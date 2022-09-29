/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vpacientes;
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
public class fpacientes {

    private Conexion mysql = new Conexion();
//    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apellido", "N Documento", "Telefono", "Direccion", "Genero",};
        String[] registro = new String[7];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "Select p.idpersona,p.nombre,p.apellido,p.numDocumento,p.telefono,p.direccion,p.genero "
                + "from persona p inner join paciente c on p.idpersona=c.idpaciente where (numDocumento"
                + " like '%"+ buscar +"%' or p.nombre like '%"+ buscar +"%' OR p.apellido like '%"+ buscar +"%' or p.direccion like '%"+ buscar +"%') and p.estado= 'ACTIVO' order by idpersona desc";

        try {
            Connection cn = mysql.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("numDocumento");
                registro[4] = rs.getString("telefono");
                registro[5] = rs.getString("direccion");
                registro[6] = rs.getString("genero");
                //registro[7] = rs.getString("estado");
              

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }finally{
            mysql.desconectar();
        }
       
    }
     
    public boolean insertar(vpacientes dts) {
        sSQL= "insert into persona (nombre, apellido, numDocumento, telefono,direccion, genero,estado)"
                + "values(upper(?),upper(?),?,?,?,?,?)";
        sSQL2 = "insert into paciente (idpaciente,estado)"
                + "values((select idpersona from persona order by idpersona desc limit 1),?)";
        
        try {
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
           
            
            pst2.setString(1, "ACTIVO");
            
           
          

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
        }finally{
            mysql.desconectar();
        }
        
    }
    
    public boolean  editar(vpacientes dts){
        sSQL = "update persona set nombre=upper(?), apellido=upper(?), numDocumento=?, telefono=?, direccion=?, genero=?,estado=?"
                + "where idpersona=?";
        //"update paciente set idpaciente=? where idpersona=? ";
        
        sSQL2 = "update paciente set estado=? "
                + "where idpaciente=?";
         try {
            Connection cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getNumDocumento());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getDireccion());
            pst.setString(6, dts.getGenero());
            pst.setString(7,"ACTIVO");
            pst.setInt(8, dts.getIdpersona());
           
            pst2.setString(1, "ACTIVO");
            pst2.setInt(2, dts.getIdpersona());
           // pst2.setInt(4, dts.getIdpersona());
           
           
           
          

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
        }finally{
             mysql.desconectar();
         }
        
        
        
    }
    public boolean eliminar(vpacientes dts) {
        sSQL = "update persona set estado=?"
                + "where idpersona=?";
        
                //"delete from paciente where idpaciente=?";
                
        sSQL2 = "update paciente set estado=? "
                + "where idpaciente=?";
                //"delete from persona where idpersona=?";

        try {
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
        }finally{
            mysql.desconectar();
            
        }
    }

}
