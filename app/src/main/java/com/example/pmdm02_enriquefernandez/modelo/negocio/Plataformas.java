package com.example.pmdm02_enriquefernandez.modelo.negocio;

import com.example.pmdm02_enriquefernandez.R;
import com.example.pmdm02_enriquefernandez.modelo.dominio.Plataforma;

import java.util.ArrayList;
import java.util.List;

public class Plataformas {

    private final List<Plataforma> plataformas;

    public Plataformas() {
        plataformas = new ArrayList<>();
        plataformas.add(new Plataforma("Netflix", R.drawable.netflix));
        plataformas.add(new Plataforma("HBO Max", R.drawable.hbo));
        plataformas.add(new Plataforma("Amazon Prime Video", R.drawable.amazon_prime));
        plataformas.add(new Plataforma("Dazn", R.drawable.dazn));
        plataformas.add(new Plataforma("Disney+", R.drawable.dinsey));
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }
}
