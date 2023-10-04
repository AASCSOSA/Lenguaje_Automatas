/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.lenguaje_automata;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author alanh
 */
public class Lenguaje_Automata {

    public static void main(String[] args) {
        int s = 0;
        do {
            String cadenaUno = JOptionPane.showInputDialog("Ingrese una cadena");

//           Pattern pat= Pattern.compile("[^a-z][a-z]+");
//           Pattern pat= Pattern.compile("[A-Z][a-z]+\\s[A-Z][a-z]+");
            try {
                //Pattern pat = Pattern.compile("a*|bb*");
                //Pattern pat = Pattern.compile("[A-Z][a-z]+\\s[A-Z][a-z]+");
                Pattern pat = Pattern.compile("[^a-z][a-z]+");
                Matcher mat = pat.matcher(cadenaUno);
                if (mat.matches()) {
                    System.out.println(cadenaUno + "\n" + "Cadena válida");
                } else {
                    System.out.println(cadenaUno + "\n" + "Cadena no válida");
                }
            } catch (Exception e) {
                System.err.println("Error en la expresión regular: " + e.getMessage());

            }
            s = Integer.parseInt(JOptionPane.showInputDialog("Deseas salir s=1, no=0"));
        } while (s == 0);

//    for(int longitud=0;longitud<=10;longitud++){
//        String alfabeto = "abcdefghijklmnopqrstuvwxyz"; // Alfabeto de letras minúsculas
//        String palabrarandom = generarPalabra(longitud, alfabeto);
//        System.out.println("Palabra aleatoria: " + palabrarandom);
//    }
//    }
//
//    public static String generarPalabra(int longitud, String alfabeto) {
//        Random random = new Random();
//        StringBuilder sb = new StringBuilder(longitud);
//
//        for (int i = 0; i < longitud; i++) {
//            int index = random.nextInt(alfabeto.length());
//            char Char = alfabeto.charAt(index);
//            sb.append(Char);
//        }
//
//        return sb.toString();
//    }
    }
}
