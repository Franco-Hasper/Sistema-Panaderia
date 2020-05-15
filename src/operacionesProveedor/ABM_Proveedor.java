package operacionesProveedor;

import calsesPadre.Consultas;
import conexion.ConexionHibernate;
import entidades.Direccion_Proveedor;
import entidades.Estado;
import entidades.Localidad;
import entidades.Proveedor;
import entidades.Provincia;
import entidades.TelefonoProveedor;
import entidades.TipoTelefono;
import formularios.FormularioEditarDireccion;
import formularios.FormularioEditarProveedor;
import formularios.FormularioEditarTelefono;
import formularios.FormularioRegistrarDireccion;
import formularios.FormularioRegistrarProveedor;
import formularios.FormularioRegistrarTelefono;
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
public class ABM_Proveedor extends Consultas {

    OperacionesUtiles opUtl = new OperacionesUtiles();
    JOptionPane jop = new JOptionPane();

    public boolean ejecutarRegistrarProveedor(FormularioRegistrarProveedor f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionRegistrarProveedor(f);
            f.dispose();
            return true;
        }
        return false;
    }

    public boolean ejecutarEditarProveedor(FormularioEditarProveedor f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionEditarProveedor(f);
            f.dispose();
            return true;
        }
        return false;
    }

    public boolean ejecutarElminarDireccionProveedor() {
        if (OperacionesUtiles.mensajeEliminarRegistro()) {
            String idProveedor = Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla().toString();
            setConsultaList("from Direccion_Proveedor where codigo_proveedor=" + idProveedor);
            obtenerListaConsulta();
            transaccionEliminarDireccionProveedor();
            return true;
        }
        return false;
    }

    public boolean ejecutarRegistrarTelefonoProveedor(FormularioRegistrarTelefono f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionRegistrarTelefonoProveedor(f);
            f.dispose();
            return true;
        }
        return false;
    }

    public boolean ejecutarEliminarProveedor() {
        transaccionEliminarProveedor();
        return true;
    }

    public boolean ejecutarEditarDireccionProveedor(FormularioEditarDireccion f) {
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            String idProveedor = Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla().toString();
            setConsultaList("from Direccion_Proveedor where codigo_proveedor=" + idProveedor);
            obtenerListaConsulta();
            transaccionEditarDireccionProveedor(f);
            f.dispose();
            return true;
        }
        return false;
    }

    public void transaccionEditarDireccionProveedor(FormularioEditarDireccion f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            String idDireccionProveedor = null;
            int fila = Main.getPrincipalAdmin().getDireccion().getTabla().getSelectedRow();
            String nombreDireccion = Main.getPrincipalAdmin().getDireccion().getTabla().getValueAt(fila, 0).toString();
            String numeroDireccion = Main.getPrincipalAdmin().getDireccion().getTabla().getValueAt(fila, 1).toString();
            miSesion.beginTransaction();
            List lista = this.getListaResultados();
            for (Object o : lista) {
                Direccion_Proveedor direccion = (Direccion_Proveedor) o;

                if (direccion.getNombre().toString().equals(nombreDireccion) && direccion.getNumero().toString().equals(numeroDireccion)) {
                    idDireccionProveedor = direccion.getIdDireccionProveedor().toString();
                }
            }

            Direccion_Proveedor dp = (Direccion_Proveedor) miSesion.get(Direccion_Proveedor.class, Integer.parseInt(idDireccionProveedor));
            dp.setNombre(f.getTxtDireccion().getText());

            dp.setNumero(Integer.valueOf(f.getTxtnuemroDireccion().getText()));

            List<Localidad> lista_Lc
                    = (List<Localidad>) miSesion.createQuery("from Localidad").list();

            for (Localidad lc : lista_Lc) {
                if (lc.getNombre().equals(f.getBoxLocalidad().getSelectedItem())) {
                    dp.setCodigoLocalidad(lc);
                }
            }

            miSesion.saveOrUpdate(dp);

            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro editado con exito");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean ejecutarRegistrarDireccionProveedor(FormularioRegistrarDireccion f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionRegistrarDireccionProveedor(f);
            f.dispose();
            return true;
        }
        return false;
    }

    public void transaccionRegistrarDireccionProveedor(FormularioRegistrarDireccion f) {

        Session miSesion = ConexionHibernate.tomarConexion();

        try {
            miSesion.beginTransaction();

            String idProveedor = Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla().toString();
            Proveedor p = (Proveedor) miSesion.get(Proveedor.class, Integer.parseInt(idProveedor));

            Direccion_Proveedor dp = new Direccion_Proveedor();

            dp.setCodigoProveedor(p);
            dp.setNombre(f.getTxtDireccion().getText());
            dp.setNumero(Integer.parseInt(f.getTxtnuemroDireccion().getText()));

            List<Localidad> lista_Lc
                    = (List<Localidad>) miSesion.createQuery("from Localidad").list();
            List<Provincia> lista_Pr
                    = (List<Provincia>) miSesion.createQuery("from Provincia").list();

            for (Localidad lc : lista_Lc) {
                if (lc.getNombre().equals(f.getBoxLocalidad().getSelectedItem())) {
                    dp.setCodigoLocalidad(lc);
                    for (Provincia pr : lista_Pr) {
                        if (pr.getNombre().equals(f.getBoxProvincia().getSelectedItem())) {
                            lc.setCodigoProvincia(pr);
                        }
                    }
                }
            }

            miSesion.save(dp);

            miSesion.getTransaction().commit();

            showMessageDialog(null, "Nuevo registro creado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al intentar crear  registro");
        }

    }

    public boolean ejecutarEditarTelefonoProveedor(FormularioEditarTelefono f) {
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            String idProveedor = Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla().toString();
            setConsultaList("from TelefonoProveedor where codigo_proveedor=" + idProveedor);
            obtenerListaConsulta();
            transaccionEditarTelefonoProveedor(f);
            f.dispose();
            return true;
        }
        return false;
    }

    public boolean ejecutarEliminarTelefonoProveedor() {
        if (OperacionesUtiles.mensajeEliminarRegistro()) {
            String idProveedor = Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla().toString();
            setConsultaList("from TelefonoProveedor where codigo_proveedor=" + idProveedor);
            obtenerListaConsulta();
            transaccionEliminarTelefonoProveedor();
            return true;
        }
        return false;
    }

    public void transaccionEliminarTelefonoProveedor() {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            String idTelefonoProveedor = null;
            int fila = Main.getPrincipalAdmin().getTelefono().getTabla().getSelectedRow();
            String numeroTelefono = Main.getPrincipalAdmin().getTelefono().getTabla().getValueAt(fila, 0).toString();
            String tipoTelefono = Main.getPrincipalAdmin().getTelefono().getTabla().getValueAt(fila, 1).toString();

            miSesion.beginTransaction();
            List lista = this.getListaResultados();
            for (Object o : lista) {
                TelefonoProveedor telefono = (TelefonoProveedor) o;

                if (telefono.getNuemero().toString().equals(numeroTelefono) && telefono.getCodigoTipoTelefono().getNombre().toString().equals(tipoTelefono)) {
                    idTelefonoProveedor = telefono.getIdTelefonoProveedor().toString();
                }
            }

            TelefonoProveedor tp = (TelefonoProveedor) miSesion.get(TelefonoProveedor.class, Integer.parseInt(idTelefonoProveedor));
            miSesion.delete(tp);

            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro eliminado con exito");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void transaccionRegistrarTelefonoProveedor(FormularioRegistrarTelefono f) {

        Session miSesion = ConexionHibernate.tomarConexion();

        try {
            miSesion.beginTransaction();

            String idProveedor = Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla().toString();
            Proveedor p = (Proveedor) miSesion.get(Proveedor.class, Integer.parseInt(idProveedor));

            TelefonoProveedor tlp = new TelefonoProveedor();

            tlp.setCodigoProveedor(p);
            tlp.setNuemero(f.getTxtTelefono().getText());

            List<TipoTelefono> lista_tipotelefono
                    = (List<TipoTelefono>) miSesion.createQuery("from TipoTelefono").list();
            for (TipoTelefono tt : lista_tipotelefono) {
                if (tt.getNombre().equals(f.getBoxTipoTelefono().getSelectedItem())) {
                    tlp.setCodigoTipoTelefono(tt);
                }
            }
            miSesion.save(tlp);

            miSesion.getTransaction().commit();

            showMessageDialog(null, "Nuevo registro creado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al intentar crear  registro");
        }

    }

    public void transaccionEditarTelefonoProveedor(FormularioEditarTelefono f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            String idTelefonoProveedor = null;
            int fila = Main.getPrincipalAdmin().getTelefono().getTabla().getSelectedRow();
            String numeroTelefono = Main.getPrincipalAdmin().getTelefono().getTabla().getValueAt(fila, 0).toString();
            String tipoTelefono = Main.getPrincipalAdmin().getTelefono().getTabla().getValueAt(fila, 1).toString();

            miSesion.beginTransaction();
            List lista = this.getListaResultados();
            for (Object o : lista) {
                TelefonoProveedor telefono = (TelefonoProveedor) o;

                if (telefono.getNuemero().toString().equals(numeroTelefono) && telefono.getCodigoTipoTelefono().getNombre().toString().equals(tipoTelefono)) {
                    idTelefonoProveedor = telefono.getIdTelefonoProveedor().toString();
                }
            }

            TelefonoProveedor tp = (TelefonoProveedor) miSesion.get(TelefonoProveedor.class, Integer.parseInt(idTelefonoProveedor));

            tp.setNuemero(f.getTxtTelefono().getText());

            List<TipoTelefono> lista_tipotelefono = (List<TipoTelefono>) miSesion.createQuery("from TipoTelefono").list();
            for (TipoTelefono tt : lista_tipotelefono) {
                if (tt.getNombre().equals(f.getBoxTipoTelefono().getSelectedItem())) {
                    tp.setCodigoTipoTelefono(tt);
                }
            }

            miSesion.saveOrUpdate(tp);

            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro editado con exito //Revisar metodo ObtenerIdTelefono");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void transaccionRegistrarProveedor(FormularioRegistrarProveedor f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 1);
            Proveedor p = new Proveedor();
            p.setNombre(f.getTxtNombre().getText());
            p.setCodigoEstado(e);
            miSesion.save(p);
            TelefonoProveedor tp = new TelefonoProveedor();
            tp.setCodigoProveedor(p);
            tp.setNuemero(f.getTxtTelefono().getText());

            List<TipoTelefono> lista_tipotelefono
                    = (List<TipoTelefono>) miSesion.createQuery("from TipoTelefono").list();
            for (TipoTelefono tt : lista_tipotelefono) {
                if (tt.getNombre().equals(f.getBoxTipoTelefono().getSelectedItem())) {
                    tp.setCodigoTipoTelefono(tt);
                }
            }
            miSesion.save(tp);

            Direccion_Proveedor d = new Direccion_Proveedor();

            d.setCodigoProveedor(p);
            d.setNombre(f.getTxtDireccion().getText());
            d.setNumero(Integer.parseInt(f.getTxtnuemroDireccion().getText()));

            List<Localidad> lista_Lc
                    = (List<Localidad>) miSesion.createQuery("from Localidad").list();
            List<Provincia> lista_Pr
                    = (List<Provincia>) miSesion.createQuery("from Provincia").list();

            for (Localidad lc : lista_Lc) {
                if (lc.getNombre().equals(f.getBoxLocalidad().getSelectedItem())) {
                    d.setCodigoLocalidad(lc);
                    for (Provincia pr : lista_Pr) {
                        if (pr.getNombre().equals(f.getBoxProvincia().getSelectedItem())) {
                            lc.setCodigoProvincia(pr);
                        }
                    }
                }
            }
            miSesion.save(d);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Nuevo registro creado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al intentar crear  registro");
        }

    }

    public void transaccionEliminarDireccionProveedor() {
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            String idDireccionProveedor = null;
            int fila = Main.getPrincipalAdmin().getDireccion().getTabla().getSelectedRow();
            String nombreDireccion = Main.getPrincipalAdmin().getDireccion().getTabla().getValueAt(fila, 0).toString();
            String numeroDireccion = Main.getPrincipalAdmin().getDireccion().getTabla().getValueAt(fila, 1).toString();
            miSesion.beginTransaction();
            List lista = this.getListaResultados();
            for (Object o : lista) {
                Direccion_Proveedor direccion = (Direccion_Proveedor) o;
                if (direccion.getNombre().toString().equals(nombreDireccion) && direccion.getNumero().toString().equals(numeroDireccion)) {
                    idDireccionProveedor = direccion.getIdDireccionProveedor().toString();
                }
            }
            Direccion_Proveedor dp = (Direccion_Proveedor) miSesion.get(Direccion_Proveedor.class, Integer.parseInt(idDireccionProveedor));
            miSesion.delete(dp);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro eliminado con exito");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void transaccionEditarProveedor(FormularioEditarProveedor f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            String idProveedor = Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla().toString();
            Proveedor p = (Proveedor) miSesion.get(Proveedor.class, Integer.parseInt(idProveedor));
            p.setNombre(f.getTxteditarNombre().getText());
            miSesion.saveOrUpdate(p);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro editado con exito");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void transaccionEliminarProveedor() {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 2);
            Proveedor p = (Proveedor) miSesion.get(Proveedor.class, Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla());
            p.setCodigoEstado(e);
            miSesion.saveOrUpdate(p);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro eliminado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al Intentar eliminar registro");
        }

    }

}
