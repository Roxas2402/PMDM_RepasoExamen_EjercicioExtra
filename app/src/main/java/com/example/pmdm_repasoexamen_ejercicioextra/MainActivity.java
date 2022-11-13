package com.example.pmdm_repasoexamen_ejercicioextra;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.pmdm_repasoexamen_ejercicioextra.adapters.PartidosModelAdapters;
import com.example.pmdm_repasoexamen_ejercicioextra.models.PartidoModel;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import com.example.pmdm_repasoexamen_ejercicioextra.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private PartidosModelAdapters adapters;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<PartidoModel> partidoModelList;
    ActivityResultLauncher<Intent> launcherCrearPartido;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        partidoModelList = new ArrayList<>();
        adapters = new PartidosModelAdapters(partidoModelList, R.layout.partido_view_holder, this);

        layoutManager = new GridLayoutManager(this, 1);
        binding.contenedorMain.contenedor.setLayoutManager(layoutManager);
        binding.contenedorMain.contenedor.setAdapter(adapters);

        iniciaLauncher();


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCrearPartido.launch(new Intent(MainActivity.this, CrearPartidosActivity.class));
            }
        });
    }

    private void iniciaLauncher() {
        launcherCrearPartido = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null && result.getData().getExtras() != null) {
                        PartidoModel p = (PartidoModel) result.getData().getExtras().getSerializable("PART");
                        Toast.makeText(MainActivity.this, p.toString(), Toast.LENGTH_SHORT).show();
                        partidoModelList.add(p);
                        adapters.notifyItemInserted(partidoModelList.size() - 1);
                    }
                }
            }
        });
    }
}