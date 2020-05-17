package operacionesDireccion;

import operacionesCliente.*;
import complementos.Cargar;
import conexion.ConexionHibernate;
import entidades.Cliente;
import entidades.Proveedor;
import escritorios.PrincipalDireccion;
import formularios.FormularioEditarDireccion;
import formularios.FormularioRegistrarDireccion;
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
public class InterfacesGraficasDireccion {

    String entidad;

    BoxesCliente b = new BoxesCliente();
    TablaDireccion t = new TablaDireccion();

    public void nuevaVentanaDireccion(PrincipalAdministrador p) {

        if (p.estacerrado(p.getDireccion())) {
            PrincipalDireccion d = new PrincipalDireccion();
            d.setEntidad(this.getEntidad());
            p.setDireccion(d);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) d.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getDireccion().remove(menupanel);
            p.getDireccion().setSize(width, Height);
                        try {
                 p.getEscritorio().add(p.getDireccion());
            } catch (IllegalArgumentException e) {
            }
           
            p.getDireccion().show();
        }
        colorInterfazEscritorio(p);
        p.getDireccion().toFront();
    }

    public boolean verificarFilaSeleccionadaDireccion() {
        try {
            int fila = Main.getPrincipalAdmin().getDireccion().getTabla().getSelectedRow();
            Main.getPrincipalAdmin().getDireccion().getTabla().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void ejecutarnuevaVentanaDireccion(PrincipalAdministrador p, String entidad) {

        switch (entidad) {
            case "proveedor":
                setEntidad(entidad);
                neuvaVentanaProveedorDireccion(p, entidad);
                break;
            case "cliente":
                setEntidad(entidad);
                neuvaVentanaClienteDireccion(p, entidad);
                break;
        }

    }

    public void neuvaVentanaProveedorDireccion(PrincipalAdministrador p, String entidad) {
        if (verificarFilaSeleccionadaProveedor()) {
            try {
                nuevaVentanaDireccion(p);
                rellenarLabelDireccion(entidad);
                t.ejecutarRellenarTablaDireccionProveedor(Main.getPrincipalAdmin().getDireccion());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error al intentar cargar la ventana", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void neuvaVentanaClienteDireccion(PrincipalAdministrador p, String entidad) {
        if (verificarFilaSeleccionadaCliente()) {
            try {
                nuevaVentanaDireccion(p);
                rellenarLabelDireccion(entidad);
                t.ejecutarRellenarTablaDireccionCliente(Main.getPrincipalAdmin().getDireccion());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error al intentar cargar la ventana", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void rellenarLabelDireccion(String entidad) {
        switch (entidad) {
            case "proveedor":
                rellenarLabelDireccionProveedor();
                break;
            case "cliente":
                rellenarLabelDireccionCliente();
                break;
        }
    }

    public void rellenarLabelDireccionProveedor() {
        String idProveedor = Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla().toString();
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Proveedor proveedor = (Proveedor) miSesion.get(Proveedor.class, Integer.valueOf(idProveedor));
            Main.getPrincipalAdmin().getDireccion().getLblNombre().setText(proveedor.getNombre().toString());
        } catch (Exception e) {
        }

    }

    public void rellenarLabelDireccionCliente() {
        String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Cliente cliente = (Cliente) miSesion.get(Cliente.class, Integer.valueOf(idCliente));
            Main.getPrincipalAdmin().getDireccion().getLblNombre().setText(cliente.getNombre().toString() + " "
                    + cliente.getApellido().toString());
        } catch (Exception e) {
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

    /**      *
     * public void ejecutarnuevaVentanaDireccion(PrincipalAdministrador p) {
     * String idCli =
     * Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
     * System.out.println(idCli); if (verificarFilaSeleccionadaCliente()) { try
     * { String idCliente =
     * Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
     * nuevaVentanaDireccion(p); rellenarLabelDireccio(idCliente);
     * t.ejecutarRellenarTablaDireccionCliente(Main.getPrincipalAdmin().getDireccion());
     * } catch (Exception e) { JOptionPane.showMessageDialog(null, "aun no hay
     * direcciones asociadas a esta cuenta", "Informacion",
     * JOptionPane.INFORMATION_MESSAGE); } }
     *
     * }
     *
     *
     */
    public void rellenarLabelDireccio(String idCliente) {
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Cliente cliente = (Cliente) miSesion.get(Cliente.class, Integer.valueOf(idCliente));
            Main.getPrincipalAdmin().getDireccion().getLblNombre().setText(cliente.getNombre().toString() + " "
                    + cliente.getApellido().toString());
        } catch (Exception e) {
        }

    }

    public void nuevoFormRegistrarDireccion(FormularioRegistrarDireccion fr) {
        b.rellenarBoxesRD(fr);
        infoTextPrompt(fr);
        fr.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fr.setVisible(true);
    }

    public void infoTextPrompt(FormularioRegistrarDireccion fr) {
        TextPrompt direcc = new TextPrompt("DIRECCION", fr.getTxtDireccion());
        TextPrompt numDir = new TextPrompt("N° DIRECCION", fr.getTxtnuemroDireccion());
        fr.getTxtDireccion().grabFocus();
    }

    public void infoTextPrompt(FormularioEditarDireccion fe) {
        TextPrompt direcc = new TextPrompt("DIRECCION", fe.getTxtDireccion());
        TextPrompt numDir = new TextPrompt("N° DIRECCION", fe.getTxtnuemroDireccion());
        fe.getTxtDireccion().grabFocus();
    }

    public void nuevoFormEditarDireccion(FormularioEditarDireccion fe) {
        int fila = Main.getPrincipalAdmin().getDireccion().getTabla().getSelectedRow();
        fe.getTxtDireccion().setText(Main.getPrincipalAdmin().getDireccion().getTabla().getValueAt(fila, 0).toString());
        fe.getTxtnuemroDireccion().setText(Main.getPrincipalAdmin().getDireccion().getTabla().getValueAt(fila, 1).toString());
        b.rellenarBoxesED(fe);
        infoTextPrompt(fe);
        fe.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        fe.setVisible(true);
    }

    public void colorInterfazEscritorio(PrincipalAdministrador p) {
        p.getDireccion().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getDireccion().getTabla().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getDireccion().getTabla().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
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
    public static InterfacesGraficasDireccion i = new InterfacesGraficasDireccion();
    public static Cargar c = new Cargar();

    public static void ejecutarNuevaVentanaDireccion() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaCargando());
        exe.execute(new TareaDireccion());
    }

    public static class TareaDireccion implements Runnable {

        @Override
        public void run() {
            try {
                i.nuevaVentanaDireccion(Main.getPrincipalAdmin());
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
