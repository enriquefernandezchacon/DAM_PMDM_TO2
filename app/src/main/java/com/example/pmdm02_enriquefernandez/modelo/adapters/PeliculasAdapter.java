package com.example.pmdm02_enriquefernandez.modelo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm02_enriquefernandez.R;
import com.example.pmdm02_enriquefernandez.modelo.dominio.Pelicula;

import java.util.List;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.myHolderView> {

    private final List<Pelicula> datos;
    private PeliculasAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Pelicula item);
    }

    public PeliculasAdapter(List<Pelicula> datos, OnItemClickListener listener) {
        this.datos = datos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PeliculasAdapter.myHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rec_row_pelicula, parent, false);

        return new PeliculasAdapter.myHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculasAdapter.myHolderView holder, int position) {
        holder.titulo.setText(datos.get(position).getTitulo());
        holder.ivPortada.setImageResource(datos.get(position).getPortada());
        holder.ivRating.setImageResource(getImagenRating(datos.get(position).getPuntuación()));

        //Al pulsar click en el contenedor lo propagamos hacia arriba al escuchador que recibimos en el constructor
        holder.contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(datos.get(holder.getAdapterPosition()));
            }
        });

    }

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

    @Override
    public int getItemCount() {
        return datos.size();
    }

    class myHolderView extends RecyclerView.ViewHolder{

        ImageView ivPortada;
        TextView titulo;
        ImageView ivRating;
        ConstraintLayout contenedor;

        public myHolderView(@NonNull View itemView) {
            super(itemView);
            ivPortada = itemView.findViewById(R.id.ivRVPortadaPelicula);
            titulo = itemView.findViewById(R.id.tvRVTitulo);
            ivRating = itemView.findViewById(R.id.ivRVRating);
            contenedor = itemView.findViewById(R.id.constraintPeliculaIndividual);
        }
    }
}
