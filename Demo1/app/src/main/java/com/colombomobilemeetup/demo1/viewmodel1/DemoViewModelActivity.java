package com.colombomobilemeetup.demo1.viewmodel1;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.colombomobilemeetup.demo1.R;

public class DemoViewModelActivity extends AppCompatActivity {

    private CounterViewModel counterViewModel;

    TextView textViewCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_view_model);

        textViewCount = findViewById(R.id.textViewCount4);
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
        counterViewModel.counterLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                textViewCount.setText(integer.toString());
            }
        });
    }
}
