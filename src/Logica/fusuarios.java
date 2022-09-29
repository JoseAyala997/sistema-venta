/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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
public class fusuarios {

    private Conexion mysql = new Conexion();
    private String sSQL = "";
    private String sSQL2 = "";
    public String ACCESO = "";
    public String NOMBRE = "";
    public String APELLIDO = "";
    private int cod_usuarios;
    public Integer totalregistros;
//    public Integer totalregistroslog;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Nombre", "Apellido", "Usuario", "Contraseña"};
        String[] registro = new String[5];
        totalregistros = 0;
        try {

            modelo = new DefaultTableModel(null, titulos);
            sSQL = "Select p.idpersona,p.nombre,p.apellido,u.login,u.password from persona p inner join usuarios u "
                    + "on p.idpersona=u.idusuarios where numDocumento like '%" + buscar + "%' or p.nombre like "
                    + "'%" + buscar + "%' or p.apellido like '%" + buscar + "%' and p.estado='ACTIVO'"
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

                registro[3] = rs.getString("login");
                registro[4] = rs.getString("password");

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

    public DefaultTableModel mostrarPermisos(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Nombre", "Apellido", "Usuario", "Contraseña", "Acceso", "venta", "compras", "apertura_caja", "cierre_caja", "usuarios", "pago_deudas", "ing_egre", "historial_ven", "ventas_dia", "venta_cliente", "historial_compras", "historial_ingre_egre", "resumen_ingre_egre", "respaldo", "rptusuarios"};
        String[] registro = new String[21];
        totalregistros = 0;
        try {

            modelo = new DefaultTableModel(null, titulos);
            sSQL = "Select p.idpersona,p.nombre,p.apellido,u.login,u.password,u.acceso,per.venta, per.compras, per.apertura_caja, per.cierre_caja, per.usuarios, per.pago_deudas,"
                    + " per.ing_egre, per.historial_ven, per.ventas_dia, per.venta_cliente, per.historial_compras, per.historial_ingre_egre, per.resumen_ingre_egre,per.respaldo,per.rptusuarios from persona p\n"
                    + "	inner join usuarios u on p.idpersona=u.idusuarios inner join permisos per on u.idusuarios=per.idusuarios where ( p.nombre like '%" + buscar + "%' or p.apellido"
                    + " like '%" + buscar + "%' ) AND p.estado='ACTIVO' order by idpersona desc";

            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            ResultSet rs = st.executeQuery(sSQL);
//Statement st = cn.createStatement();
            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("login");
                registro[4] = rs.getString("password");
                registro[5] = rs.getString("acceso");

                registro[6] = rs.getString("venta");
                registro[7] = rs.getString("compras");
                registro[8] = rs.getString("apertura_caja");
                registro[9] = rs.getString("cierre_caja");
                registro[10] = rs.getString("usuarios");
                registro[11] = rs.getString("pago_deudas");
                registro[12] = rs.getString("ing_egre");
                registro[13] = rs.getString("historial_ven");
                registro[14] = rs.getString("ventas_dia");
                registro[15] = rs.getString("venta_cliente");
                registro[16] = rs.getString("historial_compras");
                registro[17] = rs.getString("historial_ingre_egre");
                registro[18] = rs.getString("resumen_ingre_egre");
                registro[19] = rs.getString("respaldo");
                registro[20] = rs.getString("rptusuarios");

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

    public boolean insertar(vusuarios dts) {
        sSQL = "insert into persona ( nombre, apellido, numDocumento, telefono,direccion, genero,estado) "
                + "values(upper(?),upper(?),?,?,?,?,?)";
        sSQL2 = "insert into usuarios (idusuarios,acceso,login,password,estado)"
                + "values((select idpersona from persona order by idpersona desc limit 1),?,?,?,?)";

        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getNumDocumento());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getDireccion());
            pst.setString(6, dts.getGenero());
            pst.setString(7, "ACTIVO");

            pst2.setString(1, dts.getAcceso());
            pst2.setString(2, dts.getLogin());
            pst2.setString(3, dts.getPassword());
            pst2.setString(4, "ACTIVO");

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
            mysql.desconectar();
        }
    }

    public boolean editar(vusuarios dts) {
        sSQL = "update persona p set p.nombre=upper(?), p.apellido=upper(?)"
                + "where p.idpersona=?";
        //"update paciente set idpaciente=? where idpersona=? ";

        sSQL2 = "update usuarios u set u.acceso=?,u.login=?,u.password=? "
                + "where u.idusuarios=?";
        try {
//abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
//            pst.setString(3, dts.getNumDocumento());
//            pst.setString(4, dts.getTelefono());
//            pst.setString(5, dts.getDireccion());
//            pst.setString(6, dts.getGenero());
            //pst.setString(7, "ACTIVO");
            pst.setInt(3, dts.getIdpersona());

            pst2.setString(1, dts.getAcceso());
            pst2.setString(2, dts.getLogin());
            pst2.setString(3, dts.getPassword());
            //pst2.setString(4, "ACTIVO");
            pst2.setInt(4, dts.getIdpersona());

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
            pst.setInt(2, dts.getIdpersona());

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
        String[] titulos = {"Codigo", "Nombre", "Documento", "Usuario", "Contraseña", "Aceeso", "venta", "compras", "apertura_caja", "cierre_caja", "usuarios", "pago_deudas", "ing_egre", "historial_ven", "ventas_dia", "venta_cliente", "historial_compras", "historial_ingre_egre", "resumen_ingre_egre", "respaldo", "rptusuario"};
        String[] registro = new String[21];
        totalregistros = 0;
        try {

            modelo = new DefaultTableModel(null, titulos);
            sSQL = "Select p.idpersona,CONCAT(p.nombre,' ',p.apellido)as nombre,p.numDocumento,u.login,u.password,u.acceso,per.venta, per.compras, per.apertura_caja, per.cierre_caja, per.usuarios, per.pago_deudas,\n"
                    + "                     per.ing_egre, per.historial_ven, per.ventas_dia, per.venta_cliente, per.historial_compras, per.historial_ingre_egre, per.resumen_ingre_egre,per.respaldo,per.rptusuarios from persona p\n"
                    + "                    	inner join usuarios u on p.idpersona=u.idusuarios inner join permisos per on u.idusuarios=per.idusuarios where u.login='" + login + "' AND u.password= '" + password + "' ";

            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            ResultSet rs = st.executeQuery(sSQL);
//Statement st = cn.createStatement();
            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("numDocumento");
                registro[3] = rs.getString("login");
                registro[4] = rs.getString("password");
                registro[5] = rs.getString("acceso");

                registro[6] = rs.getString("venta");
                registro[7] = rs.getString("compras");
                registro[8] = rs.getString("apertura_caja");
                registro[9] = rs.getString("cierre_caja");
                registro[10] = rs.getString("usuarios");
                registro[11] = rs.getString("pago_deudas");
                registro[12] = rs.getString("ing_egre");
                registro[13] = rs.getString("historial_ven");
                registro[14] = rs.getString("ventas_dia");
                registro[15] = rs.getString("venta_cliente");
                registro[16] = rs.getString("historial_compras");
                registro[17] = rs.getString("historial_ingre_egre");
                registro[18] = rs.getString("resumen_ingre_egre");
                registro[19] = rs.getString("respaldo");
                registro[20] = rs.getString("rptusuarios");

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

}
