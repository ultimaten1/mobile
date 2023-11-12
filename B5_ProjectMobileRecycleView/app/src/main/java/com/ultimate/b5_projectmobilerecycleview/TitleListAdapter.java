package com.ultimate.b5_projectmobilerecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class TitleListAdapter extends RecyclerView.Adapter<TitleListAdapter.TitleViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<String> titleList;
    public TitleListAdapter(Context context, ArrayList<String> titleList) {
        inflater = LayoutInflater.from(context);
        this.titleList = titleList;
    }

    @NonNull
    @Override
    public TitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.custom_recycleview_item, parent, false);

        return new TitleViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull TitleViewHolder holder, int position) {
        String current = titleList.get(position);

        holder.getTitleItemView().setText(current);
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    class TitleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView titleItemView;
        private TitleListAdapter adapter;

        public TitleViewHolder(View itemView, TitleListAdapter adapter) {
            super(itemView);
            // Get the layout
            titleItemView = itemView.findViewById(R.id.txtTitle);
            // Associate with this adapter
            this.adapter = adapter;
            // Add click listener, if desired
            itemView.setOnClickListener(this);
        }

        public TextView getTitleItemView() {
            return titleItemView;
        }

        // Implement onClick() if desired
        @Override
        public void onClick(View view) {

        }
    }
}

