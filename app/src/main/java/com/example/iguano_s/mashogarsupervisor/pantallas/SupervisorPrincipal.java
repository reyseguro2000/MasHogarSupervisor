package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.iguano_s.mashogarsupervisor.EscanerSimpleActi;
import com.example.iguano_s.mashogarsupervisor.R;

public class SupervisorPrincipal extends AppCompatActivity implements OnClickListener {

ImageButton btn_tarjeta, btn_listas, btn_busqueda, btn_reporte, btn_catalogo, btn_salir,btn_escanea_venta;
EditText txt_venta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_supervisor_principal);
        btn_escanea_venta=(ImageButton)findViewById(R.id.btn_escanea_venta);
        btn_tarjeta=(ImageButton)findViewById(R.id.btn_tarjeta);
        btn_listas=(ImageButton)findViewById(R.id.btn_listas);
        btn_busqueda=(ImageButton)findViewById(R.id.btn_busqueda);
        btn_reporte=(ImageButton)findViewById(R.id.btn_reporte);
        btn_catalogo=(ImageButton)findViewById(R.id.btn_catalogo);
        btn_salir=(ImageButton)findViewById(R.id.btn_actualizar);
        txt_venta=(EditText)findViewById(R.id.txt_venta);

        btn_tarjeta.setOnClickListener(this);
        btn_escanea_venta.setOnClickListener(this);
        btn_listas.setOnClickListener(this);

        btn_busqueda.setOnClickListener(this);
        btn_reporte.setOnClickListener(this);
        btn_catalogo.setOnClickListener(this);
        btn_salir.setOnClickListener(this);


/*
btn_escanea_venta.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SupervisorPrincipal.this, EscanerSimpleActi.class);
        startActivity(intent);
    }
});

btn_tarjeta.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(SupervisorPrincipal.this, tarjeta_virtual.class);

        String venta = txt_venta.getText().toString();

        intent.putExtra("venta",venta);
        startActivity(intent);
    }
});
*/
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tarjeta:
             Intent   intent = new Intent(SupervisorPrincipal.this, tarjeta_virtual.class);
                String venta = "MAR"+txt_venta.getText().toString();
                intent.putExtra("venta",venta);
                startActivity(intent);
            break;
            case R.id.btn_escanea_venta:
                Intent intentcod = new Intent(this, EscanerSimpleActi.class);
                startActivityForResult(intentcod,1);
                break;
            case R.id.btn_listas:
                Intent intentListas= new Intent(this,SeleccionarLista.class);
                startActivity(intentListas);
                break;


            case R.id.btn_busqueda:
                Intent intentBusqueda= new Intent(this,BuscarClientes.class);
                startActivity(intentBusqueda);
                break;

            case R.id.btn_reporte:
                Intent intentReporte= new Intent(this,Reporte.class);
                startActivity(intentReporte);
                break;

            case  R.id.btn_catalogo:
                Intent intentCatalogo= new Intent(this,CatalogoLocal.class);
                startActivity(intentCatalogo);
                break;

            case R.id.btn_actualizar:
                Intent intentActualizar= new Intent(this,actualizar.class);
                startActivity(intentActualizar);
                break;
        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                final String result =data.getStringExtra("code");
                txt_venta.setText(result);
            }
        }
    }
}
