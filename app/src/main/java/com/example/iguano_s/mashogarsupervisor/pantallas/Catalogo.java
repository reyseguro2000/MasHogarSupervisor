package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.iguano_s.mashogarsupervisor.adaptadores.AdaptadorArticulo;
import com.example.iguano_s.mashogarsupervisor.estructura_datos.DatosArticulo;
import com.example.iguano_s.mashogarsupervisor.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Catalogo extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        rv=(RecyclerView)findViewById(R.id.rv_articulos);
        LinearLayoutManager llm = new LinearLayoutManager((this));
        rv.setLayoutManager(llm);
        List<DatosArticulo> listaArtticulos;


        EnviarDatos("http://radioxxxiguanoxxx.no-ip.biz:8080/mashogar/consulta_articulos.php");


    }

    public void EnviarDatos(String URL){
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
                        CargarListView(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Catalogo.this, "No se que paso", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }
    URL imageUrl = null;
    Bitmap imagen = null;

    public void CargarListView(JSONArray ja){

        //ArrayList<String> lista = new ArrayList<>();
        final ArrayList<DatosArticulo> listaarreglo = new ArrayList<DatosArticulo>();

        for(int i=0;i<ja.length();i+=5){

           try {

               File imgFile2 = new File(Environment.getExternalStorageDirectory()+ "/pictures/Catalogo/busqueda.png");
               imagen = BitmapFactory.decodeFile(imgFile2.getAbsolutePath());
               DatosArticulo listaArticulos = new DatosArticulo(imagen, ja.getString(i), ja.getString(i + 1), ja.getString(i + 2), ja.getString(i + 3),ja.getString(i + 4));
               listaarreglo.add(listaArticulos);

                // lista.add(ja.getString(i)+" "+ja.getString(i+1)+" "+ja.getString(i+2)+" "+ja.getString(i+3));
            } catch (JSONException e) {
                e.printStackTrace();

            }

        }

        AdaptadorArticulo adaptadorRV = new AdaptadorArticulo(listaarreglo);
        rv.setAdapter(adaptadorRV);






}
}
