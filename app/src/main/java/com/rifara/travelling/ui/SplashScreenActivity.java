package com.rifara.travelling.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rifara.travelling.HomeActivity;
import com.rifara.travelling.R;
import com.rifara.travelling.ui.SignInActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
            if (currentUser != null) {
                startActivity(new Intent(SplashScreenActivity.this, SignInActivity.class));
            } else {
                startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
            }
//            startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
            finish();
        },3000);

    }
}