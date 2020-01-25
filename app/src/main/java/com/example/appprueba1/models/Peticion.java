package com.example.appprueba1.models;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class Peticion {

    final RequestQueue requestQueue;
    Context context;

    Map<String,String> params = new HashMap<>();
    Map<String,String> header = new HashMap<>();


    public Peticion(Context context, RequestQueue requestQueue){
        this.context = context;
        this.requestQueue = requestQueue;
    }

    public void stringRequest(int metodo, String url, Response.Listener<String> listener){

        StringRequest stringRequest = new StringRequest(metodo, url, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                new MaterialAlertDialogBuilder(context)
                        .setTitle("Error")
                        .setMessage(error.getMessage())
                        .setPositiveButton("Aceptar",null)
                        .show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if(params == null){
                    return super.getParams();
                } else{
                    return params;
                }
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if(header == null){
                    return super.getHeaders();
                } else{
                    return header;
            }
        }};

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(20000,0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);
    }

    public void stringRequest(int metodo, String url, Response.Listener<String> listener, Response.ErrorListener errorListener){
        StringRequest stringRequest = new StringRequest(metodo,url,listener,errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if(header == null){
                    return super.getHeaders();
                }else {
                    return header;
                }
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if(params == null){
                    return super.getParams();
                } else {
                    return params;
                }
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(20000,0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);

    }

    public void addParams(String clave, String value){
        this.params.put(clave,value);

    }

    public void addHeader(String header, String value){
        this.header.put(header,value);
    }



}
