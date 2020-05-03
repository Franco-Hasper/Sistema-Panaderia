package operacionesVenta;

import clasesUtilidadGeneral.SwingBrowser;
import complementos.Cargar;
import escritorios.PrincipalVentas;
import formularios.FormularioDetalleDeVenta;
import formularios.FormularioEditarVenta;
import formularios.FormularioEstadoVenta;
import formularios.FormularioRegistrarVenta;
import formularios.FormularioWebAFIP;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import clasesUtilidadGeneral.OperacionesUtiles;
import clasesUtilidadGeneral.TextPrompt;
import principal.Main;
import principal.PrincipalAdministrador;

/**
 *
 * @author TELCOM MPC
 */
public class InterfacesGraficasVenta {

    TablaVenta t = new TablaVenta();
    OperacionesUtiles oU = new OperacionesUtiles();
    BoxesVenta b = new BoxesVenta();
    OperacionesSecundariasVenta ot = new OperacionesSecundariasVenta();

    public void nuevaVentanaVentas(PrincipalAdministrador p) {
        if (p.estacerrado(p.getVentas())) {
            try {
                PrincipalVentas v = new PrincipalVentas();
                p.setVentas(v);
                BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) v.getUI()).getNorthPane();
                int width = p.getEscritorio().getWidth();
                int Height = p.getEscritorio().getHeight();
                p.getVentas().remove(menupanel);
                p.getVentas().setSize(width, Height);
                try {
                    p.getEscritorio().add(p.getVentas());
                } catch (IllegalArgumentException e) {
                }
                infoTextPrompt(v);
                t.ejecutarRellenarTabla(v);
                p.getVentas().show();
            } catch (ClassCastException e) {
            }
        }
        colorInterfazEscritorio(p);
        p.getVentas().toFront();
    }

    public void nuevoFormularioWebAFIP(PrincipalAdministrador p) {
        if (p.estacerrado(p.getWebAFIP())) {
            FormularioWebAFIP m = new FormularioWebAFIP();
            p.setWebAFIP(m);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) m.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getWebAFIP().remove(menupanel);
            p.getWebAFIP().setSize(width, Height);
            try {
                p.getEscritorio().add(p.getWebAFIP());
            } catch (IllegalArgumentException e) {
            }
            p.getWebAFIP().show();
        }
        insertarPagina(p);
        p.getWebAFIP().toFront();
    }

    //reproductor de musica  
    private void insertarPagina(PrincipalAdministrador p) {
        SwingBrowser browser = new SwingBrowser();
        browser.loadURL("https://auth.afip.gob.ar/contribuyente_/login.xhtml");
        browser.setBounds(1, 1, p.getWebAFIP().getJPanel().getWidth() - 1, p.getWebAFIP().getJPanel().getHeight() - 1);
        p.getWebAFIP().getJPanel().add(browser);
    }

    public void colorInterfazEscritorio(PrincipalAdministrador p) {
        p.getVentas().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getVentas().getTabla().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getVentas().getTabla().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void nuevaFormularioRegistrarVenta(PrincipalAdministrador p) {
        if (p.estacerrado(p.getRegistrarVentas())) {
            FormularioRegistrarVenta f = new FormularioRegistrarVenta();
            p.setRegistrarVentas(f);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) f.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getRegistrarVentas().remove(menupanel);
            p.getRegistrarVentas().setSize(width, Height);
            p.getEscritorio().add(p.getRegistrarVentas());
            b.rellenarBoxesR(f);
            infoTextPrompt(f);
            t.ejecutarRellenarTablaProductoSinFecha(f);
            colorInterfaz(f);
            p.getRegistrarVentas().show();
        }

        p.getRegistrarVentas().toFront();
    }

    public void colorInterfaz(FormularioRegistrarVenta f) {
        f.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getBtnBuscarCliente().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getBtnAgregar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getBtnQuitar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getrSDateChooser().setColorBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getrSDateChooser().setColorButtonHover(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getTablaBuscarProducto().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getTablaBuscarProducto().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getTablaCliente().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getTablaCliente().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getTablaListarProductos().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getTablaListarProductos().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());

    }

    public void colorInterfaz(FormularioEditarVenta f) {
        f.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getBtnBuscarCliente().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getBtnAgregar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getBtnQuitar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getrSDateChooser().setColorBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getrSDateChooser().setColorButtonHover(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getTablaBuscarProducto().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getTablaBuscarProducto().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getTablaCliente().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getTablaCliente().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getTablaListarProductos().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getTablaListarProductos().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void nuevoFormEditarVenta(PrincipalAdministrador p) {
        if (p.estacerrado(p.getEditarVentas())) {
            FormularioEditarVenta f = new FormularioEditarVenta();
            p.setEditarVentas(f);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) f.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getEditarVentas().remove(menupanel);
            p.getEditarVentas().setSize(width, Height);
            p.getEscritorio().add(p.getEditarVentas());
            b.rellenarBoxesE(f);
            infoTextPrompt(f);
            t.ejecutarRellenarTablaProductoSinFecha(f);
            t.ejecutarRellenarDatosEditarVenta(f);
            colorInterfaz(f);
            p.getEditarVentas().show();
            ot.obtenerPrecioTotal(f);
        }

        p.getEditarVentas().toFront();
    }

    public void deshabilitarBotonesIfIsVentaSimple(FormularioEstadoVenta f) {
        int fila = Main.getPrincipalAdmin().getVentas().getTabla().getSelectedRow();
        if (Main.getPrincipalAdmin().getVentas().getTabla().getValueAt(fila, 3).toString().equals("venta simple")) {
            f.getBtnCancelado().setEnabled(false);
            f.getBtnPendiente().setEnabled(false);
            f.getBtnRealizado().setEnabled(false);
        }
    }

    public void nuevoFormularioDetalleDeVenta(FormularioDetalleDeVenta f) {
        oU.centrarVentana(f);
        f.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        t.ejecutarRellenarDetalleDeVenta(f);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }

    public void nuevoFormularioEstadoVenta(FormularioEstadoVenta f) {
        oU.centrarVentana(f);
        deshabilitarBotonesIfIsVentaSimple(f);
        f.getLblC().setVisible(false);
        f.getLblE().setVisible(false);
        f.getLblP().setVisible(false);
        f.getLblR().setVisible(false);
        f.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.setVisible(true);

    }

    public void seleccionElminar(FormularioEstadoVenta f) {
        f.getLblC().setVisible(false);
        f.getLblE().setVisible(true);
        f.getLblP().setVisible(false);
        f.getLblR().setVisible(false);
    }

    public void seleccionCancelar(FormularioEstadoVenta f) {
        f.getLblC().setVisible(true);
        f.getLblE().setVisible(false);
        f.getLblP().setVisible(false);
        f.getLblR().setVisible(false);
    }

    public void seleccionPendiente(FormularioEstadoVenta f) {
        f.getLblC().setVisible(false);
        f.getLblE().setVisible(false);
        f.getLblP().setVisible(true);
        f.getLblR().setVisible(false);
    }

    public void seleccionRealizado(FormularioEstadoVenta f) {
        f.getLblC().setVisible(false);
        f.getLblE().setVisible(false);
        f.getLblP().setVisible(false);
        f.getLblR().setVisible(true);
    }

    public void infoTextPrompt(FormularioRegistrarVenta fr) {
        new TextPrompt("BUSCAR PRODUCTO", fr.getTxtBuscar());
        new TextPrompt("CANTIDAD DE UNIDADES", fr.getTxtCantidad());
        fr.getTxtBuscar().grabFocus();
    }

    public void infoTextPrompt(FormularioEditarVenta fr) {
        new TextPrompt("BUSCAR PRODUCTO", fr.getTxtBuscar());
        new TextPrompt("CANTIDAD DE UNIDADES", fr.getTxtCantidad());
        new TextPrompt("BUSCAR EN PRODUCTOS LISTADOS", fr.getTxtBuscarEnLista());
        fr.getTxtBuscar().grabFocus();
    }

    public void infoTextPrompt(PrincipalVentas p) {
        new TextPrompt("BUSCAR POR FECHA, FORMATO (AAAA-MM-DD)", p.getTxtBuscar());
        p.getTxtBuscar().grabFocus();
    }

    public boolean verificarFilaSeleccionadaVenta() {

        try {
            int fila = Main.getPrincipalAdmin().getVentas().getTabla().getSelectedRow();
            Main.getPrincipalAdmin().getVentas().getTabla().getValueAt(fila, 0).toString();

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

    }

    /*----------------------------SECCION MULIHILO--------------------------*/
    public static InterfacesGraficasVenta i = new InterfacesGraficasVenta();
    public static Cargar c = new Cargar(null, true);

    public static void ejecutarNuevaVentanaVenta() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaCargando());
        exe.execute(new TareaVenta());
    }

    public static void ejecutarNuevaVentanaVentaWeb() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaVentanaWeb());
    }

    public static class TareaVentanaWeb implements Runnable {

        @Override
        public void run() {
            try {
                i.nuevoFormularioWebAFIP(Main.getPrincipalAdmin());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static class TareaVenta implements Runnable {

        @Override
        public void run() {
            try {
                i.nuevaVentanaVentas(Main.getPrincipalAdmin());
                c.cerrarDialogCargar();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static class TareaCargando implements Runnable {

        @Override
        public void run() {
            try {
                c.ejecutatDialogCargar();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
