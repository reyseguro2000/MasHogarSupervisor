package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iguano_s.mashogarsupervisor.BaseDatos.ayudaBD;
import com.example.iguano_s.mashogarsupervisor.R;
import com.example.iguano_s.mashogarsupervisor.adaptadores.AdaptadorRecibos;
import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosRecibos;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Reporte extends AppCompatActivity implements View.OnClickListener{

    RecyclerView rv_reportes_pagos;
    Button btn_cobrador,btn_supervisor,btn_total_cobrador;
    EditText txt_reporte_dia;
    TextView lbl_total_recibos,lbl_total_cobrado;
    Integer total_recibos,total_cobrado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        btn_cobrador=(Button)findViewById(R.id.btn_reporte_busqueda_cobrador);
        btn_total_cobrador=(Button)findViewById(R.id.btn_reporte_total_cobrador);
        btn_supervisor=(Button)findViewById(R.id.btn_reporte_busqueda_supervisor);
        lbl_total_recibos=(TextView)findViewById(R.id.lbl_reporte_total_recibos);
        lbl_total_cobrado=(TextView)findViewById(R.id.lbl_reporte_total_cobrado);
        txt_reporte_dia=(EditText)findViewById(R.id.txt_reporte_dia);
        txt_reporte_dia.setText(simpleDateFormat.format(calendar.getTime()));
        rv_reportes_pagos=(RecyclerView)findViewById(R.id.rv_reportes_pagos);
        total_cobrado= 0;
        total_recibos= 0;
        LinearLayoutManager llm = new LinearLayoutManager((this));
        rv_reportes_pagos.setLayoutManager(llm);
    }

    public void clicBuscarDiaCobrador(View v){
        final ArrayList<DatosRecibos> listaRecibos=new ArrayList<DatosRecibos>();
        ayudaBD BD = new ayudaBD(getApplicationContext());
        if (BD != null) ;
        {
            SQLiteDatabase consulta = BD.getReadableDatabase();
            Cursor CursorRecibos =consulta.rawQuery("select * from pagos_nuevos where fecha like '"+txt_reporte_dia.getText().toString()+"%'",null);
            if (CursorRecibos.moveToFirst()) {
                total_cobrado= 0;
                total_recibos= 0;
               do{
                   total_recibos++;
                   total_cobrado= total_cobrado+Integer.valueOf(CursorRecibos.getString(3));
                   DatosRecibos ListaRecibos=new DatosRecibos(CursorRecibos.getString(0),CursorRecibos.getString(3),CursorRecibos.getString(4),CursorRecibos.getString(1));
                   listaRecibos.add(ListaRecibos);

               }while (CursorRecibos.moveToNext());

                AdaptadorRecibos AdapatorRecibosRV = new AdaptadorRecibos(listaRecibos);

                rv_reportes_pagos.setAdapter(AdapatorRecibosRV);
                lbl_total_cobrado.setText(total_cobrado.toString());
                lbl_total_recibos.setText(total_recibos.toString());
            }else {

                Toast.makeText(getApplicationContext(), "Error al cargar cliente", Toast.LENGTH_SHORT).show();
            }


        }


    }

    public void clicBuscartotalCobrador(View v){
        final ArrayList<DatosRecibos> listaRecibos=new ArrayList<DatosRecibos>();
        ayudaBD BD = new ayudaBD(getApplicationContext());
        if (BD != null) ;
        {
            total_cobrado= 0;
            total_recibos= 0;
            SQLiteDatabase consulta = BD.getReadableDatabase();
            Cursor CursorRecibos =consulta.rawQuery("select * from pagos_nuevos",null);
            if (CursorRecibos.moveToFirst()) {
                do{
                    total_recibos++;
                    total_cobrado= total_cobrado+Integer.valueOf(CursorRecibos.getString(3));
                    DatosRecibos ListaRecibos=new DatosRecibos(CursorRecibos.getString(0),CursorRecibos.getString(3),CursorRecibos.getString(4),CursorRecibos.getString(1));
                    listaRecibos.add(ListaRecibos);


                }while (CursorRecibos.moveToNext());

                AdaptadorRecibos AdapatorRecibosRV = new AdaptadorRecibos(listaRecibos);

                rv_reportes_pagos.setAdapter(AdapatorRecibosRV);
                lbl_total_cobrado.setText(total_cobrado.toString());
                lbl_total_recibos.setText(total_recibos.toString());
            }else {

                Toast.makeText(getApplicationContext(), "Error al cargar cliente", Toast.LENGTH_SHORT).show();
            }


        }


    }


    public void clicBuscarDiaSupervisor(View v){

        final ArrayList<DatosRecibos> listaRecibos=new ArrayList<DatosRecibos>();
        ayudaBD BD = new ayudaBD(getApplicationContext());
        if (BD != null) ;
        {
            SQLiteDatabase consulta = BD.getReadableDatabase();
            Cursor CursorRecibos =consulta.rawQuery("select * from pagos_nuevos where fecha like '"+txt_reporte_dia.getText().toString()+"%'",null);
            if (CursorRecibos.moveToFirst()) {
                do{
                    DatosRecibos ListaRecibos=new DatosRecibos(CursorRecibos.getString(0),CursorRecibos.getString(2),CursorRecibos.getString(3),CursorRecibos.getString(1));
                    listaRecibos.add(ListaRecibos);


                }while (CursorRecibos.moveToNext());

                AdaptadorRecibos AdapatorRecibosRV = new AdaptadorRecibos(listaRecibos);

                rv_reportes_pagos.setAdapter(AdapatorRecibosRV);

            }else {

                Toast.makeText(getApplicationContext(), "Error al cargar cliente", Toast.LENGTH_SHORT).show();
            }


        }

    }

    @Override
    public void onClick(View v) {

    }
}
