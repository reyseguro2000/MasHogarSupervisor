package com.example.iguano_s.mashogarsupervisor.estructura_datos;

/**
 * Created by IGUANO-S on 22/09/2017.
 */

public class DatosClientes {
    String Cliente, ife, nombre, calle, colonia, ciudad, telefono, casa, documento, casaDatos, calificacion;

    public DatosClientes(String cliente, String ife, String nombre, String calle, String colonia, String ciudad, String telefono, String casa, String documento, String casaDatos, String calificacion) {
        Cliente = cliente;
        this.ife = ife;
        this.nombre = nombre;
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.casa = casa;
        this.documento = documento;
        this.casaDatos = casaDatos;
        this.calificacion = calificacion;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getIfe() {
        return ife;
    }

    public void setIfe(String ife) {
        this.ife = ife;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCasaDatos() {
        return casaDatos;
    }

    public void setCasaDatos(String casaDatos) {
        this.casaDatos = casaDatos;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
}
