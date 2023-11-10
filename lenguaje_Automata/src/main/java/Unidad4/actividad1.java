/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Unidad4;

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
        String palabrasReservadas[] = {"abstract", "boolean", "break", "byte", "byvalue", "case", "cast", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "final", "finally", "float", "for", "future", "generic", "goto", "if", "implements",
            "import", "inner", "instanceof", "int", "interface", "long", "native", "new", "null", "operator", "outer", "package", "private", "protected",
            "public", "rest", "return", "short", "static", "super", "switch", "synchronized", "this", "threadsafe", "throw", "transient", "try", "var",
            "void", "while", "id", "int", "long", "double", "float", "boolean", "char", "cadenas", "++", "--", "!", "*", "/", "%", "+", "-", "<",
            ">", "<=", ">=", "==", "!=", "&&", "||", "?", "=", "(", ")", "{", "}", "[", "]", ";", ",", ".", "//", "/*", "/**"
        };

        int s = 0;

        do {
            String entrada = JOptionPane.showInputDialog("Ingrese un palabra");

            try {
                Pattern patIdentificador = Pattern.compile("[a-zA-Z]+[-+]?[$+]?[a-zA-Z]+");
                //Números reales
                Pattern patLiteralNEntera = Pattern.compile("[0-9]+");
                Pattern patLiteralNEnteroLargo = Pattern.compile("[0-9]+L");

                //Números reales
                Pattern patLiteralDouble = Pattern.compile("[0-9]+[.][0-9]+d?");
                Pattern patLiteralFlotante = Pattern.compile("[0-9]+[.][0-9]+f");

                //Valores booleanos
                Pattern patVerdadero = Pattern.compile("(true)?");
                Pattern patFalso = Pattern.compile("(false)?");

                //Carcacteres
                Pattern patCaracter = Pattern.compile("\'[a-z-A-Z]\'");

                //Cadenas de caracteres
                Pattern patCadena = Pattern.compile("(\"([a-z-A-Z]+\\s[a-z-A-Z]+)*\")?||(\"[a-z-A-Z]+\")");

                Matcher mat = patIdentificador.matcher(entrada);
                Matcher mat1 = patLiteralNEntera.matcher(entrada);
                Matcher mat2 = patLiteralNEnteroLargo.matcher(entrada);
                Matcher mat3 = patLiteralDouble.matcher(entrada);
                Matcher mat4 = patLiteralFlotante.matcher(entrada);
                Matcher mat5 = patVerdadero.matcher(entrada);
                Matcher mat6 = patFalso.matcher(entrada);
                Matcher mat7 = patCaracter.matcher(entrada);
                Matcher mat8 = patCadena.matcher(entrada);

                if (compararPR(palabrasReservadas, entrada)) {
                    int indice = posicion(palabrasReservadas, entrada);
                    String palabraR = nombreToken(palabrasReservadas, entrada);
                    System.out.println("Tipo token: " + palabraR + "\nToken: " + indice);
                } else {
                    if (mat.matches()) {
                        System.out.println("Cadena válida como identificador");
                    } else if (mat1.matches()) {
                        System.out.println("Cadena válida como Literal entera");
                    } else if (mat2.matches()) {
                        System.out.println("Cadena válida como Literal larga");
                    } else if (mat3.matches()) {
                        System.out.println("Cadena válida como Literal double");
                    } else if (mat4.matches()) {
                        System.out.println("Cadena válida como Literal flotante");
                    } else if (mat5.matches()) {
                        System.out.println("Cadena válida como valor booleano verdadero");
                    } else if (mat6.matches()) {
                        System.out.println("Cadena válida como valor booleano falso");
                    } else if (mat7.matches()) {
                        System.out.println("Cadena válida como caracter");
                    } else if (mat8.matches()) {
                        System.out.println("Cadena válida como cadena");
                    } else {
                        System.out.println("Cadena no válida");
                    }
                }
            } catch (Exception e) {
                System.err.println("Error en la expresión regular: " + e.getMessage());
            }
            s = Integer.parseInt(JOptionPane.showInputDialog("Deseas salir s=1, no=0"));
        } while (s
                <= 100);

    }

    private static boolean compararPR(String[] palabrasReservadas, String entrada) {
        for (String palabrasReservada : palabrasReservadas) {
            if (palabrasReservada.equals(entrada)) {
                return true;
            }
        }
        return false;
    }

    private static int posicion(String[] palabrasReservadas, String entrada) {
        int contador = 0;
        for (String palabrasReservada : palabrasReservadas) {
            contador++;
            if (palabrasReservada.equals(entrada)) {
                return contador;
            }
        }
        return 0;
    }

    private static String nombreToken(String[] palabrasReservadas, String entrada) {
        int contador = 0;
        for (String palabrasReservada : palabrasReservadas) {
            contador++;
            if (palabrasReservada.equals(entrada)) {
                if(contador>0 && contador<=56){
                return "Palabra reservada";
                }else if(contador==57){
                    return "Identificador";
                }else if(contador>=58 && contador<=64){
                    return "Literales";
                }else if(contador>=65 && contador<=82){
                    return "Operadores";
                }else if(contador>=83 && contador<=91){
                    return "Delimitador";
                }else{
                    return "Comentarios";
                }
            }
        }
        return null;
    }

}
