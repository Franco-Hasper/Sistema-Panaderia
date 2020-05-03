package operacionesTelefono;

import formularios.FormularioEditarTelefono;
import formularios.FormularioRegistrarTelefono;
import operacionesCliente.ABM_Cliente;
import operacionesProveedor.ABM_Proveedor;
import principal.Main;

/**
 *
 * @author FRANCO
 */
public class ABM_Telefono {

    String entidad;

    ABM_Cliente abmCl = new ABM_Cliente();
    ABM_Proveedor abmPr = new ABM_Proveedor();
    TablaTelefono t = new TablaTelefono();

    public void ejecutarRegistrarTelefono(FormularioRegistrarTelefono f) {
        switch (getEntidad()) {
            case "cliente":
                if (abmCl.ejecutarRegistrarTelefonoCliente(f)) {
                    t.ejecutarRellenarTablaTelefonoCliente(Main.getPrincipalAdmin().getTelefono());
                }
                break;
            case "proveedor":
                if (abmPr.ejecutarRegistrarTelefonoProveedor(f)) {
                    t.ejecutarRellenarTablaTelefonoProveedor(Main.getPrincipalAdmin().getTelefono());
                }
                break;
        }
    }

    public void ejecutarEditarTelefono(FormularioEditarTelefono f) {
        switch (getEntidad()) {
            case "cliente":
                if (abmCl.ejecutarEditarTelefonoCliente(f)) {
                    t.ejecutarRellenarTablaTelefonoCliente(Main.getPrincipalAdmin().getTelefono());
                }
                break;
            case "proveedor":
                if (abmPr.ejecutarEditarTelefonoProveedor(f)) {
                    t.ejecutarRellenarTablaTelefonoProveedor(Main.getPrincipalAdmin().getTelefono());
                }
                break;
        }
    }

    public void ejecutarEliminarTelefono() {
        switch (getEntidad()) {
            case "cliente":
                if (abmCl.ejecutarElminarTelefonoCliente()) {
                    t.ejecutarRellenarTablaTelefonoCliente(Main.getPrincipalAdmin().getTelefono());
                }
                break;
            case "proveedor":
                if (abmPr.ejecutarEliminarTelefonoProveedor()) {
                    t.ejecutarRellenarTablaTelefonoProveedor(Main.getPrincipalAdmin().getTelefono());
                }
                break;
        }

    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

}
