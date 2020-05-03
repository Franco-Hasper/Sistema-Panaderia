package operacionesVenta;

import calsesPadre.Consultas;
import entidades.TipoVenta;
import formularios.FormularioEditarVenta;
import formularios.FormularioRegistrarVenta;
import java.util.List;
import javax.swing.JComboBox;
import clasesUtilidadGeneral.OperacionesUtiles;

/**
 *
 * @author TELCOM MPC
 */
public class BoxesVenta extends Consultas {

    private JComboBox box;

    public JComboBox getBox() {
        return box;
    }

    public void setBox(JComboBox box) {
        this.box = box;
    }

    OperacionesUtiles opu = new OperacionesUtiles();

    public void rellenarBoxesR(FormularioRegistrarVenta f) {
        setConsultaList("from TipoVenta");
        obtenerListaConsulta();
        setBox(f.getBoxTipoVenta());
        rellenarBoxTipoVenta();

    }

    public void rellenarBoxesE(FormularioEditarVenta f) {
        setConsultaList("from TipoVenta");
        obtenerListaConsulta();
        setBox(f.getBoxTipoVenta());
        rellenarBoxTipoVenta();

    }

    public void rellenarBoxTipoVenta() {
        List lista = this.getListaResultados();
        List<TipoVenta> lista_tVenta
                = (List<TipoVenta>) lista;
        for (Object o : lista_tVenta) {
            TipoVenta tv = (TipoVenta) o;
            opu.agregarItem(tv.getNombre(), getBox());
        }

    }

}
