/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.ProductoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.Producto;


public class VentanaProducto extends javax.swing.JFrame {

 
    static ProductoDAO datos;
    private Integer idProductoActual = null;

    private static final int COL_ID = 0;
    private static final int COL_NOMBRE = 1;
    private static final int COL_TIPO = 2;
    private static final int COL_PRECIO = 3;
    private static final int COL_DISPONIBILIDAD = 4;

    public VentanaProducto(ProductoDAO datosExternos) {

        datos = datosExternos;
        initComponents();

        setLocationRelativeTo(this); //para que esté en el centro de la ventana

        actualizarTabla();

    }

    private void actualizarTabla() {

        ArrayList<Producto> productos = datos.verCarta();

        ((DefaultTableModel) tabla.getModel()).setRowCount(0);

        for (var p : productos) {
            Object fila[] = {
                p.getIdPro(),
                p.getNombre(),
                p.getTipo(),
                p.getPrecio(),
                p.getDisponibilidad()

            };
            ((DefaultTableModel) tabla.getModel()).addRow(fila);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        comboDisponible = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Tipo", "Precio", "Disponibilidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir);

        jPanel1.add(jPanel3, java.awt.BorderLayout.EAST);

        jPanel2.setLayout(new java.awt.GridLayout(3, 2, 15, 5));

        comboDisponible.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISPONIBLE", "AGOTADO" }));
        comboDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDisponibleActionPerformed(evt);
            }
        });
        jPanel2.add(comboDisponible);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);
        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        Integer pos_actual = tabla.getSelectedRow();

        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();

        comboDisponible.getModel().setSelectedItem((String) modeloTabla.getValueAt(pos_actual, COL_DISPONIBILIDAD));

        idProductoActual = (Integer) modeloTabla.getValueAt(pos_actual, COL_ID);
    }//GEN-LAST:event_tablaMouseClicked


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        //if( formularioVacio() ) return;
        Producto producto = datos.verProducto(idProductoActual);

        completarProductoDesdeFormulario(producto);

        datos.update(producto);

        actualizarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void completarProductoDesdeFormulario(Producto producto) {

        producto.setDisponibilidad((String) comboDisponible.getModel().getSelectedItem());
    }

    private void comboDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDisponibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDisponibleActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void borrarFormulario() {

        comboDisponible.getModel().setSelectedItem("DISPONIBLE");
    }

//    private boolean formularioVacio(){
//          Boolean vacio =  "".equals(txtNombre.getText()) || 
//            "".equals(txtApellidos.getText());
//          if(vacio){
//            JOptionPane.showMessageDialog(null, "Debes completar todos los campos",
//            "Campos vacios", JOptionPane.INFORMATION_MESSAGE);
//          }
//          return vacio;
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboDisponible;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
