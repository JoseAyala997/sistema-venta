/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import CONSULTAS.frmhistorial_ventas;
import CONSULTAS.frmventas_diarias;
import Datos.vmovimiento_caja;
import Presentacion.FrmApertura_Caja;
import Presentacion.FrmCerrarCaja;
import Presentacion.frmprincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
public class fmovimiento_caja {

    private Conexion mysql = new Conexion();
//    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public static int ultimo_id;
    public static int ultimo_id_cj;
    public static String ultimo_idm;
    public static int ultimoMonto;
    public static int idm;
//    public static Double gananciatotal;
    DecimalFormat formatear = new DecimalFormat();
    DecimalFormat format = new DecimalFormat("###,###.##");
    public Integer totalregistros;

    public DefaultTableModel mostrarcaja(String buscar, String estado, String idm) {
        DefaultTableModel modelo;

        String[] titulos = {"IDCAJA", "NRO CAJA", "MONTO APERTURA", "MONTO CIERRE", "FECHA APERT.", "FECHA CIERRE", "ESTADO", "IDPERSONA", "FUNCIONARIO", "DOC", "EGRESOS", "COMPRAS"};
        String[] registro = new String[12];

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select cj.idmovimiento,cj.num_Caja,cj.monto_apertura,cj.monto_cierre,cj.fecha_apertura, cj.fecha_cierre, cj.estado, \n"
                + "cj.idusuarios,concat(p.nombre,' ',p.apellido) as funcionario,p.numDocumento ,(SELECT sum(e.monto)as egreso from egresos e WHERE cj.idmovimiento= e.idmovimiento and e.estado='EGRESO')AS egresos,(SELECT sum(total)as compra FROM compras where estado='FINALIZADO' AND idmovimiento='" + idm + "' )as compras\n"
                + "from movimiento_caja cj \n"
                + "join usuarios em on em.idusuarios=cj.idusuarios\n"
                + "join persona p on em.idusuarios=p.idpersona\n"
                + "join egresos e on cj.idmovimiento=e.idmovimiento where cj.estado='ACTIVO' and cj.idusuarios='" + buscar + "' order by cj.idmovimiento Desc limit 1";

        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
//                idm = rs.getInt("idmovimiento");
//                idm = rs.getInt("idmovimiento");
                registro[0] = rs.getString("idmovimiento");
                registro[1] = rs.getString("num_Caja");
                registro[2] = formatear.format(rs.getDouble("monto_apertura"));
                registro[3] = formatear.format(rs.getDouble("monto_cierre"));
                registro[4] = rs.getString("fecha_apertura");
                registro[5] = rs.getString("fecha_cierre");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("idusuarios");
                registro[8] = rs.getString("funcionario");
                registro[9] = rs.getString("numDocumento");
                registro[10] = formatear.format(rs.getDouble("egresos"));
                registro[11] = formatear.format(rs.getDouble("compras"));
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        } finally {
            mysql.desconectar();
        }
    }

    public DefaultTableModel mostrarCierre(String buscar,String inicio,String fin) {
        DefaultTableModel modelo;

        String[] titulos = {"ID MOV", "NRO CAJA", "MONTO APERTURA", "MONTO CIERRE", "FECHA APERT.", "FECHA CIERRE", "CREDITO", "GASTOS", "COBRADO", "COMPRAS", "INGRESOS", "USUARIO", "ESTADO"};
        String[] registro = new String[13];

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select cj.idmovimiento,cj.num_Caja,cj.monto_apertura,cj.monto_cierre,cj.fecha_apertura, cj.fecha_cierre, cj.credito,cj.gastos,cj.cobrado,cj.compras,cj.ingresos, cj.estado,\n"
                + "concat(p.nombre,' ',p.apellido) as funcionario from movimiento_caja cj \n"
                + "join usuarios em on em.idusuarios=cj.idusuarios\n"
                + "join persona p on em.idusuarios=p.idpersona\n"
                + "where (cj.fecha_cierre BETWEEN '" + inicio + "' AND '" + fin + "') AND cj.estado='CERRADO' and cj.idusuarios='" + buscar + "' order by cj.idmovimiento Desc";

        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
//                idm = rs.getInt("idmovimiento");
//                idm = rs.getInt("idmovimiento");
                registro[0] = rs.getString("idmovimiento");
                registro[1] = rs.getString("num_Caja");
                registro[2] = formatear.format(rs.getDouble("monto_apertura"));
                registro[3] = formatear.format(rs.getDouble("monto_cierre"));
                registro[4] = rs.getString("fecha_apertura");
                registro[5] = rs.getString("fecha_cierre");
                registro[6] = formatear.format(rs.getDouble("credito"));
                registro[7] = formatear.format(rs.getDouble("gastos"));
                registro[8] = formatear.format(rs.getDouble("cobrado"));
                registro[9] = formatear.format(rs.getDouble("compras"));
                registro[10] = formatear.format(rs.getDouble("ingresos"));
                registro[11] = rs.getString("funcionario");
                registro[12] = rs.getString("estado");
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        } finally {
            mysql.desconectar();
        }
    }

    public void mostrar_ultimo_id(String buscar) {
//select max(idmovimiento)as id from movimiento_caja WHERE estado='ACTIVO' AND idusuarios='" + buscar + "'
        sSQL = "select idmovimiento as id from movimiento_caja WHERE estado='ACTIVO' AND idusuarios='" + buscar + "' order by idmovimiento desc limit 1";

        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            mysql.conectar();
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                ultimo_id_cj = rs.getInt("id");
                frmprincipal.lblidmovimiento2.setText(String.valueOf(ultimo_id_cj));

            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        } finally {
            mysql.desconectar();
        }

    }

    public DefaultTableModel mostrar(String buscar, String estado, String idm) {
        DefaultTableModel modelo;

        String[] titulos = {"IDCAJA", "NRO CAJA", "MONTO APERTURA", "MONTO CIERRE", "FECHA APERT.", "FECHA CIERRE", "ESTADO", "IDPERSONA", "FUNCIONARIO", "DOC", "COMPRAS"};
        String[] registro = new String[11];

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select cj.idmovimiento,cj.num_Caja,cj.monto_apertura,cj.monto_cierre,cj.fecha_apertura, cj.fecha_cierre, cj.estado, \n"
                + "cj.idusuarios,concat(p.nombre,' ',p.apellido) as funcionario,p.numDocumento,(SELECT sum(total)as compra FROM compras where estado='FINALIZADO' AND idmovimiento='" + idm + "' )as compras\n"
                + "from movimiento_caja cj \n"
                + "join usuarios em on em.idusuarios=cj.idusuarios \n"
                + "join persona p on em.idusuarios=p.idpersona\n"
                + "where cj.estado='" + estado + "' and cj.idusuarios='" + buscar + "' order by cj.idmovimiento Desc  limit 1";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {

                registro[0] = rs.getString("idmovimiento");
                registro[1] = rs.getString("num_Caja");
                registro[2] = formatear.format(rs.getDouble("monto_apertura"));
                registro[3] = formatear.format(rs.getDouble("monto_cierre"));
                registro[4] = rs.getString("fecha_apertura");
                registro[5] = rs.getString("fecha_cierre");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("idusuarios");
                registro[8] = rs.getString("funcionario");
                registro[9] = rs.getString("numDocumento");
                registro[10] = rs.getString("compras");
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        } finally {
            mysql.desconectar();
        }
    }

