/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vcompras;
import Datos.vdetalle_compra;
import static Logica.Conexion.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALUMNO
 */
public class fcompra {

    public static String SQL = "";
    public static Conexion mysql = new Conexion();
//    public static Connection cn = mysql.conectar();
    DecimalFormat formatear = new DecimalFormat();

    public DefaultTableModel mostrarcompras(String inicio, String fin, String buscar,String estado) {
        DefaultTableModel modelo;

        String[] titulos = {"PRODUCTO", "FECHA", "PRECIO.", "CANTIDAD", "NUM. FACTURA", "SUB-TOTAL", "TOTAL", "PROVEEDOR","TIPO", "USUARIO"};
        String[] registro = new String[10];

        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT (SELECT nombre_producto FROM productos s WHERE s.idservicios = d.idservicios)as producto, c.fecha,(SELECT nombre FROM proveedor pro WHERE pro.idproveedor = d.idproveedor)as proveedor,\n"
                + "               d.precio,d.cantidad,c.nro_factura,d.sub_total,c.total,c.tipo,concat(u.nombre, ' ', u.apellido)as usuario\n"
                + "            FROM detalle_compra d INNER JOIN compras c  ON d.idcompra = c.idcompra\n"
                + "                inner join persona u on u.idpersona=c.idusuarios\n"
                + "                 WHERE c.fecha BETWEEN '" + inicio + "' AND '" + fin + "' AND c.estado LIKE '%" + estado + "%' AND d.idproveedor like '%" + buscar + "%' AND (tipo='CONTADO' OR tipo='CREDITO') order by c.idcompra desc";
        try {
//            abrimos la conexion 
            Connection cn = mysql.conectar();
             Statement st = cn.createStatement(); 
             ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
//                idm = rs.getInt("idmovimiento");
//                idm = rs.getInt("idmovimiento");
                registro[0] = rs.getString("producto");
                registro[1] = rs.getString("fecha");
                registro[2] = formatear.format(rs.getDouble("precio"));
                registro[3] = rs.getString("cantidad");
                registro[4] = rs.getString("nro_factura");

                registro[5] = formatear.format(rs.getDouble("sub_total"));
                registro[6] = formatear.format(rs.getDouble("total"));
                registro[7] = rs.getString("proveedor");
                registro[8] = rs.getString("tipo");
                registro[9] = rs.getString("usuario");
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        } finally {
//            cerramos la conexion
            mysql.desconectar();
        }

    }

    public DefaultTableModel mostrarhventacred(String inicio, String fin, String estado, String id) {
        DefaultTableModel modelo;

        String[] titulos = {"IDVENTA", "ID PRO.", "ID MOV", "FECHA", "PRODUCTO", "PRECIO.", "CANTIDAD", "SUB-TOTAL", "NUM. FACTURA", "TOTAL", "CLIENTE", "USUARIO"};
        String[] registro = new String[12];

        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT v.idventa,d.idservicios,v.fecha,v.idmovimiento, (SELECT nombre_producto FROM productos s WHERE s.idservicios = d.idservicios)as producto,\n"
                + " d.precio,d.cantidad,v.nro_factura,d.sub_total,v.saldo, CONCAT(p.nombre, ' ', p.apellido)as cliente,concat(u.nombre, ' ', u.apellido)as usuario\n"
                + " FROM detalle_venta d INNER JOIN venta v ON d.idventa = v.idventa\n"
                + " inner join persona p on p.idpersona=v.idpaciente\n"
                + " inner join persona u on u.idpersona=v.idusuarios\n"
                + " WHERE v.fecha BETWEEN '" + inicio + "' AND '" + fin + "' AND v.estado='" + estado + "' AND v.idpaciente='" + id + "' order by v.idventa desc";
        try {

            //abrimos la conexion 
            Connection cn = mysql.conectar();
             Statement st = cn.createStatement(); 
             ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
//                idm = rs.getInt("idmovimiento");
//                idm = rs.getInt("idmovimiento");
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("idservicios");
                registro[2] = rs.getString("idmovimiento");
                registro[3] = rs.getString("fecha");
                registro[4] = rs.getString("producto");

                registro[5] = formatear.format(rs.getDouble("precio"));
                registro[6] = rs.getString("cantidad");
                registro[7] = rs.getString("sub_total");
                registro[8] = rs.getString("nro_factura");
                registro[9] = formatear.format(rs.getDouble("saldo"));
                registro[10] = rs.getString("cliente");
                registro[11] = rs.getString("usuario");
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        } finally {
//            cerramos la conexion
            mysql.desconectar();
        }
    }

    public boolean insertarVentas(vcompras dts) {
        SQL = "INSERT INTO compras (idusuarios,idcliente, total, fecha, nro_factura, tipo, estado,descuento, idmovimiento)"
                + " values (?,?,?,?,?,?,?,?,?)";

        try {

            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setInt(1, dts.getIdusuarios());
            pst.setInt(2, dts.getIdcliente());
            pst.setLong(3, dts.getTotal());
            pst.setDate(4, dts.getFecha());
            pst.setString(5, dts.getNro_factura());
            pst.setString(6, dts.getTipo());
            pst.setString(7, dts.getEstado());
            pst.setLong(8, dts.getDescuento());
            pst.setInt(9, dts.getIdmovimiento());

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
            //cerramos la conexion
            mysql.desconectar();
        }
    }

    public boolean insertarDetalle(vdetalle_compra dts) {
        SQL = "INSERT INTO detalle_compra (idcompra, idservicios, cantidad, precio, sub_total, pulgadas,idproveedor)"
                + "values ((select idcompra from compras order by idcompra desc limit 1 ),?,?,?,?,?,?)";

        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setInt(1, dts.getIdservicios());
            pst.setInt(2, dts.getCantidad());
            pst.setLong(3, dts.getPrecio());
            pst.setLong(4, dts.getSub_total());
            pst.setInt(5, dts.getPulgadas());
            pst.setInt(6, dts.getIdproveedor());

            int              n = pst.executeUpdate();
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

    public int NroFactura() {

        int NroFactura = 0;
        SQL = "SELECT (count(*) + 1) contador FROM compras ";

        try {
            Connection cn = mysql.conectar();
             Statement st = cn.createStatement(); 
             ResultSet rs = st.executeQuery(SQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                NroFactura = rs.getInt("contador");

            }
            return NroFactura;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        } finally {
//            cerramos la conexion
            mysql.desconectar();
        }

    }
}
