package com.vishwanath.reachmobi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SeasonViewAdapter extends RecyclerView.Adapter<SeasonViewAdapter.ViewHolder> {
    private Context mContext;
    private String[] strings;
    CustomItemClickListener listener;

    public SeasonViewAdapter(Context context, String[] strings, CustomItemClickListener listener) {
        this.mContext = context;
        this.strings = strings;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_item_recycler_view, parent, false);

        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                listener.onClick(v, viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.textView.setText(strings[position]);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(final View view) {
            super(view);
            textView = view.findViewById(R.id.text);
        }
    }
}