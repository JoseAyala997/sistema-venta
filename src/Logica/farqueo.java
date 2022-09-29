/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import CONSULTAS.frm_ingreso_egreso_final;
import Datos.varqueo;
import Datos.vegresos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Torres
 */
public class farqueo {

    public static String SQL = "";
    public static Conexion mysql = new Conexion();
//    public static Connection cn = mysql.conectar();
    DecimalFormat formatear = new DecimalFormat();
    DecimalFormat format = new DecimalFormat("###,###.##");

    public int TotalRegistros;
    public int totalpagado;
    public int totaldeuda;

    public static Statement st;
    public static ResultSet rs;

    public boolean insertar(varqueo dts) {
        SQL = "INSERT INTO arqueo (a50, a100, a500, a1000, a2000, a5000, a10000, a20000, a50000, a100000, total, detalle1, monto1, detalle2, monto2, detalle3, monto3, detalle4, monto4, detalle5, monto5, idmovimiento)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setInt(1, dts.getA50());
            pst.setInt(2, dts.getA100());
            pst.setInt(3, dts.getA500());
            pst.setInt(4, dts.getA1000());
            pst.setInt(5, dts.getA2000());
            pst.setInt(6, dts.getA5000());
            pst.setInt(7, dts.getA10000());
            pst.setInt(8, dts.getA20000());
            pst.setInt(9, dts.getA50000());
            pst.setInt(10, dts.getA100000());
            pst.setLong(11, dts.getTotal());
            pst.setString(12, dts.getDetalle1());
            pst.setLong(13, dts.getMonto1());
            pst.setString(14, dts.getDetalle2());
            pst.setLong(15, dts.getMonto2());
            pst.setString(16, dts.getDetalle3());
            pst.setLong(17, dts.getMonto3());
            pst.setString(18, dts.getDetalle4());
            pst.setLong(19, dts.getMonto4());
            pst.setString(20, dts.getDetalle5());
            pst.setLong(21, dts.getMonto5());
            pst.setInt(22, dts.getIdmovimiento());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        } finally {
//            cerramos la conexion
            mysql.desconectar();
        }
    }

}
