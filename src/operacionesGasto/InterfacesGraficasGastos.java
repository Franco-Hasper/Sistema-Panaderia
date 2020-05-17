package operacionesGasto;

import complementos.Cargar;
import escritorios.PrincipalGastos;
import formularios.FormularioEditarGasto;
import formularios.FormularioRegistrarNuevoGasto;
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
public class InterfacesGraficasGastos {

    TablaGastos t = new TablaGastos();

    public void nuevaVentanaGastos(PrincipalAdministrador p) {
        if (p.estacerrado(p.getGastos())) {
            PrincipalGastos g = new PrincipalGastos();
            p.setGastos(g);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) g.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getGastos().remove(menupanel);
            p.getGastos().setSize(width, Height);
            try {
                 p.getEscritorio().add(p.getGastos());
            } catch (IllegalArgumentException e) {
            }
           
            infoTextPrompt(g);
            t.ejecutarRellenarTabla(g);
            p.getGastos().show();
        }
        colorInterfazEscritorio(p);
        p.getGastos().toFront();
    }

    public void colorInterfazEscritorio(PrincipalAdministrador p) {
        p.getGastos().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getGastos().getTabla().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getGastos().getTabla().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
//        p.getGastos().getBtnEditar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
//        p.getGastos().getBtnEliminar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void nuevoFormRegistrarGasto(FormularioRegistrarNuevoGasto fr) {
        infoTextPrompt(fr);
        colorInterfaz(fr);
        fr.setVisible(true);
    }

    public void colorInterfaz(FormularioRegistrarNuevoGasto f) {
        f.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getrSDateChooser().setColorBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getrSDateChooser().setColorButtonHover(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void nuevoFormEditarGasto(FormularioEditarGasto fe) {
        int fila = Main.getPrincipalAdmin().getGastos().getTabla().getSelectedRow();
        //fe.getLblId().setText(Main.getPrincipalAdmin().getGastos().ObjetoTablaConDatos().getIdTabla().toString());
        //fe.getTxtDescripcion().setText(Main.getPrincipalAdmin().getGastos().getTabla().getValueAt(fila, 0).toString());
        //fe.getTxtTotalGastado().setText(Main.getPrincipalAdmin().getGastos().getTabla().getValueAt(fila, 1).toString());
        infoTextPrompt(fe);
        colorInterfaz(fe);
        fe.setVisible(true);
    }

    public void colorInterfaz(FormularioEditarGasto f) {
        f.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getrSDateChooser1().setColorBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getrSDateChooser1().setColorButtonHover(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void infoTextPrompt(FormularioRegistrarNuevoGasto fr) {
        new TextPrompt("DESCRIPCION", fr.getTxtDescripcion());
        new TextPrompt("TOTAL GASTADO", fr.getTxtTotlaGasatado());
        fr.getTxtDescripcion().grabFocus();
    }

    public void infoTextPrompt(FormularioEditarGasto fe) {
        new TextPrompt("DESCRIPCION", fe.getTxtDescripcion());
        new TextPrompt("TOTAL GASTADO", fe.getTxtTotalGastado());
        fe.getTxtDescripcion().grabFocus();
    }

    public void infoTextPrompt(PrincipalGastos p) {
        new TextPrompt("BUSCAR POR FECHA, FORMATO (AAAA-MM-DD)", p.getTxtBuscar());
        p.getTxtBuscar().grabFocus();
    }

    public boolean verificarFilaSeleccionadaGasto() {
        try {
            int fila = Main.getPrincipalAdmin().getGastos().getTabla().getSelectedRow();
            Main.getPrincipalAdmin().getGastos().getTabla().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    /*----------------------------SECCION MULIHILO--------------------------*/
    public static InterfacesGraficasGastos i = new InterfacesGraficasGastos();
    public static Cargar c = new Cargar();

    public static void ejecutarNuevaVentanaGasto() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaCargando());
        exe.execute(new TareaGasto());
    }

    public static class TareaGasto implements Runnable {

        @Override
        public void run() {
            try {
                i.nuevaVentanaGastos(Main.getPrincipalAdmin());
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
