package com.example.adrianch.bisontes_app;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by Adrian Ch on 07/12/2017.
 */

public class imagenesEventosAdapter extends ArrayAdapter<ImagenesEventos> implements ListAdapter {
    Context contexto;
    int iLayout;
    ImagenesEventos[] imagenesEventos;

    public imagenesEventosAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ImagenesEventos[] objects) {
        super(context, resource, objects);
        contexto = context;
        iLayout = resource;
        imagenesEventos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgVwDet;
        TextView txtVwRestDet, txtVwDescDet;
        View vwFila = convertView;

        if (vwFila == null) { //La lista se llena por primera vez
            LayoutInflater CrearLayout = ((Activity) contexto).getLayoutInflater();
            vwFila = CrearLayout.inflate(iLayout, parent, false);
        }

        imgVwDet = (ImageView) vwFila.findViewById(R.id.imgVw);

        //Llenar datos
        imgVwDet.setImageResource(imagenesEventos[position].imagenEvento);
        //  txtVwDescDet.setText(imagenesRestaurantes[position].);
        return vwFila;
        //return super.getView(position, convertView, parent);
    }
}


