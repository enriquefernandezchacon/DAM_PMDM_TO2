package com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma;

import com.example.pmdm02_enriquefernandez.modelo.dominio.Pelicula;
import com.example.pmdm02_enriquefernandez.modelo.negocio.Peliculas;

import java.util.List;

//CLASE QUE CONTROLA LA LOGICA DE UNA PLATAFORMA
public class Plataforma {

    //ATRIBUTOS DE LA CLASE
    private final String nombrePlataforma;
    private final int imagenPlataformaId;
    private final Peliculas listadoPeliculas;
    private final IdPlataforma id;

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
