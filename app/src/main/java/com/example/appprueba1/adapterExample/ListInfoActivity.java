package com.example.appprueba1.adapterExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appprueba1.R;

public class ListInfoActivity extends AppCompatActivity {

    String[] listInfo = {"Info 1","Info 2","info 3","info 3","info 4","info 5","info 6","info 7","info 8"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_info);

        listView = findViewById(R.id.list_view);

    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.item_list_view,R.id.txt_item, listInfo);

        listView.setAdapter(arrayAdapter);
    }
}
