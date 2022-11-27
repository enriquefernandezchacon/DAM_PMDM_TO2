package com.example.pmdm02_enriquefernandez.modelo.dominio;

import java.util.Date;

//Clase de apoyo para la lógica del historial
public class Visualizacion {

    private final Pelicula pelicula;
    private final Date fecha;

    public Visualizacion(Pelicula pelicula) {
        this.pelicula = pelicula;
        //LA FECHA SE ESTABLECE EN EL MOMENTO DE CREAR EL OBJETO
        fecha = new Date();
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Date getFecha() {
        return fecha;
    }
}
