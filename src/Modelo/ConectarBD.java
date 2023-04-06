/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ConectarBD {
    
    Connection conectar = null;
    
    String user = "root";
    String password = "root";//*********** colocar el password de su base de datos
    String dataBase = "ventasgobd";
    String server = "localhost";
    String puerto = "3308";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    String cadena = "jdbc:mysql://"+server+":"+puerto+"/"+dataBase;
    
    public Connection establecerConexion(){
        
        try{
            Class.forName(driver);
            conectar= DriverManager.getConnection(cadena,user,password);
            //JOptionPane.showMessageDialog(null, "Conexion establecida");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: Verifique su Estado de Conexion " + e.toString());
        }
        return conectar;
}
    
}
