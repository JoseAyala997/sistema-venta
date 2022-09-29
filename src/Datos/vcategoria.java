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
public class vcategoria {
    private int idcategorias;
    private String categoria;
 

    public vcategoria() {
    }

    public vcategoria(int idcategorias, String categoria) {
        this.idcategorias = idcategorias;
        this.categoria = categoria;
    }

    public int getIdcategorias() {
        return idcategorias;
    }

    public void setIdcategorias(int idcategorias) {
        this.idcategorias = idcategorias;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

   
            
    
}
