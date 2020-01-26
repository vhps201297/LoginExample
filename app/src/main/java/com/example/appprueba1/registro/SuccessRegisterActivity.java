package com.example.appprueba1.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appprueba1.LoginActivity;
import com.example.appprueba1.R;

public class SuccessRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);
    }

    public void onClickTerminarRegistro(View view) {

        startActivity(new Intent(this, LoginActivity.class));
        setResult(RESULT_OK);
        finish();
    }
}
