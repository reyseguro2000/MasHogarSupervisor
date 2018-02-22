package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iguano_s.mashogarsupervisor.BaseDatos.ayudaBD;
import com.example.iguano_s.mashogarsupervisor.BaseDatos.contrato_mas_hogar;
import com.example.iguano_s.mashogarsupervisor.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class agregarPago extends AppCompatActivity {
    EditText txtCantidad;
    TextView lbl_pago_saldo,lbl_resultado;
    TextView  lbl_pag_venta,lbl_pag_ruta,lbl_pag_nombre,lbl_pag_cliente,lbl_pag_no_recibo;
    Integer no_recibo;
    Button btn_guardar;
    String venta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_pago);
        txtCantidad=(EditText)findViewById(R.id.txt_cantidad_recibo);
        lbl_pag_venta=(TextView)findViewById(R.id.lbl_pag_venta);
        lbl_pag_no_recibo=(TextView)findViewById(R.id.lbl_pag_no_recibo);
        lbl_pag_ruta=(TextView)findViewById(R.id.lbl_pago_nuevo_ruta);
        lbl_pag_nombre=(TextView)findViewById(R.id.lbl_pag_nombre);
        lbl_pag_cliente=(TextView)findViewById(R.id.lbl_pag_cliente);

        lbl_pago_saldo=(TextView)findViewById(R.id.lbl_pag_saldo);
        lbl_resultado=(TextView)findViewById(R.id.lbl_pag_resultado);
        btn_guardar=(Button)findViewById(R.id.btn_guarda_recibo);

        Bundle extras=getIntent().getExtras();
        if (extras!= null){
            venta=extras.getString("venta");

            lbl_pag_venta.setText((venta));
            lbl_pag_ruta.setText(extras.getString("ruta"));
            lbl_pag_cliente.setText(extras.getString("cliente"));
            lbl_pag_nombre.setText(extras.getString("nombre"));
            lbl_pago_saldo.setText(extras.getString("saldo"));

        }else {
            lbl_pag_venta.setText("No ai");
        }

        ayudaBD BD = new ayudaBD(getApplicationContext());
        if (BD != null) ;
        {
            SQLiteDatabase consulta = BD.getReadableDatabase();
            Cursor c = consulta.rawQuery("select bodega,consecutivo from cofiguracion ", null);
            if (c.moveToFirst()) {


                no_recibo=c.getInt(1);
                lbl_pag_no_recibo.setText(c.getString(0)+lbl_pag_ruta.getText()+"-"+c.getString(1));
            }
        }

    }
    public void clicResta(View V){
        Integer resultado;
        //lbl_cantidad2.setText(txtCantidad.getText().toString());

        resultado=Integer.parseInt(lbl_pago_saldo.getText().toString())-Integer.parseInt(txtCantidad.getText().toString());
        lbl_resultado.setText(resultado.toString());


    }
    public void clicGuardarRecibo(View V2){

        //lbl_resultado.setText("50");
        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd= ayudaBD.getWritableDatabase();

         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        ContentValues valoresPago = new ContentValues();
        valoresPago.put(contrato_mas_hogar.tabla_pagos_nuevos.columnaRecibo,lbl_pag_no_recibo.getText().toString());
        valoresPago.put(contrato_mas_hogar.tabla_pagos_nuevos.columnaVenta,lbl_pag_venta.getText().toString());
        valoresPago.put(contrato_mas_hogar.tabla_pagos_nuevos.columnaRuta,lbl_pag_ruta.getText().toString());
        valoresPago.put(contrato_mas_hogar.tabla_pagos_nuevos.columnaCantidad,txtCantidad.getText().toString());
        valoresPago.put(contrato_mas_hogar.tabla_pagos_nuevos.columnaFecha,simpleDateFormat.format(calendar.getTime()));

        Long idGuardado=bd.insert(contrato_mas_hogar.tabla_pagos_nuevos.TablaPagosNuevos,contrato_mas_hogar.tabla_pagos_nuevos._ID,valoresPago);

        bd.execSQL("update ventas set saldo=saldo-"+txtCantidad.getText().toString()+" where clave_venta='"+lbl_pag_venta.getText().toString()+"'");
        bd.execSQL("update cofiguracion set consecutivo=consecutivo+1");


        if (idGuardado>0){
            Toast.makeText(getApplicationContext(),"SE GUARDO EL DATO " +idGuardado.toString(),Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"ERROR AL GUARDAR EL DATO " ,Toast.LENGTH_LONG).show();
        }


    }

}
