package com.sample.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.sample.listview.model.User;

public class MainActivity extends AppCompatActivity {

    ListView listViewUser;
    UserAdapter userAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        listViewUser = findViewById(R.id.list_user);
        User user = new User("test1", "테스트","qweqwd@gmail.com", "010-1234-1234");
        userAdapter = new UserAdapter(this);
        userAdapter.addUser(user);
        listViewUser.setAdapter(userAdapter);

        Button btnMoveRecyclerTest = findViewById(R.id.btn_move_recycler_test);
        btnMoveRecyclerTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), RecyclerViewTestActivity.class);
                startActivity(intent);
            }
        });
    }

}
