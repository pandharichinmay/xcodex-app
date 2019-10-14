package com.example.codex.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.codex.model.bo.CategoryMaster;
import com.example.codex.model.bo.CustomerMaster;
import com.example.codex.model.bo.DepartmentMaster;
import com.example.codex.model.bo.DeviceMaster;
import com.example.codex.model.bo.OrderStatusMaster;
import com.example.codex.model.bo.OrderTypeMaster;
import com.example.codex.model.bo.PriorityMaster;
import com.example.codex.model.bo.UserMaster;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.codex.ui.rns.LoginActivity.getToken;

public class Utility {
    //public static final String HOST_URL = "http://332cc3ad.ngrok.io/";

    // public static final String HOST_URL = "http://li961-172.members.linode.com:9090/";
    public static final String HOST_URL = "http://192.168.1.203:8080/";
    public static final String PHP_URL = "http://192.168.1.203/Repo/codex/views/php_services/";
    //public static final String PHP_URL = "http://xcodex.in/views/php_services/";

    public static final String ORDER_KEY = "order";
    private static final String PREF_NAME = "codexPrefs";
    public static final String DATE_FORMAT = "MMM dd hh:mm";

    public static <T> T fromJson(String response, Class<T> cls, Type token) {
        try {
            if (response == null) {
                return null;
            }
            if (token != null) {
                return new Gson().fromJson(response, token);
            } else {
                return new Gson().fromJson(response, cls);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Response.ErrorListener standardErrorListener(final Context ctx) {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //displaying the error in toast if occurrs
                System.out.println("In Error Listener" + error);
                Toast.makeText(ctx, "Error occurred on the server ..", Toast.LENGTH_SHORT).show();
            }
        };
    }

    public static void saveToSharedPref(Activity activity, String keyString, Object object) {
        try {
            SharedPreferences sharedPreferences = activity.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(keyString, new Gson().toJson(object));
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object readFromSharedPref(Activity activity, String key, Class<?> cls) {
        try {
            if (activity == null || key == null) {
                return null;
            }
            SharedPreferences sharedPreferences = activity.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            return fromJson(sharedPreferences.getString(key, null), cls, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String convertDate(Date date, String dateFormat) {
        try {
            return new SimpleDateFormat(dateFormat).format(date);
        } catch (Exception e) {
        }
        return null;
    }

    public static Integer parseInteger(EditText input) {
        try {
            if (!TextUtils.isEmpty(input.getText())) {
                return Integer.valueOf(input.getText().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getString(Integer quantity) {
        if (quantity == null) {
            return "0";
        }
        return quantity.toString();
    }


    public static int getIndexFromList(List list, Object object, String type) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            switch (type) {
                case "User":
                    UserMaster user = (UserMaster) object;
                    UserMaster comparer = (UserMaster) obj;
                    if (user.getIdUser() == comparer.getIdUser()) {
                        return i;
                    }
                    break;
                case "Category":
                    CategoryMaster category = (CategoryMaster) object;
                    CategoryMaster cat1 = (CategoryMaster) obj;
                    if (category.getIdCategory() == cat1.getIdCategory()) {
                        return i;
                    }
                    break;
                case "Department":
                    DepartmentMaster dept = (DepartmentMaster) object;
                    DepartmentMaster dept1 = (DepartmentMaster) obj;
                    if (dept.getIdDept() == dept1.getIdDept()) {
                        return i;
                    }
                    break;
                case "Type":
                    OrderTypeMaster typ = (OrderTypeMaster) object;
                    OrderTypeMaster type1 = (OrderTypeMaster) obj;
                    System.out.println("Comparing .. " + typ.getIdOrdertype() + " with " + type1.getIdOrdertype());
                    if (typ.getIdOrdertype().intValue() == type1.getIdOrdertype().intValue()) {
                        System.out.println("Returning " + i);
                        return i;
                    }
                    break;
                case "Status":
                    OrderStatusMaster status = (OrderStatusMaster) object;
                    OrderStatusMaster status1 = (OrderStatusMaster) obj;
                    if (status.getIdOrderstatus() == status1.getIdOrderstatus()) {
                        return i;
                    }
                    break;
                case "Customer":
                    CustomerMaster cust = (CustomerMaster) object;
                    CustomerMaster cust1 = (CustomerMaster) obj;
                    if (cust.getIdCustomer() == cust1.getIdCustomer()) {
                        return i;
                    }
                    break;
                case "Priority":
                    PriorityMaster pr = (PriorityMaster) object;
                    PriorityMaster pr1 = (PriorityMaster) obj;
                    if (pr.getIdPriority() == pr1.getIdPriority()) {
                        return i;
                    }
                    break;
            }
        }

        return 0;
    }

    public static void setActionBar(String title, ActionBar actionBar) {
        //actionBar.setCustomView(R.layout.layout_app_bar);
        //actionBar.setTitle("My Products");
        actionBar.setTitle(title);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setElevation(0);
    }

    public static void sendTokenToServer(final UserMaster currentUser, Context ctx) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Utility.HOST_URL + "addDevice", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


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
                DeviceMaster device = new DeviceMaster();
                UserMaster user = new UserMaster();
                user.setIdUser(currentUser.getIdUser());
                device.setDeviceId(getToken());
                device.setIdUser(user);
                String str = new Gson().toJson(device);
                return str.getBytes();
            }
        };

        RequestQueue queue = Volley.newRequestQueue(ctx);
        queue.add(stringRequest);
    }
}
