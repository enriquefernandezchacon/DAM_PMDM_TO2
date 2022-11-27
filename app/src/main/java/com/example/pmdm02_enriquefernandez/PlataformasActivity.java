package com.example.pmdm02_enriquefernandez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pmdm02_enriquefernandez.modelo.adapters.PlataformasAdapter;
import com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma.Plataforma;
import com.example.pmdm02_enriquefernandez.modelo.negocio.Plataformas;

public class PlataformasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plataformas);
        //ASIGNO EL RECYCLER VIEW Y SU LAYOUT
        RecyclerView recyclerView = findViewById(R.id.rvPlataformas);

        LinearLayoutManager lmg = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(lmg);

        //OBTENGO LA INSTANCIA DE PLATAFORMAS
        Plataformas plataformas = Plataformas.getInstance();

        //EVENTO PARA ABRIR LA VENTANA DEL LISTADO DE PELICULAS CORRESPONDIENTE A ESA PLATAFORMA
        PlataformasAdapter.OnItemClickListener listener = new PlataformasAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Plataforma item) {
                Intent intent = new Intent(getApplicationContext(), ListadoPeliculasActivity.class);
                intent.putExtra("PLATAFORMA", item.getIdPlataforma());
                startActivity(intent);
            }
        };

        PlataformasAdapter adaptador = new PlataformasAdapter(plataformas.getPlataformas(), listener);

        recyclerView.setAdapter(adaptador);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.plataformas_menu, menu);
        return true;
    }

    //CONTROLADOR DEL MENU DE OPCIONES, PARA CADA OPCIÓN SE MUESTRA SU DIALOGO O NUEVA VENTANA
    //CORRESPONDIENTE
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.menuMainHistorial){
            Intent intent = new Intent(this, HistorialActivity.class);
            startActivity(intent);
        } else if (id == R.id.menuMainAyuda){
            //CREAMOS EL DIALOGO QUE MUESTRE EL PANEL "AYUDA"
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.diaologo_ayuda);
            dialog.show();
        } else if (id == R.id.menuMainAcercaDe){
            //CREAMOS EL DIALOGO QUE MUESTRE EL PANEL "ACERCA DE"
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.diaologo_acercade);
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}