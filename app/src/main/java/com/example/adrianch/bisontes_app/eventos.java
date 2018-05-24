package com.example.adrianch.bisontes_app;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class eventos extends AppCompatActivity {

    ImageButton imageButton;
    EditText editTextNombre, editTextDescripcion, editTextlug;
    String nombreEvento, descripcionEvento, lugarEvento, resultado;
    int imaEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);


        imageButton = findViewById(R.id.imageButton);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextDescripcion = findViewById(R.id.editTextDescripcion);
        editTextlug = findViewById(R.id.editTextlug);



    }
    public void onClickSeleccionarImagen(View v) {
        Intent intent = new Intent(eventos.this, Seleccionar_imagen.class);
        startActivityForResult(intent, 1000);

}

    public void onClickGuardar(View v) throws IOException {
        nombreEvento = editTextNombre.getText().toString();
        descripcionEvento = editTextDescripcion.getText().toString();
        lugarEvento = editTextlug.getText().toString();
        imaEventos = Integer.parseInt(resultado);

        boolean sdDisponible = false;
        boolean sdAccesoEscritura = false;

        String estado = Environment.getExternalStorageState();

        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            sdAccesoEscritura = true;
        }
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "Eventos.txt");
            File g = new File(ruta_sd.getAbsolutePath(), "Opiniones.txt");

            OutputStreamWriter fout =
                    new OutputStreamWriter(
                            new FileOutputStream(f, true));

            OutputStreamWriter fout2 =
                    new OutputStreamWriter(
                            new FileOutputStream(g, true));

            fout.append(imaEventos + ";" + nombreEvento + ";" + descripcionEvento + ";" + lugarEvento + ";" + "\n");
            fout.close();

            fout2.append("3;\n");
            fout2.close();

        } catch (Exception ex) {
            Log.e("Ficheros", "error msg");
        }
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK) {
                resultado = data.getExtras().getString("ImagenSeleccionada");
                imageButton.setImageResource(Integer.parseInt(resultado));

    }
        }
    }