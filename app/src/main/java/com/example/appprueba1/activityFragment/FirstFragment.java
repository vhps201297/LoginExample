package com.example.appprueba1.activityFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appprueba1.R;
import com.example.appprueba1.models.Contacto;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    List<Contacto> contactos = new ArrayList<>();

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        llenarContactos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }


    public void llenarContactos(){
        contactos.add(new Contacto("Juan Carlos","mensaje nuevo"));
        contactos.add(new Contacto("Raul Eduardo","mensaje nuevo"));
        contactos.add(new Contacto("Ruben Castillo","mensaje nuevo"));
        contactos.add(new Contacto("Brandon Juarez","mensaje nuevo"));
        contactos.add(new Contacto("Alberto Sánchez","mensaje nuevo"));
        contactos.add(new Contacto("Noelia Ramirez","mensaje nuevo"));
        contactos.add(new Contacto("Lizet Hernández","mensaje nuevo"));
        contactos.add(new Contacto("Aylin Derbez","mensaje nuevo"));
        contactos.add(new Contacto("Sandra Carvajal","mensaje nuevo"));

    }


}
