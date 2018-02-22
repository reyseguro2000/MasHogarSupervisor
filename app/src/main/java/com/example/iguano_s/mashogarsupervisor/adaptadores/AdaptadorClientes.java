package com.example.iguano_s.mashogarsupervisor.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iguano_s.mashogarsupervisor.R;
import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosClientes;

import java.util.List;

/**
 * Created by IGUANO-S on 22/09/2017.
 */

public class AdaptadorClientes extends RecyclerView.Adapter<AdaptadorClientes.DatosClientesViewHolder> {

    List<DatosClientes>listaClientes;


    @Override
    public AdaptadorClientes.DatosClientesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_detalle,parent,false);
        AdaptadorClientes.DatosClientesViewHolder adaptadorClientesViewHolder=new AdaptadorClientes.DatosClientesViewHolder(v);
        return adaptadorClientesViewHolder;
    }

    @Override
    public void onBindViewHolder(AdaptadorClientes.DatosClientesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }


    public class DatosClientesViewHolder extends RecyclerView.ViewHolder {
        public DatosClientesViewHolder(View itemView) {
            super(itemView);

        }
    }
}
