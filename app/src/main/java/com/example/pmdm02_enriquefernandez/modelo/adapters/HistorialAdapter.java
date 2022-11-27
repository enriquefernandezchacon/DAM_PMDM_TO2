package com.example.pmdm02_enriquefernandez.modelo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm02_enriquefernandez.R;
import com.example.pmdm02_enriquefernandez.modelo.dominio.Visualizacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

//ESTA CLASE ESTA CREADA EN BASE A LA EXPUESTA EN EL EJEMPLO DEL PROFESOR
public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.myHolderView> {

    //ATRIBUTOS DE LA CLASE, LA LISTA DE DATOS, Y EL EVENTO
    private final List<Visualizacion> datos;
    private final HistorialAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Visualizacion item);
    }

    public HistorialAdapter(List<Visualizacion> datos, OnItemClickListener listener) {
        this.datos = datos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HistorialAdapter.myHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //INDICAMOS QUE LAYOUT USAREMOS PARA CADA ELEMENTO DE LA VISTA
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rec_row_visualizacion, parent, false);

        return new HistorialAdapter.myHolderView(view);
    }

    //METODO QUE COGE LOS DATOS DE CADA ELEMENTO Y LOS ASIGNA A LOS CAMPOS CORRESPONDIENTES PARA CADA
    //ITEM
    @Override
    public void onBindViewHolder(@NonNull HistorialAdapter.myHolderView holder, int position) {
        holder.titulo.setText(datos.get(position).getPelicula().getTitulo());
        //PARA ESTABLECER LA FECHA, USO UN DATE FORMAT
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        holder.fecha.setText(dateFormat.format(datos.get(position).getFecha()));
        holder.plataforma.setText(datos.get(position).getPelicula().getIdPlataforma().toString());

        //Al pulsar click en el contenedor lo propagamos hacia arriba al escuchador que recibimos en el constructor
        holder.contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(datos.get(holder.getAdapterPosition()));
            }
        });

    }

    //ASIGNAMOS AL HOLDER LOS ELEMENTOS QUE EDITAREMOS POR CADA ITEM
    @Override
    public int getItemCount() {
        return datos.size();
    }

    class myHolderView extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView fecha;
        TextView plataforma;
        ConstraintLayout contenedor;

        public myHolderView(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tvHistorialTitulo);
            fecha = itemView.findViewById(R.id.tvHistorialFecha);
            plataforma = itemView.findViewById(R.id.tvHistorialPlataforma);
            contenedor = itemView.findViewById(R.id.contenedor_rv_historial);
        }
    }
}
