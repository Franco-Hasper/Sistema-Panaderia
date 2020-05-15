package operacionesCaja;

import clasesUtilidadGeneral.OperacionesUtiles;
import formularios.FormularioCorteDiario;
import formularios.FormularioEditarCorte;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Franco Hasper
 */
public class OperacionesSecundarias {

    /**
     * Suma todos los registros de la tabla entradas y guarda el resultado en el
     * label total eltradas.
     *
     * @param f
     */
    public void calcularTotalEntradas(FormularioCorteDiario f) {
        Double suma = 0.0;
        try {
            for (int i = 0; i < f.getTablaEntradas().getRowCount(); i++) {
                suma = suma + (Double.valueOf(f.getTablaEntradas().getValueAt(i, 2).toString()));
            }
            f.getLblTotalEntradas().setText(new OperacionesUtiles().formatoDouble(suma));
        } catch (Exception e) {
            showMessageDialog(null, "Ocurrio un error al intenetar calcular total entradas");

        }

    }

    /**
     * Suma todos los registros de la tabla salidas y guarda el resultado en el
     * label total salidas.
     *
     * @param f
     */
    public void calcularTotalSalidas(FormularioCorteDiario f) {
        Double suma = 0.0;
        try {

            for (int i = 0; i < f.getTablaSlidas().getRowCount(); i++) {
                suma = suma + (Double.valueOf(f.getTablaSlidas().getValueAt(i, 2).toString()));
            }
            f.getLblTotalSlidas().setText(new OperacionesUtiles().formatoDouble(suma));
        } catch (Exception e) {
            showMessageDialog(null, "Ocurrio un error al intenetar calcular total salidas");

        }

    }

    /**
     * Calcula el balance de el corte diario restando el total de entras de el
     * total de salidas y guarda el resultado en el sabel balance.
     *
     * @param f
     */
    public void calcularBalance(FormularioCorteDiario f) {
        Double suma = 0.0;
        Double entradas = 0.0;
        Double salidas = 0.0;
        try {
            entradas = Double.valueOf(f.getLblTotalEntradas().getText());
            salidas = Double.valueOf(f.getLblTotalSlidas().getText());
            suma = entradas + (-salidas);
            
            f.getLblBalance().setText(new OperacionesUtiles().formatoDouble(suma));

        } catch (Exception e) {
            showMessageDialog(null, "Ocurrio un error al intenetar calcular balance");
        }

    }

    /**
     * Calcula el balance de el corte diario restando el total de entras de el
     * total de salidas y guarda el resultado en el sabel balance y retorna el
     * resultado de la resta.
     *
     * @param f
     * @return
     */
    public Double calcularBalance(FormularioEditarCorte f) {
        Double suma = 0.0;
        Double entradas = 0.0;
        Double salidas = 0.0;
        try {
            entradas = Double.valueOf(f.getTxtTotalIngresos().getText());
            salidas = Double.valueOf(f.getTxtTotalEgresos().getText());
            suma = entradas + (-salidas);
            return suma;
        } catch (Exception e) {
            return suma;
        }

    }

}
