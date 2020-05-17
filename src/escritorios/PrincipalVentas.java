package escritorios;

import formularios.FormularioDetalleDeVenta;
import formularios.FormularioEstadoVenta;
import java.awt.Frame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import clasesUtilidadGeneral.OperacionesUtiles;
import operacionesVenta.InterfacesGraficasVenta;
import operacionesVenta.OperacionesSecundariasVenta;
import operacionesVenta.TablaVenta;
import principal.Main;

/**
 *
 * @author TELCOM MPC
 */
public class PrincipalVentas extends javax.swing.JInternalFrame {

    TablaVenta t = new TablaVenta();
    OperacionesUtiles opU = new OperacionesUtiles();
    Frame j = new Frame();
    OperacionesSecundariasVenta ot = new OperacionesSecundariasVenta();
    InterfacesGraficasVenta i = new InterfacesGraficasVenta();

    Integer tipoFormulario;
    private boolean minimiza = false;
    public boolean cerra = false;

    public PrincipalVentas() {
        initComponents();
        radButtonPendientes.setEnabled(false);
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public TablaVenta getT() {
        return t;
    }

    public void setT(TablaVenta t) {
        this.t = t;
    }

    /**
     * Devuelve un objeto de la clase TablaVenta con el id de la fila
     * seleccionada.
     * @return
     */
    public TablaVenta ObjetoTablaConDatos() {
        t.setTabla(tabla);
        t.setConsultaList("from Venta");
        t.obtenerListaConsulta();
        t.obtenerIdTablaVenta();
        return t;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_1_primario = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lbltrigo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnEditarVenta = new principal.MaterialButton();
        btnVentaWeb = new principal.MaterialButton();
        nuevo = new principal.MaterialButton();
        radButonSoloPedidos = new javax.swing.JRadioButton();
        radButtonPendientes = new javax.swing.JRadioButton();
        bntCambiarEstado = new principal.MaterialButton();
        btnDetallesVenta = new principal.MaterialButton();

        panel_1_primario.setBackground(new java.awt.Color(204, 0, 0));
        panel_1_primario.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setBackground(new java.awt.Color(255, 255, 255));
        tabla.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tabla.setForeground(new java.awt.Color(102, 0, 0));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CLIENTE", "FECHA", "PRECIO TOTAL", "TIPO DE VENTA", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla.setDoubleBuffered(true);
        tabla.setRowHeight(40);
        tabla.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tabla.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0, 60));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        lbltrigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/low_price_80px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("VENTAS");

        lblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_60px.png"))); // NOI18N
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltrigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbltrigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        txtBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnEditarVenta.setBackground(new java.awt.Color(0,0,0,60));
        btnEditarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarVenta.setText("EDITAR VENTA");
        btnEditarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarVenta.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnEditarVenta.setMinimumSize(new java.awt.Dimension(0, 0));
        btnEditarVenta.setPreferredSize(new java.awt.Dimension(230, 35));
        btnEditarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVentaActionPerformed(evt);
            }
        });

        btnVentaWeb.setBackground(new java.awt.Color(0,0,0,60));
        btnVentaWeb.setForeground(new java.awt.Color(255, 255, 255));
        btnVentaWeb.setText("NUEVO VENTA WEB");
        btnVentaWeb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentaWeb.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnVentaWeb.setMinimumSize(new java.awt.Dimension(0, 0));
        btnVentaWeb.setPreferredSize(new java.awt.Dimension(230, 35));
        btnVentaWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaWebActionPerformed(evt);
            }
        });

        nuevo.setBackground(new java.awt.Color(0,0,0,60));
        nuevo.setForeground(new java.awt.Color(255, 255, 255));
        nuevo.setText("NUEVO VENTA");
        nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevo.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        nuevo.setMinimumSize(new java.awt.Dimension(0, 0));
        nuevo.setPreferredSize(new java.awt.Dimension(230, 35));
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        radButonSoloPedidos.setText("SOLO PEDIDOS");
        radButonSoloPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radButonSoloPedidosActionPerformed(evt);
            }
        });

        radButtonPendientes.setText("PENDIENTES");
        radButtonPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radButtonPendientesActionPerformed(evt);
            }
        });

        bntCambiarEstado.setBackground(new java.awt.Color(0,0,0,60));
        bntCambiarEstado.setForeground(new java.awt.Color(255, 255, 255));
        bntCambiarEstado.setText("ELIMINAR/CAMBIAR ESTADO");
        bntCambiarEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntCambiarEstado.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        bntCambiarEstado.setMinimumSize(new java.awt.Dimension(0, 0));
        bntCambiarEstado.setPreferredSize(new java.awt.Dimension(230, 35));
        bntCambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCambiarEstadoActionPerformed(evt);
            }
        });

        btnDetallesVenta.setBackground(new java.awt.Color(0,0,0,60));
        btnDetallesVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnDetallesVenta.setText("VER DEtALLES");
        btnDetallesVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetallesVenta.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnDetallesVenta.setMinimumSize(new java.awt.Dimension(0, 0));
        btnDetallesVenta.setPreferredSize(new java.awt.Dimension(230, 35));
        btnDetallesVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_1_primarioLayout = new javax.swing.GroupLayout(panel_1_primario);
        panel_1_primario.setLayout(panel_1_primarioLayout);
        panel_1_primarioLayout.setHorizontalGroup(
            panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_1_primarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnVentaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnEditarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntCambiarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDetallesVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radButtonPendientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radButonSoloPedidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_1_primarioLayout.setVerticalGroup(
            panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_1_primarioLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVentaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntCambiarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDetallesVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_1_primarioLayout.createSequentialGroup()
                        .addComponent(radButonSoloPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addComponent(radButtonPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_1_primario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_1_primario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed

        i.nuevaFormularioRegistrarVenta(Main.getPrincipalAdmin());
    }//GEN-LAST:event_nuevoActionPerformed


    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        t.ejecutarRellenarTabla(this);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnEditarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVentaActionPerformed
        if (i.verificarFilaSeleccionadaVenta()) {
            i.nuevoFormEditarVenta(Main.getPrincipalAdmin());
        }
    }//GEN-LAST:event_btnEditarVentaActionPerformed

    private void btnVentaWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaWebActionPerformed
        // TODO add your handling code here:
        /**
         * try { String http="http://localhost/parcial2/";
         * Desktop.getDesktop().browse(new URI(http)); } catch (Exception e) { }
         *
         */
        InterfacesGraficasVenta.ejecutarNuevaVentanaVentaWeb();
    }//GEN-LAST:event_btnVentaWebActionPerformed

    private void radButonSoloPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radButonSoloPedidosActionPerformed
        if (radButonSoloPedidos.isSelected()) {
            radButtonPendientes.setEnabled(true);
        } else {
            radButtonPendientes.setEnabled(false);
        }
        t.ejecutarRellenarTabla(this);
    }//GEN-LAST:event_radButonSoloPedidosActionPerformed

    private void radButtonPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radButtonPendientesActionPerformed
        t.ejecutarRellenarTabla(this);
    }//GEN-LAST:event_radButtonPendientesActionPerformed

    private void bntCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCambiarEstadoActionPerformed

        if (i.verificarFilaSeleccionadaVenta()) {
            FormularioEstadoVenta f = new FormularioEstadoVenta(j, true);
            i.nuevoFormularioEstadoVenta(f);
        }

    }//GEN-LAST:event_bntCambiarEstadoActionPerformed

    private void btnDetallesVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesVentaActionPerformed
        if (i.verificarFilaSeleccionadaVenta()) {
            FormularioDetalleDeVenta f = new FormularioDetalleDeVenta(j, true);
            i.nuevoFormularioDetalleDeVenta(f);
        }
    }//GEN-LAST:event_btnDetallesVentaActionPerformed

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    public JPanel getPanel_1_primario() {
        return panel_1_primario;
    }

    public void setPanel_1_primario(JPanel panel_1_primario) {
        this.panel_1_primario = panel_1_primario;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JRadioButton getRadButonSoloPedidos() {
        return radButonSoloPedidos;
    }

    public void setRadButonSoloPedidos(JRadioButton radButonSoloPedidos) {
        this.radButonSoloPedidos = radButonSoloPedidos;
    }

    public JRadioButton getRadButtonPendientes() {
        return radButtonPendientes;
    }

    public void setRadButtonPendientes(JRadioButton radButtonPendientes) {
        this.radButtonPendientes = radButtonPendientes;
    }

    public Integer getTipoFormulario() {
        return tipoFormulario;
    }

    public void setTipoFormulario(Integer tipoFormulario) {
        this.tipoFormulario = tipoFormulario;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton bntCambiarEstado;
    private principal.MaterialButton btnDetallesVenta;
    private principal.MaterialButton btnEditarVenta;
    private principal.MaterialButton btnVentaWeb;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSalir;
    public static javax.swing.JLabel lbltrigo;
    private principal.MaterialButton nuevo;
    private javax.swing.JPanel panel_1_primario;
    private javax.swing.JRadioButton radButonSoloPedidos;
    private javax.swing.JRadioButton radButtonPendientes;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
