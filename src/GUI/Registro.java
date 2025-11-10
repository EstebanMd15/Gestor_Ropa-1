
package GUI;
import Metodos.Placeholder;
import java.sql.*;
import java.sql.Connection;
import gestor_ropa.BD_CONECCTION;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import GUI_ADMIN.Gestion_Usuarios;

public class Registro extends javax.swing.JFrame {
    Connection con = BD_CONECCTION.getInstance().getconectar();
            
    
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
        Combo_Estado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Campo_Correo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Campo_Contraseña = new javax.swing.JPasswordField();
        Campo_Telefono = new javax.swing.JTextField();
        BTN_Salir_Registro = new javax.swing.JButton();
        BTN_Confirmar_Registro = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        Combo_Tipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setText("No :");

        Campo_Identidad.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Identidad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("CORREO ELECTRONICO:");

        Campo_Nombre.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Nombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Campo_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_NombreActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("APELLIDOS:");

        Campo_Apellido.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Apellido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Campo_Apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_ApellidoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("FECHA DE EXPEDICION:");

        Combo_Tipo_Identidad.setBackground(new java.awt.Color(0, 102, 0));
        Combo_Tipo_Identidad.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Combo_Tipo_Identidad.setForeground(new java.awt.Color(255, 255, 255));
        Combo_Tipo_Identidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C.C", "T.I", "C.E" }));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("DIRECCION DE RESIDENCIA:");

        Campo_Direccion.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Direccion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("TIPO DE IDENTIDAD:");

        Campo_Fecha_Expedicion.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Fecha_Expedicion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Campo_Fecha_Expedicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_Fecha_Expedicion(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("BARRIO:");

        Campo_Barrio.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Barrio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("NOMBRES:");

        Combo_Estado.setBackground(new java.awt.Color(0, 102, 0));
        Combo_Estado.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Combo_Estado.setForeground(new java.awt.Color(255, 255, 255));
        Combo_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));
        Combo_Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_EstadoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 30, 30));
        jLabel9.setText("ESTADO:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 30, 30));
        jLabel10.setText("CONTRASEÑA:");

        Campo_Correo.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Correo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 30, 30));
        jLabel11.setText("TELEFONO:");

        Campo_Contraseña.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Contraseña.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        Campo_Telefono.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Telefono.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        BTN_Salir_Registro.setBackground(new java.awt.Color(204, 0, 0));
        BTN_Salir_Registro.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        BTN_Salir_Registro.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Salir_Registro.setText("SALIR");
        BTN_Salir_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Salir_RegistroActionPerformed(evt);
            }
        });

        BTN_Confirmar_Registro.setBackground(new java.awt.Color(0, 102, 0));
        BTN_Confirmar_Registro.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        BTN_Confirmar_Registro.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Confirmar_Registro.setText("CONFIRMAR");
        BTN_Confirmar_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Confirmar_RegistroActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(30, 30, 30));
        jLabel12.setText("ROL:");

        Combo_Tipo.setBackground(new java.awt.Color(0, 102, 0));
        Combo_Tipo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Combo_Tipo.setForeground(new java.awt.Color(255, 255, 255));
        Combo_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "EMPLEADO" }));
        Combo_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_TipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Campo_Barrio, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel7)
                    .addComponent(BTN_Salir_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Campo_Correo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(Campo_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Campo_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(BTN_Confirmar_Registro)
                    .addComponent(Campo_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(55, 55, 55)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Combo_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Combo_Estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Combo_Tipo_Identidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(Campo_Identidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Campo_Fecha_Expedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(Combo_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(Combo_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Campo_Barrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Confirmar_Registro)
                    .addComponent(BTN_Salir_Registro))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_Salir_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Salir_RegistroActionPerformed
        Gestion_Usuarios gu =  new Gestion_Usuarios();
        gu.setVisible(true);
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
            PreparedStatement guardar = con.prepareStatement("INSERT INTO Registro (NOMBRES, APELLIDOS, TIPO_IDENTIDAD, NO_IDENTIDAD, FECHA_EXPEDICION, BARRIO, DIRECCION_RESIDENCIA, TIPO, CORREO_ELECTRONICO, TELEFONO, CONTRASEÑA, ESTADO)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            guardar.setString(1, Campo_Nombre.getText());
            guardar.setString(2, Campo_Apellido.getText());
            guardar.setString(3, Combo_Tipo_Identidad.getSelectedItem().toString());
            guardar.setString(4, Campo_Identidad.getText());
            guardar.setString(5, Campo_Fecha_Expedicion.getText());
            guardar.setString(6, Campo_Barrio.getText());
            guardar.setString(7, Campo_Direccion.getText());
            guardar.setString(8, Combo_Tipo.getSelectedItem().toString());
            guardar.setString(9, correo);
            guardar.setString(10, Campo_Telefono.getText());
            guardar.setString(11, Campo_Contraseña.getText());
            guardar.setString(12, Combo_Estado.getSelectedItem().toString());
           
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

    private void Campo_Fecha_Expedicion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_Fecha_Expedicion
           Placeholder CampoFecha = new Placeholder("AA-DD-MM");
            Campo_Fecha_Expedicion.add(CampoFecha);
            CampoFecha.setVisible(true);
            CampoFecha.add(CampoFecha, BorderLayout.CENTER);
            CampoFecha.setPreferredSize(new Dimension(150, 25));
            
            Campo_Fecha_Expedicion.revalidate();
            Campo_Fecha_Expedicion.repaint();

// TODO add your handling code here:
    }//GEN-LAST:event_Campo_Fecha_Expedicion

    private void Campo_ApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_ApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_ApellidoActionPerformed

    private void Campo_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_NombreActionPerformed

    private void Combo_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_EstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_EstadoActionPerformed

    private void Combo_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_TipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_TipoActionPerformed

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
    public javax.swing.JTextField Campo_Apellido;
    private javax.swing.JTextField Campo_Barrio;
    private javax.swing.JPasswordField Campo_Contraseña;
    public javax.swing.JTextField Campo_Correo;
    private javax.swing.JTextField Campo_Direccion;
    public javax.swing.JTextField Campo_Fecha_Expedicion;
    private javax.swing.JTextField Campo_Identidad;
    public javax.swing.JTextField Campo_Nombre;
    public javax.swing.JTextField Campo_Telefono;
    public javax.swing.JComboBox<String> Combo_Estado;
    public javax.swing.JComboBox<String> Combo_Tipo;
    private javax.swing.JComboBox<String> Combo_Tipo_Identidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
