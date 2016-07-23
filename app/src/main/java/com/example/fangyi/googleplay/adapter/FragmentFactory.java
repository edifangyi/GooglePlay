package com.example.fangyi.googleplay.adapter;

import com.example.fangyi.googleplay.base.BaseFragment;
import com.example.fangyi.googleplay.fragment.AppFragment;
import com.example.fangyi.googleplay.fragment.CategoryFragment;
import com.example.fangyi.googleplay.fragment.GameFragment;
import com.example.fangyi.googleplay.fragment.HomeFragment;
import com.example.fangyi.googleplay.fragment.SubjectFragment;
import com.example.fangyi.googleplay.fragment.TopFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FANGYI on 2016/7/19.
 */

public class FragmentFactory {

    private static Map<Integer, BaseFragment> mFragments = new HashMap<Integer, BaseFragment>();

    public static BaseFragment createFragment(int position) {
        BaseFragment fragment;
        fragment = mFragments.get(position);  //在集合中取出来Fragment
        if (fragment == null) {  //如果再集合中没有取出来 需要重新创建
            if (position == 0) {
                fragment = new HomeFragment();
            } else if (position == 1) {
                fragment = new AppFragment();
            } else if (position == 2) {
                fragment = new GameFragment();
            } else if (position == 3) {
                fragment = new SubjectFragment();
            } else if (position == 4) {
                fragment = new CategoryFragment();
            } else if (position == 5) {
                fragment = new TopFragment();
            }
            if (fragment != null) {
                mFragments.put(position, fragment);// 把创建好的Fragment存放到集合中缓存起来
            }
        }
        return fragment;

    }

//    public static BaseFragment createFragment(int position) {
//
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
//    }
}
