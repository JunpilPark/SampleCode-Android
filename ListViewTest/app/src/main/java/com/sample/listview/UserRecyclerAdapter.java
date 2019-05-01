package com.sample.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample.listview.model.User;

import java.util.ArrayList;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder>{
    ArrayList<User> userList;

    UserRecyclerAdapter() {
        if(userList == null) {
            userList = new ArrayList<>();
        }
    }

    UserRecyclerAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        this.userList.add(user);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item,  parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int position) {
        userViewHolder.bind(userList.get(position).getName(),
                            userList.get(position).getEmail(),
                            userList.get(position).getMobile());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        TextView txtMail;
        TextView txtMobile;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_value_name);
            txtMail = itemView.findViewById(R.id.txt_value_mail);
            txtMobile = itemView.findViewById(R.id.txt_value_mobile);
        }

        public void bind(String name, String mail, String mobile) {
            txtName.setText(name);
            txtMail.setText(mail);
            txtMobile.setText(mobile);
        }
    }
}
