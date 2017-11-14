package com.example.android.footballscorekeeper;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int redTeamA = 0;
    int yellowTeamA = 0;

    int scoreTeamB = 0;
    int redTeamB = 0;
    int yellowTeamB = 0;

    String red = "Red Card";
    String yellow = "Yellow card";
    String goal = "Goal";

    //Display delaying
    int pause = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset();
    }

    /**
     * reset counters to 0
     */
    private void reset() {

        scoreTeamA = 0;
        redTeamA = 0;
        yellowTeamA = 0;
        scoreTeamB = 0;
        redTeamB = 0;
        yellowTeamB = 0;


        setRedA(redTeamA);
        setYellowA(yellowTeamA);
        setGoalA(scoreTeamA);
        setRedB(redTeamB);
        setYellowB(yellowTeamB);
        setGoalB(scoreTeamB);
        setDisplay();
    }

    /**
     * Main display Colors set
     */

    public void displayDefault(){
        LinearLayout mainDisplay = findViewById(R.id.maindisplay);
        mainDisplay.setBackgroundColor(Color.DKGRAY);
    }

    public void displayRed(){
        LinearLayout mainDisplay = findViewById(R.id.maindisplay);
        mainDisplay.setBackgroundColor(Color.RED);
        TextView scoresDisplaySecond = findViewById(R.id.display_second_string);
        scoresDisplaySecond.setText(red.toUpperCase());
    }

    public void displayYellow(){
        LinearLayout mainDisplay = findViewById(R.id.maindisplay);
        mainDisplay.setBackgroundColor(Color.YELLOW);
        TextView scoresDisplaySecond = findViewById(R.id.display_second_string);
        scoresDisplaySecond.setText(yellow.toUpperCase());
        scoresDisplaySecond.setTextColor(Color.DKGRAY);
        TextView scoresDisplayMain = findViewById(R.id.scoresdisplay);
        scoresDisplayMain.setTextColor(Color.DKGRAY);

    }

    public void displayGoal(){
        LinearLayout mainDisplay = findViewById(R.id.maindisplay);
        mainDisplay.setBackgroundColor(Color.GREEN);
        TextView scoresDisplaySecond = findViewById(R.id.display_second_string);
        scoresDisplaySecond.setText(goal.toUpperCase());
        scoresDisplaySecond.setTextColor(Color.DKGRAY);
        TextView scoresDisplayMain = findViewById(R.id.scoresdisplay);
        scoresDisplayMain.setTextColor(Color.DKGRAY);
    }

    public void displayTeamA(){
        TextView scoresDisplay = findViewById(R.id.scoresdisplay);
        scoresDisplay.setText(getResources().getText(R.string.teama));
    }

    public void displayTeamB(){
        TextView scoresDisplay = findViewById(R.id.scoresdisplay);
        scoresDisplay.setText(getResources().getText(R.string.teamb));
    }

    /**
     * Buttons click handler: Red A
     */
    public void redAClick(View view){
        setRedA(++redTeamA);
        displayRed();
        displayTeamA();
        setDisplayPause();
    }

    /**
     * Buttons click handler: Yellow A
     */
    public void yellowAClick(View view){
        setYellowA(++yellowTeamA);
        displayYellow();
        displayTeamA();
        setDisplayPause();
    }

    /**
     * Buttons click handler: Goal A
     */
    public void goalAClick(View view){
        setGoalA(++scoreTeamA);
        displayGoal();
        displayTeamA();
        setDisplayPause();
    }

    /**
     * Buttons click handler: Red B
     */
    public void redBClick(View view){
        setRedB(++redTeamB);
        displayRed();
        displayTeamB();
        setDisplayPause();
    }

    /**
     * Buttons click handler: Yellow B
     */
    public void yellowBClick(View view){
        setYellowB(++yellowTeamB);
        displayYellow();
        displayTeamB();
        setDisplayPause();
    }

    /**
     * Buttons click handler: Goal B
     */
    public void goalBClick(View view){
        setGoalB(++scoreTeamB);
        displayGoal();
        displayTeamB();
        setDisplayPause();
    }


    /**
     * set a red cards quantity for team A
     */
    public void setRedA(int score){
        Button redButtonA = findViewById(R.id.reda);
        Resources res = getResources();
        redButtonA.setText(String.format(res.getString(R.string.reda), score));
    }

    /**
     * set a yellow cards quantity for team A
     */
    public void setYellowA(int score){
        Button redButtonA = findViewById(R.id.yellowa);
        Resources res = getResources();
        redButtonA.setText(String.format(res.getString(R.string.yellowa), score));
    }

    /**
     * set a goals quantity for team A
     */
    public void setGoalA(int score){
        Button redButtonA = findViewById(R.id.goala);
        Resources res = getResources();
        redButtonA.setText(String.format(res.getString(R.string.goala), score));
    }

    /**
     * set a red cards quantity for team B
     */
    public void setRedB(int score){
        Button redButtonA = findViewById(R.id.redb);
        Resources res = getResources();
        redButtonA.setText(String.format(res.getString(R.string.redb), score));
    }

    /**
     * set a yellow cards quantity for team B
     */
    public void setYellowB(int score){
        Button redButtonA = findViewById(R.id.yellowb);
        Resources res = getResources();
        redButtonA.setText(String.format(res.getString(R.string.yellowb), score));
    }

    /**
     * set a goals quantity for team B
     */
    public void setGoalB(int score){
        Button redButtonA = findViewById(R.id.goalb);
        Resources res = getResources();
        redButtonA.setText(String.format(res.getString(R.string.goalb), score));
    }

    /**
     * set Main Scores
     */
    public void setDisplay(){
        displayDefault();
        TextView scoresDisplay = findViewById(R.id.scoresdisplay);
        Resources res = getResources();
        scoresDisplay.setText(String.format(res.getString(R.string.scores), scoreTeamA, scoreTeamB));
        scoresDisplay.setTextColor(Color.WHITE);
        TextView scoresDisplaySecond = findViewById(R.id.display_second_string);
        scoresDisplaySecond.setText(getResources().getText(R.string.scoretext));
        scoresDisplaySecond.setTextColor(Color.WHITE);
    }

    private void setDisplayPause(){

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setDisplay();
            }
        }, pause);
    }

    /**
     * Reset button
     */
    public void resetButton(View view){
        reset();
    }
}
