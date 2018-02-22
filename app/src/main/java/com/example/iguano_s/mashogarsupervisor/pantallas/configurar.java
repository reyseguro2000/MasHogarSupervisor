package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.iguano_s.mashogarsupervisor.BaseDatos.ayudaBD;
import com.example.iguano_s.mashogarsupervisor.BaseDatos.contrato_mas_hogar;
import com.example.iguano_s.mashogarsupervisor.R;
import com.example.iguano_s.mashogarsupervisor.adaptadores.AdaptadorArticulo;
import com.example.iguano_s.mashogarsupervisor.adaptadores.AdaptadorRuta;
import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosArticulo;
import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosRutas;

import org.json.JSONException;

import java.io.File;
import java.util.ArrayList;

public class configurar extends AppCompatActivity {

    EditText txt_nombre, txt_pass, txt_puesto, txt_recibo, txt_ruta, txt_no, txt_bodega;
    RecyclerView recicla_rutas;
    Button btn_guardar_usuario, btn_eliminar_usuario, btn_guardar_ruta, btn_eliminar_ruta;
    private ArrayAdapter<String> adaptador1;
    private ArrayList<String>RutasLista;
    ListView listaRuta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);
        txt_no=(EditText)findViewById(R.id.txt_configura_no);
        txt_bodega=(EditText)findViewById(R.id.txt_configura_bodega);
        txt_nombre=(EditText)findViewById(R.id.txt_configura_nombre);
        txt_pass=(EditText)findViewById(R.id.txt_configua_pass);
        txt_puesto=(EditText)findViewById(R.id.txt_configua_puesto);
        txt_recibo=(EditText)findViewById(R.id.txt_configua_recibo);
        txt_ruta=(EditText)findViewById(R.id.txt_configua_ruta);
        btn_guardar_usuario=(Button)findViewById(R.id.btn_configurar_guardar_nombre);
        btn_eliminar_usuario=(Button)findViewById(R.id.btn_configurar_eliniar_nombre);
        btn_guardar_ruta=(Button)findViewById(R.id.btn_configurar_agragar_ruta);
        btn_eliminar_ruta=(Button)findViewById(R.id.btn_configurar_eliniar_ruta);
        recicla_rutas=(RecyclerView)findViewById(R.id.rv_configurar_rutas);
        listaRuta=(ListView)findViewById(R.id.lista_configura_ruta);

        final ArrayList<DatosRutas> listaarregloruta = new ArrayList<DatosRutas>();
        ayudaBD BD = new ayudaBD(getApplicationContext());
        if (BD != null) ;
        {
            SQLiteDatabase consulta = BD.getReadableDatabase();
            Cursor c = consulta.rawQuery("select * from cofiguracion", null);
            if (c.moveToFirst()) {
                txt_no.setText(c.getString(0));
                txt_bodega.setText(c.getString(1));
                txt_nombre.setText(c.getString(2));
                txt_pass.setText(c.getString(3));
               txt_recibo.setText(c.getString(4));
                txt_puesto.setText(c.getString(5));
            }else{
                Toast.makeText(getApplicationContext(), "Error al cargar", Toast.LENGTH_SHORT).show();

            }

            Cursor cursorRutas=consulta.rawQuery("select * from rutas",null);
            if (cursorRutas.moveToFirst()){

                RutasLista=new ArrayList<String>();
                do {

                    RutasLista.add("Ruta: "+cursorRutas.getString(0));

                    DatosRutas listaRutas = new DatosRutas( cursorRutas.getString(0), cursorRutas.getString(1), cursorRutas.getString(2));
                    listaarregloruta.add(listaRutas);
                } while (cursorRutas.moveToNext());
                adaptador1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,RutasLista);
                listaRuta.setAdapter(adaptador1);
            }


/*
            AdaptadorRuta adaptadorRV = new AdaptadorRuta(listaarregloruta);
            recicla_rutas.setAdapter(adaptadorRV);*/


        }
    }




    public void clicGuardarUsuario(View vista){
        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd= ayudaBD.getWritableDatabase();


            try {

                ContentValues valoresUsuario = new ContentValues();
                valoresUsuario.put(contrato_mas_hogar.tabla_configuracion.columnaClavePersonal,txt_no.getText().toString());

                valoresUsuario.put(contrato_mas_hogar.tabla_configuracion.columnabodega,txt_bodega.getText().toString());
                valoresUsuario.put(contrato_mas_hogar.tabla_configuracion.columnanombre,txt_nombre.getText().toString());
                valoresUsuario.put(contrato_mas_hogar.tabla_configuracion.columnaPass,txt_pass.getText().toString());
                valoresUsuario.put(contrato_mas_hogar.tabla_configuracion.columnaConsecutivo,txt_recibo.getText().toString());
                valoresUsuario.put(contrato_mas_hogar.tabla_configuracion.columnaPuesto,txt_puesto.getText().toString());

                Long idGuardado=bd.insert(contrato_mas_hogar.tabla_configuracion.TablaConfiguracion,contrato_mas_hogar.tabla_configuracion._ID,valoresUsuario);

                if (idGuardado>0){
                    Toast.makeText(getApplicationContext(),"SE GUARDO EL DATO " +idGuardado.toString(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"No se que demonios a pasao " ,Toast.LENGTH_LONG).show();
                }


            } catch (Exception e) {
                e.printStackTrace();

            }




    }
    public void clicEliminarUsuario(View vista){

        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd= ayudaBD.getWritableDatabase();
        ayudaBD.CreaUsuario(bd);
    }


    public void clicGuardarRuta(View vista){
        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd= ayudaBD.getWritableDatabase();


        try {

            ContentValues valoresRuta = new ContentValues();
            valoresRuta.put(contrato_mas_hogar.tabla_rutas.columnaRuta,txt_ruta.getText().toString());
            valoresRuta.put(contrato_mas_hogar.tabla_rutas.columnaatrazadas,"1");

            valoresRuta.put(contrato_mas_hogar.tabla_rutas.columnaActualizada,"1");



            Long idGuardado=bd.insert(contrato_mas_hogar.tabla_rutas.TablaRutas,contrato_mas_hogar.tabla_rutas._ID,valoresRuta);

            if (idGuardado>0){
                Toast.makeText(getApplicationContext(),"SE GUARDO EL DATO " +idGuardado.toString(),Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"No se que demonios a pasao " ,Toast.LENGTH_LONG).show();
            }


        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    public void clicEliminarRuta(View vista){

        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd= ayudaBD.getWritableDatabase();
        ayudaBD.CreaRuta(bd);
    }

}
