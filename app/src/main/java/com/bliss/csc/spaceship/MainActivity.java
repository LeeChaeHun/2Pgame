package com.bliss.csc.spaceship;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.startgame);
        findViewById(R.id.main).setOnClickListener(OnMyClick);
        findViewById(R.id.main1).setOnClickListener(OnMyClick);
    }


    Button.OnClickListener OnMyClick = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.main:
                    startActivity(new Intent(MainActivity.this, SpaceActivity.class));
                    break;
                case R.id.main1:
                    Log.i("TEST","눌림");
                    startActivity(new Intent(MainActivity.this, AirHockeyActivity.class));
                    break;

            }
        }
    };
}
