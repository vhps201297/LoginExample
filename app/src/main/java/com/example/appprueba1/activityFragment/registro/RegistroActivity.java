package com.example.appprueba1.activityFragment.registro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appprueba1.LoginActivity;
import com.example.appprueba1.R;
import com.example.appprueba1.models.Peticion;
import com.example.appprueba1.models.URLCodevstack;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {

    EditText userName;
    EditText name;
    EditText pass;
    EditText email;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    private static final String REGISTER_TAG = "Registro";
    public static final int REGISTER_CODE = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        userName = findViewById(R.id.edtxt_user_name);
        name = findViewById(R.id.edtxt_name);
        pass = findViewById(R.id.edtxt_password);
        email = findViewById(R.id.edtxt_email);
        preferences = getSharedPreferences("register_user", Context.MODE_PRIVATE);
        editor = preferences.edit();


    }

    public void onClickCrearCuenta(View view) {

        if (userName.getText().toString().isEmpty()) {
            new MaterialAlertDialogBuilder(this)
                    .setTitle(getString(R.string.app_name))
                    .setMessage("Debe de ingresar el nombre de usuario")
                    .setPositiveButton("Aceptar", null)
                    .show();
        } else if (name.getText().toString().isEmpty()) {
            new MaterialAlertDialogBuilder(this)
                    .setTitle(getString(R.string.app_name))
                    .setMessage("Debe de ingresar su nombre")
                    .setPositiveButton("Aceptar", null)
                    .show();
        } else if (email.getText().toString().isEmpty()) {
            new MaterialAlertDialogBuilder(this)
                    .setTitle(getString(R.string.app_name))
                    .setMessage("Debe de ingresar el email")
                    .setPositiveButton("Aceptar", null)
                    .show();
        } else {
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            // String url = getString(R.string.url_registro);
            String url = URLCodevstack.REGISTRO; // se obtiene el url de la clase

            //setRegister();

            Peticion peticionRegistro = new Peticion(this, requestQueue);

            peticionRegistro.addParams("user_name", userName.getText().toString());
            peticionRegistro.addParams("name", name.getText().toString());
            peticionRegistro.addParams("email", email.getText().toString());
            peticionRegistro.addParams("password", pass.getText().toString());

            peticionRegistro.stringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        Log.i(REGISTER_TAG, "Ok response: " + response);

                        JSONObject jsonUser = jsonObject.getJSONObject("user");
                        editor.putString("nombre_usuario",jsonUser.getString("user_name"));
                        editor.putString("nombre",jsonUser.getString("name"));
                        editor.putString("email",jsonUser.getString("email"));
                        editor.putString("password",jsonUser.getString("password"));
                        editor.apply();

                        Intent intent = new Intent(RegistroActivity.this, SuccessRegisterActivity.class);
                        startActivityForResult(intent,REGISTER_CODE);

                        // startActivity();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e(getString(R.string.app_name),e.getMessage());
                    }
                }
            });
        }


        // Se integran servicios


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REGISTER_CODE && resultCode == RESULT_OK){
            finish();
        }
    }

    public void onClickTengoCuenta(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

}
