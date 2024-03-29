package clasesUtilidadGeneral;

import ds.desktop.notify.DesktopNotify;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
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

    private String mensaje = "sin mensaje";

    /**
     * Devuelve un mensaje, implementado fecuentemente en los dialogos
     * utilizados para informar al usario de el estado de una accion.
     *
     * @return mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Aloja un mensaje, implementado fecuentemente en los dialogos utilizados
     * para informar al usario de el estado de una accion.
     *
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Agrega items a un JComboBox indicado en el parametro box.
     *
     * @param o
     * @param box
     */
    public void agregarItem(Object o, JComboBox box) {
        box.addItem(o.toString());
    }

    /**
     * Inserta un texto en el label especificado en el parametro label.
     *
     * @param o
     * @param label
     */
    public void agregarTexto(Object o, JTextField label) {
        label.setText(o.toString());
    }

    /**
     * Verifica que todos los campos (JTextField) alojados en la lista tengan
     * por lo menos un caracter de longitud si esta codicion no se cumple
     * despliega un dialog con un mensaje especifico si todos los campos estan
     * completos devuelve true.
     *
     * @param lista
     * @return
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

    /**
     * Verifica que todos los campos (JTextField) alojados en la lista tengan
     * por lo menos un caracter de longitud si esto no se cumple despliega un
     * dialog con un mensaje del atributo mensaje si todos los campos estan
     * completos devuelve true.
     *
     * @param lista
     * @return
     */
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

    /**
     * Verifica que todos los campos (JTextField) alojados en la lista tengan
     * por lo menos un caracter de longitud si esto no se cumple despliega un
     * dialog con un mensaje del parametro mensaje si todos los campos estan
     * completos devuelve true.
     *
     * @param lista
     * @param mensaje
     * @return
     */
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

    /**
     * Verifica que un campo (JTextField) tenga por lo menos un caracter de
     * longitud si esto no se cumple despliega un dialog con un mensaje del
     * parametro mensaje si todos los campos estan completos devuelve true.
     *
     * @param campoTexto
     * @param mensaje
     * @return
     */
    public boolean verificarCampoTextoVacio(JTextField campoTexto, String mensaje) {

        if (campoTexto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;

    }

    /**
     * Limpia todas las filas de la tabla indicada.
     *
     * @param tabla
     */
    public void removerFilas(DefaultTableModel tabla) {
        while (tabla.getRowCount() > 0) {
            tabla.removeRow(0);
        }

    }

    /**
     * Limpia todos los items de el box indicado.
     *
     * @param box
     */
    public void removerItemsBox(JComboBox box) {
        if (box.getItemCount() > 0) {
            box.removeAllItems();
        }

    }

    /**
     * Inserta la fecha actual en el box RSDateChooser.
     *
     * @param contenedor
     */
    public void insertarFechaActualDateChooser(RSDateChooser contenedor) {
        Date fecha = new Date();
        contenedor.setDatoFecha(fecha);
    }

    /**
     * Limpia el campo de texto indicado.
     *
     * @param campo
     */
    public static void borrarCampo(JTextField campo) {
        campo.setText(null);
    }

    /**
     * Despliega un mensaje indicando que solo deben ingresarse Letras.
     *
     * @param evt
     * @return
     */
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

    /**
     * Despliega un mensaje indicando que solo deben ingresarse números.
     *
     * @param evt
     * @return
     */
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

    /**
     * Devuelve un recuadro tipo default de la clase ToolKit para mostrar
     * mensajes al usuario.
     *
     * @return
     */
    public Toolkit getToolkit() {
        return Toolkit.getDefaultToolkit();
    }

    /**
     * Muestra un dialog de confirmacion.
     *
     * @return
     */
    public static boolean mensajeEliminarRegistro() {
        if (JOptionPane.showConfirmDialog(null, "¿SEGURO QUE DESEA ELIMINAR EL REGISTRO?", "",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            return true;
        }
        return false;
    }

    /**
     * muestra un mensaje de confirmacion.
     *
     * @return
     */
    public static boolean mensajeGuardarTema() {
        if (JOptionPane.showConfirmDialog(null, "¿SEGURO QUE DESE GUARDAR LOS CAMBIOS?", "",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            return true;
        }
        return false;
    }

    /**
     * mustra un mensaje de confirmacion.
     *
     * @param formulario
     */
    public static void mensajeCancelarFormulario(JDialog formulario) {
        if (JOptionPane.showConfirmDialog(null, "¿SEGURO QUE DESEA CANCELAR LA ACCION?", "",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            formulario.dispose();
        }
    }

    /**
     * Centra la interfaz pasada como parametro.
     *
     * @param ventana
     */
    public void centrarVentana(Window ventana) {
        ventana.setLocationRelativeTo(null);
    }

    /**
     * Formatea la fecha indicada a dd-MM-yyyy (HH:mm.ss)
     *
     * @param fechaSinFormato
     * @return
     */
    public Object formatoFecha(Date fechaSinFormato) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy (HH:mm:ss)");
        return dateFormat.format(fechaSinFormato);

    }

    /**
     * * Formatea la fecha indicada a dd-MM-yyyy
     *
     * @param fechaSinFormato
     * @return
     */
    public Object formatoFechaSinHora(Date fechaSinFormato) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(fechaSinFormato);

    }

    /**
     * Devuelve true si la tabla pasada como parametro posee una fila
     * seleccionada , de contrario retorna false.
     *
     * @param tabla
     * @return
     */
    public boolean verificarSeleccionFila(JTable tabla) {
        if (tabla.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UAN FILA PARA LLEVAR A CABO LA ACCION",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Reposiciona un JFrame en los ejes x,y indicados
     *
     * @param cuadroFrame
     * @param x
     * @param y
     */
    public void reposicionarDialog(JFrame cuadroFrame, int x, int y) {
        cuadroFrame.setLocation(x, y);
    }

    /**
     * Redimensiona un Jframe con los valores x,y indicados.
     *
     * @param cuadroFrame
     * @param x
     * @param y
     */
    public void redimensionarDialog(JFrame cuadroFrame, int x, int y) {
        cuadroFrame.setSize(x, y);
    }

    /**
     * Recibe un a fecha como parametro y la compara con la fecha actual, si son
     * iguales retorna true, de lo contrario retorna false.
     *
     * @param fecha
     * @return
     */
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
     * Devuelve el indice de una fila seleccionada en un JTable.
     *
     * @param j
     * @return
     */
    public int seleccionarFila(JTable j) {
        return j.getSelectedRow();
    }

    /**
     * Recibe dos cadenas y las compara sin tener en cuenta a mayusculas y
     * minusculas, si los resultados coinciden devuelve true, de lo contrario
     * devuelve false.
     *
     * @param resultadoSql
     * @param cadenaBusqueda
     * @return
     */
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

    /**
     * Dar formato a un valor Double
     */
    public String formatoDouble(Double valor) {
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato = new DecimalFormat("#.00", separadoresPersonalizados);
        return formato.format(valor);
    }

    /**
     * Utiliza la niblioteca DesktopNotify para enviar una notificacion al
     * usuario.
     *
     * @param tipo 1 exitoReistrar, 2 exitoEditar, 3 exitoEliminar, 4
     * errorRegistrar, 5 errorEditar, 6 erroreliminar.
     */
    public void notificar(Integer tipo) {
        Image iconoSucces = new ImageIcon(getClass().getResource("/imagenes/succ.png")).getImage();
        Image iconoError = new ImageIcon(getClass().getResource("/imagenes/error.png")).getImage();
        switch (tipo) {

            case 1:

                DesktopNotify.showDesktopMessage("Accion Exitosa", "Nuevo registro creado con exito", 0, iconoSucces, null, 7000);
                break;
            case 2:
                DesktopNotify.showDesktopMessage("Accion Exitosa", "Registro actualizado con exito", 0, iconoSucces, null, 7000);
                break;
            case 3:
                DesktopNotify.showDesktopMessage("Accion Exitosa", "Registro eliminado con exito", 0, iconoSucces, null, 7000);
                break;
            case 4:
                DesktopNotify.showDesktopMessage("Error", "No se pudo completar el registro", 0, iconoError, null, 7000);
                break;
            case 5:
                DesktopNotify.showDesktopMessage("Error", "No se pudo actualizar el registro", 0, iconoError, null, 7000);
                break;
            case 6:
                DesktopNotify.showDesktopMessage("Error", "No se pudo eliminar el registro", 0, iconoError, null, 7000);
                break;
        }

    }

}
