package com.example.iguano_s.mashogarsupervisor.estructura_datos;

/**
 * Created by IGUANO-S on 08/09/2017.
 */

public class DatosRutas {
    String ruta, atrazadas, actualizada;

    public DatosRutas(String ruta, String atrazadas, String actualizada) {
        this.ruta = ruta;
        this.atrazadas = atrazadas;
        this.actualizada = actualizada;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getAtrazadas() {
        return atrazadas;
    }

    public void setAtrazadas(String atrazadas) {
        this.atrazadas = atrazadas;
    }

    public String getActualizada() {
        return actualizada;
    }

    public void setActualizada(String actualizada) {
        this.actualizada = actualizada;
    }
}
