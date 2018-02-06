package com.vishwanath.reachmobi;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SelectedTeamActivity extends AppCompatActivity {

    private ArrayList<JSONData> data;
    private RecyclerView seasonView;
    private SeasonViewAdapter seasonAdapter;
    private Map<String, String> map;
    private String clubName, title;
    TextView homeTeam, awayTeam;
    TextView homeScore, awayScore, date;
    ImageView home, away;
    LiveScoreAsynctask task;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_team);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        homeTeam = findViewById(R.id.firstText);
        awayTeam = findViewById(R.id.secondText);
        homeScore = findViewById(R.id.homeScore);
        awayScore = findViewById(R.id.awayScore);
        date = findViewById(R.id.matchDate);
        home = findViewById(R.id.firstImage);
        away = findViewById(R.id.secondImage);

        button = findViewById(R.id.addTeam);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTeamInfo();
            }
        });
        Bundle bundle = getIntent().getExtras();
        map = new HashMap<>();

        for (int i = 0; i < Constants.latestScore.length; i++) {
            map.put(Constants.teamCode[i], Constants.latestScore[i]);
        }

        if (bundle != null) {
            try {
                clubName = bundle.getString("name");
                title = bundle.getString("club_name");
                getSupportActionBar().setTitle(title);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        liveScoreUpdate();
        initializeViews();
    }

    private void liveScoreUpdate() {
        task = new LiveScoreAsynctask();
        task.execute(map.get(clubName));
    }


    private class LiveScoreAsynctask extends AsyncTask<String, Void, JSONObject> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... strings) {
            return JSONFetchData.readJSONFeed(map.get(clubName));
        }


        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            //super.onPostExecute(jsonObject);

            try {
                homeTeam.setText(jsonObject.getString("FIELD3"));
                homeScore.setText(jsonObject.getString("FIELD5"));
                date.setText(jsonObject.getString("FIELD2"));
                awayScore.setText(jsonObject.getString("FIELD6"));
                awayTeam.setText(jsonObject.getString("FIELD4"));
                //SetLogoHomeorAway(jsonObject);

            } catch (JSONException j) {
                j.printStackTrace();
            }

        }
    }

    private void saveTeamInfo() {

        Intent intent = new Intent(SelectedTeamActivity.this, MainActivity.class);
        intent.putExtra("homeTeam", homeTeam.getText().toString());
        intent.putExtra("homeScore", homeScore.getText().toString());
        intent.putExtra("date", date.getText().toString());
        intent.putExtra("awayTeam", awayTeam.getText().toString());
        intent.putExtra("awayScore", awayScore.getText().toString());
        Constants.teamSaved = true;
        startActivityFromChild(SelectedTeamActivity.this, intent, -1);

    }

    private void SetLogoHomeorAway(JSONObject jsonObject) { // not working properly

        try {
            String homeTeam = jsonObject.getString("FIELD3");
            String awayTeam = jsonObject.getString("FIELD4");

            switch (homeTeam) {
                case "1":
                    home.setImageResource(Constants.club_icons[0]);
                case "Ath Madrid":
                    home.setImageResource(Constants.club_icons[1]);
                case "Real Madrid":
                    home.setImageResource(Constants.club_icons[2]);
                case "Man United":
                    home.setImageResource(Constants.club_icons[3]);
                case "Man City":
                    home.setImageResource(Constants.club_icons[4]);
                default:
                    home.setImageResource(R.drawable.soccerball);
            }

            switch (awayTeam) {
                case "Barcelona":
                    away.setImageResource(Constants.club_icons[0]);
                case "Ath Madrid":
                    away.setImageResource(Constants.club_icons[1]);
                case "Real Madrid":
                    away.setImageResource(Constants.club_icons[2]);
                case "Man United":
                    away.setImageResource(Constants.club_icons[3]);
                case "Man City":
                    away.setImageResource(Constants.club_icons[4]);
                default:
                    home.setImageResource(R.drawable.soccerball);
            }

        } catch (JSONException j) {
            j.printStackTrace();
        }

    }


    private void initializeViews() {
        seasonView = findViewById(R.id.seasons);
        RecyclerView.LayoutManager seasonLayoutManager = new LinearLayoutManager(this);
        seasonView.setLayoutManager(seasonLayoutManager);
        seasonView.setHasFixedSize(true);
        seasonAdapter = new SeasonViewAdapter(SelectedTeamActivity.this, Constants.seasons, new CustomItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                String jsonURL = Constants.BASE_URL + clubName + Constants.seasonCode[position] + ".json";
                Intent intent = new Intent(SelectedTeamActivity.this, SeasonDetailActivity.class);
                intent.putExtra("jsonURL", jsonURL);
                intent.putExtra("seasons", Constants.seasons[position]);
                startActivity(intent);
            }
        });
        seasonView.setAdapter(seasonAdapter);
    }


}