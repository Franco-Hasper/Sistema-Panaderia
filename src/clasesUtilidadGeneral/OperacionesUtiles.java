package clasesUtilidadGeneral;

import java.awt.Toolkit;
import java.awt.Window;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import rojeru_san.componentes.RSDateChooser;

/**
 *
 * @author TELCOM MPC
 */
public class OperacionesUtiles {

    String mensaje = "sin mensaje";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //agrega items al box especifcado
    public void agregarItem(Object o, JComboBox box) {
        box.addItem(o.toString());
    }

    public void agregarTexto(Object o, JTextField label) {
        label.setText(o.toString());
    }

    /* VER ESTE
    public void agregarFilaTabla(Vector vector,DefaultTableModel tablaGui){
        Vector<Object>fila=new Vector<>();
          tablaGui.addRow(fila);
     }
    
     */
    public boolean verificarCamposTextoVacios(List lista) {
        List<JTextField> listCamposTexto
                = (List<JTextField>) lista;
        for (Object o : listCamposTexto) {
            JTextField j = (JTextField) o;
            if (j.getText().length() == 0) {
                showMessageDialog(null, "Todos los campos son requeridos");
                break;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean verificarCamposTextoVaciosMensaje(List lista) {
        List<JTextField> listCamposTexto
                = (List<JTextField>) lista;
        for (Object o : listCamposTexto) {
            JTextField j = (JTextField) o;
            if (j.getText().length() == 0) {
                showMessageDialog(null, mensaje);
                break;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean verificarCamposTextoVacios(List lista, String mensaje) {
        List<JTextField> listCamposTexto
                = (List<JTextField>) lista;
        for (Object o : listCamposTexto) {
            JTextField j = (JTextField) o;
            if (j.getText().length() == 0) {
                showMessageDialog(null, mensaje);
                break;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean verificarCampoTextoVacio(JTextField campoTexto, String mensaje) {

        if (campoTexto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;

    }

    //metodo para limpiar tabla
    public void removerFilas(DefaultTableModel tabla) {
        while (tabla.getRowCount() > 0) {
            tabla.removeRow(0);
        }

    }

    //metodo para limpiar box
    public void removerItemsBox(JComboBox box) {
        if (box.getItemCount() > 0) {
            box.removeAllItems();
        }

    }

    public void insertarFechaActualDateChooser(RSDateChooser contenedor) {
        Date fecha = new Date();
        contenedor.setDatoFecha(fecha);
    }

    public static void borrarCampo(JTextField campo) {
        campo.setText(null);
    }

    //mensaje indicando que se deben ingrear solamente Letras
    public boolean advertenciaChar(java.awt.event.KeyEvent evt) {
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solamente Letras");
            return true;
        }
        return false;
    }

    //mensaje indicando que se deben ingrear solamente Numeros
    public boolean advertenciaNum(java.awt.event.KeyEvent evt) {
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar Solamente Numeros");
            return true;
        }
        return false;
    }

//metodo para advertencia
    public Toolkit getToolkit() {
        return Toolkit.getDefaultToolkit();
    }

    public static boolean mensajeEliminarRegistro() {
        if (JOptionPane.showConfirmDialog(null, "¿SEGURO QUE DESEA ELIMINAR EL REGISTRO?", "",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            return true;
        }
        return false;
    }

    public static boolean mensajeGuardarTema() {
        if (JOptionPane.showConfirmDialog(null, "¿SEGURO QUE DESE GUARDAR LOS CAMBIOS?", "",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            return true;
        }
        return false;
    }

    //mensaje de onfiramcion para cerrar formulario
    public static void mensajeCancelarFormulario(JDialog formulario) {
        if (JOptionPane.showConfirmDialog(null, "¿SEGURO QUE DESEA CANCELAR LA ACCION?", "",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            formulario.dispose();
        }
    }

    public void centrarVentana(Window ventana) {
        ventana.setLocationRelativeTo(null);
    }

    public Object formatoFecha(Date fechaSinFormato) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy (HH:mm:ss)");
        return dateFormat.format(fechaSinFormato);

    }

    public Object formatoFechaSinHora(Date fechaSinFormato) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(fechaSinFormato);

    }

    public boolean verificarSeleccionFila(JTable tabla) {
        if (tabla.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UAN FILA PARA LLEVAR A CABO LA ACCION",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void reposicionarDialog(JFrame cuadroFrame, int x, int y) {
        cuadroFrame.setLocation(x, y);
    }

    public void redimensionarDialog(JFrame cuadroFrame, int x, int y) {
        cuadroFrame.setSize(x, y);
    }

    public boolean compararFecha(Date fecha) {

        Date date = new Date();

        DateFormat fechaFormatActual = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = fechaFormatActual.format(date);
        String fechaComparable = fechaFormatActual.format(fecha);

        String[] fechaSeparadaActual = fechaActual.split("-");
        String[] fechaSeparadaComparable = fechaComparable.split("-");

        if (Integer.parseInt(fechaSeparadaActual[0]) == Integer.parseInt(fechaSeparadaComparable[0])) {
            if (Integer.parseInt(fechaSeparadaActual[1]) == Integer.parseInt(fechaSeparadaComparable[1])) {
                if (Integer.parseInt(fechaSeparadaActual[2]) == Integer.parseInt(fechaSeparadaComparable[2])) {
                    return true;

                } else {
                    return false;
                }
            }
        }
        return false;

    }

    /**
     * devuelve una fila de la tabla especificada
     *
     * @param j (objeto de la clase JTable)
     */
    public int seleccionarFila(JTable j) {
        return j.getSelectedRow();
    }

    public static boolean convertirResultado(String resultadoSql, String cadenaBusqueda) {
        Integer resutadoComparacion = resultadoSql.indexOf(cadenaBusqueda);
        Integer resutadoComparacionMinuscula = resultadoSql.toLowerCase().indexOf(cadenaBusqueda);
        Integer resutadoComparacionMayuscula = resultadoSql.toUpperCase().indexOf(cadenaBusqueda);
        Integer resutadoComparacionFirstMayuscula = (resultadoSql.substring(0, 1).toUpperCase() + resultadoSql.substring(1).toUpperCase()).indexOf(cadenaBusqueda);

        if (resutadoComparacion.equals(0)
                || resutadoComparacionMinuscula.equals(0)
                || resutadoComparacionMayuscula.equals(0)
                || resutadoComparacionFirstMayuscula.equals(0)) {
            return true;
        }
        return false;
    }

}
