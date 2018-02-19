package com.colombomobilemeetup.demo1.livedata1;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.colombomobilemeetup.demo1.R;

public class Demo3Activity extends AppCompatActivity {

    private CounterViewModel counterViewModel;

    TextView textViewCount3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textViewCount3 = findViewById(R.id.textViewCount3);
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
        counterViewModel.getCounter().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                textViewCount3.setText(integer.toString());
            }
        });

       /* CounterLiveData.get().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                textViewCount3.setText(integer.toString());
            }
        });*/
    }
}
