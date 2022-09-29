/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author Jose Ayala
 */

public class vmovimiento_caja {
    private int idmovimiento;
    private String num_Caja;
   private int idusuarios;
   private Date fecha_apertura;
   private Date fecha_cierre;
   private long monto_apertura;
   private long monto_cierre;
   private long credito;
   private long ingresos;
   private long gastos;
   private long cobrado;
   private long contado;
   private long compras;
   private String estado;
;

    public vmovimiento_caja() {
    }

    public int getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(int idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public String getNum_Caja() {
        return num_Caja;
    }

    public void setNum_Caja(String num_Caja) {
        this.num_Caja = num_Caja;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public Date getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Date fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public Date getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(Date fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public long getMonto_apertura() {
        return monto_apertura;
    }

    public void setMonto_apertura(long monto_apertura) {
        this.monto_apertura = monto_apertura;
    }

    public long getMonto_cierre() {
        return monto_cierre;
    }

    public void setMonto_cierre(long monto_cierre) {
        this.monto_cierre = monto_cierre;
    }

    public long getCredito() {
        return credito;
    }

    public void setCredito(long credito) {
        this.credito = credito;
    }

    public long getIngresos() {
        return ingresos;
    }

    public void setIngresos(long ingresos) {
        this.ingresos = ingresos;
    }

    public long getGastos() {
        return gastos;
    }

    public void setGastos(long gastos) {
        this.gastos = gastos;
    }

    public long getCobrado() {
        return cobrado;
    }

    public void setCobrado(long cobrado) {
        this.cobrado = cobrado;
    }

    public long getContado() {
        return contado;
    }

    public void setContado(long contado) {
        this.contado = contado;
    }

    public long getCompras() {
        return compras;
    }

    public void setCompras(long compras) {
        this.compras = compras;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
   
   

}