//    
//    idmovimiento`,
//    `movimiento_caja`.`idusuarios`,
//    `movimiento_caja`.`num_Caja`,
//    `movimiento_caja`.`fecha_apertura`,
//    `movimiento_caja`.`fecha_cierre`,
//    `movimiento_caja`.`monto_apertura`,
//    `movimiento_caja`.`monto_cierre`,
//    `movimiento_caja`.`credito`,
//    `movimiento_caja`.`gastos`,
//    `movimiento_caja`.`cobrado`,
//    `movimiento_caja`.`contado`,
//    `movimiento_caja`.`ingresos`,
//    `movimiento_caja`.`compras`,
//    `movimiento_caja`.`estado`
    public boolean cerraCaja(vmovimiento_caja dts) {
        sSQL = "update movimiento_caja set monto_cierre=?, fecha_cierre=?,credito=?,gastos=?,cobrado=?,contado=?,ingresos=?,compras=?, estado=? "
                + " where idmovimiento=?";
        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setLong(1, dts.getMonto_cierre());
            pst.setDate(2, dts.getFecha_cierre());
            pst.setLong(3, dts.getCredito());
            pst.setLong(4, dts.getGastos());
            pst.setLong(5, dts.getCobrado());
            pst.setLong(6, dts.getContado());
            pst.setLong(7, dts.getIngresos());
            pst.setLong(8, dts.getCompras());
            pst.setString(9, dts.getEstado());
            pst.setInt(10, dts.getIdmovimiento());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error dddd: " + e);
            return false;
        } finally {
//            cerramos la conexion
            mysql.desconectar();
        }
    }

    public void mostrar_id() {

        sSQL = "select max(idmovimiento)as id from movimiento_caja ";

        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                ultimo_id = rs.getInt("id");
//                System.out.println("hola" + jose);

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        } finally {
            mysql.desconectar();
        }

    }

    public void ultimo_cierre() {

        sSQL = "select max(idmovimiento)as id from movimiento_caja ";

        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                ultimo_id = rs.getInt("id");
//                System.out.println("hola" + jose);

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        } finally {
            mysql.desconectar();
        }

    }

    public String[] obtenerdatos(String buscar) {

        String[] registro = new String[9];
        registro[0] = "";
        sSQL = "select cj.idmovimiento,cj.monto_apertura,cj.monto_cierre,cj.fecha_apertura, cj.fecha_cierre, cj.estado,\n"
                + "cj.idusuarios, concat(p.nombre,' ',p.apellido) as funcionario,p.numDocumento \n"
                + "from movimiento_Caja cj \n"
                + "join usuarios em on em.idusuarios=cj.idusuarios\n"
                + "join persona p on em.idusuarios=p.idpersona\n"
                + "where cj.Estado='ACTIVO' and cj.idusuarios = '" + buscar + "'order by cj.idmovimiento Desc";

        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idmovimiento");
                registro[1] = formatear.format(rs.getLong("monto_apertura"));
                registro[2] = formatear.format(rs.getLong("monto_cierre"));
                registro[3] = rs.getString("fecha_apertura");
                registro[4] = rs.getString("fecha_cierre");
                registro[5] = rs.getString("idusuarios");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("funcionario");
                registro[8] = rs.getString("numDocumento");
            }

            return registro;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error 11111: " + e);
            return null;
        } finally {
            mysql.desconectar();
        }
    }

    public DefaultTableModel mostraractivos() {
        DefaultTableModel modelo;

        String[] titulos = {"IDCAJA", "NUM CAJA", "MONTO APERTURA", "MONTO CIERRE", "FECHA APERT.", "FECHA CIERRE", "ESTADO", "IDPERSONA", "FUNCIONARIO", "DOC"};
        String[] registro = new String[10];

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select cj.idmovimiento,cj.num_Caja,cj.monto_apertura,cj.monto_cierre,cj.fecha_apertura, cj.fecha_cierre, cj.estado, \n"
                + "cj.idusuarios, concat(p.nombre,' ',p.apellido) as funcionario,p.numDocumento\n"
                + "from movimiento_caja cj \n"
                + "join usuarios em on em.idusuarios = cj.idusuarios\n"
                + "join persona p on em.idusuarios=p.idpersona\n"
                + "where cj.estado='ACTIVO' order by cj.idmovimiento Desc";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idmovimiento");
                registro[1] = rs.getString("num_Caja");
                registro[2] = formatear.format(rs.getDouble("monto_apertura"));
                registro[3] = formatear.format(rs.getDouble("monto_cierre"));
                registro[4] = rs.getString("fecha_apertura");
                registro[5] = rs.getString("fecha_cierre");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("idusuarios");
                registro[8] = rs.getString("funcionario");
                registro[9] = rs.getString("numDocumento");
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        } finally {
            mysql.desconectar();
        }
    }

    public boolean insertar(vmovimiento_caja dts) {
        sSQL = "insert into movimiento_caja (idusuarios,num_caja, fecha_apertura, fecha_cierre, monto_apertura, monto_cierre, estado)"
                + "values(?,?,?,?,?,?,?)";
        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sSQL);
