package com.example.instagram;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private BottomNavigationView bottom_navigation;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        // define your fragments here
        final Fragment actionHome = new HomeFragment();
        final Fragment actionProfile = new AccountFragement();
        final Fragment actionAdd = new AddFragment();

        bottom_navigation = findViewById(R.id.bottom_navigation);

        // handle navigation selection
        bottom_navigation.setOnItemSelectedListener(
                new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment;
                        switch (item.getItemId()) {
                            case R.id.home:
                                fragment = actionHome;
                                break;
                            case R.id.add:
                                fragment = actionAdd;
                                break;
                            case R.id.person:
                            default:
                                fragment = actionProfile;
                                break;
                        }
                        fragmentManager.beginTransaction().replace(R.id.Frame, fragment).commit();
                        return true;
                    }
                });
        // Set default selection
        bottom_navigation.setSelectedItemId(R.id.home);
    }
}
