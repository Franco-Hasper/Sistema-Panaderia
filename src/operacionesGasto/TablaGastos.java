package operacionesGasto;

import calsesPadre.Tablas;
import entidades.Gasto;
import escritorios.PrincipalGastos;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import principal.Main;

/**
 *
 * @author TELCOM MPC
 */
public class TablaGastos extends Tablas {

    public TablaGastos() {
        setEstadoConsulta(0);
    }

    public void ejecutarRellenarTabla(PrincipalGastos g) {
        setTabla(g.getTabla());
        setStringConsulta("from Gasto");
        evaluarEstadoConsulta();
        setCampoTexto(g.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaGastos = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaGastos);

        for (Object o : lista) {
            Gasto g = (Gasto) o;
            Integer resutadoComparacion = (g.getFecha().toString().indexOf(valorBusqueda));
            if (g.getCodigoEstado().getIdEstado().equals(1) && resutadoComparacion.equals(0)) {
                Vector<Object> fila = new Vector<>();
                fila.add(g.getDescripcion());
                fila.add(g.getPrecioTotal());
                fila.add(opu.formatoFechaSinHora(g.getFecha()));
                tablaGastos.addRow(fila);
            }

        }
    }

    public void obtenerIdTablaGastos() {

        int fila = Main.getPrincipalAdmin().getGastos().getTabla().getSelectedRow();
        String descripcion = Main.getPrincipalAdmin().getGastos().getTabla().getValueAt(fila, 0).toString();
        String totalGastado = Main.getPrincipalAdmin().getGastos().getTabla().getValueAt(fila, 1).toString();
        String fecha = Main.getPrincipalAdmin().getGastos().getTabla().getValueAt(fila, 2).toString();
        for (Object o : getListaResultados()) {
            //asignamos todos los resultados a m
            Gasto g = (Gasto) o;

            if (g.getDescripcion().equals(descripcion)
                    && opu.formatoFechaSinHora(g.getFecha()).equals(fecha)
                    && ((Double) g.getPrecioTotal()).toString().equals(totalGastado)) {
                this.setIdTabla(g.getIdGasto());
            }

        }
    }

}
