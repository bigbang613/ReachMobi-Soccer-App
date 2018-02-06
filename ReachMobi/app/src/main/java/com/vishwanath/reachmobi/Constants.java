package com.vishwanath.reachmobi;

import java.util.Map;

/**
 * Created by vishwanath on 2/4/18.
 */

public class Constants {

    public static final String[] clubs = {"FC Barcelona", "Atletico Madrid FC", "Real Madrid CF", "Manchester United", "Manchester City"};
    public static final String[] teamCode = {"barca", "atm", "rm", "mu", "mc"};
    public static final int[] club_icons = {R.drawable.barcelona_256, R.drawable.am_256, R.drawable.rm_256, R.drawable.mu_256, R.drawable.mc_256};
    public static final int[] country_icons = {R.drawable.brazil_256, R.drawable.germany_256, R.drawable.spain_256, R.drawable.argentina_256, R.drawable.italy_256};
    public static final int REQUEST_TEAM = 1;

    public static final String BASE_URL = "https://bigbang613.github.io/soccer_statictics_data/";
    public static final String[] seasons = {"Records in Season 2013-14", "Records in Season 2014-15", "Records in Season 2015-16",
            "Records in Season 2016-17", "Records in Season 2017-18"};
    public static final String[] teams = {"Barcelona", "Ath Madrid", "Real Madrid", "Man United", "Man City"};
    public static final String[] seasonCode = {"_1314", "_1415", "_1516", "_1617", "_1718"};

    public static final String[] latestScore = {BASE_URL + "barcelona/barca_1718.json",
            BASE_URL + "atletico_madrid/atm_1718.json",
            BASE_URL + "real_madrid/rm_1718.json",
            BASE_URL + "man_utd/mu_1718.json",
            BASE_URL + "man_city/mc_1718.json"};

    public static boolean teamSaved = false;


}
