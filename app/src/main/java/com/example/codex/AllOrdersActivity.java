package com.example.codex;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.codex.Adapters.ToDoAdapter;
import com.example.codex.model.bo.OrderMaster;
import com.example.codex.model.bo.UserMaster;
import com.example.codex.util.Utility;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AllOrdersActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView allOrders;
    private ToDoAdapter adapter;
    private UserMaster currentUser;
    private FloatingActionButton addOrder;
    private ProgressBar loadingProgressBar;

    private TextView name;
    private TextView subText;
    private android.support.v7.widget.SearchView mSearchView;
    private ArrayList<OrderMaster> employeeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_orders_activity);
        // DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //NavigationView navigationView = findViewById(R.id.nav_view);
        //       ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        System.out.println("In Order Listener..");
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//        navigationView.setNavigationItemSelectedListener(this);
        currentUser = (UserMaster) Utility.readFromSharedPref(this, "user", UserMaster.class);

        //Setup profile
//        name = navigationView.getHeaderView(0).findViewById(R.id.profileName);
//        name.setText(currentUser.getUsername());
//        subText = navigationView.findViewById(R.id.profileSubText);
//        //TODO subText.setText(currentUser.g);


        //     allOrders = drawer.findViewById(R.id.assigned_orders1);
//        allOrders.setLayoutManager(new LinearLayoutManager(this));

        //   addOrder = drawer.findViewById(R.id.btnAddOrder);
//        addOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("In On Click Listener..");
//                loadingProgressBar.setVisibility(View.VISIBLE);
//                startActivity(new Intent(AllOrdersActivity.this, AddOrder.class));
//            }
//        });

        loadingProgressBar = findViewById(R.id.loadingAssignedOrders1);
        //mSearchView = (SearchView) findViewById(R.id.searchView2);
        allOrders = findViewById(R.id.all_orders);

        Utility.setActionBar("All orders", getSupportActionBar());

        //getActionBar().setHomeButtonEnabled(true);
        //setupSearchView();
        loadAllOrders();


    }

    private void setupSearchView() {
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (adapter != null) {
                    adapter.getFilter().filter(s);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (adapter != null) {
                    adapter.getFilter().filter(s);
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("In OnResume..");

        loadAllOrders();
    }

    private void loadAllOrders() {
        Long assignedTo = currentUser.getIdUser();
        System.out.println("In Load Assigned order..");

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getAllOrdersBySearch/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loadingProgressBar.setVisibility(View.GONE);
                try {
                    System.out.println("In Try..");

                    //removeSimpleProgressDialog();
                    Log.d("response", ">>" + response);

                    Type listType = new TypeToken<ArrayList<OrderMaster>>() {
                    }.getType();

                    List<OrderMaster> orders = Utility.fromJson(response, null, listType);
                    if (orders != null && orders.size() > 0) {

                        adapter = new ToDoAdapter(orders, AllOrdersActivity.this);
                        allOrders.setLayoutManager(new LinearLayoutManager(AllOrdersActivity.this));
                        allOrders.setAdapter(adapter);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, Utility.standardErrorListener(this));

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }

    /*@Override
    public void onBackPressed() {

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.user_drawer, menu);
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem item = menu.findItem(R.id.search);
        mSearchView = new android.support.v7.widget.SearchView(getSupportActionBar().getThemedContext());
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        //((EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text)).setTextColor(getResources().getColor(R.color.md_black_1000));
        MenuItemCompat.setActionView(item, mSearchView);


        setupSearchView();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action


        } /*else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
