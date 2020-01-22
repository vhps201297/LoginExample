package com.example.appprueba1;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String pass;
    private String fechaNacimiento;

    public Usuario(String nombre, String pass, String nacimiento){
        this.nombre = nombre;
        this.pass = pass;
        this.fechaNacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }



}
