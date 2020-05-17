package operacionesGasto;

import conexion.ConexionHibernate;
import entidades.Estado;
import entidades.Gasto;
import formularios.FormularioEditarGasto;
import formularios.FormularioRegistrarNuevoGasto;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import clasesUtilidadGeneral.OperacionesUtiles;
import org.hibernate.Session;
import principal.Main;

/**
 *
 * @author TELCOM MPC
 */
public class ABM_Gasto {

    OperacionesUtiles opUtl = new OperacionesUtiles();
    JOptionPane jop = new JOptionPane();

    public boolean ejecutarRegistrarGasto(FormularioRegistrarNuevoGasto f) {
        //verificar que no hayan campos vacios
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos(), "El campo TOTAL GASTADO es obligatorio")) {
            transaccionRegistrarGasto(f);
            f.dispose();
            return true;
        }
        return false;
    }

    public boolean ejecutarEditarGasto(FormularioEditarGasto f) {
        if (opUtl.verificarCamposTextoVacios(f.getListaCampos(), "El campo TOTAL GASTADO es obligatorio")) {
            transaccionEditarGasto(f);
            f.dispose();
            return true;
        }
        return false;
    }

    public boolean ejecutarEliminarGasto() {
        transaccionEliminarGasto();
        return true;
    }

    public boolean transaccionRegistrarGasto(FormularioRegistrarNuevoGasto f) {

        Session miSesion = ConexionHibernate.tomarConexion();

        try {
            miSesion.beginTransaction();

            Gasto g = new Gasto();

            Estado e = (Estado) miSesion.get(Estado.class, 1);

            g.setDescripcion(f.getTxtDescripcion().getText());
            g.setPrecioTotal(Double.valueOf(f.getTxtTotlaGasatado().getText()));
            g.setFecha(f.getrSDateChooser().getDatoFecha());
            g.setCodigoEstado(e);
            miSesion.save(g);
            miSesion.getTransaction().commit();

            new OperacionesUtiles().notificar(1);

            return true;
        } catch (Exception e) {
            new OperacionesUtiles().notificar(4);
            return false;
        }

    }

    public void transaccionEditarGasto(FormularioEditarGasto f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            miSesion.beginTransaction();

            String idGasto = Main.getPrincipalAdmin().getGastos().ObjetoTablaConDatos().getIdTabla().toString();
            Gasto g = (Gasto) miSesion.get(Gasto.class, Integer.parseInt(idGasto));
            g.setDescripcion(f.getTxtDescripcion().getText());
            g.setPrecioTotal(Double.valueOf(f.getTxtTotalGastado().getText()));
            try {
                f.getrSDateChooser1().getDatoFecha();
            } catch (NullPointerException e) {
                g.setFecha(f.getrSDateChooser1().getDatoFecha());
            }
            miSesion.saveOrUpdate(g);
            miSesion.getTransaction().commit();
          new OperacionesUtiles().notificar(2);
        } catch (Exception ex) {
            new OperacionesUtiles().notificar(5);
        }

    }

    public void transaccionEliminarGasto() {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 2);
            Gasto g = (Gasto) miSesion.get(Gasto.class, Main.getPrincipalAdmin().getGastos().ObjetoTablaConDatos().getIdTabla());
            g.setCodigoEstado(e);
            miSesion.saveOrUpdate(g);
            miSesion.getTransaction().commit();
            new OperacionesUtiles().notificar(3);
        } catch (Exception ex) {
            new OperacionesUtiles().notificar(6);
        }

    }

}
