package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyTextView;
    Button buttonTop;
    Button buttonBottom;

    int mCurrentState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            mCurrentState = savedInstanceState.getInt("STATE_KEY");
        }
        else {
            mCurrentState = 0;
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        buttonTop = (Button) findViewById(R.id.buttonTop);
        buttonBottom = (Button) findViewById(R.id.buttonBottom);

        updateUI();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mCurrentState == 0) { // state T1
                    mCurrentState = 2; // go to state T3
                    updateUI();
                }
                else if(mCurrentState == 1) { // state T2
                    mCurrentState = 2; // go to state T3
                    updateUI();
                }
                else if(mCurrentState == 2) { // state T3
                    mCurrentState = 5; // go to state T6
                    updateUI();
                }
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mCurrentState == 0) { // state T1
                    mCurrentState = 1; // go to state T2
                    updateUI();
                }
                else if(mCurrentState == 1) { // state T2
                    mCurrentState = 3; // go to state T4
                    updateUI();
                }
                else if(mCurrentState == 2) { // state T3
                    mCurrentState = 4; // go to state T5
                    updateUI();
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("STATE_KEY", mCurrentState);
    }

    private void updateUI() {
        if(mCurrentState == 0) { //state T1
            storyTextView.setText(R.string.T1_Story);
            buttonTop.setText(R.string.T1_Ans1);
            buttonBottom.setText(R.string.T1_Ans2);
        }
        else if(mCurrentState == 1) { // state T2
            storyTextView.setText(R.string.T2_Story);
            buttonTop.setText(R.string.T2_Ans1);
            buttonBottom.setText(R.string.T2_Ans2);
        }
        else if(mCurrentState == 2) { // state T3
            storyTextView.setText(R.string.T3_Story);
            buttonTop.setText(R.string.T3_Ans1);
            buttonBottom.setText(R.string.T3_Ans2);
        }
        else if(mCurrentState == 3) { // state T4
            storyTextView.setText(R.string.T4_End);
            buttonTop.setVisibility(View.INVISIBLE);
            buttonBottom.setVisibility(View.INVISIBLE);
        }
        else if(mCurrentState == 4) { // state T5
            storyTextView.setText(R.string.T5_End);
            buttonTop.setVisibility(View.INVISIBLE);
            buttonBottom.setVisibility(View.INVISIBLE);
        }
        else if(mCurrentState == 5) { // state T6
            storyTextView.setText(R.string.T6_End);
            buttonTop.setVisibility(View.INVISIBLE);
            buttonBottom.setVisibility(View.INVISIBLE);
        }
    }
}
