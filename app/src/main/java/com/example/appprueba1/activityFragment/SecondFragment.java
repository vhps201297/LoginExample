package com.example.appprueba1.activityFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appprueba1.R;
import com.example.appprueba1.adapterExample.AdapterPublicacion;
import com.example.appprueba1.models.Publicacion;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    private List<Publicacion> publicaciones = new ArrayList<>();
    private AdapterPublicacion adapterPublicacion;
    private RecyclerView rvPublicacion;

    public SecondFragment() {
        // Required empty public constructor
    }


    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarDatosFake();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        adapterPublicacion = new AdapterPublicacion(publicaciones);
        rvPublicacion = view.findViewById(R.id.rv_publicacion);
        rvPublicacion.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvPublicacion.setAdapter(adapterPublicacion);
        // Inflate the layout for this fragment
        return view;
    }

    public void llenarDatosFake(){
        publicaciones.add(new Publicacion("Codevstack", "Primera publicaion del perfil"));
        publicaciones.add(new Publicacion("Raul Cuevas", "programandoando"));
        publicaciones.add(new Publicacion("José Fernandez", "Buenas noches xD"));
        publicaciones.add(new Publicacion("Juan Rios", "xDDDDDDDDDDDDDDDDDDDDD"));


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
