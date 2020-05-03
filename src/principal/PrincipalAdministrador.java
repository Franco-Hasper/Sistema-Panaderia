package principal;

import complementos.Cargar;
import escritorios.PrincipalCaja;
import escritorios.PrincipalCliente;
import escritorios.PrincipalConfiguracion;
import escritorios.PrincipalCuenta;
import escritorios.PrincipalDireccion;
import escritorios.PrincipalProveedor;
import escritorios.PrincipalGastos;
import escritorios.PrincipalIngresoMatPrima;
import escritorios.PrincipalMateriaPrima;
import escritorios.PrincipalVentas;
import escritorios.PrincipalProducto;
import escritorios.PrincipalTelefono;
import formularios.FormularioEditarVenta;
import formularios.FormularioRegistrarVenta;
import formularios.FormularioWebAFIP;
import complementos.OptionPaneMateriaPrima;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import operacionesCaja.InterfacesGraficasCaja;
import operacionesCliente.InterfacesGraficasCliente;
import operacionesConfiguracion.InterfacesGraficasConfiguracion;
import operacionesGasto.InterfacesGraficasGastos;
import operacionesProducto.InterfacesGraficasProducto;
import operacionesProveedor.InterfacesGraficasProveedor;
import operacionesVenta.InterfacesGraficasVenta;

/**
 *
 * @author TELCOM MPC
 */
public class PrincipalAdministrador extends javax.swing.JFrame {

    public PrincipalAdministrador() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    private boolean minimiza = false;
    public boolean cerra = false;

    // 
    private PrincipalMateriaPrima matprima = null;
    public PrincipalIngresoMatPrima ingmatprima = null;
    public PrincipalCliente cliente = null;
    public PrincipalCuenta cuenta = null;
    public PrincipalProveedor proveedor = null;
    public PrincipalProducto producto = null;
    public PrincipalGastos gastos = null;
    public PrincipalVentas ventas = null;
    public PrincipalCaja caja = null;
    public PrincipalConfiguracion configuracion = null;
    public Cargar cargar = null;
    public FormularioWebAFIP webAFIP = null;
    public PrincipalDireccion direccion = null;
    public PrincipalTelefono telefono = null;
    private FormularioRegistrarVenta registrarVentas = null;
    private FormularioEditarVenta editarVentas = null;

