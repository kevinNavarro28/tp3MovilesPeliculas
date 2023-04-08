package com.example.tp3movilespeliculas;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {
    private ArrayList<Pelicula> peliculas ;
    private MutableLiveData<ArrayList<Pelicula>> lista;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<ArrayList<Pelicula>> getLista() {
        if(this.lista == null){
            this.lista = new MutableLiveData<>();
        }
        return this.lista;
    }

    public void cargarLista(){
        peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("Avatar", "Entramos en el mundo Avatar de la mano de Jake Sully, un ex-Marine en silla de ruedas, que ha sido reclutado para viajar a Pandora, donde existe un mineral raro y muy preciado que puede solucionar la crisis energética existente en la Tierra.", "James Cameron", "Sam Worthington", R.drawable.avatar));
        peliculas.add(new Pelicula("intelestellar", "Un grupo de científicos y exploradores, encabezados por Cooper, se embarcan en un viaje espacial para encontrar un lugar con las condiciones necesarias para reemplazar a la Tierra y comenzar una nueva vida allí. La Tierra está llegando a su fin y este grupo necesita encontrar un planeta más allá de nuestra galaxia que garantice el futuro de la raza humana.", "Christopher Nolan", "Matthew McConaughey", R.drawable.intelestelar));
        peliculas.add(new Pelicula("Matrix", "El programador informático Thomas Anderson, más conocido en el mundo de los \"hacker\" como Neo, está en el punto de mira del temible agente Smith. Otros dos piratas informáticos, Trinity y Morfeo, se ponen en contacto con Neo para ayudarlo a escapar. Matrix te posee. Sigue al conejo blanco.", "Lana Wachowski y Lilly Wachowski", "Keanu Reeves", R.drawable.matrix));
        lista.setValue(peliculas);
    }
}