/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vdetalle_venta;
import Datos.vventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOSE AYALA
 */
public class fventa {

    public static String SQL = "";
    public static String SsQL = "";
    public static Conexion mysql = new Conexion();
    DecimalFormat formatear = new DecimalFormat();

    public boolean insertarVentas(vventas dts) {
        SQL = "INSERT INTO venta (idusuarios, idpaciente, total, fecha, nro_factura, tipo, estado,idmovimiento,descuento,saldo)"
                + " values (?,?,?,?,?,?,?,?,?,?)";

        try {

            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setInt(1, dts.getIdusuarios());
            pst.setInt(2, dts.getIdpaciente());
            pst.setLong(3, dts.getTotal());
            pst.setDate(4, dts.getFecha());
            pst.setString(5, dts.getNro_factura());
            pst.setString(6, dts.getTipo());
            pst.setString(7, dts.getEstado());
            pst.setInt(8, dts.getIdmovimiento());
            pst.setLong(9, dts.getDescuento());
            pst.setLong(10, dts.getSaldo());

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
    public boolean anularVenta(vventas dts) {
//        INSERT INTO productos (nombre_producto, descripcion, precio_unitario, precio_mayor, precio_costo, stock, pulgadas, estado, idcategorias,idproveedor)"
//                + " values (upper(?),upper(?),?,?,?,?,?,?,?,?)";
        SQL = " update venta set  estado='ANULADO', tipo='ANULADO'"
                + "where idventa=?";

        try {
//            abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setInt(1, dts.getIdventa());
           

         
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

    public boolean insertarDetalle(vdetalle_venta dts) {
        SQL = "INSERT INTO detalle_venta (idventa, idservicios, cantidad, precio, sub_total,pulgadas)"
                + "values ((select idventa from venta order by idventa desc limit 1 ),?,?,?,?,?)";

        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setInt(1, dts.getIdservicios());
            pst.setInt(2, dts.getCantidad());
            pst.setLong(3, dts.getPrecio());
            pst.setLong(4, dts.getSub_total());
            pst.setInt(5, dts.getPulgadas());

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

    public int NroFactura() {

        int NroFactura = 0;
        SQL = "SELECT (count(*) + 1) contador FROM venta where (estado='FINALIZADO' OR estado='PENDIENTE' OR estado='PRESUPUESTO' OR estado='ANULADO') AND (tipo='CONTADO' OR tipo='CREDITO' OR tipo='PRESUPUESTO' OR tipo='ANULADO')";

        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                NroFactura = rs.getInt("contador");

            }
            return NroFactura;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }

    }

    public int NroPago() {

        int NroPago = 0;
        SQL = "SELECT (count(*) + 1) CONT FROM venta where estado='PAGADO' AND tipo='DEUDA'";

        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                NroPago = rs.getInt("CONT");

            }
            return NroPago;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }

    }

    public boolean editar(vventas dts) {
        SQL = " update venta set total=?, estado=?, saldo=? where idventa=?";
        try {
            
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setLong(1, dts.getTotal());
            pst.setString(2, dts.getEstado());
            pst.setLong(3, dts.getSaldo());
            pst.setInt(4, dts.getIdventa());

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

    public boolean editar_deudas(vventas dts) {
        SQL = " update venta set total=?, estado=?, saldo=?,idmovimiento=?,ultimo_pago=? where idventa=?";
        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setLong(1, dts.getTotal());
            pst.setString(2, dts.getEstado());
            pst.setLong(3, dts.getSaldo());
            pst.setInt(4, dts.getIdmovimiento());
            pst.setDate(5, dts.getUltimo_pago());
            pst.setInt(6, dts.getIdventa());

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
     public  DefaultTableModel mostrarcancelacion(String id) {
        DefaultTableModel modelo;

        String[] titulos = {"IDVENTA", "ID PRO.", "ID MOV", "FECHA","NUM. FACTURA", "TIPO", "TOTAL","ID CLIENTE", "CLIENTE", "USUARIO"};
        String[] registro = new String[10];

        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT v.idventa,d.idservicios,v.idmovimiento,v.fecha,v.nro_factura,v.tipo,v.total,v.idpaciente, CONCAT(p.nombre, ' ', p.apellido)as cliente,concat(u.nombre, ' ', u.apellido)as usuario\n" +
"               FROM detalle_venta d INNER JOIN venta v ON d.idventa = v.idventa\n" +
"               inner join persona p on p.idpersona=v.idpaciente\n" +
"               inner join persona u on u.idpersona=v.idusuarios"
                + " WHERE  v.idmovimiento='" + id + "' AND (v.estado='FINALIZADO' OR v.estado='PENDIENTE') group by v.idventa desc";
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
                registro[4] = rs.getString("nro_factura");
                registro[5] = rs.getString("tipo");
                registro[6] = formatear.format(rs.getDouble("total"));
                registro[7] = rs.getString("idpaciente");
                registro[8] = rs.getString("cliente");
                registro[9] = rs.getString("usuario");
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }
    }
      public  DefaultTableModel mostrarcancelacionProductos(String idpro) {
        DefaultTableModel modelo;

        String[] titulos = {"ID PRODUCTO","NOMBRE PRODUCTO"};
        String[] registro = new String[2];

        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT d.idservicios,p.nombre_producto\n" +
" FROM detalle_venta d INNER JOIN productos p ON d.idservicios = p.idservicios\n" +
"where d.idventa='" + idpro + "' order by d.idservicios desc";
        try {
             //abrimos la conexion
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
//                idm = rs.getInt("idmovimiento");
//                idm = rs.getInt("idmovimiento");
                registro[0] = rs.getString("idservicios");
                registro[1] = rs.getString("nombre_producto");
             
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }
    }

    public DefaultTableModel mostrarventa(String buscar,String inicio,String fin) {
        DefaultTableModel modelo;

        String[] titulos = {"IDVENTA", "ID PRO.", "ID MOV", "FECHA", "PRODUCTO", "NUM. FACTURA", "TOTAL", "CLIENTE", "USUARIO"};
        String[] registro = new String[9];

        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT v.idventa,d.idservicios,v.idmovimiento,v.fecha, (SELECT nombre_producto FROM productos s WHERE s.idservicios = d.idservicios)as producto,\n"
                + "                v.nro_factura, v.total, CONCAT(p.nombre, ' ', p.apellido)as cliente,concat(u.nombre, ' ', u.apellido)as usuario\n"
                + "                FROM detalle_venta d INNER JOIN venta v ON d.idventa = v.idventa\n"
                + "                 inner join persona p on p.idpersona=v.idpaciente\n"
                + "                inner join persona u on u.idpersona=v.idusuarios\n"
                + "              WHERE (v.fecha BETWEEN '" + inicio + "' AND '" + fin + "') AND (v.estado='FINALIZADO' OR v.estado='PENDIENTE') group by v.nro_factura desc";
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
            
                registro[5] = rs.getString("nro_factura");
                registro[6] = formatear.format(rs.getDouble("total"));
                registro[7] = rs.getString("cliente");
                registro[8] = rs.getString("usuario");
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }
    }
//funcion para mostrar ventas al contado y credito con los nombres frmventa_General

    public DefaultTableModel mostrarcontnombre(String inicio, String fin, String estado, String id) {
        DefaultTableModel modelo;

        String[] titulos = {"IDVENTA", "ID PRO.", "ID MOV", "CLIENTE", "FECHA", "PRODUCTO", "PRECIO.", "CANTIDAD", "SUB-TOTAL", "NUM. FACTURA", "TIPO", "TOTAL",};
        String[] registro = new String[12];

        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT v.idventa,d.idservicios,v.fecha,v.idmovimiento,(SELECT concat(nombre,' ',apellido) FROM persona p WHERE p.idpersona = v.idpaciente)as cliente,\n"
                + "(SELECT nombre_producto FROM productos s WHERE s.idservicios = d.idservicios)as producto,\n"
                + "                 d.precio,d.cantidad,v.nro_factura,v.tipo,d.sub_total,v.total\n"
                + "                 FROM detalle_venta d INNER JOIN venta v ON d.idventa = v.idventa\n"
                + "                 inner join persona p on p.idpersona=v.idpaciente\n"
                + "                 inner join persona u on u.idpersona=v.idusuarios\n"
                + " WHERE v.fecha BETWEEN '" + inicio + "' AND '" + fin + "' AND v.estado like '%" + estado + "%' AND v.idpaciente like '%" + id + "%' order by v.tipo desc";
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
                registro[3] = rs.getString("cliente");
                registro[4] = rs.getString("fecha");
                registro[5] = rs.getString("producto");

                registro[6] = formatear.format(rs.getDouble("precio"));
                registro[7] = rs.getString("cantidad");
                registro[8] = formatear.format(rs.getDouble("sub_total"));
                registro[9] = rs.getString("nro_factura");
                registro[10] = rs.getString("tipo");
                registro[11] = formatear.format(rs.getDouble("total"));

                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }
    }

//metodo para mostrar ventas al contado y credito en frmhistorialventas diarias
//    public DefaultTableModel mostrarhventacont(String inicio, String fin, String estado) {
//        DefaultTableModel modelo;
//
//        String[] titulos = {"IDVENTA", "ID PRO.", "ID MOV", "FECHA", "PRODUCTO", "PRECIO.", "CANTIDAD", "SUB-TOTAL", "NUM. FACTURA", "TOTAL", "CLIENTE", "USUARIO"};
//        String[] registro = new String[12];
//
//        modelo = new DefaultTableModel(null, titulos);
//        SQL = "SELECT v.idventa,d.idservicios,v.fecha,v.idmovimiento, (SELECT nombre_producto FROM productos s WHERE s.idservicios = d.idservicios)as producto,\n"
//                + "                 d.precio,d.cantidad,v.nro_factura,d.sub_total,v.total, CONCAT(p.nombre, ' ', p.apellido)as cliente,concat(u.nombre, ' ', u.apellido)as usuario\n"
//                + "                 FROM detalle_venta d INNER JOIN venta v ON d.idventa = v.idventa\n"
//                + "                 inner join persona p on p.idpersona=v.idpaciente\n"
//                + "                 inner join persona u on u.idpersona=v.idusuarios\n"
//                + "                 WHERE v.fecha BETWEEN '" + inicio + "' "
//                + "                 AND '" + fin + "' AND v.estado='" + estado + "'  order by v.idventa desc";
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(SQL);
//            while (rs.next()) {
////                idm = rs.getInt("idmovimiento");
////                idm = rs.getInt("idmovimiento");
//                registro[0] = rs.getString("idventa");
//                registro[1] = rs.getString("idservicios");
//                registro[2] = rs.getString("idmovimiento");
//                registro[3] = rs.getString("fecha");
//                registro[4] = rs.getString("producto");
//
//                registro[5] = formatear.format(rs.getDouble("precio"));
//                registro[6] = rs.getString("cantidad");
//                registro[7] = formatear.format(rs.getDouble("sub_total"));
//                registro[8] = rs.getString("nro_factura");
//                registro[9] = formatear.format(rs.getDouble("total"));
//                registro[10] = rs.getString("cliente");
//                registro[11] = rs.getString("usuario");
//                modelo.addRow(registro);
//            }
//
//            return modelo;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
//            return null;
//        }
//    }
    public DefaultTableModel mostrarhventatotal(String inicio, String fin, String estado) {
        DefaultTableModel modelo;

        String[] titulos = {"IDVENTA", "ID PRO.", "ID MOV", "FECHA", "PRODUCTO", "PRECIO.", "CANTIDAD", "SUB-TOTAL", "NUM. FACTURA", "TIPO", "TOTAL", "CLIENTE", "USUARIO"};
        String[] registro = new String[13];

        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT v.idventa,d.idservicios,v.fecha,v.idmovimiento, (SELECT nombre_producto FROM productos s WHERE s.idservicios = d.idservicios)as producto,\n"
                + " d.precio,d.cantidad,v.nro_factura,v.tipo,d.sub_total,v.total, CONCAT(p.nombre, ' ', p.apellido)as cliente,concat(u.nombre, ' ', u.apellido)as usuario\n"
                + " FROM detalle_venta d INNER JOIN venta v ON d.idventa = v.idventa\n"
                + " inner join persona p on p.idpersona=v.idpaciente\n"
                + " inner join persona u on u.idpersona=v.idusuarios\n"
                + " WHERE v.fecha BETWEEN '" + inicio + "' AND '" + fin + "' AND v.estado LIKE '%" + estado + "%'  order by v.idventa desc";
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
                registro[7] = formatear.format(rs.getDouble("sub_total"));
                registro[8] = rs.getString("nro_factura");
                registro[9] = rs.getString("tipo");
                registro[10] = formatear.format(rs.getDouble("total"));
                registro[11] = rs.getString("cliente");
                registro[12] = rs.getString("usuario");
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }
    }

