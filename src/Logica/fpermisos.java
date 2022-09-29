/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vpermisos;
import Datos.vusuarios;
import static Logica.Conexion.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
public class fpermisos {

    private Conexion mysql = new Conexion();
    private String sSQL = "";
    private String sSQL2 = "";
    public String ACCESO = "";
    public String NOMBRE = "";
    public String APELLIDO = "";
    private int cod_usuarios;
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Nombre", "Apellido", "N Documento", "Telefono", "Direccion", "Genero", "Acceso", "Login", "Contraseña"};
        String[] registro = new String[10];
        totalregistros = 0;
        try {

            modelo = new DefaultTableModel(null, titulos);
            sSQL = "Select p.idpersona,p.nombre,p.apellido,p.numDocumento,p.telefono,p.direccion,p.genero,u.acceso,u.login,u.password "
                    + "from persona p inner join usuarios u on p.idpersona=u.idusuarios where numDocumento like '%" + buscar + "%' or p.nombre like '%" + buscar + "%' or p.apellido like '%" + buscar + "%' and p.estado='ACTIVO'"
                    + "order by idpersona desc";

            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            ResultSet rs = st.executeQuery(sSQL);
//Statement st = cn.createStatement();
            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("numDocumento");
                registro[4] = rs.getString("telefono");
                registro[5] = rs.getString("direccion");
                registro[6] = rs.getString("genero");
                //registro[7] = rs.getString("estado");
                registro[7] = rs.getString("acceso");
                registro[8] = rs.getString("login");
                registro[9] = rs.getString("password");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        } finally {
            mysql.desconectar();
        }

    }

    public boolean insertarPermisos(vpermisos dts) {

        sSQL = "INSERT INTO `permisos` (`idusuarios`, `venta`, `compras`, `apertura_caja`, `cierre_caja`, `usuarios`, `pago_deudas`, `ing_egre`, `historial_ven`, `ventas_dia`, `venta_cliente`, `historial_compras`,"
                + " `historial_ingre_egre`, `resumen_ingre_egre`, `respaldo`, `rptusuarios`)VALUES ((select idpersona from persona order by idpersona desc limit 1),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sSQL);

//            pst.setInt(1, dts.getIdusuarios());
            pst.setInt(1, dts.getVenta());
            pst.setInt(2, dts.getCompras());
            pst.setInt(3, dts.getApertura_caja());
            pst.setInt(4, dts.getCierre_caja());
            pst.setInt(5, dts.getUsuarios());
            pst.setInt(6, dts.getPago_deudas());
            pst.setInt(7, dts.getIng_egre());
            pst.setInt(8, dts.getHistorial_ven());
            pst.setInt(9, dts.getVentas_dia());
            pst.setInt(10, dts.getVenta_cliente());
            pst.setInt(11, dts.getHistorial_compras());
            pst.setInt(12, dts.getHistorial_ingre_egre());
            pst.setInt(13, dts.getResumen_ingre_egre());
            pst.setInt(14, dts.getRespaldo());
            pst.setInt(15, dts.getRptusuario());

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

    public boolean editar(vpermisos dts) {

        sSQL = " update permisos pr set pr.venta=?, pr.compras=?, pr.apertura_caja=?, pr.cierre_caja=?, pr.usuarios=?, pr.pago_deudas=?, pr.ing_egre=?, pr.historial_ven=?,\n"
                + "              pr.ventas_dia=?, pr.venta_cliente=?, pr.historial_compras=?, pr.historial_ingre_egre=?, pr.resumen_ingre_egre=?, pr.respaldo=?, pr.rptusuarios=? where pr.idusuarios=?";

        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getVenta());
            pst.setInt(2, dts.getCompras());
            pst.setInt(3, dts.getApertura_caja());
            pst.setInt(4, dts.getCierre_caja());
            pst.setInt(5, dts.getUsuarios());
            pst.setInt(6, dts.getPago_deudas());

            pst.setInt(7, dts.getIng_egre());
            pst.setInt(8, dts.getHistorial_ven());
            pst.setInt(9, dts.getVentas_dia());
            pst.setInt(10, dts.getVenta_cliente());
            pst.setInt(11, dts.getHistorial_compras());
            pst.setInt(12, dts.getHistorial_ingre_egre());
            pst.setInt(13, dts.getResumen_ingre_egre());
            pst.setInt(14, dts.getRespaldo());
            pst.setInt(15, dts.getRptusuario());

            pst.setInt(16, dts.getIdusuarios());
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

    public boolean eliminar(vusuarios dts) {
        sSQL = "update persona set estado=?"
                + "where idpersona=? ";
        // "delete from usuarios where idusuarios=?";
        sSQL2 = "update usuarios set estado=? "
                + "where idusuarios=?";

        try {
//abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, "INACTIVO");
            pst.setInt(2, dts.getIdusuarios());

            pst2.setString(1, "INACTIVO");
            pst2.setInt(2, dts.getIdpersona());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } finally {
//            cerramos la conexion
            mysql.desconectar();
        }
    }

    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apellido", "Documento", "Acceso", "Login", "Clave", "Estado"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select u.idusuarios,p.nombre,p.apellido,p.numDocumento, u.acceso,u.login,u.password,u.estado from usuarios u \n"
                + "inner join persona p on u.idusuarios = p.idpersona  where login = '" + login + "' and password = '" + password + "' \n"
                + "and u.estado = 'ACTIVO' AND p.estado='ACTIVO'";

        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idusuarios");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("numDocumento");
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }

//            JOptionPane.showMessageDialog(null, "desconectado");
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        } finally {
            mysql.desconectar();
        }
    }
}
