package com.marvelvsdc.brian.marvelvsdc.modelos;

public class Personaje {

    String urlImagen;
    String nombre;
    Integer tipo;

    public Personaje(String urlImagen, String nombre, Integer tipo) {
        this.urlImagen = urlImagen;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
