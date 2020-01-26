package com.example.appprueba1.adapterExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appprueba1.R;
import com.example.appprueba1.models.Publicacion;

import java.util.List;

public class AdapterPublicacion extends RecyclerView.Adapter<AdapterPublicacion.PublicationViewHolder> {

    private List<Publicacion> publicaciones;

    public AdapterPublicacion(List<Publicacion> publicaciones){
        this.publicaciones = publicaciones;
    }
    @NonNull
    @Override
    public PublicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_publicacion,parent,false);
        return new PublicationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PublicationViewHolder holder, int position) {

        holder.txtNamePropery.setText(publicaciones.get(position).getPropertyName());
        holder.txtDecription.setText(publicaciones.get(position).getDescripcion());
        //holder.imgPublication.setImageBitmap(publicaciones.get(position).getImagePublicacion());


    }

    @Override
    public int getItemCount() {
        return publicaciones.size();
    }

    public class PublicationViewHolder extends RecyclerView.ViewHolder {

        TextView txtNamePropery;
        TextView txtDecription;
        ImageView imgPublication;
        Button btnReaction;
        Button btnComment;
        Button btnShared;

        public PublicationViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNamePropery = itemView.findViewById(R.id.property_name);
            txtDecription = itemView.findViewById(R.id.publication_description);
            imgPublication = itemView.findViewById(R.id.publication_image);
            btnReaction = itemView.findViewById(R.id.reaction);
            btnComment = itemView.findViewById(R.id.comment);
            btnShared = itemView.findViewById(R.id.shared);
        }
    }
}
