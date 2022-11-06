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
        View view = inflater.inflate(R.layout.tournament_table_test, parent, false);
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

        private TextView teamForm;
        private TextView teamWon;
        private TextView teamDraw;

        private TextView teamLost;
        private TextView teamGoalsFor;
        private TextView teamGoalsAgainst;

        public MyViewHolder(View itemView) {
            super(itemView);


            teamPosition = itemView.findViewById(R.id.team_position);
            teamName = itemView.findViewById(R.id.team_name);
            playedGames = itemView.findViewById(R.id.played_games);

            teamForm = itemView.findViewById(R.id.form_team);
            teamWon = itemView.findViewById(R.id.won_games);
            teamDraw = itemView.findViewById(R.id.draw_games);

            teamLost = itemView.findViewById(R.id.lost_games);
            teamGoalsFor = itemView.findViewById(R.id.goalsFor_games);
            teamGoalsAgainst = itemView.findViewById(R.id.goalsAgainst_games);
        }

        void bind (int position) {
            String teamPositionData = tableList.tableList[position].getTeamPosition();
            String teamNameData = tableList.tableList[position].getTeamName();
            String playedGamesData = tableList.tableList[position].getPlayedGames();

            String teamFormData = tableList.tableList[position].getTeamForm();
            String teamWonData = tableList.tableList[position].getTeamWon();
            String teamDrawData = tableList.tableList[position].getTeamDraw();

            String teamLostData = tableList.tableList[position].getTeamLost();
            String teamGoalsForData = tableList.tableList[position].getTeamGoalsFor();
            String teamGoalsAgainstData = tableList.tableList[position].getTeamGoalsAgainst();

            teamPosition.setText(teamPositionData);
            teamName.setText(teamNameData);
            playedGames.setText(playedGamesData);

            teamForm.setText(teamFormData);
            teamWon.setText(teamWonData);
            teamDraw.setText(teamDrawData);

            teamLost.setText(teamLostData);
            teamGoalsFor.setText(teamGoalsForData);
            teamGoalsAgainst.setText(teamGoalsAgainstData);
        }
    }
}
