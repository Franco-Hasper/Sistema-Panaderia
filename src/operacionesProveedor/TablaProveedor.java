package operacionesProveedor;

import calsesPadre.Tablas;
import entidades.Direccion_Proveedor;
import entidades.Proveedor;
import entidades.TelefonoProveedor;
import escritorios.PrincipalProveedor;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import clasesUtilidadGeneral.OperacionesUtiles;
import principal.Main;

/**
 *
 * @author TELCOM MPC
 */
public class TablaProveedor extends Tablas {

    public TablaProveedor() {
        setEstadoConsulta(0);
    }

    public void ejecutarRellenarTabla(PrincipalProveedor p) {
        setTabla(p.getTabla());
        setStringConsulta("from Proveedor");
        evaluarEstadoConsulta();
        setCampoTexto(p.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaProveedor = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaProveedor);
        //estas dos variables sirven para evitar que se repita un proveedor en la tabla por tener mas de un telefono o direccion (solamente aparece la primera registrada)
        Integer vueltaDir = 0;
        Integer vueltaTel = 0;
        for (Object o : lista) {
            Proveedor pr = (Proveedor) o;
            Vector<Object> fila = new Vector<>();
            Integer resutadoComparacion = (pr.getNombre().toString().indexOf(valorBusqueda));
            boolean resultadoComparacion = OperacionesUtiles.convertirResultado(pr.getNombre(), valorBusqueda);
            if (pr.getCodigoEstado().getIdEstado().equals(1) && resultadoComparacion) {
                fila.add(pr.getNombre());
                List<Direccion_Proveedor> direcciones = pr.getDireccionesProveedores();
                List<TelefonoProveedor> telefonos = pr.getTelefonos();
                if (pr.getDireccionesProveedores().size() == 0) {
                    fila.add("sin registros");
                    fila.add("sin registros");
                    fila.add("sin registros");
                    fila.add("sin registros");
                } else {
                    for (Direccion_Proveedor drPr : direcciones) {
                        if (vueltaDir != 1) {
                            fila.add(drPr.getNombre());
                            fila.add(drPr.getNumero());
                            fila.add(drPr.getCodigoLocalidad().getNombre());
                            fila.add(drPr.getCodigoLocalidad().getCodigoProvincia().getNombre());
                            vueltaDir = 1;
                        }
                    }
                }
                if (pr.getTelefonos().size() == 0) {
                    fila.add("sin registros");
                    fila.add("sin registros");
                } else {
                    for (TelefonoProveedor tlpr : telefonos) {
                        if (vueltaTel != 1) {
                            fila.add(tlpr.getNuemero());
                            fila.add(tlpr.getCodigoTipoTelefono().getNombre());

                            vueltaTel = 1;
                        }
                    }
                }

                vueltaDir = 0;
                vueltaTel = 0;
                tablaProveedor.addRow(fila);
            }
        }
    }

    public void obtenerIdTablaProveedor() {
        int fila = Main.getPrincipalAdmin().getProveedor().getTabla().getSelectedRow();
        String nombreProveedor = Main.getPrincipalAdmin().getProveedor().getTabla().getValueAt(fila, 0).toString();
        for (Object o : getListaResultados()) {
            //asignamos todos los resultados a m
            Proveedor p = (Proveedor) o;
            if (p.getNombre().equals(nombreProveedor)) {
                this.setIdTabla(p.getIdProveedor());
            }

        }

    }

}
