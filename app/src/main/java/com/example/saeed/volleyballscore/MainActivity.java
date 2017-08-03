package com.example.saeed.volleyballscore;



        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import org.w3c.dom.Text;

        import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    String message;
    TextView textView;
    int gamepointTeamA;
    int setpointTeamA;
    int gamepointTeamB;
    int setpointTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayForTeamA(int point) {
        TextView pointview = (TextView) findViewById(R.id.team_a_score);
        pointview.setText(String.valueOf(point));
    }

    private void displayForTeamAset(int point) {
        TextView pointview = (TextView) findViewById(R.id.team_a_score_set);
        pointview.setText(String.valueOf(point));
    }

    public void A_Game_points(View v) {

        gamepointTeamA = gamepointTeamA + 1;
        displayForTeamA(gamepointTeamA);
        if (gamepointTeamA >= 25 && gamepointTeamA - 1 > gamepointTeamB)

        {
            setpointTeamA = setpointTeamA + 1;
            displayForTeamAset(setpointTeamA);
            gamepointTeamB = 0;
            gamepointTeamA = 0;
            displayForTeamB(gamepointTeamB);
            displayForTeamA(gamepointTeamA);

        }
        if (setpointTeamA == 3 && setpointTeamB < 3) {
            message += "Team A WON";
            VictoryMessage(message);

        }
    }

    public void A_Set_points(View v) {
        setpointTeamA = setpointTeamA + 1;
        displayForTeamAset(setpointTeamA);
        if (setpointTeamA == 3 && setpointTeamB < 3) {
            message = "Team A WON";
            VictoryMessage(message);
        }
    }

    private void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    private void displayForTeamBset(int point) {
        TextView pointview = (TextView) findViewById(R.id.team_b_score_set);
        pointview.setText(String.valueOf(point));
    }

    public void B_Game_points(View v) {
        gamepointTeamB = gamepointTeamB + 1;
        displayForTeamB(gamepointTeamB);
        if (gamepointTeamB >= 25 && gamepointTeamB - 1 > gamepointTeamA)

        {
            setpointTeamB = setpointTeamB + 1;
            displayForTeamBset(setpointTeamB);
            gamepointTeamB = 0;
            gamepointTeamA = 0;
            displayForTeamB(gamepointTeamB);
            displayForTeamA(gamepointTeamA);
        }
        if (setpointTeamB == 3 && setpointTeamA < 3) {
            message = "Team B WON";
            VictoryMessage(message);
        }
    }

    public void B_Set_points(View v) {
        setpointTeamB = setpointTeamB + 1;
        displayForTeamBset(setpointTeamB);
        if (setpointTeamB == 3 && setpointTeamA < 3) {
            message = "Team B WON";
            VictoryMessage(message);
        }
    }

    private void VictoryMessage(String message) {

        TextView textView = (TextView) findViewById(R.id.Victory_Message);
        textView.setText(message);
    }

    public void resetpoints(View v) {
        gamepointTeamA = 0;
        setpointTeamA = 0;
        gamepointTeamB = 0;
        setpointTeamB = 0;
        displayForTeamB(0);
        displayForTeamA(0);
        displayForTeamAset(0);
        displayForTeamBset(0);
        message = "";
        VictoryMessage(message);
    }
}

