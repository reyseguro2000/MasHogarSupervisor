package com.example.iguano_s.mashogarsupervisor.estructura_datos;

/**
 * Created by IGUANO-S on 30/09/2017.
 */

public class DatosRecibos {
    String Recibo, cantidad, fecha, venta;

    public DatosRecibos(String recibo, String cantidad, String fecha, String venta) {
        Recibo = recibo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.venta = venta;
    }

    public String getRecibo() {
        return Recibo;
    }

    public void setRecibo(String recibo) {
        Recibo = recibo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }
}
