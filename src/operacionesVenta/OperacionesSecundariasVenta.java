package operacionesVenta;

import calsesPadre.Consultas;
import formularios.FormularioEditarVenta;
import formularios.FormularioRegistrarVenta;
import java.util.Vector;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import operacionesCliente.InterfacesGraficasCliente;
import clasesUtilidadGeneral.OperacionesUtiles;
import principal.Main;

/**
 *
 * @author TELCOM MPC
 */
public class OperacionesSecundariasVenta extends Consultas {

    OperacionesUtiles opu = new OperacionesUtiles();
    InterfacesGraficasCliente i = new InterfacesGraficasCliente();

    public OperacionesSecundariasVenta() {
    }

    public void buscarCliente() {
        nuevaVentanaAndCambiarEstadoBotones();
    }

    public void buscarClienteE() {
        nuevaVentanaAndCambiarEstadoBotones();
    }

    public void nuevaVentanaAndCambiarEstadoBotones() {
        i.nuevaVentanaCliente(Main.getPrincipalAdmin());
        Main.getPrincipalAdmin().getCliente().getBtnSeleccionarCliente().setVisible(true);
        Main.getPrincipalAdmin().getCliente().getBtnEliminarCli().setVisible(false);
        Main.getPrincipalAdmin().getCliente().getBtnnEditarCl().setVisible(false);
        Main.getPrincipalAdmin().getCliente().getBtnnuevocliente().setVisible(false);
        Main.getPrincipalAdmin().getCliente().getBtnCuenta().setVisible(false);
    }

    public void deshabilitarBtnSeleccionarCliente() {
        if (Main.getPrincipalAdmin().estacerrado(Main.getPrincipalAdmin().getCliente())) {
        } else {
            Main.getPrincipalAdmin().getCliente().getBtnSeleccionarCliente().setVisible(false);
        }
    }

    public void tipoVentaSeleccionada(FormularioRegistrarVenta f, String valor) {

        if (valor.equals("pedido")) {
            f.getRadButonConsumidorFinal().setEnabled(false);
            this.modeloTablaPedido(f);
        } else {
            f.getRadButonConsumidorFinal().setEnabled(true);
            this.modeloTablaVentaSimple(f);
        }

    }

    public void modeloTablaPedido(FormularioRegistrarVenta f) {
        Vector datosTabla = new Vector();
        Vector<String> encabezadoTabla = new Vector<>();
        encabezadoTabla.add("NOMBRE");
        encabezadoTabla.add("TELEFONO");
        encabezadoTabla.add("DIRECCION");
        //encabezadoTabla.add("DIRECCION DE ENVIO");
        f.getTablaCliente().setModel(new DefaultTableModel(datosTabla, encabezadoTabla));

    }

    public void modeloTablaVentaSimple(FormularioRegistrarVenta f) {
        Vector datosTabla = new Vector();
        Vector<String> encabezadoTabla = new Vector<>();
        encabezadoTabla.add("NOMBRE");
        encabezadoTabla.add("TELEFONO");
        encabezadoTabla.add("DIRECCION");
        f.getTablaCliente().setModel(new DefaultTableModel(datosTabla, encabezadoTabla));

    }

    public void tipoConsumidorFinalEnabled(FormularioRegistrarVenta f) {

        if (f.getRadButonConsumidorFinal().isSelected()) {
            f.getBtnBuscarCliente().setEnabled(false);
            this.modeloTablaVentaSimple(f);
            datosventaSimpleConsumidorFinal(f);
        } else {
            f.getBtnBuscarCliente().setEnabled(true);
            this.modeloTablaVentaSimple(f);

        }
    }

    public void datosventaSimpleConsumidorFinal(FormularioRegistrarVenta f) {

        Vector datosTabla = new Vector();
        DefaultTableModel tablaVentaCliente = (DefaultTableModel) f.getTablaCliente().getModel();
        opu.removerFilas(tablaVentaCliente);
        datosTabla.add("Cons. Final");
        datosTabla.add("---");
        datosTabla.add("----");
        tablaVentaCliente.addRow(datosTabla);

    }

