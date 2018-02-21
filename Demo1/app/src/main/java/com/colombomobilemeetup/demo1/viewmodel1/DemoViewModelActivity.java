package com.colombomobilemeetup.demo1.viewmodel1;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.colombomobilemeetup.demo1.R;

public class DemoViewModelActivity extends AppCompatActivity {

    TextView textViewCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_view_model);
        textViewCount = findViewById(R.id.textViewCount4);
        ViewModelProviders
                .of(this)
                .get(CounterViewModel.class)
                .counterLiveData.observe(this, integer -> textViewCount.setText(integer.toString()));
    }
}
