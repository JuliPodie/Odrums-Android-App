package com.example.myapplication.ui.slideshow;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    static char[] thighHat = {'0', '0', '0', '0'};         //
    static char[] tsnare = {'0', '0', '0', '0'};         //
    static char[] tkick = {'0', '0', '0', '0'};            //innerer Kreis Grau
    static char[] tcrashBecken = {'0', '0', '0', '0'}; // outer

    static ImageView[] crash;
    static ImageView[] snare;
    static ImageView[] highHat;
    static ImageView[] kick;

    public static String getLevelName(View view) {
        return ((EditText) v.findViewById(R.id.editTextTextPersonName2)).getText().toString();
    }

    public static String getthighHat() {
        String tmp = "" + thighHat[0] + thighHat[1] + thighHat[2] + thighHat[3];
        return tmp;
    }

    public static String gettsnare() {
        String tmp = "" + tsnare[0] + tsnare[1] + tsnare[2] + tsnare[3];
        return tmp;
    }

    public static String gettkick() {
        String tmp = "" + tkick[0] + tkick[1] + tkick[2] + tkick[3];
        return tmp;
    }

    public static String gettcrashBecken() {
        String tmp = "" + tcrashBecken[0] + tcrashBecken[1] + tcrashBecken[2] + tcrashBecken[3];
        return tmp;
    }

static View v;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        v = inflater.inflate(R.layout.fragment_levelbuilder, container, false);

        ImageView[] crash1 = {
                v.findViewById(R.id.crashOne),
                v.findViewById(R.id.crashOne2),
                v.findViewById(R.id.crashOne3),
                v.findViewById(R.id.crashOne4)};

        ImageView[] snare1 = {
                v.findViewById(R.id.snare),
                v.findViewById(R.id.snare2),
                v.findViewById(R.id.snare3),
                v.findViewById(R.id.snare4)};

        ImageView[] highHat1 = {
                v.findViewById(R.id.highHat),
                v.findViewById(R.id.highHat2),
                v.findViewById(R.id.highHat3),
                v.findViewById(R.id.highHat4)};

        ImageView[] kick1 = {
                v.findViewById(R.id.kick),
                v.findViewById(R.id.kick2),
                v.findViewById(R.id.kick3),
                v.findViewById(R.id.kick4)};

        crash = crash1;
        kick = kick1;
        highHat = highHat1;
        snare = snare1;

        return v;
    }

    public static void placeDot(View view) {

        switch (view.getId()) {
            case R.id.crashOne:
                if (tcrashBecken[0] == '0') {
                    crash[0].setColorFilter(Color.BLUE);
                    tcrashBecken[0] = '1';
                } else {
                    tcrashBecken[0] = '0';
                    crash[0].clearColorFilter();
                }
                break;
            case R.id.crashOne2:
                if (tcrashBecken[1] == '0') {
                    crash[1].setColorFilter(Color.BLUE);
                    tcrashBecken[1] = '1';
                } else {
                    tcrashBecken[1] = '0';
                    crash[1].clearColorFilter();
                }
                break;
            case R.id.crashOne3:
                if (tcrashBecken[2] == '0') {
                    crash[2].setColorFilter(Color.BLUE);
                    tcrashBecken[2] = '1';
                } else {
                    tcrashBecken[2] = '0';
                    crash[2].clearColorFilter();
                }
                break;
            case R.id.crashOne4:
                if (tcrashBecken[3] == '0') {
                    crash[3].setColorFilter(Color.BLUE);
                    tcrashBecken[3] = '1';
                } else {
                    tcrashBecken[3] = '0';
                    crash[3].clearColorFilter();
                }
                break;

            case R.id.highHat:
                if (thighHat[0] == '0') {
                    highHat[0].setColorFilter(Color.BLUE);
                    thighHat[0] = '1';
                } else {
                    thighHat[0] = '0';
                    highHat[0].clearColorFilter();
                }
                break;
            case R.id.highHat2:
                if (thighHat[1] == '0') {
                    highHat[1].setColorFilter(Color.BLUE);
                    thighHat[1] = '1';
                } else {
                    thighHat[1] = '0';
                    highHat[1].clearColorFilter();
                }
                break;
            case R.id.highHat3:
                if (thighHat[2] == '0') {
                    highHat[2].setColorFilter(Color.BLUE);
                    thighHat[2] = '1';
                } else {
                    thighHat[2] = '0';
                    highHat[2].clearColorFilter();
                }
                break;
            case R.id.highHat4:
                if (thighHat[3] == '0') {
                    highHat[3].setColorFilter(Color.BLUE);
                    thighHat[3] = '1';
                } else {
                    thighHat[3] = '0';
                    highHat[3].clearColorFilter();
                }
                break;

            case R.id.kick:
                if (tkick[0] == '0') {
                    kick[0].setColorFilter(Color.BLUE);
                    tkick[0] = '1';
                } else {
                    tkick[0] = '0';
                    kick[0].clearColorFilter();
                }
                break;
            case R.id.kick2:
                if (tkick[1] == '0') {
                    kick[1].setColorFilter(Color.BLUE);
                    tkick[1] = '1';
                } else {
                    tkick[1] = '0';
                    kick[1].clearColorFilter();
                }
                break;
            case R.id.kick3:
                if (tkick[2] == '0') {
                    kick[2].setColorFilter(Color.BLUE);
                    tkick[2] = '1';
                } else {
                    tkick[2] = '0';
                    kick[2].clearColorFilter();
                }
                break;
            case R.id.kick4:
                if (tkick[3] == '0') {
                    kick[3].setColorFilter(Color.BLUE);
                    tkick[3] = '1';
                } else {
                    tkick[3] = '0';
                    kick[3].clearColorFilter();
                }
                break;

            case R.id.snare:
                if (tsnare[0] == '0') {
                    snare[0].setColorFilter(Color.BLUE);
                    tsnare[0] = '1';
                } else {
                    tsnare[0] = '0';
                    snare[0].clearColorFilter();
                }
                break;
            case R.id.snare2:
                if (tsnare[1] == '0') {
                    snare[1].setColorFilter(Color.BLUE);
                    tsnare[1] = '1';
                } else {
                    tsnare[1] = '0';
                    snare[1].clearColorFilter();
                }

                break;
            case R.id.snare3:
                if (tsnare[2] == '0') {
                    snare[2].setColorFilter(Color.BLUE);
                    tsnare[2] = '1';
                } else {
                    tsnare[2] = '0';
                    snare[2].clearColorFilter();
                }
                break;
            case R.id.snare4:
                if (tsnare[3] == '0') {
                    snare[3].setColorFilter(Color.BLUE);
                    tsnare[3] = '1';
                } else {
                    tsnare[3] = '0';
                    snare[3].clearColorFilter();
                }
                break;
        }
    }
}