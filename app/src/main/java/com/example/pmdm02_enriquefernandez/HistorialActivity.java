package com.example.pmdm02_enriquefernandez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.pmdm02_enriquefernandez.modelo.adapters.HistorialAdapter;
import com.example.pmdm02_enriquefernandez.modelo.dominio.Visualizacion;
import com.example.pmdm02_enriquefernandez.modelo.negocio.Historial;

public class HistorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        //ASIGNO EL RECYCLER VIEW Y EL LAYOUT NORMAL
        RecyclerView rv = findViewById(R.id.rv_historial);

        LinearLayoutManager lmg = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(lmg);
        //OBTENGO LA REFERENCIA DEL HISTORIAL MEDIANTE EL PATRON SINGLETON
        Historial historial = Historial.getInstance();

        //CON ESTE EVENTO PODREMOS ACCEDER DIRECTAMENTE A LA PELICULA YA VISTA, Y DE LA PLATAFORMA
        //CORRESPONDIENTE
        HistorialAdapter.OnItemClickListener listener = new HistorialAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Visualizacion item) {
                Intent intent = new Intent(getApplicationContext(), PeliculaActivity.class);
                intent.putExtra("PELICULA", item.getPelicula());
                startActivity(intent);
            }
        };

        HistorialAdapter adapter = new HistorialAdapter(historial.getHistorial(), listener);

        rv.setAdapter(adapter);
    }
}