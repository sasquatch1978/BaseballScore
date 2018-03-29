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

        // Identify all views and set their listeners.
        initializeViews();
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle.
        savedInstanceState.putInt("inning_number", inningNumber);
        // Home Team
        savedInstanceState.putInt("score_home", scoreHomeTeam);
        savedInstanceState.putInt("strike_home", strikeHomeTeam);
        savedInstanceState.putInt("ball_home", ballHomeTeam);
        savedInstanceState.putInt("out_home", outHomeTeam);
        // Away Team
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
        // Restore state members from saved instance.
        inningNumber = savedInstanceState.getInt("inning_number");
        // Home Team
        scoreHomeTeam = savedInstanceState.getInt("score_home");
        strikeHomeTeam = savedInstanceState.getInt("strike_home");
        ballHomeTeam = savedInstanceState.getInt("ball_home");
        outHomeTeam = savedInstanceState.getInt("out_home");
        // Away Team
        scoreAwayTeam = savedInstanceState.getInt("score_away");
        strikeAwayTeam = savedInstanceState.getInt("strike_away");
        ballAwayTeam = savedInstanceState.getInt("ball_away");
        outAwayTeam = savedInstanceState.getInt("out_away");
        // Display the saved values.
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

    // Perform action on click.
    public void onClick(View v) {
        switch (v.getId()) {
            // Home Team run button.
            case R.id.runHomeTeam:
                // Add one point to Home Team score.
                scoreHomeTeam += 1;
                home_score.setText(String.valueOf(scoreHomeTeam));
                break;

            // Home Team strike button.
            case R.id.strikeHomeTeam:
                // Add one strike to Home Team.
                strikeHomeTeam += 1;
                home_strike.setText(String.valueOf(strikeHomeTeam));

                // After three strikes, display toast and reset count.
                if (strikeHomeTeam == 3)
                    strikeOut();
                break;

            // Home Team ball button.
            case R.id.ballHomeTeam:
                // Add one ball to the Home Team.
                ballHomeTeam += 1;
                home_ball.setText(String.valueOf(ballHomeTeam));

                // After four balls, display toast and reset count.
                if (ballHomeTeam == 4)
                    walkPlayer();
                break;

            // Home Team out button.
            case R.id.outHomeTeam:
                // Add one out to the Home Team.
                outHomeTeam += 1;
                home_out.setText(String.valueOf(outHomeTeam));

                // After three outs, display toast, reset count and reset outs with a one second delay.
                if (outHomeTeam == 3) {
                    Toast toast = Toast.makeText(this, R.string.awayTeamBat, Toast.LENGTH_SHORT);
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

            // Away Team run button.
            case R.id.runAwayTeam:
                // Add one point to Away Team score.
                scoreAwayTeam += 1;
                away_score.setText(String.valueOf(scoreAwayTeam));
                break;

            // Away Team strike button.
            case R.id.strikeAwayTeam:
                // Add one strike to Away Team.
                strikeAwayTeam += 1;
                away_strike.setText(String.valueOf(strikeAwayTeam));

                // After three strikes, display toast and reset count.
                if (strikeAwayTeam == 3)
                    strikeOut();
                break;

            // Away Team ball button.
            case R.id.ballAwayTeam:
                // Add one ball to the Away Team.
                ballAwayTeam += 1;
                away_ball.setText(String.valueOf(ballAwayTeam));

                // After four balls, display toast and reset count.
                if (ballAwayTeam == 4)
                    walkPlayer();
                break;

            // Away Team out button.
            case R.id.outAwayTeam:
                // Add one out to the Away Team.
                outAwayTeam += 1;
                away_out.setText(String.valueOf(outAwayTeam));

                // After three outs, display toast, reset count, reset outs, and increase inning by one with a one second delay.
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

            // Reset Count button (needed so that if player gets on base without being walked, count can be reset).
            case R.id.countReset:
                // Reset the count.
                resetCount();
                break;

            // Game Over button.
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

    // Identify all views and set their listeners.
    public void initializeViews() {
        inning_number = findViewById(R.id.inning_number);

        // Home team TextViews.
        home_score = findViewById(R.id.home_score);
        home_strike = findViewById(R.id.home_strike);
        home_ball = findViewById(R.id.home_ball);
        home_out = findViewById(R.id.home_out);

        // Away team TextViews.
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

    // Resets strikes and balls to zero.
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

    // Resets outs to zero.
    public void resetOuts() {
        outHomeTeam = 0;
        outAwayTeam = 0;
        home_out.setText(String.valueOf(outHomeTeam));
        away_out.setText(String.valueOf(outAwayTeam));
    }

    // Display toast, and reset strikes and balls to zero with one second delay.
    public void strikeOut() {
        Toast toast = Toast.makeText(this, R.string.playerOut, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 420);
        toast.show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                resetCount();
            }
        }, 1000);
    }

    // Display toast, and reset strikes and balls to zero with one second delay.
    public void walkPlayer() {
        Toast toast = Toast.makeText(this, R.string.playerWalk, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 420);
        toast.show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                resetCount();
            }
        }, 1000);
    }
}
