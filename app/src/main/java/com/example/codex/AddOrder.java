package com.example.codex;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.codex.Adapters.AddProductAdapter;
import com.example.codex.model.bo.CategoryMaster;
import com.example.codex.model.bo.CustomerMaster;
import com.example.codex.model.bo.DepartmentMaster;
import com.example.codex.model.bo.OrderMaster;
import com.example.codex.model.bo.OrderStatusMaster;
import com.example.codex.model.bo.OrderTypeMaster;
import com.example.codex.model.bo.PriorityMaster;
import com.example.codex.model.bo.ProductMaster;
import com.example.codex.model.bo.UserMaster;
import com.example.codex.model.php.UpdateOrderRequest;
import com.example.codex.util.Utility;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private RecyclerView productsRecyclerView;
    private TextView addProductButton;
    private AddProductAdapter addProductAdapter;
    private EditText quantity;
    private Button saveOrder;
    private EditText orderTitle;
    private OrderMaster currentOrder;

    //Response Lists
    private List<ProductMaster> products = new ArrayList<>();
    private List<UserMaster> users = new ArrayList<>();
    private List<OrderTypeMaster> types = new ArrayList<>();
    private List<OrderStatusMaster> statuses = new ArrayList<>();
    private List<CategoryMaster> categories = new ArrayList<>();
    private List<DepartmentMaster> departments = new ArrayList<>();
    private List<CustomerMaster> customers = new ArrayList<>();
    private List<PriorityMaster> priorities = new ArrayList<>();
    private UserMaster currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        currentUser = (UserMaster) Utility.readFromSharedPref(this, "user", UserMaster.class);

        String orderJson = getIntent().getStringExtra(Utility.ORDER_KEY);
        currentOrder = Utility.fromJson(orderJson, OrderMaster.class, null);


        customerSpinner = findViewById(R.id.spinnerCustomer);
        departmentSpinner = findViewById(R.id.spinnerDepartment);
        typeSpinner = findViewById(R.id.spinnerType);
        categorySpinner = findViewById(R.id.spinnerCategory);
        productSpinner = findViewById(R.id.spinnerProduct);
        assignToSpinner = findViewById(R.id.spinnerAssignTo);
        prioritySpinner = findViewById(R.id.spinnerPriority);
        statusSpinner = findViewById(R.id.spinnerStatus);
        quantity = findViewById(R.id.productQuantity);
        saveOrder = findViewById(R.id.btnCreateOrder);
        saveOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveOrder();
            }
        });

        productsRecyclerView = findViewById(R.id.recyclerProducts);
        productsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        addProductAdapter = new AddProductAdapter(AddOrder.this);
        productsRecyclerView.setAdapter(addProductAdapter);

        addProductButton = findViewById(R.id.txtAddProduct);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProductMaster prod = products.get(productSpinner.getSelectedItemPosition());
                if (prod != null) {
                    prod.setQuantity(Utility.parseInteger(quantity));
                    System.out.println("Prod quantity => " + prod.getQuantity() + " == " + quantity.getText());
                    if (addProductAdapter == null) {
                        addProductAdapter = new AddProductAdapter(AddOrder.this);
                        productsRecyclerView.setAdapter(addProductAdapter);
                    }
                    addProductAdapter.addProduct(prod);
                }

            }
        });

        orderTitle = findViewById(R.id.order);

        fetchCustomer();
        fetchDepartment();
        fetchType();
        fetchCategory();
        fetchProduct();
        fetchAssignTo();
        fetchPriority();
        fetchStatus();
    }

    private void saveOrder() {
        final UpdateOrderRequest request = new UpdateOrderRequest();
        request.setAssign_to(assignToSpinner.getSelectedItemPosition());
        request.setCategory(categorySpinner.getSelectedItemPosition());
        request.setCustomer_id(customerSpinner.getSelectedItemPosition());
        request.setDepartmentid(departmentSpinner.getSelectedItemPosition());
        request.setPriority(prioritySpinner.getSelectedItemPosition());
        request.setStatus(statusSpinner.getSelectedItemPosition());
        request.setTicket_type(typeSpinner.getSelectedItemPosition());
        request.setProductsList(addProductAdapter.getSelectedProducts());
        request.setProductQuantity(addProductAdapter.getSelectedProductQuantities());
        request.setTitle(orderTitle.getText().toString());
        request.setUserid(currentUser.getIdUser());
        request.setUsername(currentUser.getUsername());
        request.setSubmitter_id(currentUser.getIdUser().toString());
        request.setStartDate("");
        request.setEndDate("");
        request.setClosureCode("");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Utility.PHP_URL + "add_order_service.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(AddOrder.this, "Save Successful..!", Toast.LENGTH_LONG).show();
                System.out.println("Added successfully .. " + response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    //loadingProgressBar.setVisibility(View.GONE);
                    System.out.println("Error Message.." + error.getMessage());

                    Toast.makeText(AddOrder.this, "Some error occurred on the server .. ", Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(AddOrder.this, "Some error occurred on the server .. ", Toast.LENGTH_LONG).show();
                }

            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String str = new Gson().toJson(request);
                return str.getBytes();
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }

    private ProductMaster findProductByName(String productName) {
        if (products != null && products.size() > 0) {
            for (ProductMaster prod : products) {
                if (prod.getProductApplication() != null && prod.getProductApplication().equals(productName)) {
                    return prod;
                }
            }
        }
        return null;

    }


    private void fetchAssignTo() {
        System.out.println("In Assign to");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getAllUsers", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("In Responce" + response);
                try {
                    System.out.println("In Try" + response);
                    removeSimpleProgressDialog();
                    Log.d("Users List", ">>" + response);

                    Type listType = new TypeToken<ArrayList<UserMaster>>() {
                    }.getType();

                    List<UserMaster> userList = Utility.fromJson(response, null, listType);
                    if (userList != null && userList.size() > 0) {
                        users = userList;
                        List<String> names = new ArrayList<>();
                        for (UserMaster cust : userList) {
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
        }, Utility.standardErrorListener(this));

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
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

                    List<DepartmentMaster> departmentList = Utility.fromJson(response, null, listType);
                    if (departmentList != null && departmentList.size() > 0) {
                        departments = departmentList;
                        List<String> names = new ArrayList<>();
                        for (DepartmentMaster cust : departmentList) {
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
        }, Utility.standardErrorListener(this));

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

                    List<OrderTypeMaster> orderTypeList = Utility.fromJson(response, null, listType);
                    if (orderTypeList != null && orderTypeList.size() > 0) {
                        types = orderTypeList;
                        List<String> names = new ArrayList<>();
                        for (OrderTypeMaster cust : orderTypeList) {
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
        }, Utility.standardErrorListener(this));

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

                    List<CategoryMaster> categoryList = Utility.fromJson(response, null, listType);
                    if (categoryList != null && categoryList.size() > 0) {
                        categories = categoryList;
                        List<String> names = new ArrayList<>();
                        for (CategoryMaster cust : categoryList) {
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
        }, Utility.standardErrorListener(this));

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

                    List<ProductMaster> productList = Utility.fromJson(response, null, listType);
                    if (productList != null && productList.size() > 0) {
                        products = productList;
                        List<String> names = new ArrayList<>();
                        for (ProductMaster cust : productList) {
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
        }, Utility.standardErrorListener(this));

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

                    priorities = Utility.fromJson(response, null, listType);
                    if (priorities != null && priorities.size() > 0) {
                        List<String> names = new ArrayList<>();
                        for (PriorityMaster cust : priorities) {
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
        }, Utility.standardErrorListener(this));

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

                    statuses = Utility.fromJson(response, null, listType);
                    if (statuses != null && statuses.size() > 0) {
                        List<String> names = new ArrayList<>();
                        for (OrderStatusMaster cust : statuses) {
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
        }, Utility.standardErrorListener(this));

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
        }, Utility.standardErrorListener(this));

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
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
