package com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma;

import com.example.pmdm02_enriquefernandez.modelo.dominio.Pelicula;
import com.example.pmdm02_enriquefernandez.modelo.negocio.Peliculas;

import java.util.List;

public class Plataforma {

    private String nombrePlataforma;
    private int imagenPlataformaId;
    private Peliculas listadoPeliculas;
    private IdPlataforma id;

    public Plataforma(int imagenId, IdPlataforma id) {
        this.nombrePlataforma = id.toString();
        this.imagenPlataformaId = imagenId;
        listadoPeliculas = new Peliculas();
        this.id = id;
    }

    public void AgregarPelicula(Pelicula pelicula) {
        pelicula.setIdPlataforma(id);
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

    public IdPlataforma getIdPlataforma() {return  id; }

    public int getImagenPlataformaId() {
        return imagenPlataformaId;
    }
}
