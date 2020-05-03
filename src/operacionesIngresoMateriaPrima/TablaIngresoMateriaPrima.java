package operacionesIngresoMateriaPrima;

import calsesPadre.Tablas;
import entidades.IngresoMateriaPrima;
import escritorios.PrincipalIngresoMatPrima;
import formularios.FormularioReporteIngresoMateriaPrima;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import clasesUtilidadGeneral.OperacionesUtiles;
import principal.Main;

/**
 *
 * @author FRANCO
 */
public class TablaIngresoMateriaPrima extends Tablas {

    JLabel labelPrecioTotal;

    public JLabel getLabelPrecioTotal() {
        return labelPrecioTotal;
    }

    public void setLabelPrecioTotal(JLabel labelPrecioTotal) {
        this.labelPrecioTotal = labelPrecioTotal;
    }

    public TablaIngresoMateriaPrima() {
        setEstadoConsulta(0);
    }

    public void ejecutarRellenarTabla(PrincipalIngresoMatPrima p) {
        setTabla(p.getTabla());
        setStringConsulta("from IngresoMateriaPrima");
        evaluarEstadoConsulta();
        setCampoTexto(p.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaIngMateriaPrima = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaIngMateriaPrima);
        for (Object o : lista) {
            IngresoMateriaPrima inmt = (IngresoMateriaPrima) o;
            Vector<Object> fila = new Vector<>();
            Integer resutadoComparacion = (inmt.getFecha().toString().indexOf(valorBusqueda));
            if (inmt.getCodigoEstado().getIdEstado().equals(1) && (resutadoComparacion.equals(0))) {
                fila.add(inmt.getCodigoMateriaPrima().getNombre());
                fila.add(inmt.getTotalEnvases());
                fila.add(inmt.getUdPorEnvase());
                fila.add(inmt.getCodigoMateriaPrima().getCodigoUnidaddeMedida().getNombre());
                fila.add(inmt.getPrecioTotal());
                fila.add(opu.formatoFecha(inmt.getFecha()));
                tablaIngMateriaPrima.addRow(fila);
            }
        }
    }

    public void ejecutarRellenarTabla(FormularioReporteIngresoMateriaPrima f) {
        setTabla(f.getTabla());
        setStringConsulta("from IngresoMateriaPrima");
        evaluarEstadoConsulta();
        OperacionesUtiles op = new OperacionesUtiles();
        String fechaString = (String.valueOf(op.formatoFechaSinHora(f.getrSDateChooser().getDatoFecha())));
        setLabelPrecioTotal(f.getLblImporteTotal());
        rellenarTablaForm(fechaString);
    }

    public void rellenarTablaForm(String valorBusqueda) {
        DefaultTableModel tablaIngMateriaPrima = (DefaultTableModel) getTabla().getModel();

        List lista = this.getListaResultados();
        Double importeTotal = 0.0;
        OperacionesUtiles op = new OperacionesUtiles();
        opu.removerFilas(tablaIngMateriaPrima);
        for (Object o : lista) {
            IngresoMateriaPrima inmt = (IngresoMateriaPrima) o;
            Vector<Object> fila = new Vector<>();
            String fecha = (String.valueOf(op.formatoFechaSinHora(inmt.getFecha())));
            Integer resutadoComparacion = (fecha.indexOf(valorBusqueda));
            if (inmt.getCodigoEstado().getIdEstado().equals(1) && (resutadoComparacion.equals(0))) {
                fila.add(inmt.getCodigoMateriaPrima().getNombre());
                fila.add(inmt.getTotalEnvases());
                fila.add(inmt.getUdPorEnvase());
                fila.add(inmt.getPrecioTotal());
                importeTotal += inmt.getPrecioTotal();
                tablaIngMateriaPrima.addRow(fila);
            }
        }
        getLabelPrecioTotal().setText(importeTotal.toString());
    }

    /**
     * Permite obtener el id de la fila seleccionada en la tabla de la interfaz
     * grafica(id traida desde la bd) de materia prima
     */
    public void obtenerIdTablaIngresoMateriaPrima() {
        int fila = Main.getPrincipalAdmin().getIngmatprima().getTabla().getSelectedRow();
        String nombreIngMatPrima = Main.getPrincipalAdmin().getIngmatprima().getTabla().getValueAt(fila, 0).toString();
        //String totalEnvases = Main.getPrincipalAdmin().getIngmatprima().getTabla().getValueAt(fila, 1).toString();
        //String udXenv = Main.getPrincipalAdmin().getIngmatprima().getTabla().getValueAt(fila, 2).toString();
        String precioTotal = Main.getPrincipalAdmin().getIngmatprima().getTabla().getValueAt(fila, 4).toString();
        String fecha = Main.getPrincipalAdmin().getIngmatprima().getTabla().getValueAt(fila, 5).toString();

        for (Object o : getListaResultados()) {
            //asignamos todos los resultados a m
            IngresoMateriaPrima im = (IngresoMateriaPrima) o;
            if (im.getCodigoMateriaPrima().getNombre().equals(nombreIngMatPrima)
                    && im.getPrecioTotal().equals(Double.parseDouble(precioTotal))
                    && opu.formatoFecha(im.getFecha()).equals(fecha)) {
                this.setIdTabla(im.getIdIngresoMateriaPrima());
            }
        }
    }

}
