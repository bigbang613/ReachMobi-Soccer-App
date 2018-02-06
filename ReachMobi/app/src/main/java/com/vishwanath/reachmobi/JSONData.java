package com.vishwanath.reachmobi;

/**
 * Created by vishwanath on 2/4/18.
 */

public class JSONData {


    private String homeTeam;
    private String awayTeam;
    private int homeGoals;
    private int awayGoals;
    private String date;


    public JSONData(String hT, String aT, int hG, int aG, String date) {
        this.homeTeam = hT;
        this.awayTeam = aT;
        this.homeGoals = hG;
        this.awayGoals = aG;
    }


    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
