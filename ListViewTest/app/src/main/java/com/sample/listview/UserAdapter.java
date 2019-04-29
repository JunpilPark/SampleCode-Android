package com.sample.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sample.listview.model.User;
import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    ArrayList<User> userList;
    Context context;

    UserAdapter(Context context) {
        userList = new ArrayList<>();
        this.context = context;
    }

    UserAdapter(ArrayList userList) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public User getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserViewHolder userViewHolder;
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.user_list_item, parent, false);
            userViewHolder = new UserViewHolder();
            userViewHolder.txtMail = convertView.findViewById(R.id.txt_value_mail);
            userViewHolder.txtName = convertView.findViewById(R.id.txt_value_name);
            userViewHolder.txtMobile = convertView.findViewById(R.id.txt_value_mobile);
            convertView.setTag(userViewHolder);
        }
        else {
            userViewHolder = (UserViewHolder) convertView.getTag();
        }

        userViewHolder.bind(userList.get(position).getName(),
                userList.get(position).getEmail(),
                userList.get(position).getMobile());

        return convertView;
    }

    public void addUser(User user) {
        userList.add(user);
        notifyDataSetChanged();
    }

    public void remove(User user) {
        userList.remove(user);
        notifyDataSetChanged();
    }

    public static class UserViewHolder {
        TextView txtName;
        TextView txtMail;
        TextView txtMobile;

        public void bind(String name, String mail, String mobile) {
            txtName.setText(name);
            txtMail.setText(mail);
            txtMobile.setText(mobile);
        }
    }
}
