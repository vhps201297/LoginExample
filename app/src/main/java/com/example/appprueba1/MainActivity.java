package com.example.appprueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.appprueba1.models.Usuario;

public class MainActivity extends AppCompatActivity {

    private TextView txtSaludo;
    private String user, pass;
    private Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtSaludo = findViewById(R.id.txt_saludo);

        usuario = (Usuario) getIntent().getSerializableExtra(getString(R.string.str_user));

    }

    @Override
    protected void onResume() {
        super.onResume();

        if(usuario != null)
            txtSaludo.setText("Bienvenido " + usuario.getNombre() + " tu contrase es: " + usuario.getPass());
    }

    public void onClickBack(View view) {
        onBackPressed();
    }

    public void onClickRemove(View view) {
        finish();
    }

    public void onClickResult(View view) {
        setResult(RESULT_OK);
        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



}
