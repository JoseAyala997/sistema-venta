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
public class vpacientes extends vpersona{
    private int idpersona;
    private int idpaciente;
    private String estado;

    public vpacientes() {
    }

    public vpacientes(int idpersona, int idpaciente, String estado) {
        this.idpersona = idpersona;
        this.idpaciente = idpaciente;
        this.estado = estado;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  

    

    

   
    
}
