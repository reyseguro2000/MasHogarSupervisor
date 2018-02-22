package com.example.iguano_s.mashogarsupervisor.pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.iguano_s.mashogarsupervisor.R;

public class PantallaInicial extends AppCompatActivity implements View.OnClickListener {

EditText txt_inicio_sesion;
    ImageButton btn_inicio_cobrador, btn_inicio_supervisor, btn_inicio_invitado, btn_inicio_configuracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicial);

        btn_inicio_cobrador=(ImageButton)findViewById(R.id.btn_inicio_cobrador);
        btn_inicio_supervisor=(ImageButton)findViewById(R.id.btn_inicio_supervisor);
        btn_inicio_invitado=(ImageButton)findViewById(R.id.btn_inicio_invitado);
        btn_inicio_configuracion=(ImageButton)findViewById(R.id.btn_inicio_configuracion);
        txt_inicio_sesion=(EditText)findViewById(R.id.txt_inicio_sesion);

        btn_inicio_cobrador.setOnClickListener(this);
        btn_inicio_supervisor.setOnClickListener(this);
        btn_inicio_invitado.setOnClickListener(this);
        btn_inicio_configuracion.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        final String usuario_activo;
        switch (v.getId()){
            case R.id.btn_inicio_cobrador:
                usuario_activo=txt_inicio_sesion.getText().toString();
                if(usuario_activo.equals("COBRADOR")|| usuario_activo.equals(""))            {
                    Intent intentCobrador= new Intent(this,SupervisorPrincipal.class);
                    intentCobrador.putExtra("persona",R.string.lbl_persona_cobrador);
                    startActivity(intentCobrador);
                }else {
                    Toast.makeText(this, R.string.lbl_error_dato, Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btn_inicio_supervisor:
                usuario_activo=txt_inicio_sesion.getText().toString();
                if(usuario_activo.equals("SUPERVISOR") || usuario_activo.equals("xxx")){
                    Intent intentSupervisor= new Intent(this,SupervisorPrincipal.class);
                    intentSupervisor.putExtra("persona",R.string.lbl_persona_supervisor);
                    startActivity(intentSupervisor);
                }else {
                    Toast.makeText(this, R.string.lbl_error_dato, Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btn_inicio_invitado:
                Intent intentCatalogo= new Intent(this,Catalogo.class);
                startActivity(intentCatalogo);
                break;


            case R.id.btn_inicio_configuracion:

                usuario_activo=txt_inicio_sesion.getText().toString();
                if(usuario_activo.equals("IGUANO") || usuario_activo.equals("")){
                    Intent intentConfiguracion= new Intent(this,configurar.class);
                    startActivity(intentConfiguracion);
                }else {
                    Toast.makeText(this, R.string.lbl_error_dato, Toast.LENGTH_SHORT).show();
                }


                break;
        }
    }
}
