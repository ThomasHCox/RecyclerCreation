package com.example.tcox.recyclercreation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tcox on 12/12/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // return super.getPageTitle(position);
        switch (position){
            case 0: return "QA";
            case 1: return "Dev";
            case 2: return "Product";
        }
        return "Tab";
    }

    @Override
    public int getCount() {
        return 4;
    }
}
