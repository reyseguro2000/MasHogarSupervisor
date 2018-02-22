package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.iguano_s.mashogarsupervisor.BaseDatos.ayudaBD;
import com.example.iguano_s.mashogarsupervisor.R;

import java.util.ArrayList;

/**
 * Created by IGUANO-S on 23/09/2017.
 */
public  class BuscarClientes extends AppCompatActivity {

    ListView ListaClientes;
    private ArrayAdapter<String> adaptador1;
    private ArrayList<String >ClientesLista;
    EditText filtro;
    Button btn_direccion,btn_nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_cliente);

        filtro=(EditText)findViewById(R.id.txt_busqueda_buscar);
        btn_nombre=(Button)findViewById(R.id.btn_busqueda_nombre);
        btn_direccion=(Button)findViewById(R.id.btn_busqueda_direccion);
        ListaClientes=(ListView)findViewById(R.id.lista_busqueda_clientes);

    }

    public void clicBuscarNombre(View v){
        ayudaBD BD = new ayudaBD(getApplicationContext());
        if (BD != null) ;
        {
            SQLiteDatabase consulta = BD.getReadableDatabase();

            Cursor cursorClientes=consulta.rawQuery("select saldo, nombre, cliente,clave_venta, calle  from ventas,clientes where clave_cliente=cliente and nombre like '%"+filtro.getText()+"%'",null);
            if (cursorClientes.moveToFirst()){

                ClientesLista=new ArrayList<String>();
                do {

                    ClientesLista.add(cursorClientes.getString(3)+"  "+cursorClientes.getString(1)+"  "+cursorClientes.getString(4)+"  "+cursorClientes.getString(0));


                } while (cursorClientes.moveToNext());

                adaptador1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ClientesLista);
                ListaClientes.setAdapter(adaptador1);
            }else {
                Toast.makeText(getApplicationContext(), "Error al cargar articulos", Toast.LENGTH_SHORT).show();

            }
        }




    }
    public void clicBuscarDireccion(View v){
        ayudaBD BD = new ayudaBD(getApplicationContext());
        if (BD != null) ;
        {

            SQLiteDatabase consulta = BD.getReadableDatabase();
            Cursor cursorClientes=consulta.rawQuery("select saldo, nombre, cliente,clave_venta, calle,colonia,ciudad  from ventas,clientes where clave_cliente=cliente and (calle like '%"+filtro.getText()+"%' or colonia like '%"+filtro.getText()+"%' or ciudad like '%"+filtro.getText()+"%')",null);
            //final ArrayList<DatosListados> listaarreglo = new ArrayList<DatosListados>();
            if (cursorClientes.moveToFirst()){
               /* do {

                    DatosListados listaVentas = new DatosListados(cursorClientes.getString(0).toString(), cursorClientes.getString(1).toString(), cursorClientes.getString(2).toString(), cursorClientes.getString(3).toString(), cursorClientes.getString(4).toString(), "2", "1000","atrazo", cursorClientes.getString(6).toString(), "fvence", cursorClientes.getString(7).toString(), cursorClientes.getString(8).toString(), cursorClientes.getString(9).toString());
                    listaarreglo.add(listaVentas);
                } while (cursorClientes.moveToNext());

                AdaptadorListado adaptadorRV = new AdaptadorListado(listaarreglo);
                rv_listado.setAdapter(adaptadorRV);*/


                ClientesLista=new ArrayList<String>();
                do {

                    ClientesLista.add(cursorClientes.getString(3)+"  "+cursorClientes.getString(1)+"  "+cursorClientes.getString(4)+"  "+cursorClientes.getString(0));


                } while (cursorClientes.moveToNext());
                adaptador1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ClientesLista);
                ListaClientes.setAdapter(adaptador1);

            }else {
                Toast.makeText(getApplicationContext(), "Error al cargar articulos", Toast.LENGTH_SHORT).show();

            }
        }




    }
}
