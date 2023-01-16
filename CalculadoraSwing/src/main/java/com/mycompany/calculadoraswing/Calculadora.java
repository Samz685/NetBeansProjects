package com.mycompany.calculadoraswing;

public class Calculadora extends javax.swing.JFrame {

    public float num1;
    public float num2;
    public String operador;

    public Calculadora() {

        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1_pantalla = new javax.swing.JPanel();
        pantallaTxt = new javax.swing.JTextField();
        botonBorrar = new javax.swing.JButton();
        botonDel = new javax.swing.JButton();
        botonRaiz = new javax.swing.JButton();
        jPanel2_teclado = new javax.swing.JPanel();
        boton7 = new javax.swing.JButton();
        boton8 = new javax.swing.JButton();
        boton9 = new javax.swing.JButton();
        botonMulti = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        boton5 = new javax.swing.JButton();
        boton6 = new javax.swing.JButton();
        botonDivision = new javax.swing.JButton();
        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        botonResta = new javax.swing.JButton();
        botonComa = new javax.swing.JButton();
        boton0 = new javax.swing.JButton();
        botonResultado = new javax.swing.JButton();
        botonSuma = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(365, 412));
        setMinimumSize(new java.awt.Dimension(365, 412));
        setResizable(false);
        setSize(new java.awt.Dimension(365, 412));
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        pantallaTxt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pantallaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pantallaTxtActionPerformed(evt);
            }
        });

        botonBorrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonBorrar.setText("C");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonDel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonDel.setText("DEL");
        botonDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDelActionPerformed(evt);
            }
        });

        botonRaiz.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonRaiz.setText("√");
        botonRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRaizActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1_pantallaLayout = new javax.swing.GroupLayout(jPanel1_pantalla);
        jPanel1_pantalla.setLayout(jPanel1_pantallaLayout);
        jPanel1_pantallaLayout.setHorizontalGroup(
            jPanel1_pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1_pantallaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonDel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonRaiz, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1_pantallaLayout.createSequentialGroup()
                .addComponent(pantallaTxt)
                .addContainerGap())
        );
        jPanel1_pantallaLayout.setVerticalGroup(
            jPanel1_pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1_pantallaLayout.createSequentialGroup()
                .addComponent(pantallaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1_pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1_pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botonRaiz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonDel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        getContentPane().add(jPanel1_pantalla);

        jPanel2_teclado.setLayout(new java.awt.GridLayout(5, 4));

        boton7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boton7.setText("7");
        boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton7ActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(boton7);

        boton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boton8.setText("8");
        boton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton8ActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(boton8);

        boton9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boton9.setText("9");
        boton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton9ActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(boton9);

        botonMulti.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonMulti.setText("*");
        botonMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMultiActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(botonMulti);

        boton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boton4.setText("4");
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(boton4);

        boton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boton5.setText("5");
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(boton5);

        boton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boton6.setText("6");
        boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton6ActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(boton6);

        botonDivision.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonDivision.setText("/");
        botonDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDivisionActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(botonDivision);

        boton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boton1.setText("1");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(boton1);

        boton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boton2.setText("2");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(boton2);

        boton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boton3.setText("3");
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(boton3);

        botonResta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonResta.setText("-");
        botonResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestaActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(botonResta);

        botonComa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonComa.setText(",");
        botonComa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComaActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(botonComa);

        boton0.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boton0.setText("0");
        boton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton0ActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(boton0);

        botonResultado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonResultado.setText("=");
        botonResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonResultadoActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(botonResultado);

        botonSuma.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonSuma.setText("+");
        botonSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSumaActionPerformed(evt);
            }
        });
        jPanel2_teclado.add(botonSuma);

        getContentPane().add(jPanel2_teclado);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton7ActionPerformed
        pantallaTxt.setText(pantallaTxt.getText() + 7);
    }//GEN-LAST:event_boton7ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        pantallaTxt.setText(pantallaTxt.getText() + 2);
    }//GEN-LAST:event_boton2ActionPerformed

    private void pantallaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pantallaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pantallaTxtActionPerformed

    private void boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton8ActionPerformed
        pantallaTxt.setText(pantallaTxt.getText() + 8);
    }//GEN-LAST:event_boton8ActionPerformed

    private void boton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton9ActionPerformed
        pantallaTxt.setText(pantallaTxt.getText() + 9);
    }//GEN-LAST:event_boton9ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        pantallaTxt.setText(pantallaTxt.getText() + 4);
    }//GEN-LAST:event_boton4ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
        pantallaTxt.setText(pantallaTxt.getText() + 5);
    }//GEN-LAST:event_boton5ActionPerformed

    private void boton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton6ActionPerformed
        pantallaTxt.setText(pantallaTxt.getText() + 6);
    }//GEN-LAST:event_boton6ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        pantallaTxt.setText(pantallaTxt.getText() + 1);
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        pantallaTxt.setText(pantallaTxt.getText() + 3);
    }//GEN-LAST:event_boton3ActionPerformed

    private void boton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton0ActionPerformed
        pantallaTxt.setText(pantallaTxt.getText() + 0);
    }//GEN-LAST:event_boton0ActionPerformed

    private void botonComaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComaActionPerformed
        if (!pantallaTxt.getText().contains(".")) {
            pantallaTxt.setText(pantallaTxt.getText() + ".");
        }

    }//GEN-LAST:event_botonComaActionPerformed

    private void botonSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSumaActionPerformed

        num1 = Float.parseFloat(pantallaTxt.getText());
        operador = "+";
        pantallaTxt.setText("");

    }//GEN-LAST:event_botonSumaActionPerformed

    private void botonResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonResultadoActionPerformed

        num2 = Float.parseFloat(pantallaTxt.getText());
        switch (operador) {
            case "+":
                pantallaTxt.setText(Float.toString(num1 + num2));
                break;
            case "-":
                pantallaTxt.setText(Float.toString(num1 - num2));
                break;
            case "*":
                pantallaTxt.setText(Float.toString(num1 * num2));
                break;
            case "/":
                pantallaTxt.setText(Float.toString(num1 / num2));
                break;
            case "√":
                pantallaTxt.setText(Float.toString((float) Math.sqrt(num1)));
                break;

        }

    }//GEN-LAST:event_botonResultadoActionPerformed

    private void botonDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDivisionActionPerformed
        num1 = Float.parseFloat(pantallaTxt.getText());
        operador = "/";
        pantallaTxt.setText("");
    }//GEN-LAST:event_botonDivisionActionPerformed

    private void botonRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestaActionPerformed
        num1 = Float.parseFloat(pantallaTxt.getText());
        operador = "-";
        pantallaTxt.setText("");
    }//GEN-LAST:event_botonRestaActionPerformed

    private void botonMultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMultiActionPerformed

        num1 = Float.parseFloat(pantallaTxt.getText());
        operador = "*";
        pantallaTxt.setText("");
    }//GEN-LAST:event_botonMultiActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        pantallaTxt.setText("");
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDelActionPerformed

        String cadena = pantallaTxt.getText();
        pantallaTxt.setText("");

        for (int i = 0; i < cadena.length() - 1; i++) {
            pantallaTxt.setText(pantallaTxt.getText() + cadena.charAt(i));
        }
    }//GEN-LAST:event_botonDelActionPerformed

    private void botonRaizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRaizActionPerformed
        num1 = Float.parseFloat(pantallaTxt.getText());
        operador = "√";

    }//GEN-LAST:event_botonRaizActionPerformed

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
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton0;
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton boton5;
    private javax.swing.JButton boton6;
    private javax.swing.JButton boton7;
    private javax.swing.JButton boton8;
    private javax.swing.JButton boton9;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonComa;
    private javax.swing.JButton botonDel;
    private javax.swing.JButton botonDivision;
    private javax.swing.JButton botonMulti;
    private javax.swing.JButton botonRaiz;
    private javax.swing.JButton botonResta;
    private javax.swing.JButton botonResultado;
    private javax.swing.JButton botonSuma;
    private javax.swing.JPanel jPanel1_pantalla;
    private javax.swing.JPanel jPanel2_teclado;
    private javax.swing.JTextField pantallaTxt;
    // End of variables declaration//GEN-END:variables
}
