package com.example.iguano_s.mashogarsupervisor.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by IGUANO-S on 27/08/2017.
 */

public class ayudaBD extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "catalogoMasHogar.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INT";
    private static final String COMMA_SEP = ",";

    private static final String CreaTablaArticulosCatalogo =
            "CREATE TABLE " + contrato_mas_hogar.tabla_articulos_catalogo.TablaArticulosCatalogo + " (" +
                    contrato_mas_hogar.tabla_articulos_catalogo.columnaClave + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_articulos_catalogo.columnaArticulo + TEXT_TYPE + COMMA_SEP +
                    contrato_mas_hogar.tabla_articulos_catalogo.columnaPrecio + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_articulos_catalogo.columnaDescripcion + TEXT_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_articulos_catalogo.columnaFormula + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_articulos_catalogo.columnaPreLista + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_articulos_catalogo.columnaActivo + TEXT_TYPE +
                    " )";

    private static final String CreaTablaPreciosArticulosCatalogo =
            "CREATE TABLE " + contrato_mas_hogar.tabla_precios_articulos_catalogo.TablaPreciosArticulosCatalogo + " (" +
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_c + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_1 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_2 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_3 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_4 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_5 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_6 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_7 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_8 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_9 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_10 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_11 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_12 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_com + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL1_may + INTEGER_TYPE + COMMA_SEP+

                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_c + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_1 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_2 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_3 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_4 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_5 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_6 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_7 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_8 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_9 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_10 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_11 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_12 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_com + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL2_may + INTEGER_TYPE + COMMA_SEP+

                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_c + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_1 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_2 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_3 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_4 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_5 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_6 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_7 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_8 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_9 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_10 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_11 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_12 + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_com + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaL3_may + INTEGER_TYPE + COMMA_SEP+

                    contrato_mas_hogar.tabla_precios_articulos_catalogo.columnaFecha + TEXT_TYPE +
                    " )";



    private static final String CreaTablaConfiguracion =
            "CREATE TABLE " + contrato_mas_hogar.tabla_configuracion.TablaConfiguracion + " (" +
                    contrato_mas_hogar.tabla_configuracion.columnaClavePersonal + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_configuracion.columnabodega + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_configuracion.columnanombre + TEXT_TYPE + COMMA_SEP +
                    contrato_mas_hogar.tabla_configuracion.columnaPass + TEXT_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_configuracion.columnaConsecutivo + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_configuracion.columnaPuesto + TEXT_TYPE +
                    " )";


    private static final String CreaTablaRutas =
            "CREATE TABLE " + contrato_mas_hogar.tabla_rutas.TablaRutas + " (" +
                    contrato_mas_hogar.tabla_rutas.columnaRuta + INTEGER_TYPE + " ," +
                    contrato_mas_hogar.tabla_rutas.columnaatrazadas + TEXT_TYPE + COMMA_SEP +
                    contrato_mas_hogar.tabla_rutas.columnaActualizada + TEXT_TYPE +
                    " )";


    private static final String CreaTablaClientes =
            "CREATE TABLE " + contrato_mas_hogar.tabla_clietnes.TablaClientes  + " ("+
                    contrato_mas_hogar.tabla_clietnes.columnaClientes + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_clietnes.columnaIfe + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_clietnes.columnaNombre + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_clietnes.columnaCalle + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_clietnes.columnaColonia + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_clietnes.columnaCiudad + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_clietnes.columnaTelefono + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_clietnes.columnaCasa + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_clietnes.columnaDocumento + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_clietnes.columnaCasaDatos + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_clietnes.columnaCalificacion + TEXT_TYPE  +
                    ")";


    private static final String CreaTablaReferencia1 =
            "CREATE TABLE " + contrato_mas_hogar.tabla_referencia1.TablaReferencia1 + " ("+
                    contrato_mas_hogar.tabla_referencia1.columnaCliente + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_referencia1.columnaNombre + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_referencia1.columnaCalle + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_referencia1.columnaColonia + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_referencia1.columnaCiudad + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_referencia1.columnaTelefono + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_referencia1.columnaParentesco + TEXT_TYPE +
                    ")";

    private static final String CreaTablaReferencia2 =
            "CREATE TABLE " + contrato_mas_hogar.tabla_referencia2.TablaReferencia2 + " ("+
                    contrato_mas_hogar.tabla_referencia2.columnaCliente + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_referencia2.columnaNombre + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_referencia2.columnaCalle + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_referencia2.columnaColonia + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_referencia2.columnaCiudad + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_referencia2.columnaTelefono + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_referencia2.columnaParentesco + TEXT_TYPE +
                    ")";


    private static final String CreaTablaVenta =
            "CREATE TABLE " + contrato_mas_hogar.tabla_ventas.TablaRuta + " ("+
                    contrato_mas_hogar.tabla_ventas.columnaVenta + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_ventas.columnaCliente + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_ventas.columnaRuta + INTEGER_TYPE + " ," +
                    contrato_mas_hogar.tabla_ventas.columnaFecha + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_ventas.columnaPlazo + INTEGER_TYPE + " ," +

                    contrato_mas_hogar.tabla_ventas.columnaForma + INTEGER_TYPE + " ," +
                    contrato_mas_hogar.tabla_ventas.columnaTotal + INTEGER_TYPE + " ," +
                    contrato_mas_hogar.tabla_ventas.columnaEnganche + INTEGER_TYPE + " ," +
                    contrato_mas_hogar.tabla_ventas.columnaDescuento + INTEGER_TYPE + " ," +
                    contrato_mas_hogar.tabla_ventas.columnaSaldo + INTEGER_TYPE + " ," +
                    contrato_mas_hogar.tabla_ventas.columnaVendedor + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_ventas.columnaFolio + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_ventas.columnaTipoDesc + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_ventas.columnaUltimoPago + TEXT_TYPE +
                    ")";


    private static final String CreateTablaAval =
            "CREATE TABLE " + contrato_mas_hogar.tabla_aval.TablaAval + " ("+
                    contrato_mas_hogar.tabla_aval.columnaVenta + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_aval.columnaNombre + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_aval.columnaCalle + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_aval.columnaColonia + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_aval.columnaCiudad + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_aval.columnaTelefono + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_aval.columnaParentesco + TEXT_TYPE +
                    ")";


    private static final String CreateTablaArticulosVenta =
            "CREATE TABLE " + contrato_mas_hogar.tabla_articulos_venta.TablaArticuosVenta + " ("+
                    contrato_mas_hogar.tabla_articulos_venta.columnaVenta + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_articulos_venta.columnaCantidad + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_articulos_venta.columnaArticulo + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_articulos_venta.columnaClave_articulo + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_articulos_venta.columnaPrecio + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_articulos_venta.columnaCosto + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_articulos_venta.columnaSerie + TEXT_TYPE +
                    ")";


    private static final String CreaTablaPagosEchos =
            "CREATE TABLE " + contrato_mas_hogar.tabla_pagos_echos.TablaPagosEchos + " (" +
                    contrato_mas_hogar.tabla_pagos_echos.columnaRecibo + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_pagos_echos.columnaVenta +TEXT_TYPE + COMMA_SEP +
                    contrato_mas_hogar.tabla_pagos_echos.columnaCantidad +INTEGER_TYPE+ COMMA_SEP+
                    contrato_mas_hogar.tabla_pagos_echos.columnaFecha +TEXT_TYPE+

                    " )";

    private static final String CreaTablaPagosNuevos =
            "CREATE TABLE " + contrato_mas_hogar.tabla_pagos_nuevos.TablaPagosNuevos + " (" +
                    contrato_mas_hogar.tabla_pagos_nuevos.columnaRecibo + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_pagos_nuevos.columnaVenta +TEXT_TYPE + COMMA_SEP +
                    contrato_mas_hogar.tabla_pagos_nuevos.columnaRuta +INTEGER_TYPE + COMMA_SEP +
                    contrato_mas_hogar.tabla_pagos_nuevos.columnaCantidad +INTEGER_TYPE+ COMMA_SEP+
                    contrato_mas_hogar.tabla_pagos_nuevos.columnaFecha +TEXT_TYPE+

                    " )";

    private static final String CreaTablaPagosCancelados =
            "CREATE TABLE " + contrato_mas_hogar.tabla_pagos_cancelados.TablaPagosCancelados + " (" +
                    contrato_mas_hogar.tabla_pagos_cancelados.columnaRecibo + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_pagos_cancelados.columnaVenta +TEXT_TYPE + COMMA_SEP +
                    contrato_mas_hogar.tabla_pagos_cancelados.columnaRuta +INTEGER_TYPE + COMMA_SEP +
                    contrato_mas_hogar.tabla_pagos_cancelados.columnaCantidad +INTEGER_TYPE+ COMMA_SEP+
                    contrato_mas_hogar.tabla_pagos_cancelados.columnaFecha +TEXT_TYPE+COMMA_SEP+
                    contrato_mas_hogar.tabla_pagos_cancelados.columnaFechaCancelado +TEXT_TYPE+

                    " )";

    private static final String CreaTablaSupervisorPendientes =
            "CREATE TABLE " + contrato_mas_hogar.tabla_supervisor_pendintes.TablaSupervisorPendiente + " (" +
                    contrato_mas_hogar.tabla_supervisor_pendintes.columnaVenta + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_supervisor_pendintes.columnaFecha + TEXT_TYPE + COMMA_SEP +
                    contrato_mas_hogar.tabla_supervisor_pendintes.columnaPVG + INTEGER_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_supervisor_pendintes.columnaEstado + TEXT_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_supervisor_pendintes.columnaVisto + TEXT_TYPE +
                    " )";


    private static final String CreaTablaIndicaciones =
            "CREATE TABLE " + contrato_mas_hogar.tabla_indicaciones.TablaIndicaciones + " (" +
                    contrato_mas_hogar.tabla_indicaciones.columnaVenta + TEXT_TYPE + " ," +
                    contrato_mas_hogar.tabla_indicaciones.columnaUsuario + TEXT_TYPE + COMMA_SEP +
                    contrato_mas_hogar.tabla_indicaciones.columnaVisita + TEXT_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_indicaciones.columnaPerona + TEXT_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_indicaciones.columnaIndicacion + TEXT_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_indicaciones.columnaComentario + TEXT_TYPE + COMMA_SEP+
                    contrato_mas_hogar.tabla_indicaciones.columnaCumple + TEXT_TYPE +
                    " )";



    private static final String borrarTablaConfiguracion ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_configuracion.TablaConfiguracion;
    private static final String borrarTablaRuas ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_rutas.TablaRutas;

    private static final String borrarTablaArticulos = "DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_articulos_catalogo.TablaArticulosCatalogo;
    private static final String borrarTablaPreciosArticulos = "DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_precios_articulos_catalogo.TablaPreciosArticulosCatalogo;

    private static final String borrarTablaPagosNuevos ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_pagos_nuevos.TablaPagosNuevos;
    private static final String borrarTablaPagosCancelados ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_pagos_cancelados.TablaPagosCancelados;

    private static final String borrarTablaClientes ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_clietnes.TablaClientes;
    private static final String borrarTablaReferencia1 ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_referencia1.TablaReferencia1;
    private static final String borrarTablaReferencia2 ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_referencia2.TablaReferencia2;
    private static final String borrarTablaVenta ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_ventas.TablaRuta;
    private static final String borrarTablaAval ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_aval.TablaAval;
    private static final String borrarTablaArticulosVenta ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_articulos_venta.TablaArticuosVenta;
    private static final String borrarTablaPagosEchos ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_pagos_echos.TablaPagosEchos;

    private static final String borrarSupervisorPendientes ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_supervisor_pendintes.TablaSupervisorPendiente;
    private static final String borrarIndicaciones ="DROP TABLE IF EXISTS " + contrato_mas_hogar.tabla_indicaciones.TablaIndicaciones;

    public ayudaBD(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CreaTablaConfiguracion);
        db.execSQL(CreaTablaRutas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void ActualizaDatos(SQLiteDatabase db){
        db.execSQL(borrarTablaClientes);
        db.execSQL(borrarTablaReferencia1);
        db.execSQL(borrarTablaReferencia2);
        db.execSQL(borrarTablaVenta);
        db.execSQL(borrarTablaAval);
        db.execSQL(borrarTablaArticulosVenta);
        db.execSQL(borrarTablaPagosEchos);
        db.execSQL(borrarTablaPagosNuevos);
        db.execSQL(borrarTablaPagosCancelados);
        //db.execSQL(borrarTablaArticulos);
        db.execSQL(borrarSupervisorPendientes);
        db.execSQL(borrarIndicaciones);


        db.execSQL(CreaTablaClientes);
        db.execSQL(CreaTablaReferencia1);
        db.execSQL(CreaTablaReferencia2);
        db.execSQL(CreaTablaVenta);
        db.execSQL(CreateTablaAval);
        db.execSQL(CreateTablaArticulosVenta);
        db.execSQL(CreaTablaPagosEchos);
        //db.execSQL(CreaTablaArticulosCatalogo);
        db.execSQL(CreaTablaPagosNuevos);
        db.execSQL(CreaTablaPagosCancelados);
        db.execSQL(CreaTablaSupervisorPendientes);
        db.execSQL(CreaTablaIndicaciones);
    }
    public void CreaUsuario(SQLiteDatabase db){
        db.execSQL(borrarTablaConfiguracion);
        db.execSQL(CreaTablaConfiguracion);
    }

    public void CreaRuta(SQLiteDatabase db){
        db.execSQL(borrarTablaRuas);
        db.execSQL(CreaTablaRutas);
    }
    public void CreaArticulos(SQLiteDatabase db){
        db.execSQL(borrarTablaArticulos);
        db.execSQL(CreaTablaArticulosCatalogo);
        db.execSQL(borrarTablaPreciosArticulos);
        db.execSQL(CreaTablaPreciosArticulosCatalogo);
    }
}
