
package GUI;
import java.sql.*;
import gestor_ropa.BD_CONECCTION;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Inicio_Sesion extends javax.swing.JFrame {
    BD_CONECCTION bd1 = new BD_CONECCTION();
    Connection con = bd1.conectar();

    
    
    public Inicio_Sesion() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Campo_Correo_InicioSesion = new javax.swing.JTextField();
        Campo_Contraseña_InicioSesion = new javax.swing.JPasswordField();
        BTN_Salir_InicioSesion = new javax.swing.JButton();
        BTN_Entrar_InicioSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("CONTRASEÑA");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("INICIO DE SESION");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("CORREO ELECTRONICO");

        Campo_Correo_InicioSesion.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N

        Campo_Contraseña_InicioSesion.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N

        BTN_Salir_InicioSesion.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        BTN_Salir_InicioSesion.setText("SALIR");
        BTN_Salir_InicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Salir_InicioSesionActionPerformed(evt);
            }
        });

        BTN_Entrar_InicioSesion.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        BTN_Entrar_InicioSesion.setText("ENTRAR");
        BTN_Entrar_InicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Entrar_InicioSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BTN_Entrar_InicioSesion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTN_Salir_InicioSesion))
                            .addComponent(Campo_Correo_InicioSesion)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Campo_Contraseña_InicioSesion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel2)))
                .addContainerGap(331, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Campo_Correo_InicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Campo_Contraseña_InicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Salir_InicioSesion)
                    .addComponent(BTN_Entrar_InicioSesion))
                .addGap(229, 229, 229))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_Salir_InicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Salir_InicioSesionActionPerformed
        Inicio in = new Inicio();
        in.setVisible(true);
        dispose();
    }//GEN-LAST:event_BTN_Salir_InicioSesionActionPerformed

    private void BTN_Entrar_InicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Entrar_InicioSesionActionPerformed
            String correo2 = Campo_Correo_InicioSesion.getText().trim();
            if(!correo2.contains("@")|| !correo2.contains(".com")){
                JOptionPane.showMessageDialog(null, "CORREO ELECTRONICO INVALIDO, POR FAVOR VERIFICAR");
                Campo_Correo_InicioSesion.requestFocus();
                Campo_Correo_InicioSesion.selectAll();
                return;
            }
        try {
            //String correo = Campo_Correo_InicioSesion.getText();
            String pass = Campo_Contraseña_InicioSesion.getText();
            PreparedStatement in = con.prepareStatement("SELECT * FROM Registro WHERE CORREO_ELECTRONICO = '"+correo2+"' AND CONTRASEÑA = '"+pass+"'");
            ResultSet rs = in.executeQuery();
            if(rs.next()){
                Menu mn = new Menu();
                mn.setVisible(true);
                dispose();
                
            }else{
                JOptionPane.showMessageDialog(null, "CORREO NO REGISTRADO");
                Campo_Correo_InicioSesion.setText("");
                Campo_Contraseña_InicioSesion.setText("");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
    }//GEN-LAST:event_BTN_Entrar_InicioSesionActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio_Sesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Entrar_InicioSesion;
    private javax.swing.JButton BTN_Salir_InicioSesion;
    private javax.swing.JPasswordField Campo_Contraseña_InicioSesion;
    private javax.swing.JTextField Campo_Correo_InicioSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
