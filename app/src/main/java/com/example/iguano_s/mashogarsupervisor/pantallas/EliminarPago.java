package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iguano_s.mashogarsupervisor.BaseDatos.ayudaBD;
import com.example.iguano_s.mashogarsupervisor.BaseDatos.contrato_mas_hogar;
import com.example.iguano_s.mashogarsupervisor.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EliminarPago extends AppCompatActivity {

    TextView venta, cantidad, recibo, fecha;
    Button btn_eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_pago);
        venta=(TextView)findViewById(R.id.lbl_eliminar_recibos_venta);
        cantidad=(TextView)findViewById(R.id.lbl_eliminar_recibos_cantidad);
        recibo=(TextView)findViewById(R.id.lbl_eliminar_recibos_recibo);
        fecha=(TextView)findViewById(R.id.lbl_eliminar_recibos_fecha);
        btn_eliminar=(Button)findViewById(R.id.btn_eliminar_recibo);
        Bundle extras=getIntent().getExtras();
        if (extras!= null) {
            venta.setText( extras.getString("venta"));
            cantidad.setText( extras.getString("cantidad"));
            recibo.setText( extras.getString("recibo"));
            fecha.setText( extras.getString("fecha"));
        }
    }
    public void onClicEliminarRecibo(View v){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd= ayudaBD.getWritableDatabase();
        bd.execSQL("delete from pagos_nuevos where recibo='"+recibo.getText().toString()+"'");
        bd.execSQL("update ventas set saldo=saldo+"+cantidad.getText().toString()+" where clave_venta='"+venta.getText().toString()+"'");
        ContentValues valoresPagoCancelado = new ContentValues();
        valoresPagoCancelado.put(contrato_mas_hogar.tabla_pagos_cancelados.columnaRecibo,recibo.getText().toString());
        valoresPagoCancelado.put(contrato_mas_hogar.tabla_pagos_cancelados.columnaVenta,venta.getText().toString());
       // valoresPagoCancelado.put(contrato_mas_hogar.tabla_pagos_cancelados.columnaRuta,lbl_pag_ruta.getText().toString());
        valoresPagoCancelado.put(contrato_mas_hogar.tabla_pagos_cancelados.columnaCantidad,cantidad.getText().toString());
        valoresPagoCancelado.put(contrato_mas_hogar.tabla_pagos_cancelados.columnaFecha,fecha.getText().toString());
        valoresPagoCancelado.put(contrato_mas_hogar.tabla_pagos_cancelados.columnaFechaCancelado,simpleDateFormat.format(calendar.getTime()));

        Long idGuardado=bd.insert(contrato_mas_hogar.tabla_pagos_cancelados.TablaPagosCancelados,contrato_mas_hogar.tabla_pagos_cancelados._ID,valoresPagoCancelado);
        if (idGuardado>0){
            Toast.makeText(getApplicationContext(),"SE GUARDO EL DATO " +idGuardado.toString(),Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"ERROR AL GUARDAR EL DATO " ,Toast.LENGTH_LONG).show();
        }
    }

}
