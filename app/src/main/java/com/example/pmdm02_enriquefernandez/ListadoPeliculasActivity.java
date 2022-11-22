package com.example.pmdm02_enriquefernandez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ListadoPeliculasActivity extends AppCompatActivity {

    private RecyclerView rvListadoPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_peliculas);

        rvListadoPeliculas = findViewById(R.id.rvListadoPeliculas);
    }
}