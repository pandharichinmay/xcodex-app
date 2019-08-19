package com.example.codex;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.codex.Adapters.TabbedAdapter;
import com.example.codex.model.bo.OrderMaster;
import com.example.codex.util.Utility;

public class OrderDetailsActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    private OrderMaster currentOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        String orderJson = getIntent().getStringExtra(Utility.ORDER_KEY);
        currentOrder = Utility.fromJson(orderJson, OrderMaster.class, null);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Details"));
        tabLayout.addTab(tabLayout.newTab().setText("Files"));
        tabLayout.addTab(tabLayout.newTab().setText("History"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final TabbedAdapter adapter = new TabbedAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        adapter.setOrder(currentOrder);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
