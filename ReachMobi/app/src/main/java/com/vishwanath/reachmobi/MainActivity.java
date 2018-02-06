package com.vishwanath.reachmobi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private CardView card1, card2;
    TextView t1, t2, ch1, ch2, ca1, ca2, cd1, cd2, gh1, gh2, ga1, ga2;
    public static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!Constants.teamSaved) {
            setContentView(R.layout.activity_main);
            Button button = findViewById(R.id.add_team);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, SelectTeamActivity.class);
                    startActivity(i);
                }
            });

            Toast.makeText(this, "Aint it funny", Toast.LENGTH_LONG).show();

        } else {
            setContentView(R.layout.saved_score);
            Bundle bundle = getIntent().getExtras();
            ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.conlayout);
            View view = getLayoutInflater().inflate(R.layout.live_score_view, layout, false);

            layout.addView(view);
            //addLayouts(layout, view);

            ch1 = findViewById(R.id.firstText);
            cd1 = findViewById(R.id.matchDate);
            ca1 = findViewById(R.id.secondText);
            gh1 = findViewById(R.id.homeScore);
            ga1 = findViewById(R.id.awayScore);

            if (bundle != null) {
                ch1.setText(bundle.getString("homeTeam"));
                cd1.setText(bundle.getString("date"));
                gh1.setText(bundle.getString("homeScore"));
                ca1.setText(bundle.getString("awayTeam"));
                ga1.setText(bundle.getString("awayScore"));
            }

            Button button = findViewById(R.id.add_team_2);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, SelectTeamActivity.class);
                    startActivity(i);
                }
            });

        }
    }


    public void addLayouts(ConstraintLayout layout, View view) {
        for (int i = 0; i < 2; i++) {
//addLayouts(layout, view);
        }
    }


}
