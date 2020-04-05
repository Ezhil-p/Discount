package com.example.discount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Amount, Percentage;
    private Button Calculate;
    private TextView Display, per;
    private SeekBar seekbar;
protected int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Amount = (EditText) findViewById(R.id.et1);

        Calculate = (Button) findViewById(R.id.btn1);
        Display = (TextView) findViewById(R.id.tv1);
        seekbar = (SeekBar) findViewById(R.id.sb1);
        per = (TextView) findViewById(R.id.tv2);
        seekbar.setMax(100);
        seekbar.setProgress(0);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                a=progress;
                per.setText(a+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(Amount.getText().toString()) || TextUtils.isEmpty(per.getText().toString())) {
                    //Toast.makeText(MainActivity.this, "Cannot be Empty", Toast.LENGTH_LONG).show();
                    Amount.setError("Cannot Be Empty");
                } else {
                    double c= Integer.parseInt(Amount.getText().toString());
                    double b = a;
                    double result = c* b / 100;
                    double result1 = c - result;
                    Display.setText("Amount:" + "  " + result1);
                }
            }
        });


    }
}
