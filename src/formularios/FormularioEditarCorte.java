package formularios;

import calsesPadre.Formularios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextField;
import operacionesCaja.ABM_Caja;
import operacionesCaja.OperacionesSecundarias;
import operacionesCaja.TablaCaja;
import clasesUtilidadGeneral.OperacionesUtiles;
import principal.Main;
import rojeru_san.componentes.RSDateChooser;

/**
 *
 * @author FRANCO
 */
public class FormularioEditarCorte extends javax.swing.JDialog implements Formularios{

    OperacionesUtiles opU = new OperacionesUtiles();
    TablaCaja t = new TablaCaja();
    ABM_Caja abm = new ABM_Caja();
    OperacionesSecundarias o = new OperacionesSecundarias();

    /**
     * Creates new form FormularioEditarCorte
     */
    public FormularioEditarCorte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @Override
    public List getListaCampos() {
        List listCamposTexto = new ArrayList();
        listCamposTexto.add(this.getTxtTotalEgresos());
        listCamposTexto.add(this.getTxtTotalIngresos());
        return listCamposTexto;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_1_primario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PanelIngresoMateriaPrima = new javax.swing.JPanel();
        rSDateChooser = new rojeru_san.componentes.RSDateChooser();
        txtBalance = new javax.swing.JTextField();
        radioButtonFecha = new javax.swing.JRadioButton();
        txtTotalIngresos = new javax.swing.JTextField();
        txtTotalEgresos = new javax.swing.JTextField();
        btnGuardarCambios = new principal.MaterialButton();
        btnCancelar = new principal.MaterialButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), java.awt.Color.gray, new java.awt.Color(102, 102, 102), java.awt.Color.gray));

        panel_1_primario.setBackground(new java.awt.Color(153, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("EDITAR CORTE");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit_file_80px.png"))); // NOI18N

        javax.swing.GroupLayout panel_1_primarioLayout = new javax.swing.GroupLayout(panel_1_primario);
        panel_1_primario.setLayout(panel_1_primarioLayout);
        panel_1_primarioLayout.setHorizontalGroup(
            panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_1_primarioLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_1_primarioLayout.setVerticalGroup(
            panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        PanelIngresoMateriaPrima.setBackground(new java.awt.Color(255, 255, 255));
        PanelIngresoMateriaPrima.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelIngresoMateriaPrimaMouseDragged(evt);
            }
        });

        rSDateChooser.setColorBackground(new java.awt.Color(0, 0, 0));
        rSDateChooser.setColorButtonHover(new java.awt.Color(0, 0, 0));
        rSDateChooser.setColorDiaActual(new java.awt.Color(0, 0, 0));
        rSDateChooser.setColorForeground(new java.awt.Color(0, 0, 0));

        txtBalance.setEditable(false);
        txtBalance.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        txtBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBalanceActionPerformed(evt);
            }
        });
        txtBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBalanceKeyReleased(evt);
            }
        });

        radioButtonFecha.setText("FECHA ACTUAL");
        radioButtonFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonFechaActionPerformed(evt);
            }
        });

        txtTotalIngresos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        txtTotalIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalIngresosActionPerformed(evt);
            }
        });
        txtTotalIngresos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalIngresosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalIngresosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalIngresosKeyTyped(evt);
            }
        });

        txtTotalEgresos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        txtTotalEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalEgresosActionPerformed(evt);
            }
        });
        txtTotalEgresos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalEgresosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalEgresosKeyTyped(evt);
            }
        });

        btnGuardarCambios.setBackground(new java.awt.Color(0, 0, 0,60));
        btnGuardarCambios.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCambios.setText("GUARDAR CAMBIOS");
        btnGuardarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarCambios.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnGuardarCambios.setMaximumSize(new java.awt.Dimension(170, 35));
        btnGuardarCambios.setMinimumSize(new java.awt.Dimension(170, 35));
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

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

        filler1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout PanelIngresoMateriaPrimaLayout = new javax.swing.GroupLayout(PanelIngresoMateriaPrima);
        PanelIngresoMateriaPrima.setLayout(PanelIngresoMateriaPrimaLayout);
        PanelIngresoMateriaPrimaLayout.setHorizontalGroup(
            PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filler8, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                            .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rSDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(radioButtonFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBalance)
                                    .addComponent(txtTotalEgresos)
                                    .addComponent(txtTotalIngresos)
                                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(filler3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(filler4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(30, 30, 30)
                .addComponent(filler5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        PanelIngresoMateriaPrimaLayout.setVerticalGroup(
            PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268))
            .addGroup(PanelIngresoMateriaPrimaLayout.createSequentialGroup()
                .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTotalIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelIngresoMateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_1_primario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(PanelIngresoMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel_1_primario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelIngresoMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void txtBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBalanceActionPerformed

    private void txtBalanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBalanceKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBalanceKeyReleased

    private void radioButtonFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonFechaActionPerformed

        if (radioButtonFecha.isSelected()) {
            opU.insertarFechaActualDateChooser(rSDateChooser);
        } else {
            rSDateChooser.setDatoFecha(null);
        }
    }//GEN-LAST:event_radioButtonFechaActionPerformed

    private void PanelIngresoMateriaPrimaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelIngresoMateriaPrimaMouseDragged

    }//GEN-LAST:event_PanelIngresoMateriaPrimaMouseDragged

    private void txtTotalIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalIngresosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalIngresosActionPerformed

    private void txtTotalIngresosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalIngresosKeyReleased
        this.getTxtBalance().setText(o.calcularBalance(this).toString());
    }//GEN-LAST:event_txtTotalIngresosKeyReleased

    private void txtTotalEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalEgresosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalEgresosActionPerformed

    private void txtTotalEgresosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalEgresosKeyReleased
        this.getTxtBalance().setText(o.calcularBalance(this).toString());
    }//GEN-LAST:event_txtTotalEgresosKeyReleased

    private void txtTotalIngresosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalIngresosKeyTyped

        if (opU.advertenciaNum(evt)) {
            OperacionesUtiles.borrarCampo(txtTotalIngresos);
        }

    }//GEN-LAST:event_txtTotalIngresosKeyTyped

    private void txtTotalEgresosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalEgresosKeyTyped

        if (opU.advertenciaNum(evt)) {
            OperacionesUtiles.borrarCampo(txtTotalEgresos);
        }
    }//GEN-LAST:event_txtTotalEgresosKeyTyped

    private void txtTotalIngresosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalIngresosKeyPressed

    }//GEN-LAST:event_txtTotalIngresosKeyPressed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
          if (abm.ejecutarEditarCorteCaja(this)) {
            t.setEstadoConsulta(0);
            t.ejecutarRellenarTabla(Main.getPrincipalAdmin().getCaja());
            Main.getPrincipalAdmin().getCaja().setT(t);

        }

    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioEditarCorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioEditarCorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioEditarCorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioEditarCorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioEditarCorte dialog = new FormularioEditarCorte(new javax.swing.JFrame(), true);
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

    public JTextField getTxtBalance() {
        return txtBalance;
    }

    public void setTxtBalance(JTextField txtBalance) {
        this.txtBalance = txtBalance;
    }

    public JTextField getTxtTotalEgresos() {
        return txtTotalEgresos;
    }

    public void setTxtTotalEgresos(JTextField txtTotalEgresos) {
        this.txtTotalEgresos = txtTotalEgresos;
    }

    public JTextField getTxtTotalIngresos() {
        return txtTotalIngresos;
    }

    public void setTxtTotalIngresos(JTextField txtTotalIngresos) {
        this.txtTotalIngresos = txtTotalIngresos;
    }

    public RSDateChooser getrSDateChooser() {
        return rSDateChooser;
    }

    public void setrSDateChooser(RSDateChooser rSDateChooser) {
        this.rSDateChooser = rSDateChooser;
    }

    public JPanel getPanel_1_primario() {
        return panel_1_primario;
    }

    public void setPanel_1_primario(JPanel panel_1_primario) {
        this.panel_1_primario = panel_1_primario;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel PanelIngresoMateriaPrima;
    public static principal.MaterialButton btnCancelar;
    public static principal.MaterialButton btnGuardarCambios;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel_1_primario;
    private rojeru_san.componentes.RSDateChooser rSDateChooser;
    private javax.swing.JRadioButton radioButtonFecha;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtTotalEgresos;
    private javax.swing.JTextField txtTotalIngresos;
    // End of variables declaration//GEN-END:variables
}
