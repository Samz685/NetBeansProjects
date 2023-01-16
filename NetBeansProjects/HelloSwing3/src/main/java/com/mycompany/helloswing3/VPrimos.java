/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.helloswing3;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author MichanGalvanJamai
 */
public class VPrimos extends javax.swing.JFrame {

    private ArrayList<Integer> numeros = new ArrayList<>();
    private Integer inicio = 1;
    private Integer fin = 10;
    private DefaultListModel modelolistado = new DefaultListModel();
    
    private Vpconfig dialogo = new Vpconfig(this, true);
    
    public VPrimos() {
        initComponents();
        listaP.setModel(modelolistado);
        
        actualizarLista();
        
        
    }

    
    
    public static boolean esPrimo(int num1){
        
        boolean esPrimo = true;
        int divisor = num1/2;
        while (esPrimo && divisor > 1){
            int resto = num1%divisor;
            if (resto == 0){
                esPrimo = false;
            }divisor--;
        }
        return esPrimo;
    }
    
     public void actualizarLista(){
        numeros.clear();
        for(Integer i = inicio; i <= fin ; i++){
            if(esPrimo(i)) numeros.add(i);
                
            }
       
        modelolistado.addAll(numeros); 
        numeros.clear();
    }

     public void actualizarTodo(Integer ini, Integer fin){
         inicio = ini;
         this.fin = fin;
         actualizarLista();
         
         
     }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaP = new javax.swing.JList<>();
        Bconfig = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 200));
        setPreferredSize(new java.awt.Dimension(200, 400));
        setResizable(false);

        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Primos");
        getContentPane().add(Titulo, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportView(listaP);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        Bconfig.setText("Configurar...");
        Bconfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BconfigActionPerformed(evt);
            }
        });
        getContentPane().add(Bconfig, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BconfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BconfigActionPerformed
        
        dialogo.setup(inicio, fin);
        dialogo.setVisible(true);
        
        
    }//GEN-LAST:event_BconfigActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPrimos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bconfig;
    private javax.swing.JLabel Titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaP;
    // End of variables declaration//GEN-END:variables
}
