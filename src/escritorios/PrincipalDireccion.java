package escritorios;

import formularios.FormularioEditarDireccion;
import formularios.FormularioRegistrarDireccion;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import operacionesDireccion.ABM_Direccion;
import operacionesDireccion.InterfacesGraficasDireccion;
import operacionesDireccion.TablaDireccion;
import principal.MaterialButton;

public class PrincipalDireccion extends javax.swing.JInternalFrame {

    String entidad;

    InterfacesGraficasDireccion i = new InterfacesGraficasDireccion();
    Frame j = new Frame();
    ABM_Direccion abmd = new ABM_Direccion();
    TablaDireccion t = new TablaDireccion();

    /**
     * Creates new form PrincipalDireccion
     */
    public PrincipalDireccion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_1_primario = new javax.swing.JPanel();
        btnnEditarDir = new principal.MaterialButton();
        btnEliminarDir = new principal.MaterialButton();
        btnNuevoDir = new principal.MaterialButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();

        panel_1_primario.setBackground(new java.awt.Color(204, 0, 0));

        btnnEditarDir.setBackground(new java.awt.Color(0, 0, 0,60));
        btnnEditarDir.setForeground(new java.awt.Color(255, 255, 255));
        btnnEditarDir.setText("EDITAR DIRECCION");
        btnnEditarDir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnEditarDir.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnnEditarDir.setMaximumSize(new java.awt.Dimension(130, 35));
        btnnEditarDir.setMinimumSize(new java.awt.Dimension(130, 35));
        btnnEditarDir.setPreferredSize(new java.awt.Dimension(130, 35));
        btnnEditarDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnEditarDirActionPerformed(evt);
            }
        });

        btnEliminarDir.setBackground(new java.awt.Color(0, 0, 0,60));
        btnEliminarDir.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarDir.setText("ELIMINAR DIRECCION");
        btnEliminarDir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarDir.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnEliminarDir.setMaximumSize(new java.awt.Dimension(130, 35));
        btnEliminarDir.setMinimumSize(new java.awt.Dimension(130, 35));
        btnEliminarDir.setPreferredSize(new java.awt.Dimension(130, 35));
        btnEliminarDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDirActionPerformed(evt);
            }
        });

        btnNuevoDir.setBackground(new java.awt.Color(0, 0, 0,60));
        btnNuevoDir.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoDir.setText("NUEVO DIRECCION");
        btnNuevoDir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoDir.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnNuevoDir.setMaximumSize(new java.awt.Dimension(130, 35));
        btnNuevoDir.setMinimumSize(new java.awt.Dimension(130, 35));
        btnNuevoDir.setPreferredSize(new java.awt.Dimension(130, 35));
        btnNuevoDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoDirActionPerformed(evt);
            }
        });

        tabla.setBackground(new java.awt.Color(255, 255, 255));
        tabla.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tabla.setForeground(new java.awt.Color(102, 0, 0));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "NUMERO", "LOCALIDAD", "CODIGO POStAL", "PROVINCIA"
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
        tabla.setSelectionBackground(new java.awt.Color(102, 0, 0));
        tabla.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                tablaComponentHidden(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/map_80px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DIRECCIONES");

        lblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_60px.png"))); // NOI18N
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_1_primarioLayout = new javax.swing.GroupLayout(panel_1_primario);
        panel_1_primario.setLayout(panel_1_primarioLayout);
        panel_1_primarioLayout.setHorizontalGroup(
            panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_1_primarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoDir, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnnEditarDir, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarDir, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(366, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_1_primarioLayout.setVerticalGroup(
            panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_1_primarioLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnEditarDir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoDir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarDir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_1_primario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_1_primario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnEditarDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnEditarDirActionPerformed
        // TODO add your handling code here:
        if (i.verificarFilaSeleccionadaDireccion()) {
            FormularioEditarDireccion fed = new FormularioEditarDireccion(j, true);
            fed.setEntidad(this.getEntidad());
            i.nuevoFormEditarDireccion(fed);
        }
    }//GEN-LAST:event_btnnEditarDirActionPerformed

    private void tablaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tablaComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaComponentHidden

    private void btnNuevoDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoDirActionPerformed
        // TODO add your handling code here:
        FormularioRegistrarDireccion fr = new FormularioRegistrarDireccion(j, true);
        fr.setEntidad(this.getEntidad());
        i.nuevoFormRegistrarDireccion(fr);
    }//GEN-LAST:event_btnNuevoDirActionPerformed

    private void btnEliminarDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDirActionPerformed
        // TODO add your handling code here:
        if (i.verificarFilaSeleccionadaDireccion()) {
            abmd.setEntidad(getEntidad());
            abmd.ejecutarElminarDireccion();
            // t.ejecutarRellenarTablaDireccionCliente(this);
        }
    }//GEN-LAST:event_btnEliminarDirActionPerformed

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    public MaterialButton getBtnEliminarDir() {
        return btnEliminarDir;
    }

    public void setBtnEliminarDir(MaterialButton btnEliminarDir) {
        this.btnEliminarDir = btnEliminarDir;
    }

    public MaterialButton getBtnNuevoDir() {
        return btnNuevoDir;
    }

    public void setBtnNuevoDir(MaterialButton btnNuevoDir) {
        this.btnNuevoDir = btnNuevoDir;
    }

    public MaterialButton getBtnnEditarDir() {
        return btnnEditarDir;
    }

    public void setBtnnEditarDir(MaterialButton btnnEditarDir) {
        this.btnnEditarDir = btnnEditarDir;
    }

    public JPanel getPanel_1_primario() {
        return panel_1_primario;
    }

    public void setPanel_1_primario(JPanel panel_1_primario) {
        this.panel_1_primario = panel_1_primario;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    /**
     * Devuelve un valor si la entidad es Proveedor y otro si la entidad es
     * Cliente.
     *
     * @return
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * permite alojar un valor en el atributo entidad dependiendo de que ventana
     * realiza la apertura de Direcciones, sindo los valores posibles Proveedor
     * o Cliente.
     *
     * @param entidad
     */
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton btnEliminarDir;
    private principal.MaterialButton btnNuevoDir;
    private principal.MaterialButton btnnEditarDir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JPanel panel_1_primario;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
