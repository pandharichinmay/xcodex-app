package com.example.codex.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.codex.AddOrder;
import com.example.codex.OrderDetailsActivity;
import com.example.codex.R;
import com.example.codex.model.bo.OrderMaster;
import com.example.codex.util.Utility;
import com.google.gson.Gson;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.RecViewHolder> {

    private List<OrderMaster> list;
    private Activity context;

    public ToDoAdapter(List<OrderMaster> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    public void setList(List<OrderMaster> list) {
        this.list = list;
    }

    @Override
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_order_row, parent, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecViewHolder holder, final int position) {
        final OrderMaster order = list.get(position);

        holder.bind(order);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                Intent intent = new Intent(context, OrderDetailsActivity.class);
                intent.putExtra(Utility.ORDER_KEY, new Gson().toJson(order));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {

        private TextView txtpriorityStatus, txtcategoryStatus;
        private TextView orderTitle, dueDate;
        private TextView status;
        private ImageView editButton;

        public RecViewHolder(View itemView) {
            super(itemView);
            txtpriorityStatus = (TextView) itemView.findViewById(R.id.txtOrderPriority);
            txtcategoryStatus = (TextView) itemView.findViewById(R.id.txtOrderCategory);
            orderTitle = (TextView) itemView.findViewById(R.id.txtOrderTitle);
            dueDate = (TextView) itemView.findViewById(R.id.txtDueDate);
            status = (TextView) itemView.findViewById(R.id.btnOrderStatus);
            editButton = (ImageView) itemView.findViewById(R.id.btnEditOrder);
        }

        private void bind(final OrderMaster todo) {

            if (todo.getPriority_id() != null) {
                txtpriorityStatus.setText(todo.getPriority_id().getPriority());
            }
            if (todo.getCategory_id() != null) {
                txtcategoryStatus.setText(todo.getCategory_id().getCategory());
            }

            orderTitle.setText(todo.getTitle());
            dueDate.setText(Utility.convertDate(todo.getDue_date(), Utility.DATE_FORMAT));
            if (todo.getStatus_id() != null) {
                status.setText(todo.getStatus_id().getStatus());
            }

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, AddOrder.class);
                    intent.putExtra(Utility.ORDER_KEY, new Gson().toJson(todo));
                    context.startActivity(intent);
                }
            });

        }

    }


    public void updateCustomerList(List<OrderMaster> todo) {
        //setUsers(customers);
        this.list = todo;
        notifyDataSetChanged();
    }

}
