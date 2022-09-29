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
public class vegresos {
//    idegresos, descripcion, monto, fecha, hora, estado, idusuarios
    private int idegresos;
    private String descripcion;
    private Long monto; 
    private Date fecha;
    private String hora; 
    private int idusuarios; 
    private int idmovimiento;
    private String estado;

    public vegresos() {
    }

    public vegresos(int idegresos, String descripcion, Long monto, Date fecha, String hora, int idusuarios, int idmovimiento, String estado) {
        this.idegresos = idegresos;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
        this.idusuarios = idusuarios;
        this.idmovimiento = idmovimiento;
        this.estado = estado;
    }

    public int getIdegresos() {
        return idegresos;
    }

    public void setIdegresos(int idegresos) {
        this.idegresos = idegresos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public int getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(int idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
  
    
    
}
