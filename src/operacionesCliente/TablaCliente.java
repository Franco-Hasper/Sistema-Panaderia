package operacionesCliente;

import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import calsesPadre.Tablas;
import entidades.Cliente;
import entidades.Direccion_Cliente;
import entidades.TelefonoCliente;
import escritorios.PrincipalCliente;
import clasesUtilidadGeneral.OperacionesUtiles;
import principal.Main;

/**
 * <h1>Clase TablaMatetiaPrima</h1>
 * Contiene atributos y metodos que se encargan de manejar operaciones
 * relaacionadas con JTable de la interfaz grafica materia prima
 *
 * @author Hasper Franco
 * @version 0.1
 * @since 2020-01-15
 */
public class TablaCliente extends Tablas {

    public TablaCliente() {
        setEstadoConsulta(0);
    }

    public void ejecutarRellenarTabla(PrincipalCliente p) {
        setTabla(p.getTabla());
        setStringConsulta("from Cliente");
        evaluarEstadoConsulta();
        setCampoTexto(p.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaCliente = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaCliente);
        Integer vueltaDir = 0;
        Integer vueltaTel = 0;
        for (Object o : lista) {
            Cliente c = (Cliente) o;
            Vector<Object> fila = new Vector<>();

            boolean resultadoComparacion = OperacionesUtiles.convertirResultado(c.getNombre(), valorBusqueda);
            //***********************
            if (c.getCodigoEstado().getIdEstado().equals(1) && resultadoComparacion) {
                fila.add(c.getNombre());
                fila.add(c.getApellido());
                fila.add(c.getCodigoRazonSocial().getNombre());
                List<Direccion_Cliente> direcciones = c.getDireccionesclientes();
                List<TelefonoCliente> telefonos = c.getTelefonos();
                if (c.getDireccionesclientes().size() == 0) {
                    fila.add("sin registros");
                    fila.add("sin registros");
                    fila.add("sin registros");
                    fila.add("sin registros");
                } else {
                    for (Direccion_Cliente drCl : direcciones) {
                        if (vueltaDir != 1) {
                            fila.add(drCl.getNombre());
                            fila.add(drCl.getNumero());
                            fila.add(drCl.getCodigoLocalidad().getNombre());
                            fila.add(drCl.getCodigoLocalidad().getCodigoProvincia().getNombre());
                            vueltaDir = 1;
                        }
                    }
                }
                if (c.getTelefonos().size() == 0) {
                    fila.add("sin registros");
                    fila.add("sin registros");
                } else {
                    for (TelefonoCliente tlcl : telefonos) {
                        if (vueltaTel != 1) {
                            fila.add(tlcl.getNuemero());
                            fila.add(tlcl.getCodigoTipoTelefono().getNombre());
                            vueltaTel = 1;
                        }
                    }
                }

                vueltaDir = 0;
                vueltaTel = 0;

                tablaCliente.addRow(fila);

            }
        }
    }

    /**
     */
    public void obtenerIdTablaCliente() {

        int fila = Main.getPrincipalAdmin().getCliente().getTabla().getSelectedRow();
        String nombreCliente = Main.getPrincipalAdmin().getCliente().getTabla().getValueAt(fila, 0).toString();
        String apellido = Main.getPrincipalAdmin().getCliente().getTabla().getValueAt(fila, 1).toString();
        String razonSocial = Main.getPrincipalAdmin().getCliente().getTabla().getValueAt(fila, 2).toString();

        for (Object o : getListaResultados()) {
            //asignamos todos los resultados a m
            Cliente c = (Cliente) o;
            if (c.getNombre().equals(nombreCliente)
                    && c.getApellido().equals(apellido)
                    && c.getCodigoRazonSocial().getNombre().equals(razonSocial)) {
                this.setIdTabla(c.getIdCliente());
            }
        }
    }

}
