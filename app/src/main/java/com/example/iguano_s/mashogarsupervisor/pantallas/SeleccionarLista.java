package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iguano_s.mashogarsupervisor.BaseDatos.ayudaBD;
import com.example.iguano_s.mashogarsupervisor.R;
import com.example.iguano_s.mashogarsupervisor.adaptadores.AdaptadorListado;
import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosListados;

import java.util.ArrayList;
import java.util.List;

public class SeleccionarLista extends AppCompatActivity implements View.OnClickListener {
    RecyclerView rv_listado;
    EditText BuscaRuta;
    ImageButton img_lista1,img_lista2,img_lista3;
    TextView lbl_lista_seleccionada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_lista);

        rv_listado=(RecyclerView)findViewById(R.id.rv_lista_seleccionada);
        LinearLayoutManager llm = new LinearLayoutManager((this));
        rv_listado.setLayoutManager(llm);
        List<DatosListados> listaVentas;

        img_lista1=(ImageButton)findViewById(R.id.img_lista1);
        img_lista2=(ImageButton)findViewById(R.id.img_lista2);
        img_lista3=(ImageButton)findViewById(R.id.img_lista3);

        lbl_lista_seleccionada=(TextView)findViewById(R.id.lbl_lista_seleccionada);
        BuscaRuta=(EditText)findViewById(R.id.txt_ruta_seleccionada);

        img_lista1.setOnClickListener(this);
        img_lista2.setOnClickListener(this);
        img_lista3.setOnClickListener(this);


    }

public  void  Carga_lista_ventas(String noLista){
    String cadena_junta = null;

    final ArrayList<DatosListados> listaarreglo = new ArrayList<DatosListados>();
    ayudaBD BD = new ayudaBD(getApplicationContext());
    if (BD != null) ;
    {
        SQLiteDatabase consulta = BD.getReadableDatabase();
        Cursor cursorClientes = consulta.rawQuery("select total, enganche, descuento, saldo, plazo,forma, fecha, nombre, cliente,clave_venta,calle, colonia, ciudad from ventas,clientes where clave_cliente=cliente and ruta=" + BuscaRuta.getText(), null);
        if (cursorClientes.moveToFirst()) {
            cadena_junta= "RUTA "+ BuscaRuta.getText().toString()+ "  LISTA "+noLista+"  " + "  "+cursorClientes.getCount()+" VENTAS";

            lbl_lista_seleccionada.setText(cadena_junta );
            do {

                DatosListados listaVentas = new DatosListados(cursorClientes.getString(0).toString(), cursorClientes.getString(1).toString(), cursorClientes.getString(2).toString(), cursorClientes.getString(3).toString(), cursorClientes.getString(4).toString(), "2", "1000","atrazo", cursorClientes.getString(6).toString(), "fvence", cursorClientes.getString(7).toString(), cursorClientes.getString(8).toString(), cursorClientes.getString(9).toString(),cursorClientes.getString(5).toString(),cursorClientes.getString(10).toString(),cursorClientes.getString(11).toString(),cursorClientes.getString(12).toString());
                listaarreglo.add(listaVentas);
            } while (cursorClientes.moveToNext());

            AdaptadorListado adaptadorRV = new AdaptadorListado(listaarreglo);
            rv_listado.setAdapter(adaptadorRV);


        }else {

            Toast.makeText(getApplicationContext(), "Error al cargar cliente", Toast.LENGTH_SHORT).show();
        }
    }






}

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.img_lista1:


                Carga_lista_ventas("1");


                break;
            case R.id.img_lista2:
                lbl_lista_seleccionada.setText("RUTA "+ BuscaRuta.getText().toString()+ "  LISTA 2 ");
                break;
            case R.id.img_lista3:
                lbl_lista_seleccionada.setText("RUTA "+ BuscaRuta.getText().toString()+ "  LISTA 3 " );
                break;
        }

    }

    public static class agregarIndicacion extends AppCompatActivity {

        TextView lbl_ind_venta, lbl_ind_cliente, lbl_ind_nombre,lbl_ind_saldo;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_agregar_indicacion);
            String venta="";
            lbl_ind_venta=(TextView)findViewById(R.id.lbl_ind_venta);
            lbl_ind_cliente=(TextView)findViewById(R.id.lbl_ind_cliente);
            lbl_ind_nombre=(TextView)findViewById(R.id.lbl_ind_nombre);
            lbl_ind_saldo=(TextView)findViewById(R.id.lbl_ind_saldo);

            Bundle extras=getIntent().getExtras();
            if (extras!= null){
                venta=extras.getString("venta");
                lbl_ind_venta.setText((venta));
                lbl_ind_cliente.setText(extras.getString("cliente"));
                lbl_ind_nombre.setText(extras.getString("nombre"));
                lbl_ind_saldo.setText(extras.getString("saldo"));

            }else {
                lbl_ind_venta.setText("No ai");
            }
        }


    }
}
