package GUI;

import Metodos.Metodos_Inventario;
import gestor_ropa.BD_CONECCTION;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Metodos.Metodos_Ingresos;

public class INGRESO extends javax.swing.JFrame {

    BD_CONECCTION bd = new BD_CONECCTION();
    Connection con = bd.conectar();

    public INGRESO() {
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
        Tabla_Ingreso.setModel(model);

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
        Campo_Referencia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Campo_Talla = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Campo_Codigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Campo_Cantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Campo_Costo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Campo_Descripcion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Campo_Observacion = new javax.swing.JTextField();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Buscar = new javax.swing.JButton();
        BTN_Limpiar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_Mostrar_Tabla = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Ingreso = new javax.swing.JTable();
        BTN_Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PUNTO DE VENTA NORTE");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("TIENDA DE ROPA ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
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
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("CANTIDAD:");

        Campo_Referencia.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("COSTO:");

        Campo_Talla.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CODIGO:");

        Campo_Codigo.setBackground(new java.awt.Color(204, 204, 204));
        Campo_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_CodigoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("TALLA:");

        Campo_Cantidad.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("DESCRIPCION:");

        Campo_Costo.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("OBSERVACION:");

        Campo_Descripcion.setBackground(new java.awt.Color(204, 204, 204));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("REFERENCIA:");

        Campo_Observacion.setBackground(new java.awt.Color(204, 204, 204));

        BTN_Guardar.setBackground(new java.awt.Color(0, 0, 0));
        BTN_Guardar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Guardar.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Guardar.setText("GUARDAR");
        BTN_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GuardarActionPerformed(evt);
            }
        });

        BTN_Buscar.setBackground(new java.awt.Color(0, 0, 0));
        BTN_Buscar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Buscar.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Buscar.setText("BUSCAR");
        BTN_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BuscarActionPerformed(evt);
            }
        });

        BTN_Limpiar.setBackground(new java.awt.Color(0, 0, 0));
        BTN_Limpiar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Limpiar.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Limpiar.setText("LIMPIAR");
        BTN_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_LimpiarActionPerformed(evt);
            }
        });

        BTN_Modificar.setBackground(new java.awt.Color(0, 0, 0));
        BTN_Modificar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Modificar.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Modificar.setText("MODIFICAR");
        BTN_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarActionPerformed(evt);
            }
        });

        BTN_Mostrar_Tabla.setBackground(new java.awt.Color(0, 0, 0));
        BTN_Mostrar_Tabla.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Mostrar_Tabla.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Mostrar_Tabla.setText("MOSTRAR");
        BTN_Mostrar_Tabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Mostrar_TablaActionPerformed(evt);
            }
        });

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
                                    .addComponent(Campo_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(38, 38, 38)
                                    .addComponent(Campo_Talla, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Campo_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Campo_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(56, 56, 56))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BTN_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(BTN_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(Campo_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Campo_Referencia, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTN_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Campo_Observacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(BTN_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(BTN_Mostrar_Tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Campo_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Campo_Talla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Campo_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Campo_Referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Campo_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(Campo_Observacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Campo_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Guardar)
                    .addComponent(BTN_Buscar)
                    .addComponent(BTN_Limpiar)
                    .addComponent(BTN_Modificar)
                    .addComponent(BTN_Mostrar_Tabla))
                .addGap(22, 22, 22))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jScrollPane1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        Tabla_Ingreso.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Tabla_Ingreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "REFERENCIA", "TALLA", "CANTIDAD", "COSTO", "FECHA INGRESO", "OBSERVACION"
            }
        ));
        jScrollPane1.setViewportView(Tabla_Ingreso);

        BTN_Salir.setBackground(new java.awt.Color(0, 0, 0));
        BTN_Salir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_Salir.setForeground(new java.awt.Color(255, 255, 255));
        BTN_Salir.setText("SALIR");
        BTN_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTN_Salir)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Campo_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_CodigoActionPerformed

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed
        Metodos_Ingresos mt = new Metodos_Ingresos(this);
        mt.guardar();

//            int cantIngreso = Integer.parseInt(Campo_Cantidad.getText().trim());
//        try {
//            PreparedStatement guardar = con.prepareStatement("INSERT INTO Ingresos (CODIGO, DESCRIPCION, REFERENCIA,TALLA, CANTIDAD, COSTO, FECHA_INGRESO, OBSERVACION) VALUES (?,?,?,?,?,?,?,?)");
//            guardar.setString(1, Campo_Codigo.getText());
//            guardar.setString(2, Campo_Descripcion.getText());
//            guardar.setString(3, Campo_Referencia.getText());
//            guardar.setString(4, Campo_Talla.getText());
//            guardar.setInt(5,cantIngreso);
//            guardar.setString(6, Campo_Costo.getText());
//            java.sql.Date fechaActual = new java.sql.Date(System.currentTimeMillis());
//            guardar.setString(7, fechaActual.toString());
//            guardar.setString(8, Campo_Observacion.getText());
//            //LIMPIAR CAMPOS
//            Campo_Cantidad.setText("");
//            Campo_Codigo.setText("");
//            Campo_Costo.setText("");
//            Campo_Descripcion.setText("");
//            Campo_Observacion.setText("");
//            Campo_Referencia.setText("");
//            Campo_Talla.setText("");
//            guardar.executeUpdate();// EJECUTA SENTENCIAS SQL QUE MODIFIQUEN DATOS COMO INSERT, DELETE, UPDATE
//            JOptionPane.showMessageDialog(null, "REGISTRADO");
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "[ERROR]: " + e);
//        }
        mostrar("Ingresos");
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SalirActionPerformed
        Menu mn = new Menu();
        mn.setVisible(true);
        dispose();
    }//GEN-LAST:event_BTN_SalirActionPerformed

    private void BTN_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BuscarActionPerformed
        Metodos_Ingresos mt = new Metodos_Ingresos(this);
        mt.buscar();

