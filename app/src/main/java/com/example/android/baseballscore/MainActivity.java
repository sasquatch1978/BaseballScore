package com.example.android.baseballscore;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public class Reset extends AppCompatActivity implements View.OnClickListener {

        protected void onCreate(Bundle savedBundle) {
            super.onCreate(savedBundle);
            setContentView(R.layout.reset_popup);

            // Create your buttons and set their onClickListener to "this". //
            Button b1 = (Button) findViewById(R.id.count_reset);
            b1.setOnClickListener(this);

            Button b2 = (Button) findViewById(R.id.outs_reset);
            b2.setOnClickListener(this);

            Button b3 = (Button) findViewById(R.id.all_reset);
            b3.setOnClickListener(this);}


        // Implement the onClick method here. //

        public void onClick(View v) {
            // Perform action on click //
            switch (v.getId()) {
                case R.id.count_reset:
                    // Reset the count. //
                    strikeHomeTeam = 0;
                    ballHomeTeam = 0;
                    strikeAwayTeam = 0;
                    ballAwayTeam = 0;
                    home_strike.setText(String.valueOf(strikeHomeTeam));
                    home_ball.setText(String.valueOf(ballHomeTeam));
                    away_strike.setText(String.valueOf(strikeAwayTeam));
                    away_ball.setText(String.valueOf(ballAwayTeam));
                    break;
                case R.id.outs_reset:
                    // Reset the count and outs. //
                    strikeHomeTeam = 0;
                    ballHomeTeam = 0;
                    strikeAwayTeam = 0;
                    ballAwayTeam = 0;
                    outHomeTeam = 0;
                    outAwayTeam = 0;
                    home_strike.setText(String.valueOf(strikeHomeTeam));
                    home_ball.setText(String.valueOf(ballHomeTeam));
                    away_strike.setText(String.valueOf(strikeAwayTeam));
                    away_ball.setText(String.valueOf(ballAwayTeam));
                    home_out.setText(String.valueOf(outHomeTeam));
                    away_out.setText(String.valueOf(outAwayTeam));
                    break;
                case R.id.all_reset:
                    // Reset the count and outs. //
                    strikeHomeTeam = 0;
                    ballHomeTeam = 0;
                    strikeAwayTeam = 0;
                    ballAwayTeam = 0;
                    outHomeTeam = 0;
                    outAwayTeam = 0;
                    home_strike.setText(String.valueOf(strikeHomeTeam));
                    home_ball.setText(String.valueOf(ballHomeTeam));
                    away_strike.setText(String.valueOf(strikeAwayTeam));
                    away_ball.setText(String.valueOf(ballAwayTeam));
                    home_out.setText(String.valueOf(outHomeTeam));
                    away_out.setText(String.valueOf(outAwayTeam));
                    break;

                default:
                    break;
            }
        }
    }


    // Inning Number //
    int inningNumber = 1;

    static String INNING_NUMBER = "inning_number";

    TextView inning_number;

    // Home Team //
    int scoreHomeTeam = 0;
    int strikeHomeTeam = 0;
    int ballHomeTeam = 0;
    int outHomeTeam = 0;

    static String SCORE_HOME = "score_home";
    static String STRIKE_HOME = "strike_home";
    static String BALL_HOME = "ball_home";
    static String OUT_HOME = "out_home";

    TextView home_score;
    TextView home_strike;
    TextView home_ball;
    TextView home_out;

    // Away Team //
    int scoreAwayTeam = 0;
    int strikeAwayTeam = 0;
    int ballAwayTeam = 0;
    int outAwayTeam = 0;

    static String SCORE_AWAY = "score_away";
    static String STRIKE_AWAY = "strike_away";
    static String BALL_AWAY = "ball_away";
    static String OUT_AWAY = "out_away";

    TextView away_score;
    TextView away_strike;
    TextView away_ball;
    TextView away_out;

    // Reset Button //
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inning_number = (TextView) findViewById(R.id.inning_number);

        home_score = findViewById(R.id.home_score);
        home_strike = findViewById(R.id.home_strike);
        home_ball = findViewById(R.id.home_ball);
        home_out = findViewById(R.id.home_out);

        away_score = findViewById(R.id.away_score);
        away_strike = findViewById(R.id.away_strike);
        away_ball = findViewById(R.id.away_ball);
        away_out = findViewById(R.id.away_out);

        // Create your buttons and set their onClickListener to "this". //
        Button b4 = (Button) findViewById(R.id.reset);
        b4.setOnClickListener(this);

        }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle. //
        savedInstanceState.putInt(INNING_NUMBER, inningNumber);
        // Home Team. //
        savedInstanceState.putInt(SCORE_HOME, scoreHomeTeam);
        savedInstanceState.putInt(STRIKE_HOME, strikeHomeTeam);
        savedInstanceState.putInt(BALL_HOME, ballHomeTeam);
        savedInstanceState.putInt(OUT_HOME, outHomeTeam);
        // Away Team. //
        savedInstanceState.putInt(SCORE_AWAY, scoreAwayTeam);
        savedInstanceState.putInt(STRIKE_AWAY, strikeAwayTeam);
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
        ballHomeTeam = savedInstanceState.getInt(BALL_HOME);
        outHomeTeam = savedInstanceState.getInt(OUT_HOME);
        // Away Team //
        scoreAwayTeam = savedInstanceState.getInt(SCORE_AWAY);
        strikeAwayTeam = savedInstanceState.getInt(STRIKE_AWAY);
        ballAwayTeam = savedInstanceState.getInt(BALL_AWAY);
        outAwayTeam = savedInstanceState.getInt(OUT_AWAY);
        // Display the saved values. //
        home_strike.setText(String.valueOf(strikeHomeTeam));
        home_ball.setText(String.valueOf(ballHomeTeam));
        away_strike.setText(String.valueOf(strikeAwayTeam));
        away_ball.setText(String.valueOf(ballAwayTeam));
        home_out.setText(String.valueOf(outHomeTeam));
        away_out.setText(String.valueOf(outAwayTeam));
        inning_number.setText(String.valueOf(inningNumber));
        home_score.setText(String.valueOf(scoreHomeTeam));
        away_score.setText(String.valueOf(scoreAwayTeam));
    }

    // Reset Button //
    public void onClick(View v) {
        // Perform action on click //
        switch (v.getId()) {
            case R.id.reset:
                // Reset the count. //
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.reset_popup);
                dialog.show();
                break;
        }
    }

    /**
     * This method is called when the Inning button is clicked.
     */
    public void changeInning(View view) {
        inningNumber = inningNumber + 1;
        inning_number.setText(String.valueOf(inningNumber));
    }

    /**
     * This method is called when the Home Team Run button is clicked.
     */
    public void runHomeTeam(View view) {
        scoreHomeTeam = scoreHomeTeam + 1;
        home_score.setText(String.valueOf(scoreHomeTeam));
    }

    /**
     * This method is called when the Home Team Strike button is clicked.
     */
    public void strikeHomeTeam(View view) {
        strikeHomeTeam = strikeHomeTeam + 1;
        home_strike.setText(String.valueOf(strikeHomeTeam));
    }

    /**
     * This method is called when the Home Team Ball button is clicked.
     */
    public void ballHomeTeam(View view) {
        ballHomeTeam = ballHomeTeam + 1;
        home_ball.setText(String.valueOf(ballHomeTeam));
    }

    /**
     * This method is called when the Home Team Out button is clicked.
     */
    public void outHomeTeam(View view) {
        outHomeTeam = outHomeTeam + 1;
        home_out.setText(String.valueOf(outHomeTeam));
    }

    /**
     * This method is called when the Away Team Run button is clicked.
     */
    public void runAwayTeam(View view) {
        scoreAwayTeam = scoreAwayTeam + 1;
        away_score.setText(String.valueOf(scoreAwayTeam));
    }

    /**
     * This method is called when the Away Team Strike button is clicked.
     */
    public void strikeAwayTeam(View view) {
        strikeAwayTeam = strikeAwayTeam + 1;
        away_strike.setText(String.valueOf(strikeAwayTeam));
    }

    /**
     * This method is called when the Away Team Ball button is clicked.
     */
    public void ballAwayTeam(View view) {
        ballAwayTeam = ballAwayTeam + 1;
        away_ball.setText(String.valueOf(ballAwayTeam));
    }

    /**
     * This method is called when the Away Team Out button is clicked.
     */
    public void outAwayTeam(View view) {
        outAwayTeam = outAwayTeam + 1;
        away_out.setText(String.valueOf(outAwayTeam));
    }
}
