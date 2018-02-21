package com.colombomobilemeetup.demo2.room;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ProgressBar;

import com.colombomobilemeetup.demo2.R;
import com.colombomobilemeetup.demo2.database.User;
import com.colombomobilemeetup.demo2.utils.OnItemClickListener;
import com.colombomobilemeetup.demo2.utils.UserAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    RecyclerView recyclerView;
    Button buttonNew;

    ArrayList<User> users = new ArrayList<>();
    UserAdapter userAdapter;
    private UsersViewModel usersViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        buttonNew = findViewById(R.id.buttonNew);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        userAdapter = new UserAdapter(this, users, this);
        recyclerView.setAdapter(userAdapter);

        usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);

        usersViewModel.getUsers().observe(this, users -> {
            MainActivity.this.users.clear();
            MainActivity.this.users.addAll(users);
            userAdapter.notifyDataSetChanged();
        });

        buttonNew.setOnClickListener(view -> add());
    }

    private void add() {
        startActivity(new Intent(this,AddEditActivity.class));
    }

    @Override
    public void onClick(User user) {
        Intent intent = new Intent(this, AddEditActivity.class);
        intent.putExtra("user_id",user.id);
        startActivity(intent);
    }
}
