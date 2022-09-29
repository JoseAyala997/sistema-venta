/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author joseluis
 */
//iddeuda, total_deuda,total_pagado, saldo, estado, fecha_deuda, fecha_pago, idcliente
public class vdeudas {
  private int iddeuda;
  private Long total_deuda;
  private Long total_pagado;
  private Long saldo;
  private String estado;
  private Date fecha_deuda;
  private Date fecha_pago;
  private int idcliente;
  
 
    public vdeudas() {
    }

    
    public int getIddeuda() {
        return iddeuda;
    }

    public void setIddeuda(int iddeuda) {
        this.iddeuda = iddeuda;
    }

    public Long getTotal_deuda() {
        return total_deuda;
    }

    public void setTotal_deuda(Long total_deuda) {
        this.total_deuda = total_deuda;
    }

    public Long getTotal_pagado() {
        return total_pagado;
    }

    public void setTotal_pagado(Long total_pagado) {
        this.total_pagado = total_pagado;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_deuda() {
        return fecha_deuda;
    }

    public void setFecha_deuda(Date fecha_deuda) {
        this.fecha_deuda = fecha_deuda;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }


    
  
}
