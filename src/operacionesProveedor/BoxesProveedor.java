package operacionesProveedor;

import calsesPadre.Consultas;
import entidades.Localidad;
import entidades.Provincia;
import entidades.TipoTelefono;
import formularios.FormularioRegistrarProveedor;
import java.util.List;
import javax.swing.JComboBox;
import clasesUtilidadGeneral.OperacionesUtiles;

/**
 *
 * @author TELCOM MPC
 */
public class BoxesProveedor extends Consultas {

    private JComboBox box;

    public JComboBox getBox() {
        return box;
    }

    public void setBox(JComboBox box) {
        this.box = box;
    }

    OperacionesUtiles opu = new OperacionesUtiles();

    public void rellenarBoxesR(FormularioRegistrarProveedor f) {

        setConsultaList("from Provincia");
        obtenerListaConsulta();
        setBox(f.getBoxProvincia());
        rellenarBoxProvincia();

        setConsultaList("from TipoTelefono");
        obtenerListaConsulta();
        setBox(f.getBoxTipoTelefono());
        rellenarTipoTelefono();

    }

    public void rellenarBoxProvincia() {
        List lista = this.getListaResultados();
        List<Provincia> lista_provincia
                = (List<Provincia>) lista;
        for (Object o : lista_provincia) {
            Provincia p = (Provincia) o;
            opu.agregarItem(p.getNombre(), getBox());
        }

    }

    public void rellenarTipoTelefono() {
        List lista = this.getListaResultados();
        List<TipoTelefono> lista_TipoTelefono
                = (List<TipoTelefono>) lista;
        for (Object o : lista_TipoTelefono) {
            TipoTelefono t = (TipoTelefono) o;
            opu.agregarItem(t.getNombre(), getBox());

        }

    }

    public void ejecutarRellenarBoxLocalidad(FormularioRegistrarProveedor f) {
        while (f.getBoxLocalidad().getItemCount() > 0) {
            f.getBoxLocalidad().removeAllItems();
        }
        setConsultaList("from Provincia");
        obtenerListaConsulta();
        setBox(f.getBoxLocalidad());
        rellenarBoxLocalidad(f);
    }

    public void rellenarBoxLocalidad(FormularioRegistrarProveedor f) {

        List lista = this.getListaResultados();
        List<Provincia> lista_Provincias
                = (List<Provincia>) lista;

        for (Object o : lista_Provincias) {
            Provincia p = (Provincia) o;
            if (p.getNombre().equals(f.getBoxProvincia().getSelectedItem().toString())) {
                List<Localidad> localidades = p.getLocalidades();
                for (Localidad l : localidades) {
                    f.getBoxLocalidad().addItem(l.getNombre());
                }

            }

        }

    }

}
