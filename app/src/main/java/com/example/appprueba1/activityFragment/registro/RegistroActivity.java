package com.example.appprueba1.activityFragment.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.appprueba1.LoginActivity;
import com.example.appprueba1.R;

public class RegistroActivity extends AppCompatActivity {

    EditText userName;
    EditText name;
    EditText pass;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        userName = findViewById(R.id.edtxt_user_name);
        name = findViewById(R.id.edtxt_name);
        pass = findViewById(R.id.edtxt_pass);
        email = findViewById(R.id.edtxt_email);
    }

    public void onClickCrearCuenta(View view) {

        // Se integran servicios

    }

    public void onClickTengoCuenta(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
