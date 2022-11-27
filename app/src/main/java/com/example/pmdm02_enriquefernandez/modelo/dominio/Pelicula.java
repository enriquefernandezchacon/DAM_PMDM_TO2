package com.example.pmdm02_enriquefernandez.modelo.dominio;

import com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma.IdPlataforma;

import java.io.Serializable;

//LOGICA DE UNA PELICULA
public class Pelicula implements Serializable {

    private int id;
    private final String titulo;
    private final int puntuacion;
    private final int portadaId;
    private final int anoPublicacion;
    private final String director;
    private final int duracion;
    private final String sinopsis;
    private IdPlataforma idPlataforma;
    private final String url;

    public Pelicula(String titulo, int puntuacion, int portadaId, int anoPublicacion, String director, int duracion, String sinopsis, String url) {
        this.titulo = titulo;
        this.puntuacion = puntuacion;
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

    public int getPuntuacion() {
        return puntuacion;
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

    public String getUrl() { return url; }
}
