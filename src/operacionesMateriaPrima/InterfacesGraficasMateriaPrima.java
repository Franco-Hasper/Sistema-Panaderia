package operacionesMateriaPrima;

import complementos.Cargar;
import escritorios.PrincipalIngresoMatPrima;
import escritorios.PrincipalMateriaPrima;
import formularios.FormularioEditarIngresoMateriaPrima;
import formularios.FormularioEditarMateriaPrima;
import formularios.FormularioRegistrarIngresoMateriaPrima;
import formularios.FormularioRegistrarMateriaPrima;
import formularios.FormularioReporteIngresoMateriaPrima;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import clasesUtilidadGeneral.TextPrompt;
import operacionesIngresoMateriaPrima.TablaIngresoMateriaPrima;
import principal.Main;
import principal.PrincipalAdministrador;

/**
 *
 * @author TELCOM MPC
 */
public class InterfacesGraficasMateriaPrima {

    BoxesMateriaPrima b = new BoxesMateriaPrima();
    TablaMateriaPrima t = new TablaMateriaPrima();
    TablaIngresoMateriaPrima ti = new TablaIngresoMateriaPrima();

    public void nuevaVentanaMateriaPrima(PrincipalAdministrador p) {
        if (p.estacerrado(p.getMatprima())) {
            PrincipalMateriaPrima m = new PrincipalMateriaPrima();
            p.setMatprima(m);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) m.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getMatprima().remove(menupanel);
            p.getMatprima().setSize(width, Height);
            p.getEscritorio().add(p.getMatprima());
            infoTextPrompt(m);
            t.ejecutarRellenarTabla(m);
            p.getMatprima().show();
        }
        colorInterfazEscritorioM(p);
        p.getMatprima().toFront();
    }

    public void colorInterfazEscritorioM(PrincipalAdministrador p) {
        p.getMatprima().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getMatprima().getTabla().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getMatprima().getTabla().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        //p.getMatprima().getBtnEditar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        //p.getMatprima().getBtnEliminar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        //p.getMatprima().getBtnNuevoIngreso().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void nuevaVentanaIngresoMateriaPrima(PrincipalAdministrador p) {
        if (p.estacerrado(p.getIngmatprima())) {
            PrincipalIngresoMatPrima m = new PrincipalIngresoMatPrima();
            p.setIngmatprima(m);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) m.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getIngmatprima().remove(menupanel);
            p.getIngmatprima().setSize(width, Height);
            p.getEscritorio().add(p.getIngmatprima());
            infoTextPrompt(m);
            ti.ejecutarRellenarTabla(m);
            p.getIngmatprima().show();
        }
        colorInterfazEscritorioIM(p);
        p.getIngmatprima().toFront();
    }

    public void colorInterfazEscritorioIM(PrincipalAdministrador p) {
        p.getIngmatprima().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getIngmatprima().getTabla().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getIngmatprima().getTabla().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
//        p.getIngmatprima().getBtnEditar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
//        p.getIngmatprima().getBtnEliminar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void nuevoFormRegistrarMateriaPrima(FormularioRegistrarMateriaPrima fr) {
        b.rellenarBoxesR(fr);
        fr.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        infoTextPrompt(fr);
        fr.setVisible(true);
    }

    public void nuevoFormGenerarReporteIngreso(FormularioReporteIngresoMateriaPrima fr) {
        Date fecha = new Date();
        fr.getrSDateChooser().setDatoFecha(fecha);
        colorInterfaz(fr);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

    public void colorInterfaz(FormularioReporteIngresoMateriaPrima f) {
        f.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getrSDateChooser().setColorBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getrSDateChooser().setColorButtonHover(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getBtnBuscar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void nuevoFormEditarMateriaPrima(FormularioEditarMateriaPrima fe) {
        int fila = Main.getPrincipalAdmin().getMatprima().getTabla().getSelectedRow();
        fe.getTxtNombreMAteriaPrima().setText(Main.getPrincipalAdmin().getMatprima().getTabla().getValueAt(fila, 0).toString());
        b.rellenarBoxesE(fe);
        fe.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fe.setVisible(true);
    }

    public void nuevoFormularioRegistrarIngresoMateriaPrima(FormularioRegistrarIngresoMateriaPrima fri) {
        int fila = Main.getPrincipalAdmin().getMatprima().getTabla().getSelectedRow();
        fri.getTxtMatPr().setText(Main.getPrincipalAdmin().getMatprima().getTabla().getValueAt(fila, 0).toString());
        fri.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fri.setVisible(true);
    }

    public void nuevoFormEditarIngresoMateriaPrima(FormularioEditarIngresoMateriaPrima fe) {
        int fila = Main.getPrincipalAdmin().getIngmatprima().getTabla().getSelectedRow();
        fe.getTxtMatPr().setText(Main.getPrincipalAdmin().getIngmatprima().getTabla().getValueAt(fila, 0).toString());
        fe.getTxttotalEnvases().setText(Main.getPrincipalAdmin().getIngmatprima().getTabla().getValueAt(fila, 1).toString());
        fe.getTxtUdsPorEnvase().setText(Main.getPrincipalAdmin().getIngmatprima().getTabla().getValueAt(fila, 2).toString());
        fe.getTxtPrecioTotal().setText(Main.getPrincipalAdmin().getIngmatprima().getTabla().getValueAt(fila, 4).toString());
        colorInterfaz(fe);
        fe.setVisible(true);

    }

    public void colorInterfaz(FormularioEditarIngresoMateriaPrima f) {
        f.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getDateFecha().setColorBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.getDateFecha().setColorButtonHover(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void infoTextPrompt(FormularioRegistrarMateriaPrima fr) {
        new TextPrompt("NOMBRE", fr.getTxtNombre());
        fr.getTxtNombre().grabFocus();
    }

    public void infoTextPrompt(PrincipalMateriaPrima p) {
        new TextPrompt("BUSCAR POR NOMBRE", p.getTxtBuscar());
        p.getTxtBuscar().grabFocus();
    }

    public void infoTextPrompt(PrincipalIngresoMatPrima p) {
        new TextPrompt("BUSCAR POR FECHA, FORMATO (AAAA-MM-DD)", p.getTxtBuscar());
        p.getTxtBuscar().grabFocus();
    }

    public boolean verificarFilaSeleccionadaMateriaPrima() {
        try {
            int fila = Main.getPrincipalAdmin().getMatprima().getTabla().getSelectedRow();
            Main.getPrincipalAdmin().getMatprima().getTabla().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public boolean verificarFilaSeleccionadaIngresoMateriaPrima() {
        try {
            int fila = Main.getPrincipalAdmin().getIngmatprima().getTabla().getSelectedRow();
            Main.getPrincipalAdmin().getIngmatprima().getTabla().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    /*----------------------------SECCION MULIHILO--------------------------*/
    public static InterfacesGraficasMateriaPrima i = new InterfacesGraficasMateriaPrima();
    public static Cargar c = new Cargar(null, true);

    public static void ejecutarNuevaVentanaMateriaPrima() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaCargando());
        exe.execute(new TareaMateriaPrima());
    }

    public static void ejecutarNuevaVentanaIngresoMateriaPrima() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaCargando());
        exe.execute(new TareaIngresoMateriaPrima());
    }

    public static class TareaMateriaPrima implements Runnable {

        @Override
        public void run() {
            try {
                i.nuevaVentanaMateriaPrima(Main.getPrincipalAdmin());
                c.cerrarDialogCargar();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static class TareaIngresoMateriaPrima implements Runnable {

        @Override
        public void run() {
            try {
                i.nuevaVentanaIngresoMateriaPrima(Main.getPrincipalAdmin());
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
