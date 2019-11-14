package com.example.codex.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.codex.R;
import com.example.codex.model.bo.OrderHistoryLog;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.RecViewHolder> {
    private List<OrderHistoryLog> list;
    private Activity context;

    public OrderHistoryAdapter(List<OrderHistoryLog> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    public OrderHistoryAdapter(Activity context) {
        this.context = context;
    }

    public void setList(List<OrderHistoryLog> list) {
        System.out.println("Size :-" + list.size());

        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public OrderHistoryAdapter.RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println("In  RecyclerView");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_history_row, parent, false);
        return new OrderHistoryAdapter.RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecViewHolder holder, final int position) {
        final OrderHistoryLog product = list.get(position);

        holder.bind(product);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                product.getUser().setCurrentBusiness(currentUser.getCurrentBusiness());
//                context.startActivity(Utility.nextIntent(context, GenericCustomerProfileActivity.class, true, product.getUser(), Utility.CUSTOMER_KEY));

            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public List<Long> getSelectedProducts() {
        if (list != null && list.size() > 0) {
            List<Long> products = new ArrayList<>();
            for (OrderHistoryLog prod : list) {
                //    products.add(prod.getProduct_id().getIdProdMaster());
            }
            return products;
        }
        return null;
    }

    public List<Integer> getSelectedProductQuantities() {
        if (list != null && list.size() > 0) {
            List<Integer> quantities = new ArrayList<>();
            for (OrderHistoryLog prod : list) {
                // quantities.add(prod.getHistoydescription());
            }
            return quantities;
        }
        return null;
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {

        private TextView historyTitle, historyDescription, historyDate;


        public RecViewHolder(View itemView) {
            super(itemView);
            historyTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            historyDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            historyDate = (TextView) itemView.findViewById(R.id.txtDateYear);

        }

        private void bind(final OrderHistoryLog product) {

            historyTitle.setText(product.getHistoydescription());

            if (product.getNewStatus() != null && product.getNewStatus().getIdOrderstatus() != null) {
                if (product.getOldStatus() == null || product.getOldStatus().getIdOrderstatus().intValue() != product.getNewStatus().getIdOrderstatus().intValue()) {
                    historyTitle.setText("Changed to " + product.getNewStatus().getStatus());
                }
            }

            if (product.getNewUser() != null && product.getNewUser().getIdUser() != null) {
                if (product.getOldUser() == null || product.getOldUser().getIdUser().intValue() != product.getNewUser().getIdUser().intValue()) {
                    historyTitle.setText("Assigned to " + product.getNewUser().getUsername());
                }
            }

            historyDescription.setText(Html.fromHtml(product.getComments()));
            if (product.getTimestamp() != null) {
                historyDate.setText(DateFormat.format("MMM dd HH:mm", product.getTimestamp()));
            }
            System.out.println("History Title " + product.getHistoydescription());
        }

    }

    public List<OrderHistoryLog> getList() {
        return list;
    }

    public void updateCustomerList(List<OrderHistoryLog> product) {
        //setUsers(customers);
        this.list = product;
        notifyDataSetChanged();
    }

    public void addProduct(OrderHistoryLog product) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(product);
        notifyDataSetChanged();
    }
}
