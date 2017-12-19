package com.example.suchetaaa.mi_tour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity
{
    ViewPager viewPager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter());
    }
}

class MyAdapter extends FragmentPagerAdapter
{

    MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        if(i==0)
        {
            fragment = new About();
        }
        if(i==1)
        {
            fragment = new RulesnReg();
        }
        if(i==2)
        {
            fragment = new CodeofConduct();
        }
        if(i==3)
        {
            fragment = new SelProcedure();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0) {
            return "About";
        }
        if(position==1) {
            return "Rules and Regulations";
        }
        if(position==2) {
            return "Code of Conduct";
        }
        if(position==3) {
            return "Selection Procedure";
        }
    }
}

