package com.example.pmdm02_enriquefernandez.modelo.dominio;

public class Pelicula {

    private int id;
    private String titulo;
    private int puntuación;
    private int portadaId;
    private int fechaPublicacion;
    private String director;
    private int duracion;
    private String sinopsis;

    public Pelicula(String titulo, int puntuación, int portadaId, int fechaPublicacion, String director, int duracion, String sinopsis) {
        this.titulo = titulo;
        this.puntuación = puntuación;
        this.portadaId = portadaId;
        this.fechaPublicacion = fechaPublicacion;
        this.director = director;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
    }

    public void setId(int id) {
        this.id = 0;
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

    public int getFechaPublicacion() {
        return fechaPublicacion;
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
