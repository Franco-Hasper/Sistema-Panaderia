package formularios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import clasesUtilidadGeneral.OperacionesUtiles;
import operacionesVenta.ABM_Venta;
import operacionesVenta.InterfacesGraficasVenta;
import operacionesVenta.TablaVenta;
import principal.Main;
import principal.MaterialButton;

/**
 *
 * @author FRANCO
 */
public class FormularioEstadoVenta extends javax.swing.JDialog {

    InterfacesGraficasVenta i = new InterfacesGraficasVenta();
    ABM_Venta abm = new ABM_Venta();
    TablaVenta t = new TablaVenta();

    public FormularioEstadoVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setEstado(0);
    }

    Integer estado;

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_1_primario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PanelIngresoMateriaPrima = new javax.swing.JPanel();
        btnPendiente = new principal.MaterialButton();
        btnCancelado = new principal.MaterialButton();
        btnEliminar = new principal.MaterialButton();
        btnRealizado = new principal.MaterialButton();
        lblP = new javax.swing.JLabel();
        lblR = new javax.swing.JLabel();
        lblE = new javax.swing.JLabel();
        lblC = new javax.swing.JLabel();
        btnCancelar = new principal.MaterialButton();
        btnAceptar = new principal.MaterialButton();
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler20 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), java.awt.Color.gray, new java.awt.Color(102, 102, 102), java.awt.Color.gray));

        panel_1_primario.setBackground(new java.awt.Color(153, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELEGIR UNA ACCION");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/outgoing_data_80px.png"))); // NOI18N

        javax.swing.GroupLayout panel_1_primarioLayout = new javax.swing.GroupLayout(panel_1_primario);
        panel_1_primario.setLayout(panel_1_primarioLayout);
        panel_1_primarioLayout.setHorizontalGroup(
            panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_1_primarioLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        panel_1_primarioLayout.setVerticalGroup(
            panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        PanelIngresoMateriaPrima.setBackground(new java.awt.Color(255, 255, 255));
        PanelIngresoMateriaPrima.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelIngresoMateriaPrimaMouseDragged(evt);
            }
        });

        btnPendiente.setBackground(new java.awt.Color(0,0,0,60));
        btnPendiente.setForeground(new java.awt.Color(255, 255, 255));
        btnPendiente.setText("EStADO PENDIENTE");
        btnPendiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPendiente.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnPendiente.setPreferredSize(new java.awt.Dimension(230, 35));
        btnPendiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });

        btnCancelado.setBackground(new java.awt.Color(0,0,0,60));
        btnCancelado.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelado.setText("ESTADO CANCELADO");
        btnCancelado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelado.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnCancelado.setPreferredSize(new java.awt.Dimension(230, 35));
        btnCancelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanceladoActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0,0,0,60));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR REGISTRO");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnEliminar.setPreferredSize(new java.awt.Dimension(230, 35));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRealizado.setBackground(new java.awt.Color(0,0,0,60));
        btnRealizado.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizado.setText("ESTADO REALIZADO");
        btnRealizado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRealizado.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnRealizado.setPreferredSize(new java.awt.Dimension(230, 35));
        btnRealizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizadoActionPerformed(evt);
            }
        });

        lblP.setBackground(new java.awt.Color(255, 255, 255));
        lblP.setForeground(new java.awt.Color(255, 255, 255));
        lblP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ok.png"))); // NOI18N

        lblR.setBackground(new java.awt.Color(255, 255, 255));
        lblR.setForeground(new java.awt.Color(255, 255, 255));
        lblR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ok.png"))); // NOI18N

        lblE.setBackground(new java.awt.Color(255, 255, 255));
        lblE.setForeground(new java.awt.Color(255, 255, 255));
        lblE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ok.png"))); // NOI18N

        lblC.setBackground(new java.awt.Color(255, 255, 255));
        lblC.setForeground(new java.awt.Color(255, 255, 255));
        lblC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ok.png"))); // NOI18N

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0,60));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnCancelar.setPreferredSize(new java.awt.Dimension(70, 50));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(0, 0, 0,60));
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("ACEPTAR");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnAceptar.setMaximumSize(new java.awt.Dimension(170, 35));
        btnAceptar.setMinimumSize(new java.awt.Dimension(170, 35));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        filler15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout PanelIngresoMateriaPrimaLayout = new javax.swing.GroupLayout(PanelIngresoMateriaPrima);
        PanelIngresoMateriaPrima.setLayout(PanelIngresoMateriaPrimaLayout);
        PanelIngresoMateriaPrimaLayout.setHorizontalGroup(
            PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(filler20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                                .addComponent(btnCancelado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblC))
                            .addGroup(PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblE))))
                    .addComponent(filler19, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(filler15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                            .addComponent(btnPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblP)))
                    .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(filler17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                            .addComponent(btnRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblR))))
                .addGap(108, 108, 108))
            .addGroup(PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filler18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filler16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(filler21, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(88, Short.MAX_VALUE)))
        );
        PanelIngresoMateriaPrimaLayout.setVerticalGroup(
            PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                .addComponent(filler17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRealizado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPendiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                    .addContainerGap(394, Short.MAX_VALUE)
                    .addComponent(filler21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(92, 92, 92)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_1_primario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelIngresoMateriaPrima, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel_1_primario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelIngresoMateriaPrima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void PanelIngresoMateriaPrimaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelIngresoMateriaPrimaMouseDragged

    }//GEN-LAST:event_PanelIngresoMateriaPrimaMouseDragged

    private void btnPendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPendienteActionPerformed
        setEstado(4);
        i.seleccionPendiente(this);
    }//GEN-LAST:event_btnPendienteActionPerformed

    private void btnCanceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanceladoActionPerformed
        setEstado(5);
        i.seleccionCancelar(this);
    }//GEN-LAST:event_btnCanceladoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        setEstado(2);
        i.seleccionElminar(this);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRealizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizadoActionPerformed
        setEstado(3);
        i.seleccionRealizado(this);
    }//GEN-LAST:event_btnRealizadoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
         if (getEstado().equals(0)) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (abm.ejecutarCambiarEstadoVenta(this)) {
                this.dispose();
                t.setEstadoConsulta(0);
                t.ejecutarRellenarTabla(Main.getPrincipalAdmin().getVentas());
                Main.getPrincipalAdmin().getVentas().setT(t);
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
          OperacionesUtiles.mensajeCancelarFormulario(this);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioEstadoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioEstadoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioEstadoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioEstadoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioEstadoVenta dialog = new FormularioEstadoVenta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JLabel getLblC() {
        return lblC;
    }

    public void setLblC(JLabel lblC) {
        this.lblC = lblC;
    }

    public JLabel getLblE() {
        return lblE;
    }

    public void setLblE(JLabel lblE) {
        this.lblE = lblE;
    }

    public JLabel getLblP() {
        return lblP;
    }

    public void setLblP(JLabel lblP) {
        this.lblP = lblP;
    }

    public JLabel getLblR() {
        return lblR;
    }

    public void setLblR(JLabel lblR) {
        this.lblR = lblR;
    }

    public JPanel getPanel_1_primario() {
        return panel_1_primario;
    }

    public void setPanel_1_primario(JPanel panel_1_primario) {
        this.panel_1_primario = panel_1_primario;
    }

    public MaterialButton getBtnCancelado() {
        return btnCancelado;
    }

    public void setBtnCancelado(MaterialButton btnCancelado) {
        this.btnCancelado = btnCancelado;
    }

    public MaterialButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(MaterialButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public MaterialButton getBtnPendiente() {
        return btnPendiente;
    }

    public void setBtnPendiente(MaterialButton btnPendiente) {
        this.btnPendiente = btnPendiente;
    }

    public MaterialButton getBtnRealizado() {
        return btnRealizado;
    }

    public void setBtnRealizado(MaterialButton btnRealizado) {
        this.btnRealizado = btnRealizado;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel PanelIngresoMateriaPrima;
    public static principal.MaterialButton btnAceptar;
    private principal.MaterialButton btnCancelado;
    public static principal.MaterialButton btnCancelar;
    private principal.MaterialButton btnEliminar;
    private principal.MaterialButton btnPendiente;
    private principal.MaterialButton btnRealizado;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler16;
    private javax.swing.Box.Filler filler17;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler20;
    private javax.swing.Box.Filler filler21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblC;
    private javax.swing.JLabel lblE;
    private javax.swing.JLabel lblP;
    private javax.swing.JLabel lblR;
    private javax.swing.JPanel panel_1_primario;
    // End of variables declaration//GEN-END:variables
}
