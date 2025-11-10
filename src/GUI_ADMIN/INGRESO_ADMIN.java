package GUI_ADMIN;

import GUI.*;
import gestor_ropa.BD_CONECCTION;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Metodos_Admin.Metodos_Ingresos_admin;

public class INGRESO_ADMIN extends javax.swing.JFrame {

    public INGRESO_ADMIN() {
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
        model.addColumn("OBSERVACION");
        model.addColumn("PRECIO");
        Tabla_Ingresos.setModel(model);

        String[] datos = new String[9];
        try {
            Statement st;
            st = BD_CONECCTION.getInstance().getconectar().createStatement();
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
                datos[8] = rs.getString(9);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Campo_Referencia_admin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Campo_Talla_admin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Campo_Codigo_admin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Campo_Cantidad_admin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Campo_Costo_admin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Campo_Descripcion_admin = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Campo_Observacion_admin = new javax.swing.JTextField();
        BTN_Guardar_admin = new javax.swing.JButton();
        BTN_Buscar_admin = new javax.swing.JButton();
        BTN_Limpiar_admin = new javax.swing.JButton();
        BTN_Modificar_admin = new javax.swing.JButton();
        BTN_Mostrar_Tabla_admin = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        Campo_PrecioVenta_admin = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Ingresos = new javax.swing.JTable();
        BTN_Salir_admin = new javax.swing.JButton();
        BTN_EliminarRegistros_admin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel1.setText("PUNTO DE VENTA NORTE");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("TIENDA DE ROPA ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("TEL: 9999-99999");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setText("CANTIDAD:");

        Campo_Referencia_admin.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setText("COSTO:");

        Campo_Talla_admin.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("CODIGO:");

        Campo_Codigo_admin.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Codigo_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_Codigo_adminActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setText("TALLA:");

        Campo_Cantidad_admin.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel9.setText("DESCRIPCION:");

        Campo_Costo_admin.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel11.setText("OBSERVACION:");

        Campo_Descripcion_admin.setBackground(new java.awt.Color(204, 204, 204));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel12.setText("REFERENCIA:");

        Campo_Observacion_admin.setBackground(new java.awt.Color(204, 204, 204));

        BTN_Guardar_admin.setBackground(new java.awt.Color(0, 0, 204));
        BTN_Guardar_admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Guardar_admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Guardar_admin.setText("GUARDAR");
        BTN_Guardar_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Guardar_adminActionPerformed(evt);
            }
        });

