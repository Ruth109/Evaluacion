package com.example.evaluacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ElegirMostrarTipoPublicacion extends AppCompatActivity {

    private RadioButton rbLibro, rbRevista, rbTodos;
    private RadioGroup rgbEleccion;
    private Button btnMostrar;
    private Bundle bundle;
    private int idEleccion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_mostrar_tipo_publicacion);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rgbEleccion = findViewById(R.id.rgEleccion);
        rbLibro = rgbEleccion.findViewById(R.id.rgLibro);
        rbRevista = rgbEleccion.findViewById(R.id.rgRevista);
        rbTodos = rgbEleccion.findViewById(R.id.rgTodos);
        btnMostrar = findViewById(R.id.btnMostrar);

        rbLibro.setOnClickListener(view -> idEleccion = 1);
        rbRevista.setOnClickListener(view -> idEleccion = 2);
        rbTodos.setOnClickListener(view -> idEleccion = 3);

        btnMostrar.setOnClickListener(view -> {
            bundle = new Bundle();
            bundle.putInt("tipoMostrarEleccion", idEleccion);
            Intent intent = new Intent(this, MostrarLista.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}