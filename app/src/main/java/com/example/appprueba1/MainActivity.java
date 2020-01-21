package com.example.appprueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtSaludo;
    private String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtSaludo = findViewById(R.id.txt_saludo);
        pass = getIntent().getStringExtra(getString(R.string.str_pass));
        user = getIntent().getStringExtra(getString(R.string.str_user));

    }

    @Override
    protected void onResume() {
        super.onResume();

        txtSaludo.setText("Bienvenido " + user + " tu contrase es: " + pass);
    }

    public void onClickBack(View view) {
        onBackPressed();
    }

    public void onClickRemove(View view) {
        finish();
    }

    public void onClickResult(View view) {
        setResult(RESULT_OK);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



}
