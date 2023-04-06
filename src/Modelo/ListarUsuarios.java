/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Arrays;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
/**
 *
 * @author PC
 */
public class ListarUsuarios {
    static Connection conexion=null;
    static Statement sentencia=null;
    JTable jTableUsuario = new JTable();
    ConectarBD con = new ConectarBD();    
    
    public void MostrarTabla(JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cod Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ci");
        modelo.addColumn("Telefono");
        modelo.addColumn("Usuario");
        modelo.addColumn("Direccion");
        jTableUsuario.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
        jTableUsuario.setRowSorter(sorter);
        sorter.setSortable(0, false); // deshabilitar ordenamiento en la columna del ID de usuario
        sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING))); // ordenar por nombreUsuario ascendente

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
    consultasql = "SELECT codUsuario, nombreUsuario, ciUsuario, telefonoUsuario, idUsuario, direccionUsuario FROM usuarios WHERE nombreUsuario LIKE \"%"+palabra+"%\"  ORDER BY nombreUsuario";
    
    try{
        conexion=con.establecerConexion(); 
        sentencia=conexion.createStatement();
        if (sentencia != null) {  // Agregado para validar que la sentencia no es null
            ResultSet rs = sentencia.executeQuery(consultasql);
            while(rs.next()){
                Object [] lista = {rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
        }
    }catch(Exception e){
        System.out.println("ERROR AL LISTAR LOS DATOS" + e);
    }   
    }
}
