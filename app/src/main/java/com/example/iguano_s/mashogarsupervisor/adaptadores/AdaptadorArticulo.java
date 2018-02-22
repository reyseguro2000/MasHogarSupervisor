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

import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosArticulo;
import com.example.iguano_s.mashogarsupervisor.R;
import com.example.iguano_s.mashogarsupervisor.pantallas.Catalogo_Detalles;

import java.util.List;

/**
 * Created by IGUANO-S on 28/06/2017.
 */

public class AdaptadorArticulo extends RecyclerView.Adapter<AdaptadorArticulo.ArticuloViewHolder> implements View.OnLongClickListener{
    List<DatosArticulo> listaArticulos;
    public AdaptadorArticulo(List<DatosArticulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    @Override
    public ArticuloViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalogo_detalle,parent,false);
        ArticuloViewHolder articuloViewHolder = new ArticuloViewHolder(v);
        return articuloViewHolder;
    }

    @Override
    public void onBindViewHolder(ArticuloViewHolder holder, int position) {

        //holder.img_articulo.setImageResource(listaArticulos.get(position).getImagen_articulo());
        //holder.img_articulo.setImageResource(R.drawable.busqueda);
        holder.clave.setText(listaArticulos.get(position).getClave_articulo());
        holder.articulo.setText(listaArticulos.get(position).getArticulo());
        holder.precio.setText(listaArticulos.get(position).getPrecio());
        holder.formula.setText(listaArticulos.get(position).getFormula());
        holder.descripcion.setText(listaArticulos.get(position).getDescripcion());
        holder.setOnClickListener();


    }

    @Override
    public int getItemCount() {
        return listaArticulos.size();
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    private static AdapterView.OnItemClickListener onItemClickListener;
    public static interface OnItemClickListener{
        public void onItemClick(View view,int position);
    }



    public static class ArticuloViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        ImageView img_articulo;
        TextView clave, articulo, precio, formula, descripcion;


        public ArticuloViewHolder(View itemView) {
            super(itemView);
            context= itemView.getContext();


            img_articulo= (ImageView)itemView.findViewById(R.id.busca_catalogo);
            //img_articulo.setImageBitmap(imagen);
            clave=(TextView)itemView.findViewById(R.id.lbl_detalle_catalogo_clave);
            articulo=(TextView)itemView.findViewById(R.id.lbl_detalle_catalogo_articulo);
            precio=(TextView)itemView.findViewById(R.id.lbl_detalle_catalogo_precio);
            formula=(TextView)itemView.findViewById(R.id.lbl_detalle_catalogo_formula);
            descripcion=(TextView)itemView.findViewById(R.id.lbl_detalle_catalogo_descripcion);



        }
        void  setOnClickListener(){
            img_articulo.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,Catalogo_Detalles.class);
            intent.putExtra("clave",clave.getText());
            intent.putExtra("articulo",articulo.getText());
            intent.putExtra("formula",Integer.parseInt(formula.getText().toString()));
            intent.putExtra("precio",Integer.parseInt(precio.getText().toString()));
            context.startActivity(intent);

        }
    }
}
