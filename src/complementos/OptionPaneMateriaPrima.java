package complementos;

import javax.swing.JButton;
import operacionesMateriaPrima.InterfacesGraficasMateriaPrima;
import principal.Main;

/**
 *
 * @author TELCOM MPC
 */
public class OptionPaneMateriaPrima extends javax.swing.JDialog {

    /**
     * Creates new form OptionPaneMateriaPrima
     */
    public OptionPaneMateriaPrima(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getBtnMateriaPrima().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        getBtnIngresoMateriaPrima().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        this.setLocationRelativeTo(null);
    }

    InterfacesGraficasMateriaPrima i = new InterfacesGraficasMateriaPrima();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnMateriaPrima = new javax.swing.JButton();
        btnIngresoMateriaPrima = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), java.awt.Color.gray, new java.awt.Color(102, 102, 102), java.awt.Color.gray));
        jPanel2.setMaximumSize(new java.awt.Dimension(415, 300));
        jPanel2.setMinimumSize(new java.awt.Dimension(415, 300));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        btnMateriaPrima.setBackground(new java.awt.Color(153, 0, 51));
        btnMateriaPrima.setForeground(new java.awt.Color(255, 255, 255));
        btnMateriaPrima.setText("MATERIA PRIMA");
        btnMateriaPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMateriaPrimaActionPerformed(evt);
            }
        });

        btnIngresoMateriaPrima.setBackground(new java.awt.Color(153, 0, 51));
        btnIngresoMateriaPrima.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresoMateriaPrima.setText("INGRESO MATERIA PRIMA");
        btnIngresoMateriaPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoMateriaPrimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIngresoMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(btnMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnIngresoMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresoMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoMateriaPrimaActionPerformed
        // TODO add your handling code here:
        InterfacesGraficasMateriaPrima.ejecutarNuevaVentanaIngresoMateriaPrima();
        this.dispose();
    }//GEN-LAST:event_btnIngresoMateriaPrimaActionPerformed

    private void btnMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMateriaPrimaActionPerformed
        // TODO add your handling code here:
        InterfacesGraficasMateriaPrima.ejecutarNuevaVentanaMateriaPrima();
        this.dispose();
    }//GEN-LAST:event_btnMateriaPrimaActionPerformed

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
            java.util.logging.Logger.getLogger(OptionPaneMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionPaneMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionPaneMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionPaneMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OptionPaneMateriaPrima dialog = new OptionPaneMateriaPrima(new javax.swing.JFrame(), true);
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

    public JButton getBtnIngresoMateriaPrima() {
        return btnIngresoMateriaPrima;
    }

    public void setBtnIngresoMateriaPrima(JButton btnIngresoMateriaPrima) {
        this.btnIngresoMateriaPrima = btnIngresoMateriaPrima;
    }

    public JButton getBtnMateriaPrima() {
        return btnMateriaPrima;
    }

    public void setBtnMateriaPrima(JButton btnMateriaPrima) {
        this.btnMateriaPrima = btnMateriaPrima;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresoMateriaPrima;
    private javax.swing.JButton btnMateriaPrima;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
