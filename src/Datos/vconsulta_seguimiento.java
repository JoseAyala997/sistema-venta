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
public class vconsulta_seguimiento {
    private int idconsulta;
    private Date fecha_consulta;
    private String observacion;
    private Date fecha_prox;
    private int idpaciente;
    private int idreserva;
    private int peso_inicial;
    private String recomendaciones;
    private String estado; 
    private int idusuarios;

    public vconsulta_seguimiento() {
    }

    public vconsulta_seguimiento(int idconsulta, Date fecha_consulta, String observacion, Date fecha_prox, int idpaciente, int idreserva, int peso_inicial, String recomendaciones, String estado, int idusuarios) {
        this.idconsulta = idconsulta;
        this.fecha_consulta = fecha_consulta;
        this.observacion = observacion;
        this.fecha_prox = fecha_prox;
        this.idpaciente = idpaciente;
        this.idreserva = idreserva;
        this.peso_inicial = peso_inicial;
        this.recomendaciones = recomendaciones;
        this.estado = estado;
        this.idusuarios = idusuarios;
    }

    public int getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(int idconsulta) {
        this.idconsulta = idconsulta;
    }

    public Date getFecha_consulta() {
        return fecha_consulta;
    }

    public void setFecha_consulta(Date fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha_prox() {
        return fecha_prox;
    }

    public void setFecha_prox(Date fecha_prox) {
        this.fecha_prox = fecha_prox;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getPeso_inicial() {
        return peso_inicial;
    }

    public void setPeso_inicial(int peso_inicial) {
        this.peso_inicial = peso_inicial;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }
    
    
    
}
