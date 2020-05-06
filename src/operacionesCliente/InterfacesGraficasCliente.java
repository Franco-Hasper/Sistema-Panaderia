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
 * @author Hasper Franco
 */
public class InterfacesGraficasCliente {

    BoxesCliente b = new BoxesCliente();
    TablaCliente t = new TablaCliente();

    /**
     * Crea una nuea instancia para la clase PrincipalCliente (intefaz grafica).
     *
     * @param p
     */
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

    /**
     * Crea una nuea instancia para la clase FormularioRegistrarCliente (intefaz
     * grafica).
     *
     * @param fr
     */
    public void nuevoFormRegistrarCliente(FormularioRegistrarCliente fr) {
        b.rellenarBoxesR(fr);
        infoTextPrompt(fr);
        fr.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fr.setVisible(true);
    }

    /**
     * Añade el texto de fondo al los labels del formulario registrar cliente.
     *
     * @param fr
     */
    public void infoTextPrompt(FormularioRegistrarCliente fr) {
        new TextPrompt("NOMBRE", fr.getTxtNombre());
        new TextPrompt("APELLIDO", fr.getTxtApellido());
        new TextPrompt("DIRECCION", fr.getTxtDireccion());
        new TextPrompt("RAZON SOCIAL", fr.getTxtRazonSocial());
        new TextPrompt("TELEFONO", fr.getTxtTelefono());
        new TextPrompt("NUMERO DE DIRECCION", fr.getTxtnuemroDireccion());
        fr.getTxtNombre().grabFocus();
    }

    /**
     * Añade el texto de fondo al buscador de la ventana PrincipalCliente.
     *
     * @param p
     */
    public void infoTextPrompt(PrincipalCliente p) {
        new TextPrompt("BUSCAR POR NOMBRE", p.getTxtBuscar());
        p.getTxtBuscar().grabFocus();
    }

    /**
     * Crea una nuea instancia para la clase FormularioRegistrarDireccion
     * (intefaz grafica).
     *
     * @param fr
     */
    public void nuevoFormRegistrarDireccionCliente(FormularioRegistrarDireccion fr) {
        b.rellenarBoxesRD(fr);
        fr.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fr.setVisible(true);
    }

    /**
     * Crea una nuea instancia para la clase FormularioEditarCliente (intefaz
     * grafica).
     *
     * @param fe
     */
    public void nuevoFormEditarCliente(FormularioEditarCliente fe) {
        int fila = Main.getPrincipalAdmin().getCliente().getTabla().getSelectedRow();
        fe.getTxtNombre().setText(Main.getPrincipalAdmin().getCliente().getTabla().getValueAt(fila, 0).toString());
        fe.getTxtApellido().setText(Main.getPrincipalAdmin().getCliente().getTabla().getValueAt(fila, 1).toString());
        fe.getTxtRazonSocial().setText(Main.getPrincipalAdmin().getCliente().getTabla().getValueAt(fila, 2).toString());
        fe.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fe.setVisible(true);
    }

    /**
     * Modifica el color de los elementos en la ventana PrincipalCliente segun
     * el color de PrincipalAdministador panel.
     *
     * @param p
     */
    public void colorInterfazEscritorio(PrincipalAdministrador p) {
        p.getCliente().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCliente().getTabla().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCliente().getTabla().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    /**
     * Retorna true si la tabla de PrincipalCliente tiene una fila seleccionada,
     * de lo contrario retorna false.
     *
     * @return
     */
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

    /**
     * Crea 2 hilos para ejecutar un dialog cargando mientras la se inica la
     * ventana PrincipalCliente.
     */
    public static void ejecutarNuevaVentanaCliente() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaCargando());
        exe.execute(new TareaCliente());
    }

    /**
     * Crea una nueva tarea que ejcuta el metodo nuevaVentanCliente, una vez
     * terminada cierra el dialog cargando.
     */
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

    /**
     * Crea una nueva tarea que ejcuta el metodo ejecutarDialogcargar.
     */
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
