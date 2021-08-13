package com.example.myapplication;

public class level {
    String levelName;
    String highHat;         //
    String snare;           //
    String kick;            //innerer Kreis Grau
    String crashBecken;     //ganz außen orange
    int bpm;
    //String takt;

    level(String name,String highHat,String snare,String kick,String crashBecken, int bpm){
        this.levelName=name;
        this.snare = snare;
        this.highHat = highHat;
        this.crashBecken= crashBecken;
        this.kick = kick;
        this.bpm = bpm;
    }


    static level level1 (){
        level temp = new level("Level 1","1111","0010"
                ,"1000","0000", 60);
        return temp;
    }

    static level level2 (){
        level temp = new level("Level 2","1111","0101"
                ,"1010","1000", 120);
        return temp;
    }

    static level level3 (){
        level temp = new level("Level 3","1010","0101"
                ,"1010","1001", 140);
        return temp;
    }


    public String getCrashBecken() {
        return crashBecken;
    }

    public String getHighHat() {
        return highHat;
    }

    public String getKick() {
        return kick;
    }

    public String getLevelName() {
        return levelName;
    }

    public String getSnare() {
        return snare;
    }

    public int getBpm() { return bpm; }
}
