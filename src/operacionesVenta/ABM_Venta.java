package operacionesVenta;

import conexion.ConexionHibernate;
import entidades.Cliente;
import entidades.Estado;
import entidades.Producto;
import entidades.Producto_Venta;
import entidades.TipoVenta;
import entidades.Venta;
import formularios.FormularioEditarVenta;
import formularios.FormularioEstadoVenta;
import formularios.FormularioRegistrarVenta;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;
import org.hibernate.Session;
import principal.Main;

/**
 *
 * @author FRANCO
 */
public class ABM_Venta {

    OperacionesSecundariasVenta o = new OperacionesSecundariasVenta();

    public boolean ejecutarRegistrarVenta(FormularioRegistrarVenta f) {
        if (o.validarListaProductos(f) && o.validarTablaCliente(f) && o.validarFecha(f)) {
            transaccionRegistrarVenta(f);
            return true;
        }
        return false;
    }

    public boolean ejecutarEditarVenta(FormularioEditarVenta f) {
        if (o.validarListaProductos(f) && o.validarTablaCliente(f) && o.validarFecha(f)) {
            transaccionEditarVenta(f);
            return true;
        }
        return false;
    }

    public boolean ejecutarCambiarEstadoVenta(FormularioEstadoVenta f) {
        transaccionCambiarEstadoVenta(f);
        return true;
    }

    public void transaccionRegistrarVenta(FormularioRegistrarVenta f) {
        Double totalunidades;
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();

            Venta v = new Venta();
            if (f.getRadButonConsumidorFinal().isSelected()) {
                Cliente c = (Cliente) miSesion.get(Cliente.class, 1);
                v.setCodigoCliente(c);
            } else {
                Cliente c = (Cliente) miSesion.get(Cliente.class, Integer.valueOf(Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla()));
                v.setCodigoCliente(c);
            }
            v.setFechaHoraVenta(f.getrSDateChooser().getDatoFecha());
            v.setPrecioTotal(Double.valueOf(f.getLblPrecioTotal().getText()));

            if (f.getBoxTipoVenta().getSelectedItem().equals("venta simple")) {
                TipoVenta tvs = (TipoVenta) miSesion.get(TipoVenta.class, 1);
                v.setCodigoTipoVenta(tvs);
                Estado e = (Estado) miSesion.get(Estado.class, 3);
                v.setCodigoEstado(e);
            } else {
                TipoVenta tvp = (TipoVenta) miSesion.get(TipoVenta.class, 2);
                v.setCodigoTipoVenta(tvp);
                Estado e = (Estado) miSesion.get(Estado.class, 4);
                v.setCodigoEstado(e);
            }
            miSesion.save(v);

            for (int i = 0; i < f.getTablaListarProductos().getRowCount(); i++) {
                Producto_Venta pv = new Producto_Venta();
                Producto p = (Producto) miSesion.get(Producto.class, Integer.valueOf(f.getTablaListarProductos().getValueAt(i, 0).toString()));
                totalunidades = Double.valueOf(f.getTablaListarProductos().getValueAt(i, 2).toString());
                pv.setCodigoProducto(p);
                pv.setCodigoVenta(v);
                pv.setTotalUnidades(totalunidades);
                miSesion.save(pv);
            }

            miSesion.getTransaction().commit();

            showMessageDialog(null, "Venta registrado con exito");
        } catch (Exception e) {
            showMessageDialog(null, "Error al intentar registrar venta");
            e.printStackTrace();
        }

    }

    public void transaccionCambiarEstadoVenta(FormularioEstadoVenta f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Estado eE = (Estado) miSesion.get(Estado.class, 2);
            Estado eR = (Estado) miSesion.get(Estado.class, 3);
            Estado eP = (Estado) miSesion.get(Estado.class, 4);
            Estado eC = (Estado) miSesion.get(Estado.class, 5);
            Venta v = (Venta) miSesion.get(Venta.class, Main.getPrincipalAdmin().getVentas().ObjetoTablaConDatos().getIdTabla());
            switch (f.getEstado()) {
                case 2:
                    v.setCodigoEstado(eE);
                    break;
                case 3:
                    v.setCodigoEstado(eR);
                    break;
                case 4:
                    v.setCodigoEstado(eP);
                    break;
                case 5:
                    v.setCodigoEstado(eC);
                    break;
            }
            miSesion.saveOrUpdate(v);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "El estado del registro se modifico con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al Intentar eliminar registro");
        }

    }

    public void transaccionEditarVenta(FormularioEditarVenta f) {

        Double totalunidades;
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            List lista = TablaVenta.getListaProductosEliminar();

            for (Object o : lista) {
                Producto_Venta pr = (Producto_Venta) o;
                Producto_Venta productoEliminar = (Producto_Venta) miSesion.get(Producto_Venta.class, pr.getIdProductoVenta());
                miSesion.delete(productoEliminar);
            }
            Venta v = (Venta) miSesion.get(Venta.class, Integer.valueOf(Main.getPrincipalAdmin().getVentas().ObjetoTablaConDatos().getIdTabla()));
            if (f.getCambiarCliente().equals(1)) {
                Cliente c = (Cliente) miSesion.get(Cliente.class, Integer.valueOf(Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla()));
                v.setCodigoCliente(c);
            } else if (f.getRadButonConsumidorFinal().isSelected()) {
                Cliente c = (Cliente) miSesion.get(Cliente.class, 1);
                v.setCodigoCliente(c);
            }

            v.setFechaHoraVenta(f.getrSDateChooser().getDatoFecha());
            v.setPrecioTotal(Double.valueOf(f.getLblPrecioTotal().getText()));

            if (f.getBoxTipoVenta().getSelectedItem().equals("venta simple")) {
                TipoVenta tvs = (TipoVenta) miSesion.get(TipoVenta.class, 1);
                v.setCodigoTipoVenta(tvs);
                Estado e = (Estado) miSesion.get(Estado.class, 3);
                v.setCodigoEstado(e);
            } else {
                TipoVenta tvp = (TipoVenta) miSesion.get(TipoVenta.class, 2);
                v.setCodigoTipoVenta(tvp);
                Estado e = (Estado) miSesion.get(Estado.class, 4);
                v.setCodigoEstado(e);
            }
            miSesion.saveOrUpdate(v);

            for (int i = 0; i < f.getTablaListarProductos().getRowCount(); i++) {
                Producto_Venta pv = new Producto_Venta();
                Producto p = (Producto) miSesion.get(Producto.class, Integer.valueOf(f.getTablaListarProductos().getValueAt(i, 0).toString()));
                totalunidades = Double.valueOf(f.getTablaListarProductos().getValueAt(i, 2).toString());
                pv.setCodigoProducto(p);
                pv.setCodigoVenta(v);
                pv.setTotalUnidades(totalunidades);
                miSesion.save(pv);
            }

            miSesion.getTransaction().commit();

            showMessageDialog(null, "Registro editado con exito");
        } catch (Exception e) {
            showMessageDialog(null, "Error al intentar modificar registro");
            e.printStackTrace();
        }

    }

}
