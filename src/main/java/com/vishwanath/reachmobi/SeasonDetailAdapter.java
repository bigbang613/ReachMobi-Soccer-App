package com.vishwanath.reachmobi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SeasonDetailAdapter extends RecyclerView.Adapter<SeasonDetailAdapter.ViewHolder> {
    private Context mContext;
    ArrayList<String> homeTeam = new ArrayList<>();
    ArrayList<String> awayTeam = new ArrayList<>();
    ArrayList<String> homeScore = new ArrayList<>();
    ArrayList<String> awayScore = new ArrayList<>();
    ArrayList<String> matchDate = new ArrayList<>();

    public SeasonDetailAdapter(Context context, ArrayList<String> homeTeam, ArrayList<String> awayTeam, ArrayList<String> homeScore, ArrayList<String> awayScore, ArrayList<String> matchDate) {
        this.mContext = context;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.matchDate = matchDate;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.live_score_view, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.homeTeam.setText(homeTeam.get(position));
        viewHolder.awayTeam.setText(awayTeam.get(position));
        viewHolder.homeScore.setText(homeScore.get(position));
        viewHolder.awayScore.setText(awayScore.get(position));
        viewHolder.matchDate.setText(matchDate.get(position));
    }

    @Override
    public int getItemCount() {
        return homeTeam.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView homeTeam;
        private TextView awayTeam;
        private TextView homeScore;
        private TextView awayScore;
        private TextView matchDate;

        public ViewHolder(final View view) {
            super(view);
            homeTeam = view.findViewById(R.id.firstText);
            awayTeam = view.findViewById(R.id.secondText);
            homeScore = view.findViewById(R.id.homeScore);
            awayScore = view.findViewById(R.id.awayScore);
            matchDate = view.findViewById(R.id.matchDate);
        }
    }
}