package GUI;

import GUI.INGRESO;
import Metodos.Metodos_Ventas;
import gestor_ropa.BD_CONECCTION;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Metodos.Metodos_Ingresos;
import Metodos.Metodos_FacturaProductos;

public class Ventas extends javax.swing.JFrame {

    BD_CONECCTION bd = new BD_CONECCTION();
    Connection con = bd.getconectar();
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
        model.addColumn("PRECIO");
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
                datos[4] = rs.getString(5);//PRECIO
                datos[5] = rs.getString(6);//VALOR_TOTAL

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
        Campo_COSTOventa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Campo_TallaVenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        BTN_BuscarVenta = new javax.swing.JButton();
        BTN_LimpiarVenta = new javax.swing.JButton();
        BTN_VenderVenta = new javax.swing.JButton();
        BTN_SalirVenta = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
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
        jLabel14 = new javax.swing.JLabel();
        Campo_PrecioVenta1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Campo_TotalVenta = new javax.swing.JTextField();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        Campo_COSTOventa.setEditable(false);
        Campo_COSTOventa.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_COSTOventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_COSTOventaActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));

        Campo_TallaVenta.setEditable(false);
        Campo_TallaVenta.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("CANTIDAD DISP:");

        BTN_BuscarVenta.setBackground(new java.awt.Color(0, 0, 204));
        BTN_BuscarVenta.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_BuscarVenta.setForeground(new java.awt.Color(255, 255, 255));
        BTN_BuscarVenta.setText("BUSCAR");
        BTN_BuscarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BuscarVentaActionPerformed(evt);
            }
        });

        BTN_LimpiarVenta.setBackground(new java.awt.Color(0, 0, 204));
        BTN_LimpiarVenta.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_LimpiarVenta.setForeground(new java.awt.Color(255, 255, 255));
        BTN_LimpiarVenta.setText("LIMPIAR");
        BTN_LimpiarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_LimpiarVentaActionPerformed(evt);
            }
        });

        BTN_VenderVenta.setBackground(new java.awt.Color(0, 0, 204));
        BTN_VenderVenta.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BTN_VenderVenta.setForeground(new java.awt.Color(255, 255, 255));
        BTN_VenderVenta.setText("VENDER");
        BTN_VenderVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VenderVentaActionPerformed(evt);
            }
        });

        BTN_SalirVenta.setBackground(new java.awt.Color(204, 0, 0));
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

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("COSTO:");

        Campo_ReferenciaVenta.setEditable(false);
        Campo_ReferenciaVenta.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        BTN_CancelarVenta.setBackground(new java.awt.Color(0, 0, 204));
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
                "CODIGO", "DESCRIPCION", "TALLA", "REFERENCIA", "PRECIO", "CANTIDAD", "VALOR TOTAL"
            }
        ));
        jScrollPane1.setViewportView(Tabla_Ventas);

        BTN_AgregarVenta.setBackground(new java.awt.Color(0, 0, 204));
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

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("PRECIO:");

        Campo_PrecioVenta1.setEditable(false);
        Campo_PrecioVenta1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_PrecioVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_PrecioVenta1ActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("TOTAL:");

        Campo_TotalVenta.setEditable(false);
        Campo_TotalVenta.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Campo_TotalVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_TotalVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Campo_CodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel14)
                                                .addComponent(jLabel11))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(Campo_PrecioVenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Campo_COSTOventa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Campo_CantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Campo_DescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Campo_TallaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Campo_ReferenciaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Campo_CantDispo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(BTN_BuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(BTN_LimpiarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(BTN_CancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(603, 603, 603)
                                .addComponent(BTN_AgregarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(84, 84, 84)
                        .addComponent(BTN_VenderVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(BTN_SalirVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(115, 115, 115)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Campo_TotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(9, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Campo_CodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(Campo_CantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(Campo_COSTOventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Campo_PrecioVenta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(Campo_DescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Campo_TallaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(Campo_ReferenciaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(Campo_CantDispo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_BuscarVenta)
                    .addComponent(BTN_LimpiarVenta)
                    .addComponent(BTN_CancelarVenta)
                    .addComponent(BTN_VenderVenta)
                    .addComponent(BTN_AgregarVenta))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(BTN_SalirVenta)
                    .addComponent(jLabel15)
                    .addComponent(Campo_TotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        Metodos_FacturaProductos mtf = new Metodos_FacturaProductos(this);
        mtf.facturas();
        //mtf.obtenerTotal();
        mt.venderVentas();
    }//GEN-LAST:event_BTN_VenderVentaActionPerformed

    private void BTN_CancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CancelarVentaActionPerformed
        Metodos_Ventas mt = new Metodos_Ventas(this);
        Metodos_FacturaProductos mft = new Metodos_FacturaProductos(this);
        mft.cancelar();
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
        Metodos_FacturaProductos mtf = new Metodos_FacturaProductos(this);
        mtf.obtenerProducto();
        mt.agregarVenta();
        mostrar("Ventas");
        costoTotal();
        mt.calcularYMostrarTotal();
        mt.limpiar2();
    }//GEN-LAST:event_BTN_AgregarVentaActionPerformed

    private void BTN_BuscarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BuscarVentaActionPerformed
        Metodos_Ventas mt = new Metodos_Ventas(this);
        mt.buscar();
        mt.cantidadDispo();
       // mt.calculoPorcentaje();
    }//GEN-LAST:event_BTN_BuscarVentaActionPerformed

    private void Campo_COSTOventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_COSTOventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_COSTOventaActionPerformed

    private void Campo_CantidadVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_CantidadVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_CantidadVentaActionPerformed

    private void Campo_CantDispoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_CantDispoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_CantDispoActionPerformed

    private void Campo_PrecioVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_PrecioVenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_PrecioVenta1ActionPerformed

    private void Campo_TotalVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_TotalVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_TotalVentaActionPerformed

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
    public javax.swing.JTextField Campo_COSTOventa;
    public javax.swing.JTextField Campo_CantDispo;
    public javax.swing.JTextField Campo_CantidadVenta;
    public javax.swing.JTextField Campo_CodigoVenta;
    public javax.swing.JTextField Campo_DescripcionVenta;
    public javax.swing.JTextField Campo_PrecioVenta1;
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
