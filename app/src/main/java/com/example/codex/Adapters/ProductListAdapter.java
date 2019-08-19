package com.example.codex.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.codex.R;
import com.example.codex.model.bo.OrderProductMapping;
import com.example.codex.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.RecViewHolder> {
    private List<OrderProductMapping> list;
    private Activity context;

    public ProductListAdapter(List<OrderProductMapping> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    public ProductListAdapter(Activity context) {
        this.context = context;
    }

    public void setList(List<OrderProductMapping> list) {
        System.out.println("Size :-" + list.size());

        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ProductListAdapter.RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println("In  RecyclerView");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_quantity_list, parent, false);
        return new ProductListAdapter.RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecViewHolder holder, final int position) {
        final OrderProductMapping product = list.get(position);

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
            for (OrderProductMapping prod : list) {
                products.add(prod.getProduct_id().getIdProdMaster());
            }
            return products;
        }
        return null;
    }

    public List<Integer> getSelectedProductQuantities() {
        if (list != null && list.size() > 0) {
            List<Integer> quantities = new ArrayList<>();
            for (OrderProductMapping prod : list) {
                quantities.add(prod.getQuantity());
            }
            return quantities;
        }
        return null;
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {

        private TextView productTitle, quantity;


        public RecViewHolder(View itemView) {
            super(itemView);
            productTitle = (TextView) itemView.findViewById(R.id.txtProductTitle);
            quantity = (TextView) itemView.findViewById(R.id.txtProductQuantity);

        }

        private void bind(final OrderProductMapping product) {

            productTitle.setText(product.getProduct_id().getProductApplication());
            quantity.setText(Utility.getString(product.getQuantity()));
            System.out.println("Product quantity " + product.getQuantity() + " for product " + product.getProduct_id().getProductApplication());
        }

    }

    public List<OrderProductMapping> getList() {
        return list;
    }

    public void updateCustomerList(List<OrderProductMapping> product) {
        //setUsers(customers);
        this.list = product;
        notifyDataSetChanged();
    }

    public void addProduct(OrderProductMapping product) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(product);
        notifyDataSetChanged();
    }


}
