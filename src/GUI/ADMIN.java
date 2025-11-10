package GUI;

import GUI_ADMIN.Gestion_Usuarios;

public class ADMIN extends javax.swing.JFrame {

    public ADMIN() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BTN_Cerrar_Sesión = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        btn_Ingresos = new javax.swing.JMenuItem();
        btn_Inventarios = new javax.swing.JMenuItem();
        btn_Ventas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("BIENVENIDO AL GESTOR DE TU TIENDA");

        BTN_Cerrar_Sesión.setBackground(new java.awt.Color(204, 0, 0));
        BTN_Cerrar_Sesión.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        BTN_Cerrar_Sesión.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Cerrar_Sesión.setText("CERRAR SESION");
        BTN_Cerrar_Sesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Cerrar_SesiónActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BTN_Cerrar_Sesión))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                .addComponent(BTN_Cerrar_Sesión)
                .addContainerGap())
        );

        jMenuBar2.setBackground(new java.awt.Color(255, 255, 255));

        jMenu3.setBackground(new java.awt.Color(255, 255, 255));
        jMenu3.setForeground(new java.awt.Color(0, 0, 0));
        jMenu3.setText("MODULOS");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btn_Ingresos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Ingresos.setText("INGRESOS");
        btn_Ingresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IngresosActionPerformed(evt);
            }
        });
        jMenu3.add(btn_Ingresos);

        btn_Inventarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Inventarios.setText("INVENTARIO");
        btn_Inventarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InventariosActionPerformed(evt);
            }
        });
        jMenu3.add(btn_Inventarios);

        btn_Ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Ventas.setText("VENTAS");
        btn_Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VentasActionPerformed(evt);
            }
        });
        jMenu3.add(btn_Ventas);

        jMenuBar2.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(255, 255, 255));
        jMenu4.setForeground(new java.awt.Color(0, 0, 0));
        jMenu4.setText("ADMIN");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem7.setText("GESTION DE USUARIOS");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem8.setText("REPORTES");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_IngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IngresosActionPerformed
        INGRESO ig = new INGRESO();
        ig.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_IngresosActionPerformed

    private void btn_InventariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InventariosActionPerformed
        Inventario iv = new Inventario();
        iv.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_InventariosActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Gestion_Usuarios gu =  new Gestion_Usuarios();
        gu.setVisible(true);
        dispose();
        

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void BTN_Cerrar_SesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Cerrar_SesiónActionPerformed
        Inicio_Sesion ins = new Inicio_Sesion();
        ins.setVisible(true);
        dispose();
    }//GEN-LAST:event_BTN_Cerrar_SesiónActionPerformed

    private void btn_VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VentasActionPerformed
        Ventas vt = new Ventas();
        vt.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_VentasActionPerformed

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
            java.util.logging.Logger.getLogger(ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADMIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar_Sesión;
    private javax.swing.JMenuItem btn_Ingresos;
    private javax.swing.JMenuItem btn_Inventarios;
    private javax.swing.JMenuItem btn_Ventas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
