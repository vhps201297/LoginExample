package com.example.appprueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtxtUser;
    private EditText edtxtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edtxtPass = findViewById(R.id.edtxt_pass);
        edtxtUser = findViewById(R.id.edtxt_user);

    }

    public void onClickResetPass(View view) {
        startActivity(new Intent(this, ForgotActivity.class));
    }

    public void onClickLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(getString(R.string.str_user), edtxtUser.getText().toString());
        intent.putExtra(getString(R.string.str_pass), edtxtPass.getText().toString());
        startActivity(intent);
    }

    public void onClickMoreIdioms(View view) {
        Toast.makeText(this, R.string.str_error_idioms, Toast.LENGTH_SHORT).show();
    }

    public void onClickRegister(View view) {
        Toast.makeText(this, R.string.str_error_register, Toast.LENGTH_SHORT).show();
    }
}
