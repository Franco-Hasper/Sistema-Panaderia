package operacionesCuenta;

import conexion.ConexionHibernate;
import entidades.Cuenta;
import org.hibernate.Session;
import principal.Main;

/**
 *
 * @author TELCOM MPC
 */
public class LabelsCuenta {

    public void rellenarLabelBalance() {
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Cuenta cuenta = (Cuenta) miSesion.get(Cuenta.class, Integer.valueOf(Main.getPrincipalAdmin().getCuenta().getBoxCuenta().getSelectedItem().toString()));
            Main.getPrincipalAdmin().getCuenta().getLblBalance().setText(cuenta.getBalance().toString());
        } catch (Exception e) {
        }
    }

}
