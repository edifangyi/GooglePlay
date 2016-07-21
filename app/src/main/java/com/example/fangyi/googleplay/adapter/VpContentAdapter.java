package com.example.fangyi.googleplay.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by FANGYI on 2016/7/19.
 */

public class VpContentAdapter extends FragmentStatePagerAdapter {

    private String[] tabNames;

    public VpContentAdapter(FragmentManager fm, String[] tabNames) {
        super(fm);
        this.tabNames = tabNames;
    }

    @Override
    public Fragment getItem(int position) {
        //通过Fragment工厂，生成Fragment
//        if (position == 0) {
//            return new HomeFragment();
//        } else if (position == 1) {
//            return new AppFragment();
//        } else if (position == 2) {
//            return new GameFragment();
//        } else if (position == 3) {
//            return new SubjectFragment();
//        } else if (position == 4) {
//            return new CategoryFragment();
//        } else if (position == 5) {
//            return new TopFragment();
//        } else {
//            return null;
//        }
        return FragmentFactory.createFragment(position);
    }

    //一个有几个条目
    @Override
    public int getCount() {
        return tabNames.length;
    }

    //返回每个条目的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames[position];
    }
}
