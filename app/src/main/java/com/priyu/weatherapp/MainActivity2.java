package com.priyu.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity2 extends AppCompatActivity {
    Button btn;
    TextView  result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = findViewById(R.id.goback);
        result = findViewById(R.id.result);

        String value = getIntent().getStringExtra("main");
        result.setText(value);

        btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

    }
}