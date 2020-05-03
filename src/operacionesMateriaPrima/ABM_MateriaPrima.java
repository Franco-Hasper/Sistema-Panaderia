package operacionesMateriaPrima;

import conexion.ConexionHibernate;
import entidades.Estado;
import entidades.IngresoMateriaPrima;
import entidades.Marca;
import entidades.MateriaPrima;
import entidades.MateriaPrima_Marca;
import entidades.MateriaPrima_Marca_Proveedor;
import entidades.MateriaPrima_Proveedor;
import entidades.Proveedor;
import entidades.UnidaddeMedida;
import formularios.FormularioEditarIngresoMateriaPrima;
import formularios.FormularioEditarMateriaPrima;
import formularios.FormularioRegistrarIngresoMateriaPrima;
import formularios.FormularioRegistrarMateriaPrima;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import clasesUtilidadGeneral.OperacionesUtiles;
import org.hibernate.Session;
import principal.Main;
import principal.PrincipalAdministrador;

/**
 * <h1>Clase ABM_MateriaPrima</h1>
 * Contiene las 3 funciones "alta, baja y modificar" para la entidad materia
 * prima
 *
 * @author Hasper Franco
 * @version 0.1
 * @since 2020-01-16
 */
public class ABM_MateriaPrima {

    OperacionesUtiles opUtl = new OperacionesUtiles();
    JOptionPane jop = new JOptionPane();

