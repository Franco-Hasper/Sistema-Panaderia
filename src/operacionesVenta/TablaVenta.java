package operacionesVenta;

import calsesPadre.Tablas;
import entidades.Cliente;
import entidades.Direccion_Cliente;
import entidades.PrecioProducto;
import entidades.Producto;
import entidades.Producto_Venta;
import entidades.TelefonoCliente;
import entidades.Venta;
import escritorios.PrincipalVentas;
import formularios.FormularioDetalleDeVenta;
import formularios.FormularioEditarVenta;
import formularios.FormularioRegistrarVenta;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import operacionesCuenta.InterfacesGraficasCuenta;
import principal.Main;

/**
 *
 * @author TELCOM MPC
 */
public class TablaVenta extends Tablas {

    InterfacesGraficasCuenta i = new InterfacesGraficasCuenta();

    public TablaVenta() {
        setEstadoConsulta(0);
    }

    static List<Producto_Venta> listaProductosEliminar;

    public static List<Producto_Venta> getListaProductosEliminar() {
        return listaProductosEliminar;
    }

    public static void setListaProductosEliminar(List<Producto_Venta> listaProductosEliminar) {
        TablaVenta.listaProductosEliminar = listaProductosEliminar;
    }

    public void ejecutarRellenarTabla(PrincipalVentas v) {
        setTabla(v.getTabla());
        setStringConsulta("from Venta");
        evaluarEstadoConsulta();
        setCampoTexto(v.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaVenta = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaVenta);

        for (Object o : lista) {
            Venta vnt = (Venta) o;
            Integer resutadoComparacion = (vnt.getFechaHoraVenta().toString().indexOf(valorBusqueda));
            Vector<Object> fila = new Vector<>();
            /**
             * pedidos pendienntes*
             */
            if (vnt.getCodigoEstado().getIdEstado() != 2 && resutadoComparacion.equals(0)) {
                if (Main.getPrincipalAdmin().getVentas().getRadButonSoloPedidos().isSelected()) {
                    if (Main.getPrincipalAdmin().getVentas().getRadButtonPendientes().isSelected()) {
                        if ((vnt.getCodigoTipoVenta().getNombre().equals("pedido")) && (vnt.getCodigoEstado().getValor().equals("pendiennte"))) {

                            if (vnt.getCodigoCliente().getNombre().equals("Consumidor Final")) {
                                fila.add(vnt.getCodigoCliente().getNombre());
                            } else {
                                fila.add(vnt.getCodigoCliente().getNombre() + " " + vnt.getCodigoCliente().getApellido());
                            }

                            fila.add(opu.formatoFecha(vnt.getFechaHoraVenta()));
                            fila.add(vnt.getPrecioTotal());
                            fila.add(vnt.getCodigoTipoVenta().getNombre());
                            fila.add(vnt.getCodigoEstado().getValor());
                            tablaVenta.addRow(fila);

                        }
                        /**
                         * pedidos todos*
                         */
                    } else {
                        if (vnt.getCodigoTipoVenta().getNombre().equals("pedido")) {
                            if (vnt.getCodigoCliente().getNombre().equals("Consumidor Final")) {
                                fila.add(vnt.getCodigoCliente().getNombre());
                            } else {
                                fila.add(vnt.getCodigoCliente().getNombre() + " " + vnt.getCodigoCliente().getApellido());
                            }

                            fila.add(opu.formatoFecha(vnt.getFechaHoraVenta()));
                            fila.add(vnt.getPrecioTotal());
                            fila.add(vnt.getCodigoTipoVenta().getNombre());
                            fila.add(vnt.getCodigoEstado().getValor());
                            tablaVenta.addRow(fila);
                        }
                    }
                } else {
                    if (vnt.getCodigoCliente().getNombre().equals("Consumidor Final")) {
                        fila.add(vnt.getCodigoCliente().getNombre());
                    } else {
                        fila.add(vnt.getCodigoCliente().getNombre() + " " + vnt.getCodigoCliente().getApellido());
                    }

                    fila.add(opu.formatoFecha(vnt.getFechaHoraVenta()));
                    fila.add(vnt.getPrecioTotal());
                    fila.add(vnt.getCodigoTipoVenta().getNombre());
                    fila.add(vnt.getCodigoEstado().getValor());
                    tablaVenta.addRow(fila);
                }
            }

        }
    }

