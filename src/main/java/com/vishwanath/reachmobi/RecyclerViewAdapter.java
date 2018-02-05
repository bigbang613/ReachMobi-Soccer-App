package com.vishwanath.reachmobi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private String[] strings;
    private int[] images;
    CustomItemClickListener listener;

    public RecyclerViewAdapter(Context context, String[] strings, int[] images, CustomItemClickListener listener) {
        this.mContext = context;
        this.strings = strings;
        this.images = images;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);

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
        viewHolder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(final View view) {
            super(view);
            textView = view.findViewById(R.id.text);
            imageView = view.findViewById(R.id.club_logo);
        }
    }
}