package com.example.codex;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.codex.model.bo.CustomerMaster;
import com.example.codex.util.Utility;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_spinner_item;

public class AddOrder extends AppCompatActivity {
    private static ProgressDialog mProgressDialog;
    private ArrayList<CustomerMaster> goodModelArrayList;
    private ArrayList<String> names = new ArrayList<String>();
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
        spinner = findViewById(R.id.spinnerCustomer);

        retrieveJSON();

    }

    private void retrieveJSON() {
        //showSimpleProgressDialog(this, "Loading...", "Fetching Json", false);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getAllCustomer", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    removeSimpleProgressDialog();
                    Log.d("strrrrr", ">>" + response);

                    Type listType = new TypeToken<ArrayList<CustomerMaster>>(){}.getType();

                    List<CustomerMaster> customers = Utility.fromJson(response, null, listType);
                    if (customers != null && customers.size() > 0) {
                        List<String> names = new ArrayList<>();
                        for(CustomerMaster cust: customers) {
                            names.add(cust.getCustName());
                        }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddOrder.this, simple_spinner_item, names);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        spinner.setAdapter(spinnerArrayAdapter);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, standardErrorListener());

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }

    private Response.ErrorListener standardErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //displaying the error in toast if occurrs
                Toast.makeText(getApplicationContext(), "Error occurred on the server ..", Toast.LENGTH_SHORT).show();
            }
        };
    }

    public static void removeSimpleProgressDialog() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                    mProgressDialog = null;
                }
            }
        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();

        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSimpleProgressDialog(Context context, String title, String msg, boolean isCancelable) {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(context, title, msg);
                mProgressDialog.setCancelable(isCancelable);
            }

            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }

        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
