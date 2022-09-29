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
public class vusuarios extends vpersona{

    public int idusuarios;
    public String acceso;
    public String login;
    public String password;
    public String estado;

    public vusuarios() {
    }

//    public vusuarios(int idusuarios, String acceso, String login, String password, String estado) {
//        this.idusuarios = idusuarios;
//        this.acceso = acceso;
//        this.login = login;
//        this.password = password;
//        this.estado = estado;
//    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
   
}