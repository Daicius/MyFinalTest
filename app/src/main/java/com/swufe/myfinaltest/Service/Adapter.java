package com.swufe.myfinaltest.Service;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.swufe.myfinaltest.Activity.SecondFragment;
import com.swufe.myfinaltest.Activity.UserFragment;

public class Adapter extends FragmentPagerAdapter {

    public Adapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new UserFragment();
        } else {
            return new SecondFragment();
        }
    }


    @Override
    public int getCount() {
        return 2;
    }
    public CharSequence getPageTitle(int position) {
        return "Title" + position;
    }
}
