package operacionesMateriaPrima;

import calsesPadre.Consultas;
import entidades.Marca;
import entidades.Proveedor;
import entidades.UnidaddeMedida;
import formularios.FormularioEditarMateriaPrima;
import formularios.FormularioRegistrarMateriaPrima;
import java.util.List;
import javax.swing.JComboBox;
import clasesUtilidadGeneral.OperacionesUtiles;

public class BoxesMateriaPrima extends Consultas {

    private JComboBox box;

    public JComboBox getBox() {
        return box;
    }

    public void setBox(JComboBox box) {
        this.box = box;
    }

    OperacionesUtiles opu = new OperacionesUtiles();

    public void rellenarBoxesR(FormularioRegistrarMateriaPrima f) {

        setConsultaList("from UnidaddeMedida");
        obtenerListaConsulta();
        setBox(f.getBoxUdeMedida());
        rellenarBoxUnidadMedida();

        setConsultaList("from Marca");
        obtenerListaConsulta();
        setBox(f.getBoxMarca());
        rellenarBoxMarca();

        setConsultaList("from Proveedor");
        obtenerListaConsulta();
        setBox(f.getBoxProveedor());
        rellenarBoxProveedor();

    }

    public void rellenarBoxesE(FormularioEditarMateriaPrima f) {

        setConsultaList("from UnidaddeMedida");
        obtenerListaConsulta();
        setBox(f.getBoxUdeMedida());
        rellenarBoxUnidadMedida();

        setConsultaList("from Marca");
        obtenerListaConsulta();
        setBox(f.getBoxMarca());
        rellenarBoxMarca();

        setConsultaList("from Proveedor");
        obtenerListaConsulta();
        setBox(f.getBoxProveedor());
        rellenarBoxProveedor();

    }

    public void rellenarBoxUnidadMedida() {
        List lista = this.getListaResultados();
        List<UnidaddeMedida> lista_uDeMedida
                = (List<UnidaddeMedida>) lista;
        for (Object o : lista_uDeMedida) {
            UnidaddeMedida u = (UnidaddeMedida) o;
            opu.agregarItem(u.getNombre(), getBox());

        }

    }

    public void rellenarBoxMarca() {
        List lista = this.getListaResultados();
        List<Marca> lista_marca
                = (List<Marca>) lista;
        for (Object o : lista_marca) {
            Marca m = (Marca) o;
            opu.agregarItem(m.getNombre(), getBox());

        }

    }

    public void rellenarBoxProveedor() {
        List lista = this.getListaResultados();
        List<Proveedor> lista_proveedor
                = (List<Proveedor>) lista;
        for (Object o : lista_proveedor) {
            Proveedor p = (Proveedor) o;
            opu.agregarItem(p.getNombre(), getBox());
        }

    }

}
