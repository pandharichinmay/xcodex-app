package com.example.codex.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.codex.R;
import com.example.codex.model.bo.ProductMaster;
import com.example.codex.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.RecViewHolder> {
    private List<ProductMaster> list;
    private Activity context;
    public ProductListAdapter(List<ProductMaster> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    public ProductListAdapter(Activity context) {
        this.context = context;
    }

    public void setList(List<ProductMaster> list) {
        this.list = list;
    }

    @Override
    public ProductListAdapter.RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println("In  RecyclerView");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_quantity_list, parent, false);
        return new ProductListAdapter.RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductListAdapter.RecViewHolder holder, final int position) {
        final ProductMaster product = list.get(position);

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

    public List<Integer> getSelectedProducts() {
        if (list != null && list.size() > 0) {
            List<Integer> products = new ArrayList<>();
            for (ProductMaster prod : list) {
                products.add(prod.getIdProdMaster().intValue());
            }
            return products;
        }
        return null;
    }

    public List<Integer> getSelectedProductQuantities() {
        if (list != null && list.size() > 0) {
            List<Integer> quantities = new ArrayList<>();
            for (ProductMaster prod : list) {
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

        private void bind(final ProductMaster product) {

            productTitle.setText(product.getProductApplication());
            quantity.setText(Utility.getString(product.getQuantity()));
            System.out.println("Adapter prod quantity " + product.getQuantity());
        }

    }

    public List<ProductMaster> getList() {
        return list;
    }

    public void updateCustomerList(List<ProductMaster> product) {
        //setUsers(customers);
        this.list = product;
        notifyDataSetChanged();
    }

    public void addProduct(ProductMaster product) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(product);
        notifyDataSetChanged();
    }


}
