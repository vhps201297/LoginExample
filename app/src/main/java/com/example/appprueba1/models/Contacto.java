package com.example.appprueba1.models;

public class Contacto {

    private String name;
    private String descMessage;
    private String urlImage;

    public Contacto(String name, String message){
        this.name = name;
        this.descMessage = message;
        this.urlImage = urlImage;
    }

    public Contacto(String name, String message, String urlImage){
        this.name = name;
        this.descMessage = message;
        this.urlImage = urlImage;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescMessage() {
        return descMessage;
    }

    public void setDescMessage(String descMessage) {
        this.descMessage = descMessage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