    public DefaultTableModel mostrarhventacred(String inicio, String fin, String estado) {
        DefaultTableModel modelo;

        String[] titulos = {"IDVENTA", "ID PRO.", "ID MOV", "FECHA", "PRODUCTO", "PRECIO.", "CANTIDAD", "SUB-TOTAL", "NUM. FACTURA", "TOTAL", "CLIENTE", "USUARIO"};
        String[] registro = new String[12];

        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT v.idventa,d.idservicios,v.fecha,v.idmovimiento, (SELECT nombre_producto FROM productos s WHERE s.idservicios = d.idservicios)as producto,\n"
                + " d.precio,d.cantidad,v.nro_factura,d.sub_total,v.saldo, CONCAT(p.nombre, ' ', p.apellido)as cliente,concat(u.nombre, ' ', u.apellido)as usuario\n"
                + " FROM detalle_venta d INNER JOIN venta v ON d.idventa = v.idventa\n"
                + " inner join persona p on p.idpersona=v.idpaciente\n"
                + " inner join persona u on u.idpersona=v.idusuarios\n"
                + " WHERE v.fecha BETWEEN '" + inicio + "' "
                + " AND '" + fin + "' AND v.estado='" + estado + "' order by v.idventa desc";
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
                registro[7] = formatear.format(rs.getDouble("sub_total"));
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
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }
    }

    public DefaultTableModel mostrarhventacredtotal(String inicio, String fin, String estado) {
        DefaultTableModel modelo;

        String[] titulos = {"IDVENTA", "ID PRO.", "ID MOV", "FECHA", "PRODUCTO", "PRECIO.", "CANTIDAD", "SUB-TOTAL", "NUM. FACTURA", "TOTAL", "CLIENTE", "USUARIO"};
        String[] registro = new String[12];

        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT v.idventa,d.idservicios,v.fecha,v.idmovimiento, (SELECT nombre_producto FROM productos s WHERE s.idservicios = d.idservicios)as producto,\n"
                + " d.precio,d.cantidad,v.nro_factura,d.sub_total,v.saldo, CONCAT(p.nombre, ' ', p.apellido)as cliente,concat(u.nombre, ' ', u.apellido)as usuario\n"
                + " FROM detalle_venta d INNER JOIN venta v ON d.idventa = v.idventa\n"
                + " inner join persona p on p.idpersona=v.idpaciente\n"
                + " inner join persona u on u.idpersona=v.idusuarios\n"
                + " WHERE v.fecha BETWEEN '" + inicio + "' AND '" + fin + "' AND v.estado='" + estado + "' order by v.idventa desc";
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
                registro[7] = formatear.format(rs.getDouble("sub_total"));
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
        }finally{
//            cerramos la conexion
            mysql.desconectar();
        }
    }

}