//            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdusuarios());
            pst.setString(2, dts.getNum_Caja());
            pst.setDate(3, dts.getFecha_apertura());
            pst.setDate(4, dts.getFecha_cierre());
            pst.setLong(5, dts.getMonto_apertura());
            pst.setLong(6, dts.getMonto_cierre());
            pst.setString(7, dts.getEstado());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error xxx: " + e);
            return false;
        } finally {
//            cerramos la conexion
            mysql.desconectar();
        }
    }

    public boolean Insertar_cierre(vmovimiento_caja dts) {
        mostrar_id();//se muestra el ultimo id registrado para actualizarlo
        sSQL = "UPDATE movimiento_caja set  fecha_cierre=?, cierre=?, estado=?\n"
                + "where idmovimiento=? ";
        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sSQL);
//            PreparedStatement pst = cn.prepareStatement(sSQL);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setDate(1, dts.getFecha_cierre());
            pst.setLong(2, dts.getMonto_cierre());
            pst.setString(3, "CERRADO");
            pst.setInt(4, ultimo_id);

            int n = pst.executeUpdate();
//              System.out.println(pst);
            if (n != 0) {

                return true;
            }

            return false;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        } finally {
//            cerramos la conexion
            mysql.desconectar();
        }
    }

    public boolean editar(vmovimiento_caja dts) {
        sSQL = "update movimiento_caja set idusuarios=?,fecha_apertura=?, fecha_cierre=?, monto_apertura=?, monto_cierre=?,  estado=?"
                + " where idmovimiento=?";
        try {
            //abrimos la conexion
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sSQL);
//            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdusuarios());
            pst.setDate(2, dts.getFecha_apertura());
            pst.setDate(3, dts.getFecha_cierre());
            pst.setLong(4, dts.getMonto_apertura());
            pst.setLong(5, dts.getMonto_cierre());
            pst.setString(6, dts.getEstado());
            pst.setInt(7, dts.getIdmovimiento());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: xxx1" + e);
            return false;
        } finally {
//            cerramos la conexion
            mysql.desconectar();
        }
    }

    public Double mostraraprturacaja(String buscar) {
        Double t = 0.0;
        sSQL = "select monto_apertura "
                + "  from movimiento_caja "
                + " where idmovimiento='" + buscar + "' ";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("monto_apertura");
            }
            return t;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return t;
        } finally {
            mysql.desconectar();
        }
    }

    public Double mostrarTotalAcumuladoPagosVentas(String buscar) {
        Double t = 0.0;
        sSQL = "select total"
                + "  from venta "
                + " where idmovimiento='" + buscar + "' AND estado='FINALIZADO' AND tipo='CONTADO' ";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("total");

            }
            return t;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return t;
        } finally {
            mysql.desconectar();

        }
    }
    //funcion para mostrar la ganancia de la venta

    public Double gananciasVenta(String fecha1, String fecha2) {
        Double totalganancia = 0.0;
        sSQL = "SELECT ((precio_unitario - p.precio_costo)*d.cantidad)as ganancia from detalle_venta d \n"
                + "inner join productos p on p.idservicios=d.idservicios\n"
                + "inner join venta v on d.idventa=v.idventa\n"
                + "where v.fecha between '" + fecha1 + "'  AND '" + fecha2 + "' and v.estado='FINALIZADO'";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                totalganancia = totalganancia + rs.getDouble("ganancia");

                frmhistorial_ventas.lblganancia.setText(format.format(totalganancia));
//                frmprincipal.txtcontado.setText(String.valueOf((format.format((int) t))));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(totalganancia));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(totalganancia));
        } finally {
            mysql.desconectar();
        }
    }
    //funcion para mostrar la ganancia de la venta del dia

    public Double gananciasVentadia(String fecha1, String fecha2) {
        Double totalganancia = 0.0;
        sSQL = "SELECT ((precio_unitario - p.precio_costo)*d.cantidad)as ganancia from detalle_venta d \n"
                + "inner join productos p on p.idservicios=d.idservicios\n"
                + "inner join venta v on d.idventa=v.idventa\n"
                + "where v.fecha between '" + fecha1 + "'  AND '" + fecha2 + "' and v.estado='FINALIZADO'";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                totalganancia = totalganancia + rs.getDouble("ganancia");

                frmventas_diarias.lblganancia.setText(format.format(totalganancia));
//                frmprincipal.txtcontado.setText(String.valueOf((format.format((int) t))));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(totalganancia));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(totalganancia));
        } finally {
            mysql.desconectar();
        }
    }

