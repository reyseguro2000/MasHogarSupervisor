package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iguano_s.mashogarsupervisor.BaseDatos.ayudaBD;
import com.example.iguano_s.mashogarsupervisor.R;

import java.util.ArrayList;

public class tarjeta_virtual extends AppCompatActivity {

    TextView lbl_tar_ruta,lbl_tar_venta, lbl_cliente, lbl_nombre, lbl_direccion,lbl_casa_datos, lbl_conyuge, lbl_fecha, lbl_plazo,
            lbl_vence, lbl_estado, lbl_total, lbl_enganche, lbl_descuento, lbl_saldo, lbl_pagos_de, lbl_pago_recomendado;

    Button btn_ref1,btn_ref2,btn_aval,btn_agregar_pago,btn_agregar_indicacion;
    ListView ListaPagos, ListaArreglos, ListaArticulos;
    private ArrayAdapter<String> adaptador1;
    private ArrayList<String >PagosLista,ArticulosLista,ArreglosLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta_virtual);
        String venta="";
        lbl_tar_ruta=(TextView)findViewById(R.id.lbl_tar_ruta);
        lbl_tar_venta=(TextView)findViewById(R.id.lbl_tar_venta);

        lbl_cliente=(TextView)findViewById(R.id.lbl_tar_cliente);
        lbl_nombre=(TextView)findViewById(R.id.lbl_tar_nombre);
        lbl_direccion=(TextView)findViewById(R.id.lbl_tar_direccion);
        lbl_casa_datos=(TextView)findViewById(R.id.lbl_tar_casa_datos);
        lbl_conyuge=(TextView)findViewById(R.id.lbl_conyuge);
        lbl_fecha=(TextView)findViewById(R.id.lbl_tar_fecha);
        lbl_plazo=(TextView)findViewById(R.id.lbl_tar_plazo);
        lbl_vence=(TextView)findViewById(R.id.lbl_tar_vence);
        lbl_estado=(TextView)findViewById(R.id.lbl_tar_estado);
        lbl_total=(TextView)findViewById(R.id.lbl_tar_total);
        lbl_enganche=(TextView)findViewById(R.id.lbl_tar_enganche);
        lbl_descuento=(TextView)findViewById(R.id.lbl_tar_descuento);
        lbl_saldo=(TextView)findViewById(R.id.lbl_tar_saldo);
        lbl_pagos_de=(TextView)findViewById(R.id.lbl_tar_pago_contrato);
        lbl_pago_recomendado=(TextView)findViewById(R.id.lbl_tar_pago_recomendado);

        btn_ref1=(Button)findViewById(R.id.btn_tar_ref1);
        btn_ref2=(Button)findViewById(R.id.btn_tar_ref2);
        btn_aval=(Button)findViewById(R.id.btn_tar_aval);

        btn_agregar_pago=(Button)findViewById(R.id.boton_agregar_pago);
        btn_agregar_indicacion=(Button)findViewById(R.id.boton_agregar_arreglo);

        ListaArticulos=(ListView)findViewById(R.id.lista_tar_articulos);
        ListaPagos=(ListView)findViewById(R.id.lista_tar_pagos);
        ListaArreglos=(ListView)findViewById(R.id.lista_tar_arreglos);

        Bundle extras=getIntent().getExtras();
        if (extras!= null){
            venta=extras.getString("venta");
            llena_tarjeta_virtual(venta);


        }else {
            lbl_tar_venta.setText("No ai");
        }

    }


    public void llena_tarjeta_virtual(String venta){
        lbl_tar_venta.setText((venta));
        ayudaBD BD = new ayudaBD(getApplicationContext());
        if (BD != null) ;
        {
            SQLiteDatabase consulta = BD.getReadableDatabase();
            Cursor c = consulta.rawQuery("select *  from ventas where clave_venta='"+lbl_tar_venta.getText()+"'", null);
            if (c.moveToFirst()) {



                lbl_cliente.setText(c.getString(1));
                lbl_tar_ruta.setText(c.getString(2));
                lbl_fecha.setText(c.getString(3));
                lbl_plazo.setText(c.getString(4));

                lbl_total.setText(c.getString(6));
                lbl_enganche.setText(c.getString(7));
                lbl_descuento.setText(c.getString(8));
                lbl_saldo.setText(c.getString(9));


                lbl_vence.setText(c.getString(0));
                lbl_estado.setText(c.getString(0));

                lbl_pagos_de.setText(c.getString(0));
                lbl_pago_recomendado.setText(c.getString(0));

                Cursor cursorCliente = consulta.rawQuery("select * from clientes where clave_cliente='"+c.getString(1)+"'",null);
                if (cursorCliente.moveToFirst()){



                    lbl_nombre.setText(cursorCliente.getString(2));

                   lbl_direccion.setText(cursorCliente.getString(3)+c.getString(4));
                    lbl_casa_datos.setText(cursorCliente.getString(9));
                    lbl_conyuge.setText(c.getString(1));
                }else {
                    Toast.makeText(getApplicationContext(), "Error al cargar cliente", Toast.LENGTH_SHORT).show();

                }

                Cursor cursorArticulos=consulta.rawQuery("select cantidad, clave_articulo, articulo,precio from articulos_venta where venta='"+lbl_tar_venta.getText()+"'",null);
                if (cursorArticulos.moveToFirst()){

                    ArticulosLista=new ArrayList<String>();
                    do {

                        ArticulosLista.add(cursorArticulos.getString(0)+"  "+cursorArticulos.getString(1)+"  "+cursorArticulos.getString(2)+"  "+cursorArticulos.getString(3));


                    } while (cursorArticulos.moveToNext());
                    adaptador1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ArticulosLista);
                    ListaArticulos.setAdapter(adaptador1);

                }else {
                    Toast.makeText(getApplicationContext(), "Error al cargar articulos", Toast.LENGTH_SHORT).show();

                }





                Cursor cursorPagos=consulta.rawQuery("select * from pagos_echos where venta='"+lbl_tar_venta.getText()+"'",null);
                if (cursorPagos.moveToFirst()){

                    PagosLista=new ArrayList<String>();
                    do {

                        PagosLista.add(cursorPagos.getString(0)+"  "+cursorPagos.getString(2)+"   "+cursorPagos.getString(3));


                    } while (cursorPagos.moveToNext());
                    adaptador1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,PagosLista);
                    ListaPagos.setAdapter(adaptador1);

                }else {
                    Toast.makeText(getApplicationContext(), "Error al cargar pagos", Toast.LENGTH_SHORT).show();

                }





/*

*/



            } else {
                Toast.makeText(getApplicationContext(), "Error al cargar venta", Toast.LENGTH_SHORT).show();

            }
        }

    }

    public void OnClicAgregarPago(View v){
        Intent intentAgregarPago= new Intent(this,agregarPago.class);
        intentAgregarPago.putExtra("venta",lbl_tar_venta.getText().toString());
        intentAgregarPago.putExtra("ruta",lbl_tar_ruta.getText().toString());
        intentAgregarPago.putExtra("cliente",lbl_cliente.getText().toString());
        intentAgregarPago.putExtra("nombre",lbl_nombre.getText().toString());
        intentAgregarPago.putExtra("saldo",lbl_saldo.getText().toString());

        startActivity(intentAgregarPago);

    }

    public void OnClicAgregarIndicacion(View v){
        Intent intentAgregarIndicacion= new Intent(this,SeleccionarLista.agregarIndicacion.class);
        intentAgregarIndicacion.putExtra("venta",lbl_tar_venta.getText().toString());
        intentAgregarIndicacion.putExtra("ruta",lbl_tar_ruta.getText().toString());
        intentAgregarIndicacion.putExtra("cliente",lbl_cliente.getText().toString());
        intentAgregarIndicacion.putExtra("nombre",lbl_nombre.getText().toString());
        intentAgregarIndicacion.putExtra("saldo",lbl_saldo.getText().toString());
        startActivity(intentAgregarIndicacion);

    }

}
