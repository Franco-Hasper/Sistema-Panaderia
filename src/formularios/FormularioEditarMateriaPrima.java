package formularios;

import calsesPadre.Formularios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import operacionesMateriaPrima.ABM_MateriaPrima;
import operacionesMateriaPrima.TablaMateriaPrima;
import clasesUtilidadGeneral.OperacionesUtiles;
import clasesUtilidadGeneral.TextPrompt;
import principal.Main;

public class FormularioEditarMateriaPrima extends javax.swing.JDialog implements Formularios{

    OperacionesUtiles opU = new OperacionesUtiles();
    ABM_MateriaPrima abm = new ABM_MateriaPrima();
    TablaMateriaPrima t = new TablaMateriaPrima();

    public FormularioEditarMateriaPrima(javax.swing.JInternalFrame parent, boolean modal) {
        initComponents();
        TextPrompt nom = new TextPrompt("NOMBRE", txtNombreMAteriaPrima);
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
    }

    public JTextField getTxtNombreMAteriaPrima() {
        return txtNombreMAteriaPrima;
    }

    public void setTxtNombreMAteriaPrima(JTextField txtNombreMAteriaPrima) {
        this.txtNombreMAteriaPrima = txtNombreMAteriaPrima;
    }

    public JComboBox<String> getBoxMarca() {
        return boxMarca;
    }

    public void setBoxMarca(JComboBox<String> boxMarca) {
        this.boxMarca = boxMarca;
    }

    public JComboBox<String> getBoxProveedor() {
        return boxProveedor;
    }

    public void setBoxProveedor(JComboBox<String> boxProveedor) {
        this.boxProveedor = boxProveedor;
    }

    public JComboBox<String> getBoxUdeMedida() {
        return boxUdeMedida;
    }

    public void setBoxUdeMedida(JComboBox<String> boxUdeMedida) {
        this.boxUdeMedida = boxUdeMedida;
    }

  
    @Override
    public List getListaCampos() {
        List listCamposTexto = new ArrayList();
        listCamposTexto.add(this.getTxtNombreMAteriaPrima());
        return listCamposTexto;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_1_primario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtNombreMAteriaPrima = new javax.swing.JTextField();
        boxProveedor = new javax.swing.JComboBox<>();
        boxUdeMedida = new javax.swing.JComboBox<>();
        boxMarca = new javax.swing.JComboBox<>();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        btnGuardarCambios = new principal.MaterialButton();
        btnGuardarCorte = new principal.MaterialButton();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), java.awt.Color.gray, new java.awt.Color(102, 102, 102), java.awt.Color.gray));

        panel_1_primario.setBackground(new java.awt.Color(153, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("EDITAR MATERIA PRIMA");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit_file_80px.png"))); // NOI18N

        javax.swing.GroupLayout panel_1_primarioLayout = new javax.swing.GroupLayout(panel_1_primario);
        panel_1_primario.setLayout(panel_1_primarioLayout);
        panel_1_primarioLayout.setHorizontalGroup(
            panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_1_primarioLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_1_primarioLayout.setVerticalGroup(
            panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtNombreMAteriaPrima.setToolTipText("");
        txtNombreMAteriaPrima.setName(""); // NOI18N
        txtNombreMAteriaPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreMAteriaPrimaActionPerformed(evt);
            }
        });
        txtNombreMAteriaPrima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreMAteriaPrimaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreMAteriaPrimaKeyTyped(evt);
            }
        });

        boxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxProveedorActionPerformed(evt);
            }
        });

        boxUdeMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxUdeMedidaActionPerformed(evt);
            }
        });

        boxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMarcaActionPerformed(evt);
            }
        });

        filler10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        btnGuardarCorte.setBackground(new java.awt.Color(0, 0, 0,60));
        btnGuardarCorte.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCorte.setText("CANCELAR");
        btnGuardarCorte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarCorte.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnGuardarCorte.setPreferredSize(new java.awt.Dimension(70, 50));
        btnGuardarCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCorteActionPerformed(evt);
            }
        });

        filler11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filler16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(filler12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreMAteriaPrima)
                            .addComponent(filler10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filler13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filler14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxUdeMedida, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxMarca, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filler16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(filler11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardarCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(filler10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreMAteriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(filler13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxUdeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(filler14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_1_primario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel_1_primario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void txtNombreMAteriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreMAteriaPrimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreMAteriaPrimaActionPerformed

    private void txtNombreMAteriaPrimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreMAteriaPrimaKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNombreMAteriaPrimaKeyTyped

    private void boxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxProveedorActionPerformed

    private void boxUdeMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxUdeMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxUdeMedidaActionPerformed

    private void boxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMarcaActionPerformed

    private void txtNombreMAteriaPrimaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreMAteriaPrimaKeyReleased
        // TODO add your handling code here:
        opU.advertenciaChar(evt);
    }//GEN-LAST:event_txtNombreMAteriaPrimaKeyReleased

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
       abm.ejecutarEditarMateriaPrima(this);
        t.setEstadoConsulta(0);
        t.ejecutarRellenarTabla(Main.getPrincipalAdmin().getMatprima());
        Main.getPrincipalAdmin().getMatprima().setT(t);
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnGuardarCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCorteActionPerformed
        OperacionesUtiles.mensajeCancelarFormulario(this);
    }//GEN-LAST:event_btnGuardarCorteActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioEditarMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioEditarMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioEditarMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioEditarMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioEditarMateriaPrima dialog = new FormularioEditarMateriaPrima(new javax.swing.JInternalFrame(), true);
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

    public JPanel getPanel_1_primario() {
        return panel_1_primario;
    }

    public void setPanel_1_primario(JPanel panel_1_primario) {
        this.panel_1_primario = panel_1_primario;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxMarca;
    private javax.swing.JComboBox<String> boxProveedor;
    private javax.swing.JComboBox<String> boxUdeMedida;
    public static principal.MaterialButton btnGuardarCambios;
    public static principal.MaterialButton btnGuardarCorte;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler16;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panel_1_primario;
    private javax.swing.JTextField txtNombreMAteriaPrima;
    // End of variables declaration//GEN-END:variables
}
