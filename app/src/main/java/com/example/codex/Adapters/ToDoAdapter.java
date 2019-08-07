package com.example.codex.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.codex.R;
import com.example.codex.model.Todolist;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.RecViewHolder> {

    private List<Todolist> list;
    private Activity context;

    public ToDoAdapter(List<Todolist> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    public void setList(List<Todolist> list) {
        this.list = list;
    }

    @Override
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_order_row, parent, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecViewHolder holder, final int position) {
        final Todolist movie = list.get(position);

        holder.bind(movie);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                movie.getUser().setCurrentBusiness(currentUser.getCurrentBusiness());
//                context.startActivity(Utility.nextIntent(context, GenericCustomerProfileActivity.class, true, movie.getUser(), Utility.CUSTOMER_KEY));

            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {

        private TextView txtpriorityStatus,txtcategoryStatus;
//        private TextView txtAddress, txtViewprofile;
//        private TextView year;
//        private View subItem;

        public RecViewHolder(View itemView) {
            super(itemView);
            txtpriorityStatus = (TextView) itemView.findViewById(R.id.txtpriorityStatus);
            txtcategoryStatus = (TextView) itemView.findViewById(R.id.txtcategoryStatus);


        }

        private void bind(final Todolist todo) {
            txtpriorityStatus.setText(todo.getName());
            txtcategoryStatus.setText(todo.getName());

        }

    }


    public void updateCustomerList(List<Todolist> todo) {
        //setUsers(customers);
        this.list = todo;
        notifyDataSetChanged();
    }

}
