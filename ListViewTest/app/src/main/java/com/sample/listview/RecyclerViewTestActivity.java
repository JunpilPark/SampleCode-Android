package com.sample.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sample.listview.model.User;

public class RecyclerViewTestActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UserRecyclerAdapter userRecyclerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_test_activity);
        recyclerView = findViewById(R.id.recycler_user);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getBaseContext(), layoutManager.getOrientation());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

        User user = new User("test2", "테스트2","test2@gmail.com", "010-1234-1234");
        userRecyclerAdapter = new UserRecyclerAdapter();
        recyclerView.setAdapter(userRecyclerAdapter);

        userRecyclerAdapter.addUser(user);
        User user2 = new User("test3", "테스트3","test3@gmail.com", "010-1234-1235");
        userRecyclerAdapter.addUser(user2);
    }
}


