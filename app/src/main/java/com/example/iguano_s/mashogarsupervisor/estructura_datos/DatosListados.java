package com.example.iguano_s.mashogarsupervisor.estructura_datos;

import java.util.Date;

/**
 * Created by IGUANO-S on 29/06/2017.
 */

public class DatosListados {
    String total, enganche, descuento, saldo, plazo, pvg, pva, atrazo;
    String fecha_venta, fecha_vence;
    String nombre, cliente, venta, forma, calle, colonia, ciudad;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getEnganche() {
        return enganche;
    }

    public void setEnganche(String enganche) {
        this.enganche = enganche;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getPvg() {
        return pvg;
    }

    public void setPvg(String pvg) {
        this.pvg = pvg;
    }

    public String getPva() {
        return pva;
    }

    public void setPva(String pva) {
        this.pva = pva;
    }

    public String getAtrazo() {
        return atrazo;
    }

    public void setAtrazo(String atrazo) {
        this.atrazo = atrazo;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getFecha_vence() {
        return fecha_vence;
    }

    public void setFecha_vence(String fecha_vence) {
        this.fecha_vence = fecha_vence;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
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

    public DatosListados(String total, String enganche, String descuento, String saldo, String plazo, String pvg, String pva, String atrazo, String fecha_venta, String fecha_vence, String nombre, String cliente, String venta, String forma, String calle, String colonia, String ciudad) {
        this.total = total;
        this.enganche = enganche;
        this.descuento = descuento;
        this.saldo = saldo;
        this.plazo = plazo;
        this.pvg = pvg;
        this.pva = pva;
        this.atrazo = atrazo;
        this.fecha_venta = fecha_venta;
        this.fecha_vence = fecha_vence;
        this.nombre = nombre;
        this.cliente = cliente;
        this.venta = venta;
        this.forma = forma;
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;


    }
}
