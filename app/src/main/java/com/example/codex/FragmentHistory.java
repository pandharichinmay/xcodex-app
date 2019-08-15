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
import com.example.codex.Adapters.OrderHistoryAdapter;
import com.example.codex.Adapters.ProductListAdapter;
import com.example.codex.Adapters.ToDoAdapter;
import com.example.codex.model.bo.CustomerMaster;
import com.example.codex.model.bo.OrderHistoryLog;
import com.example.codex.model.bo.OrderMaster;
import com.example.codex.model.bo.OrderProductMapping;
import com.example.codex.util.Utility;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FragmentHistory extends Fragment {
    private static ProgressDialog mProgressDialog;
    private RecyclerView orderHistoryRecyclerView;
    private OrderHistoryAdapter orderHistoryAdapter;
    private List<OrderHistoryLog> orderHistoryLog = new ArrayList<>();

    public FragmentHistory() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        orderHistoryRecyclerView = view.findViewById(R.id.orderHistoryRecyclerView);
        orderHistoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        orderHistoryAdapter = new OrderHistoryAdapter(getActivity());
        orderHistoryRecyclerView.setAdapter(orderHistoryAdapter);

        displayOrderHistory();
        return view;
    }

    private void displayOrderHistory() {
        System.out.println("In Assign to " + Utility.HOST_URL + "getOrderHistory/18");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utility.HOST_URL + "getOrderHistory/18", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("In Responce" + response);
                removeSimpleProgressDialog();
                // System.out.println(""+ Err);
                Log.d("Display Order By ID ...", ">>" + response);
//
//                Type listType = new TypeToken<ArrayList<OrderHistoryLog>>() {
//                }.getType();
//
//                orderHistoryLog = Utility.fromJson(response, null, listType);
//
//                if (orderHistoryLog != null) {
//                    System.out.println("In If" + response);
//                    if (orderHistoryLog.getHistoydescription() != null) {
//                        txtTitle.setText(orderHistoryLog.getHistoydescription());
//                    }
//                    if (orderHistoryLog.getComments() != null) {
//                        txtDescription.setText(orderHistoryLog.getComments());
//                    }
//                    if (orderHistoryLog.getTimestamp() != null) {
//                        txtDateYear.setText(Utility.convertDate(orderHistoryLog.getTimestamp(), "MMM dd yyyy"));
//                    }
                //}
                Type listType = new TypeToken<ArrayList<OrderHistoryLog>>() {
                }.getType();

                orderHistoryLog = Utility.fromJson(response, null, listType);
                if (orderHistoryLog != null && orderHistoryLog.size() > 0) {

                    orderHistoryAdapter = new OrderHistoryAdapter(orderHistoryLog, getActivity());
                    orderHistoryRecyclerView.setAdapter(orderHistoryAdapter);
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
