package com.example.appprueba1.models;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

// Singleton que nos ayudará a realizar una sola intancia de requestQueue.
public class SingletonVolley {

    private RequestQueue requestQueue = null;
    private Context context;

    private static SingletonVolley ourInstance = null;

    public static SingletonVolley getInstance(Context context) {
        if(ourInstance == null){
            return new SingletonVolley(context);
        } else{
            return ourInstance;
        }
    }

    private SingletonVolley(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }
    public RequestQueue getRequestQueue(){
        if (requestQueue == null){
            return Volley.newRequestQueue(context.getApplicationContext());
        } else{
            return requestQueue;
        }
    }
}
