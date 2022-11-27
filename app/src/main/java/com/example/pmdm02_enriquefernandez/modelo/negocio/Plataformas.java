package com.example.pmdm02_enriquefernandez.modelo.negocio;

import com.example.pmdm02_enriquefernandez.R;
import com.example.pmdm02_enriquefernandez.modelo.dominio.Pelicula;
import com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma.IdPlataforma;
import com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma.Plataforma;

import java.util.ArrayList;
import java.util.List;

//ESTA CLASE USA UN PATRÓN SINGLETON, CON ESTO ME ASEGURO QUE CUALQUIER PROCESO QUE SOLICITE UN OBJETO
//DE ESTA CLASE, RECIBA LA MISMA REFERENCIA. ASI SE PUEDE ACCEDER A ÉL DESDE CUALQUIER PUNTO
//FUENTE: https://refactoring.guru/design-patterns/singleton
public class Plataformas {

    private final List<Plataforma> plataformas;
    private static volatile Plataformas instance;

    //AL INSTANCIAR PLATAFORMAS, CREO CADA PLATAFORMA INDIVIDUALMENTE Y AÑADO 30 PELICULAS EN CADA UNA
    private Plataformas() {
        plataformas = new ArrayList<>();
        plataformas.add(new Plataforma(R.drawable.logo_netflix, IdPlataforma.NETFLIX));
        plataformas.add(new Plataforma(R.drawable.logo_hbo, IdPlataforma.HBO));
        plataformas.add(new Plataforma(R.drawable.logo_amazon_prime, IdPlataforma.PRIME));
        plataformas.add(new Plataforma(R.drawable.logo_dazn, IdPlataforma.DAZN));
        plataformas.add(new Plataforma(R.drawable.logo_dinsey, IdPlataforma.DISNEY));

        anadirPeliculas();
    }

    public Plataforma getPlataforma(IdPlataforma id) {
        for (Plataforma plataforma : plataformas ) {
            if (plataforma.getIdPlataforma().equals(id)) {
                return plataforma;
            }
        }
        return plataformas.get(0);
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public static Plataformas getInstance() {
        Plataformas result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Plataformas.class) {
            if (instance == null) {
                instance = new Plataformas();
            }
            return instance;
        }
    }

    private void anadirPeliculas() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Pelicula p1 = crearPelicula(1);
                Pelicula p2 = crearPelicula(2);
                Pelicula p3 = crearPelicula(3);
                plataformas.get(i).AgregarPelicula(p1);
                plataformas.get(i).AgregarPelicula(p2);
                plataformas.get(i).AgregarPelicula(p3);
            }
        }

    }

    //METODO PARA CREAR PELICULAS POR DEFECTO
    private Pelicula crearPelicula(int i) {
        String titulo;
        int puntuación;
        int portadaId;
        int fechaPublicacion;
        String director;
        int duracion;
        String sinopsis;
        String url;

        if (i == 1) {
            titulo = "Voy a pasármelo bien";
            puntuación = 3;
            portadaId = R.drawable.pelicula_voy_a_pasarmelo_bien;
            fechaPublicacion = 2022;
            director = "David Serrano";
            duracion = 108;
            sinopsis = "Valladolid, 1989. David y Layla acaban de empezar Octavo de E.G.B. y a ambos les encanta el grupo “Hombres G”. También se gustan mucho entre ellos, pero como a David le aconsejan tan mal sus amigos, todas las cosas que hace para conquistarla terminan siempre siendo un fracaso. A pesar de todo, los dos se hacen inseparables y siempre se lo están pasando bien. Muy bien.\n" +
                    "\n" +
                    "Valladolid. Poco más de treinta años después. David y Layla no se han vuelto a ver desde finales de los ochenta, pero nunca se han olvidado el uno del otro. Layla es directora de cine y ha ganado un Oscar. La vida de David, en cambio, ha sido más normal sin fama ni premios. Cuando Layla vuelve a la ciudad para recibir un homenaje, ambos pasarán juntos una semana en la que se dan cuenta de que los niños que fueron no han desaparecido del todo.";
            sinopsis += "\n\nValladolid, 1989. David y Layla acaban de empezar Octavo de E.G.B. y a ambos les encanta el grupo “Hombres G”. También se gustan mucho entre ellos, pero como a David le aconsejan tan mal sus amigos, todas las cosas que hace para conquistarla terminan siempre siendo un fracaso. A pesar de todo, los dos se hacen inseparables y siempre se lo están pasando bien. Muy bien.\n" +
                    "\n" +
                    "Valladolid. Poco más de treinta años después. David y Layla no se han vuelto a ver desde finales de los ochenta, pero nunca se han olvidado el uno del otro. Layla es directora de cine y ha ganado un Oscar. La vida de David, en cambio, ha sido más normal sin fama ni premios. Cuando Layla vuelve a la ciudad para recibir un homenaje, ambos pasarán juntos una semana en la que se dan cuenta de que los niños que fueron no han desaparecido del todo.";
            url = "https://www.youtube.com/watch?v=RmESeBJu9sI";
        } else if (i == 2) {
            titulo = "Bullet Train";
            puntuación = 4;
            portadaId = R.drawable.pelicula_bullet_train;
            fechaPublicacion = 2022;
            director = "David Leitch";
            duracion = 126;
            sinopsis = "Cinco asesinos a sueldo se encuentran a bordo de un tren bala que viaja de Tokio a Morioka con unas pocas paradas intermedias. Descubren que sus misiones no son ajenas entre sí. La pregunta es quién saldrá vivo del tren y qué les espera en la estación final.";
            url = "https://www.youtube.com/watch?v=KmfnQMJmK2w";
        } else {
            titulo = "El hombre del norte";
            puntuación = 4;
            portadaId = R.drawable.pelicula_the_northman;
            fechaPublicacion = 2022;
            director = "Robert Eggers";
            duracion = 136;
            sinopsis = "En Islandia, en pleno siglo X, un príncipe nórdico (Skarsgard) busca vengar a toda costa la muerte de su padre.";
            url = "https://www.youtube.com/watch?v=7HZ4tBQEiB0";
        }

        return new Pelicula(titulo, puntuación, portadaId, fechaPublicacion, director, duracion, sinopsis, url);
    }
}
