/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.helloswing3;

import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author MichanGalvanJamai
 */
public class Vpconfig extends javax.swing.JDialog {

    
    
    private VPrimos ventanaPadre;
    
    
    public Vpconfig(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ventanaPadre = (VPrimos) parent;
        initComponents();
    }
    
    public void setup(Integer inicio, Integer fin){
        
        this.inicio.getModel().setValue(inicio);
        this.fin.getModel().setValue(fin);
        
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tinicio = new javax.swing.JLabel();
        Tfin = new javax.swing.JLabel();
        inicio = new javax.swing.JSpinner();
        fin = new javax.swing.JSpinner();
        aceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 150));
        setPreferredSize(new java.awt.Dimension(300, 150));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(3, 2, 0, 20));

        Tinicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tinicio.setText("INICIO");
        getContentPane().add(Tinicio);

        Tfin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tfin.setText("FIN");
        getContentPane().add(Tfin);
        getContentPane().add(inicio);
        getContentPane().add(fin);

        aceptar.setText("ACEPTAR");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar);

        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
    
        
        this.setVisible(false);
        
        ventanaPadre.actualizarTodo(
                                    (Integer) this.inicio.getModel().getValue(),
                                    (Integer) this.fin.getModel().getValue());
        
        
    }//GEN-LAST:event_aceptarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tfin;
    private javax.swing.JLabel Tinicio;
    private javax.swing.JButton aceptar;
    private javax.swing.JSpinner fin;
    private javax.swing.JSpinner inicio;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
