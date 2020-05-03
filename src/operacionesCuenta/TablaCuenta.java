package operacionesCuenta;

import calsesPadre.Consultas;
import entidades.Cuenta;
import entidades.MovimientoCuenta;
import escritorios.PrincipalCuenta;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import clasesUtilidadGeneral.OperacionesUtiles;

/**
 *
 * @author TELCOM MPC
 */
public class TablaCuenta extends Consultas {

    private JTable tabla;
    private Integer idTabla;

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public Integer getIdTabla() {
        return idTabla;
    }

    public void setIdTabla(Integer idTabla) {
        this.idTabla = idTabla;
    }

    OperacionesUtiles opu = new OperacionesUtiles();

    public void rellenarTabla() {
        DefaultTableModel tablaCuenta = (DefaultTableModel) getTabla().getModel();
        Object objeto = this.getObjetoResultado();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaCuenta);
        Cuenta cuenta = (Cuenta) objeto;
        for (Object o : lista) {
            MovimientoCuenta mv = (MovimientoCuenta) o;
            Vector<Object> fila = new Vector<>();
            if (mv.getCodigoCuenta().getIdCuenta().equals(cuenta.getIdCuenta())) {
                fila.add(mv.getMotivo());
                fila.add(mv.getMonto());
                fila.add(mv.getBalance());
                fila.add(opu.formatoFecha(mv.getFecha()));
                tablaCuenta.addRow(fila);
            }
        }
    }

    public void ejecutarRellenarTablaCuenta(PrincipalCuenta p) {

        try {

            setTabla(p.getTabla());
            setConsultaObject("from Cuenta where id_cuenta=" + p.getBoxCuenta().getSelectedItem().toString());
            obtenerObjetoConsulta();
            if (p.getTxtBuscarHistorial().getText().equals("")) {
                setConsultaList("from MovimientoCuenta");
                obtenerListaConsulta();
                rellenarTabla();
            } else {
                setConsultaList("from MovimientoCuenta where fecha like '" + p.getTxtBuscarHistorial().getText() + "%'");
                obtenerListaConsulta();
                rellenarTabla();
            }
        } catch (NullPointerException e) {
        }
    }

}
