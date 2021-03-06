package com.example.playground.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.playground.activitys.Frags.fragment.CardFragment;
import com.example.playground.activitys.Frags.fragment.ChatFragment;
import com.example.playground.activitys.Frags.fragment.TextFragment;
import com.example.playground.activitys.Frags.fragment.UIFragment;

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    private String mWordUpdated;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //call this method to update fragments in ViewPager dynamically
    public void update(String word) {
        this.mWordUpdated = word;
        notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        //don't return POSITION_NONE, avoid fragment recreation.
        return super.getItemPosition(object);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment = null;
        switch (position){
            case 0 : fragment = TextFragment.newInstance("","");
                break;
            case 1 : fragment = CardFragment.newInstance("","");
                break;
            case 2 : fragment = UIFragment.newInstance("","");
                break;
            case 3 : fragment = ChatFragment.newInstance("","");
                break;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Text";
            case 1:
                return "Card";
            case 2:
                return "UI";
            case 3:
                return "Chat";
        }
        return null;
    }
}