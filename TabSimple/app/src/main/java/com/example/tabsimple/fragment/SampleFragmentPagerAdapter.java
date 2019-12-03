package com.example.tabsimple.fragment;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    //final int PAGE_COUNT = 3;

    private List<String> tabTitless;


    private String tabTitles[] = new String[] { "Tab  1", "Tab  2", "Tab  3", "tab  4", "tab  5", "tab  6", "tab  7"  };
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context, List<String> tabTitless) {
        super(fm);
        this.context = context;
        this.tabTitless = tabTitless;
    }

    @Override public int getCount() {
        return tabTitless.size();
    }

    @Override public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override public CharSequence getPageTitle(int position) {
        // генерируем заголовок в зависимости от позиции
        return tabTitless.get(position);
    }
}
