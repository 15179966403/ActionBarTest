package com.hrc.administrator.actionbartest;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import layout.Dashboard;
import layout.Home;
import layout.Notification;

public class ThreeActivity extends AppCompatActivity {
    private Home home;
    private Dashboard dashboard;
    private Notification notifications;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(home==null){
                        home=new Home();
                    }
                    transaction.replace(R.id.content,home);
                    break;
                case R.id.navigation_dashboard:
                    if (dashboard==null){
                        dashboard=new Dashboard();
                    }
                    transaction.replace(R.id.content,dashboard);
                    break;
                case R.id.navigation_notifications:
                    if (notifications==null){
                        notifications=new Notification();
                    }
                    transaction.replace(R.id.content,notifications);
                    break;
            }
            transaction.commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        home=new Home();
        transaction.replace(R.id.content,home);
        transaction.commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
