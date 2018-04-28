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
    int gameInningNumber = 1;

    TextView inningNumber;

    static String myInningNumber = "myInningNumber";

    // Home Team
    int scoreHomeTeam;
    int strikeHomeTeam;
    int ballHomeTeam;
    int outHomeTeam;

    TextView homeScore;
    TextView homeStrike;
    TextView homeBall;
    TextView homeOut;

    static String scoreHome = "scoreHome";
    static String strikeHome = "strikeHome";
    static String ballHome = "ballHome";
    static String outHome = "outHome";

    // Away Team
    int scoreAwayTeam;
    int strikeAwayTeam;
    int ballAwayTeam;
    int outAwayTeam;

    TextView awayScore;
    TextView awayStrike;
    TextView awayBall;
    TextView awayOut;

    static String scoreAway = "scoreAway";
    static String strikeAway = "strikeAway";
    static String ballAway = "ballAway";
    static String outAway = "outAway";

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
        savedInstanceState.putInt(myInningNumber, gameInningNumber);
        // Home Team
        savedInstanceState.putInt(scoreHome, scoreHomeTeam);
        savedInstanceState.putInt(strikeHome, strikeHomeTeam);
        savedInstanceState.putInt(ballHome, ballHomeTeam);
        savedInstanceState.putInt(outHome, outHomeTeam);
        // Away Team
        savedInstanceState.putInt(scoreAway, scoreAwayTeam);
        savedInstanceState.putInt(strikeAway, strikeAwayTeam);
        savedInstanceState.putInt(ballAway, ballAwayTeam);
        savedInstanceState.putInt(outAway, outAwayTeam);
        super.onSaveInstanceState(savedInstanceState);
    }

    // Retrieve variables
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Inning number
        gameInningNumber = savedInstanceState.getInt(myInningNumber);
        // Home Team
        scoreHomeTeam = savedInstanceState.getInt(scoreHome);
        strikeHomeTeam = savedInstanceState.getInt(strikeHome);
        ballHomeTeam = savedInstanceState.getInt(ballHome);
        outHomeTeam = savedInstanceState.getInt(outHome);
        // Away Team
        scoreAwayTeam = savedInstanceState.getInt(scoreAway);
        strikeAwayTeam = savedInstanceState.getInt(strikeAway);
        ballAwayTeam = savedInstanceState.getInt(ballAway);
        outAwayTeam = savedInstanceState.getInt(outAway);
        // Display the saved values.
        homeStrike.setText(String.valueOf(strikeHomeTeam));
        homeBall.setText(String.valueOf(ballHomeTeam));
        awayStrike.setText(String.valueOf(strikeAwayTeam));
        awayBall.setText(String.valueOf(ballAwayTeam));
        homeOut.setText(String.valueOf(outHomeTeam));
        awayOut.setText(String.valueOf(outAwayTeam));
        inningNumber.setText(String.valueOf(gameInningNumber));
        homeScore.setText(String.valueOf(scoreHomeTeam));
        awayScore.setText(String.valueOf(scoreAwayTeam));
    }

    // Perform action on click.
    public void onClick(View v) {
        switch (v.getId()) {
            // Home Team run button.
            case R.id.runHomeTeam:
                // Add one point to Home Team score.
                scoreHomeTeam++;
                homeScore.setText(String.valueOf(scoreHomeTeam));
                break;

            // Home Team strike button.
            case R.id.strikeHomeTeam:
                // Add one strike to Home Team.
                strikeHomeTeam++;
                homeStrike.setText(String.valueOf(strikeHomeTeam));

                // After three strikes, display toast and reset count.
                if (strikeHomeTeam == 3)
                    strikeOut();
                break;

            // Home Team ball button.
            case R.id.ballHomeTeam:
                // Add one ball to the Home Team.
                ballHomeTeam++;
                homeBall.setText(String.valueOf(ballHomeTeam));

                // After four balls, display toast and reset count.
                if (ballHomeTeam == 4)
                    walkPlayer();
                break;

            // Home Team out button.
            case R.id.outHomeTeam:
                // Add one out to the Home Team.
                outHomeTeam++;
                homeOut.setText(String.valueOf(outHomeTeam));

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
                awayScore.setText(String.valueOf(scoreAwayTeam));
                break;

            // Away Team strike button.
            case R.id.strikeAwayTeam:
                // Add one strike to Away Team.
                strikeAwayTeam++;
                awayStrike.setText(String.valueOf(strikeAwayTeam));

                // After three strikes, display toast and reset count.
                if (strikeAwayTeam == 3)
                    strikeOut();
                break;

            // Away Team ball button.
            case R.id.ballAwayTeam:
                // Add one ball to the Away Team.
                ballAwayTeam++;
                awayBall.setText(String.valueOf(ballAwayTeam));

                // After four balls, display toast and reset count.
                if (ballAwayTeam == 4)
                    walkPlayer();
                break;

            // Away Team out button.
            case R.id.outAwayTeam:
                // Add one out to the Away Team.
                outAwayTeam++;
                awayOut.setText(String.valueOf(outAwayTeam));

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
                            gameInningNumber++;
                            inningNumber.setText(String.valueOf(gameInningNumber));
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
                gameInningNumber = 1;
                scoreHomeTeam = 0;
                scoreAwayTeam = 0;
                inningNumber.setText(String.valueOf(gameInningNumber));
                homeScore.setText(String.valueOf(scoreHomeTeam));
                awayScore.setText(String.valueOf(scoreAwayTeam));

            default:
                break;
        }
    }

    // Identify all views and set their listeners.
    public void initializeViews() {
        inningNumber = findViewById(R.id.inningNumber);

        // Home team TextViews.
        homeScore = findViewById(R.id.homeScore);
        homeStrike = findViewById(R.id.homeStrike);
        homeBall = findViewById(R.id.homeBall);
        homeOut = findViewById(R.id.homeOut);

        // Away team TextViews.
        awayScore = findViewById(R.id.awayScore);
        awayStrike = findViewById(R.id.awayStrike);
        awayBall = findViewById(R.id.awayBall);
        awayOut = findViewById(R.id.awayOut);

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
        homeStrike.setText(String.valueOf(strikeHomeTeam));
        homeBall.setText(String.valueOf(ballHomeTeam));
        awayStrike.setText(String.valueOf(strikeAwayTeam));
        awayBall.setText(String.valueOf(ballAwayTeam));
    }

    // Resets outs to zero.
    public void resetOuts() {
        outHomeTeam = 0;
        outAwayTeam = 0;
        homeOut.setText(String.valueOf(outHomeTeam));
        awayOut.setText(String.valueOf(outAwayTeam));
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
