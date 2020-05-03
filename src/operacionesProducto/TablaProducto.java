package operacionesProducto;

import calsesPadre.Tablas;
import entidades.PrecioProducto;
import escritorios.PrincipalProducto;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import clasesUtilidadGeneral.OperacionesUtiles;
import principal.Main;

/**
 *
 * @author TELCOM MPC
 */
public class TablaProducto extends Tablas {

    public TablaProducto() {
        setEstadoConsulta(0);
    }

    public void ejecutarRellenarTabla(PrincipalProducto p) {
        setTabla(p.getTabla());
        setStringConsulta("from PrecioProducto");
        evaluarEstadoConsulta();
        setCampoTexto(p.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    public void rellenarTabla(String valorBusqueda) {

        DefaultTableModel tablaPrducto = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaPrducto);
        for (Object o : lista) {
            PrecioProducto pr = (PrecioProducto) o;
            Vector<Object> fila = new Vector<>();

            boolean resultadoComparacion = OperacionesUtiles.convertirResultado(pr.getCodigoProducto().getNombre(), valorBusqueda);
            if (pr.getCodigoEstado().getIdEstado().equals(1)
                    && pr.getCodigoProducto().getCodigoEstado().getIdEstado().equals(1) && resultadoComparacion) {
                fila.add(pr.getCodigoProducto().getNombre());
                fila.add(pr.getCodigoProducto().getDescripcion());
                fila.add(pr.getPrecioTotal());
                fila.add(opu.formatoFechaSinHora(pr.getFecha()));
                tablaPrducto.addRow(fila);

            }
        }
    }

    public void obtenerIdTablaProducto() {

        int fila = Main.getPrincipalAdmin().getProducto().getTabla().getSelectedRow();
        String nombrePrducto = Main.getPrincipalAdmin().getProducto().getTabla().getValueAt(fila, 0).toString();
        String descripcion = Main.getPrincipalAdmin().getProducto().getTabla().getValueAt(fila, 1).toString();
        List lista = this.getListaResultados();
        List<PrecioProducto> lista_producto
                = (List<PrecioProducto>) lista;
        for (Object o : lista_producto) {

            PrecioProducto pr = (PrecioProducto) o;

            if (pr.getCodigoProducto().getNombre().equals(nombrePrducto)
                    && pr.getCodigoProducto().getDescripcion().equals(descripcion)) {
                this.setIdTabla(pr.getCodigoProducto().getIdProducto());
            }

        }

    }

}
