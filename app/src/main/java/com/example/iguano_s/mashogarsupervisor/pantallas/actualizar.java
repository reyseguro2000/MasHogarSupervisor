package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.iguano_s.mashogarsupervisor.BaseDatos.ayudaBD;
import com.example.iguano_s.mashogarsupervisor.BaseDatos.contrato_mas_hogar;
import com.example.iguano_s.mashogarsupervisor.R;
import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosRecibos;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class actualizar extends AppCompatActivity {

    Button btn_actualiza_subir, btn_actrualiza_bajar;

    EditText txt_ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);
        txt_ip=(EditText)findViewById(R.id.txt_actualiza_ip);
        btn_actualiza_subir=(Button)findViewById(R.id.btn_actualizar_subir);
        btn_actrualiza_bajar=(Button)findViewById(R.id.btn_actualizar_bajar);

 
    }


    public void clicActualizaArticulos(View v) {
        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd = ayudaBD.getWritableDatabase();
        ayudaBD.CreaArticulos(bd);
       // EnviarDatosArticulos("http://radioxxxiguanoxxx.no-ip.biz:8080/mashogar/consulta_articulos.php");
        //EnviarDatosPreciosArticulos("http://radioxxxiguanoxxx.no-ip.biz:8080/mashogar/consulta_precios_articulos.php");
       EnviarDatosArticulos(txt_ip.getText()+":8001/mashogar/consulta_articulos.php");
       EnviarDatosPreciosArticulos(txt_ip.getText()+":8001/mashogar/consulta_precios_articulos.php");

    }

    public void clicActualizaSubir(View v) {

        ayudaBD BD = new ayudaBD(getApplicationContext());
        if (BD != null) ;
        {
            SQLiteDatabase consulta = BD.getReadableDatabase();
            Cursor CursorRecibos =consulta.rawQuery("select * from pagos_nuevos",null);
            if (CursorRecibos.moveToFirst()) {
                do{
                    DatosRecibos ListaRecibos=new DatosRecibos(CursorRecibos.getString(0),CursorRecibos.getString(2),CursorRecibos.getString(3),CursorRecibos.getString(1));

                    new CargarDatos().execute(txt_ip.getText()+":8001/mashogar/registro_pagos.php?recibo="+CursorRecibos.getString(0)+"&venta="+CursorRecibos.getString(1)+"&ruta="+CursorRecibos.getString(2)+"&cantidad="+CursorRecibos.getString(3)+"&fecha="+CursorRecibos.getString(4));

                }while (CursorRecibos.moveToNext());



            }else {

                Toast.makeText(getApplicationContext(), "Error al cargar cliente", Toast.LENGTH_SHORT).show();
            }


        }

        //btn_actrualiza_bajar.getVisibility();

    }

    private class CargarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            Toast.makeText(getApplicationContext(), "Se almacenaron los datos correctamente", Toast.LENGTH_LONG).show();

        }
    }

    private String downloadUrl(String myurl) throws IOException {
        Log.i("URL",""+myurl);
        myurl = myurl.replace(" ","%20");
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("respuesta", "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }


    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }

    public void clicActualizaBajar(View v) {
        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd = ayudaBD.getWritableDatabase();
        Cursor cusaruio =bd.rawQuery("select * from rutas",null);
        ayudaBD.ActualizaDatos(bd);

        if (cusaruio.moveToFirst()){

            do {
                EnviarDatosClientes(txt_ip.getText()+":8001/mashogar/consulta_clientes_activos.php?ruta="+cusaruio.getString(0).toString());
                EnviarDatosVentas(txt_ip.getText()+":8001/mashogar/consulta_ventas_activas.php?ruta="+cusaruio.getString(0).toString());
                EnviarDatosArticulosVentas(txt_ip.getText()+":8001/mashogar/consulta_articulos_ventas_activas.php?ruta="+cusaruio.getString(0).toString());
                EnviarDatosPagos(txt_ip.getText()+":8001/mashogar/consulta_pagos_activas.php?ruta="+cusaruio.getString(0).toString());

            } while (cusaruio.moveToNext());
        }
    }

    public void EnviarDatosClientes(String URL){
        Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();

        RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        llena_base_clientes(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener(){
            @Override

            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR cliente"+ error, Toast.LENGTH_LONG).show();
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                100000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(stringRequest);
    }

    public void llena_base_clientes(JSONArray ja) {
        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd = ayudaBD.getWritableDatabase();
       // Toast.makeText(getApplicationContext(), "VOY A EMPEZAR clientes ", Toast.LENGTH_SHORT).show();
        for (int i = 0; i < ja.length(); i += 18) {

            try {

                ContentValues valoresClientes = new ContentValues();
                valoresClientes.put(contrato_mas_hogar.tabla_clietnes.columnaClientes, ja.getString(i));
                valoresClientes.put(contrato_mas_hogar.tabla_clietnes.columnaIfe, ja.getString(i + 1));
                valoresClientes.put(contrato_mas_hogar.tabla_clietnes.columnaNombre, ja.getString(i + 2));
                valoresClientes.put(contrato_mas_hogar.tabla_clietnes.columnaCalle, ja.getString(i + 3));
                valoresClientes.put(contrato_mas_hogar.tabla_clietnes.columnaColonia, ja.getString(i + 4));
                valoresClientes.put(contrato_mas_hogar.tabla_clietnes.columnaCiudad, ja.getString(i + 5));
                valoresClientes.put(contrato_mas_hogar.tabla_clietnes.columnaTelefono, ja.getString(i + 6));
                valoresClientes.put(contrato_mas_hogar.tabla_clietnes.columnaCasa, ja.getString(i + 7));
                valoresClientes.put(contrato_mas_hogar.tabla_clietnes.columnaDocumento, ja.getString(i + 8));
                valoresClientes.put(contrato_mas_hogar.tabla_clietnes.columnaCasaDatos, ja.getString(i + 9));
                valoresClientes.put(contrato_mas_hogar.tabla_clietnes.columnaCalificacion, ja.getString(i + 10));

                Long idGuardado = bd.insert(contrato_mas_hogar.tabla_clietnes.TablaClientes, contrato_mas_hogar.tabla_clietnes._ID, valoresClientes);

            } catch (JSONException e) {
                e.printStackTrace();

            }

        }
       // Toast.makeText(getApplicationContext(), "YA TERMINE  cliente", Toast.LENGTH_SHORT).show();
    }



    public void EnviarDatosVentas(String URL){
       // Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();

        RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        llena_base_Venta(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener(){
            @Override

            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR VEnta"+error, Toast.LENGTH_SHORT).show();
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                100000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(stringRequest);
    }

    public void llena_base_Venta(JSONArray ja) {
        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd = ayudaBD.getWritableDatabase();
        //Toast.makeText(getApplicationContext(), "VOY A EMPEZAR ventas ", Toast.LENGTH_SHORT).show();
        for (int i = 0; i < ja.length(); i += 13) {

            try {

                ContentValues valoresVenta = new ContentValues();
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaVenta, ja.getString(i));
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaCliente, ja.getString(i + 1));
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaRuta, ja.getString(i + 2));
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaFecha, ja.getString(i + 3));
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaPlazo, ja.getString(i + 4));
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaForma, ja.getString(i + 5));
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaTotal, ja.getString(i + 6));
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaEnganche, ja.getString(i + 7));
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaDescuento, ja.getString(i + 8));
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaSaldo, ja.getString(i + 9));
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaVendedor, ja.getString(i + 10));
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaFolio, ja.getString(i + 11));
                valoresVenta.put(contrato_mas_hogar.tabla_ventas.columnaTipoDesc, ja.getString(i + 12));



                Long idGuardado = bd.insert(contrato_mas_hogar.tabla_ventas.TablaRuta, contrato_mas_hogar.tabla_ventas._ID, valoresVenta);

            } catch (JSONException e) {
                e.printStackTrace();

            }

        }
        //Toast.makeText(getApplicationContext(), "YA TERMINE ventas ", Toast.LENGTH_LONG).show();
    }




    public void EnviarDatosArticulosVentas(String URL){
       // Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();

        RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        llena_base_articulos_venta(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener(){
            @Override

            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR articulos"+error, Toast.LENGTH_SHORT).show();
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                100000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(stringRequest);
    }

    public void llena_base_articulos_venta(JSONArray ja) {
        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd = ayudaBD.getWritableDatabase();
       // Toast.makeText(getApplicationContext(), "VOY A EMPEZAR articulos", Toast.LENGTH_SHORT).show();
        for (int i = 0; i < ja.length(); i += 8) {

            try {

                ContentValues valoresArticulosVentas = new ContentValues();
                valoresArticulosVentas.put(contrato_mas_hogar.tabla_articulos_venta.columnaVenta, ja.getString(i+1));
                valoresArticulosVentas.put(contrato_mas_hogar.tabla_articulos_venta.columnaCantidad, ja.getString(i + 2));
                valoresArticulosVentas.put(contrato_mas_hogar.tabla_articulos_venta.columnaArticulo, ja.getString(i + 4));
                valoresArticulosVentas.put(contrato_mas_hogar.tabla_articulos_venta.columnaClave_articulo, ja.getString(i + 3));
                valoresArticulosVentas.put(contrato_mas_hogar.tabla_articulos_venta.columnaPrecio, ja.getString(i + 5));
                valoresArticulosVentas.put(contrato_mas_hogar.tabla_articulos_venta.columnaCosto, ja.getString(i + 7));
                valoresArticulosVentas.put(contrato_mas_hogar.tabla_articulos_venta.columnaSerie, ja.getString(i + 6));


                Long idGuardado = bd.insert(contrato_mas_hogar.tabla_articulos_venta.TablaArticuosVenta, contrato_mas_hogar.tabla_articulos_venta._ID, valoresArticulosVentas);

            } catch (JSONException e) {
                e.printStackTrace();

            }

        }
      //  Toast.makeText(getApplicationContext(), "YA TERMINE articulossss  ", Toast.LENGTH_SHORT).show();
    }


    public void EnviarDatosPagos(String URL){
     //   Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();

        RequestQueue queue= Volley.newRequestQueue(this);

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override


            public void onResponse(String response) {
                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        llena_base_Pagos(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener(){
            @Override

            public void onErrorResponse(VolleyError error) {
                if (error.networkResponse == null) {
                    if (error.getClass().equals(TimeoutError.class)) {
                        // Show timeout error message
                        Toast.makeText(getApplicationContext(),"Oops. Timeout error!",
                                Toast.LENGTH_LONG).show();
                    }
                }
                Toast.makeText(getApplicationContext(), "ERROR pagos"+error, Toast.LENGTH_LONG).show();
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                100000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(stringRequest);
    }

    public void llena_base_Pagos(JSONArray ja) {
        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd = ayudaBD.getWritableDatabase();
        Toast.makeText(getApplicationContext(), "VOY A EMPEZAR pgos", Toast.LENGTH_LONG).show();
        for (int i = 0; i < ja.length(); i += 5) {

            try {

                ContentValues valoresPagos = new ContentValues();
                valoresPagos.put(contrato_mas_hogar.tabla_pagos_echos.columnaRecibo, ja.getString(i));
                valoresPagos.put(contrato_mas_hogar.tabla_pagos_echos.columnaVenta, ja.getString(i + 1));
                //valoresPagos.put(contrato_mas_hogar.tabla_pagos_echos.columnaRuta, ja.getString(i + 2));
                valoresPagos.put(contrato_mas_hogar.tabla_pagos_echos.columnaCantidad, ja.getString(i + 3));
                valoresPagos.put(contrato_mas_hogar.tabla_pagos_echos.columnaFecha, ja.getString(i + 4));

                Long idGuardado = bd.insert(contrato_mas_hogar.tabla_pagos_echos.TablaPagosEchos, contrato_mas_hogar.tabla_pagos_echos._ID, valoresPagos);

            } catch (JSONException e) {
                e.printStackTrace();

            }

        }
        Toast.makeText(getApplicationContext(), "YA TERMINE pagos ", Toast.LENGTH_LONG).show();
    }




    public void EnviarDatosArticulos(String URL){
        Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();

        RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        llena_base_articulos(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener(){
            @Override

            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR VOLLEY", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }


    public void llena_base_articulos(JSONArray ja) {
        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd = ayudaBD.getWritableDatabase();
        Toast.makeText(getApplicationContext(), "VOY A EMPEZAR ", Toast.LENGTH_LONG).show();
        for (int i = 0; i < ja.length(); i += 5) {

            try {

                ContentValues valoresArticulo = new ContentValues();
                valoresArticulo.put(contrato_mas_hogar.tabla_articulos_catalogo.columnaClave, ja.getString(i));
                valoresArticulo.put(contrato_mas_hogar.tabla_articulos_catalogo.columnaArticulo, ja.getString(i + 1));
                valoresArticulo.put(contrato_mas_hogar.tabla_articulos_catalogo.columnaFormula, ja.getString(i + 2));
                valoresArticulo.put(contrato_mas_hogar.tabla_articulos_catalogo.columnaPrecio, ja.getString(i + 3));
                valoresArticulo.put(contrato_mas_hogar.tabla_articulos_catalogo.columnaDescripcion, ja.getString(i + 4));

                Long idGuardado = bd.insert(contrato_mas_hogar.tabla_articulos_catalogo.TablaArticulosCatalogo, contrato_mas_hogar.tabla_articulos_catalogo._ID, valoresArticulo);
/*
                if (idGuardado > 0) {
                    Toast.makeText(getApplicationContext(), "SE GUARDO EL DATO " + idGuardado.toString(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No se que demonios a pasao ", Toast.LENGTH_LONG).show();
                }
*/

            } catch (JSONException e) {
                e.printStackTrace();

            }

        }
        Toast.makeText(getApplicationContext(), "YA TERMINE  ", Toast.LENGTH_LONG).show();
    }




    public void EnviarDatosPreciosArticulos(String URL){
        Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();

        RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        llena_base_precios_articulos(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener(){
            @Override

            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR VOLLEY", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }


    public void llena_base_precios_articulos(JSONArray ja) {
        ayudaBD ayudaBD = new ayudaBD(getApplicationContext());
        SQLiteDatabase bd = ayudaBD.getWritableDatabase();
        Toast.makeText(getApplicationContext(), "VOY A EMPEZAR ", Toast.LENGTH_LONG).show();
        int i=0;
        // for (int i = 0; i < ja.length(); i += 5) {

            try {

                ContentValues valoresArticulo = new ContentValues();
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_c, ja.getString(i+1));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_1, ja.getString(i+2));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_2, ja.getString(i+3));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_3, ja.getString(i+4));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_4, ja.getString(i+5));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_5, ja.getString(i+6));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_6, ja.getString(i+7));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_7, ja.getString(i+8));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_8, ja.getString(i+9));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_9, ja.getString(i+10));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_10, ja.getString(i+11));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_11, ja.getString(i+12));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_12, ja.getString(i+13));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_com, ja.getString(i+14));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_may, ja.getString(i+15));

