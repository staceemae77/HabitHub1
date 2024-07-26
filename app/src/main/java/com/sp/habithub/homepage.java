package com.sp.habithub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import android.content.Intent;
import android.view.MenuItem;
import androidx.annotation.NonNull;

import android.os.Bundle;

public class homepage extends AppCompatActivity {
    private BottomNavigationView navView;

    private HomeFragment homefragment;
    private int bottomSelectedMenu = R.id.stats;
    private int getBottomSelectedMenu = R.id.addHabit;
    private int TheBottomSelectedMenu = R.id.home;
    private FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        replaceFragment(new AddHabitFragment());

        navView = findViewById(R.id.bottomNavigationView);
        navView.setOnItemSelectedListener(menuSelected);
        homefragment = new HomeFragment();

        }
        /*@Override
                protected void onStart() {
            invalidateOptionsMenu();
            super.onStart();
        } */


        NavigationBarView.OnItemSelectedListener menuSelected = new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home) {
                    fragmentManager.beginTransaction();
                    replaceFragment(new HomeFragment());
                    return true;
                } else if (id == R.id.addHabit) {

                    Intent intent = new Intent(homepage.this, AddHabit.class);
                    startActivity(intent);

                   // fragmentManager.beginTransaction();
                           // replaceFragment(new AddHabitFragment());

                    return true;
                    } else if (id == R.id.stats) {
                    Intent i = new Intent(homepage.this, Stats.class);
                    startActivity(i);
                    return true;
                }
                return false;
            }
        };


public void replaceFragment(Fragment fragment){
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.frame_layout,fragment);
    fragmentTransaction.commit();

    }
}