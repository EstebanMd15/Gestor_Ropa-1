package GUI_ADMIN;

import GUI.*;
import gestor_ropa.BD_CONECCTION;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import javax.swing.JOptionPane;
import GUI.INGRESO;
import GUI.Ventas;
import Metodos_Admin.Metodos_Inventario_admin;

public class Inventario_ADMIN extends javax.swing.JFrame {

    Connection con = BD_CONECCTION.getInstance().getconectar();
    INGRESO in = new INGRESO();
    Ventas vn = new Ventas();
//   Metodos_Inventario mt = new Metodos_Inventario();

    public Inventario_ADMIN() {
        initComponents();
    }

    public void mostrar(String tabla) {
        String sql = "SELECT * FROM " + tabla;

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CODIGO");
        model.addColumn("DESCRIPCION");
        model.addColumn("REFERENCIA");
        model.addColumn("TALLA");
        model.addColumn("CANTIDAD");
        model.addColumn("COSTO");
        model.addColumn("FECHA_INGRESO");
        TablaInventario.setModel(model);

        String[] datos = new String[7];
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
        Campo_CodigoInventario_admin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Campo_DescripcionInventario_admin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Campo_TallaInventario_admin = new javax.swing.JTextField();
        Campo_ReferenciaInventario_admin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Campo_CantidadDispoInven_admin = new javax.swing.JTextField();
        BTN_BuscarCodInven_admin = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Campo_CostoInventario_admin = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Campo_PrecioInventario_admin = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Campo_FechaIngresoInven_admin = new javax.swing.JTextField();
        BTN_MostrarInven_admin = new javax.swing.JButton();
        BTN_LimpiarInven_admin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        BTN_SalirVenta_admin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaInventario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel1.setText("PUNTO DE VENTA NORTE");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("TIENDA DE ROPA");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("TEL:9999-9999");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("CODIGO:");

        Campo_CodigoInventario_admin.setBackground(new java.awt.Color(204, 204, 204));
        Campo_CodigoInventario_admin.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_CodigoInventario_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_CodigoInventario_adminActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("DESCRIPCION:");

        Campo_DescripcionInventario_admin.setEditable(false);
        Campo_DescripcionInventario_admin.setBackground(new java.awt.Color(204, 204, 204));
        Campo_DescripcionInventario_admin.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_DescripcionInventario_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_DescripcionInventario_adminActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("TALLA:");

        Campo_TallaInventario_admin.setEditable(false);
        Campo_TallaInventario_admin.setBackground(new java.awt.Color(204, 204, 204));
        Campo_TallaInventario_admin.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        Campo_ReferenciaInventario_admin.setEditable(false);
        Campo_ReferenciaInventario_admin.setBackground(new java.awt.Color(204, 204, 204));
        Campo_ReferenciaInventario_admin.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("REFERENCIA:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("CANTIDAD DISPONIBLE:");

        Campo_CantidadDispoInven_admin.setEditable(false);
        Campo_CantidadDispoInven_admin.setBackground(new java.awt.Color(204, 204, 204));
        Campo_CantidadDispoInven_admin.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_CantidadDispoInven_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_CantidadDispoInven_adminActionPerformed(evt);
            }
        });

        BTN_BuscarCodInven_admin.setBackground(new java.awt.Color(0, 0, 204));
        BTN_BuscarCodInven_admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_BuscarCodInven_admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_BuscarCodInven_admin.setText("BUSCAR CODIGO");
        BTN_BuscarCodInven_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BuscarCodInven_adminActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("COSTO:");

        Campo_CostoInventario_admin.setEditable(false);
        Campo_CostoInventario_admin.setBackground(new java.awt.Color(204, 204, 204));
        Campo_CostoInventario_admin.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("PRECIO:");

        Campo_PrecioInventario_admin.setEditable(false);
        Campo_PrecioInventario_admin.setBackground(new java.awt.Color(204, 204, 204));
        Campo_PrecioInventario_admin.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setText("FECHA DE INGRESO:");

        Campo_FechaIngresoInven_admin.setEditable(false);
        Campo_FechaIngresoInven_admin.setBackground(new java.awt.Color(204, 204, 204));
        Campo_FechaIngresoInven_admin.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_FechaIngresoInven_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_FechaIngresoInven_adminActionPerformed(evt);
            }
        });

        BTN_MostrarInven_admin.setBackground(new java.awt.Color(0, 0, 204));
        BTN_MostrarInven_admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_MostrarInven_admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_MostrarInven_admin.setText("MOSTRAR INVENTARIO");
        BTN_MostrarInven_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_MostrarInven_adminActionPerformed(evt);
            }
        });

        BTN_LimpiarInven_admin.setBackground(new java.awt.Color(0, 0, 204));
        BTN_LimpiarInven_admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_LimpiarInven_admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_LimpiarInven_admin.setText("LIMPIAR");
        BTN_LimpiarInven_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_LimpiarInven_adminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BTN_BuscarCodInven_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(BTN_MostrarInven_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(BTN_LimpiarInven_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_CantidadDispoInven_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_CodigoInventario_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel9))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Campo_DescripcionInventario_admin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Campo_FechaIngresoInven_admin)
                                .addComponent(Campo_ReferenciaInventario_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Campo_TallaInventario_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Campo_CostoInventario_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Campo_PrecioInventario_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(Campo_PrecioInventario_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(Campo_DescripcionInventario_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(Campo_ReferenciaInventario_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(Campo_FechaIngresoInven_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(Campo_CodigoInventario_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(Campo_TallaInventario_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(Campo_CostoInventario_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BTN_BuscarCodInven_admin)
                        .addComponent(BTN_MostrarInven_admin)
                        .addComponent(BTN_LimpiarInven_admin))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(Campo_CantidadDispoInven_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        BTN_SalirVenta_admin.setBackground(new java.awt.Color(204, 0, 0));
        BTN_SalirVenta_admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_SalirVenta_admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_SalirVenta_admin.setText("SALIR");
        BTN_SalirVenta_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SalirVenta_adminActionPerformed(evt);
            }
        });

        TablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "REFERENCIA", "TALLA", "CANTIDAD", "COSTO", "FECHA_INGRESO"
            }
        ));
        jScrollPane1.setViewportView(TablaInventario);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_SalirVenta_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_SalirVenta_admin)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_SalirVenta_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SalirVenta_adminActionPerformed
        ADMIN mn = new ADMIN();
        mn.setVisible(true);
        dispose();
    }//GEN-LAST:event_BTN_SalirVenta_adminActionPerformed

    private void Campo_CodigoInventario_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_CodigoInventario_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_CodigoInventario_adminActionPerformed

    private void Campo_DescripcionInventario_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_DescripcionInventario_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_DescripcionInventario_adminActionPerformed

    private void Campo_CantidadDispoInven_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_CantidadDispoInven_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_CantidadDispoInven_adminActionPerformed

    private void BTN_BuscarCodInven_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BuscarCodInven_adminActionPerformed
        Metodos_Inventario_admin metodo = new Metodos_Inventario_admin(this);
        metodo.buscarCodigo();
        metodo.cantidadDisponible();
