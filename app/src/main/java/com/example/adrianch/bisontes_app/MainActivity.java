package com.example.adrianch.bisontes_app;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    Button btneve,btnforo,btnasce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btneve = findViewById(R.id.btneve);
        btnforo = findViewById(R.id.btnforo);
        btnasce = findViewById(R.id.btnasce);
    }
        public void onClickeve (View v){
        Intent intent=new Intent(MainActivity.this,eventos.class);
        startActivity(intent);

    }


    }