    public void quitarProducto(FormularioRegistrarVenta f) {
        try {
            opu.verificarSeleccionFila(f.getTablaListarProductos());
            DefaultTableModel tablaListaproductos = (DefaultTableModel) f.getTablaListarProductos().getModel();
            int fila = f.getTablaListarProductos().getSelectedRow();
            tablaListaproductos.removeRow(fila);
        } catch (ArrayIndexOutOfBoundsException e) {
        }

    }

    public void obtenerPrecioTotal(FormularioRegistrarVenta f) {
        try {

            Double total = 0.0;
            for (int i = 0; i < f.getTablaListarProductos().getRowCount(); i++) {
                total = total + (Double.valueOf(f.getTablaListarProductos().getValueAt(i, 3).toString()));
            }
            f.getLblPrecioTotal().setText(new OperacionesUtiles().formatoDouble(total));
        } catch (ArrayIndexOutOfBoundsException e) {
            f.getLblPrecioTotal().setText("0.0");
        }

    }

    public void listarProductos(FormularioRegistrarVenta f) {

        if (opu.verificarSeleccionFila(f.getTablaBuscarProducto())
                && opu.verificarCampoTextoVacio(f.getTxtCantidad(), "DEBE INDICAR LA CANTIDA DE UNIDADES PARA LISTAR EL PRODUCTO")) {
            DefaultTableModel tablaBuscarProducto = (DefaultTableModel) f.getTablaBuscarProducto().getModel();
            int fila = f.getTablaBuscarProducto().getSelectedRow();
            Double precioUnitario;
            Integer cantidad;
            Double resultado;
            DefaultTableModel tablaListaproductos = (DefaultTableModel) f.getTablaListarProductos().getModel();
            //String datos[] = new String[4];
            Vector<Object> datos = new Vector<>();

            datos.add(tablaBuscarProducto.getValueAt(fila, 0));
            datos.add(tablaBuscarProducto.getValueAt(fila, 1));
            precioUnitario = Double.valueOf(tablaBuscarProducto.getValueAt(fila, 3).toString());
            cantidad = Integer.valueOf(f.getTxtCantidad().getText());
            datos.add(f.getTxtCantidad().getText());
            resultado = precioUnitario * cantidad;
            datos.add(new OperacionesUtiles().formatoDouble(resultado));
            tablaListaproductos.addRow(datos);
        }
    }

    public boolean validarListaProductos(FormularioRegistrarVenta f) {

        if (f.getTablaListarProductos().getRowCount() < 1) {
            showMessageDialog(null, "La tabla 'Listar Productos' debe contener almenos un producto");
            return false;
        } else {
            return true;
        }
    }

