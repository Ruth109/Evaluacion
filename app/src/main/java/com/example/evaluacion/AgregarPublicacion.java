package com.example.evaluacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import static com.example.evaluacion.MainActivity.lstPublicaciones;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.evaluacion.clases.Libro;
import com.example.evaluacion.clases.Revista;

public class AgregarPublicacion extends AppCompatActivity {
    EditText edtCodigoPublic, edtTituloPublic, edtAnioPublic, edtNumRevista;
    ImageView imgRevista, imgLibro;
    Button btnIrProcesar;
    Bundle bundle;
    int idEleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_publicacion);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        edtCodigoPublic = findViewById(R.id.edtCodigo);
        edtTituloPublic = findViewById(R.id.edtTitulo);
        edtAnioPublic = findViewById(R.id.edtAnio);
        edtNumRevista = findViewById(R.id.edtNumeroRevista);
        btnIrProcesar = findViewById(R.id.btnProcesar);
        imgRevista = findViewById(R.id.imgRevista);
        imgLibro = findViewById(R.id.imgLibro);

        bundle = getIntent().getExtras();
        idEleccion = bundle.getInt("tipoEleccion");

        if(idEleccion == 1){
            edtNumRevista.setVisibility(View.GONE);
            imgRevista.setVisibility(View.GONE);
        }

        if(idEleccion == 2){
            imgLibro.setVisibility(View.GONE);
        }

        btnIrProcesar.setOnClickListener(view -> {
            if (edtNumRevista.getText().toString().isEmpty()) {
                lstPublicaciones.add(
                        new Libro(
                                Integer.valueOf(edtCodigoPublic.getText().toString()),
                                edtTituloPublic.getText().toString(),
                                Integer.valueOf(edtAnioPublic.getText().toString()),
                                false
                        )
                );
            }else{
                lstPublicaciones.add(
                        new Revista(
                                Integer.valueOf(edtCodigoPublic.getText().toString()),
                                edtTituloPublic.getText().toString(),
                                Integer.valueOf(edtAnioPublic.getText().toString()),
                                Integer.valueOf(edtNumRevista.getText().toString())
                        )
                );
            }

            new AlertDialog.Builder(this).setMessage("Insertado con exito").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            }).show();
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