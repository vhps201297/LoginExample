package com.example.appprueba1.models;

import android.graphics.Bitmap;
import android.widget.Button;

public class Publicacion {

    private String propertyName;
    private String descripcion;
    private Bitmap imagePublicacion;
    private int numReactions;

    public Publicacion(String propertyName, String descripcion){
        this.propertyName = propertyName;
        this.descripcion = descripcion;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Bitmap getImagePublicacion() {
        return imagePublicacion;
    }

    public void setImagePublicacion(Bitmap imagePublicacion) {
        this.imagePublicacion = imagePublicacion;
    }

    public int getNumReactions() {
        return numReactions;
    }

    public void setNumReactions(int numReactions) {
        this.numReactions = numReactions;
    }
}