    public void rellenarTablaProductoSinFeha() {
        DefaultTableModel tablaPrducto = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaPrducto);
        List<PrecioProducto> lista_producto
                = (List<PrecioProducto>) lista;
        for (Object o : lista_producto) {

            PrecioProducto pr = (PrecioProducto) o;
            if (pr.getCodigoEstado().getIdEstado().equals(1)) {
                Vector<Object> fila = new Vector<>();
                fila.add(pr.getCodigoProducto().getIdProducto());
                fila.add(pr.getCodigoProducto().getNombre());
                fila.add(pr.getCodigoProducto().getDescripcion());
                fila.add(pr.getPrecioTotal());
                tablaPrducto.addRow(fila);

            }
        }
    }

    public void rellenarTablaProductoSinFechaBusqueda() {
        DefaultTableModel tablaPrducto = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaPrducto);
        List<Producto> lista_producto
                = (List<Producto>) lista;

        for (Producto pr : lista_producto) {
            List<PrecioProducto> listaPre = pr.getPrecios();

            for (PrecioProducto p : listaPre) {

                if (p.getCodigoEstado().getIdEstado().equals(1)) {
                    Vector<Object> fila = new Vector<>();
                    fila.add(p.getCodigoProducto().getIdProducto());
                    fila.add(p.getCodigoProducto().getNombre());
                    fila.add(p.getCodigoProducto().getDescripcion());
                    fila.add(String.valueOf(p.getPrecioTotal()));
                    tablaPrducto.addRow(fila);
                }

            }
        }
    }

    public void ejecutarRellenarDetalleDeVenta(FormularioDetalleDeVenta f) {

        setConsultaObject("from Producto_Venta where codigo_venta=" + Main.getPrincipalAdmin().getVentas().ObjetoTablaConDatos().getIdTabla().toString());
        obtenerObjetoConsulta();
        rellenarLabelsDetalleDeVenta(f);
        setTabla(f.getTablaListaProductos());
        setConsultaList("from Producto_Venta where codigo_venta=" + Main.getPrincipalAdmin().getVentas().ObjetoTablaConDatos().getIdTabla().toString());
        obtenerListaConsulta();
        rellenarTablaDetalleDeVenta();

    }

    public void ejecutarRellenarDatosEditarVenta(FormularioEditarVenta f) {
        setTabla(f.getTablaListarProductos());
        setConsultaList("from Producto_Venta where codigo_venta=" + Main.getPrincipalAdmin().getVentas().ObjetoTablaConDatos().getIdTabla().toString());
        obtenerListaConsulta();
        rellenarTablaListaProducto();
        setTabla(f.getTablaCliente());
        setConsultaObject("from Producto_Venta where codigo_venta=" + Main.getPrincipalAdmin().getVentas().ObjetoTablaConDatos().getIdTabla().toString());
        obtenerObjetoConsulta();
        cambiarEstadoBoxTipoVenta(f);
        insertarFechaVenta(f);
        rellenatTablaClienteFormularioEditar();

    }

    public void insertarFechaVenta(FormularioEditarVenta f) {
        Object objeto = this.getObjetoResultado();
        Producto_Venta pr = (Producto_Venta) objeto;
        try {
            f.getrSDateChooser().setDatoFecha(pr.getCodigoVenta().getFechaHoraVenta());
        } catch (NullPointerException e) {
        }

    }

    public void cambiarEstadoBoxTipoVenta(FormularioEditarVenta f) {
        Object objeto = this.getObjetoResultado();
        Producto_Venta pr = (Producto_Venta) objeto;
        try {
            switch (pr.getCodigoVenta().getCodigoTipoVenta().getIdTipoVenta()) {
                case (1):
                    f.getBoxTipoVenta().setSelectedIndex(0);
                    break;
                case (2):
                    f.getBoxTipoVenta().setSelectedIndex(1);
            }
        } catch (NullPointerException e) {
        }

    }

    public void rellenarLabelsDetalleDeVenta(FormularioDetalleDeVenta f) {
        Object objeto = this.getObjetoResultado();
        Producto_Venta pro = (Producto_Venta) objeto;
        try {
            f.getLblCliente().setText(pro.getCodigoVenta().getCodigoCliente().getNombre() + "  " + pro.getCodigoVenta().getCodigoCliente().getApellido());
            f.getLblFecha().setText(opu.formatoFecha(pro.getCodigoVenta().getFechaHoraVenta()).toString());
            f.getLblTipoVenta().setText(pro.getCodigoVenta().getCodigoTipoVenta().getNombre());
            f.getLblImporteTotal().setText(pro.getCodigoVenta().getPrecioTotal().toString());
        } catch (NullPointerException e) {
            System.out.println(e);
        }

    }

    public void rellenatTablaClienteFormularioEditar() {
        try {

            DefaultTableModel tablaCliente = (DefaultTableModel) getTabla().getModel();
            opu.removerFilas(tablaCliente);
            Integer vueltaDir = 0;
            Integer vueltaTel = 0;
            Object objeto = this.getObjetoResultado();
            Producto_Venta pr = (Producto_Venta) objeto;

            Vector<Object> fila = new Vector<>();
            fila.add(pr.getCodigoVenta().getCodigoCliente().getNombre() + " - " + pr.getCodigoVenta().getCodigoCliente().getApellido());

            List<Direccion_Cliente> direcciones = pr.getCodigoVenta().getCodigoCliente().getDireccionesclientes();
            List<TelefonoCliente> telefonos = pr.getCodigoVenta().getCodigoCliente().getTelefonos();

            if (pr.getCodigoVenta().getCodigoCliente().getTelefonos().size() == 0) {
                fila.add("ningun registro encontrado");
            } else {
                for (TelefonoCliente tlcl : telefonos) {
                    if (vueltaTel != 1) {
                        fila.add(tlcl.getNuemero() + " / " + tlcl.getCodigoTipoTelefono().getNombre());
                        vueltaTel = 1;
                    }
                }
            }

            if (pr.getCodigoVenta().getCodigoCliente().getDireccionesclientes().size() == 0) {
                fila.add("ningun registro encontrado");
            } else {
                for (Direccion_Cliente drCl : direcciones) {
                    if (vueltaDir != 1) {
                        fila.add(drCl.getNombre() + " - " + drCl.getNumero() + " - " + drCl.getCodigoLocalidad().getNombre()
                                + " / " + drCl.getCodigoTipoDomicilio().getNombre());
                        vueltaDir = 1;
                    }
                }
            }
            vueltaDir = 0;
            vueltaTel = 0;
            tablaCliente.addRow(fila);

        } catch (NullPointerException e) {

        }

    }

    public void rellenarTablaDetalleDeVenta() {
        DefaultTableModel tablaDetallesVenta = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaDetallesVenta);
        for (Object o : lista) {
            Producto_Venta pr = (Producto_Venta) o;
            Vector<Object> fila = new Vector<>();
            fila.add(pr.getCodigoProducto().getNombre());
            fila.add(pr.getTotalUnidades());
            List<PrecioProducto> precios
                    = pr.getCodigoProducto().getPrecios();
            for (PrecioProducto pre : precios) {
                if (pre.getCodigoEstado().getIdEstado().equals(1)) {
                    fila.add(pr.getTotalUnidades() * pre.getPrecioTotal());
                }
            }
            tablaDetallesVenta.addRow(fila);
        }
    }

    public void rellenarTablaListaProducto() {
        DefaultTableModel tablaDetallesVenta = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        this.setListaProductosEliminar(lista);
        opu.removerFilas(tablaDetallesVenta);
        for (Object o : lista) {
            Producto_Venta pr = (Producto_Venta) o;
            Vector<Object> fila = new Vector<>();
            fila.add(pr.getCodigoProducto().getIdProducto());
            fila.add(pr.getCodigoProducto().getNombre());
            fila.add(pr.getTotalUnidades());
            List<PrecioProducto> precios
                    = pr.getCodigoProducto().getPrecios();
            for (PrecioProducto pre : precios) {
                if (pre.getCodigoEstado().getIdEstado().equals(1)) {
                    fila.add(pr.getTotalUnidades() * pre.getPrecioTotal());
                }
            }
            tablaDetallesVenta.addRow(fila);
        }
    }

    public void ejecutarRellenarTablaProductoSinFecha(FormularioRegistrarVenta p) {
        setTabla(p.getTablaBuscarProducto());
        setConsultaList("from PrecioProducto");
        obtenerListaConsulta();
        rellenarTablaProductoSinFeha();
    }

    public void ejecutarRellenarTablaProductoSinFecha(FormularioEditarVenta p) {
        setTabla(p.getTablaBuscarProducto());
        setConsultaList("from PrecioProducto");
        obtenerListaConsulta();
        rellenarTablaProductoSinFeha();
    }

    public void ejecutarRellenarTablaProductoSinFechaBusqueda(FormularioRegistrarVenta f) {
        setTabla(f.getTablaBuscarProducto());
        if (f.getTxtBuscar().getText().equals("")) {
            setConsultaList("from PrecioProducto");
            obtenerListaConsulta();
            rellenarTablaProductoSinFeha();
        } else {
            setConsultaList("from Producto where nombre like '" + f.getTxtBuscar().getText() + "%'");
            obtenerListaConsulta();
            rellenarTablaProductoSinFechaBusqueda();
        }
    }

    public void ejecutarRellenarTablaProductoSinFechaBusqueda(FormularioEditarVenta f) {
        setTabla(f.getTablaBuscarProducto());
        if (f.getTxtBuscar().getText().equals("")) {
            setConsultaList("from PrecioProducto");
            obtenerListaConsulta();
            rellenarTablaProductoSinFeha();
        } else {
            setConsultaList("from Producto where nombre like '" + f.getTxtBuscar().getText() + "%'");
            obtenerListaConsulta();
            rellenarTablaProductoSinFechaBusqueda();
        }
    }

    public boolean RellenarTablaClienteRegistrar(FormularioRegistrarVenta f) {
        if (i.verificarFilaSeleccionadaCliente()) {
            setTabla(f.getTablaCliente());
            String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
            setConsultaList("from Cliente where id_cliente=" + idCliente);
            obtenerListaConsulta();
            rellenarTablaClientedeVenta();
            f.toFront();
            return true;
        }
        return false;
    }

    public boolean RellenarTablaClienteEditar(FormularioEditarVenta f) {
        if (i.verificarFilaSeleccionadaCliente()) {
            setTabla(f.getTablaCliente());
            String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
            setConsultaList("from Cliente where id_cliente=" + idCliente);
            obtenerListaConsulta();
            rellenarTablaClientedeVenta();
            f.toFront();
            return true;
        }
        return false;
    }

    public void rellenarTablaClientedeVenta() {
        try {
            DefaultTableModel tablaCliente = (DefaultTableModel) getTabla().getModel();
            List lista = this.getListaResultados();
            opu.removerFilas(tablaCliente);
            Integer vueltaDir = 0;
            Integer vueltaTel = 0;
            for (Object o : lista) {
                Cliente c = (Cliente) o;
                Vector<Object> fila = new Vector<>();
                fila.add(c.getNombre() + " - " + c.getApellido());

                List<Direccion_Cliente> direcciones = c.getDireccionesclientes();
                List<TelefonoCliente> telefonos = c.getTelefonos();

                //****************************//
                if (c.getTelefonos().size() == 0) {
                    fila.add("ningun registro encontrado");
                } else {
                    for (TelefonoCliente tlcl : telefonos) {
                        if (vueltaTel != 1) {
                            fila.add(tlcl.getNuemero() + " / " + tlcl.getCodigoTipoTelefono().getNombre());
                            vueltaTel = 1;
                        }
                    }
                }
                //****************************//
                if (c.getDireccionesclientes().size() == 0) {
                    fila.add("ningun registro encontrado");
                } else {
                    for (Direccion_Cliente drCl : direcciones) {
                        if (vueltaDir != 1) {
                            fila.add(drCl.getNombre() + " - " + drCl.getNumero() + " - " + drCl.getCodigoLocalidad().getNombre()
                                    + " / " + drCl.getCodigoTipoDomicilio().getNombre());
                            vueltaDir = 1;
                        }
                    }
                }

                vueltaDir = 0;
                vueltaTel = 0;
                tablaCliente.addRow(fila);
            }
        } catch (Exception e) {
        }

    }

    public void obtenerIdTablaVenta() {
        int fila = Main.getPrincipalAdmin().getVentas().getTabla().getSelectedRow();
        String nombreCliente = Main.getPrincipalAdmin().getVentas().getTabla().getValueAt(fila, 0).toString();
        String fecha = Main.getPrincipalAdmin().getVentas().getTabla().getValueAt(fila, 1).toString();
        String precioTotal = Main.getPrincipalAdmin().getVentas().getTabla().getValueAt(fila, 2).toString();
        String tipoVenta = Main.getPrincipalAdmin().getVentas().getTabla().getValueAt(fila, 3).toString();
        String estado = Main.getPrincipalAdmin().getVentas().getTabla().getValueAt(fila, 4).toString();
        try {
            for (Object o : getListaResultados()) {
                Venta v = (Venta) o;
                String nombreyApellido = v.getCodigoCliente().getNombre().toString() + " " + v.getCodigoCliente().getApellido().toString();

                if (nombreyApellido.equals(nombreCliente)
                        && (opu.formatoFecha(v.getFechaHoraVenta()).equals(fecha))
                        && precioTotal.equals(v.getPrecioTotal().toString())
                        && tipoVenta.equals(v.getCodigoTipoVenta().getNombre().toString())
                        && estado.equals(v.getCodigoEstado().getValor().toString())) {
                    this.setIdTabla(v.getIdVenta());
                }
            }
        } catch (Exception e) {
        }

    }

}
