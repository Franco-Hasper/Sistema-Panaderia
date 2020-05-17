package operacionesProducto;

import calsesPadre.Consultas;
import conexion.ConexionHibernate;
import ds.desktop.notify.DesktopNotify;
import entidades.Estado;
import entidades.Iva;
import entidades.PrecioProducto;
import entidades.Producto;
import formularios.FormularioEditarProducto;
import formularios.FormularioPrecioProducto;
import formularios.FormularioRegistrarProducto;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import clasesUtilidadGeneral.OperacionesUtiles;
import org.hibernate.Session;
import principal.Main;

/**
 *
 * @author TELCOM MPC
 */
public class ABM_Producto extends Consultas {

    OperacionesUtiles opUtl = new OperacionesUtiles();
    JOptionPane jop = new JOptionPane();
    TablaProducto t = new TablaProducto();

    public boolean ejecutarRegistrarProducto(FormularioRegistrarProducto f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionRegistrarProducto(f);
            f.dispose();
            return true;
        }
        return false;
    }

    public boolean ejecutarNuevoPrecioProducto(FormularioPrecioProducto f) {
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionNuevoPrecioProducto(f);
            f.dispose();
            return true;
        }
        return false;
    }

    public boolean ejecutarEliminarProducto() {
        transaccionEliminarProducto();
        return true;
    }

    public boolean ejecutarEditarProducto(FormularioEditarProducto f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionEditarProducto(f);
            f.dispose();
            return true;
        }
        return false;
    }

    public void transaccionEditarProducto(FormularioEditarProducto f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            String idProducto = Main.getPrincipalAdmin().getProducto().ObjetoTablaConDatos().getIdTabla().toString();
            Producto p = (Producto) miSesion.get(Producto.class, Integer.parseInt(idProducto));
            p.setNombre(f.getTxtNombre().getText());
            p.setDescripcion(f.getTxtDescripcion().getText());
            miSesion.saveOrUpdate(p);
            miSesion.getTransaction().commit();
            new OperacionesUtiles().notificar(2);
        } catch (Exception ex) {
            new OperacionesUtiles().notificar(5);
        }

    }

    public void transaccionRegistrarProducto(FormularioRegistrarProducto f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();

            Producto p = new Producto();

            Estado e = (Estado) miSesion.get(Estado.class, 1);

            p.setNombre(f.getTxtNombre().getText());
            p.setDescripcion(f.getTxtDescripcion().getText());
            p.setCodigoEstado(e);
            miSesion.save(p);

            PrecioProducto prp = new PrecioProducto();

            prp.setCodigoProducto(p);

            Iva i = (Iva) miSesion.createQuery("from Iva where codigoEstado= " + e.getIdEstado()).uniqueResult();

            prp.setCodigoIva(i);
            prp.setPrecioBruto(Double.valueOf(f.getTxtPrecio().getText()));
            prp.setPrecioTotal(Double.valueOf(f.getTxtPrecioFinal().getText()));
            Date fechaActual = new Date();
            prp.setFecha(fechaActual);
            prp.setCodigoEstado(e);

            miSesion.save(prp);

            miSesion.getTransaction().commit();

            new OperacionesUtiles().notificar(1);

        } catch (Exception ex) {
            new OperacionesUtiles().notificar(4);
        }

    }

    public void transaccionEliminarProducto() {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 2);
            Producto p = (Producto) miSesion.get(Producto.class, Main.getPrincipalAdmin().getProducto().ObjetoTablaConDatos().getIdTabla());
            p.setCodigoEstado(e);
            miSesion.saveOrUpdate(p);
            miSesion.getTransaction().commit();
            new OperacionesUtiles().notificar(3);
        } catch (Exception ex) {
            new OperacionesUtiles().notificar(6);
        }

    }

    public void transaccionNuevoPrecioProducto(FormularioPrecioProducto f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Estado ef = (Estado) miSesion.get(Estado.class, 2);
            Producto p = (Producto) miSesion.get(Producto.class, Main.getPrincipalAdmin().getProducto().ObjetoTablaConDatos().getIdTabla());
            List<PrecioProducto> precios = p.getPrecios();
            //List lista = this.getListaResultados();
            for (Object o : precios) {
                PrecioProducto pr = (PrecioProducto) o;
                pr.setCodigoEstado(ef);
                miSesion.saveOrUpdate(pr);
            }

            Estado e = (Estado) miSesion.get(Estado.class, 1);
            PrecioProducto prp = new PrecioProducto();
            prp.setCodigoProducto(p);

            Iva i = (Iva) miSesion.createQuery("from Iva where codigoEstado= " + e.getIdEstado()).uniqueResult();

            prp.setCodigoIva(i);
            prp.setPrecioBruto(Double.valueOf(f.getTxtPrecio().getText()));
            prp.setPrecioTotal(Double.valueOf(f.getTxtPrecioFinal().getText()));
            Date fechaActual = new Date();
            prp.setFecha(fechaActual);
            prp.setCodigoEstado(e);

            miSesion.save(prp);

            miSesion.getTransaction().commit();

            new OperacionesUtiles().notificar(1);
        } catch (Exception ex) {
            new OperacionesUtiles().notificar(4);
            showMessageDialog(null, "");
        }

    }

}
