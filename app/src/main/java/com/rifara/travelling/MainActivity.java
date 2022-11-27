package com.rifara.travelling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rifara.travelling.ui.HistoryFragment;
import com.rifara.travelling.ui.HomeFragment;
<<<<<<< Updated upstream
import com.rifara.travelling.ui.ProfileFragment;
=======
import com.rifara.travelling.ui.ProfilFragment;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
                    fragment = new ProfileFragment();
=======
                    fragment = new ProfilFragment();
                    break;
>>>>>>> Stashed changes
            }
            LoadFragment(fragment);
            return true;
        });
    }
    //pindah antar fragment
    private void LoadFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.f_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
}