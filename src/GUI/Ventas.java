package GUI;

import GUI.INGRESO;
import Metodos.Metodos_Ventas;
import com.mysql.cj.xdevapi.Result;
import gestor_ropa.BD_CONECCTION;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ventas extends javax.swing.JFrame {

    BD_CONECCTION bd = new BD_CONECCTION();
    Connection con = bd.conectar();
    INGRESO in = new INGRESO();

    public Ventas() {
        initComponents();
    }

    public void mostrar(String tabla) {
        String sql = "SELECT * FROM " + tabla;

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CODIGO");
        model.addColumn("DESCRIPCION");
        model.addColumn("TALLA");
        model.addColumn("REFERENCIA");
        model.addColumn("COSTO");
        model.addColumn("CANTIDAD");
        model.addColumn("VALOR_TOTAL");
        Tabla_Ventas.setModel(model);

        String[] datos = new String[7];
        try {
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);//CODIGO
                datos[1] = rs.getString(2);//DESCRIPCION
                datos[2] = rs.getString(3);//TALLA
                datos[3] = rs.getString(4);//REFERENCIA
                datos[4] = rs.getString(5);//REFERENCIA
                datos[5] = rs.getString(6);//REFERENCIA

                try {
                    double costo = Double.parseDouble(datos[4]);
                    int cantidad = Integer.parseInt(datos[5]);
                    datos[6] = String.valueOf(costo * cantidad);
                } catch (NumberFormatException e) {
                    datos[6] = "0";// valor pro defecto si hay error
                }

                model.addRow(datos);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR AL CARGAR LOS DATOS]: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "[ERROR EN FORMATO DE NUMEROS]: " + e.getMessage());
        }
    }

    public void costoTotal() {
        try {
            //VERIRICAR QUE LOS CAMPOS NO ESTÉN VACIOS
            if (in.Campo_Costo.getText().trim().isEmpty() || Campo_CantidadVenta.getText().trim().isEmpty()) {
                return;
            }

            //OBTENER VALORES DE LOS CAMPOS
            double costo = Double.parseDouble(in.Campo_Costo.getText());
            int cantidad = Integer.parseInt(Campo_CantidadVenta.getText());
            double total2 = costo * cantidad;

            //OBTENER EL MODELO DE LA TABLA
            DefaultTableModel model = (DefaultTableModel) Tabla_Ventas.getModel();

            //OBTENER FILA SELECCIONADA
            int filaSelec = Tabla_Ventas.getSelectedRow();

            if (filaSelec >= 0) {
                //ACTUALIZAR EL VALOR TOTAL EN LA TABLA
                model.setValueAt(total2, filaSelec, 6);
            } else {
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA PARA ACTUALIZAR EL VALOR TOTAL");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "[AQUI]: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Campo_DescripcionVenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Campo_CostoVenta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Campo_TallaVenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        BTN_BuscarVenta = new javax.swing.JButton();
        BTN_LimpiarVenta = new javax.swing.JButton();
        BTN_VenderVenta = new javax.swing.JButton();
        BTN_SalirVenta = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Campo_TotalVenta = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Campo_ReferenciaVenta = new javax.swing.JTextField();
        BTN_CancelarVenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Ventas = new javax.swing.JTable();
        BTN_AgregarVenta = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        Campo_CantidadVenta = new javax.swing.JTextField();
        Campo_CodigoVenta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Campo_CantDispo = new javax.swing.JTextField();

        popupMenu1.setLabel("popupMenu1");

        jLabel5.setText("jLabel5");

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PUNTO DE VENTA NORTE");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("TIENDA DE ROPA");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("TEL:9999-9999");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel3)))
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DESCRIPCION:");

        Campo_DescripcionVenta.setEditable(false);
        Campo_DescripcionVenta.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_DescripcionVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_DescripcionVentaActionPerformed(evt);
            }
        });

        Campo_CostoVenta.setEditable(false);
        Campo_CostoVenta.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_CostoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_CostoVentaActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("TOTAL:");

        Campo_TallaVenta.setEditable(false);
        Campo_TallaVenta.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("CANTIDAD DISPONIBLE:");

        BTN_BuscarVenta.setBackground(new java.awt.Color(0, 0, 0));
        BTN_BuscarVenta.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_BuscarVenta.setForeground(new java.awt.Color(255, 255, 255));
        BTN_BuscarVenta.setText("BUSCAR");
        BTN_BuscarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BuscarVentaActionPerformed(evt);
            }
        });

        BTN_LimpiarVenta.setBackground(new java.awt.Color(0, 0, 0));
        BTN_LimpiarVenta.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_LimpiarVenta.setForeground(new java.awt.Color(255, 255, 255));
        BTN_LimpiarVenta.setText("LIMPIAR");
        BTN_LimpiarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_LimpiarVentaActionPerformed(evt);
            }
        });

        BTN_VenderVenta.setBackground(new java.awt.Color(0, 0, 0));
        BTN_VenderVenta.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_VenderVenta.setForeground(new java.awt.Color(255, 255, 255));
        BTN_VenderVenta.setText("VENDER");
        BTN_VenderVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VenderVentaActionPerformed(evt);
            }
        });

        BTN_SalirVenta.setBackground(new java.awt.Color(0, 0, 0));
        BTN_SalirVenta.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_SalirVenta.setForeground(new java.awt.Color(255, 255, 255));
        BTN_SalirVenta.setText("SALIR");
        BTN_SalirVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SalirVentaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("REFERENCIA:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("TALLA:");

        Campo_TotalVenta.setEditable(false);
        Campo_TotalVenta.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_TotalVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_TotalVentaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("COSTO:");

        Campo_ReferenciaVenta.setEditable(false);
        Campo_ReferenciaVenta.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        BTN_CancelarVenta.setBackground(new java.awt.Color(0, 0, 0));
        BTN_CancelarVenta.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_CancelarVenta.setForeground(new java.awt.Color(255, 255, 255));
        BTN_CancelarVenta.setText("CANCELAR");
        BTN_CancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CancelarVentaActionPerformed(evt);
            }
        });

        Tabla_Ventas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Tabla_Ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "TALLA", "REFERENCIA", "COSTO", "CANTIDAD", "VALOR TOTAL"
            }
        ));
        jScrollPane1.setViewportView(Tabla_Ventas);

        BTN_AgregarVenta.setBackground(new java.awt.Color(0, 0, 0));
        BTN_AgregarVenta.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_AgregarVenta.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AgregarVenta.setText("AGREGAR");
        BTN_AgregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AgregarVentaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("CANTIDAD:");

        Campo_CantidadVenta.setBackground(new java.awt.Color(204, 204, 204));
        Campo_CantidadVenta.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_CantidadVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_CantidadVentaActionPerformed(evt);
            }
        });

        Campo_CodigoVenta.setBackground(new java.awt.Color(204, 204, 204));
        Campo_CodigoVenta.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_CodigoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_CodigoVentaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("CODIGO:");

        Campo_CantDispo.setEditable(false);
        Campo_CantDispo.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_CantDispo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_CantDispoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(BTN_LimpiarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(Campo_CantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Campo_CodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(59, 59, 59))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Campo_CostoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(125, 125, 125)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Campo_DescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Campo_TallaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Campo_ReferenciaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(BTN_CancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BTN_AgregarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(82, 82, 82))))
                            .addComponent(BTN_BuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(BTN_VenderVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BTN_SalirVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_CantDispo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_TotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(Campo_DescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_CodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Campo_TallaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel12)
                        .addComponent(Campo_CantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Campo_ReferenciaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Campo_CostoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_BuscarVenta)
                    .addComponent(BTN_LimpiarVenta)
                    .addComponent(BTN_CancelarVenta)
                    .addComponent(BTN_VenderVenta)
                    .addComponent(BTN_AgregarVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Campo_TotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(BTN_SalirVenta)
                    .addComponent(jLabel8)
                    .addComponent(Campo_CantDispo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Campo_DescripcionVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_DescripcionVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_DescripcionVentaActionPerformed

    private void Campo_CodigoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_CodigoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_CodigoVentaActionPerformed

    private void BTN_VenderVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VenderVentaActionPerformed
        Metodos_Ventas mt = new Metodos_Ventas(this);
        mt.venderVentas();
    }//GEN-LAST:event_BTN_VenderVentaActionPerformed

    private void Campo_TotalVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_TotalVentaActionPerformed
        Metodos_Ventas mt = new Metodos_Ventas(this);
        mt.calcularYMostrarTotal();
               
        
    }//GEN-LAST:event_Campo_TotalVentaActionPerformed

    private void BTN_CancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CancelarVentaActionPerformed
        Metodos_Ventas mt = new Metodos_Ventas(this);
        mt.cancelar();
        mostrar("Ventas");
        mt.limpiar();
    }//GEN-LAST:event_BTN_CancelarVentaActionPerformed

    private void BTN_SalirVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SalirVentaActionPerformed
        Menu mn = new Menu();
        mn.setVisible(true);
        dispose();
    }//GEN-LAST:event_BTN_SalirVentaActionPerformed

    private void BTN_LimpiarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_LimpiarVentaActionPerformed
        Metodos_Ventas mt = new Metodos_Ventas(this);
        mt.limpiar();
    }//GEN-LAST:event_BTN_LimpiarVentaActionPerformed

    private void BTN_AgregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AgregarVentaActionPerformed
        Metodos_Ventas mt = new Metodos_Ventas(this);
        mt.agregarVenta();
        mostrar("Ventas");
        costoTotal();
        mt.calcularYMostrarTotal();
    }//GEN-LAST:event_BTN_AgregarVentaActionPerformed

    private void BTN_BuscarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BuscarVentaActionPerformed
        Metodos_Ventas mt = new Metodos_Ventas(this);
        mt.buscar();
        mt.cantidadDispo();
    }//GEN-LAST:event_BTN_BuscarVentaActionPerformed

    private void Campo_CostoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_CostoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_CostoVentaActionPerformed

    private void Campo_CantidadVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_CantidadVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_CantidadVentaActionPerformed

    private void Campo_CantDispoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_CantDispoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_CantDispoActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_AgregarVenta;
    public javax.swing.JButton BTN_BuscarVenta;
    public javax.swing.JButton BTN_CancelarVenta;
    public javax.swing.JButton BTN_LimpiarVenta;
    private javax.swing.JButton BTN_SalirVenta;
    public javax.swing.JButton BTN_VenderVenta;
    public javax.swing.JTextField Campo_CantDispo;
    public javax.swing.JTextField Campo_CantidadVenta;
    public javax.swing.JTextField Campo_CodigoVenta;
    public javax.swing.JTextField Campo_CostoVenta;
    public javax.swing.JTextField Campo_DescripcionVenta;
    public javax.swing.JTextField Campo_ReferenciaVenta;
    public javax.swing.JTextField Campo_TallaVenta;
    public javax.swing.JTextField Campo_TotalVenta;
    public javax.swing.JTable Tabla_Ventas;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