//funcion para mostrar la ganancia del dia
    public Double gananciashoy(String buscar, String fecha) {
        Double total = 0.0;
        sSQL = "SELECT ((precio_unitario - p.precio_costo)*d.cantidad)as ganancia from detalle_venta d \n"
                + "inner join productos p on p.idservicios=d.idservicios\n"
                + "inner join venta v on d.idventa=v.idventa\n"
                + "where v.fecha between '" + fecha + "'  AND '" + fecha + "' and v.idmovimiento='" + buscar + "'";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                total = total + rs.getDouble("ganancia");
                frmprincipal.txtgananciahoy.setText(format.format(total));
//                frmprincipal.txtcontado.setText(String.valueOf((format.format((int) t))));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(total));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(total));
        } finally {
            mysql.desconectar();
        }
    }

    //funcion para mostrar la ganancia del dia
    public Double gananciatotal(String buscar) {
        Double total = 0.0;
        sSQL = "SELECT ((precio_unitario - p.precio_costo)*d.cantidad)as ganancia from detalle_venta d \n"
                + "inner join productos p on p.idservicios=d.idservicios\n"
                + "inner join venta v on d.idventa=v.idventa\n"
                + "where v.idmovimiento='" + buscar + "'";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                total = total + rs.getDouble("ganancia");
                frmprincipal.txtgananciatotal.setText(format.format(total));
//                frmprincipal.txtcontado.setText(String.valueOf((format.format((int) t))));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(total));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(total));
        } finally {
            mysql.desconectar();

        }
    }

    public Double ventashoy(String buscar, String fecha) {
        Double total = 0.0;
        sSQL = "select sum(total)AS total1"
                + "  from venta "
                + " where idmovimiento='" + buscar + "' AND fecha='" + fecha + "' AND estado='FINALIZADO' AND tipo='CONTADO'";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                total = total + rs.getDouble("total1");
                frmprincipal.txtcontado.setText(format.format(total));
//                frmprincipal.txtcontado.setText(String.valueOf((format.format((int) t))));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(total));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(total));
        } finally {
            mysql.desconectar();
        }
    }

    public Double ventasmod(String buscar) {
        Double t1 = 0.0;
        sSQL = "select sum(total)AS total"
                + "  from venta "
                + " where idmovimiento='" + buscar + "' AND estado='FINALIZADO' AND tipo='CONTADO'";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t1 = t1 + rs.getDouble("total");
                frmprincipal.txtcontado1.setText(format.format(t1));
//                JOptionPane.showMessageDialog(null, t1);
//                frmprincipal.txtcontado1.setText(String.valueOf((format.format((int) t))));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t1));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t1));
        } finally {
            mysql.desconectar();
        }
    }

    public Double cobradohoy(String buscar, String fecha) {
        int t = 0;
        sSQL = "select sum(total)as cobrado from venta where idmovimiento='" + buscar + "'  AND tipo ='DEUDA' AND estado='PAGADO' AND fecha='" + fecha + "'";
//        sSQL = "select sum(v.total)as cobrado from venta v inner join movimiento_caja m where v.idmovimiento = m.idmovimiento "
//                + "and v.tipo='CREDITO' and m.idmovimiento ='" + buscar + "' order by m.idmovimiento desc limit 1";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getInt("cobrado");
                frmprincipal.txtpagado.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        } finally {
            mysql.desconectar();
        }
    }

    public Double cobradomod(String buscar) {
        int t = 0;
        sSQL = "select sum(total)as cobrado from venta where idmovimiento='" + buscar + "'  AND tipo ='DEUDA' AND estado='PAGADO'";
//        sSQL = "select sum(v.total)as cobrado from venta v inner join movimiento_caja m where v.idmovimiento = m.idmovimiento "
//                + "and v.tipo='CREDITO' and m.idmovimiento ='" + buscar + "' order by m.idmovimiento desc limit 1";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getInt("cobrado");
                frmprincipal.txtpagado1.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        } finally {
            mysql.desconectar();
        }
    }

    public Double creditohoy(String buscar, String fecha) {
        Double t = 0.0;

        sSQL = "select sum(v.saldo)as credito from venta v inner join movimiento_caja m where v.idmovimiento = m.idmovimiento "
                + "and v.tipo='CREDITO' and m.idmovimiento ='" + buscar + "' AND fecha='" + fecha + "' order by m.idmovimiento desc limit 1";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("credito");
                frmprincipal.txtcredito.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        } finally {
            mysql.desconectar();
        }
    }

    public Double creditomod(String buscar) {
        Double t = 0.0;

        sSQL = "select sum(v.saldo)as credito from venta v inner join movimiento_caja m where v.idmovimiento = m.idmovimiento "
                + "and v.tipo='CREDITO' and m.idmovimiento ='" + buscar + "'order by m.idmovimiento desc limit 1";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("credito");
                frmprincipal.txtcredito1.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        } finally {
            mysql.desconectar();
        }
    }

    public Double egresohoy(String buscar, String fecha) {
        Double eg = 0.0;

        sSQL = "SELECT sum(monto)as egreso FROM egresos where estado='EGRESO' AND idmovimiento='" + buscar + "' AND fecha='" + fecha + "'";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                eg = eg + rs.getDouble("egreso");
                frmprincipal.txtegresos.setText(format.format(eg));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(eg));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(eg));
        } finally {
            mysql.desconectar();
        }
    }

    public Double egresomov(String buscar) {
        Double t = 0.0;

        sSQL = "SELECT sum(monto)as egreso FROM egresos where estado='EGRESO' AND idmovimiento='" + buscar + "' ";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("egreso");
                frmprincipal.txtegresos1.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        } finally {
            mysql.desconectar();
        }

    }

    public Double ingresohoy(String buscar, String fecha) {
        Double t = 0.0;

        sSQL = "SELECT sum(monto)as ingreso FROM egresos where estado='INGRESO' AND idmovimiento='" + buscar + "' AND fecha='" + fecha + "' ";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("ingreso");
                frmprincipal.txtingresos.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        } finally {
            mysql.desconectar();
        }
    }

    public Double ingresomov(String buscar) {
        Double t = 0.0;

        sSQL = "SELECT sum(monto)as ingreso FROM egresos where estado='INGRESO' AND idmovimiento='" + buscar + "' ";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("ingreso");
                frmprincipal.txtingresos1.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        } finally {
            mysql.desconectar();
        }
    }

    public Double comprashoy(String buscar, String fecha) {
        Double t = 0.0;

        sSQL = "SELECT sum(total)as compra FROM compras where estado='FINALIZADO' AND idmovimiento='" + buscar + "' AND fecha='" + fecha + "' ";
        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("compra");
                frmprincipal.TXTCOMPRAS.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        } finally {
            mysql.desconectar();
        }
    }

    public Double comprasmov(String buscar) {
        Double t = 0.0;

        sSQL = "SELECT sum(total)as compra FROM compras where estado='FINALIZADO' AND idmovimiento='" + buscar + "' ";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("compra");
                frmprincipal.TXTCOMPRAS1.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        } finally {
            mysql.desconectar();

        }
    }

    public Double ingresohoycierre(String buscar) {
        Double t = 0.0;

        sSQL = "SELECT sum(monto)as ingreso FROM egresos where estado='INGRESO' AND idmovimiento='" + buscar + "' ";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("ingreso");
                FrmCerrarCaja.txtotros.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        } finally {
            mysql.desconectar();
        }
    }

    public Double aperturahoy(String buscar) {
        Double t = 0.0;

        sSQL = "SELECT monto_apertura FROM movimiento_caja where estado='ACTIVO'AND idmovimiento='" + buscar + "' ";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("monto_apertura");
                frmprincipal.txtapertura.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        } finally {
            mysql.desconectar();
        }
    }

    public Double mostrarcredito(String buscar) {
        Double t = 0.0;

        sSQL = "select sum(v.saldo)as credito from venta v inner join movimiento_caja m where v.idmovimiento = m.idmovimiento "
                + "and v.tipo='CREDITO' and m.idmovimiento ='" + buscar + "' order by m.idmovimiento desc limit 1";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("credito");

            }
            return t;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return t;
        } finally {
            mysql.desconectar();
        }
    }

    public Double mostrarcobrado(String buscar) {
        Double t = 0.0;
        sSQL = "select sum(total)as cobrado from venta where idmovimiento='" + buscar + "'  AND tipo ='DEUDA' AND estado='PAGADO'";
//                "select sum(v.total)as cobrado from venta v inner join movimiento_caja m where v.idmovimiento = m.idmovimiento "
//                + "andselect sum(v.total)as cobrado from venta v v.tipo='CREDITO' and m.idmovimiento ='" + buscar + "' order by m.idmovimiento desc limit 1";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
            //            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("cobrado");

            }
            return t;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return t;
        } finally {
            mysql.desconectar();
        }
    }

    public int mostrarmovimiento(String buscar) {
        int t = 0;
        sSQL = "select max(m.idmovimiento)AS idmov from movimiento_caja m\n"
                + "inner join usuarios u on m.idusuarios=u.idusuarios where m.estado='ACTIVO' and m.idusuarios='" + buscar + "'";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = rs.getInt("idmov");
                System.out.println(t);
            }
            return t;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return t;
        } finally {
            mysql.desconectar();
        }
    }

    public Double mostrarTotalegreso(String buscar) {
        Double t = 0.0;
        sSQL = "select sub_total "
                + "  from detalle_venta "
                + " where idventa='" + buscar + "'";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("sub_total");

            }
            return t;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return t;
        } finally {
            mysql.desconectar();
        }
    }

    public void mostrarMonto(String buscar) {

        sSQL = "SELECT (e.idmovimiento)as id, (m.idmovimiento)as idm from egresos e \n"
                + "inner join movimiento_caja m on e.idmovimiento=m.idmovimiento "
                + "where m.estado='ACTIVO' and m.idusuarios='" + buscar + "' order by m.idmovimiento Desc";

        try {
//              abrimos la conexion 
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                ultimoMonto = rs.getInt("id");
                idm = rs.getInt("idm");

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        } finally {
            mysql.desconectar();
        }

    }

    public Integer UltimoCierre(String buscar) {
        Integer total = 0;
        sSQL = "SELECT idmovimiento, monto_cierre from movimiento_caja where idusuarios='" + buscar + "' AND estado='CERRADO' order by idmovimiento desc limit 1";
        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                total = total + rs.getInt("monto_cierre");

//                System.out.println(formatear.format(total));
                FrmApertura_Caja.txtMontoApertura.setText(formatear.format(total));
            }
            return Integer.parseInt(String.valueOf(total));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Integer.parseInt(String.valueOf(total));
        } finally {
            mysql.desconectar();
        }
    }
}
