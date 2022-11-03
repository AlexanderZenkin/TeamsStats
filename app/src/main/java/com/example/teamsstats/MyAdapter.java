package com.example.teamsstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamsstats.interfaces.ListItemClickListener;
import com.example.teamsstats.model.ListMatches;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder> {

    final private ListItemClickListener mOnClickListener;

    private ListMatches listMatches;
    private int numberItems;

    public MyAdapter(ListMatches listMatches, int length, ListItemClickListener listItemClickListener) {

        this.mOnClickListener = listItemClickListener;
        this.numberItems = length;
        this.listMatches = listMatches;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.matches_list_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView homeTeam;
        private TextView awayTeam;
        private TextView result;

        public MyViewHolder(View itemView) {
            super(itemView);

            homeTeam = itemView.findViewById(R.id.matchHomeTeam);
            awayTeam = itemView.findViewById(R.id.matchAwayTeam);
            result = itemView.findViewById(R.id.matchResult);
            result.setOnClickListener(this);
        }

        void bind (int position) {
            String homeTeamData = listMatches.listMatches[position].getHomeTeam();
            String awayTeamData = listMatches.listMatches[position].getAwayTeam();
            String resultData = listMatches.listMatches[position].getResult();

            homeTeam.setText(homeTeamData);
            awayTeam.setText(awayTeamData);
            result.setText(resultData);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            mOnClickListener.onListItemClick(position);
        }
    }
}
