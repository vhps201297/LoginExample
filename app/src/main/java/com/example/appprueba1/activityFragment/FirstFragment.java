package com.example.appprueba1.activityFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appprueba1.R;
import com.example.appprueba1.adapterExample.AdapterContacto;
import com.example.appprueba1.models.Contacto;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    List<Contacto> contactos = new ArrayList<>();
    AdapterContacto adapterContacto;
    RecyclerView rvContactos;

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
        adapterContacto = new AdapterContacto(contactos);
        rvContactos.setAdapter(adapterContacto);
    }

    @Override
    public void onStart() {
        super.onStart();
        llenarContactos();
        adapterContacto.notifyDataSetChanged();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        rvContactos = view.findViewById(R.id.recycler_view);
        return view;
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
