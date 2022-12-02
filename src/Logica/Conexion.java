/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    Connection conexion;
    public static Statement sentencia;
    public static ResultSet rs;
    Connection conn;
    
//    public String usuario = "un9hbfyw34nnsbji",// "db_ventas_user",
//            contraseña = "VmgbdUgWwnJSn5Y4PTIl",
//            nombreBD = "bdcfyhe2zt1t9bmnxyd3",//ventas",
//            ip = "bdcfyhe2zt1t9bmnxyd3-mysql.services.clever-cloud.com",//192.168.100.8",
////            servidor = "jdbc:mysql://"+ip+"/"+nombreBD+"",
//             servidor = "jdbc:mysql://bdcfyhe2zt1t9bmnxyd3-mysql.services.clever-cloud.com/",
//            puerto = "3306";
//    
//    public Conexion(){
//        this.conn=null;
//        this.usuario=usuario;
//        this.contraseña=contraseña;
//        this.ip=ip;
//        this.puerto=puerto;
//        
//    }
//    
//    public Connection conectar(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(servidor,usuario,contraseña);
//            if (conn!=null) {
////                System.out.println("conectado");
//            }
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage()+"no");
//            
//        }
//        return conn;
//    }
//    
//    public void desconectar(){
//        try {
//            conn.close();
////             System.out.println("desconectado");
//        } catch (Exception e) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,e);
//        }
//    } 

}
