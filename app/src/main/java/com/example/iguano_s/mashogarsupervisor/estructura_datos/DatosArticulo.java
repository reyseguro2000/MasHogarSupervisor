package com.example.iguano_s.mashogarsupervisor.estructura_datos;

import android.graphics.Bitmap;

/**
 * Created by IGUANO-S on 24/06/2017.
 */

public class DatosArticulo {
    String clave_articulo,articulo,formula,precio, descripcion;
    Bitmap imagen_articulo;

    public DatosArticulo(Bitmap imagen_articulo, String clave_articulo, String articulo, String formula, String precio, String descripcion) {
        this.imagen_articulo = imagen_articulo;
        this.clave_articulo = clave_articulo;
        this.articulo = articulo;
        this.formula = formula;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Bitmap getImagen_articulo() {
        return imagen_articulo;
    }

    public void setImagen_articulo(Bitmap imagen_articulo) {
        this.imagen_articulo = imagen_articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getClave_articulo() {
        return clave_articulo;
    }

    public void setClave_articulo(String clave_articulo) {
        this.clave_articulo = clave_articulo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
