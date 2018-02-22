package com.example.iguano_s.mashogarsupervisor.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iguano_s.mashogarsupervisor.R;
import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosRutas;

import java.util.List;

/**
 * Created by IGUANO-S on 08/09/2017.
 */

public class AdaptadorRuta extends RecyclerView.Adapter<AdaptadorRuta.DatosRutasViewHolder> {

    List<DatosRutas> listaRutas;

    public AdaptadorRuta(List<DatosRutas> listaRutas) {

        this.listaRutas = listaRutas;
    }

    @Override
    public DatosRutasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_rutas,parent,false);
        DatosRutasViewHolder adaptadorRutaViewHolder=new DatosRutasViewHolder(v);
        return adaptadorRutaViewHolder;
    }

    @Override
    public void onBindViewHolder(DatosRutasViewHolder holder, int position) {

        holder.Ruta.setText("Ruta: "+listaRutas.get(position).getRuta());
    }

    @Override
    public int getItemCount() {

        return listaRutas.size();
    }


    public static class DatosRutasViewHolder extends RecyclerView.ViewHolder {
       // Context context;
        TextView Ruta;
        public DatosRutasViewHolder(View itemView) {
            super(itemView);

            Ruta=(TextView)itemView.findViewById(R.id.lbl_listado_rutas_ruta);
        }
    }


}
