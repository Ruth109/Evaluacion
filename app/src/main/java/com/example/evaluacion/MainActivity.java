package com.example.evaluacion;
import com.example.evaluacion.clases.Publicacion;
import com.example.evaluacion.clases.Libro;
import com.example.evaluacion.clases.Revista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static ArrayList<Publicacion> lstPublicaciones;
    private Button btnIrAgregarPublicacion, btnIrMostrarLista, btnIrAcercaDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPublicaciones = new ArrayList<>();
        btnIrAgregarPublicacion = findViewById(R.id.btnAgregar);
        btnIrMostrarLista = findViewById(R.id.btnMostrarLista);
        btnIrAcercaDe = findViewById(R.id.btnAcercaDe);

        btnIrAgregarPublicacion.setOnClickListener(this);
        btnIrMostrarLista.setOnClickListener(this);
        btnIrAcercaDe.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AcercaDe.class));
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btnAgregar){
            startActivity(new Intent(this, ElegirTipoPublicacion.class));
        }

        if(id == R.id.btnMostrarLista){
            startActivity(new Intent(this, ElegirMostrarTipoPublicacion.class));
        }
    }
}