//        try {
//            PreparedStatement buscar = con.prepareStatement("SELECT * FROM Ingresos WHERE CODIGO = ?");
//            buscar.setString(1, Campo_Codigo.getText());
//            ResultSet rs = buscar.executeQuery();
//            if (rs.next()) {
//                Campo_Cantidad.setText(rs.getString("CANTIDAD"));
//                Campo_Codigo.setText(rs.getString("CODIGO"));
//                Campo_Costo.setText(rs.getString("COSTO"));
//                Campo_Descripcion.setText(rs.getString("DESCRIPCION"));
//                Campo_Observacion.setText(rs.getString("OBSERVACION"));
//                Campo_Referencia.setText(rs.getString("REFERENCIA"));
//                Campo_Talla.setText(rs.getString("TALLA"));
//
//            } else {
//                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGUN REGISTRO CON ESE CODIGO");
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "[ERROR]: " + e);
//        }
    }//GEN-LAST:event_BTN_BuscarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
        Metodos_Ingresos mt = new Metodos_Ingresos(this);
        mt.modificar();

//        try {
//            PreparedStatement modificar = con.prepareStatement("UPDATE Ingresos SET DESCRIPCION=?, REFERENCIA=?,TALLA=?, CANTIDAD=?, COSTO=?, OBSERVACION=? WHERE CODIGO =?");
//            modificar.setString(1, Campo_Descripcion.getText());
//            modificar.setString(2, Campo_Referencia.getText());
//            modificar.setString(3, Campo_Talla.getText());
//            modificar.setString(4, Campo_Cantidad.getText());
//            modificar.setString(5, Campo_Costo.getText());
//            modificar.setString(6, Campo_Observacion.getText());
//            modificar.setString(7, Campo_Codigo.getText());
//            int modificar2 = JOptionPane.showConfirmDialog(null, "DESEA MODIFICAR EL INGRESO ?");
//            if(modificar2 == 0){
//                int filas = modificar.executeUpdate();
//            if(filas != 0){
//                modificar.executeUpdate();
//            Campo_Cantidad.setText("");
//            Campo_Codigo.setText("");
//            Campo_Costo.setText("");
//            Campo_Descripcion.setText("");
//            Campo_Observacion.setText("");
//            Campo_Referencia.setText("");
//            Campo_Talla.setText("");
//            }
//                JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO CON EXITO!!");
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "[ERROR]: " + e);
//        }
        mostrar("Ingresos");
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_LimpiarActionPerformed
            Metodos_Ingresos mt = new Metodos_Ingresos(this);
            mt.limpiar();

//        Campo_Cantidad.setText("");
//        Campo_Codigo.setText("");
//        Campo_Costo.setText("");
//        Campo_Descripcion.setText("");
//        Campo_Observacion.setText("");
//        Campo_Referencia.setText("");
//        Campo_Talla.setText("");

    }//GEN-LAST:event_BTN_LimpiarActionPerformed

    private void BTN_Mostrar_TablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Mostrar_TablaActionPerformed
        mostrar("Ingresos");
    }//GEN-LAST:event_BTN_Mostrar_TablaActionPerformed

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
            java.util.logging.Logger.getLogger(INGRESO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INGRESO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INGRESO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INGRESO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INGRESO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_Buscar;
    public javax.swing.JButton BTN_Guardar;
    public javax.swing.JButton BTN_Limpiar;
    public javax.swing.JButton BTN_Modificar;
    public javax.swing.JButton BTN_Mostrar_Tabla;
    public javax.swing.JButton BTN_Salir;
    public javax.swing.JTextField Campo_Cantidad;
    public javax.swing.JTextField Campo_Codigo;
    public javax.swing.JTextField Campo_Costo;
    public javax.swing.JTextField Campo_Descripcion;
    public javax.swing.JTextField Campo_Observacion;
    public javax.swing.JTextField Campo_Referencia;
    public javax.swing.JTextField Campo_Talla;
    private javax.swing.JTable Tabla_Ingreso;
    private javax.swing.JLabel jLabel1;
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
