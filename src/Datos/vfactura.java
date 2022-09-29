/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Jose Ayala
 */
public class vfactura {
     private int nrofactura;
    private Long monto;
    private Long efectivo;
    private Long vuelto;
    private int idventa;

    public vfactura() {
    }

    public vfactura(int nrofactura, Long monto, Long efectivo, Long vuelto, int idventa) {
        this.nrofactura = nrofactura;
        this.monto = monto;
        this.efectivo = efectivo;
        this.vuelto = vuelto;
        this.idventa = idventa;
    }

    public int getNrofactura() {
        return nrofactura;
    }

    public void setNrofactura(int nrofactura) {
        this.nrofactura = nrofactura;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Long getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(Long efectivo) {
        this.efectivo = efectivo;
    }

    public Long getVuelto() {
        return vuelto;
    }

    public void setVuelto(Long vuelto) {
        this.vuelto = vuelto;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

   
}
