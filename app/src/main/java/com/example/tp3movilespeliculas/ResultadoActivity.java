package com.example.tp3movilespeliculas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp3movilespeliculas.databinding.ActivityResultadoBinding;

public class ResultadoActivity extends AppCompatActivity {

    ActivityResultadoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getBundleExtra("pelicula");

        Pelicula pelicula =(Pelicula) bundle.getSerializable("pelicula");

        binding.tvTitulo.setText(pelicula.getTitulo());
        binding.tvDescripcion.setText(pelicula.getDescripcion());
        binding.ivPortada.setImageResource(pelicula.getUrlPortada());
        binding.tvDirector.setText(pelicula.getDirector());
        binding.tvActores.setText(pelicula.getActores());
    }
}
