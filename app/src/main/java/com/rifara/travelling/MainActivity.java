package com.rifara.travelling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rifara.travelling.ui.HistoryFragment;
import com.rifara.travelling.ui.HomeFragment;
import com.rifara.travelling.ui.ProfileFragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.rifara.travelling.ui.SignInActivity;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNav = findViewById(R.id.nav_view);
        frame = findViewById(R.id.f_container);
        LoadFragment(new HomeFragment());

        bottomNav.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()){
                case R.id.home:
                    fragment = new HomeFragment();
                    break;
                case R.id.history:
                    fragment = new HistoryFragment();
                    break;
                case R.id.profil:
                    fragment = new ProfileFragment();
                    break;
            }
            LoadFragment(fragment);
            return true;
        });
    }

    //pindah antar fragment
    private void LoadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.f_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

}