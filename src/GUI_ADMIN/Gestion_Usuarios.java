
package GUI_ADMIN;

import GUI.ADMIN;
import GUI.Registro;
import gestor_ropa.BD_CONECCTION;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

public class Gestion_Usuarios extends javax.swing.JFrame {
private JButton btnBuscar;
    
    public Gestion_Usuarios() {
        initComponents();
    }
    
    public void mostrar(String tabla){
        String sql = "SELECT * FROM " + tabla;
    
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NOMBRES");
        model.addColumn("APELLIDOS");
        model.addColumn("NO_IDENTIDAD");
        model.addColumn("TIPO");
        model.addColumn("CORREO_ELECTRONICO");
        model.addColumn("TELEFONO");
        model.addColumn("CONTRASEÑA");
        model.addColumn("ESTADO");
        Tabla_Gesion_Usuarios.setModel(model);
        
        String[] datos = new String[8];
        try {
            Statement st;
            st = BD_CONECCTION.getInstance().getconectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(8);
                datos[4] = rs.getString(9);
                datos[5] = rs.getString(10);
                datos[6] = rs.getString(11);
                datos[7] = rs.getString(12);
                model.addRow(datos);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"[ERROR]: " +  e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BTN_Listar_GestionU_Admin = new javax.swing.JButton();
        BTN_Modificar_GestionU_Admin = new javax.swing.JButton();
        BTN_CrearU_GestionU_Admin = new javax.swing.JButton();
        Campo_Filtro_GestionU_Admin = new javax.swing.JTextField();
        BTN_Eliminar_GestionU_Admin = new javax.swing.JButton();
        Campo_Identificacion_GestionU_Admin = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        Combo_Estado_GestionU_Admin = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Combo_Rol_GestionU_Admin1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Gesion_Usuarios = new javax.swing.JTable();
        BTN_Salir_GestionU_Admin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel1.setText("PUNTO DE VENTA NORTE");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("TIENDA DE ROPA ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("TEL: 9999-99999");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addGap(347, 347, 347))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        BTN_Listar_GestionU_Admin.setBackground(new java.awt.Color(0, 0, 204));
        BTN_Listar_GestionU_Admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Listar_GestionU_Admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Listar_GestionU_Admin.setText("LISTAR");
        BTN_Listar_GestionU_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Listar_GestionU_AdminActionPerformed(evt);
            }
        });

