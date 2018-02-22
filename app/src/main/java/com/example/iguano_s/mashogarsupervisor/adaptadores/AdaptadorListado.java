package com.example.iguano_s.mashogarsupervisor.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iguano_s.mashogarsupervisor.R;
import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosArticulo;
import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosListados;
import com.example.iguano_s.mashogarsupervisor.pantallas.Catalogo_Detalles;
import com.example.iguano_s.mashogarsupervisor.pantallas.tarjeta_virtual;

import java.util.List;

/**
 * Created by IGUANO-S on 29/06/2017.
 */

public class AdaptadorListado extends RecyclerView.Adapter<AdaptadorListado.ListadoViewHolder> implements View.OnLongClickListener {

    List<DatosListados> listaListados;
    public AdaptadorListado(List<DatosListados> listaListados) {
        this.listaListados = listaListados;
    }

    @Override
    public AdaptadorListado.ListadoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_detalle,parent,false);
        AdaptadorListado.ListadoViewHolder ListadoViewHolder = new AdaptadorListado.ListadoViewHolder(v);
        return ListadoViewHolder;
    }

    @Override
    public void onBindViewHolder(AdaptadorListado.ListadoViewHolder holder, int position) {

        //holder.img_articulo.setImageResource(listaArticulos.get(position).getImagen_articulo());
        //holder.img_articulo.setImageResource(R.drawable.busqueda);
        holder.cliente.setText(listaListados.get(position).getCliente());
        holder.venta.setText(listaListados.get(position).getVenta());
        holder.nombre.setText(listaListados.get(position).getNombre());

        holder.total.setText(listaListados.get(position).getTotal().toString());
        holder.enganche.setText("-"+listaListados.get(position).getEnganche().toString());
        holder.descuento.setText("-"+listaListados.get(position).getDescuento().toString());
        holder.saldo.setText("="+listaListados.get(position).getSaldo().toString());

        holder.fecha_venta.setText(listaListados.get(position).getFecha_venta().toString());
       // holder.fecha_venta.setText(listaListados.get(position).getFecha_venta().toString());
        //holder.fecha_vence.setText(listaListados.get(position).getFecha_vence().toString());
        holder.plazo.setText(listaListados.get(position).getPlazo().toString());

        holder.pvg.setText(listaListados.get(position).getPvg().toString());
        holder.pva.setText(listaListados.get(position).getPva().toString());

        holder.direccion.setText(listaListados.get(position).getCalle().toString()+listaListados.get(position).getColonia().toString()+listaListados.get(position).getCiudad().toString());

        holder.setOnClickListener();


    }

    @Override
    public int getItemCount() {
        return listaListados.size();
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    private static AdapterView.OnItemClickListener onItemClickListener;
    public static interface OnItemClickListener{
        public void onItemClick(View view,int position);
    }



    public static class ListadoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        ImageView img_listados;
        TextView cliente,venta, nombre, total, enganche, descuento, saldo, pva,pvg, fecha_venta, fecha_vence, plazo,calle, colonia, ciudad, direccion;


        public ListadoViewHolder(View itemView) {
            super(itemView);
            context= itemView.getContext();


            img_listados= (ImageView)itemView.findViewById(R.id.img_busca_listados);
            //img_articulo.setImageBitmap(imagen);
            cliente=(TextView)itemView.findViewById(R.id.lbl_listado_detalle_cliente);
            venta=(TextView)itemView.findViewById(R.id.lbl_listado_detalle_venta);
            nombre=(TextView)itemView.findViewById(R.id.lbl_listado_detalle_nombre);
            total=(TextView)itemView.findViewById(R.id.lbl_listado_detalle_total);
            enganche=(TextView)itemView.findViewById(R.id.lbl_listado_detalle_enganche);

            fecha_venta=(TextView)itemView.findViewById(R.id.lbl_listado_detalle_fecha);

            descuento=(TextView)itemView.findViewById(R.id.lbl_listado_detalle_descuento);
            saldo=(TextView)itemView.findViewById(R.id.lbl_listado_detalle_saldo);
            plazo=(TextView)itemView.findViewById(R.id.lbl_listado_detalle_plazo);
            pvg=(TextView)itemView.findViewById(R.id.lbl_listado_detalle_pvguardados);
            pva=(TextView)itemView.findViewById(R.id.lbl_listado_detalle_pvactual);

            direccion=(TextView)itemView.findViewById(R.id.lbl_listado_detalle_direccion);


        }
        void  setOnClickListener(){
            img_listados.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,tarjeta_virtual.class);
            intent.putExtra("venta",venta.getText());

            context.startActivity(intent);

        }
    }

}
