package operacionesCliente;

import complementos.Cargar;
import escritorios.PrincipalCliente;
import formularios.FormularioEditarCliente;
import formularios.FormularioRegistrarCliente;
import formularios.FormularioRegistrarDireccion;
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
public class InterfacesGraficasCliente {

    BoxesCliente b = new BoxesCliente();
    TablaCliente t = new TablaCliente();

    public void nuevaVentanaCliente(PrincipalAdministrador p) {

        if (p.estacerrado(p.getCliente())) {
            PrincipalCliente c = new PrincipalCliente();
            p.setCliente(c);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) c.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getCliente().remove(menupanel);
            p.getCliente().setSize(width, Height);
            p.getEscritorio().add(p.getCliente());
            infoTextPrompt(c);
            t.ejecutarRellenarTabla(c);
            p.getCliente().show();
        }
        colorInterfazEscritorio(p);
        p.getCliente().toFront();
    }

    public void nuevoFormRegistrarCliente(FormularioRegistrarCliente fr) {
        b.rellenarBoxesR(fr);
        infoTextPrompt(fr);
        fr.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fr.setVisible(true);
    }

    public void infoTextPrompt(FormularioRegistrarCliente fr) {
        new TextPrompt("NOMBRE", fr.getTxtNombre());
        new TextPrompt("APELLIDO", fr.getTxtApellido());
        new TextPrompt("DIRECCION", fr.getTxtDireccion());
        new TextPrompt("RAZON SOCIAL", fr.getTxtRazonSocial());
        new TextPrompt("TELEFONO", fr.getTxtTelefono());
        new TextPrompt("NUMERO DE DIRECCION", fr.getTxtnuemroDireccion());
        fr.getTxtNombre().grabFocus();
    }

    public void infoTextPrompt(PrincipalCliente p) {
        new TextPrompt("BUSCAR POR NOMBRE", p.getTxtBuscar());
        p.getTxtBuscar().grabFocus();
    }

    public void nuevoFormRegistrarDireccionCliente(FormularioRegistrarDireccion fr) {
        b.rellenarBoxesRD(fr);
        fr.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fr.setVisible(true);
    }

    public void nuevoFormEditarCliente(FormularioEditarCliente fe) {
        int fila = Main.getPrincipalAdmin().getCliente().getTabla().getSelectedRow();
        fe.getTxtNombre().setText(Main.getPrincipalAdmin().getCliente().getTabla().getValueAt(fila, 0).toString());
        fe.getTxtApellido().setText(Main.getPrincipalAdmin().getCliente().getTabla().getValueAt(fila, 1).toString());
        fe.getTxtRazonSocial().setText(Main.getPrincipalAdmin().getCliente().getTabla().getValueAt(fila, 2).toString());
        fe.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fe.setVisible(true);
    }

    public void colorInterfazEscritorio(PrincipalAdministrador p) {
        p.getCliente().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCliente().getTabla().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCliente().getTabla().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public boolean verificarFilaSeleccionada() {
        try {
            int fila = Main.getPrincipalAdmin().getCliente().getTabla().getSelectedRow();
            Main.getPrincipalAdmin().getCliente().getTabla().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    /*----------------------------SECCION MULIHILO--------------------------*/
    public static InterfacesGraficasCliente i = new InterfacesGraficasCliente();
    public static Cargar c = new Cargar(null, true);

    public static void ejecutarNuevaVentanaCliente() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaCargando());
        exe.execute(new TareaCliente());
    }

    public static class TareaCliente implements Runnable {

        @Override
        public void run() {
            try {
                i.nuevaVentanaCliente(Main.getPrincipalAdmin());
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
