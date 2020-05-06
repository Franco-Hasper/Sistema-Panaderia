package operacionesCaja;

import complementos.Cargar;
import escritorios.PrincipalCaja;
import formularios.FormularioCorteDiario;
import formularios.FormularioEditarCorte;
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
 * @author Franco Hasper
 */
public class InterfacesGraficasCaja {

    TablaCaja t = new TablaCaja();
    OperacionesSecundarias o = new OperacionesSecundarias();

    public void nuevaVentanaCaja(PrincipalAdministrador p) {
        if (p.estacerrado(p.getCaja())) {
            PrincipalCaja c = new PrincipalCaja();
            p.setCaja(c);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) c.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getCaja().remove(menupanel);
            p.getCaja().setSize(width, Height);
            p.getEscritorio().add(p.getCaja());
            infoTextPrompt(c);
            t.ejecutarRellenarTabla(c);
            p.getCaja().show();
        }
        colorInterfazEscritorio(p);
        p.getCaja().toFront();
    }

    public void colorInterfazEscritorio(PrincipalAdministrador p) {
        p.getCaja().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCaja().getTabla().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCaja().getTabla().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void nuevoFormularioCorteCaja(FormularioCorteDiario f) {
        t.ejecutarRellenarTablaEntradas(f);
        t.ejecutarRellenarTablaSalidasGastos(f);
        t.ejecutarRellenarTablaSalidasIngresosMateriaPrima(f);
        o.calcularTotalEntradas(f);
        o.calcularTotalSalidas(f);
        o.calcularBalance(f);
        f.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        f.setVisible(true);
    }

    public boolean verificarFilaSeleccionadaCaja() {
        try {
            int fila = Main.getPrincipalAdmin().getCaja().getTabla().getSelectedRow();
            Main.getPrincipalAdmin().getCaja().getTabla().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void nuevoFormEditarCorte(FormularioEditarCorte fe) {
        infoTextPrompt(fe);
        colorInterfazEscritorioIM(fe);
        fe.setVisible(true);
    }

    public void colorInterfazEscritorioIM(FormularioEditarCorte fe) {
        fe.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fe.getrSDateChooser().setColorBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fe.getrSDateChooser().setColorButtonHover(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void infoTextPrompt(FormularioEditarCorte fr) {
        new TextPrompt("TOTAL INGRESOS", fr.getTxtTotalIngresos());
        new TextPrompt("TOTAL EGRESOS", fr.getTxtTotalEgresos());
        new TextPrompt("BALANCE", fr.getTxtBalance());
        fr.getTxtTotalIngresos().grabFocus();
    }

    public void infoTextPrompt(PrincipalCaja p) {
        new TextPrompt("BUSCAR POR FECHA, FORMATO (AAAA-MM-DD)", p.getTxtBuscar());
        p.getTxtBuscar().grabFocus();
    }


    /*----------------------------SECCION MULIHILO--------------------------*/
    public static InterfacesGraficasCaja i = new InterfacesGraficasCaja();
    public static Cargar c = new Cargar(null, true);

    public static void ejecutarNuevaVentanaCaja() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaCargando());
        exe.execute(new TareaCaja());
    }

    public static class TareaCaja implements Runnable {

        @Override
        public void run() {
            try {
                i.nuevaVentanaCaja(Main.getPrincipalAdmin());
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
