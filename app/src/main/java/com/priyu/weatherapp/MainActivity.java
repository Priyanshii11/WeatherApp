package com.priyu.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText city;
    Button btn1;
    weatherSingleton weatherSingleton;


    String baseUrl ="https://api.openweathermap.org/data/2.5/weather?q=";

    String Api = "&appid=a0f354fde9591b574b9c3b1f568091ef";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.getcity);
        city = findViewById(R.id.city);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String  val = city.getText().toString();
                if(TextUtils.isEmpty(val)){
                    city.setError(" Enter city name ");
                }
                String myURL = baseUrl + val +Api;

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, myURL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.i("JSON", "JSON" + jsonObject);
                        try{
                            String info = jsonObject.getString("weather");
                            JSONArray ar = new JSONArray(info);

                            for(int i = 0; i < ar.length(); i++)
                            {
                                JSONObject jobj = ar.getJSONObject(i);
                                String myweather = jobj.getString( "main");
                                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                                intent.putExtra("main",myweather);
                                startActivity(intent);
                                Log.i("ID","ID" + jobj.getString("id"));
                                Log.i("MAIN","MAIN" + jobj.getString("main"));
                                Log.i("description","Description" + jobj.getString("description"));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                        error -> Log.i("Error","Something went wrong"+ error)
                );
            com.priyu.weatherapp.weatherSingleton.getInstance(MainActivity.this).addToRequestQueue(jsonObjectRequest);
            }
        });
    }
}
