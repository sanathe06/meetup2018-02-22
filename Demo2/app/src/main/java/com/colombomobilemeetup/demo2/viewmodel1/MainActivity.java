package com.colombomobilemeetup.demo2.viewmodel1;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.colombomobilemeetup.demo2.R;
import com.colombomobilemeetup.demo2.User;
import com.colombomobilemeetup.demo2.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    Button buttonLoad;

    ArrayList<User> users = new ArrayList<>();
    UserAdapter userAdapter;
    private UsersViewModel usersViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        buttonLoad = findViewById(R.id.buttonLoad);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        userAdapter = new UserAdapter(this, users);
        recyclerView.setAdapter(userAdapter);

        usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);

        usersViewModel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                MainActivity.this.users.clear();
                MainActivity.this.users.addAll(users);
                userAdapter.notifyDataSetChanged();
            }
        });

        usersViewModel.getProgress().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean showProgress) {
                if (showProgress) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usersViewModel.refresh();
            }
        });
    }
}
