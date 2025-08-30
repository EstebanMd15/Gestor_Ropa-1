package GUI;

import gestor_ropa.BD_CONECCTION;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import javax.swing.JOptionPane;
import GUI.INGRESO;
import GUI.Ventas;
import Metodos.Metodos_Inventario;

public class Inventario extends javax.swing.JFrame {

    BD_CONECCTION bd = new BD_CONECCTION();
    Connection con = bd.conectar();
    INGRESO in = new INGRESO();
    Ventas vn = new Ventas();
//   Metodos_Inventario mt = new Metodos_Inventario();

    public Inventario() {
        initComponents();
    }

    public void mostrar(String tabla) {
        String sql = "SELECT * FROM " + tabla;

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CODIGO");
        model.addColumn("DESCRIPCION");
        model.addColumn("TALLA");
        model.addColumn("REFERENCIA");
        model.addColumn("TALLA");
        model.addColumn("CANTIDAD");
        model.addColumn("COSTO");
        model.addColumn("FECHA_INGRESO");
        TablaInventario.setModel(model);

        String[] datos = new String[8];
        try {
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }

    public void cantidadDisponible() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Campo_CodigoInventario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Campo_DescripcionInventario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Campo_TallaInventario = new javax.swing.JTextField();
        Campo_ReferenciaInventario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Campo_CantidadDispoInven = new javax.swing.JTextField();
        BTN_BuscarCodInven = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Campo_CostoInventario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Campo_PrecioInventario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Campo_FechaIngresoInven = new javax.swing.JTextField();
        BTN_MostrarInven = new javax.swing.JButton();
        BTN_LimpiarInven = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        BTN_SalirVenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaInventario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel1.setText("PUNTO DE VENTA NORTE");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("TIENDA DE ROPA");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("TEL:9999-9999");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(483, 483, 483)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(547, 547, 547)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(jLabel3)))
                .addContainerGap(496, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("CODIGO:");

        Campo_CodigoInventario.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_CodigoInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_CodigoInventarioActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("DESCRIPCION:");

        Campo_DescripcionInventario.setEditable(false);
        Campo_DescripcionInventario.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_DescripcionInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_DescripcionInventarioActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("TALLA:");

        Campo_TallaInventario.setEditable(false);
        Campo_TallaInventario.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        Campo_ReferenciaInventario.setEditable(false);
        Campo_ReferenciaInventario.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("REFERENCIA:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("CANTIDAD DISPONIBLE:");

        Campo_CantidadDispoInven.setEditable(false);
        Campo_CantidadDispoInven.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_CantidadDispoInven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_CantidadDispoInvenActionPerformed(evt);
            }
        });

        BTN_BuscarCodInven.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_BuscarCodInven.setText("BUSCAR CODIGO");
        BTN_BuscarCodInven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BuscarCodInvenActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("COSTO:");

        Campo_CostoInventario.setEditable(false);
        Campo_CostoInventario.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("PRECIO:");

        Campo_PrecioInventario.setEditable(false);
        Campo_PrecioInventario.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setText("FECHA DE INGRESO:");

        Campo_FechaIngresoInven.setEditable(false);
        Campo_FechaIngresoInven.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_FechaIngresoInven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_FechaIngresoInvenActionPerformed(evt);
            }
        });

        BTN_MostrarInven.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_MostrarInven.setText("MOSTRAR INVENTARIO");
        BTN_MostrarInven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_MostrarInvenActionPerformed(evt);
            }
        });

        BTN_LimpiarInven.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_LimpiarInven.setText("LIMPIAR");
        BTN_LimpiarInven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_LimpiarInvenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(BTN_BuscarCodInven, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(BTN_MostrarInven, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(BTN_LimpiarInven, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_CantidadDispoInven, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Campo_CodigoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(195, 195, 195)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Campo_DescripcionInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Campo_TallaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Campo_FechaIngresoInven)
                                    .addComponent(Campo_ReferenciaInventario, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                                .addGap(168, 168, 168)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Campo_CostoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Campo_PrecioInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Campo_CodigoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(Campo_DescripcionInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(Campo_TallaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Campo_ReferenciaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(Campo_CostoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(Campo_FechaIngresoInven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(Campo_PrecioInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_BuscarCodInven)
                    .addComponent(jLabel12)
                    .addComponent(Campo_CantidadDispoInven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_MostrarInven)
                    .addComponent(BTN_LimpiarInven))
                .addGap(31, 31, 31))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        BTN_SalirVenta.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_SalirVenta.setText("SALIR");
        BTN_SalirVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SalirVentaActionPerformed(evt);
            }
        });

        TablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "TALLA", "REFERENCIA", "CANTIDAD", "COSTO", "PRECIO", "FECHA DE INGRESO"
            }
        ));
        jScrollPane1.setViewportView(TablaInventario);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_SalirVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1151, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_SalirVenta)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_SalirVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SalirVentaActionPerformed
        Menu mn = new Menu();
        mn.setVisible(true);
        dispose();
    }//GEN-LAST:event_BTN_SalirVentaActionPerformed

    private void Campo_CodigoInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_CodigoInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_CodigoInventarioActionPerformed

    private void Campo_DescripcionInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_DescripcionInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_DescripcionInventarioActionPerformed

    private void Campo_CantidadDispoInvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_CantidadDispoInvenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_CantidadDispoInvenActionPerformed

    private void BTN_BuscarCodInvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BuscarCodInvenActionPerformed
        Metodos_Inventario metodo = new Metodos_Inventario(this);
        metodo.buscarCodigo();
        metodo.cantidadDisponible();
