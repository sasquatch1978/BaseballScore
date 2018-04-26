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

    static String INNING_NUMBER = "inning_number";

    // Home Team
    int scoreHomeTeam = 0;
    int strikeHomeTeam = 0;
    int ballHomeTeam = 0;
    int outHomeTeam = 0;

    TextView home_score;
    TextView home_strike;
    TextView home_ball;
    TextView home_out;

    static String SCORE_HOME = "score_home";
    static String STRIKE_HOME = "strike_home";
    static String BALL_HOME = "ball_home";
    static String OUT_HOME = "out_home";

    // Away Team
    int scoreAwayTeam = 0;
    int strikeAwayTeam = 0;
    int ballAwayTeam = 0;
    int outAwayTeam = 0;

    TextView away_score;
    TextView away_strike;
    TextView away_ball;
    TextView away_out;

    static String SCORE_AWAY = "score_away";
    static String STRIKE_AWAY = "strike_away";
    static String BALL_AWAY = "ball_away";
    static String OUT_AWAY = "out_away";

    // Toast and resets
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Identify all views and set their listeners.
        initializeViews();
    }

    // Save variables
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Inning number
        savedInstanceState.putInt(INNING_NUMBER, inningNumber);
        // Home Team
        savedInstanceState.putInt(SCORE_HOME, scoreHomeTeam);
        savedInstanceState.putInt(STRIKE_HOME, strikeHomeTeam);
        savedInstanceState.putInt(BALL_HOME, ballHomeTeam);
        savedInstanceState.putInt(OUT_HOME, outHomeTeam);
        // Away Team
        savedInstanceState.putInt(SCORE_AWAY, scoreAwayTeam);
        savedInstanceState.putInt(STRIKE_AWAY, strikeAwayTeam);
        savedInstanceState.putInt(BALL_AWAY, ballAwayTeam);
        savedInstanceState.putInt(OUT_AWAY, outAwayTeam);
        super.onSaveInstanceState(savedInstanceState);
    }

    // Retrieve variables
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Inning number
        inningNumber = savedInstanceState.getInt(INNING_NUMBER);
        // Home Team
        scoreHomeTeam = savedInstanceState.getInt(SCORE_HOME);
        strikeHomeTeam = savedInstanceState.getInt(STRIKE_HOME);
        ballHomeTeam = savedInstanceState.getInt(BALL_HOME);
        outHomeTeam = savedInstanceState.getInt(OUT_HOME);
        // Away Team
        scoreAwayTeam = savedInstanceState.getInt(SCORE_AWAY);
        strikeAwayTeam = savedInstanceState.getInt(STRIKE_AWAY);
        ballAwayTeam = savedInstanceState.getInt(BALL_AWAY);
        outAwayTeam = savedInstanceState.getInt(OUT_AWAY);
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
                scoreHomeTeam++;
                home_score.setText(String.valueOf(scoreHomeTeam));
                break;

            // Home Team strike button.
            case R.id.strikeHomeTeam:
                // Add one strike to Home Team.
                strikeHomeTeam++;
                home_strike.setText(String.valueOf(strikeHomeTeam));

                // After three strikes, display toast and reset count.
                if (strikeHomeTeam == 3)
                    strikeOut();
                break;

            // Home Team ball button.
            case R.id.ballHomeTeam:
                // Add one ball to the Home Team.
                ballHomeTeam++;
                home_ball.setText(String.valueOf(ballHomeTeam));

                // After four balls, display toast and reset count.
                if (ballHomeTeam == 4)
                    walkPlayer();
                break;

            // Home Team out button.
            case R.id.outHomeTeam:
                // Add one out to the Home Team.
                outHomeTeam++;
                home_out.setText(String.valueOf(outHomeTeam));

                /* After three outs, display toast, reset count and reset outs with a one second delay,
                   so that user sees that outs are updated before resetting.
                 */
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
                scoreAwayTeam++;
                away_score.setText(String.valueOf(scoreAwayTeam));
                break;

            // Away Team strike button.
            case R.id.strikeAwayTeam:
                // Add one strike to Away Team.
                strikeAwayTeam++;
                away_strike.setText(String.valueOf(strikeAwayTeam));

                // After three strikes, display toast and reset count.
                if (strikeAwayTeam == 3)
                    strikeOut();
                break;

            // Away Team ball button.
            case R.id.ballAwayTeam:
                // Add one ball to the Away Team.
                ballAwayTeam++;
                away_ball.setText(String.valueOf(ballAwayTeam));

                // After four balls, display toast and reset count.
                if (ballAwayTeam == 4)
                    walkPlayer();
                break;

            // Away Team out button.
            case R.id.outAwayTeam:
                // Add one out to the Away Team.
                outAwayTeam++;
                away_out.setText(String.valueOf(outAwayTeam));

                /* After three outs, display toast, reset count, reset outs, and increase inning by one with a
                   one second delay, so that user sees that outs are updated before resetting.
                  */
                if (outAwayTeam == 3) {
                    Toast toast = Toast.makeText(this, R.string.homeTeamBat, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 420);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            resetCount();
                            resetOuts();
                            inningNumber++;
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
        inning_number = findViewById(R.id.inningNumber);

        // Home team TextViews.
        home_score = findViewById(R.id.homeScore);
        home_strike = findViewById(R.id.homeStrike);
        home_ball = findViewById(R.id.homeBall);
        home_out = findViewById(R.id.homeOut);

        // Away team TextViews.
        away_score = findViewById(R.id.awayScore);
        away_strike = findViewById(R.id.awayStrike);
        away_ball = findViewById(R.id.awayBall);
        away_out = findViewById(R.id.awayOut);

        // Identify buttons and set their onClickListener.
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

    /* Display toast "Out", and reset strikes and balls to zero with one second delay,
       so that user sees that strikes are updated before resetting.
     */
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

    /* Display toast "Walk", and reset strikes and balls to zero with one second delay,
       so that user sees that balls are updated before resetting.
     */
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
