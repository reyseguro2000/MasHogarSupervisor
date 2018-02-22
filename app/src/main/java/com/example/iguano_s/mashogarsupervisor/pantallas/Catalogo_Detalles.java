package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iguano_s.mashogarsupervisor.BaseDatos.ayudaBD;
import com.example.iguano_s.mashogarsupervisor.R;

import java.io.File;

public class Catalogo_Detalles extends AppCompatActivity {
TextView lbl_detalle_clave, lbl_detalle_articulo, lbl_contado,lbl_1_mes,lbl_2_mes,lbl_3_mes,lbl_4_mes,lbl_5_mes,lbl_6_mes,lbl_7_mes,lbl_8_mes,lbl_9_mes,lbl_10_mes,lbl_11_mes,lbl_12_mes,
    lbl_comicion,lbl_mayoreo,lbl_clave,lbl_articulo;
    ImageView imagen;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo__detalles);
        lbl_contado=(TextView)findViewById(R.id.lbl_detalle_articulo_contado);
        lbl_1_mes=(TextView)findViewById(R.id.lbl_detalle_1_mes);
        lbl_2_mes=(TextView)findViewById(R.id.lbl_detalle_2_mes);
        lbl_3_mes=(TextView)findViewById(R.id.lbl_detalle_3_mes);
        lbl_4_mes=(TextView)findViewById(R.id.lbl_detalle_4_mes);
        lbl_5_mes=(TextView)findViewById(R.id.lbl_detalle_5_mes);
        lbl_6_mes=(TextView)findViewById(R.id.lbl_detalle_6_mes);
        lbl_7_mes=(TextView)findViewById(R.id.lbl_detalle_7_mes);
        lbl_8_mes=(TextView)findViewById(R.id.lbl_detalle_8_mes);
        lbl_9_mes=(TextView)findViewById(R.id.lbl_detalle_9_mes);
        lbl_10_mes=(TextView)findViewById(R.id.lbl_detalle_10_mes);
        lbl_11_mes=(TextView)findViewById(R.id.lbl_detalle_11_mes);
        lbl_12_mes=(TextView)findViewById(R.id.lbl_detalle_12_mes);
        lbl_comicion=(TextView)findViewById(R.id.lbl_detalle_comicion);
        lbl_mayoreo=(TextView)findViewById(R.id.lbl_detalle_mayoreo);

        lbl_detalle_clave=(TextView)findViewById(R.id.lbl_detalle_articulo_clave);
        lbl_detalle_articulo=(TextView)findViewById(R.id.lbl_detalle_articulo);
        imagen=(ImageView)findViewById(R.id.img_detalles_articulo);

        String clave="";
        String articulo="";
        Integer formula=0;
        Integer precio=0;
        Double resultado= Double.valueOf(0);
        double porcentaje;// Double.valueOf(0);


        Bundle extras =getIntent().getExtras();
        if (extras!= null){
            clave=extras.getString("clave");
            articulo=extras.getString("articulo");
            formula=extras.getInt("formula");
            precio=extras.getInt("precio");

            lbl_detalle_clave.setText(clave);
            lbl_detalle_articulo.setText(articulo);


            ayudaBD BD = new ayudaBD(getApplicationContext());
            if (BD != null) ;
            {
                SQLiteDatabase consulta = BD.getReadableDatabase();
                Cursor c = consulta.rawQuery("select *  from precios_articulos_catalogo", null);
                if (c.moveToFirst()) {

                    switch (formula){
                        case 1:
                            i=0;
                            break;
                        case 2:
                            i=15;
                            break;
                        case 3:
                            i=30;
                            break;

                    }
/*
                    if (formula=='1');{
                        i=0;

                    }
                    if(formula=='2');{
                        i=15;
                    }
                    if(formula=='3');{
                        i=30;
                    }*/
                    porcentaje=c.getDouble(i+0);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_contado.setText(resultado.toString());

                    porcentaje=c.getDouble(i+1);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_1_mes.setText(resultado.toString());

                    porcentaje=c.getDouble(i+2);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_2_mes.setText(resultado.toString());

                    porcentaje=c.getDouble(i+3);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_3_mes.setText(resultado.toString());

                    porcentaje=c.getDouble(i+4);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_4_mes.setText(resultado.toString());

                    porcentaje=c.getDouble(i+5);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_5_mes.setText(resultado.toString());

                    porcentaje=c.getDouble(i+6);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_6_mes.setText(resultado.toString());

                    porcentaje=c.getDouble(i+7);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_7_mes.setText(resultado.toString());

                    porcentaje=c.getDouble(i+8);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_8_mes.setText(resultado.toString());

                    porcentaje=c.getDouble(i+9);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_9_mes.setText(resultado.toString());

                    porcentaje=c.getDouble(i+10);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_10_mes.setText(resultado.toString());

                    porcentaje=c.getDouble(i+11);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_11_mes.setText(resultado.toString());

                    porcentaje=c.getDouble(i+12);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_12_mes.setText(resultado.toString());



                    porcentaje=c.getDouble(i+14);
                    resultado=precio*porcentaje/100;
                    resultado=resultado+precio;
                    lbl_mayoreo.setText(resultado.toString());


                    porcentaje=c.getDouble(i+13);
                    resultado=Double.parseDouble((String) lbl_1_mes.getText())*porcentaje/100;
                    //resultado=resultado+precio;
                    lbl_comicion.setText(resultado.toString());
                    //lbl_1_mes.setText(formula.toString());
                    //lbl_2_mes.setText(precio.toString());


                }
            }




           File imgFile = new File(Environment.getExternalStoragePublicDirectory(
                   Environment.DIRECTORY_PICTURES), "/catalogo/" + clave + ".jpg");

            if(imgFile.exists()) {

                imagen.setImageBitmap( BitmapFactory.decodeFile(imgFile.getAbsolutePath()));



            }
        }
    }
}
