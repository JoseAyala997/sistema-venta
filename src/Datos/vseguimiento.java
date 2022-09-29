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
public class vseguimiento  {
    private int idseguimiento;
    private int idpaciente;
    private int iddieta;
    private Date fecha_inc;
    private String categoria;
    private String calorias_estimadas;
    private String estado;
    
    public vseguimiento() {
    }

    public vseguimiento(int idseguimiento, int idpaciente, int iddieta, Date fecha_inc, String categoria, String calorias_estimadas, String estado) {
        this.idseguimiento = idseguimiento;
        this.idpaciente = idpaciente;
        this.iddieta = iddieta;
        this.fecha_inc = fecha_inc;
        this.categoria = categoria;
        this.calorias_estimadas = calorias_estimadas;
        this.estado = estado;
    }

    public int getIdseguimiento() {
        return idseguimiento;
    }

    public void setIdseguimiento(int idseguimiento) {
        this.idseguimiento = idseguimiento;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public int getIddieta() {
        return iddieta;
    }

    public void setIddieta(int iddieta) {
        this.iddieta = iddieta;
    }

    public Date getFecha_inc() {
        return fecha_inc;
    }

    public void setFecha_inc(Date fecha_inc) {
        this.fecha_inc = fecha_inc;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCalorias_estimadas() {
        return calorias_estimadas;
    }

    public void setCalorias_estimadas(String calorias_estimadas) {
        this.calorias_estimadas = calorias_estimadas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    
    
    
}
