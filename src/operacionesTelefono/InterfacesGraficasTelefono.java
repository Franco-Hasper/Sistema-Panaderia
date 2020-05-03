package operacionesTelefono;

import operacionesCliente.*;
import complementos.Cargar;
import conexion.ConexionHibernate;
import entidades.Cliente;
import entidades.Proveedor;
import escritorios.PrincipalTelefono;
import formularios.FormularioEditarTelefono;
import formularios.FormularioRegistrarTelefono;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import clasesUtilidadGeneral.TextPrompt;
import org.hibernate.Session;
import principal.Main;
import principal.PrincipalAdministrador;

/**
 *
 * @author TELCOM MPC
 */
public class InterfacesGraficasTelefono {

    String entidad;

    BoxesCliente b = new BoxesCliente();
    TablaTelefono t = new TablaTelefono();

    public void ejecutarnuevaVentanaTelefono(PrincipalAdministrador p, String entidad) {

        switch (entidad) {
            case "proveedor":
                setEntidad(entidad);
                neuvaVentanaProveedorTelefono(p, entidad);
                break;
            case "cliente":
                setEntidad(entidad);
                neuvaVentanaClienteTelefono(p, entidad);
                break;
        }

    }

    public void neuvaVentanaProveedorTelefono(PrincipalAdministrador p, String entidad) {
        if (verificarFilaSeleccionadaProveedor()) {
            try {
                nuevaVentanaTelefono(p);
                rellenarLabelTelefono(entidad);
                t.ejecutarRellenarTablaTelefonoProveedor(Main.getPrincipalAdmin().getTelefono());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error al intentar cargar la ventana", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void neuvaVentanaClienteTelefono(PrincipalAdministrador p, String entidad) {
        if (verificarFilaSeleccionadaCliente()) {
            try {
                nuevaVentanaTelefono(p);
                rellenarLabelTelefono(entidad);
                t.ejecutarRellenarTablaTelefonoCliente(Main.getPrincipalAdmin().getTelefono());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error al intentar cargar la ventana", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public boolean verificarFilaSeleccionadaCliente() {
        try {
            int fila = Main.getPrincipalAdmin().getCliente().getTabla().getSelectedRow();
            Main.getPrincipalAdmin().getCliente().getTabla().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
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

    public void nuevaVentanaTelefono(PrincipalAdministrador p) {

        if (p.estacerrado(p.getTelefono())) {
            PrincipalTelefono t = new PrincipalTelefono();
            t.setEntidad(this.getEntidad());
            p.setTelefono(t);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) t.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getTelefono().remove(menupanel);
            p.getTelefono().setSize(width, Height);
            p.getEscritorio().add(p.getTelefono());
            p.getTelefono().show();
        }
        colorInterfazEscritorio(p);
        p.getTelefono().toFront();
    }

    public boolean verificarFilaSeleccionadaTelefono() {
        try {
            int fila = Main.getPrincipalAdmin().getTelefono().getTabla().getSelectedRow();
            Main.getPrincipalAdmin().getTelefono().getTabla().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void nuevoFormEditarTelefono(FormularioEditarTelefono fe) {
        int fila = Main.getPrincipalAdmin().getTelefono().getTabla().getSelectedRow();
        fe.getTxtTelefono().setText(Main.getPrincipalAdmin().getTelefono().getTabla().getValueAt(fila, 0).toString());
        b.rellenarBoxesET(fe);
        infoTextPrompt(fe);
        fe.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fe.setVisible(true);
    }

    public void rellenarLabelTelefono(String entidad) {
        switch (entidad) {
            case "proveedor":
                rellenarLabelTelefonoProveedor();
                break;
            case "cliente":
                rellenarLabelTelefonoCliente();
                break;
        }
    }

    public void rellenarLabelTelefonoProveedor() {
        String idProveedor = Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla().toString();
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Proveedor proveedor = (Proveedor) miSesion.get(Proveedor.class, Integer.valueOf(idProveedor));
            Main.getPrincipalAdmin().getTelefono().getLblNombre().setText(proveedor.getNombre().toString());
        } catch (Exception e) {
        }

    }

    public void rellenarLabelTelefonoCliente() {
        String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Cliente cliente = (Cliente) miSesion.get(Cliente.class, Integer.valueOf(idCliente));
            Main.getPrincipalAdmin().getTelefono().getLblNombre().setText(cliente.getNombre().toString() + " "
                    + cliente.getApellido().toString());
        } catch (Exception e) {
        }

    }

    public void nuevoFormRegistrarTelefono(FormularioRegistrarTelefono fr) {
        b.rellenarBoxesRT(fr);
        infoTextPrompt(fr);
        fr.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fr.setVisible(true);
    }

    public void infoTextPrompt(FormularioRegistrarTelefono fr) {
        TextPrompt nombre = new TextPrompt("NUMERO", fr.getTxtTelefono());
        fr.getTxtTelefono().grabFocus();
    }

    public void infoTextPrompt(FormularioEditarTelefono fr) {
        TextPrompt nombre = new TextPrompt("NUMERO", fr.getTxtTelefono());
        fr.getTxtTelefono().grabFocus();
    }

    public void colorInterfazEscritorio(PrincipalAdministrador p) {
        p.getTelefono().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getTelefono().getTabla().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getTelefono().getTabla().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        //  p.getDireccion().getBtnEliminarDir().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        // p.getDireccion().getBtnNuevoDir().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        // p.getDireccion().getBtnnEditarDir().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    /*----------------------------SECCION MULIHILO--------------------------*/
    public static InterfacesGraficasTelefono i = new InterfacesGraficasTelefono();
    public static Cargar c = new Cargar(null, true);

    public static void ejecutarNuevaVentanaTelefono() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaCargando());
        exe.execute(new TareaTelefono());
    }

    public static class TareaTelefono implements Runnable {

        @Override
        public void run() {
            try {
                i.nuevaVentanaTelefono(Main.getPrincipalAdmin());
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
