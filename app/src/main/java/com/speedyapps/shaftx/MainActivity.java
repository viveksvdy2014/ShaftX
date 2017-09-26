package com.speedyapps.shaftx;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static Button Previous,Next;
    Fragment firstFragment,secondFragment,finalFragment;
    Fragment firstPage,secondPage,finalPage;
    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        Previous=(Button)findViewById(R.id.previous);
        Next=(Button)findViewById(R.id.next);
        Previous.setVisibility(View.INVISIBLE);
        firstPage = new FirstPageFragment();
        secondPage = new Page2Fragment();
        finalPage = new finnalPageFragment();
        fragmentManager.beginTransaction().add(R.id.frameFragment,firstPage,"firstPage").commit();

    }
    public void onClick(View view){
        if(Next.getVisibility()==View.INVISIBLE)
            Next.setVisibility(View.VISIBLE);
        firstFragment = getSupportFragmentManager().findFragmentByTag("firstPage");
        secondFragment = getSupportFragmentManager().findFragmentByTag("secondPage");
        finalFragment = getSupportFragmentManager().findFragmentByTag("finalPage");
        if(view.getId()==R.id.previous) {
            if ((secondFragment != null && secondFragment.isVisible())) {
                fragmentManager.beginTransaction().replace(R.id.frameFragment, firstPage, "firstPage").commit();
                Previous.setVisibility(View.INVISIBLE);
            } else if ((finalFragment != null && finalFragment.isVisible())) {
                fragmentManager.beginTransaction().replace(R.id.frameFragment, secondPage, "secondPage").commit();
            }
        }
        else {
            if(Previous.getVisibility()==View.INVISIBLE)
                Previous.setVisibility(View.VISIBLE);
            if ((firstFragment != null && firstFragment.isVisible())) {
                    fragmentManager.beginTransaction().replace(R.id.frameFragment, secondPage, "secondPage").commit();
                } else if ((secondFragment != null && secondFragment.isVisible())) {
                    fragmentManager.beginTransaction().replace(R.id.frameFragment, finalPage, "finalPage").commit();
                    Next.setVisibility(View.INVISIBLE);
                }
            }

        }



}
