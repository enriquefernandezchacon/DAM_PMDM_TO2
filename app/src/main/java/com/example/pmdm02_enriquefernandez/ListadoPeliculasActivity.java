package com.example.pmdm02_enriquefernandez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm02_enriquefernandez.modelo.adapters.PeliculasAdapter;
import com.example.pmdm02_enriquefernandez.modelo.dominio.Pelicula;
import com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma.IdPlataforma;
import com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma.Plataforma;
import com.example.pmdm02_enriquefernandez.modelo.negocio.Plataformas;

import java.util.List;

public class ListadoPeliculasActivity extends AppCompatActivity {

    private RecyclerView rvListadoPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_peliculas);
        //ASIGNO EL RECYCLER VIEW Y CREO EL LAYOUYT DE TIPO GRID, DE 3 COLUMNAS
        rvListadoPeliculas = findViewById(R.id.rvListadoPeliculas);

        GridLayoutManager glm = new GridLayoutManager(getApplicationContext(),3);
        rvListadoPeliculas.setLayoutManager(glm);

        //OBTENGO LA PLATAFORMA SELECCIONADA Y CARGO SUS PELICULAS
        Intent intentLlegada = getIntent();
        Plataformas plataformas = Plataformas.getInstance();
        IdPlataforma id = (IdPlataforma) intentLlegada.getSerializableExtra("PLATAFORMA");
        Plataforma plataforma = plataformas.getPlataforma(id);
        List<Pelicula> peliculas = plataforma.getAllPeliculas();

        TextView titulo = findViewById(R.id.tvListadoPeliculaTitulo);
        titulo.setText("PELICULAS DE " + plataforma.getNombrePlataforma().toUpperCase());

        //ESTE EVENTO CARGARA "PELICULA ACTIVITY" CON LOS DATOS DE LA PELICULA SELECCIONADA
        PeliculasAdapter.OnItemClickListener listener = new PeliculasAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Pelicula item) {
                Intent intent = new Intent(getApplicationContext(), PeliculaActivity.class);
                intent.putExtra("PELICULA", item);
                startActivity(intent);
            }
        };

        PeliculasAdapter adaptador = new PeliculasAdapter(peliculas, listener);

        rvListadoPeliculas.setAdapter(adaptador);
    }
}