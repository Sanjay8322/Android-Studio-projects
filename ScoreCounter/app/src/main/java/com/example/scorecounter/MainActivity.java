package com.example.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // TEAM A
    int teamAScore=0;
    public void three(View view){
        teamAScore+=3;
        displayForTeamA(teamAScore);
    }
    public void two(View view){
        teamAScore+=2;
        displayForTeamA(teamAScore);
    }
    public void freeThrow(View view){
        teamAScore+=1;
        displayForTeamA(teamAScore);
    }

    //TEAM B
    int teamBScore=0;
    public void threeB(View view){
        teamBScore+=3;
        displayForTeamB(teamBScore);
    }
    public void twoB(View view){
        teamBScore+=2;
        displayForTeamB(teamBScore);
    }
    public void freeThrowB(View view){
        teamBScore+=1;
        displayForTeamB(teamBScore);
    }

    public void reset(View view){
        teamAScore=0;
        teamBScore=0;
        displayForTeamA(teamAScore);
        displayForTeamB(teamBScore);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}