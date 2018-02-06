package com.vishwanath.reachmobi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //startActivity(new Intent(SplashActivity.this, MainActivity.class));
        //finish();

        setContentView(R.layout.splash_layout);

        final ImageView img = findViewById(R.id.imageView);
        final Animation ani1 = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.rotate);
        final Animation ani2 = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.antirotate);

        img.startAnimation(ani1);
        ani1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                img.startAnimation(ani2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        ani2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }


}
