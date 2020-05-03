package operacionesProducto;

import complementos.Cargar;
import escritorios.PrincipalProducto;
import formularios.FormularioEditarProducto;
import formularios.FormularioPrecioProducto;
import formularios.FormularioRegistrarProducto;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import clasesUtilidadGeneral.TextPrompt;
import principal.Main;
import principal.PrincipalAdministrador;

/**
 *
 * @author TELCOM MPC
 */
public class InterfacesGraficasProducto {

    TablaProducto t = new TablaProducto();

    public void nuevaVentanaProducto(PrincipalAdministrador p) {

        if (p.estacerrado(p.getProducto())) {
            PrincipalProducto m = new PrincipalProducto();
            p.setProducto(m);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) m.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getProducto().remove(menupanel);
            p.getProducto().setSize(width, Height);
            p.getEscritorio().add(p.getProducto());
            infoTextPrompt(m);

            t.ejecutarRellenarTabla(m);

            p.getProducto().show();

        }
        colorInterfazEscritorio(p);
        p.getProducto().toFront();
    }

    public void colorInterfazEscritorio(PrincipalAdministrador p) {
        p.getProducto().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getProducto().getTabla().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getProducto().getTabla().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
//        p.getProducto().getBtnEditar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
//        p.getProducto().getBtnEliminar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
//        p.getProducto().getBtnNuevoPrecio().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void nuevoFormRegistrarProducto(FormularioRegistrarProducto fr) {
        fr.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        infoTextPromptR(fr);
        fr.setVisible(true);
    }

    public void nuevoFormEditarProducto(FormularioEditarProducto fe) {
        int fila = Main.getPrincipalAdmin().getProducto().getTabla().getSelectedRow();
        infoTextPromptE(fe);
        //INFORmACION OBTENDIDA DE LA TABLA Y TRASLADADA AL FORMULARIO
        //fe.getLblId().setText(Main.getPrincipalAdmin().getProducto().ObjetoTablaConDatos().getIdTabla().toString());
        //fe.getTxtNombre().setText(Main.getPrincipalAdmin().getProducto().getTabla().getValueAt(fila, 0).toString());
        //fe.getTxtDescripcion().setText(Main.getPrincipalAdmin().getProducto().getTabla().getValueAt(fila, 1).toString());
        fe.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fe.setVisible(true);
    }

    public void nuevoFormPrecioProducto(FormularioPrecioProducto fe) {
        int fila = Main.getPrincipalAdmin().getProducto().getTabla().getSelectedRow();
        infoTextPromptE(fe);
        // fe.getLblId().setText(Main.getPrincipalAdmin().getProducto().ObjetoTablaConDatos().getIdTabla().toString());
        //fe.getTxtPrecioFinal().setText(Main.getPrincipalAdmin().getProducto().getTabla().getValueAt(fila, 2).toString());
        fe.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fe.setVisible(true);
    }

    public void infoTextPromptE(FormularioEditarProducto fe) {
        new TextPrompt("NOMBRE", fe.getTxtNombre());
        new TextPrompt("DESCRIPCION", fe.getTxtDescripcion());
        fe.getTxtNombre().grabFocus();
    }

    public void infoTextPrompt(PrincipalProducto p) {
        new TextPrompt("BUSCAR POR NOMBRE", p.getTxtBuscar());
        p.getTxtBuscar().grabFocus();
    }

    public void infoTextPromptR(FormularioRegistrarProducto f) {
        new TextPrompt("NOMBRE", f.getTxtNombre());
        new TextPrompt("DESCRIPCION", f.getTxtDescripcion());
        new TextPrompt("PRECIO BRUTO", f.getTxtPrecio());
        new TextPrompt("PRECIO FINAL", f.getTxtPrecioFinal());
        f.getTxtNombre().grabFocus();
    }

    public void infoTextPromptE(FormularioPrecioProducto fe) {
        new TextPrompt("PRECIO BRUTO", fe.getTxtPrecio());
        new TextPrompt("PRECIO FINAL", fe.getTxtPrecioFinal());
        fe.getTxtPrecio().grabFocus();
    }

    public boolean verificarFilaSeleccionadaProducto() {
        try {
            int fila = Main.getPrincipalAdmin().getProducto().getTabla().getSelectedRow();
            Main.getPrincipalAdmin().getProducto().getTabla().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    /*----------------------------SECCION MULIHILO--------------------------*/
    public static InterfacesGraficasProducto i = new InterfacesGraficasProducto();
    public static Cargar c = new Cargar(null, true);

    public static void ejecutarNuevaVentanaProducto() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaCargando());

        exe.execute(new TareaProducto());

    }

    public static class TareaProducto implements Runnable {

        @Override
        public void run() {
            try {
                i.nuevaVentanaProducto(Main.getPrincipalAdmin());
                c.cerrarDialogCargar();
            } catch (Exception ex) {
            }
        }
    }

    public static class TareaCargando implements Runnable {

        @Override
        public void run() {
            try {
                c.ejecutatDialogCargar();
            } catch (Exception ex) {
            }
        }
    }

}
