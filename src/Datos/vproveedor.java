/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author ayala-PC
 */
public class vproveedor {
//    idproveedor, nombre, telefono, direccion, ruc, razon
            private int idproveedor;
            private String nombre;
            private String telefono;
            private String direccion;
            private String ruc;
            private String razon;
            private String estado;

    public vproveedor() {
    }

    public vproveedor(int idproveedor, String nombre, String telefono, String direccion, String ruc, String razon, String estado) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ruc = ruc;
        this.razon = razon;
        this.estado = estado;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

            
    
            
}
