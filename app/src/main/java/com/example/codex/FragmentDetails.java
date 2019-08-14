package com.example.codex;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.codex.Adapters.AddProductAdapter;
import com.example.codex.Adapters.ProductListAdapter;
import com.example.codex.model.bo.OrderMaster;
import com.example.codex.model.bo.OrderProductMapping;
import com.example.codex.model.bo.ProductMaster;
import com.example.codex.util.Utility;

public class FragmentDetails extends Fragment {
    private TextView txtStatusValue, txtPriorityValue, txtDepartmentValue, txtOrderCategory, txtOrderTitle,txtAdminSubmitter, txtAdminAssign, txtDate, txtQuantity, textViewProduct;
    private static ProgressDialog mProgressDialog;
    private RecyclerView productListRecyclerView;
    private ProductListAdapter productListAdapter;
    private OrderProductMapping productMaster;
    private EditText productTitle;

    public FragmentDetails() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_details, container, false);

        txtStatusValue = view.findViewById(R.id.txtStatusValue);
        txtPriorityValue = view.findViewById(R.id.txtPriorityValue);
        txtDepartmentValue = view.findViewById(R.id.txtDepartmentValue);
        txtOrderCategory = view.findViewById(R.id.txtOrderCategory);
        txtAdminSubmitter = view.findViewById(R.id.txtAdminSubmitter);
        txtAdminAssign = view.findViewById(R.id.txtAdminAssign);
        txtDate = view.findViewById(R.id.txtDate);
//        txtQuantity = view.findViewById(R.id.txtQuantity);
//        textViewProduct = view.findViewById(R.id.textViewProduct);


        productListRecyclerView = view.findViewById(R.id.productListRecyclerView);
        productListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        productListAdapter = new ProductListAdapter(getActivity());
        productListRecyclerView.setAdapter(productListAdapter);

        displayOrderDetails();
        return view;

    }


    private void displayOrderDetails() {
        System.out.println("In Assign to");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getOrderDetails/28", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("In Responce" + response);
                removeSimpleProgressDialog();
                Log.d("Display Order By ID ...", ">>" + response);

                OrderMaster orderMasters = Utility.fromJson(response, OrderMaster.class, null);
                if (orderMasters != null) {
                    System.out.println("In If" + response);
                    if (orderMasters.getStatus_id() != null) {
                        txtStatusValue.setText(orderMasters.getStatus_id().getStatus());
                    }
                    if (orderMasters.getPriority_id() != null) {
                        txtPriorityValue.setText(orderMasters.getPriority_id().getPriority());
                    }
                    if (orderMasters.getDepartmentid() != null) {
                        txtDepartmentValue.setText(orderMasters.getDepartmentid().getBusiness_unit());
                    }
                    if (orderMasters.getCategory_id() != null) {
                        txtOrderCategory.setText(orderMasters.getCategory_id().getCategory());
                    }
//                        if (orderMasters.getAdminid() != null) {
//                            txtAdminSubmitter.setText(orderMasters.getAdminid().);
//                        }
                    if (orderMasters.getAssignedTo() != null) {
                        txtAdminAssign.setText(orderMasters.getAssignedTo().getUsername());
                    }
                    if (orderMasters.getOrderCreated_at() != null) {
                        txtDate.setText(Utility.convertDate(orderMasters.getOrderCreated_at(), "MMM dd"));
                    }
                    if (orderMasters.getProducts() != null) {
                        //orderMasters.getProducts();
                        productListAdapter.setList(orderMasters.getProducts());
                    }
                    if(orderMasters.getTitle()!=null)
                    {
                        txtOrderTitle.setText(orderMasters.getTitle());
                    }

//                        if (orderMasters.getProducts() != null) {
//                            txtQuantity.setText(orderMasters.getProducts().ge);
//                        }
//                        if (orderMasters.getCategory_id() != null) {
//                            textViewProduct.setText(orderMasters.getCategory_id().getCategory());
//                        }
                } else {
                    System.out.println("Else Block" + response);
                }


            }


        }, Utility.standardErrorListener(getActivity()));

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

    private void removeSimpleProgressDialog() {
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

}
