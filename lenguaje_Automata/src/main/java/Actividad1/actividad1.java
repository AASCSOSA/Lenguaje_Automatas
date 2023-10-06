/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Actividad1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author alanh
 */
public class actividad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Nombre,edad,correo electronico
        //hotmail,gmail,outlook, y la del tec
        int s = 0;
        do {
            String nombre = JOptionPane.showInputDialog("Ingrese un Nombre");

            try {
                Pattern pat = Pattern.compile("[a-zA-Z]+\\s[a-zA-Z]+$");
                Matcher mat = pat.matcher(nombre);

                if (mat.matches()) {
                    System.out.println("Cadena válida");
                } else {
                    System.out.println("Cadena no válida");
                }
            } catch (Exception e) {
                System.err.println("Error en la expresión regular: " + e.getMessage());
            }
            s = Integer.parseInt(JOptionPane.showInputDialog("Deseas salir s=1, no=0"));
        } while (s <= 100);
    }

}
