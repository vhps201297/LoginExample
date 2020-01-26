package com.example.appprueba1.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.example.appprueba1.LoginActivity;
import com.example.appprueba1.R;
import com.example.appprueba1.models.Peticion;
import com.example.appprueba1.models.SingletonVolley;
import com.example.appprueba1.models.interfaces.LoginCompletion;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Method;

public class Usuario implements Serializable {

    private String nombre;
    private String pass;
    private String fechaNacimiento;
    private RequestQueue requestQueue;
    private Context context;

    // Las preferencias se hacen globales para que puedan guardar todos los datos y cambios del usuario.
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public Usuario(Context context){
        this.context = context;
        requestQueue = SingletonVolley.getInstance(context).getRequestQueue();

    }

    public Usuario(Context context,String nombre, String pass, String nacimiento){
        this.nombre = nombre;
        this.pass = pass;
        this.fechaNacimiento = nacimiento;
        this.context = context;

        requestQueue = SingletonVolley.getInstance(context).getRequestQueue();
        preferences = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        editor = preferences.edit();

    }

    public String getNombre() {
        return preferences.getString("name","");
    }

    // guardamos la onformación dentro del dispositivo
    public void setNombre(String nombre) {
        editor.putString("name",nombre);
        editor.apply();
    }

    // obtenemos la información que guardamos en el dispositivo.
    public String getPass() {
        return preferences.getString("password","");
    }

    public void setPass(String pass) {
        editor.putString("password", pass);
        editor.apply();
    }

    public String getFechaNacimiento() {
        return preferences.getString("nacimiento","");
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        editor.putString("nacimiento", fechaNacimiento);
        editor.apply();
    }

    // Método login, una buena forma de integrar un servicio es que se ejecuten dentro del modelo

    public void doLogin(String email, String user, final LoginCompletion completion){

        Peticion loginRequest = new Peticion(context, requestQueue);
        loginRequest.addParams("email", email);
        loginRequest.addParams("user", user);

        Log.e("URL", URLCodevstack.LOGIN);
        loginRequest.stringRequest(Request.Method.POST, URLCodevstack.LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.i(context.getString(R.string.app_name), response);
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject jsonUser = jsonObject.getJSONObject("user");
                    editor.putString("name", jsonUser.getString("name"));
                    editor.putString("email",jsonUser.getString("email"));
                    completion.loginResponse(null);

                } catch (JSONException e) {
                    e.printStackTrace();
                    completion.loginResponse(ErrorRequest.WEB_SERVICE);
                }
            }
        });
    }

    // integrar servicio de registro y quitar el que se creó dentro de la actividad RegistroActivity

    public void doRegister(String nameUser, String nombre, String email, String password){

    }




}
