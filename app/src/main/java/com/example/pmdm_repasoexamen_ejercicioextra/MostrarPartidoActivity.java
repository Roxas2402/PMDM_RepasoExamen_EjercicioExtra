package com.example.pmdm_repasoexamen_ejercicioextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_repasoexamen_ejercicioextra.models.PartidoModel;

public class MostrarPartidoActivity extends AppCompatActivity {
    private TextView lblPartido;
    private TextView lblResultado;
    private TextView lblDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_partido);

        Intent intent = getIntent();
        inicializa();

        PartidoModel p = (PartidoModel) intent.getExtras().getSerializable("PARTI");
        lblPartido.setText(p.getPartido());
        lblResultado.setText(p.getResultado());
        lblDescripcion.setText(p.getDescripcion());

    }

    private void inicializa() {
        lblPartido = findViewById(R.id.lblPartidoMostrar);
        lblResultado = findViewById(R.id.lblResultadoMostrar);
        lblDescripcion = findViewById(R.id.lblDescripcionMostrar);
    }
}