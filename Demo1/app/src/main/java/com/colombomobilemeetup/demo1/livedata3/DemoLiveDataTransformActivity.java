package com.colombomobilemeetup.demo1.livedata3;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.colombomobilemeetup.demo1.R;

public class DemoLiveDataTransformActivity extends AppCompatActivity {

    private TextViewModel textViewModel;

    TextView textViewOutput;
    TextView textViewOutput2;
    EditText editTextInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo4);


        textViewOutput = findViewById(R.id.textViewOutPut);
        textViewOutput2 = findViewById(R.id.textViewOutput2);
        editTextInput = findViewById(R.id.editTextInput);
        editTextInput.addTextChangedListener(textWatcher);

        textViewModel = ViewModelProviders.of(this).get(TextViewModel.class);

        textViewModel.capsWithSwitchMap.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textViewOutput.setText(s);
            }
        });

        textViewModel.capsWithMap.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                textViewOutput2.setText("Length :" + integer);
            }
        });


    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textViewModel.setInput(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
