package com.speedyapps.shaftx;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FirstPageFragment.messageSender,Page2Fragment.secondFragmentMessage{

    public static Button Previous,Next;
    Fragment firstFragment,secondFragment,finalFragment;
    public static Bundle bundle;
    Fragment firstPage,secondPage,finalPage;
    public static FragmentManager fragmentManager;
    public static int distanceBearings=0,distanceBearingNGear=0,distanceGearNPulley=0,distancePulleyNBearing=0,diameterOfPulley=0,diameterOfGear=0,weightOfPulley=0,permissibleStress=0,pressureAngleOfGear=0,tensionRatio=0,maxTensionInBelt=0,kForHollowShaft=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle=new Bundle();
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

        }

        public void firstFragmentReceiver(int val1,int val2,int val3,int val4,int val5,int val6){
            firstFragment = getSupportFragmentManager().findFragmentByTag("firstPage");
            secondFragment = getSupportFragmentManager().findFragmentByTag("secondPage");
            finalFragment = getSupportFragmentManager().findFragmentByTag("finalPage");
            distanceBearings=val1;
            distanceBearingNGear=val2;
            distanceGearNPulley=val3;
            distancePulleyNBearing=val4;
            diameterOfPulley=val5;
            diameterOfGear=val6;
            fragmentManager.beginTransaction().replace(R.id.frameFragment, secondPage, "secondPage").commit();
            Previous.setVisibility(View.VISIBLE);

        }
        public void messageFromSecond(int var1,int var2,int var3,int var4,int var5,int var6){
            firstFragment = getSupportFragmentManager().findFragmentByTag("firstPage");
            secondFragment = getSupportFragmentManager().findFragmentByTag("secondPage");
            finalFragment = getSupportFragmentManager().findFragmentByTag("finalPage");
            weightOfPulley=var1;
            permissibleStress=var2;
            pressureAngleOfGear=var3;
            tensionRatio=var4;
            maxTensionInBelt=var5;
            kForHollowShaft=var6;
            bundle.putString("distanceBearings",Integer.toString(distanceBearings));
            bundle.putString("distanceBearingNGear",Integer.toString(distanceBearingNGear));
            bundle.putString("distanceGearNPulley",Integer.toString(distanceGearNPulley));
            bundle.putString("distancePulleyNBearing",Integer.toString(distancePulleyNBearing));
            bundle.putString("diameterOfPulley",Integer.toString(diameterOfPulley));
            bundle.putString("diameterOfGear",Integer.toString(diameterOfGear));
            bundle.putString("weightOfPulley",Integer.toString(weightOfPulley));
            bundle.putString("permissibleStress",Integer.toString(permissibleStress));
            bundle.putString("pressureAngleOfGear",Integer.toString(pressureAngleOfGear));
            bundle.putString("tensionRatio",Integer.toString(tensionRatio));
            bundle.putString("maxTensionInBelt",Integer.toString(maxTensionInBelt));
            bundle.putString("kForHollowShaft",Integer.toString(kForHollowShaft));
            finalPage.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.frameFragment, finalPage, "finalPage").commit();
            Next.setVisibility(View.INVISIBLE);
        }
}
