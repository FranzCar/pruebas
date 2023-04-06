/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.ConectarBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class ListarUsuarios {
    static Connection conexion=null;
    static Statement sentencia=null;
    ConectarBD con = new ConectarBD();    
    
    public void MostrarTabla(JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cod Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ci");
        modelo.addColumn("Telefono");
        modelo.addColumn("Usuario");
        modelo.addColumn("Direccion");
        String consultasql = new String();
        consultasql = "SELECT codUsuario, nombreUsuario, ciUsuario, telefonoUsuario, idUsuario, direccionUsuario From Usuario";
        Statement st;
        try{
            conexion=con.establecerConexion(); 
            sentencia=conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(consultasql);
            while(rs.next()){
                Object [] lista = {rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
        }catch(Exception e){
            System.out.println("ERROR AL LISTAR LOS DATOS" + e);
        }

    }
    public void MostrarTablaBuscar(JTable tabla,String palabra){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cod Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ci");
        modelo.addColumn("Telefono");
        modelo.addColumn("Usuario");
        modelo.addColumn("Direccion");
        String consultasql = new String();
        consultasql = "SELECT codUsuario, nombreUsuario, ciUsuario, telefonoUsuario, idUsuario, direccionUsuario From Usuario where nombreUsuario like \"%"+palabra+"%\"";
        Statement st;
        try{
            conexion=con.establecerConexion(); 
            sentencia=conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(consultasql);
            while(rs.next()){
                Object [] lista = {rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
        }catch(Exception e){
            System.out.println("ERROR AL LISTAR LOS DATOS" + e);
        }
    }   
}
