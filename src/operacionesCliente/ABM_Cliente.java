package operacionesCliente;

import calsesPadre.Consultas;
import conexion.ConexionHibernate;
import entidades.Cliente;
import entidades.Direccion_Cliente;
import entidades.Estado;
import entidades.Localidad;
import entidades.Provincia;
import entidades.RazonSocial;
import entidades.TelefonoCliente;
import entidades.TipoCliente;
import entidades.TipoDomicilio;
import entidades.TipoTelefono;
import formularios.FormularioEditarCliente;
import formularios.FormularioEditarDireccion;
import formularios.FormularioEditarTelefono;
import formularios.FormularioRegistrarCliente;
import formularios.FormularioRegistrarDireccion;
import formularios.FormularioRegistrarTelefono;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import clasesUtilidadGeneral.OperacionesUtiles;
import org.hibernate.Session;
import principal.Main;

/**
 * @author Hasper Franco
 */
public class ABM_Cliente extends Consultas {

    OperacionesUtiles opUtl = new OperacionesUtiles();
    JOptionPane jop = new JOptionPane();

    /**
     * Verifica que todos los campos obligatorios del formulario hayan sido
     * completados y ejecuta el metodo transaccionRegistrarCliente y cierra el
     * formulario,si la accion es exitosa retorna true, de lo contrario retorna
     * false. false.
     *
     * @param f
     * @return
     */
    public boolean ejecutarRegistrarCliente(FormularioRegistrarCliente f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionRegistrarCliente(f);
            f.dispose();
            return true;
        }
        return false;
    }

    /**
     * Verifica que todos los campos obligatorios del formulario hayan sido
     * completados y ejecuta el metodo transaccionRegistrarDireccionCliente y
     * cierra el formulario,si la accion es exitosa retorna true, de lo
     * contrario retorna false.
     *
     * @param f
     * @return
     */
    public boolean ejecutarRegistrarDireccionCliente(FormularioRegistrarDireccion f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionRegistrarDireccionCliente(f);
            f.dispose();
            return true;
        }
        return false;
    }

    /**
     * Ejeuta los metodos necesarios para eliminar una direccion del cliente
     * especificado de la base de datos.
     *
     * @return
     */
    public boolean ejecutarElminarDireccionCliente() {
        if (OperacionesUtiles.mensajeEliminarRegistro()) {
            String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
            setConsultaList("from Direccion_Cliente where codigo_cliente=" + idCliente);
            obtenerListaConsulta();
            transaccionEliminarDireccionCliente();
            return true;
        }
        return false;
    }

    /**
     * Ejeuta los metodos necesarios para eliminar un telefono del cliente
     * especificado de la base de datos.
     *
     * @return
     */
    public boolean ejecutarElminarTelefonoCliente() {
        if (OperacionesUtiles.mensajeEliminarRegistro()) {
            String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
            setConsultaList("from TelefonoCliente where codigo_cliente=" + idCliente);
            obtenerListaConsulta();
            transaccionEliminarTelefonoCliente();
            return true;
        }
        return false;
    }

    /**
     * Permite eliminar un telefono del cliente epecificado de la base datos de
     * forma definitiva.
     */
    public void transaccionEliminarTelefonoCliente() {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            String idTelefonoCliente = null;
            int fila = Main.getPrincipalAdmin().getTelefono().getTabla().getSelectedRow();
            String numeroTelefono = Main.getPrincipalAdmin().getTelefono().getTabla().getValueAt(fila, 0).toString();
            String tipoTelefono = Main.getPrincipalAdmin().getTelefono().getTabla().getValueAt(fila, 1).toString();

            miSesion.beginTransaction();
            List lista = this.getListaResultados();
            for (Object o : lista) {
                TelefonoCliente telefono = (TelefonoCliente) o;

                if (telefono.getNuemero().toString().equals(numeroTelefono) && telefono.getCodigoTipoTelefono().getNombre().toString().equals(tipoTelefono)) {
                    idTelefonoCliente = telefono.getIdTelefonoCliente().toString();
                }
            }

            TelefonoCliente tc = (TelefonoCliente) miSesion.get(TelefonoCliente.class, Integer.parseInt(idTelefonoCliente));
            miSesion.delete(tc);

            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro eliminado con exito");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * permite actualizar los datos de un Cliente en la base de datos.
     *
     * @param f
     * @return
     */
    public boolean ejecutarEditarCliente(FormularioEditarCliente f) {
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionEditarCliente(f);
            f.dispose();
            return true;
        }
        return false;
    }

    /**
     * Permite actualizar los datos de la direccion del cliente especificado en
     * la base de datos.
     *
     * @param f
     * @return
     */
    public boolean ejecutarEditarDireccionCliente(FormularioEditarDireccion f) {
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
            setConsultaList("from Direccion_Cliente where codigo_cliente=" + idCliente);
            obtenerListaConsulta();
            transaccionEditarDireccionCliente(f);
            f.dispose();
            return true;
        }
        return false;
    }

    /**
     * Permite actualizar los datos del telefono de un clientente especificado
     * en la base de datos.
     *
     * @param f
     * @return
     */
    public boolean ejecutarEditarTelefonoCliente(FormularioEditarTelefono f) {
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
            setConsultaList("from TelefonoCliente where codigo_cliente=" + idCliente);
            obtenerListaConsulta();
            transaccionEditarTelefonoCliente(f);
            f.dispose();
            return true;
        }
        return false;
    }

    /**
     * Permite registrar un nuevo telefono de un cliente especificado en la base
     * de datos.
     *
     * @param f
     * @return
     */
    public boolean ejecutarRegistrarTelefonoCliente(FormularioRegistrarTelefono f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionRegistrarTelefonoCliente(f);
            f.dispose();
            return true;
        }
        return false;
    }

    /**
     * Ejecuta el metodo transaccionEliminarCliente y retorna true.
     *
     * @return
     */
    public boolean ejecutarEliminarCliente() {
        transaccionEliminarCliente();
        return true;
    }

    /**
     * Permite registrar un nuevo cliente en la base de datos.
     *
     * @param f
     */
    public void transaccionRegistrarCliente(FormularioRegistrarCliente f) {

        Session miSesion = ConexionHibernate.tomarConexion();

        try {
            miSesion.beginTransaction();

            Estado e = (Estado) miSesion.get(Estado.class, 1);

            Cliente c = new Cliente();
            c.setNombre(f.getTxtNombre().getText());
            c.setApellido(f.getTxtApellido().getText());

            if (f.getRadioButon().isSelected()) {

                RazonSocial rs = (RazonSocial) miSesion.get(RazonSocial.class, 1);

                c.setCodigoRazonSocial(rs);
            } else {
                RazonSocial rs = new RazonSocial();
                rs.setNombre(f.getTxtRazonSocial().getText());
                miSesion.save(rs);
                c.setCodigoRazonSocial(rs);
            }

            TipoCliente tc = (TipoCliente) miSesion.get(TipoCliente.class, 2);
            c.setCodigoTipoCliente(tc);

            c.setCodigoEstado(e);

            miSesion.save(c);

            TelefonoCliente tlc = new TelefonoCliente();

            tlc.setCodigoCliente(c);
            tlc.setNuemero(Integer.parseInt(f.getTxtTelefono().getText()));

            List<TipoTelefono> lista_tipotelefono
                    = (List<TipoTelefono>) miSesion.createQuery("from TipoTelefono").list();
            for (TipoTelefono tt : lista_tipotelefono) {
                if (tt.getNombre().equals(f.getBoxTipoTelefono().getSelectedItem())) {
                    tlc.setCodigoTipoTelefono(tt);
                }
            }
            miSesion.save(tlc);

            Direccion_Cliente dc = new Direccion_Cliente();

            List<TipoDomicilio> lista_tipodomicilio
                    = (List<TipoDomicilio>) miSesion.createQuery("from TipoDomicilio").list();
            for (TipoDomicilio tdm : lista_tipodomicilio) {
                if (tdm.getNombre().equals(f.getBoxtipoDom().getSelectedItem())) {
                    dc.setCodigoTipoDomicilio(tdm);
                }
            }

            dc.setCodigoCliente(c);
            dc.setNombre(f.getTxtDireccion().getText());
            dc.setNumero(Integer.parseInt(f.getTxtnuemroDireccion().getText()));

            List<Localidad> lista_Lc
                    = (List<Localidad>) miSesion.createQuery("from Localidad").list();
            List<Provincia> lista_Pr
                    = (List<Provincia>) miSesion.createQuery("from Provincia").list();

            for (Localidad lc : lista_Lc) {
                if (lc.getNombre().equals(f.getBoxLocalidad().getSelectedItem())) {
                    dc.setCodigoLocalidad(lc);
                    for (Provincia pr : lista_Pr) {
                        if (pr.getNombre().equals(f.getBoxProvincia().getSelectedItem())) {
                            lc.setCodigoProvincia(pr);
                        }
                    }
                }
            }

            miSesion.save(dc);

            miSesion.getTransaction().commit();

            showMessageDialog(null, "Nuevo registro creado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al intentar crear  registro");
        }

    }

    /**
     * Prmite actualizar los datos del cliente especificado en la base de datos.
     *
     * @param f
     */
    public void transaccionEditarCliente(FormularioEditarCliente f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            miSesion.beginTransaction();

            String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
            Cliente c = (Cliente) miSesion.get(Cliente.class, Integer.parseInt(idCliente));

            c.setNombre(f.getTxtNombre().getText());

            c.setApellido(f.getTxtApellido().getText());

            if (f.getRadioButon().isSelected()) {
                RazonSocial rs = (RazonSocial) miSesion.get(RazonSocial.class, 1);
                c.setCodigoRazonSocial(rs);

            } else {
                RazonSocial rs = (RazonSocial) miSesion.get(RazonSocial.class, (c.getCodigoRazonSocial().getIdRazonSocial()));
                rs.setNombre(f.getTxtRazonSocial().getText());

                miSesion.saveOrUpdate(rs);
                c.setCodigoRazonSocial(rs);
            }

            miSesion.saveOrUpdate(c);

            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro editado con exito");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Permite registra una nueva direccion para el cliente especificado en la
     * base de datos.
     *
     * @param f
     */
    public void transaccionRegistrarDireccionCliente(FormularioRegistrarDireccion f) {

        Session miSesion = ConexionHibernate.tomarConexion();

        try {
            miSesion.beginTransaction();

            String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
            Cliente c = (Cliente) miSesion.get(Cliente.class, Integer.parseInt(idCliente));

            Direccion_Cliente dc = new Direccion_Cliente();

            List<TipoDomicilio> lista_tipodomicilio
                    = (List<TipoDomicilio>) miSesion.createQuery("from TipoDomicilio").list();
            for (TipoDomicilio tdm : lista_tipodomicilio) {
                if (tdm.getNombre().equals(f.getBoxtipoDom().getSelectedItem())) {
                    dc.setCodigoTipoDomicilio(tdm);
                }
            }

            dc.setCodigoCliente(c);
            dc.setNombre(f.getTxtDireccion().getText());
            dc.setNumero(Integer.parseInt(f.getTxtnuemroDireccion().getText()));

            List<Localidad> lista_Lc
                    = (List<Localidad>) miSesion.createQuery("from Localidad").list();
            List<Provincia> lista_Pr
                    = (List<Provincia>) miSesion.createQuery("from Provincia").list();

            for (Localidad lc : lista_Lc) {
                if (lc.getNombre().equals(f.getBoxLocalidad().getSelectedItem())) {
                    dc.setCodigoLocalidad(lc);
                    for (Provincia pr : lista_Pr) {
                        if (pr.getNombre().equals(f.getBoxProvincia().getSelectedItem())) {
                            lc.setCodigoProvincia(pr);
                        }
                    }
                }
            }

            miSesion.save(dc);

            miSesion.getTransaction().commit();

            showMessageDialog(null, "Nuevo registro creado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al intentar crear  registro");
        }

    }

    /**
     * Permite registrar un nuevo telefono para el cliente especificado en la
     * base de datos.
     *
     * @param f
     */
    public void transaccionRegistrarTelefonoCliente(FormularioRegistrarTelefono f) {

        Session miSesion = ConexionHibernate.tomarConexion();

        try {
            miSesion.beginTransaction();

            String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
            Cliente c = (Cliente) miSesion.get(Cliente.class, Integer.parseInt(idCliente));

            TelefonoCliente tlc = new TelefonoCliente();

            tlc.setCodigoCliente(c);
            tlc.setNuemero(Integer.parseInt(f.getTxtTelefono().getText()));

            List<TipoTelefono> lista_tipotelefono
                    = (List<TipoTelefono>) miSesion.createQuery("from TipoTelefono").list();
            for (TipoTelefono tt : lista_tipotelefono) {
                if (tt.getNombre().equals(f.getBoxTipoTelefono().getSelectedItem())) {
                    tlc.setCodigoTipoTelefono(tt);
                }
            }
            miSesion.save(tlc);

            miSesion.getTransaction().commit();

            showMessageDialog(null, "Nuevo registro creado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al intentar crear  registro");
        }

    }

    /**
     * Permite actualizar la direccion del cleiente especificado en la base de
     * datos.
     *
     * @param f
     */
    public void transaccionEditarDireccionCliente(FormularioEditarDireccion f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            String idDireccionCliente = null;
            int fila = Main.getPrincipalAdmin().getDireccion().getTabla().getSelectedRow();
            String nombreDireccion = Main.getPrincipalAdmin().getDireccion().getTabla().getValueAt(fila, 0).toString();
            String numeroDireccion = Main.getPrincipalAdmin().getDireccion().getTabla().getValueAt(fila, 1).toString();
            miSesion.beginTransaction();
            List lista = this.getListaResultados();
            for (Object o : lista) {
                Direccion_Cliente direccion = (Direccion_Cliente) o;

                if (direccion.getNombre().toString().equals(nombreDireccion) && direccion.getNumero().toString().equals(numeroDireccion)) {
                    idDireccionCliente = direccion.getIdDireccionCliente().toString();
                }
            }

            Direccion_Cliente dc = (Direccion_Cliente) miSesion.get(Direccion_Cliente.class, Integer.parseInt(idDireccionCliente));
            dc.setNombre(f.getTxtDireccion().getText());

            dc.setNumero(Integer.valueOf(f.getTxtnuemroDireccion().getText()));

            List<TipoDomicilio> lista_tipodomicilio
                    = (List<TipoDomicilio>) miSesion.createQuery("from TipoDomicilio").list();
            for (TipoDomicilio tdm : lista_tipodomicilio) {
                if (tdm.getNombre().equals(f.getBoxtipoDom().getSelectedItem())) {
                    dc.setCodigoTipoDomicilio(tdm);
                }
            }

            List<Localidad> lista_Lc
                    = (List<Localidad>) miSesion.createQuery("from Localidad").list();

            for (Localidad lc : lista_Lc) {
                if (lc.getNombre().equals(f.getBoxLocalidad().getSelectedItem())) {
                    dc.setCodigoLocalidad(lc);
                }
            }

            miSesion.saveOrUpdate(dc);

            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro editado con exito");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Permite actualizar la deireccion del cliente especificado en la bas e de
     * datos.
     *
     * @param f
     */
    public void transaccionEditarTelefonoCliente(FormularioEditarTelefono f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            String idTelefonoCliente = null;
            int fila = Main.getPrincipalAdmin().getTelefono().getTabla().getSelectedRow();
            String numeroTelefono = Main.getPrincipalAdmin().getTelefono().getTabla().getValueAt(fila, 0).toString();
            String tipoTelefono = Main.getPrincipalAdmin().getTelefono().getTabla().getValueAt(fila, 1).toString();

            miSesion.beginTransaction();
            List lista = this.getListaResultados();
            for (Object o : lista) {
                TelefonoCliente telefono = (TelefonoCliente) o;

                if (telefono.getNuemero().toString().equals(numeroTelefono) && telefono.getCodigoTipoTelefono().getNombre().toString().equals(tipoTelefono)) {
                    idTelefonoCliente = telefono.getIdTelefonoCliente().toString();
                }
            }

            TelefonoCliente tc = (TelefonoCliente) miSesion.get(TelefonoCliente.class, Integer.parseInt(idTelefonoCliente));

            tc.setNuemero(Integer.valueOf(f.getTxtTelefono().getText()));

            List<TipoTelefono> lista_tipotelefono = (List<TipoTelefono>) miSesion.createQuery("from TipoTelefono").list();
            for (TipoTelefono tt : lista_tipotelefono) {
                if (tt.getNombre().equals(f.getBoxTipoTelefono().getSelectedItem())) {
                    tc.setCodigoTipoTelefono(tt);
                }
            }

            miSesion.saveOrUpdate(tc);

            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro editado con exito");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Permite cambiar de estado a un cliente especificado, por lo que este ya
     * no aparece en los resultados de busqueda.
     */
    public void transaccionEliminarCliente() {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 2);
            Cliente c = (Cliente) miSesion.get(Cliente.class, Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla());
            c.setCodigoEstado(e);
            miSesion.saveOrUpdate(c);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro eliminado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al Intentar eliminar registro");
        }

    }

    /**
     * Elimina una direccion de cliente especificado de la base de datos.
     */
    public void transaccionEliminarDireccionCliente() {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            String idDireccionCliente = null;
            int fila = Main.getPrincipalAdmin().getDireccion().getTabla().getSelectedRow();
            String nombreDireccion = Main.getPrincipalAdmin().getDireccion().getTabla().getValueAt(fila, 0).toString();
            String numeroDireccion = Main.getPrincipalAdmin().getDireccion().getTabla().getValueAt(fila, 1).toString();
            miSesion.beginTransaction();
            List lista = this.getListaResultados();
            for (Object o : lista) {
                Direccion_Cliente direccion = (Direccion_Cliente) o;
                if (direccion.getNombre().toString().equals(nombreDireccion) && direccion.getNumero().toString().equals(numeroDireccion)) {
                    idDireccionCliente = direccion.getIdDireccionCliente().toString();
                }
            }

            Direccion_Cliente dc = (Direccion_Cliente) miSesion.get(Direccion_Cliente.class, Integer.parseInt(idDireccionCliente));

            miSesion.delete(dc);

            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro eliminado con exito");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
