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
public class vproductos {
    private int idservicios;
    private String nombre_producto;
    private String descripcion;
    private Long precio_unitario;
    private Long precio_mayor;
    private Long precio_costo;
    private Double stock;
    private String cod_barra;
    private String estado;
    private int idcategorias;
    private Double pulgadas;
    private int idproveedor;
    

    public vproductos() {
    }

    public vproductos(int idservicios, String nombre_producto, String descripcion, Long precio_unitario, Long precio_mayor, Long precio_costo, Double stock, String cod_barra, String estado, int idcategorias, Double pulgadas, int idproveedor) {
        this.idservicios = idservicios;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
        this.precio_mayor = precio_mayor;
        this.precio_costo = precio_costo;
        this.stock = stock;
        this.cod_barra = cod_barra;
        this.estado = estado;
        this.idcategorias = idcategorias;
        this.pulgadas = pulgadas;
        this.idproveedor = idproveedor;
    }

    public int getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(int idservicios) {
        this.idservicios = idservicios;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Long precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Long getPrecio_mayor() {
        return precio_mayor;
    }

    public void setPrecio_mayor(Long precio_mayor) {
        this.precio_mayor = precio_mayor;
    }

    public Long getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(Long precio_costo) {
        this.precio_costo = precio_costo;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public String getCod_barra() {
        return cod_barra;
    }

    public void setCod_barra(String cod_barra) {
        this.cod_barra = cod_barra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdcategorias() {
        return idcategorias;
    }

    public void setIdcategorias(int idcategorias) {
        this.idcategorias = idcategorias;
    }

    public Double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(Double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    
            
    
}
