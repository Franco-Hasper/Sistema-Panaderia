package operacionesCaja;

import calsesPadre.Tablas;
import entidades.CorteCaja;
import entidades.Gasto;
import entidades.IngresoMateriaPrima;
import entidades.PrecioProducto;
import entidades.Producto_Venta;
import entidades.Venta;
import escritorios.PrincipalCaja;
import formularios.FormularioCorteDiario;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import principal.Main;

/**
 *
 * @author Franco Hasper
 */
public class TablaCaja extends Tablas {

    public TablaCaja() {
        setEstadoConsulta(0);
    }

    /**
     * Ejecuata los metodos necesarios para rellenar la tabla de la ventana
     * Caja.
     *
     * @param c
     */
    public void ejecutarRellenarTabla(PrincipalCaja c) {
        setTabla(c.getTabla());
        setStringConsulta("from CorteCaja");
        evaluarEstadoConsulta();
        setCampoTexto(c.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());

    }

    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaCaja = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaCaja);
        for (Object o : lista) {
            CorteCaja corteCaja = (CorteCaja) o;
            Integer resutadoComparacion = (corteCaja.getFecha().toString().indexOf(valorBusqueda));
            if (corteCaja.getCodigoEstado().getIdEstado().equals(1) && resutadoComparacion.equals(0)) {
                Vector<Object> fila = new Vector<>();
                fila.add(corteCaja.getTotalIngresos());
                fila.add(corteCaja.getTotalEgresos());
                fila.add(corteCaja.getBalance());
                fila.add(opu.formatoFecha(corteCaja.getFecha()));
                tablaCaja.addRow(fila);
            }

        }
    }

    /**
     * Toma los resultados de la consulta gastos y los agrega en la tabla
     * salidas de la ventana Corte de Caja.
     */
    public void rellenarTablaSalidasGasto() {
        DefaultTableModel tablaSalidas = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaSalidas);
        for (Object o : lista) {
            Gasto g = (Gasto) o;
            Vector<Object> fila = new Vector<>();
            if (opu.compararFecha(g.getFecha())) {
                fila.add("otros");
                fila.add(g.getDescripcion());
                fila.add(g.getPrecioTotal());

                tablaSalidas.addRow(fila);
            }
        }

    }

    /**
     * Toma los resultados de la consulta ingreso materia prima y los agrega en
     * la tabla salidas de la ventana Corte de Caja.
     */
    public void rellenarTablaSalidasIngresoMatPrima() {
        DefaultTableModel tablaSalidas = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();

        for (Object o : lista) {
            IngresoMateriaPrima i = (IngresoMateriaPrima) o;
            Vector<Object> fila = new Vector<>();
            if (opu.compararFecha(i.getFecha())) {
                fila.add(i.getCodigoMateriaPrima().getNombre());
                fila.add("Ingreso de materia prima");
                fila.add(i.getPrecioTotal());
                tablaSalidas.addRow(fila);
            }
        }

    }

    /**
     * Ejecuata los metodos necesarios para rellenar la tabla de la salidas en
     * la ventana Corte de caja con los resultados de la consulta de gastos.
     *
     * @param p
     */
    public void ejecutarRellenarTablaSalidasGastos(FormularioCorteDiario p) {
        setTabla(p.getTablaSlidas());
        setConsultaList("from Gasto");
        obtenerListaConsulta();
        rellenarTablaSalidasGasto();
    }

    /**
     * Ejecuata los metodos necesarios para rellenar la tabla de la salidas en
     * la ventana Corte de caja con los resultados de la consulta de ingreso de
     * materia prima.
     *
     * @param p
     */
    public void ejecutarRellenarTablaSalidasIngresosMateriaPrima(FormularioCorteDiario p) {
        setTabla(p.getTablaSlidas());
        setConsultaList("from IngresoMateriaPrima");
        obtenerListaConsulta();
        rellenarTablaSalidasIngresoMatPrima();
    }

    /**
     * Toma los resultados de la consulta entradas y los agrega en la tabla
     * entradas de la ventana Corte de Caja.
     *
     */
    public void rellenarTablaEntradas() {

        DefaultTableModel tablaEntradas = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaEntradas);
        for (Object o : lista) {
            Venta v = (Venta) o;
            Vector<Object> fila = new Vector<>();
            if (opu.compararFecha(v.getFechaHoraVenta())) {
                List<Producto_Venta> productos = v.getProductos();
                for (Producto_Venta pr : productos) {
                    fila.add(pr.getCodigoProducto().getNombre());
                    fila.add(pr.getTotalUnidades());
                    List<PrecioProducto> precios
                            = pr.getCodigoProducto().getPrecios();
                    for (PrecioProducto pre : precios) {
                        if (pre.getCodigoEstado().getIdEstado().equals(1)) {
                            fila.add(pr.getTotalUnidades() * pre.getPrecioTotal());
                        }
                    }
                }
                fila.add(v.getPrecioTotal().toString());
                tablaEntradas.addRow(fila);

            }

        }

    }

    /**
     * Ejecuata los metodos necesarios para rellenar la tabla de la entradas en
     * la ventana Corte de caja con los resultados de la consulta de entradas.
     *
     * @param p
     */
    public void ejecutarRellenarTablaEntradas(FormularioCorteDiario p) {
        setTabla(p.getTablaEntradas());
        setConsultaList("from Venta");
        obtenerListaConsulta();
        rellenarTablaEntradas();
    }

    /**
     * Compara los valores de una fila seleccionada en la tabla de Corte de Caja
     * con los resultados obtenidos de la base datos, si estos coinciden guarda
     * el resultado en la variable idCorteCaja.
     */
    public void obtenerIdTablaCorteCaja() {

        int fila = Main.getPrincipalAdmin().getCaja().getTabla().getSelectedRow();
        String ingresos = Main.getPrincipalAdmin().getCaja().getTabla().getValueAt(fila, 0).toString();
        String egresos = Main.getPrincipalAdmin().getCaja().getTabla().getValueAt(fila, 1).toString();
        String balance = Main.getPrincipalAdmin().getCaja().getTabla().getValueAt(fila, 2).toString();
        String fecha = Main.getPrincipalAdmin().getCaja().getTabla().getValueAt(fila, 3).toString();

        for (Object o : getListaResultados()) {
            //asignamos todos los resultados a m
            CorteCaja c = (CorteCaja) o;

            if (c.getTotalIngresos().toString().equals(ingresos) && c.getTotalEgresos().toString().equals(egresos)
                    && c.getBalance().toString().equals(balance) && (opu.formatoFecha(c.getFecha()).toString().equals(fecha))) {

                this.setIdTabla(c.getIdCorteCaja());
            }

        }

    }
}
