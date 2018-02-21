package com.colombomobilemeetup.demo2.room;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.colombomobilemeetup.demo2.R;

public class AddEditActivity extends AppCompatActivity {

    EditText editTextFirstName;
    EditText editTextLastName;
    Button save;
    Button delete;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        setupUi();
        int userId = getIntent().getIntExtra("user_id", -1);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        if (userId != -1) {
            userViewModel.getUser(userId).observe(this, user -> {
                if (user != null) {
                    editTextFirstName.setText(user.firstName);
                    editTextLastName.setText(user.lastName);
                }
                userViewModel.setUser(user);
            });
        }

        save.setOnClickListener(v -> saveUser());
        delete.setOnClickListener(v -> deleteUser());
    }

    private void deleteUser() {
        userViewModel.delete();
        finish();
    }

    private void saveUser() {
        String fname = editTextFirstName.getText().toString();
        String lname = editTextLastName.getText().toString();
        if (!fname.isEmpty() && !lname.isEmpty()) {
            userViewModel.save(fname, lname);
            finish();
        }
    }

    private void setupUi() {
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        save = findViewById(R.id.buttonSave);
        delete = findViewById(R.id.buttonDelete);
    }
}
