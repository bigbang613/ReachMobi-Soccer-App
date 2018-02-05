package com.vishwanath.reachmobi;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by vishwanath on 2/4/18.
 */

public class JSONFetchData {

    private static ArrayList<String> homeTeam = new ArrayList<>();
    private static ArrayList<String> awayTeam = new ArrayList<>();
    private static ArrayList<String> homeScore = new ArrayList<>();
    private static ArrayList<String> awayScore = new ArrayList<>();
    private static ArrayList<String> matchDate = new ArrayList<>();

    public static JSONObject readJSONFeed(String str) {
        String responseString = "";
        JSONObject jsonObject = null;
        try {
            URL url = new URL(str);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            responseString = readStream(urlConnection.getInputStream());
            JSONArray array = new JSONArray(responseString);
            jsonObject = array.getJSONObject(array.length() - 1);

        } catch (JSONException je) {
            je.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JSONArray readJSONArray(String str) {
        String responseString = "";
        JSONArray array = null;
        try {
            URL url = new URL(str);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            responseString = readStream(urlConnection.getInputStream());
            array = new JSONArray(responseString);
            fetchAllJSONdata(array);
        } catch (JSONException je) {
            je.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }


    public static String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuilder response = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }

    public static void fetchAllJSONdata(JSONArray array) {
        JSONObject object;
        for (int i = 1; i < array.length(); i++) {
            try {
                object = array.getJSONObject(i);
                homeTeam.add(object.getString("FIELD3"));
                homeScore.add(object.getString("FIELD5"));
                matchDate.add(object.getString("FIELD2"));
                awayScore.add(object.getString("FIELD6"));
                awayTeam.add(object.getString("FIELD4"));
            } catch (JSONException j) {
                j.printStackTrace();
            }
        }
    }


    public static ArrayList<String> getHomeTeam() {
        return homeTeam;
    }

    public static ArrayList<String> getAwayTeam() {
        return awayTeam;
    }

    public static ArrayList<String> getHomeScore() {
        return homeScore;
    }

    public static ArrayList<String> getAwayScore() {
        return awayScore;
    }

    public static ArrayList<String> getMatchDate() {
        return matchDate;
    }

}
