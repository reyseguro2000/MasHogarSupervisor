package com.example.iguano_s.mashogarsupervisor.BaseDatos;

import android.provider.BaseColumns;

/**
 * Created by IGUANO-S on 27/08/2017.
 */

public class contrato_mas_hogar {
    public contrato_mas_hogar() {
    }

    public static class tabla_configuracion implements BaseColumns{

        public static final String TablaConfiguracion= "cofiguracion";
        public static final String columnaClavePersonal = "clave_persona";
        public static final String columnaPuesto = "puesto";
        public static final String columnanombre = "nombre";
        public static final String columnabodega = "bodega";
        public static final String columnaPass = "pass";
        public static final String columnaConsecutivo = "consecutivo";

    }

    public static class tabla_rutas implements BaseColumns{

        public static final String TablaRutas= "rutas";
        public static final String columnaRuta = "ruta";
        public static final String columnaatrazadas = "atrazadas";
        public static final String columnaActualizada = "actualizada";
    }



    public static class tabla_articulos_catalogo implements BaseColumns {

        public static final String TablaArticulosCatalogo= "articulos_catalogo";
        public static final String columnaClave = "clave";
        public static final String columnaArticulo = "articulo";
        public static final String columnaFormula = "formula";
        public static final String columnaPrecio = "precio";
        public static final String columnaDescripcion = "descripcion";
        public static final String columnaPreLista = "p_lista";
        public static final String columnaActivo = "activo";

    }

    public static class tabla_precios_articulos_catalogo implements BaseColumns {

        public static final String TablaPreciosArticulosCatalogo= "precios_articulos_catalogo";
        public static final String columnaL1_c = "l1_c";
        public static final String columnaL1_1 = "l1_1";
        public static final String columnaL1_2 = "l1_2";
        public static final String columnaL1_3 = "l1_3";
        public static final String columnaL1_4 = "l1_4";
        public static final String columnaL1_5 = "l1_5";
        public static final String columnaL1_6 = "l1_6";
        public static final String columnaL1_7 = "l1_7";
        public static final String columnaL1_8 = "l1_8";
        public static final String columnaL1_9 = "l1_9";
        public static final String columnaL1_10 = "l1_10";
        public static final String columnaL1_11 = "l1_11";
        public static final String columnaL1_12 = "l1_12";
        public static final String columnaL1_com = "l1_com";
        public static final String columnaL1_may = "l1_may";

        public static final String columnaL2_c = "l2_c";
        public static final String columnaL2_1 = "l2_1";
        public static final String columnaL2_2 = "l2_2";
        public static final String columnaL2_3 = "l2_3";
        public static final String columnaL2_4 = "l2_4";
        public static final String columnaL2_5 = "l2_5";
        public static final String columnaL2_6 = "l2_6";
        public static final String columnaL2_7 = "l2_7";
        public static final String columnaL2_8 = "l2_8";
        public static final String columnaL2_9 = "l2_9";
        public static final String columnaL2_10 = "l2_10";
        public static final String columnaL2_11 = "l2_11";
        public static final String columnaL2_12 = "l2_12";
        public static final String columnaL2_com = "l2_com";
        public static final String columnaL2_may = "l2_may";

        public static final String columnaL3_c = "l3_c";
        public static final String columnaL3_1 = "l3_1";
        public static final String columnaL3_2 = "l3_2";
        public static final String columnaL3_3 = "l3_3";
        public static final String columnaL3_4 = "l3_4";
        public static final String columnaL3_5 = "l3_5";
        public static final String columnaL3_6 = "l3_6";
        public static final String columnaL3_7 = "l3_7";
        public static final String columnaL3_8 = "l3_8";
        public static final String columnaL3_9 = "l3_9";
        public static final String columnaL3_10 = "l3_10";
        public static final String columnaL3_11 = "l3_11";
        public static final String columnaL3_12 = "l3_12";
        public static final String columnaL3_com = "l3_com";
        public static final String columnaL3_may = "l3_may";

        public static final String columnaFecha = "fecha";
    }


    public static class tabla_clietnes implements BaseColumns{

        public static final String TablaClientes= "clientes";
        public static final String columnaClientes = "clave_cliente";
        public static final String columnaIfe= "ife";
        public static final String columnaNombre = "nombre";
        public static final String columnaCalle = "calle";
        public static final String columnaColonia = "colonia";
        public static final String columnaCiudad= "ciudad";
        public static final String columnaTelefono = "telefono";
        public static final String columnaCasa = "casa";
        public static final String columnaDocumento = "documento";
        public static final String columnaCasaDatos = "casa_datos";
        public static final String columnaCalificacion = "calificacion";
    }

