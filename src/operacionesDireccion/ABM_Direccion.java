package operacionesDireccion;

import formularios.FormularioEditarDireccion;
import formularios.FormularioRegistrarDireccion;
import operacionesCliente.ABM_Cliente;
import operacionesProveedor.ABM_Proveedor;
import principal.Main;

/**
 *
 * @author FRANCO
 */
public class ABM_Direccion {

    String entidad;

    ABM_Cliente abmCl = new ABM_Cliente();
    ABM_Proveedor abmPr = new ABM_Proveedor();
    TablaDireccion t = new TablaDireccion();

    public void ejecutarRegistrarDireccion(FormularioRegistrarDireccion f) {
        switch (getEntidad()) {
            case "cliente":
                if (abmCl.ejecutarRegistrarDireccionCliente(f)) {
                    t.ejecutarRellenarTablaDireccionCliente(Main.getPrincipalAdmin().getDireccion());
                }
                break;
            case "proveedor":
                if (abmPr.ejecutarRegistrarDireccionProveedor(f)) {
                    t.ejecutarRellenarTablaDireccionProveedor(Main.getPrincipalAdmin().getDireccion());
                }
                break;
        }
    }

    public void ejecutarEditarDireccion(FormularioEditarDireccion f) {
        switch (getEntidad()) {
            case "cliente":
                if (abmCl.ejecutarEditarDireccionCliente(f)) {
                    t.ejecutarRellenarTablaDireccionCliente(Main.getPrincipalAdmin().getDireccion());
                }
                break;
            case "proveedor":
                if (abmPr.ejecutarEditarDireccionProveedor(f)) {
                    t.ejecutarRellenarTablaDireccionProveedor(Main.getPrincipalAdmin().getDireccion());
                }
                break;
        }
    }

    public void ejecutarElminarDireccion() {
        switch (getEntidad()) {
            case "cliente":
                if (abmCl.ejecutarElminarDireccionCliente()) {
                    t.ejecutarRellenarTablaDireccionCliente(Main.getPrincipalAdmin().getDireccion());
                }
                break;
            case "proveedor":
                if (abmPr.ejecutarElminarDireccionProveedor()) {
                    t.ejecutarRellenarTablaDireccionProveedor(Main.getPrincipalAdmin().getDireccion());
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
