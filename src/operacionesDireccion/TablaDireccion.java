package operacionesDireccion;

import calsesPadre.Consultas;
import entidades.Direccion_Cliente;
import entidades.Direccion_Proveedor;
import escritorios.PrincipalDireccion;
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
public class TablaDireccion extends Consultas {

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

    public void rellenarTablaDireccionCliente() {
        DefaultTableModel tablaDireccion = (DefaultTableModel) getTabla().getModel();
        Object objeto = this.getObjetoResultado();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaDireccion);
        for (Object o : lista) {
            Direccion_Cliente direccion = (Direccion_Cliente) o;
            Vector<Object> fila = new Vector<>();
            fila.add(direccion.getNombre());
            fila.add(direccion.getNumero());
            fila.add(direccion.getCodigoLocalidad().getNombre());
            fila.add(direccion.getCodigoLocalidad().getCodigoPostal());
            fila.add(direccion.getCodigoLocalidad().getCodigoProvincia().getNombre());
            tablaDireccion.addRow(fila);
        }
    }

    public void rellenarTablaDireccionProveedor() {
        DefaultTableModel tablaDireccion = (DefaultTableModel) getTabla().getModel();
        Object objeto = this.getObjetoResultado();
        List lista = this.getListaResultados();
        opu.removerFilas(tablaDireccion);
        for (Object o : lista) {
            Direccion_Proveedor direccion = (Direccion_Proveedor) o;
            Vector<Object> fila = new Vector<>();
            fila.add(direccion.getNombre());
            fila.add(direccion.getNumero());
            fila.add(direccion.getCodigoLocalidad().getNombre());
            fila.add(direccion.getCodigoLocalidad().getCodigoPostal());
            fila.add(direccion.getCodigoLocalidad().getCodigoProvincia().getNombre());
            tablaDireccion.addRow(fila);
        }
    }

    public void ejecutarRellenarTablaDireccionCliente(PrincipalDireccion p) {
        String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
        setTabla(p.getTabla());
        setConsultaList("from Direccion_Cliente where codigo_cliente=" + idCliente);
        obtenerListaConsulta();
        rellenarTablaDireccionCliente();
        //   tc.setEstadoConsulta(0);
        //  tc.ejecutarRellenarTabla(Main.getPrincipalAdmin().getCliente());
        // Main.getPrincipalAdmin().getCliente().setT(tc);
    }

    public void ejecutarRellenarTablaDireccionProveedor(PrincipalDireccion p) {
        String idProveedor = Main.getPrincipalAdmin().getProveedor().ObjetoTablaConDatos().getIdTabla().toString();
        setTabla(p.getTabla());
        setConsultaList("from Direccion_Proveedor where codigo_proveedor=" + idProveedor);
        obtenerListaConsulta();
        rellenarTablaDireccionProveedor();
        //   tp.setEstadoConsulta(0);
        // tp.ejecutarRellenarTabla(Main.getPrincipalAdmin().getProveedor());
        // Main.getPrincipalAdmin().getProveedor().setT(tp);
    }

}
