package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public List<level> list = new ArrayList<level>();
    public int actualLvl = 0;

    public Controller(){
        list.add(level.level1());
        list.add(level.level2());
        list.add(level.level3());


    }

    void addLevelToList(String name,String highHat,String snare,String kick,String crashBecken,int bpm){
        list.add(new level(name,highHat, snare,kick,crashBecken, bpm));
    }


}
