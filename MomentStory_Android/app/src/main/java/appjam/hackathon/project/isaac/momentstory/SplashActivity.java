package appjam.hackathon.project.isaac.momentstory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import appjam.hackathon.project.isaac.momentstory.view.LoginActivity;

public class SplashActivity extends AppCompatActivity {
    ImageView logo_main;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo_main = findViewById(R.id.logo_main);
        logo = findViewById(R.id.logo);
        Handler delayHandler = new Handler();
        delayHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
                logo_main.startAnimation(animation);

                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation2);
                logo.startAnimation(animation2);

                Handler delayHandler = new Handler();
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    }
                }, 2000);
            }
        }, 1000);
    }
}
