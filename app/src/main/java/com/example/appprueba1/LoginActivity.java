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
import com.example.appprueba1.models.ErrorRequest;
import com.example.appprueba1.models.Usuario;
import com.example.appprueba1.models.interfaces.LoginCompletion;

public class LoginActivity extends AppCompatActivity {

    private EditText edtxtUser;
    private EditText edtxtPass;
    static int CODE_REQUEST = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edtxtPass = findViewById(R.id.edtxt_pass_login);
        edtxtUser = findViewById(R.id.edtxt_user);

    }

    public void onClickResetPass(View view) {
        startActivity(new Intent(this, ForgotActivity.class));
    }

    public void onClickLogin(View view) {

        final Usuario usuario = new Usuario(this);
        usuario.doLogin(edtxtUser.getText().toString(), edtxtPass.getText().toString(), new LoginCompletion() {
            @Override
            public void loginResponse(ErrorRequest error) {
                if (error == null){
                    Intent intent = new Intent(LoginActivity.this, ParentActivity.class);
                    intent.putExtra(getString(R.string.str_user), usuario);
                    startActivity(intent);
                    finish();
                } else{
                    Log.e(getString(R.string.app_name), "Error en la petición");
                }
            }
        });


    }

    public void onClickMoreIdioms(View view) {
        Toast.makeText(this, R.string.str_error_idioms, Toast.LENGTH_SHORT).show();
    }

    public void onClickRegister(View view) {
        startActivity(new Intent(this, RegistroActivity.class));
        finish();
    }


}
