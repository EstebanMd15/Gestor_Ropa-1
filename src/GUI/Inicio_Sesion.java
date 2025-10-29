package GUI;

import java.sql.*;
import gestor_ropa.BD_CONECCTION;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Inicio_Sesion extends javax.swing.JFrame {

    BD_CONECCTION bd1 = new BD_CONECCTION();
    Connection con = bd1.getconectar();

    public Inicio_Sesion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Campo_Correo_InicioSesion = new javax.swing.JTextField();
        Campo_Contraseña_InicioSesion = new javax.swing.JPasswordField();
        BTN_Salir_InicioSesion = new javax.swing.JButton();
        BTN_Entrar_InicioSesion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CONTRASEÑA");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("INICIO DE SESION");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CORREO ELECTRONICO");

        Campo_Correo_InicioSesion.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Correo_InicioSesion.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        Campo_Correo_InicioSesion.setForeground(new java.awt.Color(0, 0, 0));

        Campo_Contraseña_InicioSesion.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Contraseña_InicioSesion.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        Campo_Contraseña_InicioSesion.setForeground(new java.awt.Color(0, 0, 0));

        BTN_Salir_InicioSesion.setBackground(new java.awt.Color(204, 0, 0));
        BTN_Salir_InicioSesion.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        BTN_Salir_InicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Salir_InicioSesion.setText("SALIR");
        BTN_Salir_InicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Salir_InicioSesionActionPerformed(evt);
            }
        });

        BTN_Entrar_InicioSesion.setBackground(new java.awt.Color(0, 102, 0));
        BTN_Entrar_InicioSesion.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        BTN_Entrar_InicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Entrar_InicioSesion.setText("ENTRAR");
        BTN_Entrar_InicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Entrar_InicioSesionActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Parametrización\\Pictures\\logo ususarui.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1))
                            .addComponent(Campo_Contraseña_InicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BTN_Entrar_InicioSesion)
                                .addGap(102, 102, 102)
                                .addComponent(BTN_Salir_InicioSesion))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Campo_Correo_InicioSesion)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Campo_Correo_InicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Campo_Contraseña_InicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Salir_InicioSesion)
                    .addComponent(BTN_Entrar_InicioSesion))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_Salir_InicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Salir_InicioSesionActionPerformed
        Inicio in = new Inicio();
        in.setVisible(true);
        dispose();
    }//GEN-LAST:event_BTN_Salir_InicioSesionActionPerformed

    private void BTN_Entrar_InicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Entrar_InicioSesionActionPerformed
        try {
            String contraseñaIngresada = new String(Campo_Contraseña_InicioSesion.getPassword());
            String correoIngresado = Campo_Correo_InicioSesion.getText().trim();
            
            if(contraseñaIngresada.isEmpty() || correoIngresado.isEmpty()){
                JOptionPane.showMessageDialog(null, "POR FAVOR, INGRESE CORREO Y CONTRASEÑA");
                Campo_Correo_InicioSesion.requestFocus();
                return;
            }
            if(!correoIngresado.contains("@")|| !correoIngresado.contains(".com")){
                JOptionPane.showMessageDialog(null, "CORREO INVALIDO");
                Campo_Correo_InicioSesion.requestFocus();
                return;
            }
            PreparedStatement entrar = con.prepareStatement("SELECT CONTRASEÑA FROM Registro WHERE CORREO_ELECTRONICO = ?");
            entrar.setString(1, correoIngresado);
            ResultSet rs = entrar.executeQuery();
            
            if(rs.next()){
                String contraseñaValida = rs.getString("CONTRASEÑA");
            
            if(contraseñaValida.equals(contraseñaIngresada)){
                JOptionPane.showMessageDialog(null, "BIENVENIDO");
                Menu mn = new Menu();
                mn.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA");
                Campo_Contraseña_InicioSesion.requestFocus();
            }
            }else{
                JOptionPane.showMessageDialog(null, "CORREO ELECTRONICO NO REGISTRADO");
                Campo_Correo_InicioSesion.requestFocus();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"[ERROR DE CONEXION]: " + e.getMessage());
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
