package com.example.pmdm02_enriquefernandez.modelo.dominio;

import com.example.pmdm02_enriquefernandez.modelo.negocio.Peliculas;

import java.util.List;

public class Plataforma {

    private String nombrePlataforma;
    private int imagenPlataformaId;
    private Peliculas listadoPeliculas;

    public Plataforma(String nombre, int imagenId) {
        this.nombrePlataforma = nombre;
        this.imagenPlataformaId = imagenId;
        listadoPeliculas = new Peliculas();
    }

    public void AgregarPelicula(Pelicula pelicula) {
        listadoPeliculas.AgregarPelicula(pelicula);
    }

    public Pelicula getPelicula(int id) {
        return listadoPeliculas.getPelicula(id);
    }

    public List<Pelicula> getAllPeliculas() {
        return listadoPeliculas.getListaPeliculas();
    }

    public String getNombrePlataforma() {
        return nombrePlataforma;
    }

    public int getImagenPlataformaId() {
        return imagenPlataformaId;
    }
}
