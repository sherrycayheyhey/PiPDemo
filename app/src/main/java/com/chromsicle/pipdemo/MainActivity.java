package com.chromsicle.pipdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Picture in picture is most often implemented with video playing apps but could be
//used for other purposes too like a constant stock update overlay of other apps
//is this how those pokemon iv apps work?



//*****remember to add activity stuff in the manifest so that PiP works with this app*****
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goPip(View view) {
        enterPictureInPictureMode(); //this says deprecated but is it really??
    }

    //this gets called anytime PiP is entered or exited
    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);

        TextView textView = findViewById(R.id.textView);
        Button pipButton = findViewById(R.id.pipButton);

        if (isInPictureInPictureMode) {
            //going into PiP
            pipButton.setVisibility(View.INVISIBLE);
            getSupportActionBar().hide();
            textView.setText("oh my glob!");
        } else {
            //going out of Pip
            pipButton.setVisibility(View.VISIBLE);
            getSupportActionBar().show();
            textView.setText("back to normal...");
        }
    }
}
