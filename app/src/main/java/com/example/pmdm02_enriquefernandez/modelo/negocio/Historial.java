package com.example.pmdm02_enriquefernandez.modelo.negocio;

import com.example.pmdm02_enriquefernandez.R;
import com.example.pmdm02_enriquefernandez.modelo.dominio.Visualizacion;
import com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma.IdPlataforma;
import com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma.Plataforma;

import java.util.ArrayList;
import java.util.List;

//ESTA CLASE USA UN PATRÓN SINGLETON, CON ESTO ME ASEGURO QUE CUALQUIER PROCESO QUE SOLICITE UN OBJETO
//DE ESTA CLASE, RECIBA LA MISMA REFERENCIA. ASI SE PUEDE ACCEDER A ÉL DESDE CUALQUIER PUNTO
//FUENTE: https://refactoring.guru/design-patterns/singleton
public class Historial {

    private final List<Visualizacion> historial;
    private static volatile Historial instance;

    private Historial() {
        historial = new ArrayList<>();
    }

    public static Historial getInstance() {
        Historial result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Historial.class) {
            if (instance == null) {
                instance = new Historial();
            }
            return instance;
        }
    }

    public void AgregarVisualizacion(Visualizacion visualizacion) {
        if (visualizacion != null) {
            historial.add(visualizacion);
        }
    }

    public List<Visualizacion> getHistorial() {
        return historial;
    }
}
