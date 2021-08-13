package com.example.myapplication;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.ui.slideshow.SlideshowFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public static MediaPlayer mp;
    Context context;
    public static Controller c;
    private final static String SHARED_PREFERENCES_FILE_USER_INFO_LIST = "levellist";
    private final static String SHARED_PREFERENCES_KEY_USER_INFO_LIST = "level_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_settings)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        c = new Controller();
        context = this;

        mp = MediaPlayer.create(this, R.raw.metro);
        mp.setLooping(false);

        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_USER_INFO_LIST, MODE_PRIVATE);
        String levelJsonString = sharedPreferences.getString(SHARED_PREFERENCES_KEY_USER_INFO_LIST, "");
        Gson gson = new Gson();

        level levelPref[] = gson.fromJson(levelJsonString, level[].class);

        if(levelPref == null)
           return;


        for (int i = 3; i < levelPref.length;i++){
            c.list.add(levelPref[i]);
        }

        for(int i = 0;i<  c.list.size();i++){
            System.out.println(c.list.get(i).getLevelName());
        }

    }

    public void v7(View v) {
        Navigation.findNavController(v).navigate(R.id.action_nav_home_to_nav_level2);
        switch (v.getId()) {
            case R.id.level1circle:
                c.actualLvl = 0;
                break;

            case R.id.level2circle:
                c.actualLvl = 1;
                break;
            case R.id.level3circle:
                c.actualLvl = 2;
                break;
        }
    }

    public void place(View v) {
        SlideshowFragment.placeDot(v);
    }

    int translation = 50;

    LinearLayout linearLayout;

    public void search(View v) {
        translation = 50;
        linearLayout = findViewById(R.id.searched);
        linearLayout.removeAllViews();
        int[] id = new int[c.list.size()];

        for (int i = 0; i < c.list.size(); i++) {
            final int textviewid = i;
            if (c.list.get(i).getLevelName().contains(((EditText) findViewById(R.id.levelNameSearch)).getText().toString())) {
                TextView textView = new TextView(this);
                textView.setText(c.list.get(i).getLevelName());
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                textView.setTextSize(25);
                textView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        c.actualLvl = textviewid;
                        System.out.println(textviewid);
                        Navigation.findNavController(v).navigate(R.id.action_nav_gallery_to_nav_level);
                    }
                });
                textView.setTypeface(null, Typeface.BOLD);
                textView.setTranslationY(translation);
                linearLayout.addView(textView);
                translation = translation + 50;
            }

        }
    }

    public void delete(View v){
        SharedPreferences sp = context.getSharedPreferences(SHARED_PREFERENCES_FILE_USER_INFO_LIST, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();

        for(int i = 3; i < c.list.size();i++){
            c.list.remove(i);
        }
    }

    public void safeLevel(View v) {
        Gson gson = new Gson();
        c.addLevelToList(SlideshowFragment.getLevelName(v), SlideshowFragment.getthighHat(), SlideshowFragment.gettsnare(), SlideshowFragment.gettkick(), SlideshowFragment.gettcrashBecken(), 100);
        SharedPreferences sp = context.getSharedPreferences(SHARED_PREFERENCES_FILE_USER_INFO_LIST, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(SHARED_PREFERENCES_KEY_USER_INFO_LIST, gson.toJson(c.list));
        editor.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}