        BTN_Modificar_GestionU_Admin.setBackground(new java.awt.Color(0, 0, 204));
        BTN_Modificar_GestionU_Admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Modificar_GestionU_Admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Modificar_GestionU_Admin.setText("MODIFICAR");
        BTN_Modificar_GestionU_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Modificar_GestionU_AdminActionPerformed(evt);
            }
        });

        BTN_CrearU_GestionU_Admin.setBackground(new java.awt.Color(0, 0, 204));
        BTN_CrearU_GestionU_Admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_CrearU_GestionU_Admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_CrearU_GestionU_Admin.setText("CREAR");
        BTN_CrearU_GestionU_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CrearU_GestionU_AdminActionPerformed(evt);
            }
        });

        Campo_Filtro_GestionU_Admin.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Filtro_GestionU_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_Filtro_GestionU_AdminActionPerformed(evt);
            }
        });

        BTN_Eliminar_GestionU_Admin.setBackground(new java.awt.Color(0, 0, 204));
        BTN_Eliminar_GestionU_Admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Eliminar_GestionU_Admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Eliminar_GestionU_Admin.setText("ELIMINAR");
        BTN_Eliminar_GestionU_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Eliminar_GestionU_AdminActionPerformed(evt);
            }
        });

        Campo_Identificacion_GestionU_Admin.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Identificacion_GestionU_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_Identificacion_GestionU_AdminActionPerformed(evt);
            }
        });

        Combo_Estado_GestionU_Admin.setBackground(new java.awt.Color(0, 102, 0));
        Combo_Estado_GestionU_Admin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Combo_Estado_GestionU_Admin.setForeground(new java.awt.Color(255, 255, 255));
        Combo_Estado_GestionU_Admin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(NINGUNO)", "ACTIVO", "INACTIVO" }));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("NO IDENTIDAD:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setText("FILTRO GENERAL:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel9.setText("ESTADO:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel10.setText("ROL:");

        Combo_Rol_GestionU_Admin1.setBackground(new java.awt.Color(0, 102, 0));
        Combo_Rol_GestionU_Admin1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Combo_Rol_GestionU_Admin1.setForeground(new java.awt.Color(255, 255, 255));
        Combo_Rol_GestionU_Admin1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(NINGUNO)", "ADMIN", "EMPLEADO" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BTN_CrearU_GestionU_Admin)
                        .addGap(383, 383, 383)
                        .addComponent(BTN_Listar_GestionU_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Campo_Identificacion_GestionU_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(Campo_Filtro_GestionU_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(BTN_Eliminar_GestionU_Admin)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(528, 528, 528)
                                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Combo_Estado_GestionU_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BTN_Modificar_GestionU_Admin)
                                            .addComponent(Combo_Rol_GestionU_Admin1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Campo_Filtro_GestionU_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(Combo_Estado_GestionU_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(Combo_Rol_GestionU_Admin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Campo_Identificacion_GestionU_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_CrearU_GestionU_Admin)
                    .addComponent(BTN_Modificar_GestionU_Admin)
                    .addComponent(BTN_Listar_GestionU_Admin)
                    .addComponent(BTN_Eliminar_GestionU_Admin))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Tabla_Gesion_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "APELLIDOS", "NO IDENTIDAD", "TIPO", "CORREO ELECTRONICO", "TELEFONO", "CONTRASEÑA", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(Tabla_Gesion_Usuarios);

        BTN_Salir_GestionU_Admin.setBackground(new java.awt.Color(204, 0, 0));
        BTN_Salir_GestionU_Admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Salir_GestionU_Admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Salir_GestionU_Admin.setText("SALIR");
        BTN_Salir_GestionU_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Salir_GestionU_AdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_Salir_GestionU_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_Salir_GestionU_Admin)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_Salir_GestionU_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Salir_GestionU_AdminActionPerformed
        ADMIN ad = new ADMIN();
        ad.setVisible(true);
        dispose();
    }//GEN-LAST:event_BTN_Salir_GestionU_AdminActionPerformed

    private void BTN_Listar_GestionU_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Listar_GestionU_AdminActionPerformed
        mostrar("Registro");
    }//GEN-LAST:event_BTN_Listar_GestionU_AdminActionPerformed

    private void BTN_Modificar_GestionU_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Modificar_GestionU_AdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_Modificar_GestionU_AdminActionPerformed

    private void BTN_CrearU_GestionU_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CrearU_GestionU_AdminActionPerformed
        Registro rg =  new Registro();
        rg.setVisible(true);
        dispose();

    }//GEN-LAST:event_BTN_CrearU_GestionU_AdminActionPerformed

    private void Campo_Filtro_GestionU_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_Filtro_GestionU_AdminActionPerformed
        Campo_Filtro_GestionU_Admin.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    
                    btnBuscar.doClick();
                }
                
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });


    }//GEN-LAST:event_Campo_Filtro_GestionU_AdminActionPerformed

    private void BTN_Eliminar_GestionU_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Eliminar_GestionU_AdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_Eliminar_GestionU_AdminActionPerformed

    private void Campo_Identificacion_GestionU_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_Identificacion_GestionU_AdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_Identificacion_GestionU_AdminActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_CrearU_GestionU_Admin;
    public javax.swing.JButton BTN_Eliminar_GestionU_Admin;
    public javax.swing.JButton BTN_Listar_GestionU_Admin;
    public javax.swing.JButton BTN_Modificar_GestionU_Admin;
    public javax.swing.JButton BTN_Salir_GestionU_Admin;
    public javax.swing.JTextField Campo_Filtro_GestionU_Admin;
    public javax.swing.JTextField Campo_Identificacion_GestionU_Admin;
    private javax.swing.JComboBox<String> Combo_Estado_GestionU_Admin;
    private javax.swing.JComboBox<String> Combo_Rol_GestionU_Admin1;
    public javax.swing.JTable Tabla_Gesion_Usuarios;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
