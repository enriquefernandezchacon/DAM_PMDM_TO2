package com.example.pmdm02_enriquefernandez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmdm02_enriquefernandez.modelo.dominio.Pelicula;
import com.example.pmdm02_enriquefernandez.modelo.dominio.Visualizacion;
import com.example.pmdm02_enriquefernandez.modelo.negocio.Historial;

public class PeliculaActivity extends AppCompatActivity {

    private Pelicula pelicula;
    private boolean primeraReproduccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);
        //CENTINELA PARA EL HISTORIAL DE REPRODUCCION
        primeraReproduccion = true;

        //CARGO CADA DATO EN SU ELEMENTO CORRESPONDIENTE
        Intent intent = getIntent();
        pelicula = (Pelicula) intent.getSerializableExtra("PELICULA");

        ImageView portada = findViewById(R.id.ivPeliculaPortada);
        portada.setImageResource(pelicula.getPortada());

        ImageView rating = findViewById(R.id.ivPeliculaRating);
        rating.setImageResource(getImagenRating(pelicula.getPuntuacion()));

        TextView titulo = findViewById(R.id.tvPeliculaTitulo);
        titulo.setText(pelicula.getTitulo());

        TextView director = findViewById(R.id.tvPeliculaDirector);
        director.setText(pelicula.getDirector());

        TextView duracion = findViewById(R.id.tvPeliculaDuracion);
        duracion.setText(pelicula.getDuracion() + " minutos");

        TextView fecha = findViewById(R.id.tvPeliculaFecha);
        fecha.setText("AÑO " + pelicula.getAnoPublicacion());

        TextView sinopsis = findViewById(R.id.tvPeliculaSinopsis);
        sinopsis.setText(pelicula.getSinopsis());

        Button btPlay = findViewById(R.id.btPeliculaPlay);
        //EVENTO DE CLIC PARA REPRODUCIR
        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SI ES LA PRIMERA VEZ, LO GUARDA EN EL HISTORIAL
                if (primeraReproduccion) {
                    Historial historial = Historial.getInstance();
                    historial.AgregarVisualizacion(new Visualizacion(pelicula));
                    primeraReproduccion = false;
                }
                //ABRE UNA NUEVA VENTANA A CON LA URL DE LA PELICULA
                Uri uri = Uri.parse(pelicula.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    //METODO AUXILIAR PARA OBTENER LA IMAGEN DE LAS ESTRELLAS EN FUNCION DE LA PUNTUACION
    private int getImagenRating(int puntuacion) {
        if (puntuacion == 5) {
            return R.drawable.rating5;
        } else if (puntuacion == 4) {
            return R.drawable.rating4;
        } else if (puntuacion == 3) {
            return R.drawable.rating3;
        } else if (puntuacion == 2) {
            return R.drawable.rating2;
        } else {
            return R.drawable.rating1;
        }
    }
}