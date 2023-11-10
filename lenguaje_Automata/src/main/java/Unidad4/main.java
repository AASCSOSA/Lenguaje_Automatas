/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Unidad4;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alanh
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    DefaultTableModel tblmodel = new DefaultTableModel();

    public main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        txtTexto = new JTextField();
        btnVerificar = new JButton();
        jScrollPane2 = new JScrollPane();
        jtxtaPrueba = new JTextArea();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Ingresar texto:");

        txtTexto.setFont(new Font("Segoe UI", 1, 12)); // NOI18N

        btnVerificar.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        jtxtaPrueba.setEditable(false);
        jtxtaPrueba.setColumns(20);
        jtxtaPrueba.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jtxtaPrueba.setRows(5);
        jScrollPane2.setViewportView(jtxtaPrueba);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnVerificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(txtTexto, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTexto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnVerificar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        CargarMetodos();
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void CargarMetodos() {

        String[] palabrasRS = palabrasReservadas();
        ArrayList<String> palabras = separarCadenas();

        ArrayList<String> obtenerComparacion = compararPalabrasReservadas(palabrasRS, palabras);

        ArrayList<String> obtenerPalabraAnalisis = obtenerPalabrasAnalisis(palabrasRS, palabras);
        
        jtxtaPrueba.setText("");
        txtTexto.setText("");
        for (String comparacion : obtenerComparacion) {
            jtxtaPrueba.append(comparacion + "\n");
        }
        for (String analisis : obtenerPalabraAnalisis) {
            jtxtaPrueba.append(analisis + "\n");
        }

    }

    private String[] palabrasReservadas() {
        String palabrasReservadas[] = {"abstract", "boolean", "break", "byte", "byvalue", "case", "cast", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "final", "finally", "float", "for", "future", "generic", "goto", "if", "implements",
            "import", "inner", "instanceof", "int", "interface", "long", "native", "new", "null", "operator", "outer", "package", "private", "protected",
            "public", "rest", "return", "short", "static", "super", "switch", "synchronized", "this", "threadsafe", "throw", "transient", "try", "var",
            "void", "while", "id", "int", "long", "double", "float", "boolean", "char", "cadenas", "++", "--", "!", "*", "/", "%", "+", "-", "<",
            ">", "<=", ">=", "==", "!=", "&&", "||", "?", "=", "(", ")", "{", "}", "[", "]", ";", ",", ".", "//", "/*", "/**"
        };
        return palabrasReservadas;
    }

    private ArrayList<String> separarCadenas() {
        String[] palabrasSeparadasArray;
        ArrayList<String> palabrasSeparadasList = new ArrayList<>();
        String cadenaSeparada = txtTexto.getText();

        if (cadenaSeparada.isEmpty()) {
            return null;
        } else {
            // Expresión regular para separar palabras, operadores, delimitadores y comentarios en Java
            //String delimitadores = "(\\s+|([-+*/(),;])|(\\==)|(\\=))";
            //String delimitadores = "(?<=(\\==)|=)|(?=(\\==)|=)|(?<=\\s)|(?=\\s)|(?<=[-+*/(),;])|(?=[-+*/(),;])";
            
            String delimitadores = "(?<=\\s)|(?=\\s)|(?<=[-+*/(),;=])|(?=[-+*/(),;=])";
            palabrasSeparadasArray = cadenaSeparada.split(delimitadores);
            // Se recorre el array para tomar los datos que no sean vacíos y se guardan en un ArrayList
            for (String palabraSeparada : palabrasSeparadasArray) {
                if (!palabraSeparada.isEmpty() && !palabraSeparada.trim().isEmpty()) {
                    palabrasSeparadasList.add(palabraSeparada);
                }
            }
            return palabrasSeparadasList;
        }
    }

    private ArrayList<String> compararPalabrasReservadas(String[] palabrasRS, ArrayList<String> palabras) {
        ArrayList<String> comparacion = new ArrayList<>();
        String[] palabrasRes = palabrasRS;
        ArrayList<String> palabrasS = palabras;

        int contador;
        //Recorre los array, se realiza una comparación y se reinicia el contador para que pueda este volver a entrar a la instrucción
        for (String palabrasSeparadas : palabrasS) {
            contador = 0;
            for (String palabrasReservas : palabrasRes) {
                contador++;
                if (palabrasReservas.equals(palabrasSeparadas)) {
                    if (contador >= 0 && contador <= 56) {
                        comparacion.add(contador + " Palabra reservada " + palabrasSeparadas);
                    } else if (contador == 57) {
                        comparacion.add(contador + " Identificador " + palabrasSeparadas);
                    } else if (contador >= 58 && contador <= 64) {
                        comparacion.add(contador + " Literales " + palabrasSeparadas);
                    } else if (contador >= 65 && contador <= 82) {
                        comparacion.add(contador + " Operadores " + palabrasSeparadas);
                    } else if (contador >= 83 && contador <= 91) {
                        comparacion.add(contador + " Delimitador " + palabrasSeparadas);
                    } else if (contador >= 92 && contador <= 94) {
                        comparacion.add(contador + " Comentarios " + palabrasSeparadas);
                    }
                }
            }
        }
        return comparacion;
    }

    private ArrayList<String> obtenerPalabrasAnalisis(String[] palabrasRS, ArrayList<String> palabras) {
        ArrayList<String> palabrasRes = new ArrayList<>(Arrays.asList(palabrasRS));
        ArrayList<String> palabrasS = palabras;

        ArrayList<String> analizar = new ArrayList<>();
        ArrayList<String> palabrasAnalizadas = new ArrayList<>();
        for (String palabraSeparada : palabrasS) {
            if (!palabrasRes.contains(palabraSeparada)) {
                analizar.add(palabraSeparada);
            }
        }
        for (String analis : analizar) {
            try {
                Pattern patIdentificador = Pattern.compile("[a-z-A-Z][a-z-A-Z-0-9_]+|^(false|true)");
                //Números reales
                Pattern patLiteralNEntera = Pattern.compile("[0-9]+");
                Pattern patLiteralNEnteroLargo = Pattern.compile("[0-9]+L");

                //Números reales
                Pattern patLiteralDouble = Pattern.compile("[0-9]+[.][0-9]+d?");
                Pattern patLiteralFlotante = Pattern.compile("[0-9]+[.][0-9]+f");

                //Valores booleanos
                Pattern patVerdadero = Pattern.compile("true");
                Pattern patFalso = Pattern.compile("false");

                //Carcacteres
                Pattern patCaracter = Pattern.compile("\'[a-z-A-Z]\'");

                //Cadenas de caracteres
                Pattern patCadena = Pattern.compile("(\"([a-z-A-Z]+\\s[a-z-A-Z]+)*\")?||(\"[a-z-A-Z]+\")");

                Matcher mat = patIdentificador.matcher(analis);
                Matcher mat1 = patLiteralNEntera.matcher(analis);
                Matcher mat2 = patLiteralNEnteroLargo.matcher(analis);
                Matcher mat3 = patLiteralDouble.matcher(analis);
                Matcher mat4 = patLiteralFlotante.matcher(analis);
                Matcher mat5 = patVerdadero.matcher(analis);
                Matcher mat6 = patFalso.matcher(analis);
                Matcher mat7 = patCaracter.matcher(analis);
                Matcher mat8 = patCadena.matcher(analis);

                if (mat.matches()) {
                    palabrasAnalizadas.add("Cadena válida como identificador " + analis);
                } else if (mat1.matches()) {
                    palabrasAnalizadas.add("Cadena válida como Literal entera " + analis);
                } else if (mat2.matches()) {
                    palabrasAnalizadas.add("Cadena válida como Literal larga " + analis);
                } else if (mat3.matches()) {
                    palabrasAnalizadas.add("Cadena válida como Literal double " + analis);
                } else if (mat4.matches()) {
                    palabrasAnalizadas.add("Cadena válida como Literal flotante " + analis);
                } else if (mat5.matches()) {
                    palabrasAnalizadas.add("Cadena válida como valor booleano verdadero " + analis);
                } else if (mat6.matches()) {
                    palabrasAnalizadas.add("Cadena válida como valor booleano falso " + analis);
                } else if (mat7.matches()) {
                    palabrasAnalizadas.add("Cadena válida como caracter " + analis);
                } else if (mat8.matches()) {
                    palabrasAnalizadas.add("Cadena válida como cadena " + analis);
                } else {
                    palabrasAnalizadas.add("Cadena no válida " + analis);
                }
            } catch (Exception e) {
            }
        }
        return palabrasAnalizadas;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnVerificar;
    private JLabel jLabel1;
    private JScrollPane jScrollPane2;
    private JTextArea jtxtaPrueba;
    private JTextField txtTexto;
    // End of variables declaration//GEN-END:variables
}
