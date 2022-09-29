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
public class vpersona {

    private int idpersona;
    private String nombre;
    private String apellido;
    private String numDocumento;
    private String telefono;
    private String direccion;
    private String genero;
    private String estado;

    public vpersona() {
    }

    public vpersona(int idpersona, String nombre, String apellido, String numDocumento, String telefono, String direccion, String genero, String estado) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numDocumento = numDocumento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.genero = genero;
        this.estado = estado;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getGenero() {
        return genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   

}
