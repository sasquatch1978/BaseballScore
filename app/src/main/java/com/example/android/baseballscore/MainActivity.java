package com.example.android.baseballscore;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Inning Number
    int inningNumber = 1;

    TextView inning_number;

    // Home Team
    int scoreHomeTeam = 0;
    int strikeHomeTeam = 0;
    int ballHomeTeam = 0;
    int outHomeTeam = 0;

    TextView home_score;
    TextView home_strike;
    TextView home_ball;
    TextView home_out;

    // Away Team
    int scoreAwayTeam = 0;
    int strikeAwayTeam = 0;
    int ballAwayTeam = 0;
    int outAwayTeam = 0;

    TextView away_score;
    TextView away_strike;
    TextView away_ball;
    TextView away_out;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inning_number = findViewById(R.id.inning_number);

        home_score = findViewById(R.id.home_score);
        home_strike = findViewById(R.id.home_strike);
        home_ball = findViewById(R.id.home_ball);
        home_out = findViewById(R.id.home_out);

        away_score = findViewById(R.id.away_score);
        away_strike = findViewById(R.id.away_strike);
        away_ball = findViewById(R.id.away_ball);
        away_out = findViewById(R.id.away_out);

        // Create your buttons and set their onClickListener to "this".
        Button runHomeTeam = findViewById(R.id.runHomeTeam);
        runHomeTeam.setOnClickListener(this);
        Button strikeHomeTeam = findViewById(R.id.strikeHomeTeam);
        strikeHomeTeam.setOnClickListener(this);
        Button ballHomeTeam = findViewById(R.id.ballHomeTeam);
        ballHomeTeam.setOnClickListener(this);
        Button outHomeTeam = findViewById(R.id.outHomeTeam);
        outHomeTeam.setOnClickListener(this);
        Button runAwayTeam = findViewById(R.id.runAwayTeam);
        runAwayTeam.setOnClickListener(this);
        Button strikeAwayTeam = findViewById(R.id.strikeAwayTeam);
        strikeAwayTeam.setOnClickListener(this);
        Button ballAwayTeam = findViewById(R.id.ballAwayTeam);
        ballAwayTeam.setOnClickListener(this);
        Button outAwayTeam = findViewById(R.id.outAwayTeam);
        outAwayTeam.setOnClickListener(this);
        Button countReset = findViewById(R.id.countReset);
        countReset.setOnClickListener(this);
        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(this);
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle. //
        savedInstanceState.putInt("inning_number", inningNumber);
        // Home Team. //
        savedInstanceState.putInt("score_home", scoreHomeTeam);
        savedInstanceState.putInt("strike_home", strikeHomeTeam);
        savedInstanceState.putInt("ball_home", ballHomeTeam);
        savedInstanceState.putInt("out_home", outHomeTeam);
        // Away Team. //
        savedInstanceState.putInt("score_away", scoreAwayTeam);
        savedInstanceState.putInt("strike_away", strikeAwayTeam);
        savedInstanceState.putInt("ball_away", ballAwayTeam);
        savedInstanceState.putInt("out_away", outAwayTeam);
        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy.
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance. //
        inningNumber = savedInstanceState.getInt("inning_number");
        // Home Team //
        scoreHomeTeam = savedInstanceState.getInt("score_home");
        strikeHomeTeam = savedInstanceState.getInt("strike_home");
        ballHomeTeam = savedInstanceState.getInt("ball_home");
        outHomeTeam = savedInstanceState.getInt("out_home");
        // Away Team //
        scoreAwayTeam = savedInstanceState.getInt("score_away");
        strikeAwayTeam = savedInstanceState.getInt("strike_away");
        ballAwayTeam = savedInstanceState.getInt("ball_away");
        outAwayTeam = savedInstanceState.getInt("out_away");
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

    public void resetCount() {
        strikeHomeTeam = 0;
        ballHomeTeam = 0;
        strikeAwayTeam = 0;
        ballAwayTeam = 0;
        home_strike.setText(String.valueOf(strikeHomeTeam));
        home_ball.setText(String.valueOf(ballHomeTeam));
        away_strike.setText(String.valueOf(strikeAwayTeam));
        away_ball.setText(String.valueOf(ballAwayTeam));
    }

    public void resetOuts() {
        outHomeTeam = 0;
        outAwayTeam = 0;
        home_out.setText(String.valueOf(outHomeTeam));
        away_out.setText(String.valueOf(outAwayTeam));
    }

    public void strikeOut() {
        Toast toast = Toast.makeText(this, "Out", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 420);
        toast.show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                resetCount();
            }
        }, 1000);
    }

    public void walkPlayer() {
        Toast toast = Toast.makeText(this, "Walk", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 420);
        toast.show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                resetCount();
            }
        }, 1000);
    }

    public void onClick(View v) {
        // Perform action on click.
        switch (v.getId()) {
            case R.id.runHomeTeam:
                // Home team run button.
                scoreHomeTeam += 1;
                home_score.setText(String.valueOf(scoreHomeTeam));
                break;

            case R.id.strikeHomeTeam:
                // Home team strike button.
                strikeHomeTeam += 1;
                home_strike.setText(String.valueOf(strikeHomeTeam));

                if (strikeHomeTeam == 3)
                    strikeOut();
                break;

            case R.id.ballHomeTeam:
                // Home team ball button.
                ballHomeTeam += 1;
                home_ball.setText(String.valueOf(ballHomeTeam));

                if (ballHomeTeam == 4)
                    walkPlayer();
                break;

            case R.id.outHomeTeam:
                // Home team out button.
                outHomeTeam += 1;
                home_out.setText(String.valueOf(outHomeTeam));

                if (outHomeTeam == 3) {
                    Toast toast = Toast.makeText(this, "Away Team at bat.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 420);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            resetCount();
                            resetOuts();
                        }
                    }, 1000);
                }
                break;

            case R.id.runAwayTeam:
                // Away team run button.
                scoreAwayTeam += 1;
                away_score.setText(String.valueOf(scoreAwayTeam));
                break;

            case R.id.strikeAwayTeam:
                // Away team strike button.
                strikeAwayTeam += 1;
                away_strike.setText(String.valueOf(strikeAwayTeam));

                if (strikeAwayTeam == 3)
                    strikeOut();
                break;

            case R.id.ballAwayTeam:
                // Away team ball button.
                ballAwayTeam += 1;
                away_ball.setText(String.valueOf(ballAwayTeam));

                if (ballAwayTeam == 4)
                    walkPlayer();
                break;

            case R.id.outAwayTeam:
                // Away team out button.
                outAwayTeam += 1;
                away_out.setText(String.valueOf(outAwayTeam));

                if (outAwayTeam == 3) {
                    Toast toast = Toast.makeText(this, R.string.homeTeamBat, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 420);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            resetCount();
                            resetOuts();
                            inningNumber += 1;
                            inning_number.setText(String.valueOf(inningNumber));
                        }
                    }, 1000);
                }
                break;

            case R.id.countReset:
                // Reset the count.
                resetCount();
                break;

            case R.id.reset:
                // Reset everything.
                resetCount();
                resetOuts();
                inningNumber = 1;
                scoreHomeTeam = 0;
                scoreAwayTeam = 0;
                inning_number.setText(String.valueOf(inningNumber));
                home_score.setText(String.valueOf(scoreHomeTeam));
                away_score.setText(String.valueOf(scoreAwayTeam));

            default:
                break;
        }
    }
}
