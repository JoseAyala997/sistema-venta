/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vdeudas;
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
public class fdeudas {

    public static String SQL = "";
    public Conexion mysql = new Conexion();
//    public static Connection cn = mysql.conectar();
    DecimalFormat formatear = new DecimalFormat();
//    public static int id_deuda;
    public static String saldo;

    public int TotalRegistros;
    public int ValorTotal;

//    public static Statement st;
//    public static ResultSet rs;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "CLIENTE","NUM. DOCUMENTO", "TOTAL DEUDA", "FECHA ULTIMO PAGO", "ESTADO","ID PACIENTE"};
        String[] registro = new String[7];
        modelo = new DefaultTableModel(null, titulos);
        SQL = "select d.iddeuda, concat(p.nombre,' ',p.apellido)as cliente, p.numDocumento,d.total_deuda,d.fecha_deuda,d.estado,d.idcliente from deudas d\n"
                + " inner join persona p on p.idpersona=d.idcliente where (p.numDocumento like '%" +buscar + "%' OR concat(p.nombre,' ',p.apellido) "
                + "like '%" +buscar + "%') AND d.estado='PENDIENTE' order by d.iddeuda desc";

        TotalRegistros = 0;

        try {
//              abrimos la conexion
            Connection cn = mysql.conectar();
             Statement st = cn.createStatement(); 
             ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                registro[0] = rs.getString("iddeuda");
                registro[1] = rs.getString("cliente");
                registro[2] = rs.getString("numDocumento");
//                 registro[5] = formatear.format(rs.getDouble("precio"));
                registro[3] = formatear.format(rs.getDouble("total_deuda"));
                registro[4] = rs.getString("fecha_deuda");
                registro[5] = rs.getString("estado");
                registro[6] = rs.getString("idcliente");

                TotalRegistros = TotalRegistros + 1;

                modelo.addRow(registro);

            }

            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        finally{
            mysql.desconectar();
        }

    }
   

    public boolean insertar(vegresos dts) {
        SQL = "INSERT INTO egresos (descripcion, monto, fecha, hora, estado, idusuarios,idmovimiento)"
                + " values (upper(?),?,?,?,?,?,?)";

        try {
             //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);
//            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getDescripcion());
            pst.setLong(2, dts.getMonto());
            pst.setDate(3, dts.getFecha());
            pst.setString(4, dts.getHora());
            pst.setString(5, "ACTIVO");
            pst.setInt(6, dts.getIdusuarios());
            pst.setInt(7, dts.getIdmovimiento());
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

    public boolean eliminar(vegresos dts) {
        SQL = "UPDATE egresos set estado=? \n"
                + "where idegresos=? ";
        try {
             //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);
//            PreparedStatement pst = cn.prepareStatement(SQL);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, "INACTIVO");
            pst.setInt(2, dts.getIdegresos());

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

    public boolean editar(vdeudas dts) {
        SQL = " update deudas set total_deuda=?,fecha_pago=?,estado=? where iddeuda=?";
        try {
             //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);
//            PreparedStatement pst = cn.prepareStatement(SQL);
            
            pst.setLong(1, dts.getTotal_deuda());
            pst.setDate(2, dts.getFecha_pago());
            pst.setString(3, dts.getEstado());
           
            pst.setInt(4, dts.getIddeuda());

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

    public String[] id_cliente(String buscar) {

        String[] registro = new String[4];
        registro[0] = "";
        SQL = "select iddeuda,idcliente,total_deuda from deudas where idcliente='" + buscar + "' order by iddeuda desc limit 1";

        try {
             //abrimos la conexion
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                registro[0] = rs.getString("iddeuda");
                registro[1] = rs.getString("idcliente");
                registro[2] = rs.getString("total_deuda");
            }

            return registro;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error 11111: " + e);
            return null;
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }
    }

//     public void id_cliente(String buscar) {
//
//        SQL = "select idcliente,iddeuda,saldo from deudas where idcliente='" + buscar + "' order by iddeuda desc limit 1";
//
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(SQL);
//
//            while (rs.next()) {
//                id_deuda = rs.getString("iddeuda");
//                saldo = rs.getString("saldo");
//                System.out.println("ID= " + id_deuda);
//
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e);
//
//        }
//
//    }
    public boolean insertarDeuda(vdeudas dts) {
        SQL = "INSERT INTO deudas (idcliente,total_deuda,estado,fecha_deuda,saldo)\n"
                + "               values (?,?,?,?,?)";

        try {
             //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);
//            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setInt(1, dts.getIdcliente());
            pst.setLong(2, dts.getTotal_deuda());
            pst.setString(3, dts.getEstado());
            pst.setDate(4, dts.getFecha_deuda());
            pst.setLong(5, dts.getSaldo());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean editarDeuda(vdeudas dts) {
        SQL = " update deudas set total_deuda=?, estado=?,fecha_deuda=? where iddeuda=?";
        try {
             //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);
//            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setLong(1, dts.getTotal_deuda());
            pst.setString(2, dts.getEstado());
            pst.setDate(3, dts.getFecha_deuda());
            pst.setInt(4, dts.getIddeuda());

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
