package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.iguano_s.mashogarsupervisor.BaseDatos.ayudaBD;
import com.example.iguano_s.mashogarsupervisor.adaptadores.AdaptadorArticulo;
import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosArticulo;
import com.example.iguano_s.mashogarsupervisor.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CatalogoLocal extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_local);
        rv=(RecyclerView)findViewById(R.id.rv_articulos_local);
        LinearLayoutManager llm = new LinearLayoutManager((this));
        rv.setLayoutManager(llm);
        List<DatosArticulo> listaArtticulos;

        Bitmap imagen = null;
        final ArrayList<DatosArticulo> listaarreglo = new ArrayList<DatosArticulo>();
        ayudaBD BD = new ayudaBD(getApplicationContext());
        if (BD != null) ;
        {
            SQLiteDatabase consulta = BD.getReadableDatabase();
            Cursor c = consulta.rawQuery("select * from articulos_catalogo order by articulo", null);
            File imgFile2 = new File(Environment.getExternalStorageDirectory()+ "/pictures/Catalogo/busqueda.png");
            imagen = BitmapFactory.decodeFile(imgFile2.getAbsolutePath());
            if (c.moveToFirst()) {
                do {
/*
                    File imgFile = new File(Environment.getExternalStorageDirectory()+ "/pictures/Catalogo/"+c.getString(0)+".jpg");

                    if(imgFile.exists()) {

                        imagen = BitmapFactory.decodeFile(imgFile.getAbsolutePath());



                    }else {
                        File imgFile2 = new File(Environment.getExternalStorageDirectory()+ "/pictures/Catalogo/busqueda.png");
                        imagen = BitmapFactory.decodeFile(imgFile2.getAbsolutePath());}
*/

                    DatosArticulo listaArticulos = new DatosArticulo( imagen, c.getString(0), c.getString(1), c.getString(4), c.getString(2),c.getString(3));
                    listaarreglo.add(listaArticulos);
                } while (c.moveToNext());
            }
            AdaptadorArticulo adaptadorRV = new AdaptadorArticulo(listaarreglo);
            rv.setAdapter(adaptadorRV);
        }
        /*for(int i=0;i<ja.length();i+=5){

            try {

                DatosArticulo listaArticulos = new DatosArticulo(ja.getString(i), ja.getString(i + 1), ja.getString(i + 2), ja.getString(i + 3),ja.getString(i + 4));
                listaarreglo.add(listaArticulos);

                // lista.add(ja.getString(i)+" "+ja.getString(i+1)+" "+ja.getString(i+2)+" "+ja.getString(i+3));
            } catch (JSONException e) {
                e.printStackTrace();

            }

        }

        AdaptadorArticulo adaptadorRV = new AdaptadorArticulo(listaarreglo);
        rv.setAdapter(adaptadorRV);*/


    }

    public static class BuscarCliente extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_buscar_cliente);

        }
    }
}
