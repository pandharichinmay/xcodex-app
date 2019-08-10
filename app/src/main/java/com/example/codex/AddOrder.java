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
import com.example.codex.model.bo.CategoryMaster;
import com.example.codex.model.bo.CustomerMaster;
import com.example.codex.model.bo.DepartmentMaster;
import com.example.codex.model.bo.OrderStatusMaster;
import com.example.codex.model.bo.OrderTypeMaster;
import com.example.codex.model.bo.PriorityMaster;
import com.example.codex.model.bo.ProductMaster;
import com.example.codex.model.bo.UserMaster;
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
    private Spinner customerSpinner;
    private Spinner departmentSpinner;
    private Spinner typeSpinner;
    private Spinner categorySpinner;
    private Spinner productSpinner;
    private Spinner assignToSpinner;
    private Spinner prioritySpinner;
    private Spinner statusSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
        customerSpinner = findViewById(R.id.spinnerCustomer);
        departmentSpinner = findViewById(R.id.spinnerDepartment);
        typeSpinner = findViewById(R.id.spinnerType);
        categorySpinner = findViewById(R.id.spinnerCategory);
        productSpinner = findViewById(R.id.spinnerProduct);
        assignToSpinner = findViewById(R.id.spinnerAssignTo);
        prioritySpinner = findViewById(R.id.spinnerPriority);
        statusSpinner = findViewById(R.id.spinnerStatus);

        fetchCustomer();
        fetchDepartment();
        fetchType();
        fetchCategory();
        fetchProduct();
        fetchAssignTo();
        fetchPriority();
        fetchStatus();
    }


    private void fetchAssignTo() {
        System.out.println("In Assign to");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getAllUsers", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("In Responce" +response);
                try {
                    System.out.println("In Try" + response);
                    removeSimpleProgressDialog();
                    Log.d("Users List", ">>" + response);

                    Type listType = new TypeToken<ArrayList<UserMaster>>() {
                    }.getType();

                    List<UserMaster> customers = Utility.fromJson(response, null, listType);
                    if (customers != null && customers.size() > 0) {
                        List<String> names = new ArrayList<>();
                        for (UserMaster cust : customers) {
                            names.add(cust.getUsername());
                        }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddOrder.this, simple_spinner_item, names);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        assignToSpinner.setAdapter(spinnerArrayAdapter);

                    }

                } catch (Exception e) {
                    System.out.println("In catch" + response);
                    e.printStackTrace();
                }
            }
        }, standardErrorListener());

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

    }

    private void fetchDepartment() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getAllDepartment", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    removeSimpleProgressDialog();
                    Log.d("strrrrr", ">>" + response);

                    Type listType = new TypeToken<ArrayList<DepartmentMaster>>() {
                    }.getType();

                    List<DepartmentMaster> customers = Utility.fromJson(response, null, listType);
                    if (customers != null && customers.size() > 0) {
                        List<String> names = new ArrayList<>();
                        for (DepartmentMaster cust : customers) {
                            names.add(cust.getBusiness_unit());
                        }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddOrder.this, simple_spinner_item, names);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        departmentSpinner.setAdapter(spinnerArrayAdapter);

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

    private void fetchType() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getOrderType", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    removeSimpleProgressDialog();
                    Log.d("strrrrr", ">>" + response);

                    Type listType = new TypeToken<ArrayList<OrderTypeMaster>>() {
                    }.getType();

                    List<OrderTypeMaster> customers = Utility.fromJson(response, null, listType);
                    if (customers != null && customers.size() > 0) {
                        List<String> names = new ArrayList<>();
                        for (OrderTypeMaster cust : customers) {
                            names.add(cust.getType());
                        }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddOrder.this, simple_spinner_item, names);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        typeSpinner.setAdapter(spinnerArrayAdapter);

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

    private void fetchCategory() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getAllOrderCategory", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    removeSimpleProgressDialog();
                    Log.d("strrrrr", ">>" + response);

                    Type listType = new TypeToken<ArrayList<CategoryMaster>>() {
                    }.getType();

                    List<CategoryMaster> customers = Utility.fromJson(response, null, listType);
                    if (customers != null && customers.size() > 0) {
                        List<String> names = new ArrayList<>();
                        for (CategoryMaster cust : customers) {
                            names.add(cust.getCategory());
                        }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddOrder.this, simple_spinner_item, names);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        categorySpinner.setAdapter(spinnerArrayAdapter);

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

    private void fetchProduct() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getAllProducts", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    removeSimpleProgressDialog();
                    Log.d("strrrrr", ">>" + response);

                    Type listType = new TypeToken<ArrayList<ProductMaster>>() {
                    }.getType();

                    List<ProductMaster> customers = Utility.fromJson(response, null, listType);
                    if (customers != null && customers.size() > 0) {
                        List<String> names = new ArrayList<>();
                        for (ProductMaster cust : customers) {
                            names.add(cust.getProductApplication());
                        }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddOrder.this, simple_spinner_item, names);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        productSpinner.setAdapter(spinnerArrayAdapter);

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

    private void fetchPriority() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getAllPriority", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    removeSimpleProgressDialog();
                    Log.d("strrrrr", ">>" + response);

                    Type listType = new TypeToken<ArrayList<PriorityMaster>>() {
                    }.getType();

                    List<PriorityMaster> customers = Utility.fromJson(response, null, listType);
                    if (customers != null && customers.size() > 0) {
                        List<String> names = new ArrayList<>();
                        for (PriorityMaster cust : customers) {
                            names.add(cust.getPriority());
                        }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddOrder.this, simple_spinner_item, names);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        prioritySpinner.setAdapter(spinnerArrayAdapter);

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

    private void fetchStatus() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getAllStatus", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    removeSimpleProgressDialog();
                    Log.d("strrrrr", ">>" + response);

                    Type listType = new TypeToken<ArrayList<OrderStatusMaster>>() {
                    }.getType();

                    List<OrderStatusMaster> customers = Utility.fromJson(response, null, listType);
                    if (customers != null && customers.size() > 0) {
                        List<String> names = new ArrayList<>();
                        for (OrderStatusMaster cust : customers) {
                            names.add(cust.getStatus());
                        }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddOrder.this, simple_spinner_item, names);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        statusSpinner.setAdapter(spinnerArrayAdapter);

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

    private void fetchCustomer() {
        //showSimpleProgressDialog(this, "Loading...", "Fetching Json", false);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getAllCustomer", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    removeSimpleProgressDialog();
                    Log.d("strrrrr", ">>" + response);

                    Type listType = new TypeToken<ArrayList<CustomerMaster>>() {
                    }.getType();

                    List<CustomerMaster> customers = Utility.fromJson(response, null, listType);
                    if (customers != null && customers.size() > 0) {
                        List<String> names = new ArrayList<>();
                        for (CustomerMaster cust : customers) {
                            names.add(cust.getCustName());
                        }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(AddOrder.this, simple_spinner_item, names);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        customerSpinner.setAdapter(spinnerArrayAdapter);

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
                System.out.println("In Error Listener" + error);
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