//        try {
//            PreparedStatement buscar = con.prepareStatement("SELECT * FROM Ingresos WHERE CODIGO = ?");
//            buscar.setString(1, Campo_CodigoInventario.getText());
//            ResultSet rs = buscar.executeQuery();
//            if (rs.next()) {
//                Campo_CostoInventario.setText(rs.getString("COSTO"));
//                Campo_DescripcionInventario.setText(rs.getString("DESCRIPCION"));
//                Campo_FechaIngresoInven.setText(rs.getString("FECHA_INGRESO"));
//                Campo_ReferenciaInventario.setText(rs.getString("REFERENCIA"));
//                Campo_TallaInventario.setText(rs.getString("TALLA"));
//                
//               // Campo_CantidadDispoInven.setText(String.valueOf(disponible));//PERMITE CAMBIAR TIPO DE DATOS A CADENA DE TEXTO
//            } else {
//                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGUN REGISTRO CON ESE CODIGO");
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
//        }

    }//GEN-LAST:event_BTN_BuscarCodInvenActionPerformed

    private void Campo_FechaIngresoInvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_FechaIngresoInvenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_FechaIngresoInvenActionPerformed

    private void BTN_MostrarInvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_MostrarInvenActionPerformed
            mostrar("Ingresos");
        
    }//GEN-LAST:event_BTN_MostrarInvenActionPerformed

    private void BTN_LimpiarInvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_LimpiarInvenActionPerformed
            Metodos_Inventario mtd = new Metodos_Inventario(this);
            mtd.limpiarCampos();
//        Campo_CantidadDispoInven.setText("");
//        Campo_CodigoInventario.setText("");
//        Campo_CostoInventario.setText("");
//        Campo_DescripcionInventario.setText("");
//        Campo_FechaIngresoInven.setText("");
//        Campo_PrecioInventario.setText("");
//        Campo_ReferenciaInventario.setText("");
//        Campo_TallaInventario.setText("");

    }//GEN-LAST:event_BTN_LimpiarInvenActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_BuscarCodInven;
    public javax.swing.JButton BTN_LimpiarInven;
    public javax.swing.JButton BTN_MostrarInven;
    private javax.swing.JButton BTN_SalirVenta;
    public javax.swing.JTextField Campo_CantidadDispoInven;
    public javax.swing.JTextField Campo_CodigoInventario;
    public javax.swing.JTextField Campo_CostoInventario;
    public javax.swing.JTextField Campo_DescripcionInventario;
    public javax.swing.JTextField Campo_FechaIngresoInven;
    public javax.swing.JTextField Campo_PrecioInventario;
    public javax.swing.JTextField Campo_ReferenciaInventario;
    public javax.swing.JTextField Campo_TallaInventario;
    private javax.swing.JTable TablaInventario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
