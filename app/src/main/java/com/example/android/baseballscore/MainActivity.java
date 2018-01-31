package com.example.android.baseballscore;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inning_number = (TextView) findViewById(R.id.inning_number);

        home_score = (TextView) findViewById(R.id.home_score);
        home_strike = (TextView) findViewById(R.id.home_strike);
        home_ball = (TextView) findViewById(R.id.home_ball);
        home_out = (TextView) findViewById(R.id.home_out);

        away_score = (TextView) findViewById(R.id.away_score);
        away_strike = (TextView) findViewById(R.id.away_strike);
        away_ball = (TextView) findViewById(R.id.away_ball);
        away_out = (TextView) findViewById(R.id.away_out);

        // Create your buttons and set their onClickListener to "this". //
        Button inning = (Button) findViewById(R.id.inning);
        inning.setOnClickListener(this);
        Button runHomeTeam = (Button) findViewById(R.id.runHomeTeam);
        runHomeTeam.setOnClickListener(this);
        Button strikeHomeTeam = (Button) findViewById(R.id.strikeHomeTeam);
        strikeHomeTeam.setOnClickListener(this);
        Button ballHomeTeam = (Button) findViewById(R.id.ballHomeTeam);
        ballHomeTeam.setOnClickListener(this);
        Button outHomeTeam = (Button) findViewById(R.id.outHomeTeam);
        outHomeTeam.setOnClickListener(this);
        Button runAwayTeam = (Button) findViewById(R.id.runAwayTeam);
        runAwayTeam.setOnClickListener(this);
        Button strikeAwayTeam = (Button) findViewById(R.id.strikeAwayTeam);
        strikeAwayTeam.setOnClickListener(this);
        Button ballAwayTeam = (Button) findViewById(R.id.ballAwayTeam);
        ballAwayTeam.setOnClickListener(this);
        Button outAwayTeam = (Button) findViewById(R.id.outAwayTeam);
        outAwayTeam.setOnClickListener(this);
        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);
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
            case R.id.inning:
                // Increase the inning. //
                inningNumber = inningNumber + 1;
                inning_number.setText(String.valueOf(inningNumber));
                break;

            case R.id.runHomeTeam:
                // Home team run button. //
                scoreHomeTeam = scoreHomeTeam + 1;
                home_score.setText(String.valueOf(scoreHomeTeam));
                break;

            case R.id.strikeHomeTeam:
                // Home team strike button. //
                strikeHomeTeam = strikeHomeTeam + 1;
                home_strike.setText(String.valueOf(strikeHomeTeam));
                break;

            case R.id.ballHomeTeam:
                // Home team ball button. //
                ballHomeTeam = ballHomeTeam + 1;
                home_ball.setText(String.valueOf(ballHomeTeam));
                break;

            case R.id.outHomeTeam:
                // Home team out button. //
                outHomeTeam = outHomeTeam + 1;
                home_out.setText(String.valueOf(outHomeTeam));
                break;

            case R.id.runAwayTeam:
                // Away team run button. //
                scoreAwayTeam = scoreAwayTeam + 1;
                away_score.setText(String.valueOf(scoreAwayTeam));
                break;

            case R.id.strikeAwayTeam:
                // Away team strike button. //
                strikeAwayTeam = strikeAwayTeam + 1;
                away_strike.setText(String.valueOf(strikeAwayTeam));
                break;

            case R.id.ballAwayTeam:
                // Away team ball button. //
                ballAwayTeam = ballAwayTeam + 1;
                away_ball.setText(String.valueOf(ballAwayTeam));
                break;

            case R.id.outAwayTeam:
                // Away team out button. //
                outAwayTeam = outAwayTeam + 1;
                away_out.setText(String.valueOf(outAwayTeam));
                break;

            case R.id.reset:
                // Show the reset popup. //
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.reset_popup);

                Button countReset = (Button) dialog.findViewById(R.id.count_reset);
                countReset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Reset the count. //
                        strikeHomeTeam = 0;
                        ballHomeTeam = 0;
                        strikeAwayTeam = 0;
                        ballAwayTeam = 0;
                        home_strike.setText(String.valueOf(strikeHomeTeam));
                        home_ball.setText(String.valueOf(ballHomeTeam));
                        away_strike.setText(String.valueOf(strikeAwayTeam));
                        away_ball.setText(String.valueOf(ballAwayTeam));
                        dialog.dismiss();
                    }
                });

                Button outsReset = (Button) dialog.findViewById(R.id.outs_reset);
                outsReset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
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
                        dialog.dismiss();
                    }
                });

                Button allReset = (Button) dialog.findViewById(R.id.all_reset);
                allReset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Reset everything. //
                        strikeHomeTeam = 0;
                        ballHomeTeam = 0;
                        strikeAwayTeam = 0;
                        ballAwayTeam = 0;
                        outHomeTeam = 0;
                        outAwayTeam = 0;
                        inningNumber = 1;
                        scoreHomeTeam = 0;
                        scoreAwayTeam = 0;
                        home_strike.setText(String.valueOf(strikeHomeTeam));
                        home_ball.setText(String.valueOf(ballHomeTeam));
                        away_strike.setText(String.valueOf(strikeAwayTeam));
                        away_ball.setText(String.valueOf(ballAwayTeam));
                        home_out.setText(String.valueOf(outHomeTeam));
                        away_out.setText(String.valueOf(outAwayTeam));
                        inning_number.setText(String.valueOf(inningNumber));
                        home_score.setText(String.valueOf(scoreHomeTeam));
                        away_score.setText(String.valueOf(scoreAwayTeam));
                        dialog.dismiss();
                    }
                });

                dialog.show();

            default:
                break;
        }
    }
}
