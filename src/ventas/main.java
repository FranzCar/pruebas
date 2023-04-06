/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

import Modelo.ConectarBD;
import Vista.InterfazAdministrarUsuario;


/**
 *
 * @author HP
 */
public class main {
    public static void main (String[] args){
        InterfazAdministrarUsuario ventana=new InterfazAdministrarUsuario();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
}
}