//      metodo.calculo();

    }//GEN-LAST:event_BTN_BuscarCodInven_adminActionPerformed

    private void Campo_FechaIngresoInven_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_FechaIngresoInven_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_FechaIngresoInven_adminActionPerformed

    private void BTN_MostrarInven_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_MostrarInven_adminActionPerformed
        mostrar("Ingresos");

    }//GEN-LAST:event_BTN_MostrarInven_adminActionPerformed

    private void BTN_LimpiarInven_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_LimpiarInven_adminActionPerformed
        Metodos_Inventario_admin mtd = new Metodos_Inventario_admin(this);
        mtd.limpiarCampos();

    }//GEN-LAST:event_BTN_LimpiarInven_adminActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario_ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario_ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario_ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario_ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario_ADMIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_BuscarCodInven_admin;
    public javax.swing.JButton BTN_LimpiarInven_admin;
    public javax.swing.JButton BTN_MostrarInven_admin;
    private javax.swing.JButton BTN_SalirVenta_admin;
    public javax.swing.JTextField Campo_CantidadDispoInven_admin;
    public javax.swing.JTextField Campo_CodigoInventario_admin;
    public javax.swing.JTextField Campo_CostoInventario_admin;
    public javax.swing.JTextField Campo_DescripcionInventario_admin;
    public javax.swing.JTextField Campo_FechaIngresoInven_admin;
    public javax.swing.JTextField Campo_PrecioInventario_admin;
    public javax.swing.JTextField Campo_ReferenciaInventario_admin;
    public javax.swing.JTextField Campo_TallaInventario_admin;
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
