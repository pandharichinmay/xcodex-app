package com.example.codex.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.codex.FragmentDetails;
import com.example.codex.FragmentHistory;
import com.example.codex.FragmentFileUpload;

public class TabbedAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public TabbedAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentDetails homeFragment = new FragmentDetails();
                return homeFragment;
            case 1:
                FragmentFileUpload sportFragment = new FragmentFileUpload();
                return sportFragment;
            case 2:
                FragmentHistory movieFragment = new FragmentHistory();
                return movieFragment;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