    public static class tabla_referencia1 implements BaseColumns{

        public static final String TablaReferencia1= "referencia1";
        public static final String columnaCliente = "clave_cliente";
        public static final String columnaNombre = "nombre";
        public static final String columnaCalle = "calle";
        public static final String columnaColonia = "colonia";
        public static final String columnaCiudad= "ciudad";
        public static final String columnaTelefono = "telefono";
        public static final String columnaParentesco = "parentesco";
    }
    public static class tabla_referencia2 implements BaseColumns{

        public static final String TablaReferencia2= "referencia2";
        public static final String columnaCliente = "clave_cliente";
        public static final String columnaNombre = "nombre";
        public static final String columnaCalle = "calle";
        public static final String columnaColonia = "colonia";
        public static final String columnaCiudad= "ciudad";
        public static final String columnaTelefono = "telefono";
        public static final String columnaParentesco = "parentesco";
    }

    public static class tabla_ventas implements BaseColumns{

        public static final String TablaRuta= "ventas";
        public static final String columnaVenta = "clave_venta";
        public static final String columnaCliente = "cliente";
        public static final String columnaRuta = "ruta";
        public static final String columnaFecha = "fecha";
        public static final String columnaPlazo = "plazo";
        public static final String columnaForma = "forma";
        public static final String columnaTotal = "total";
        public static final String columnaEnganche = "enganche";

        public static final String columnaDescuento = "descuento";
        public static final String columnaSaldo = "saldo";
        public static final String columnaVendedor = "vendedor";
        public static final String columnaFolio = "folio";
        public static final String columnaTipoDesc = "tipo_desc";
        public static final String columnaUltimoPago = "ultimo_pago";
        //public static final String columnaFechaU = "fecha_u";
        //public static final String columnaLista = "lista";


    }


    public static class tabla_aval implements BaseColumns{

        public static final String TablaAval= "aval";
        public static final String columnaVenta = "venta";
        public static final String columnaNombre = "nombre";
        public static final String columnaCalle = "calle";
        public static final String columnaColonia = "colonia";
        public static final String columnaCiudad= "ciudad";
        public static final String columnaTelefono = "telefono";
        public static final String columnaParentesco = "parentesco";
    }

    public static class tabla_articulos_venta implements BaseColumns{

        public static final String TablaArticuosVenta= "articulos_venta";
        public static final String columnaVenta = "venta";
        public static final String columnaCantidad = "cantidad";
        public static final String columnaArticulo = "articulo";
        public static final String columnaClave_articulo = "clave_articulo";
        public static final String columnaPrecio= "precio";
        public static final String columnaCosto = "costo";
        public static final String columnaSerie = "serie";
    }


    public static class tabla_pagos_nuevos implements BaseColumns{

        public static final String TablaPagosNuevos= "pagos_nuevos";
        public static final String columnaVenta = "venta";
        public static final String columnaRecibo = "recibo";
        public static final String columnaCantidad = "cantidad";
        public static final String columnaFecha = "fecha";
        public static final String columnaRuta = "ruta";


    }

    public static class tabla_pagos_cancelados implements BaseColumns{

        public static final String TablaPagosCancelados= "pagos_cancelados";
        public static final String columnaVenta = "venta";
        public static final String columnaRecibo = "recibo";
        public static final String columnaCantidad = "cantidad";
        public static final String columnaFecha = "fecha";
        public static final String columnaFechaCancelado = "fecha_cancelado";
        public static final String columnaRuta = "ruta";


    }

    public static class tabla_pagos_echos implements BaseColumns{

        public static final String TablaPagosEchos= "pagos_echos";
        public static final String columnaVenta = "venta";
        public static final String columnaRecibo = "recibo";
        public static final String columnaCantidad = "cantidad";
        public static final String columnaFecha = "fecha";


    }

    public static class tabla_supervisor_pendintes implements BaseColumns{

        public static final String TablaSupervisorPendiente= "supervisor_pendiente";
        public static final String columnaVenta = "venta";
        public static final String columnaFecha = "fecha";
        public static final String columnaPVG = "pvg";
        public static final String columnaEstado = "estado";
        public static final String columnaVisto = "visto";
    }

    public static class tabla_indicaciones implements BaseColumns{

        public static final String TablaIndicaciones= "supervisor_indicaciones";
        public static final String columnaVenta = "venta";
        public static final String columnaUsuario = "usuario";
        public static final String columnaVisita = "visita";
        public static final String columnaPerona = "persona";
        public static final String columnaIndicacion = "indicacion";
        public static final String columnaComentario = "comentario";
        public static final String columnaCumple = "cumple";
    }

}
