/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Datos.vproveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Torres
 */
public class fproveedor {

    public static String SQL = "";
    public static Conexion mysql = new Conexion();

    public int TotalRegistros;


    public static Statement st;
    public static ResultSet rs;

     public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "NOMBRE", "TELEFONO", "DIRECCION", "RUC", "RAZON SOCIAL","ESTADO"};
        String[] registro = new String[8];
        modelo = new DefaultTableModel(null, titulos);
       SQL = "SELECT idproveedor, nombre, telefono, direccion, ruc, razon, estado from proveedor \n"
                + "where nombre like '%" + buscar + "%'AND estado='ACTIVO'";
       
        TotalRegistros = 0;

        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                registro[0] = rs.getString("idproveedor");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("telefono");
                registro[3] = rs.getString("direccion");
                registro[4] = rs.getString("ruc");
                registro[5] = rs.getString("razon");
                registro[6] = rs.getString("estado");

                TotalRegistros = TotalRegistros + 1;


                modelo.addRow(registro);

            }

            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }

    }
     

    public boolean insertar(vproveedor dts) {
        SQL = "INSERT INTO proveedor (nombre, telefono, direccion,ruc,razon,estado)"
                + " values (upper(?),?,upper(?),?,upper(?),?)";

        try {
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getTelefono());
            pst.setString(3, dts.getDireccion());
            pst.setString(4, dts.getRuc());
            pst.setString(5, dts.getRazon());
            pst.setString(6, "ACTIVO");

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

    public boolean eliminar(vproveedor dts) {
        SQL = "UPDATE proveedor set estado=? \n"
                + "where idproveedor=? ";
        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, "INACTIVO");
            pst.setInt(2, dts.getIdproveedor());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;
            }

            return false;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }
    }

    public boolean editar(vproveedor dts) {
        SQL = " update proveedor set  nombre=upper(?), telefono=?, direccion=upper(?),ruc=?,razon=upper(?),estado=? "
                + "where idproveedor=?";

        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getTelefono());
            pst.setString(3, dts.getDireccion());
            pst.setString(4, dts.getRuc());
            pst.setString(5, dts.getRazon());
            pst.setString(6, "ACTIVO");
            pst.setInt(7, dts.getIdproveedor());

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
