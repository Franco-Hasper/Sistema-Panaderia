package operacionesTelefono;

import calsesPadre.Consultas;
import entidades.TelefonoCliente;
import entidades.TelefonoProveedor;
import escritorios.PrincipalTelefono;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import operacionesCliente.TablaCliente;
import clasesUtilidadGeneral.OperacionesUtiles;
import operacionesProveedor.TablaProveedor;
import principal.Main;

/**
 *
 * @author TELCOM MPC
 */
public class TablaTelefono extends Consultas {

    TablaProveedor tp = new TablaProveedor();
    TablaCliente tc = new TablaCliente();

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

    public void rellenarTablaTelefonoCliente() {
        DefaultTableModel tablaDireccion = (DefaultTableModel) getTabla().getModel();
        Object objeto = this.getObjetoResultado();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaDireccion);
        for (Object o : lista) {
            TelefonoCliente telefono = (TelefonoCliente) o;
            Vector<Object> fila = new Vector<>();
            fila.add(telefono.getNuemero());
            fila.add(telefono.getCodigoTipoTelefono().getNombre());
            tablaDireccion.addRow(fila);
        }
    }

    public void rellenarTablaTelefonoProveedor() {
        DefaultTableModel tablaDireccion = (DefaultTableModel) getTabla().getModel();
        Object objeto = this.getObjetoResultado();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaDireccion);
        for (Object o : lista) {
            TelefonoProveedor telefono = (TelefonoProveedor) o;
            Vector<Object> fila = new Vector<>();
            fila.add(telefono.getNuemero());
            fila.add(telefono.getCodigoTipoTelefono().getNombre());
            tablaDireccion.addRow(fila);
        }
    }

    public void ejecutarRellenarTablaTelefonoCliente(PrincipalTelefono p) {
        String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
        setTabla(p.getTabla());
        setConsultaList("from TelefonoCliente where codigo_cliente=" + idCliente);
        obtenerListaConsulta();
        rellenarTablaTelefonoCliente();
//        tc.setEstadoConsulta(0);
//        tc.ejecutarRellenarTabla(Main.getPrincipalAdmin().getCliente());
//        Main.getPrincipalAdmin().getCliente().setT(tc);
    }

    public void ejecutarRellenarTablaTelefonoProveedor(PrincipalTelefono p) {
        String idProveedor = Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla().toString();
        setTabla(p.getTabla());
        setConsultaList("from TelefonoProveedor where codigo_proveedor=" + idProveedor);
        obtenerListaConsulta();
        rellenarTablaTelefonoProveedor();
////        tp.setEstadoConsulta(0);
////        tp.ejecutarRellenarTabla(Main.getPrincipalAdmin().getProveedor());
////        Main.getPrincipalAdmin().getProveedor().setT(tp);
    }

}
