package com.example.android.footballscorekeeper;

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

    LinearLayout mainDisplay;
    TextView scoresDisplay;
    TextView scoresDisplaySecond;
    Button redButtonA;
    Button yellowButtonA;
    Button goalButtonA;
    Button redButtonB;
    Button yellowButtonB;
    Button goalButtonB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainDisplay = findViewById(R.id.maindisplay); //Main display LinearLayout
        scoresDisplay = findViewById(R.id.scoresdisplay);
        scoresDisplaySecond = findViewById(R.id.display_second_string);
        redButtonA = findViewById(R.id.reda);
        yellowButtonA = findViewById(R.id.yellowa);
        goalButtonA = findViewById(R.id.goala);
        redButtonB = findViewById(R.id.redb);
        yellowButtonB = findViewById(R.id.yellowb);
        goalButtonB = findViewById(R.id.goalb);

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

    private void displayTextGray() {
        scoresDisplaySecond.setTextColor(Color.DKGRAY);
        scoresDisplay.setTextColor(Color.DKGRAY);
    }

    public void displayDefault(){
        mainDisplay.setBackgroundColor(Color.DKGRAY);
    }

    public void displayRed(){
        mainDisplay.setBackgroundColor(Color.RED);
        scoresDisplaySecond.setText(red.toUpperCase());
    }

    public void displayYellow(){
        mainDisplay.setBackgroundColor(Color.YELLOW);
        scoresDisplaySecond.setText(yellow.toUpperCase());
        displayTextGray();
    }

    public void displayGoal(){
        mainDisplay.setBackgroundColor(Color.GREEN);
        scoresDisplaySecond.setText(goal.toUpperCase());
        displayTextGray();
    }

    public void displayTeamA(){
        scoresDisplay.setText(getResources().getText(R.string.teama));
    }

    public void displayTeamB(){
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
        redButtonA.setText(String.format(getResources().getString(R.string.reda), score));
    }

    /**
     * set a yellow cards quantity for team A
     */
    public void setYellowA(int score){
        yellowButtonA.setText(String.format(getResources().getString(R.string.yellowa), score));
    }

    /**
     * set a goals quantity for team A
     */
    public void setGoalA(int score){
        goalButtonA.setText(String.format(getResources().getString(R.string.goala), score));
    }

    /**
     * set a red cards quantity for team B
     */
    public void setRedB(int score){
        redButtonB.setText(String.format(getResources().getString(R.string.redb), score));
    }

    /**
     * set a yellow cards quantity for team B
     */
    public void setYellowB(int score){
        yellowButtonB.setText(String.format(getResources().getString(R.string.yellowb), score));
    }

    /**
     * set a goals quantity for team B
     */
    public void setGoalB(int score){
        goalButtonB.setText(String.format(getResources().getString(R.string.goalb), score));
    }

    /**
     * set Main Scores
     */
    public void setDisplay(){
        displayDefault();
        scoresDisplay.setText(String.format(getResources().getString(R.string.scores), scoreTeamA, scoreTeamB));
        scoresDisplay.setTextColor(Color.WHITE);
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
