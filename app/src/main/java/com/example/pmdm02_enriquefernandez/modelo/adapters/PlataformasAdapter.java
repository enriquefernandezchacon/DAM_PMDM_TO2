package com.example.pmdm02_enriquefernandez.modelo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm02_enriquefernandez.R;
import com.example.pmdm02_enriquefernandez.modelo.dominio.Plataforma;

import java.util.List;

public class PlataformasAdapter
        extends RecyclerView.Adapter<PlataformasAdapter.myHolderView> {

    private final List<Plataforma> datos;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Plataforma item);
    }

    public PlataformasAdapter(List<Plataforma> datos, OnItemClickListener listener) {
        this.datos = datos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public myHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rec_row_plataforma, parent, false);

        return new myHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolderView holder, int position) {
        holder.titulo.setText(datos.get(position).getNombrePlataforma());
        holder.imageView.setImageResource(datos.get(position).getImagenPlataformaId());

        //Al pulsar click en el contenedor lo propagamos hacia arriba al escuchador que recibimos en el constructor
        holder.contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(datos.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    class myHolderView extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView titulo;
        ConstraintLayout contenedor;

        public myHolderView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivIconoPlataforma);
            titulo = itemView.findViewById(R.id.tvTituloPlataforma);
            contenedor = itemView.findViewById(R.id.constraintPlataformaIndividual);
        }
    }

}
