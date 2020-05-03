package operacionesMateriaPrima;

import entidades.MateriaPrima_Marca_Proveedor;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import calsesPadre.Tablas;
import escritorios.PrincipalMateriaPrima;
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
public class TablaMateriaPrima extends Tablas {

    public TablaMateriaPrima() {
        setEstadoConsulta(0);
    }

    public void ejecutarRellenarTabla(PrincipalMateriaPrima p) {
        setTabla(p.getTabla());
        setStringConsulta("from MateriaPrima_Marca_Proveedor");
        evaluarEstadoConsulta();
        setCampoTexto(p.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaMateriaPrima = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaMateriaPrima);
        for (Object o : lista) {
            MateriaPrima_Marca_Proveedor mpm = (MateriaPrima_Marca_Proveedor) o;
            Vector<Object> fila = new Vector<>();
            boolean resultadoComparacion = OperacionesUtiles.convertirResultado(mpm.getCodigoMateriaPrima().getNombre(), valorBusqueda);
            if (mpm.getCodigoMateriaPrima().getCodigoEstado().getIdEstado().equals(1) && resultadoComparacion) {
                fila.add(mpm.getCodigoMateriaPrima().getNombre());
                fila.add(mpm.getCodigoProveedor().getNombre());
                fila.add(mpm.getCodigoMarca().getNombre());
                fila.add(mpm.getCodigoMateriaPrima().getCodigoUnidaddeMedida().getNombre());
                tablaMateriaPrima.addRow(fila);
            }
        }
    }

    /**
     * Permite obtener el id de la fila seleccionada en la tabla de la interfaz
     * grafica(id traida desde la bd) de mtmrpr
     */
    public void obtenerIdTablaMateriaPrima() {

        int fila = Main.getPrincipalAdmin().getMatprima().getTabla().getSelectedRow();
        String nombreMatPrima = Main.getPrincipalAdmin().getMatprima().getTabla().getValueAt(fila, 0).toString();
        String nombreProveedor = Main.getPrincipalAdmin().getMatprima().getTabla().getValueAt(fila, 1).toString();
        String nombreMarca = Main.getPrincipalAdmin().getMatprima().getTabla().getValueAt(fila, 2).toString();

        for (Object o : getListaResultados()) {
            MateriaPrima_Marca_Proveedor mpmrpr = (MateriaPrima_Marca_Proveedor) o;
            if (mpmrpr.getCodigoMateriaPrima().getNombre().equals(nombreMatPrima)
                    && mpmrpr.getCodigoProveedor().getNombre().equals(nombreProveedor)
                    && mpmrpr.getCodigoMarca().getNombre().equals(nombreMarca)) {
                this.setIdTabla(mpmrpr.getCodigoMateriaPrima().getIdMateriaPrima());
            }
        }
    }

}
