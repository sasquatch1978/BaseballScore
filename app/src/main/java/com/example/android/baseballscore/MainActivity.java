package com.example.android.baseballscore;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Inning Number //
    int inningNumber = 1;
    static String INNING_NUMBER = "inning_number";

    // Home Team //
    int scoreHomeTeam = 0;
    int strikeHomeTeam = 0;
    int foulHomeTeam = 0;
    int ballHomeTeam = 0;
    int outHomeTeam = 0;

    static String SCORE_HOME = "score_home";
    static String STRIKE_HOME = "strike_home";
    static String FOUL_HOME = "foul_home";
    static String BALL_HOME = "ball_home";
    static String OUT_HOME = "out_home";

    // Away Team //
    int scoreAwayTeam = 0;
    int strikeAwayTeam = 0;
    int foulAwayTeam = 0;
    int ballAwayTeam = 0;
    int outAwayTeam = 0;

    static String SCORE_AWAY = "score_away";
    static String STRIKE_AWAY = "strike_away";
    static String FOUL_AWAY = "foul_away";
    static String BALL_AWAY = "ball_away";
    static String OUT_AWAY = "out_away";

    // Reset Button //
    final Context context = this;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = (Button) findViewById(R.id.button2);

        // Add button listener. //
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Custom dialog. //
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.reset_popup);

                Button statsReset = (Button) dialog.findViewById(R.id.stats_reset);
                // If button is clicked, clear the stats. //
                statsReset.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        strikeHomeTeam = 0;
                        foulHomeTeam = 0;
                        ballHomeTeam = 0;
                        strikeAwayTeam = 0;
                        foulAwayTeam = 0;
                        ballAwayTeam = 0;
                        displayHomeTeamStrike(strikeHomeTeam);
                        displayHomeTeamFoul(foulHomeTeam);
                        displayHomeTeamBall(ballHomeTeam);
                        displayAwayTeamStrike(strikeAwayTeam);
                        displayAwayTeamFoul(foulAwayTeam);
                        displayAwayTeamBall(ballAwayTeam);
                        dialog.dismiss();
                    }
                });

                Button outsReset = (Button) dialog.findViewById(R.id.outs_reset);
                // If button is clicked, clear the stats and outs. //
                outsReset.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        strikeHomeTeam = 0;
                        foulHomeTeam = 0;
                        ballHomeTeam = 0;
                        strikeAwayTeam = 0;
                        foulAwayTeam = 0;
                        ballAwayTeam = 0;
                        outHomeTeam = 0;
                        outAwayTeam = 0;
                        displayHomeTeamStrike(strikeHomeTeam);
                        displayHomeTeamFoul(foulHomeTeam);
                        displayHomeTeamBall(ballHomeTeam);
                        displayAwayTeamStrike(strikeAwayTeam);
                        displayAwayTeamFoul(foulAwayTeam);
                        displayAwayTeamBall(ballAwayTeam);
                        displayHomeTeamOut(outHomeTeam);
                        displayAwayTeamOut(outAwayTeam);
                        dialog.dismiss();
                    }
                });

                Button allReset = (Button) dialog.findViewById(R.id.all_reset);
                // If button is clicked, clear the outs and stats. //
                allReset.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        strikeHomeTeam = 0;
                        foulHomeTeam = 0;
                        ballHomeTeam = 0;
                        strikeAwayTeam = 0;
                        foulAwayTeam = 0;
                        ballAwayTeam = 0;
                        outHomeTeam = 0;
                        outAwayTeam = 0;
                        inningNumber = 1;
                        scoreHomeTeam = 0;
                        scoreAwayTeam = 0;
                        displayHomeTeamStrike(strikeHomeTeam);
                        displayHomeTeamFoul(foulHomeTeam);
                        displayHomeTeamBall(ballHomeTeam);
                        displayAwayTeamStrike(strikeAwayTeam);
                        displayAwayTeamFoul(foulAwayTeam);
                        displayAwayTeamBall(ballAwayTeam);
                        displayHomeTeamOut(outHomeTeam);
                        displayAwayTeamOut(outAwayTeam);
                        displayInningNumber(inningNumber);
                        displayHomeTeamScore(scoreHomeTeam);
                        displayAwayTeamScore(scoreAwayTeam);
                        dialog.dismiss();
                    }
                });

                Button cancelReset = (Button) dialog.findViewById(R.id.cancel_reset);
                // If button is clicked, close the reset popup. //
                cancelReset.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle. //
        savedInstanceState.putInt(INNING_NUMBER, inningNumber);
        // Home Team. //
        savedInstanceState.putInt(SCORE_HOME, scoreHomeTeam);
        savedInstanceState.putInt(STRIKE_HOME, strikeHomeTeam);
        savedInstanceState.putInt(FOUL_HOME, foulHomeTeam);
        savedInstanceState.putInt(BALL_HOME, ballHomeTeam);
        savedInstanceState.putInt(OUT_HOME, outHomeTeam);
        // Away Team. //
        savedInstanceState.putInt(SCORE_AWAY, scoreAwayTeam);
        savedInstanceState.putInt(STRIKE_AWAY, strikeAwayTeam);
        savedInstanceState.putInt(FOUL_AWAY, foulAwayTeam);
        savedInstanceState.putInt(BALL_AWAY, ballAwayTeam);
        savedInstanceState.putInt(OUT_AWAY, outAwayTeam);
        // Always call the superclass so it can save the view hierarchy state. //
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy. //
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance. //
        inningNumber = savedInstanceState.getInt(INNING_NUMBER);
        // Home Team //
        scoreHomeTeam = savedInstanceState.getInt(SCORE_HOME);
        strikeHomeTeam = savedInstanceState.getInt(STRIKE_HOME);
        foulHomeTeam = savedInstanceState.getInt(FOUL_HOME);
        ballHomeTeam = savedInstanceState.getInt(BALL_HOME);
        outHomeTeam = savedInstanceState.getInt(OUT_HOME);
        // Away Team //
        scoreAwayTeam = savedInstanceState.getInt(SCORE_AWAY);
        strikeAwayTeam = savedInstanceState.getInt(STRIKE_AWAY);
        foulAwayTeam = savedInstanceState.getInt(FOUL_AWAY);
        ballAwayTeam = savedInstanceState.getInt(BALL_AWAY);
        outAwayTeam = savedInstanceState.getInt(OUT_AWAY);
        // Display the saved values. //
        displayHomeTeamStrike(strikeHomeTeam);
        displayHomeTeamFoul(foulHomeTeam);
        displayHomeTeamBall(ballHomeTeam);
        displayAwayTeamStrike(strikeAwayTeam);
        displayAwayTeamFoul(foulAwayTeam);
        displayAwayTeamBall(ballAwayTeam);
        displayHomeTeamOut(outHomeTeam);
        displayAwayTeamOut(outAwayTeam);
        displayInningNumber(inningNumber);
        displayHomeTeamScore(scoreHomeTeam);
        displayAwayTeamScore(scoreAwayTeam);
    }

    /**
     * This method is called when the Inning button is clicked.
     */
    public void changeInning(View view) {
        inningNumber = inningNumber + 1;
        displayInningNumber(inningNumber);
    }

    /**
     * This method is called when the Home Team Run button is clicked.
     */
    public void runHomeTeam(View view) {
        scoreHomeTeam = scoreHomeTeam + 1;
        displayHomeTeamScore(scoreHomeTeam);
    }

    /**
     * This method is called when the Home Team Strike button is clicked.
     */
    public void strikeHomeTeam(View view) {
        strikeHomeTeam = strikeHomeTeam + 1;
        displayHomeTeamStrike(strikeHomeTeam);
    }

    /**
     * This method is called when the Home Team Foul button is clicked.
     */
    public void foulHomeTeam(View view) {
        foulHomeTeam = foulHomeTeam + 1;
        displayHomeTeamFoul(foulHomeTeam);
    }

    /**
     * This method is called when the Home Team Ball button is clicked.
     */
    public void ballHomeTeam(View view) {
        ballHomeTeam = ballHomeTeam + 1;
        displayHomeTeamBall(ballHomeTeam);
    }

    /**
     * This method is called when the Home Team Out button is clicked.
     */
    public void outHomeTeam(View view) {
        outHomeTeam = outHomeTeam + 1;
        displayHomeTeamOut(outHomeTeam);
    }

    /**
     * This method is called when the Away Team Run button is clicked.
     */
    public void runAwayTeam(View view) {
        scoreAwayTeam = scoreAwayTeam + 1;
        displayAwayTeamScore(scoreAwayTeam);
    }

    /**
     * This method is called when the Away Team Strike button is clicked.
     */
    public void strikeAwayTeam(View view) {
        strikeAwayTeam = strikeAwayTeam + 1;
        displayAwayTeamStrike(strikeAwayTeam);
    }

    /**
     * This method is called when the Away Team Foul button is clicked.
     */
    public void foulAwayTeam(View view) {
        foulAwayTeam = foulAwayTeam + 1;
        displayAwayTeamFoul(foulAwayTeam);
    }

    /**
     * This method is called when the Away Team Ball button is clicked.
     */
    public void ballAwayTeam(View view) {
        ballAwayTeam = ballAwayTeam + 1;
        displayAwayTeamBall(ballAwayTeam);
    }

    /**
     * This method is called when the Away Team Out button is clicked.
     */
    public void outAwayTeam(View view) {
        outAwayTeam = outAwayTeam + 1;
        displayAwayTeamOut(outAwayTeam);
    }

    /**
     * Displays the given Inning Number.
     */
    public void displayInningNumber(int score) {
        TextView scoreView = (TextView) findViewById(R.id.inning_number);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Home Team.
     */
    public void displayHomeTeamScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given strikes for Home Team.
     */
    public void displayHomeTeamStrike(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_strike);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given foul balls for Home Team.
     */
    public void displayHomeTeamFoul(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_foul);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given balls for Home Team.
     */
    public void displayHomeTeamBall(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_ball);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given outs for Home Team.
     */
    public void displayHomeTeamOut(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_out);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Away Team.
     */
    public void displayAwayTeamScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.away_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given strikes for Away Team.
     */
    public void displayAwayTeamStrike(int score) {
        TextView scoreView = (TextView) findViewById(R.id.away_strike);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given foul balls for Away Team.
     */
    public void displayAwayTeamFoul(int score) {
        TextView scoreView = (TextView) findViewById(R.id.away_foul);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given balls for Away Team.
     */
    public void displayAwayTeamBall(int score) {
        TextView scoreView = (TextView) findViewById(R.id.away_ball);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given outs for Away Team.
     */
    public void displayAwayTeamOut(int score) {
        TextView scoreView = (TextView) findViewById(R.id.away_out);
        scoreView.setText(String.valueOf(score));
    }

}
