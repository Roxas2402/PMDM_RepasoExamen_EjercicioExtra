package com.example.pmdm_repasoexamen_ejercicioextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pmdm_repasoexamen_ejercicioextra.databinding.ActivityCrearPartidosBinding;
import com.example.pmdm_repasoexamen_ejercicioextra.models.PartidoModel;

public class CrearPartidosActivity extends AppCompatActivity {
    private ActivityCrearPartidosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCrearPartidosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        binding.btnCrearCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String partido = binding.spCrear.getSelectedItem().toString();
                String resultado = binding.txtResultadoCrear.getText().toString();
                String descripcion = binding.txtDescripcionCrear.getText().toString();
                if (!partido.equalsIgnoreCase(Constants.SELECCION) && !resultado.isEmpty() && !descripcion.isEmpty()) {
                    PartidoModel p = new PartidoModel(partido, resultado, descripcion);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("PART", p);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(CrearPartidosActivity.this, "Datos erróneos o incompletos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}