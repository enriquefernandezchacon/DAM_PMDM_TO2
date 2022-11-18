package com.example.pmdm02_enriquefernandez.modelo.negocio;

import com.example.pmdm02_enriquefernandez.modelo.dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Peliculas {

    private List<Pelicula> peliculas;

    public Peliculas() {
        peliculas = new ArrayList<>();
    }

    public void AgregarPelicula(Pelicula pelicula) {
        pelicula.setId(peliculas.size());
        peliculas.add(pelicula);
    }

    public Pelicula getPelicula(int id) {
        return peliculas.get(id);
    }

    public List<Pelicula> getListaPeliculas() {
        return peliculas;
    }

}
