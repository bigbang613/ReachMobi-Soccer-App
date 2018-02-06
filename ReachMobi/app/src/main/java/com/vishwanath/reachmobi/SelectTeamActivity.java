package com.vishwanath.reachmobi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectTeamActivity extends AppCompatActivity {

    private RecyclerView firstRecyclerView;
    private RecyclerViewAdapter firstAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_team);

        firstRecyclerView = findViewById(R.id.recycler);
        RecyclerView.LayoutManager firstLayoutManager = new LinearLayoutManager(this);
        firstRecyclerView.setLayoutManager(firstLayoutManager);
        firstAdapter = new RecyclerViewAdapter(this, Constants.clubs, Constants.club_icons, new CustomItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent i = new Intent(SelectTeamActivity.this, SelectedTeamActivity.class);
                i.putExtra("name", Constants.teamCode[position]);
                i.putExtra("club_name", Constants.clubs[position]);
                i.putExtra("icon", Constants.club_icons[position]);
                startActivity(i);
            }
        });

        firstRecyclerView.setAdapter(firstAdapter);
    }


}




