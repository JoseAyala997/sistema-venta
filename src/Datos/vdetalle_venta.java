/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Jose Ayala
// */             
public class vdetalle_venta {
    private int iddetalle;
    private int idventa;
    private int idservicios;
    private int cantidad;
    private Long precio;
    private Long sub_total;
     private int pulgadas;

    public vdetalle_venta() {
    }

    public vdetalle_venta(int iddetalle, int idventa, int idservicios, int cantidad, int pulgadas, Long precio, Long sub_total) {
        this.iddetalle = iddetalle;
        this.idventa = idventa;
        this.idservicios = idservicios;
        this.cantidad = cantidad;
        this.pulgadas = pulgadas;
        this.precio = precio;
        this.sub_total = sub_total;
    }

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(int idservicios) {
        this.idservicios = idservicios;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getSub_total() {
        return sub_total;
    }

    public void setSub_total(Long sub_total) {
        this.sub_total = sub_total;
    }

    
    
}