    /**
     * ejecuta el metodo que verifica que no hayan campos vacios y el metodo qu
     * realiza la transaccion para crear un nuevo registro de materia prima en
     * la bd
     *
     * @param f (objeto del formulario registrar materia prima)
     */
    public boolean ejecutarRegistrarMateriaPrima(FormularioRegistrarMateriaPrima f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionRegistrarMateriaPrima(f);
            f.dispose();
            return true;
        }
        return false;
    }

    /**
     * ejecuta el metodo que verifica que no hayan campos vacios y el metodo qu
     * realiza la transaccion para editar un registro de materia prima en la bd
     *
     * @param f (objeto del formulario registrar materia prima)
     */
    public void ejecutarEditarMateriaPrima(FormularioEditarMateriaPrima f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionEditarMateriaPrima(f);
            f.dispose();
        }
    }

    /**
     * ejecuta el metodo que verifica que no hayan campos vacios y el metodo qu
     * realiza la transaccion para editar un registro de materia prima en la bd
     *
     * @param f (objeto del formulario registrar materia prima)
     */
    public boolean ejecutarEliminarMateriaPrima() {
        //ejecutar transaccion eliminar
        transaccionEliminarMateriaPrima();
        return true;
    }

    /**
     * ejecuta el metodo que verifica que no hayan campos vacios y el metodo qu
     * realiza la transaccion para crear un nuevo registro de materia prima en
     * la bd
     *
     * @param f (objeto del formulario registrar materia prima)
     */
    public void ejecutarRegistrarIngresoMateriaPrima(FormularioRegistrarIngresoMateriaPrima f, TablaMateriaPrima t, PrincipalAdministrador p) {
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            trnasaccionRegistrarIngresoMateriaPrima(f, t);
            if (p.estacerrado(p.getIngmatprima())) {
            } else {

            }
            f.dispose();
        }
    }

    /**
     * ejecutar transaccion eliminar
     *
     * @param f (objeto del formulario registrar materia prima)
     */
    public boolean ejecutarEliminarIngresoMateriaPrima() {
        transaccionEliminarIngresoMateriaPrima();
        return true;
    }

    public void ejecutarEditarIngresoMateriaPrima(FormularioEditarIngresoMateriaPrima f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionEditarIngresoMateriaPrima(f);
            f.dispose();
        }

    }

    /**
     * realiza la transaccion para crear un nuevo registro de materia prima en
     * la bd
     *
     * @param f (objeto del formulario registrar materia prima)
     */
    public void transaccionRegistrarMateriaPrima(FormularioRegistrarMateriaPrima f) {

        Session miSesion = ConexionHibernate.tomarConexion();

        try {
            miSesion.beginTransaction();
            //objeto para guardar datos en tabla materia prima marca proveedor
            MateriaPrima_Marca_Proveedor mtmrpr = new MateriaPrima_Marca_Proveedor();
            //guardar datos en Materia Prima
            MateriaPrima m = new MateriaPrima();

            m.setNombre(f.getTxtNombre().getText());

            List<UnidaddeMedida> lista_uDeMedida
                    = (List<UnidaddeMedida>) miSesion.createQuery("from UnidaddeMedida").list();
            for (UnidaddeMedida u : lista_uDeMedida) {
                if (u.getNombre().equals(f.getBoxUdeMedida().getSelectedItem())) {
                    m.setCodigoUnidaddeMedida(u);
                }
            }

            Estado e = (Estado) miSesion.get(Estado.class, 1);
            m.setCodigoEstado(e);

            miSesion.save(m);

            //Guardar datos en tabla MateriaPrima_Marca
            MateriaPrima_Marca mtmr = new MateriaPrima_Marca();

            List<Marca> lista_marca
                    = (List<Marca>) miSesion.createQuery("from Marca").list();
            for (Marca mr : lista_marca) {
                if (mr.getNombre().equals(f.getBoxMarca().getSelectedItem())) {
                    mtmr.setCodigoMarca(mr);
                    mtmrpr.setCodigoMarca(mr);
                }
            }
            mtmr.setCodigoMateriaPrima(m);
            miSesion.save(mtmr);

            //guardar datos en tabla MateriaPrima_Proveedor
            MateriaPrima_Proveedor mtpr = new MateriaPrima_Proveedor();

            List<Proveedor> lista_proveedor
                    = (List<Proveedor>) miSesion.createQuery("from Proveedor").list();
            for (Proveedor pr : lista_proveedor) {
                if (pr.getNombre().equals(f.getBoxProveedor().getSelectedItem())) {
                    mtpr.setCodigoProveedor(pr);
                    mtmrpr.setCodigoProveedor(pr);
                }
            }
            mtpr.setCodigoMateriaPrima(m);
            mtmrpr.setCodigoMateriaPrima(m);
            miSesion.save(mtpr);
            miSesion.save(mtmrpr);

            miSesion.getTransaction().commit();

            showMessageDialog(null, "Nuevo registro creado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al intentar crear  registro");
        }

    }

    /**
     * realiza la transaccion para editar un registro de materia prima en la bd
     *
     * @param f (objeto del formulario editar materia prima)
     */
    public void transaccionEditarMateriaPrima(FormularioEditarMateriaPrima f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            miSesion.beginTransaction();
            String idMp = Main.getPrincipalAdmin().getMatprima().ObjetoTablaConDatos().getIdTabla().toString();
            MateriaPrima m = (MateriaPrima) miSesion.get(MateriaPrima.class, Integer.parseInt(idMp));

            m.setNombre(f.getTxtNombreMAteriaPrima().getText());

            List<UnidaddeMedida> lista_uDeMedida
                    = (List<UnidaddeMedida>) miSesion.createQuery("from UnidaddeMedida").list();
            for (UnidaddeMedida u : lista_uDeMedida) {
                if (u.getNombre().equals(f.getBoxUdeMedida().getSelectedItem())) {
                    m.setCodigoUnidaddeMedida(u);
                }
            }

            miSesion.saveOrUpdate(m);
            String idMtpMrPr = Main.getPrincipalAdmin().getMatprima().ObjetoTablaConDatos().getIdTabla().toString();
            MateriaPrima_Marca_Proveedor mtmrpr = (MateriaPrima_Marca_Proveedor) miSesion.get(MateriaPrima_Marca_Proveedor.class, Integer.parseInt(idMtpMrPr));

            List<Marca> lista_marca
                    = (List<Marca>) miSesion.createQuery("from Marca").list();
            for (Marca mr : lista_marca) {
                if (mr.getNombre().equals(f.getBoxMarca().getSelectedItem())) {
                    mtmrpr.setCodigoMarca(mr);
                }
            }

            List<Proveedor> lista_proveedor
                    = (List<Proveedor>) miSesion.createQuery("from Proveedor").list();
            for (Proveedor pr : lista_proveedor) {
                if (pr.getNombre().equals(f.getBoxProveedor().getSelectedItem())) {
                    mtmrpr.setCodigoProveedor(pr);
                }
            }
            miSesion.saveOrUpdate(mtmrpr);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro editado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al intentar actualizar  registro");
        }

    }

    /**
     * realiza la transaccion para eliminar un registro de materia prima en la
     * bd
     */
    public void transaccionEliminarMateriaPrima() {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 2);
            MateriaPrima m = (MateriaPrima) miSesion.get(MateriaPrima.class, Main.getPrincipalAdmin().getMatprima().ObjetoTablaConDatos().getIdTabla());
            m.setCodigoEstado(e);
            miSesion.saveOrUpdate(m);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro eliminado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al Intentar eliminar registro");
        }

    }

    public void trnasaccionRegistrarIngresoMateriaPrima(FormularioRegistrarIngresoMateriaPrima f, TablaMateriaPrima tabla) {
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            MateriaPrima m = (MateriaPrima) miSesion.get(MateriaPrima.class, tabla.getIdTabla());
            Estado e = (Estado) miSesion.get(Estado.class, 1);
            IngresoMateriaPrima g = new IngresoMateriaPrima();

            g.setCodigoMateriaPrima(m);
            g.setTotalEnvases(Double.parseDouble(f.getTxttotalEnvases().getText()));
            g.setUdPorEnvase(Double.parseDouble(f.getTxtUdsPorEnvase().getText()));
            g.setPrecioTotal(Double.parseDouble(f.getTxtPrecioTotal().getText()));
            g.setCodigoEstado(e);

            miSesion.save(g);

            miSesion.getTransaction().commit();
            showMessageDialog(null, "Nuevo registro creado con exito");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(jop, "Error al intentar crear  registro :" + ex.getMessage(), "Informacion", JOptionPane.ERROR_MESSAGE);

        }

    }

    /**
     * realiza la transaccion para eliminar un registro de materia prima en la
     * bd
     */
    public void transaccionEliminarIngresoMateriaPrima() {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 2);
            IngresoMateriaPrima im = (IngresoMateriaPrima) miSesion.get(IngresoMateriaPrima.class, Main.getPrincipalAdmin().getIngmatprima().ObjetoTablaConDatos().getIdTabla());
            im.setCodigoEstado(e);
            miSesion.saveOrUpdate(im);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro eliminado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al Intentar eliminar registro");
            JOptionPane.showMessageDialog(jop, "Error :" + ex.getMessage(), "Informacion", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void transaccionEditarIngresoMateriaPrima(FormularioEditarIngresoMateriaPrima f) {
        Date date = new Date();
        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            miSesion.beginTransaction();
            String idIMp = Main.getPrincipalAdmin().getIngmatprima().ObjetoTablaConDatos().getIdTabla().toString();
            IngresoMateriaPrima im = (IngresoMateriaPrima) miSesion.get(IngresoMateriaPrima.class, Integer.parseInt(idIMp));
            im.setTotalEnvases(Double.parseDouble(f.getTxttotalEnvases().getText()));
            im.setUdPorEnvase(Double.parseDouble(f.getTxtUdsPorEnvase().getText()));
            im.setPrecioTotal(Double.parseDouble(f.getTxtPrecioTotal().getText()));
            im.setFecha(f.getDateFecha().getDatoFecha());
            miSesion.saveOrUpdate(im);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro editado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al intentar actualizar  registro");
        }

    }
}