        BTN_Buscar_admin.setBackground(new java.awt.Color(0, 0, 204));
        BTN_Buscar_admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Buscar_admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Buscar_admin.setText("BUSCAR");
        BTN_Buscar_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Buscar_adminActionPerformed(evt);
            }
        });

        BTN_Limpiar_admin.setBackground(new java.awt.Color(0, 0, 204));
        BTN_Limpiar_admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Limpiar_admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Limpiar_admin.setText("LIMPIAR");
        BTN_Limpiar_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Limpiar_adminActionPerformed(evt);
            }
        });

        BTN_Modificar_admin.setBackground(new java.awt.Color(0, 0, 204));
        BTN_Modificar_admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Modificar_admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Modificar_admin.setText("MODIFICAR");
        BTN_Modificar_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Modificar_adminActionPerformed(evt);
            }
        });

        BTN_Mostrar_Tabla_admin.setBackground(new java.awt.Color(0, 0, 204));
        BTN_Mostrar_Tabla_admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Mostrar_Tabla_admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Mostrar_Tabla_admin.setText("MOSTRAR");
        BTN_Mostrar_Tabla_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Mostrar_Tabla_adminActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel10.setText("PRECIO DE VENTA:");

        Campo_PrecioVenta_admin.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Campo_Codigo_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(38, 38, 38)
                                    .addComponent(Campo_Talla_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Campo_Cantidad_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Campo_Costo_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BTN_Guardar_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_Modificar_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(53, 53, 53)
                        .addComponent(Campo_Descripcion_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Campo_Referencia_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel11)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(BTN_Buscar_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Campo_Observacion_admin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(Campo_PrecioVenta_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(77, 77, 77))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(BTN_Limpiar_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(65, 65, 65)))
                                    .addComponent(BTN_Mostrar_Tabla_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Campo_Codigo_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Campo_Talla_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Campo_Descripcion_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Campo_Referencia_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Campo_Cantidad_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_Observacion_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Campo_Costo_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_PrecioVenta_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Guardar_admin)
                    .addComponent(BTN_Buscar_admin)
                    .addComponent(BTN_Limpiar_admin)
                    .addComponent(BTN_Modificar_admin)
                    .addComponent(BTN_Mostrar_Tabla_admin))
                .addGap(22, 22, 22))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jScrollPane1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        Tabla_Ingresos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Tabla_Ingresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "REFERENCIA", "TALLA", "CANTIDAD", "COSTO", "FECHA_INGRESO", "OBSERVACION", "PRECIO"
            }
        ));
        jScrollPane1.setViewportView(Tabla_Ingresos);

        BTN_Salir_admin.setBackground(new java.awt.Color(204, 0, 0));
        BTN_Salir_admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Salir_admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Salir_admin.setText("SALIR");
        BTN_Salir_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Salir_adminActionPerformed(evt);
            }
        });

        BTN_EliminarRegistros_admin.setBackground(new java.awt.Color(204, 0, 0));
        BTN_EliminarRegistros_admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_EliminarRegistros_admin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_EliminarRegistros_admin.setText("ELIMINA REGISTROS");
        BTN_EliminarRegistros_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EliminarRegistros_adminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(BTN_Salir_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_EliminarRegistros_admin)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Salir_admin)
                    .addComponent(BTN_EliminarRegistros_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Campo_Codigo_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_Codigo_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_Codigo_adminActionPerformed

    private void BTN_Guardar_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Guardar_adminActionPerformed
        Metodos_Ingresos_admin mt = new Metodos_Ingresos_admin(this);
        mt.guardar();
        mostrar("Ingresos");
    }//GEN-LAST:event_BTN_Guardar_adminActionPerformed

    private void BTN_Salir_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Salir_adminActionPerformed
        ADMIN mn = new ADMIN();
        mn.setVisible(true);
        dispose();
    }//GEN-LAST:event_BTN_Salir_adminActionPerformed

    private void BTN_Buscar_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Buscar_adminActionPerformed
        Metodos_Ingresos_admin mt = new Metodos_Ingresos_admin(this);
        mt.buscar();
    }//GEN-LAST:event_BTN_Buscar_adminActionPerformed

    private void BTN_Modificar_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Modificar_adminActionPerformed
        Metodos_Ingresos_admin mt = new Metodos_Ingresos_admin(this);
        mt.modificar();
        mostrar("Ingresos");
    }//GEN-LAST:event_BTN_Modificar_adminActionPerformed

    private void BTN_Limpiar_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Limpiar_adminActionPerformed
        Metodos_Ingresos_admin mt = new Metodos_Ingresos_admin(this);
        mt.limpiar();

    }//GEN-LAST:event_BTN_Limpiar_adminActionPerformed

    private void BTN_Mostrar_Tabla_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Mostrar_Tabla_adminActionPerformed
        mostrar("Ingresos");
    }//GEN-LAST:event_BTN_Mostrar_Tabla_adminActionPerformed

    private void BTN_EliminarRegistros_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EliminarRegistros_adminActionPerformed
        Metodos_Ingresos_admin mt = new Metodos_Ingresos_admin(this);
        String[] TabasOrden = {
            "VENTAS", "INGRESOS"
        };
        mostrar("Ingresos");
        mt.eliminarRegistros(TabasOrden);
    }//GEN-LAST:event_BTN_EliminarRegistros_adminActionPerformed

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
            java.util.logging.Logger.getLogger(INGRESO_ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INGRESO_ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INGRESO_ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INGRESO_ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INGRESO_ADMIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_Buscar_admin;
    private javax.swing.JButton BTN_EliminarRegistros_admin;
    public javax.swing.JButton BTN_Guardar_admin;
    public javax.swing.JButton BTN_Limpiar_admin;
    public javax.swing.JButton BTN_Modificar_admin;
    public javax.swing.JButton BTN_Mostrar_Tabla_admin;
    public javax.swing.JButton BTN_Salir_admin;
    public javax.swing.JTextField Campo_Cantidad_admin;
    public javax.swing.JTextField Campo_Codigo_admin;
    public javax.swing.JTextField Campo_Costo_admin;
    public javax.swing.JTextField Campo_Descripcion_admin;
    public javax.swing.JTextField Campo_Observacion_admin;
    public javax.swing.JTextField Campo_PrecioVenta_admin;
    public javax.swing.JTextField Campo_Referencia_admin;
    public javax.swing.JTextField Campo_Talla_admin;
    public javax.swing.JTable Tabla_Ingresos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
