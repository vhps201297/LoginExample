package com.example.appprueba1.adapterExample;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appprueba1.R;
import com.example.appprueba1.models.Contacto;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterContacto extends RecyclerView.Adapter<AdapterContacto.ContactoViewHolder>{

    private List<Contacto> contactos;

    public AdapterContacto(List<Contacto> contactos){
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View view = new
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        holder.message.setText(contactos.get(position).getDescMessage());
        holder.nameContacto.setText(contactos.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView nameContacto;
        TextView message;
        CircleImageView imgContacto;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            nameContacto = itemView.findViewById(R.id.txt_name_contact);
            message = itemView.findViewById(R.id.txt_message);
            imgContacto = itemView.findViewById(R.id.img_icon);
        }
    }
}
