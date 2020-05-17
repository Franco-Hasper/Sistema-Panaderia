package operacionesCuenta;

import complementos.Cargar;
import conexion.ConexionHibernate;
import entidades.Cliente;
import entidades.Cuenta;
import escritorios.PrincipalCuenta;
import formularios.FormularioEditarMovimeinto;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import clasesUtilidadGeneral.TextPrompt;
import org.hibernate.Session;
import principal.Main;
import principal.PrincipalAdministrador;

/**
 *
 * @author Hasper Franco
 */
public class InterfacesGraficasCuenta {

    TablaCuenta t = new TablaCuenta();

    /**
     * Crea una nuea instancia para la clase PrincipalCuenta (intefaz grafica).
     * @param p 
     */
    public void nuevaVentanaCuenta(PrincipalAdministrador p) {
        if (p.estacerrado(p.getCuenta())) {
            PrincipalCuenta c = new PrincipalCuenta();
            p.setCuenta(c);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) c.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getCuenta().remove(menupanel);
            p.getCuenta().setSize(width, Height);
            try {
                p.getEscritorio().add(p.getCuenta());
            } catch (IllegalArgumentException e) {
            }
           
            infoTextPrompt(c);
            p.getCuenta().show();
        }
        colorInterfazEscritorio(p);
        p.getCuenta().toFront();
    }

    
    public void colorInterfazEscritorio(PrincipalAdministrador p) {
        p.getCuenta().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCuenta().getTabla().setForeground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCuenta().getTabla().setSelectionBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCuenta().getBtnGuardarCuenta().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCuenta().getBtnGuardarMovimiento().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCuenta().getBtnNuevaCuenta().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCuenta().getBtnNuevoMovimiento().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCuenta().getBtnEliminarMov().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getCuenta().getBtnnEditarMov().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

    public void rellenarBoxCuenta(String idCliente) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Cliente cliente = (Cliente) miSesion.get(Cliente.class, Integer.valueOf(idCliente));
            List<Cuenta> listaC
                    = (List<Cuenta>) miSesion.createQuery("from Cuenta").list();
            for (Cuenta c : listaC) {
                if (c.getCodigoCliente().getIdCliente().equals(cliente.getIdCliente())) {
                    Main.getPrincipalAdmin().getCuenta().getBoxCuenta().addItem(c.getIdCuenta().toString());
                }
            }

        } catch (Exception e) {
        }

    }

    public boolean verificarFilaSeleccionadaCuentaEliminar() {
        try {
            int fila = Main.getPrincipalAdmin().getCuenta().getTabla().getSelectedRow();
            if (fila == 0) {
                JOptionPane.showMessageDialog(null, "El monto inicial no puede ser eliminado, solamente se puede editar", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            Main.getPrincipalAdmin().getCuenta().getTabla().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public boolean verificarFilaSeleccionadaCuenta() {
        try {
            int fila = Main.getPrincipalAdmin().getCuenta().getTabla().getSelectedRow();
            Main.getPrincipalAdmin().getCuenta().getTabla().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public boolean verficarClienteNoconsumidorFinal(Integer botonSeleccionado) {
        Integer idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla();
        if (idCliente.equals(1)) {
            switch (botonSeleccionado) {
                case 1:
                    JOptionPane.showMessageDialog(null, "No se puede eliminar ni editar 'Consumidor Final' ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                case 2:
                    JOptionPane.showMessageDialog(null, "El cliente 'Consumidor Final' no puede abrir una cuenta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    return false;
            }
            return false;
        } else {
            return true;
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

    public void ejecutarnuevaVentanaCuenta(PrincipalAdministrador p) {
        if (verificarFilaSeleccionadaCliente()) {
            try {
                String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
                nuevaVentanaCuenta(p);
                rellenarBoxCuenta(idCliente);
                t.ejecutarRellenarTablaCuenta(Main.getPrincipalAdmin().getCuenta());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Este cliente aún no abrió ninguna cuenta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public void habilitarNuevaCuenta(PrincipalCuenta p) {
       
        p.getTxtMontoInicial().setEnabled(true);
        p.getBtnGuardarCuenta().setEnabled(true);
    }

    public void nuevoFormEditarMovimiento(FormularioEditarMovimeinto fe) {
        infoTextPrompt(fe);
        fe.getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        Integer filaSeleccionada = Main.getPrincipalAdmin().getCuenta().getTabla().getSelectedRow();
        if (filaSeleccionada.equals(0)) {
            fe.getTxtMotivo().setEnabled(false);
        }
        fe.setEnabled(true);
    }

    
    
    
    
    
     public void infoTextPrompt(PrincipalCuenta p) {
        new TextPrompt("MONTO INICAL", p.getTxtMontoInicial());
        new TextPrompt("MONTO", p.getTxtMonto());
        new TextPrompt("BUSCAR POR FECHA, FORMATO (AAAA-MM-DD)", p.getTxtBuscarHistorial());
        p.getTxtBuscarHistorial().grabFocus();
      
    }
    
    
    
    
    public void infoTextPrompt(FormularioEditarMovimeinto fe) {
        new TextPrompt("MOTIVO", fe.getTxtMotivo());
        new TextPrompt("MONTO", fe.getTxtMonto());
        fe.getTxtMotivo().grabFocus();
    }

 

    public void habilitarNuevoMovimiento(PrincipalCuenta p) {
        System.out.println(p.getBoxCuenta().getSelectedItem());

        if (p.getBoxCuenta().getSelectedItem() == (null)) {
            showMessageDialog(null, "Este cliente aún no abrió ninguna cuenta, "
                    + "cree una nueva cuenta para poder utilizar esta funcion");
        } else {
            p.getLblMotivo().setEnabled(true);
            p.getEditPaneMotivo().setEnabled(true);
          
            p.getTxtMonto().setEnabled(true);
            p.getBtnGuardarMovimiento().setEnabled(true);
        }

    }


    /*----------------------------SECCION MULIHILO--------------------------*/
    public static InterfacesGraficasCuenta i = new InterfacesGraficasCuenta();
    public static Cargar c = new Cargar();

    public static void ejecutarNuevaVentanaCuenta() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(new TareaCargando());
        exe.execute(new TareaCuenta());
    }

    public static class TareaCuenta implements Runnable {

        @Override
        public void run() {
            try {
                i.ejecutarnuevaVentanaCuenta(Main.getPrincipalAdmin());
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
