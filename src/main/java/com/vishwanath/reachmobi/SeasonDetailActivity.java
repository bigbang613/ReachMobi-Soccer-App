package com.vishwanath.reachmobi;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SeasonDetailActivity extends AppCompatActivity {

    String loadURL = "";
    String title = "";
    RecyclerView recyclerView;
    SeasonDetailAdapter adapter;
    ArrayList<String> homeTeam = new ArrayList<>();
    ArrayList<String> awayTeam = new ArrayList<>();
    ArrayList<String> homeScore = new ArrayList<>();
    ArrayList<String> awayScore = new ArrayList<>();
    ArrayList<String> matchDate = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.season_detail_activity);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            loadURL = bundle.getString("jsonURL");
            title = bundle.getString("seasons");
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        new SeasonRecordTask().execute(loadURL);
        recyclerView = findViewById(R.id.seasonRV);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    private class SeasonRecordTask extends AsyncTask<String, Void, JSONArray> {

        @Override
        protected JSONArray doInBackground(String... strings) {
            return JSONFetchData.readJSONArray(loadURL);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            super.onPostExecute(jsonArray);

            homeTeam = JSONFetchData.getHomeTeam();
            awayTeam = JSONFetchData.getAwayTeam();
            homeScore = JSONFetchData.getHomeScore();
            awayScore = JSONFetchData.getAwayScore();
            matchDate = JSONFetchData.getMatchDate();

            adapter = new SeasonDetailAdapter(SeasonDetailActivity.this, homeTeam, awayTeam, homeScore, awayScore, matchDate);
            recyclerView.setAdapter(adapter);

        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        homeTeam.clear();
        awayTeam.clear();
        homeScore.clear();
        awayScore.clear();
        matchDate.clear();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return false;
    }

}