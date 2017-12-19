package com.example.suchetaaa.mi_tour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("About"));
        tabLayout.addTab(tabLayout.newTab().setText("Rules and Regulations"));
        tabLayout.addTab(tabLayout.newTab().setText("Code of Conduct"));
        tabLayout.addTab(tabLayout.newTab().setText("Selection Procedure"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new MyAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}

class MyAdapter extends FragmentStatePagerAdapter
{
    int numOfTabs;

    MyAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
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
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    //@Override
    /* public CharSequence getPageTitle(int position) {
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
        return "Default Tab";
    } */
}

