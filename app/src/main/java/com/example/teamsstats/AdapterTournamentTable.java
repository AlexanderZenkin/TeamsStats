package com.example.teamsstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamsstats.model.TableList;

public class AdapterTournamentTable extends RecyclerView.Adapter <AdapterTournamentTable.MyViewHolder> {

    private TableList tableList;
    private int numberItems;

    public AdapterTournamentTable(TableList tableList, int length) {

        this.numberItems = length;
        this.tableList = tableList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.tournament_table, parent, false);
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

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView teamName;
        private TextView teamPosition;
        private TextView playedGames;

        public MyViewHolder(View itemView) {
            super(itemView);

            teamName = itemView.findViewById(R.id.team_name);
            teamPosition = itemView.findViewById(R.id.team_position);
            playedGames = itemView.findViewById(R.id.played_games);
        }

        void bind (int position) {
            String teamPositionData = tableList.tableList[position].getTeamPosition();
            String teamNameData = tableList.tableList[position].getTeamName();
            String playedGamesData = tableList.tableList[position].getPlayedGames();

            teamName.setText(teamNameData);
            teamPosition.setText(teamPositionData);
            playedGames.setText(playedGamesData);
        }
    }
}
