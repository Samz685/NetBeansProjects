/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ventanalogin;

/**
 *
 * @author MichanGalvanJamai
 */
public class Login1 extends javax.swing.JFrame {

    /**
     * Creates new form Login1
     */
    public Login1() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Introduzca = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Usuario = new javax.swing.JLabel();
        TextUsuario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        Passw = new javax.swing.JLabel();
        Pwd = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        Recordar = new javax.swing.JCheckBox();
        Olvide = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Acceder = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        Informacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMinimumSize(new java.awt.Dimension(250, 400));
        setPreferredSize(new java.awt.Dimension(250, 400));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(330, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(330, 400));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.add(jLabel1);

        Introduzca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Introduzca.setText("<html>Introduzca su usuario y contrase??a<br> para acceder a la <strong style=\"color blue\">aplicaci??n</strong> </html>");
        jPanel5.add(Introduzca);

        jPanel1.add(jPanel5);

        Usuario.setText("Usuario");
        jPanel2.add(Usuario);

        TextUsuario.setText("usuario");
        TextUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(TextUsuario);

        jPanel1.add(jPanel2);

        Passw.setText("Contrase??a");
        jPanel3.add(Passw);

        Pwd.setText("jPas");
        Pwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PwdActionPerformed(evt);
            }
        });
        jPanel3.add(Pwd);

        jPanel1.add(jPanel3);

        Recordar.setText("Recuerdame");
        Recordar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecordarActionPerformed(evt);
            }
        });
        jPanel6.add(Recordar);

        Olvide.setForeground(new java.awt.Color(0, 102, 255));
        Olvide.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Olvide.setText("<html><u>Olvid?? la contrase??a</u></html>");
        jPanel6.add(Olvide);

        jPanel1.add(jPanel6);

        Acceder.setText("Acceder");
        Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccederActionPerformed(evt);
            }
        });
        jPanel4.add(Acceder);

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        jPanel4.add(Cancelar);

        jPanel1.add(jPanel4);

        jPanel7.setPreferredSize(new java.awt.Dimension(250, 500));

        Informacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Informacion.setText("Informaci??n de Login");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Informacion)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 70, Short.MAX_VALUE)
                    .addComponent(Informacion)
                    .addGap(0, 70, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel7);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextUsuarioActionPerformed

    private void AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccederActionPerformed
        if ("sam".equals(TextUsuario.getText() ) && "1234".equals(new String(Pwd.getPassword()))) {
            if (Recordar.isSelected()) {
                Informacion.setText("Te recordar?? Sam!");
            }else{
                Informacion.setText("Hola Sam");
            }  
        }else{
            Informacion.setText("Error en el login");
        }
    }//GEN-LAST:event_AccederActionPerformed

    private void RecordarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecordarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecordarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CancelarActionPerformed

    private void PwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PwdActionPerformed

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
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acceder;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Informacion;
    private javax.swing.JLabel Introduzca;
    private javax.swing.JLabel Olvide;
    private javax.swing.JLabel Passw;
    private javax.swing.JPasswordField Pwd;
    private javax.swing.JCheckBox Recordar;
    private javax.swing.JTextField TextUsuario;
    private javax.swing.JLabel Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
