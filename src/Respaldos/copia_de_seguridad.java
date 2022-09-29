/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Respaldos;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Ayala
 */
public class copia_de_seguridad {
    public static void main(String[] args){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaback =dtf.format(LocalDateTime.now());
         try {
            Process p = Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysqldump -udb_ventas_user -p12345 ventas");

            new HiloLector(p.getErrorStream()).start();

            InputStream is = p.getInputStream();//Pedimos la entrada

            FileOutputStream fos = new FileOutputStream("backup_ventas--"+fechaback+"--.sql"); //creamos el archivo para le respaldo

            byte[] buffer = new byte[1000]; //Creamos una variable de tipo byte para el buffer

            int leido = is.read(buffer); //Devuelve el número de bytes leídos o -1 si se alcanzó el final del stream.

            while (leido > 0) {
                fos.write(buffer, 0, leido);//Buffer de caracteres, Desplazamiento de partida para empezar a escribir caracteres, Número de caracteres para escribir
                leido = is.read(buffer);
            }

            fos.close();//Cierra respaldo

        } catch (IOException ex) {
            Logger.getLogger(copia_de_seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
            
}