i=15;
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_c, ja.getString(i+1));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_1, ja.getString(i+2));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_2, ja.getString(i+3));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_3, ja.getString(i+4));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_4, ja.getString(i+5));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_5, ja.getString(i+6));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_6, ja.getString(i+7));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_7, ja.getString(i+8));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_8, ja.getString(i+9));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_9, ja.getString(i+10));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_10, ja.getString(i+11));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_11, ja.getString(i+12));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_12, ja.getString(i+13));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_com, ja.getString(i+14));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_may, ja.getString(i+15));
                i=30;
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_c, ja.getString(i+1));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_1, ja.getString(i+2));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_2, ja.getString(i+3));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_3, ja.getString(i+4));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_4, ja.getString(i+5));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_5, ja.getString(i+6));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_6, ja.getString(i+7));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_7, ja.getString(i+8));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_8, ja.getString(i+9));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_9, ja.getString(i+10));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_10, ja.getString(i+11));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_11, ja.getString(i+12));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_12, ja.getString(i+13));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_com, ja.getString(i+14));
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_may, ja.getString(i+15));
                i=45;
                valoresArticulo.put(contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaFecha, ja.getString(i+14));


                Long idGuardado = bd.insert(contrato_mas_hogar.tabla_precios_articulos_catalogo.TablaPreciosArticulosCatalogo, contrato_mas_hogar.tabla_precios_articulos_catalogo._ID, valoresArticulo);
/*
                if (idGuardado > 0) {
                    Toast.makeText(getApplicationContext(), "SE GUARDO EL DATO " + idGuardado.toString(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No se que demonios a pasao ", Toast.LENGTH_LONG).show();
                }
*/

            } catch (JSONException e) {
                e.printStackTrace();

            }

        //}
        Toast.makeText(getApplicationContext(), "YA TERMINE  ", Toast.LENGTH_LONG).show();
    }
}
