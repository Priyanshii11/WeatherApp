package com.priyu.weatherapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class weatherSingleton {
    private static weatherSingleton weatherSingleton;
    private RequestQueue requestQueue;
    private static Context txt;
    private weatherSingleton( Context context){
        txt = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(txt.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized weatherSingleton getInstance(Context context){
        if (weatherSingleton==null){
            weatherSingleton = new weatherSingleton(context);
        }
        return weatherSingleton;
    }
    public void addToRequestQueue(Request request) {
        requestQueue.add(request);
    }
}
