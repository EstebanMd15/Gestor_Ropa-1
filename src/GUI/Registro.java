
package GUI;
import java.sql.*;
import java.sql.Connection;
import gestor_ropa.BD_CONECCTION;
import javax.swing.JOptionPane;

public class Registro extends javax.swing.JFrame {
    BD_CONECCTION bd = new BD_CONECCTION();
    Connection con = bd.conectar();
            
    
    public Registro() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Campo_Identidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Campo_Nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Campo_Apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Combo_Tipo_Identidad = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Campo_Direccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Campo_Fecha_Expedicion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Campo_Barrio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Combo_Tipo_Rh = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Campo_Correo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Campo_Contraseña = new javax.swing.JPasswordField();
        Campo_Telefono = new javax.swing.JTextField();
        BTN_Salir_Registro = new javax.swing.JButton();
        BTN_Confirmar_Registro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("No :");

        Campo_Identidad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("CORREO ELECTRONICO:");

        Campo_Nombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("APELLIDOS:");

        Campo_Apellido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("FECHA DE EXPEDICION:");

        Combo_Tipo_Identidad.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Combo_Tipo_Identidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C.C", "T.I", "C.E" }));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("DIRECCION DE RESIDENCIA:");

        Campo_Direccion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setText("TIPO DE IDENTIDAD:");

        Campo_Fecha_Expedicion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("BARRIO:");

        Campo_Barrio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("NOMBRES:");

        Combo_Tipo_Rh.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Combo_Tipo_Rh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setText("RH:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setText("CONTRASEÑA:");

        Campo_Correo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel11.setText("TELEFONO:");

        Campo_Contraseña.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        Campo_Telefono.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        BTN_Salir_Registro.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        BTN_Salir_Registro.setText("SALIR");
        BTN_Salir_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Salir_RegistroActionPerformed(evt);
            }
        });

        BTN_Confirmar_Registro.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        BTN_Confirmar_Registro.setText("CONFIRMAR");
        BTN_Confirmar_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Confirmar_RegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Combo_Tipo_Rh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(Campo_Barrio, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(Combo_Tipo_Identidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Campo_Identidad))
                                        .addComponent(Campo_Apellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(Campo_Fecha_Expedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Campo_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(Campo_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(230, 230, 230)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BTN_Confirmar_Registro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BTN_Salir_Registro))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Campo_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel2)
                                        .addComponent(Campo_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Campo_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(216, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Campo_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Campo_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Campo_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Campo_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Combo_Tipo_Identidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(Campo_Identidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Campo_Fecha_Expedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Campo_Barrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Campo_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTN_Salir_Registro)
                            .addComponent(BTN_Confirmar_Registro))
                        .addGap(2, 2, 2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Combo_Tipo_Rh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
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

    private void BTN_Salir_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Salir_RegistroActionPerformed
            Inicio in = new Inicio();
            in.setVisible(true);
            dispose();
    }//GEN-LAST:event_BTN_Salir_RegistroActionPerformed

    private void BTN_Confirmar_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Confirmar_RegistroActionPerformed
           //Validacion de correo electronico
        String correo = Campo_Correo.getText().trim();
            if(!correo.contains("@") || !correo.contains(".com")){
                JOptionPane.showMessageDialog(null, "CORREO ELECTRONICO INVALIDO, POR FAVOR VERIFICAR");
                 Campo_Correo.requestFocus();// foco en el campo del correo
                 Campo_Correo.selectAll(); // Selecciona todo el texto para una sobrescritura fácil
               return;// detiene la ejecucion del método
            }
        try {
            //Verificacion si el correo ya existe en la base de datos
            PreparedStatement verificar = con.prepareStatement("SELECT * FROM Registro WHERE CORREO_ELECTRONICO = ?");
            verificar.setString(1, correo);
            ResultSet rs = verificar.executeQuery();
            
            if(rs.next() && rs.getInt(1) >0){
                JOptionPane.showMessageDialog(null, "ESTE CORREO YA SE ENCUENTRA REGISTRADO");
                return;
            }
            //CONTINUAR CON EL REGISTRO SI TODO ESTÁ BIEN
            PreparedStatement guardar = con.prepareStatement("INSERT INTO Registro (NOMBRES, APELLIDOS, TIPO_IDENTIDAD, NO_IDENTIDAD, FECHA_EXPEDICION, BARRIO, DIRECCION_RESIDENCIA, RH, CORREO_ELECTRONICO, TELEFONO, CONTRASEÑA)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            guardar.setString(1, Campo_Nombre.getText());
            guardar.setString(2, Campo_Apellido.getText());
            guardar.setString(3, Combo_Tipo_Identidad.getSelectedItem().toString());
            guardar.setString(4, Campo_Identidad.getText());
            guardar.setString(5, Campo_Fecha_Expedicion.getText());
            guardar.setString(6, Campo_Barrio.getText());
            guardar.setString(7, Campo_Direccion.getText());
            guardar.setString(8, Combo_Tipo_Rh.getSelectedItem().toString());
            guardar.setString(9, correo);
            guardar.setString(10, Campo_Telefono.getText());
            guardar.setString(11, Campo_Contraseña.getText());
           
            int resultado = guardar.executeUpdate();
            
            if(resultado > 0){
                //LIMPIAR CAMPOS SOLO SI EL REGISTRO FUE EXITOSO
            Campo_Apellido.setText("");
            Campo_Barrio.setText("");
            Campo_Contraseña.setText("");
            Campo_Correo.setText("");
            Campo_Direccion.setText("");
            Campo_Fecha_Expedicion.setText("");
            Campo_Identidad.setText("");
            Campo_Nombre.setText("");
            Campo_Telefono.setText("");
            JOptionPane.showMessageDialog(null, "USUARIO REGISTRADO CON EXITO");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e + "\n EL USUARIO NO FUE REGISTRADO");
        }
    }//GEN-LAST:event_BTN_Confirmar_RegistroActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Confirmar_Registro;
    private javax.swing.JButton BTN_Salir_Registro;
    private javax.swing.JTextField Campo_Apellido;
    private javax.swing.JTextField Campo_Barrio;
    private javax.swing.JPasswordField Campo_Contraseña;
    private javax.swing.JTextField Campo_Correo;
    private javax.swing.JTextField Campo_Direccion;
    private javax.swing.JTextField Campo_Fecha_Expedicion;
    private javax.swing.JTextField Campo_Identidad;
    private javax.swing.JTextField Campo_Nombre;
    private javax.swing.JTextField Campo_Telefono;
    private javax.swing.JComboBox<String> Combo_Tipo_Identidad;
    private javax.swing.JComboBox<String> Combo_Tipo_Rh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
