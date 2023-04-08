package com.example.tp3movilespeliculas;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tp3movilespeliculas.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private MainActivityViewModel mv;
    private Context context;
    // private ArrayList<Pelicula> peliculas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        context = getApplicationContext();



        mv.getLista().observe(this, new Observer<ArrayList<Pelicula>>() {
            @Override
            public void onChanged(ArrayList<Pelicula> peliculas) {
                RecyclerView rv = binding.rvLista;

                GridLayoutManager grilla = new GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false);
                rv.setLayoutManager(grilla);

                MainAdapter adapter = new MainAdapter(context, peliculas, getLayoutInflater());
                rv.setAdapter(adapter);
            }
        });


        mv.cargarLista();


    }
}