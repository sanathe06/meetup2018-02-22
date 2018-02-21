package com.colombomobilemeetup.demo1.lifecycle3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.colombomobilemeetup.demo1.CountChangeListener;
import com.colombomobilemeetup.demo1.R;

public class Demo3Activity extends AppCompatActivity implements CountChangeListener {

    TextView textViewCount;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_23);
        textViewCount = findViewById(R.id.textViewCount);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count",0);
        }
        CounterWithState.bind(this, this,count);
    }

    @Override
    public void onCount(final int count) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Demo3Activity.this.count = count;
                textViewCount.setText("" + count);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",count);
    }
}