    public boolean validarFecha(FormularioRegistrarVenta f) {

        try {
            if (f.getrSDateChooser().getDatoFecha().equals(null)
                    || f.getrSDateChooser().getDatoFecha().equals(" ")) {
                showMessageDialog(null, "Debe seleccionar una fecha");
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException e) {
            showMessageDialog(null, "Debe seleccionar una fecha");
            return false;
        }
    }

    public boolean validarTablaCliente(FormularioRegistrarVenta f) {
        if (f.getTablaCliente().getRowCount() < 1) {
            showMessageDialog(null, "Debe seleccionar un cliente o consumidor final");
            return false;
        } else {
            return true;
        }

    }

    public void tipoVentaSeleccionada(FormularioEditarVenta f, String valor) {

        if (valor.equals("pedido")) {
            f.getRadButonConsumidorFinal().setEnabled(false);
            this.modeloTablaPedido(f);
        } else {
            f.getRadButonConsumidorFinal().setEnabled(true);
            this.modeloTablaVentaSimple(f);
        }

    }

    public void modeloTablaPedido(FormularioEditarVenta f) {
        Vector datosTabla = new Vector();
        Vector<String> encabezadoTabla = new Vector<>();
        encabezadoTabla.add("NOMBRE");
        encabezadoTabla.add("TELEFONO");
        encabezadoTabla.add("DIRECCION");
        //encabezadoTabla.add("DIRECCION DE ENVIO");
        f.getTablaCliente().setModel(new DefaultTableModel(datosTabla, encabezadoTabla));

    }

    public void modeloTablaVentaSimple(FormularioEditarVenta f) {
        Vector datosTabla = new Vector();
        Vector<String> encabezadoTabla = new Vector<>();
        encabezadoTabla.add("NOMBRE");
        encabezadoTabla.add("TELEFONO");
        encabezadoTabla.add("DIRECCION");
        f.getTablaCliente().setModel(new DefaultTableModel(datosTabla, encabezadoTabla));

    }

    public void tipoConsumidorFinalEnabled(FormularioEditarVenta f) {

        if (f.getRadButonConsumidorFinal().isSelected()) {
            f.getBtnBuscarCliente().setEnabled(false);
            this.modeloTablaVentaSimple(f);
            datosventaSimpleConsumidorFinal(f);
        } else {
            f.getBtnBuscarCliente().setEnabled(true);
            this.modeloTablaVentaSimple(f);

        }
    }

    public void datosventaSimpleConsumidorFinal(FormularioEditarVenta f) {

        Vector datosTabla = new Vector();
        DefaultTableModel tablaVentaCliente = (DefaultTableModel) f.getTablaCliente().getModel();
        opu.removerFilas(tablaVentaCliente);
        datosTabla.add("Cons. Final");
        datosTabla.add("---");
        datosTabla.add("----");
        tablaVentaCliente.addRow(datosTabla);

    }

    public void quitarProducto(FormularioEditarVenta f) {
        try {
            opu.verificarSeleccionFila(f.getTablaListarProductos());
            DefaultTableModel tablaListaproductos = (DefaultTableModel) f.getTablaListarProductos().getModel();
            int fila = f.getTablaListarProductos().getSelectedRow();
            tablaListaproductos.removeRow(fila);
        } catch (ArrayIndexOutOfBoundsException e) {
        }

    }

    public void obtenerPrecioTotal(FormularioEditarVenta f) {
        try {

            Double total = 0.0;
            for (int i = 0; i < f.getTablaListarProductos().getRowCount(); i++) {
                total = total + (Double.valueOf(f.getTablaListarProductos().getValueAt(i, 3).toString()));
            }
            f.getLblPrecioTotal().setText(new OperacionesUtiles().formatoDouble(total));
        } catch (ArrayIndexOutOfBoundsException e) {
            f.getLblPrecioTotal().setText("0.0");
        }

    }

    public void listarProductos(FormularioEditarVenta f) {

        if (opu.verificarSeleccionFila(f.getTablaBuscarProducto())
                && opu.verificarCampoTextoVacio(f.getTxtCantidad(), "DEBE INDICAR LA CANTIDA DE UNIDADES PARA LISTAR EL PRODUCTO")) {
            DefaultTableModel tablaBuscarProducto = (DefaultTableModel) f.getTablaBuscarProducto().getModel();
            int fila = f.getTablaBuscarProducto().getSelectedRow();
            Double precioUnitario;
            Integer cantidad;
            Double resultado;
            DefaultTableModel tablaListaproductos = (DefaultTableModel) f.getTablaListarProductos().getModel();
            //String datos[] = new String[4];
            Vector<Object> datos = new Vector<>();

            datos.add(tablaBuscarProducto.getValueAt(fila, 0));
            datos.add(tablaBuscarProducto.getValueAt(fila, 1));
            precioUnitario = Double.valueOf(tablaBuscarProducto.getValueAt(fila, 3).toString());
            cantidad = Integer.valueOf(f.getTxtCantidad().getText());
            datos.add(f.getTxtCantidad().getText());
            resultado = precioUnitario * cantidad;
            datos.add(new OperacionesUtiles().formatoDouble(resultado));
            tablaListaproductos.addRow(datos);
        }
    }

    public boolean validarListaProductos(FormularioEditarVenta f) {

        if (f.getTablaListarProductos().getRowCount() < 1) {
            showMessageDialog(null, "La tabla 'Listar Productos' debe contener almenos un producto");
            return false;
        } else {
            return true;
        }
    }

    public boolean validarFecha(FormularioEditarVenta f) {

        try {
            if (f.getrSDateChooser().getDatoFecha().equals(null)
                    || f.getrSDateChooser().getDatoFecha().equals(" ")) {
                showMessageDialog(null, "Debe seleccionar una fecha");
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException e) {
            showMessageDialog(null, "Debe seleccionar una fecha");
            return false;
        }
    }

    public boolean validarTablaCliente(FormularioEditarVenta f) {
        if (f.getTablaCliente().getRowCount() < 1) {
            showMessageDialog(null, "Debe seleccionar un cliente o consumidor final");
            return false;
        } else {
            return true;
        }

    }

}