    public boolean estacerrado(Object obj) {
        JInternalFrame[] activos = getEscritorio().getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {
                cerrado = false;
                cerra = false;
            }
            i++;
        }
        return cerrado;
    }

    public Escritorio getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(Escritorio escritorio) {
        this.escritorio = escritorio;
    }

    public PrincipalMateriaPrima getMatprima() {
        return matprima;
    }

    public void setMatprima(PrincipalMateriaPrima matprima) {
        this.matprima = matprima;
    }

    public PrincipalIngresoMatPrima getIngmatprima() {
        return ingmatprima;
    }

    public void setIngmatprima(PrincipalIngresoMatPrima ingmatprima) {
        this.ingmatprima = ingmatprima;
    }

    public PrincipalCliente getCliente() {
        return cliente;
    }

    public void setCliente(PrincipalCliente cliente) {
        this.cliente = cliente;
    }

    public PrincipalCuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(PrincipalCuenta cuenta) {
        this.cuenta = cuenta;
    }

    public PrincipalProveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(PrincipalProveedor proveedor) {
        this.proveedor = proveedor;
    }

    public PrincipalProducto getProducto() {
        return producto;
    }

    public void setProducto(PrincipalProducto producto) {
        this.producto = producto;
    }

    public PrincipalGastos getGastos() {
        return gastos;
    }

    public void setGastos(PrincipalGastos gastos) {
        this.gastos = gastos;
    }

    public PrincipalVentas getVentas() {
        return ventas;
    }

    public void setVentas(PrincipalVentas ventas) {
        this.ventas = ventas;
    }

    public PrincipalCaja getCaja() {
        return caja;
    }

    public void setCaja(PrincipalCaja caja) {
        this.caja = caja;
    }

    public PrincipalConfiguracion getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(PrincipalConfiguracion configuracion) {
        this.configuracion = configuracion;
    }

    public Cargar getCargar() {
        return cargar;
    }

    public void setCargar(Cargar cargar) {
        this.cargar = cargar;
    }

    public FormularioWebAFIP getWebAFIP() {
        return webAFIP;
    }

    public void setWebAFIP(FormularioWebAFIP webAFIP) {
        this.webAFIP = webAFIP;
    }

    public PrincipalDireccion getDireccion() {
        return direccion;
    }

    public void setDireccion(PrincipalDireccion direccion) {
        this.direccion = direccion;
    }

    public PrincipalTelefono getTelefono() {
        return telefono;
    }

    public void setTelefono(PrincipalTelefono telefono) {
        this.telefono = telefono;
    }

    public FormularioRegistrarVenta getRegistrarVentas() {
        return registrarVentas;
    }

    public void setRegistrarVentas(FormularioRegistrarVenta registrarVentas) {
        this.registrarVentas = registrarVentas;
    }

    public FormularioEditarVenta getEditarVentas() {
        return editarVentas;
    }

    public void setEditarVentas(FormularioEditarVenta editarVentas) {
        this.editarVentas = editarVentas;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_1_secundario = new javax.swing.JPanel();
        panel_1_primario = new javax.swing.JPanel();
        lblLibre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel_2_secundario = new javax.swing.JPanel();
        btnGestionVentas = new principal.MaterialButtomRectangle();
        btnGestionMateriPrima = new principal.MaterialButtomRectangle();
        btnGestionProducto = new principal.MaterialButtomRectangle();
        btnGestionProveedor = new principal.MaterialButtomRectangle();
        btnGestionCliente = new principal.MaterialButtomRectangle();
        btnGestionFinanzas = new principal.MaterialButtomRectangle();
        btnGestionGastos = new principal.MaterialButtomRectangle();
        btnConfiguracion = new principal.MaterialButtomRectangle();
        escritorio = new principal.Escritorio();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_1_secundario.setBackground(new java.awt.Color(255, 255, 255));

        panel_1_primario.setBackground(new java.awt.Color(142, 131, 54));

        lblLibre.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VENTA DOLAR LIBRE:");

        javax.swing.GroupLayout panel_1_primarioLayout = new javax.swing.GroupLayout(panel_1_primario);
        panel_1_primario.setLayout(panel_1_primarioLayout);
        panel_1_primarioLayout.setHorizontalGroup(
            panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_1_primarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLibre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_1_primarioLayout.setVerticalGroup(
            panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_1_primarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_1_primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLibre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panel_2_secundario.setBackground(new java.awt.Color(255, 255, 255));
        panel_2_secundario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));

        btnGestionVentas.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionVentas.setText("VENTAS y PEDIDOS");
        btnGestionFinanzas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionVentasActionPerformed(evt);
            }
        });

        btnGestionMateriPrima.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionMateriPrima.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionMateriPrima.setText("GESTIONAR MATERIA PRIMA");
        btnGestionMateriPrima.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionMateriPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionMateriPrimaActionPerformed(evt);
            }
        });

        btnGestionProducto.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionProducto.setText("GESTION DE PRODUCTO");
        btnGestionProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionProductoActionPerformed(evt);
            }
        });

        btnGestionProveedor.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionProveedor.setText("GESTION DE PROVEEDOR");
        btnGestionProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionProveedorActionPerformed(evt);
            }
        });

        btnGestionCliente.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionCliente.setText("GESTION DE CLIENTE");
        btnGestionCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionClienteActionPerformed(evt);
            }
        });

        btnGestionFinanzas.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionFinanzas.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionFinanzas.setText("CAJA");
        btnGestionFinanzas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionFinanzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionFinanzasActionPerformed(evt);
            }
        });

        btnGestionGastos.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionGastos.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionGastos.setText("GASTOS");
        btnGestionGastos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionGastosActionPerformed(evt);
            }
        });

        btnConfiguracion.setBackground(new java.awt.Color(177, 159, 65));
        btnConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        btnConfiguracion.setText("CONFIGURACION");
        btnConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_2_secundarioLayout = new javax.swing.GroupLayout(panel_2_secundario);
        panel_2_secundario.setLayout(panel_2_secundarioLayout);
        panel_2_secundarioLayout.setHorizontalGroup(
            panel_2_secundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_2_secundarioLayout.createSequentialGroup()
                .addGroup(panel_2_secundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGestionVentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnGestionFinanzas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnConfiguracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnGestionProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnGestionProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnGestionCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnGestionGastos, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnGestionMateriPrima, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_2_secundarioLayout.setVerticalGroup(
            panel_2_secundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_2_secundarioLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnGestionMateriPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnGestionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnGestionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnGestionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnGestionGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnGestionVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnGestionFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_1_secundarioLayout = new javax.swing.GroupLayout(panel_1_secundario);
        panel_1_secundario.setLayout(panel_1_secundarioLayout);
        panel_1_secundarioLayout.setHorizontalGroup(
            panel_1_secundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_1_primario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_1_secundarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_2_secundario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_1_secundarioLayout.setVerticalGroup(
            panel_1_secundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_1_secundarioLayout.createSequentialGroup()
                .addComponent(panel_1_primario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_1_secundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_2_secundario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_1_secundario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_1_secundario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //menu de pedidos
    private void btnGestionVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionVentasActionPerformed
        // TODO add your handling code here:  
        InterfacesGraficasVenta.ejecutarNuevaVentanaVenta();
    }//GEN-LAST:event_btnGestionVentasActionPerformed

    //menu de materia prima
    private void btnGestionMateriPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionMateriPrimaActionPerformed
        // TODO add your handling code here:
        OptionPaneMateriaPrima o = new OptionPaneMateriaPrima(this, true);
        o.setVisible(true);
    }//GEN-LAST:event_btnGestionMateriPrimaActionPerformed

    private void btnGestionProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionProductoActionPerformed
        // TODO add your handling code here:
        InterfacesGraficasProducto.ejecutarNuevaVentanaProducto();
    }//GEN-LAST:event_btnGestionProductoActionPerformed

    private void btnGestionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionProveedorActionPerformed
        // TODO add your handling code here:
        InterfacesGraficasProveedor.ejecutarNuevaVentanaProveedor();
    }//GEN-LAST:event_btnGestionProveedorActionPerformed

    private void btnGestionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionClienteActionPerformed
        // TODO add your handling code here:
        InterfacesGraficasCliente.ejecutarNuevaVentanaCliente();
    }//GEN-LAST:event_btnGestionClienteActionPerformed

    private void btnGestionFinanzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionFinanzasActionPerformed
        // TODO add your handling code here:
        InterfacesGraficasCaja.ejecutarNuevaVentanaCaja();
    }//GEN-LAST:event_btnGestionFinanzasActionPerformed

    private void btnGestionGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionGastosActionPerformed
        // TODO add your handling code here:
        InterfacesGraficasGastos.ejecutarNuevaVentanaGasto();
    }//GEN-LAST:event_btnGestionGastosActionPerformed

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        // TODO add your handling code here:
        InterfacesGraficasConfiguracion.ejecutarNuevaVentanaGasto();
    }//GEN-LAST:event_btnConfiguracionActionPerformed

    public JPanel getPanel_1_primario() {
        return panel_1_primario;
    }

    public void setPanel_1_primario(JPanel panel_1_primario) {
        this.panel_1_primario = panel_1_primario;
    }

    public JPanel getPanel_1_secundario() {
        return panel_1_secundario;
    }

    public void setPanel_1_secundario(JPanel panel_1_secundario) {
        this.panel_1_secundario = panel_1_secundario;
    }

    public JPanel getPanel_2_secundario() {
        return panel_2_secundario;
    }

    public void setPanel_2_secundario(JPanel panel_2_secundario) {
        this.panel_2_secundario = panel_2_secundario;
    }

    public MaterialButtomRectangle getBtnConfiguracion() {
        return btnConfiguracion;
    }

    public void setBtnConfiguracion(MaterialButtomRectangle btnConfiguracion) {
        this.btnConfiguracion = btnConfiguracion;
    }

    public MaterialButtomRectangle getBtnGestionCliente() {
        return btnGestionCliente;
    }

    public void setBtnGestionCliente(MaterialButtomRectangle btnGestionCliente) {
        this.btnGestionCliente = btnGestionCliente;
    }

    public MaterialButtomRectangle getBtnGestionFinanzas() {
        return btnGestionFinanzas;
    }

    public void setBtnGestionFinanzas(MaterialButtomRectangle btnGestionFinanzas) {
        this.btnGestionFinanzas = btnGestionFinanzas;
    }

    public MaterialButtomRectangle getBtnGestionMateriPrima() {
        return btnGestionMateriPrima;
    }

    public void setBtnGestionMateriPrima(MaterialButtomRectangle btnGestionMateriPrima) {
        this.btnGestionMateriPrima = btnGestionMateriPrima;
    }

    public MaterialButtomRectangle getBtnGestionPedidos() {
        return btnGestionVentas;
    }

    public void setBtnGestionPedidos(MaterialButtomRectangle btnGestionPedidos) {
        this.btnGestionVentas = btnGestionPedidos;
    }

    public MaterialButtomRectangle getBtnGestionGastos() {
        return btnGestionGastos;
    }

    public void setBtnGestionGastos(MaterialButtomRectangle btnGestionGastos) {
        this.btnGestionGastos = btnGestionGastos;
    }

    public MaterialButtomRectangle getBtnGestionProducto() {
        return btnGestionProducto;
    }

    public void setBtnGestionProducto(MaterialButtomRectangle btnGestionProducto) {
        this.btnGestionProducto = btnGestionProducto;
    }

    public MaterialButtomRectangle getBtnGestionProveedor() {
        return btnGestionProveedor;
    }

    public void setBtnGestionProveedor(MaterialButtomRectangle btnGestionProveedor) {
        this.btnGestionProveedor = btnGestionProveedor;
    }

    public JLabel getLblLibre() {
        return lblLibre;
    }

    public void setLblLibre(JLabel lblLibre) {
        this.lblLibre = lblLibre;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButtomRectangle btnConfiguracion;
    private principal.MaterialButtomRectangle btnGestionCliente;
    private principal.MaterialButtomRectangle btnGestionFinanzas;
    private principal.MaterialButtomRectangle btnGestionGastos;
    private principal.MaterialButtomRectangle btnGestionMateriPrima;
    private principal.MaterialButtomRectangle btnGestionProducto;
    private principal.MaterialButtomRectangle btnGestionProveedor;
    private principal.MaterialButtomRectangle btnGestionVentas;
    private principal.Escritorio escritorio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblLibre;
    private javax.swing.JPanel panel_1_primario;
    private javax.swing.JPanel panel_1_secundario;
    private javax.swing.JPanel panel_2_secundario;
    // End of variables declaration//GEN-END:variables
}
