package views;

import controllers.PedidoDAO;
import controllers.ProductoDAO;
import java.util.ArrayList;
import models.Pedido;
import static views.VentanaPrincipal.datosPed;
import static views.VentanaPrincipal.datosPro;

public class VentanaEstadisticas extends javax.swing.JDialog {

    private VentanaPedido ventanaPadre;
    

    public VentanaEstadisticas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        ventanaPadre = (VentanaPedido) parent;
        initComponents();

        setLocationRelativeTo(this);
        
      

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        btnPedidosSemana = new javax.swing.JButton();
        btnMejorCliente = new javax.swing.JButton();
        btnTotalClientes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnGananciasMes = new javax.swing.JButton();
        btnProductoMas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        cajaTotalClientes = new javax.swing.JLabel();
        cajaMejorCliente = new javax.swing.JLabel();
        cajaProductoMas = new javax.swing.JLabel();
        cajaGananciasmes = new javax.swing.JLabel();
        cajaPedidosSemana = new javax.swing.JLabel();
        btnPedidosHoy = new javax.swing.JButton();
        btnPedidoCliente = new javax.swing.JButton();
        cajaPedidoCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(444, 425));
        setMinimumSize(new java.awt.Dimension(444, 425));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        btnPedidosSemana.setText("Total pedidos semana");
        btnPedidosSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosSemanaActionPerformed(evt);
            }
        });

        btnMejorCliente.setText("Mejor Cliente");
        btnMejorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMejorClienteActionPerformed(evt);
            }
        });

        btnTotalClientes.setText("Total Clientes");
        btnTotalClientes.setMaximumSize(new java.awt.Dimension(145, 23));
        btnTotalClientes.setMinimumSize(new java.awt.Dimension(145, 23));
        btnTotalClientes.setPreferredSize(new java.awt.Dimension(145, 23));
        btnTotalClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalClientesActionPerformed(evt);
            }
        });

        jLabel1.setText("Busqueda y Estadisticas");

        btnGananciasMes.setText("Ganancias último mes");
        btnGananciasMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGananciasMesActionPerformed(evt);
            }
        });

        btnProductoMas.setText("Producto más vendido");
        btnProductoMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoMasActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        cajaTotalClientes.setText("nºclientes");

        cajaMejorCliente.setText("El mejor cliente es...");

        cajaProductoMas.setText("El prod. mejor vendido es...");

        cajaGananciasmes.setText("€ ultimo mes");

        cajaPedidosSemana.setText("nº pedidos");

        btnPedidosHoy.setText("Pedidos Pendientes Hoy");
        btnPedidosHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosHoyActionPerformed(evt);
            }
        });

        btnPedidoCliente.setText("Buscar Pedido por Cliente");
        btnPedidoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoClienteActionPerformed(evt);
            }
        });

        cajaPedidoCliente.setText("Cliente...");
        cajaPedidoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cajaPedidoClienteMouseClicked(evt);
            }
        });
        cajaPedidoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaPedidoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPedidosSemana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGananciasMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTotalClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPedidoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMejorCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cajaPedidoCliente)))
                            .addComponent(btnProductoMas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPedidosHoy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaGananciasmes)
                                    .addComponent(cajaTotalClientes)
                                    .addComponent(cajaPedidosSemana)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cajaMejorCliente))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cajaProductoMas))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnSalir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTotalClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaTotalClientes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGananciasMes))
                    .addComponent(cajaGananciasmes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPedidosSemana)
                    .addComponent(cajaPedidosSemana))
                .addGap(26, 26, 26)
                .addComponent(btnPedidosHoy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductoMas)
                    .addComponent(cajaProductoMas))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMejorCliente)
                    .addComponent(cajaMejorCliente))
                .addGap(18, 18, 18)
                .addComponent(btnPedidoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaPedidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        getContentPane().add(jPanel5);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGananciasMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGananciasMesActionPerformed

        int ventaMes = datosPed.verGananciasMes();
        cajaGananciasmes.setText(String.valueOf(ventaMes) + "€ total en el mes");
    }//GEN-LAST:event_btnGananciasMesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnTotalClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalClientesActionPerformed

        int nClientes = datosPed.verTotalClientes();
        cajaTotalClientes.setText(String.valueOf(nClientes) + " clientes");

    }//GEN-LAST:event_btnTotalClientesActionPerformed

    private void btnPedidosSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosSemanaActionPerformed

        int pedidosSemana = datosPed.verPedidosSemana();
        cajaPedidosSemana.setText(String.valueOf(pedidosSemana) + " pedidos esta semana");
    }//GEN-LAST:event_btnPedidosSemanaActionPerformed

    private void btnPedidosHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosHoyActionPerformed
    
        datosPed.verPedidoPendienteHoy();
        ventanaPadre.visualizarPedidoPendiente();
    }//GEN-LAST:event_btnPedidosHoyActionPerformed

    private void btnProductoMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoMasActionPerformed

        String masVendido = datosPed.verMasVendido();
        cajaProductoMas.setText(masVendido);

    }//GEN-LAST:event_btnProductoMasActionPerformed

    private void btnMejorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMejorClienteActionPerformed

        String mejorCliente = datosPed.verMejorCliente();
        cajaMejorCliente.setText(mejorCliente);
    }//GEN-LAST:event_btnMejorClienteActionPerformed

    private void btnPedidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoClienteActionPerformed

        String cliente = cajaPedidoCliente.getText();
        
        datosPed.verPedidoCliente(cliente);
        ventanaPadre.visualizarPedidoCliente(cliente);
       
        


    }//GEN-LAST:event_btnPedidoClienteActionPerformed

    private void cajaPedidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaPedidoClienteActionPerformed
        
        
        
    }//GEN-LAST:event_cajaPedidoClienteActionPerformed

    private void cajaPedidoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajaPedidoClienteMouseClicked
        cajaPedidoCliente.setText("");
    }//GEN-LAST:event_cajaPedidoClienteMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaEstadisticas dialog = new VentanaEstadisticas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGananciasMes;
    private javax.swing.JButton btnMejorCliente;
    private javax.swing.JButton btnPedidoCliente;
    private javax.swing.JButton btnPedidosHoy;
    private javax.swing.JButton btnPedidosSemana;
    private javax.swing.JButton btnProductoMas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTotalClientes;
    private javax.swing.JLabel cajaGananciasmes;
    private javax.swing.JLabel cajaMejorCliente;
    private javax.swing.JTextField cajaPedidoCliente;
    private javax.swing.JLabel cajaPedidosSemana;
    private javax.swing.JLabel cajaProductoMas;
    private javax.swing.JLabel cajaTotalClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
