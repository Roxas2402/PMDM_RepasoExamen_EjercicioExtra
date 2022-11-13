package com.example.pmdm_repasoexamen_ejercicioextra.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_repasoexamen_ejercicioextra.CrearPartidosActivity;
import com.example.pmdm_repasoexamen_ejercicioextra.MainActivity;
import com.example.pmdm_repasoexamen_ejercicioextra.MostrarPartidoActivity;
import com.example.pmdm_repasoexamen_ejercicioextra.R;
import com.example.pmdm_repasoexamen_ejercicioextra.models.PartidoModel;

import java.util.List;

public class PartidosModelAdapters extends RecyclerView.Adapter<PartidosModelAdapters.PartidoVH>{


    ActivityResultLauncher<Intent> launcherMostrarPartido;
    private MainActivity main;


    private List<PartidoModel> objects;
    private int resource;
    private Context context;
    public PartidosModelAdapters(List<PartidoModel> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
        main = (MainActivity) context;
    }


    @NonNull
    @Override
    public PartidoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View partidoView = LayoutInflater.from(context).inflate(resource, null);
        partidoView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new PartidoVH(partidoView);
    }

    @Override
    public void onBindViewHolder(@NonNull PartidoVH holder, int position) {
        PartidoModel p = objects.get(position);
        holder.lblResultado.setText(p.getResultado());
        holder.lblPartido.setText(p.getPartido());

        holder.btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verPartido(p).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherMostrarPartido.launch(MainActivity.this, MostrarPartidoActivity.class);
            }
        });
    }


    private AlertDialog verPartido(PartidoModel p) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle(p.getPartido());
        builder.setMessage("El equipo ganador es: " + p.getPartido());
        //View partidoView = LayoutInflater.from(context).inflate(R.layout.activity_crear_partidos, null);

        //TextView resultado = partidoView.findViewById(R.id.txtResultadoCrear);

        //builder.setView(partidoView);
        return builder.create();
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class PartidoVH extends RecyclerView.ViewHolder {
        TextView lblPartido, lblResultado;
        ImageButton btnVer;
        public PartidoVH(@NonNull View itemView) {
            super(itemView);
            lblPartido = itemView.findViewById(R.id.lblPartidoCard);
            lblResultado = itemView.findViewById(R.id.lblResultadoCard);
            btnVer = itemView.findViewById(R.id.btnVerCard);
        }
    }
}
