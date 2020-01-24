package com.example.appprueba1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appprueba1.activityFragment.ParentActivity;
import com.example.appprueba1.activityFragment.registro.RegistroActivity;

import java.io.Serializable;

public class LoginActivity extends AppCompatActivity {

    private EditText edtxtUser;
    private EditText edtxtPass;
    static int CODE_REQUEST = 10;

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

        Usuario usuario = new Usuario(edtxtUser.getText().toString(),
                edtxtPass.getText().toString(), "12/12/12");

        Intent intent = new Intent(this, ParentActivity.class);
        intent.putExtra(getString(R.string.str_user), usuario);

        startActivityForResult(intent,CODE_REQUEST);
    }

    public void onClickMoreIdioms(View view) {
        Toast.makeText(this, R.string.str_error_idioms, Toast.LENGTH_SHORT).show();
    }

    public void onClickRegister(View view) {
        Toast.makeText(this, R.string.str_error_register, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, RegistroActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.i("Request",String.valueOf(requestCode));
        Log.i("ResultCode", String.valueOf(resultCode));
    }
}
