package com.example.iguano_s.mashogarsupervisor.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.example.iguano_s.mashogarsupervisor.R;
import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosRecibos;
import com.example.iguano_s.mashogarsupervisor.pantallas.EliminarPago;

import java.util.List;

/**
 * Created by IGUANO-S on 30/09/2017.
 */

public class AdaptadorRecibos extends RecyclerView.Adapter<AdaptadorRecibos.listadoPagosViewHolder> {
    List<DatosRecibos>listaPagos;

    public AdaptadorRecibos(List<DatosRecibos> listaPagos) {
        this.listaPagos = listaPagos;
    }


    @Override
    public AdaptadorRecibos.listadoPagosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_recibos,parent,false);
        AdaptadorRecibos.listadoPagosViewHolder pagosViewHolder=new AdaptadorRecibos.listadoPagosViewHolder(v);
        return pagosViewHolder;
    }

    @Override
    public void onBindViewHolder(AdaptadorRecibos.listadoPagosViewHolder holder, int position) {


        holder.lbl_cantidad.setText(listaPagos.get(position).getCantidad().toString());
        holder.lbl_venta.setText(listaPagos.get(position).getVenta().toString());
        holder.lbl_recibo.setText(listaPagos.get(position).getRecibo().toString());
        holder.lbl_fecha.setText(listaPagos.get(position).getFecha().toString());
        holder.setOnClickListener();

    }

    @Override
    public int getItemCount() {
        return listaPagos.size();
    }

    private static AdapterView.OnItemClickListener onItemClickListener;
    public static interface OnItemClickListener{
        public void onItemClick(View view,int position);
    }

    public static class listadoPagosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        Button btn_recibo;
        TextView lbl_recibo, lbl_cantidad, lbl_venta,lbl_fecha;

        public listadoPagosViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            lbl_recibo = (TextView) itemView.findViewById(R.id.lbl_listado_recibos_recibo);
            lbl_cantidad = (TextView) itemView.findViewById(R.id.lbl_listado_recibos_cantidad);
            lbl_venta = (TextView) itemView.findViewById(R.id.lbl_listado_recibos_venta);
            lbl_fecha = (TextView) itemView.findViewById(R.id.lbl_listado_recibos_fecha);
            btn_recibo = (Button) itemView.findViewById(R.id.btn_listado_eliminar_recibo);

        }

        void setOnClickListener() {
            btn_recibo.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,EliminarPago.class);
            intent.putExtra("venta",lbl_venta.getText());
            intent.putExtra("cantidad",lbl_cantidad.getText());
            intent.putExtra("recibo",lbl_recibo.getText());
            intent.putExtra("fecha",lbl_fecha.getText());

            context.startActivity(intent);
        }
    }

}
