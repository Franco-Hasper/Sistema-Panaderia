package operacionesProveedor;

import complementos.Cargar;
import escritorios.PrincipalProveedor;
import formularios.FormularioEditarProveedor;
import formularios.FormularioRegistrarProveedor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import clasesUtilidadGeneral.TextPrompt;
import principal.Main;
import principal.PrincipalAdministrador;

public class InterfacesGraficasProveedor {

    TablaProveedor t = new TablaProveedor();
    BoxesProveedor b = new BoxesProveedor();

    public void nuevaVentanaProveedor(PrincipalAdministrador p) {
        if (p.estacerrado(p.getProveedor())) {
            PrincipalProveedor m = new PrincipalProveedor();
            p.setProveedor(m);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) m.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getProveedor().remove(menupanel);
            p.getProveedor().setSize(width, Height);
             try {
                p.getEscritorio().add(p.getProveedor());
            } catch (IllegalArgumentException e) {
            }
            
            infoTextPrompt(m);
            t.ejecutarRellenarTabla(m);
            p.getProveedor().show();
        }
        colorInterfazEscritorio(p);
        p.getProveedor().toFront();
    }

    public void colorInterfazEscritorio(PrincipalAdministrador p) {
        p.getProveedor().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getProveedor().getTabla().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getProveedor().getTabla().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void nuevoFormRegistrarProveedor(FormularioRegistrarProveedor fr) {

        b.rellenarBoxesR(fr);
        infoTextPromptR(fr);
        fr.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fr.setVisible(true);
    }

    public void nuevoFormEditarProveedor(FormularioEditarProveedor fe) {
        int fila = Main.getPrincipalAdmin().getProveedor().getTabla().getSelectedRow();
        fe.getLblID().setText(Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla().toString());
        fe.getTxteditarNombre().setText(Main.getPrincipalAdmin().getProveedor().getTabla().getValueAt(fila, 0).toString());
        infoTextPromptE(fe);
        fe.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fe.setVisible(true);
    }

    public void infoTextPromptE(FormularioEditarProveedor fe) {
        TextPrompt nombre = new TextPrompt("NOMBRE", fe.getTxteditarNombre());
        fe.getTxteditarNombre().grabFocus();
    }

    public void infoTextPromptR(FormularioRegistrarProveedor fr) {
        TextPrompt nombre = new TextPrompt("NOMBRE", fr.getTxtNombre());
        TextPrompt direccion = new TextPrompt("DIRECCION", fr.getTxtDireccion());
        TextPrompt numeroDir = new TextPrompt("N° DIREICCION", fr.getTxtnuemroDireccion());
        TextPrompt telefono = new TextPrompt("N° TELEFONO", fr.getTxtTelefono());
        fr.getTxtNombre().grabFocus();
    }

    public void infoTextPrompt(PrincipalProveedor p) {
        new TextPrompt("BUSCAR POR NOMBRE", p.getTxtBuscar());
        p.getTxtBuscar().grabFocus();
    }

    public boolean verificarFilaSeleccionadaProveedor() {
        try {
            int fila = Main.getPrincipalAdmin().getProveedor().getTabla().getSelectedRow();
            Main.getPrincipalAdmin().getProveedor().getTabla().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    /*----------------------------SECCION MULIHILO--------------------------*/
    public static InterfacesGraficasProveedor i = new InterfacesGraficasProveedor();
    public static Cargar c = new Cargar();

    public static void ejecutarNuevaVentanaProveedor() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaCargando());
        exe.execute(new TareaProveedor());
    }

    public static class TareaProveedor implements Runnable {

        @Override
        public void run() {
            try {
                i.nuevaVentanaProveedor(Main.getPrincipalAdmin());
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
