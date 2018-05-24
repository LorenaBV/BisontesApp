package com.example.adrianch.bisontes_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Seleccionar_imagen extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lstVwLista;
    Context contexto;

    ImagenesEventos[] arregloEventos = {
            new ImagenesEventos(R.drawable.conferencia),
            new ImagenesEventos(R.drawable.fiesta),
            new ImagenesEventos(R.drawable.taller),

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_imagen);

        lstVwLista = (ListView) findViewById(R.id.lstVwLista);
        lstVwLista.setAdapter(new imagenesEventosAdapter(this, R.layout.seleccionar_imagen, arregloEventos));
        lstVwLista.setOnItemClickListener(this);
        contexto = getApplicationContext();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Toast.makeText(this, "" + arregloRestaurantes[position].imagenRestaurante, Toast.LENGTH_SHORT).show();
        Intent i = getIntent();
        i.putExtra("ImagenSeleccionada", String.valueOf(arregloEventos[position].imagenEvento));
        setResult(RESULT_OK, i);
        finish();

    }
}
