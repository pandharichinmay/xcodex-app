package com.example.codex.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.codex.FragmentDetails;
import com.example.codex.FragmentHistory;
import com.example.codex.FragmentFileUpload;
import com.example.codex.model.bo.OrderMaster;

public class TabbedAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;
    private OrderMaster order;

    public TabbedAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    public void setOrder(OrderMaster order) {
        this.order = order;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentDetails homeFragment = new FragmentDetails();
                homeFragment.setCurrentOrder(order);
                return homeFragment;
            case 1:
                FragmentFileUpload filesFragment = new FragmentFileUpload();
                return filesFragment;
            case 2:
                FragmentHistory historyFragment = new FragmentHistory();
                historyFragment.setCurrentOrder(order);
                return historyFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
