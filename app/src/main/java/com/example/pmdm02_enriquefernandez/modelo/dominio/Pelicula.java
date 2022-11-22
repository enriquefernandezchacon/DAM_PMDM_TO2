package com.example.pmdm02_enriquefernandez.modelo.dominio;

import com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma.IdPlataforma;

import java.util.Date;

public class Pelicula {

    private int id;
    private String titulo;
    private int puntuación;
    private int portadaId;
    private int anoPublicacion;
    private String director;
    private int duracion;
    private String sinopsis;
    private IdPlataforma idPlataforma;
    private String url;

    public Pelicula(String titulo, int puntuación, int portadaId, int anoPublicacion, String director, int duracion, String sinopsis, String url) {
        this.titulo = titulo;
        this.puntuación = puntuación;
        this.portadaId = portadaId;
        this.anoPublicacion = anoPublicacion;
        this.director = director;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.url = url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setIdPlataforma(IdPlataforma id) {
        idPlataforma = id;
    }

    public IdPlataforma getIdPlataforma() {
        return idPlataforma;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPuntuación() {
        return puntuación;
    }

    public int getPortada() {
        return portadaId;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }
}
