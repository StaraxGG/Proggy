package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Nicolas on 29.03.2018.
 */

public class FragmentPageMiwokAdapter extends FragmentPagerAdapter {

    public FragmentPageMiwokAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new ColorsFragment();
            case 1: return new FamilyFragment();
            case 2: return new NumbersFragment();
            default: return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0: return "Colors";
            case 1: return "Family";
            case 2: return "Numbers";
            default: return "Phrases";
        }
    }
}
