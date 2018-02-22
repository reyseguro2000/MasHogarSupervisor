package com.example.iguano_s.mashogarsupervisor.estructura_datos;

/**
 * Created by IGUANO-S on 08/09/2017.
 */

public class DatosUsuario {String ClavePersonal, Puesto, Nombre, Pass, Consecutivo;

    public DatosUsuario(String clavePersonal, String puesto, String nombre, String pass, String consecutivo) {
        ClavePersonal = clavePersonal;
        Puesto = puesto;
        Nombre = nombre;
        Pass = pass;
        Consecutivo = consecutivo;
    }

    public String getClavePersonal() {
        return ClavePersonal;
    }

    public void setClavePersonal(String clavePersonal) {
        ClavePersonal = clavePersonal;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String puesto) {
        Puesto = puesto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getConsecutivo() {
        return Consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        Consecutivo = consecutivo;
    }
}
