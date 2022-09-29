/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vfactura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author José Ayala
 */
public class ffactura {

    private String SQL = "";


    private Conexion mysql = new Conexion();
//    private Connection cn = mysql.conectar();

    public int TotalRegistros;



    public boolean insertarF(vfactura dts) {
        SQL = "INSERT INTO factura (nrofactura, monto, efectivo, vuelto,idventa)"
                  + " values (?,?,?,?,(select idventa from venta order by idventa desc limit 1 ))";
//        (select max (idventa) from venta where limit 1)

        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);
//            PreparedStatement pst = cn.prepareStatement(SQL);
       

            pst.setInt(1, dts.getNrofactura());
            pst.setLong(2, dts.getMonto());
            pst.setLong(3, dts.getEfectivo());
            pst.setLong(4, dts.getVuelto());
           
         

            int n = pst.executeUpdate();
   
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }
    }

}
