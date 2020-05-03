package operacionesCaja;

import formularios.FormularioCorteDiario;
import formularios.FormularioEditarCorte;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author TELCOM MPC
 */
public class OperacionesSecundarias {

    public void calcularTotalEntradas(FormularioCorteDiario f) {
        Double suma = 0.0;
        try {
            for (int i = 0; i < f.getTablaEntradas().getRowCount(); i++) {
                suma = suma + (Double.valueOf(f.getTablaEntradas().getValueAt(i, 2).toString()));
            }
            f.getLblTotalEntradas().setText(suma.toString());
        } catch (Exception e) {
            showMessageDialog(null, "Ocurrio un error al intenetar calcular total entradas");

        }

    }

    public void calcularTotalSalidas(FormularioCorteDiario f) {
        Double suma = 0.0;
        try {

            for (int i = 0; i < f.getTablaSlidas().getRowCount(); i++) {
                suma = suma + (Double.valueOf(f.getTablaSlidas().getValueAt(i, 2).toString()));
            }
            f.getLblTotalSlidas().setText(suma.toString());
        } catch (Exception e) {
            showMessageDialog(null, "Ocurrio un error al intenetar calcular total salidas");

        }

    }

    public void calcularBalance(FormularioCorteDiario f) {
        Double suma = 0.0;
        Double entradas = 0.0;
        Double salidas = 0.0;
        try {
            entradas = Double.valueOf(f.getLblTotalEntradas().getText());
            salidas = Double.valueOf(f.getLblTotalSlidas().getText());
            suma = entradas + (-salidas);
            f.getLblBalance().setText(suma.toString());

        } catch (Exception e) {
            showMessageDialog(null, "Ocurrio un error al intenetar calcular balance");
        }

    }

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
