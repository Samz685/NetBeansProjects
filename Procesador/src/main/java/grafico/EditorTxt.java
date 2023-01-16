/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Syzer
 */
public class EditorTxt extends javax.swing.JFrame implements Runnable {
//-------------------------Abrir y guardar archivos variables-------------------------

    JFileChooser seleccionar = new JFileChooser();
    File archivo0;
    FileInputStream entrada;
    FileOutputStream salida;
    Boolean semaforo = false;
    String ubi = "";
    long tam = 0;
//-------------------------Variables para fuentes-------------------------
    private String fuentes[];
    private String estilos[];
    StyledDocument doc;
    Style color0;
//-------------------------Variables para hora-------------------------    
    String hora, minutos, segundos;
    Thread hilo;

    public EditorTxt() {

        initComponents();
        fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        cargarComponentes();
        fecha.setText(fecha());
        //hora.setText(hora());

        doc = area.getStyledDocument();
        color0 = area.addStyle("miEstilo", null);
        //------------Hilo de la Hora-----------------------------------
        try {
            hilo = new Thread(this);
            hilo.start();
            
        } catch (Exception e) {
        }
        
        setVisible(true);

    }
    //------------Métodos fecha y hora-----------------------------------
    public static String fecha() {
        Date fecha0 = new Date();

        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha0);
    }

    public void hora() {

        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        calendario.setTime(horaActual);
        hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

    public void run() {

        Thread current = Thread.currentThread();
        for (int i = 1; i > 0; i++) {
            if (i > 0) {
                hora();
                cajaHora.setText(hora + ":" + minutos + ":" + segundos);
            }
        }
    }
    //------------Métodos Ruta y Tamaño del archivo-----------------------------------
    public String rutaArchivo(File arch) {

        try {

            if (semaforo == true) {
                ubi = arch.getAbsolutePath();
            } else {
                ubi = "No hay archivo";
            }

        } catch (Exception e) {
        }

        return ubi;
    }

    public long tamagnioArchivo(File arch) {

        if (semaforo == true) {
            tam = arch.length();

        } else {
            return tam;
        }
        return tam;

    }
    //------------Añadir fuentes del sistema a la variable fuentes-----------------------------------
    private void cargarComponentes() {

        for (int i = 12; i <= 30; i++) {
            tamaño.addItem(i);
        }

        for (String fuente1 : fuentes) {
            fuente.addItem(fuente1);

        }

    }

    public String AbrirArchivo(File archivo) {

        String documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while ((ascci = entrada.read()) != -1) {
                char caracter = (char) ascci;
                documento += caracter;
                semaforo = true;
                ubicacion.setText(rutaArchivo(archivo0));
                cajaTamano.setText(String.valueOf(tamagnioArchivo(archivo0))+" bytes");

            }

        } catch (Exception e) {
        }

        return documento;
    }
    //------------Métodos Abrir y Guardar archivos-----------------------------------
    public String GuardarArchivo(File archivo, String documento) {

        String mensaje = null;
        try {
            salida = new FileOutputStream(archivo0);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "Archivo guardado";

        } catch (Exception e) {
        }
        return mensaje;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fechatxt = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        horatxt = new javax.swing.JLabel();
        cajaHora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cajaTamano = new javax.swing.JLabel();
        ubicaciontxt = new javax.swing.JLabel();
        ubicacion = new javax.swing.JLabel();
        panelTexto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextPane();
        panelPrincipal = new javax.swing.JPanel();
        fuente = new javax.swing.JComboBox<>();
        tamaño = new javax.swing.JComboBox();
        estilo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        color = new javax.swing.JButton();
        minus = new javax.swing.JButton();
        mayus = new javax.swing.JButton();
        acerca = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        fechatxt.setText("FECHA:");
        jPanel1.add(fechatxt);

        fecha.setText("fecha");
        jPanel1.add(fecha);

        horatxt.setText("     HORA:");
        jPanel1.add(horatxt);

        cajaHora.setText("hora");
        jPanel1.add(cajaHora);

        jLabel1.setText("    TAMAÑO:");
        jPanel1.add(jLabel1);

        cajaTamano.setText("0 bytes");
        jPanel1.add(cajaTamano);

        ubicaciontxt.setText("    Ubicación:");
        jPanel1.add(ubicaciontxt);

        ubicacion.setText("No hay archivo");
        jPanel1.add(ubicacion);

        panelTexto.setLayout(new java.awt.GridLayout(1, 1));

        jScrollPane1.setViewportView(area);

        panelTexto.add(jScrollPane1);

        fuente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fuente" }));
        fuente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fuenteItemStateChanged(evt);
            }
        });
        fuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuenteActionPerformed(evt);
            }
        });
        panelPrincipal.add(fuente);

        tamaño.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tamaño" }));
        tamaño.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tamañoItemStateChanged(evt);
            }
        });
        tamaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamañoActionPerformed(evt);
            }
        });
        panelPrincipal.add(tamaño);

        estilo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estilo", "Negrita", "Cursiva", "Cursiva/Negrita" }));
        estilo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                estiloItemStateChanged(evt);
            }
        });
        estilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estiloActionPerformed(evt);
            }
        });
        panelPrincipal.add(estilo);

        jButton2.setText("Camel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelPrincipal.add(jButton2);

        color.setText("COLOR");
        color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorActionPerformed(evt);
            }
        });
        panelPrincipal.add(color);

        minus.setText("minúscula");
        minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusActionPerformed(evt);
            }
        });
        panelPrincipal.add(minus);

        mayus.setText("MAYUS");
        mayus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mayusActionPerformed(evt);
            }
        });
        panelPrincipal.add(mayus);

        acerca.setText("Acerca de...");
        acerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaActionPerformed(evt);
            }
        });
        panelPrincipal.add(acerca);

        archivo.setText("File");
        archivo.setActionCommand("Abrir");

        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        archivo.add(abrir);

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        archivo.add(guardar);

        jMenuBar1.add(archivo);
        archivo.getAccessibleContext().setAccessibleName("Abrir");

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(panelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed

        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo0 = seleccionar.getSelectedFile();
            if (archivo0.canRead()) {
                if (archivo0.getName().endsWith("txt")) {
                    String documento = AbrirArchivo(archivo0);
                    area.setText(documento);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no válido");

                }

            }

        }

    }//GEN-LAST:event_abrirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

        if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo0 = seleccionar.getSelectedFile();
            if (archivo0.getName().endsWith("txt")) {
                String documento = area.getText();
                String mensaje = GuardarArchivo(archivo0, documento);
                if (mensaje != null) {
                    JOptionPane.showConfirmDialog(null, mensaje);

                } else {
                    JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Guardar Documento de Texto");
            }
        }


    }//GEN-LAST:event_guardarActionPerformed

    private void fuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuenteActionPerformed


    }//GEN-LAST:event_fuenteActionPerformed

    private void tamañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamañoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamañoActionPerformed

    private void fuenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fuenteItemStateChanged

        Font f = area.getFont();
        area.setFont(new Font(String.valueOf(fuente.getSelectedItem()), Font.PLAIN, f.getSize()));


    }//GEN-LAST:event_fuenteItemStateChanged

    private void tamañoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tamañoItemStateChanged
        Font f = area.getFont();
        area.setFont(new Font(f.getName(), Font.PLAIN, Integer.parseInt(String.valueOf(tamaño.getSelectedItem()))));
    }//GEN-LAST:event_tamañoItemStateChanged

    private void estiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estiloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estiloActionPerformed

    private void estiloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_estiloItemStateChanged
        Font f = area.getFont();
        area.setFont(new Font(f.getName(), estilo.getSelectedIndex(), f.getSize()));
    }//GEN-LAST:event_estiloItemStateChanged

    private void mayusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mayusActionPerformed

        String mayuscula = area.getText().toUpperCase();

        area.setText(mayuscula);

    }//GEN-LAST:event_mayusActionPerformed

    private void colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorActionPerformed
        try {
            StyleConstants.setForeground(color0, JColorChooser.showDialog(this, "seleccione un color", Color.yellow));
            doc.setCharacterAttributes(area.getSelectionStart(), area.getSelectionEnd() - area.getSelectionStart(), area.getStyle("miEstilo"), true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_colorActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String Camel = area.getText();
        String finala = "";
        String inputstring = Camel;
        String resultado = "";
        char first = inputstring.charAt(0);
        char firsttouppercase = Character.toUpperCase(first);
        resultado = resultado + firsttouppercase;
        for (int i = 1; i < inputstring.length(); i++) {
            char current = inputstring.charAt(i);
            char previous = inputstring.charAt(i - 1);
            if (previous == ' ') {
                char currenttouppercase = Character.toUpperCase(current);
                resultado = resultado + currenttouppercase;
            } else {
                char currenttolowercase = Character.toLowerCase(current);
                resultado = resultado + currenttolowercase;
            }
        }
        area.setText(resultado);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusActionPerformed
        String minuscula = area.getText().toLowerCase();
        area.setText(minuscula);
    }//GEN-LAST:event_minusActionPerformed

    private void acercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaActionPerformed
        AcercaDe acercaDe = new AcercaDe(this, true);
        acercaDe.setVisible(true);
    }//GEN-LAST:event_acercaActionPerformed

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
            java.util.logging.Logger.getLogger(EditorTxt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorTxt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorTxt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorTxt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorTxt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir;
    private javax.swing.JButton acerca;
    private javax.swing.JMenu archivo;
    private javax.swing.JTextPane area;
    private javax.swing.JLabel cajaHora;
    private javax.swing.JLabel cajaTamano;
    private javax.swing.JButton color;
    private javax.swing.JComboBox<String> estilo;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel fechatxt;
    private javax.swing.JComboBox<String> fuente;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JLabel horatxt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mayus;
    private javax.swing.JButton minus;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTexto;
    private javax.swing.JComboBox tamaño;
    private javax.swing.JLabel ubicacion;
    private javax.swing.JLabel ubicaciontxt;
    // End of variables declaration//GEN-END:variables

//    @Override
//    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
