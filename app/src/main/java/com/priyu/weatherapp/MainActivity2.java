//package com.priyu.weatherapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.android.volley.Request;
//import com.android.volley.toolbox.JsonObjectRequest;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class MainActivity2 extends AppCompatActivity {
//    Button btn;
//    TextView  result;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        btn = findViewById(R.id.goback);
//        result = findViewById(R.id.result);
//        result.setText("weather");
//
//        Bundle bundle =  new Bundle();
//        String value=;
//        bundle.putString("weather", value);
//        Intent intent =new Intent();
//        intent.putExtras(bundle);
//        startActivity(intent);
//
//
//
//        btn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
//                        startActivity(intent);
//                    }
//                });
//
//    }
//}