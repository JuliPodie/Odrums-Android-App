package com.example.myapplication.ui.level;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.level;

import java.util.Random;


public class LevelFragment extends Fragment {


    ImageView[] crash;
    ImageView[] snare;
    ImageView[] highHat;
    ImageView[] kick;

    ImageView zeiger;
    Button btn;

    boolean continueWork = false;

    private levelViewModel levelViewModel;
    View v;
    int seconds = 0;

    @Override
    public void onStop() {
        super.onStop();
        continueWork = false;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                         ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_level,container,false);
        btn = v.findViewById(R.id.button3);
        TextView lvl = v.findViewById(R.id.levelname);
        lvl.setText(MainActivity.c.list.get(MainActivity.c.actualLvl).getLevelName() + "\n BPM: " + MainActivity.c.list.get(MainActivity.c.actualLvl).getBpm());
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(continueWork){
                    continueWork = false;
                } else {
                    startRotate(MainActivity.c.list.get(MainActivity.c.actualLvl),zeiger);
                    continueWork = true;
                }
            }
        });


        zeiger = v.findViewById((R.id.zeiger));

        ImageView [] crash = {
                v.findViewById(R.id.crashOne),
                v.findViewById(R.id.crashOne2),
                v.findViewById(R.id.crashOne3),
                v.findViewById(R.id.crashOne4) };

        ImageView [] snare = {
                v.findViewById(R.id.snare),
                v.findViewById(R.id.snare2),
                v.findViewById(R.id.snare3),
                v.findViewById(R.id.snare4) };

        ImageView [] highHat = {
                v.findViewById(R.id.highHat),
                v.findViewById(R.id.highHat2),
                v.findViewById(R.id.highHat3),
                v.findViewById(R.id.highHat4) };

        ImageView [] kick = {
                v.findViewById(R.id.kick),
                v.findViewById(R.id.kick2),
                v.findViewById(R.id.kick3),
                v.findViewById(R.id.kick4) };

        this.crash = crash;
        this.kick = kick;
        this.highHat = highHat;
        this.snare = snare;

        setPoints(MainActivity.c.list.get(MainActivity.c.actualLvl),v);
        //startRotate(MainActivity.c.list.get(MainActivity.c.actualLvl),zeiger);

        return v;
    }

    void startRotate (level l, ImageView zeiger){

        double beatsMS = 60000.0/l.getBpm();
        double turn = 360.0/4;
        double stepsize = 20;
        double rot = turn/stepsize;
Handler turnArrow = new Handler();

        turnArrow.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                zeiger.setRotation((float) (zeiger.getRotation() +  rot));

                if(zeiger.getRotation() == 360){
                    zeiger.setRotation(0);
                }

                if(continueWork) {
                    turnArrow.postDelayed(this, (long) (beatsMS / stepsize));
                }
            }
        },  (long) (beatsMS / stepsize));
    }

    void setPoints(level l, View v){

        for(int i = 0; i < l.getKick().length();i++){
            if(l.getKick().charAt(i) == '1'){
                kick[i].setVisibility(View.VISIBLE);
            }
            if(l.getCrashBecken().charAt(i) == '1'){
                crash[i].setVisibility(View.VISIBLE);
            }
            if(l.getHighHat().charAt(i) == '1'){
                highHat[i].setVisibility(View.VISIBLE);
            }
            if(l.getSnare().charAt(i) == '1'){
                snare[i].setVisibility(View.VISIBLE);
            }
        }

    }


}
        /*turnArrow.postDelayed(new Runnable()
        {
            int count = 0;
            @Override
            public void run()
            {
                //zeiger.setBackgroundColor(Color.BLACK);

                if (count == 0){
                    //zeiger.setBackgroundColor(Color.RED);
                    MainActivity.mp.start();
                    System.out.println(new Random());
                }
                count += 1;
                if(count == stepsize){
                    count = 0;
                }

                //System.out.println("tick");

                zeiger.setRotation((float) (zeiger.getRotation() +  rot));
                //System.out.println("moved");
                if(continueWork) {
                    turnArrow.postDelayed(this, (long) (beatsMS / stepsize));
                }
            }
        },  (long) (beatsMS / stepsize));*/