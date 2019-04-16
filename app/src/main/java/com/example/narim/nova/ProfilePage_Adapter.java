package com.example.narim.nova;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage_Adapter extends FragmentStatePagerAdapter{
    private List<String> strings=new ArrayList<>();
    private List<Fragment>fragments=new ArrayList<>();

    public ProfilePage_Adapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    /**
     * Add fragment.
     *
     * @param x the x
     * @param y the y
     *   This method add the String x to the list of strings and Fragment y to list fo fragments
     */
    public void AddFragment(String x, Fragment y)
    {
        strings.add(x);
        fragments.add(y);
    }
}