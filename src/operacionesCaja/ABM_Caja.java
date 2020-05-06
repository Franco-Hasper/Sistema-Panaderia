package operacionesCaja;

import conexion.ConexionHibernate;
import entidades.CorteCaja;
import entidades.Estado;
import formularios.FormularioCorteDiario;
import formularios.FormularioEditarCorte;
import static javax.swing.JOptionPane.showMessageDialog;
import clasesUtilidadGeneral.OperacionesUtiles;
import org.hibernate.Session;
import principal.Main;

/**
 *
 * @author Franco Hasper
 */
public class ABM_Caja {

    OperacionesUtiles opU = new OperacionesUtiles();

    /**
     * Ejecuta el metodo transaccionRegistrarCorteCaja y cierra el formulario,si
     * la accion es exitosa retorna true, de lo contrario retorna false.
     *
     * @param f
     * @return
     */
    public boolean ejecutarRegistrarCoteCaja(FormularioCorteDiario f) {

        if (transaccionRegistrarCorteCaja(f)) {
            f.dispose();
            return true;
        }
        return false;

    }

    /**
     * Verifica que todos los campos obligatorios del formulario hayan sido
     * completados y ejecuta el metodo transaccionEditarCorte y cierra el
     * formulario,si la accion es exitosa retorna true, de lo contrario retorna
     * false.
     *
     * @param f
     * @return
     */
    public boolean ejecutarEditarCorteCaja(FormularioEditarCorte f) {
        //verificar que no hayan campos vacios
        if (opU.verificarCamposTextoVacios(f.getListaCampos())) {
            transaccionEditarCorte(f);
            f.dispose();
            return true;
        }
        return false;
    }

    /**
     * Ejecuta el metodo transaccionEliminarCorteCaja y retorna true.
     *
     * @return
     */
    public boolean ejecutarEliminarCorteCaja() {
        transaccionEliminarCorteCaja();
        return true;
    }

    /**
     * Permite actualizar los datos de CorteCaja en la base de datos.
     *
     * @param f
     */
    public void transaccionEditarCorte(FormularioEditarCorte f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            String idCorteCaja = Main.getPrincipalAdmin().getCaja().ObjetoTablaConDatos().getIdTabla().toString();
            CorteCaja c = (CorteCaja) miSesion.get(CorteCaja.class, Integer.parseInt(idCorteCaja));
            c.setTotalIngresos(Double.valueOf(f.getTxtTotalIngresos().getText()));
            c.setTotalEgresos(Double.valueOf(f.getTxtTotalEgresos().getText()));
            c.setBalance(Double.valueOf(f.getTxtBalance().getText()));
            System.out.println(f.getrSDateChooser().getDatoFecha());
            if (f.getrSDateChooser().getDatoFecha() == (null)) {
            } else {
                c.setFecha(f.getrSDateChooser().getDatoFecha());
            }
            miSesion.saveOrUpdate(c);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro editado con exito");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Pemite registrar un nuevo Corte de caja en la base de datos.
     *
     * @param f
     * @return
     */
    public boolean transaccionRegistrarCorteCaja(FormularioCorteDiario f) {
        Session miSesion = ConexionHibernate.tomarConexion();

        try {
            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 1);
            Double totalIngreso = Double.valueOf(f.getLblTotalEntradas().getText());
            Double totalEgresos = Double.valueOf(f.getLblTotalSlidas().getText());
            Double balance = Double.valueOf(f.getLblBalance().getText());

            CorteCaja c = new CorteCaja(totalIngreso, totalEgresos, balance, e);

            miSesion.save(c);

            miSesion.getTransaction().commit();

            showMessageDialog(null, "Corte registrado con exito");
            return true;
        } catch (Exception e) {
            showMessageDialog(null, "Ocurrio un error al intenetar crear el registro");
            return false;
        }
    }

    /**
     * Permite cambiar de estado a un corte de caja registrado en la base de
     * datos.
     */
    public void transaccionEliminarCorteCaja() {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 2);
            Integer idCorteCaja = Main.getPrincipalAdmin().getCaja().ObjetoTablaConDatos().getIdTabla();
            CorteCaja c = (CorteCaja) miSesion.get(CorteCaja.class, idCorteCaja);
            c.setCodigoEstado(e);
            miSesion.saveOrUpdate(c);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro eliminado con exito");
        } catch (Exception ex) {
            showMessageDialog(null, "Error al Intentar eliminar registro");
        }

    }
}
