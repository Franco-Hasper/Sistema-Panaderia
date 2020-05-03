package operacionesCliente;

import calsesPadre.Consultas;
import entidades.Localidad;
import entidades.Provincia;
import entidades.TipoDomicilio;
import entidades.TipoTelefono;
import formularios.FormularioEditarDireccion;
import formularios.FormularioEditarTelefono;
import formularios.FormularioRegistrarCliente;
import formularios.FormularioRegistrarDireccion;
import formularios.FormularioRegistrarTelefono;
import java.util.List;
import javax.swing.JComboBox;
import clasesUtilidadGeneral.OperacionesUtiles;

public class BoxesCliente extends Consultas {

    private JComboBox box;

    public JComboBox getBox() {
        return box;
    }

    public void setBox(JComboBox box) {
        this.box = box;
    }

    OperacionesUtiles opu = new OperacionesUtiles();

    public void rellenarBoxesR(FormularioRegistrarCliente f) {

        setConsultaList("from Provincia");
        obtenerListaConsulta();
        setBox(f.getBoxProvincia());
        rellenarBoxProvincia();

        setConsultaList("from TipoDomicilio");
        obtenerListaConsulta();
        setBox(f.getBoxtipoDom());
        rellenarTipoDomicilio();

        setConsultaList("from TipoTelefono");
        obtenerListaConsulta();
        setBox(f.getBoxTipoTelefono());
        rellenarTipoTelefono();

    }

    public void rellenarBoxesED(FormularioEditarDireccion f) {

        setConsultaList("from Provincia");
        obtenerListaConsulta();
        setBox(f.getBoxProvincia());
        rellenarBoxProvincia();

        setConsultaList("from TipoDomicilio");
        obtenerListaConsulta();
        setBox(f.getBoxtipoDom());
        rellenarTipoDomicilio();

    }

    public void rellenarBoxesRD(FormularioRegistrarDireccion f) {

        setConsultaList("from Provincia");
        obtenerListaConsulta();
        setBox(f.getBoxProvincia());
        rellenarBoxProvincia();

        setConsultaList("from TipoDomicilio");
        obtenerListaConsulta();
        setBox(f.getBoxtipoDom());
        rellenarTipoDomicilio();

    }

    public void rellenarBoxesET(FormularioEditarTelefono f) {
        setConsultaList("from TipoTelefono");
        obtenerListaConsulta();
        setBox(f.getBoxTipoTelefono());
        rellenarTipoTelefono();

    }

    public void rellenarBoxesRT(FormularioRegistrarTelefono f) {
        setConsultaList("from TipoTelefono");
        obtenerListaConsulta();
        setBox(f.getBoxTipoTelefono());
        rellenarTipoTelefono();

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

    public void rellenarTipoDomicilio() {
        List lista = this.getListaResultados();
        List<TipoDomicilio> lista_tipoDom
                = (List<TipoDomicilio>) lista;
        for (Object o : lista_tipoDom) {
            TipoDomicilio td = (TipoDomicilio) o;
            opu.agregarItem(td.getNombre(), getBox());

        }

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

    public void ejecutarRellenarBoxLocalidad(FormularioRegistrarCliente f) {
        while (f.getBoxLocalidad().getItemCount() > 0) {
            f.getBoxLocalidad().removeAllItems();
        }
        setConsultaList("from Provincia");
        obtenerListaConsulta();
        setBox(f.getBoxLocalidad());
        rellenarBoxLocalidad(f);
    }

    public void ejecutarRellenarBoxLocalidad(FormularioRegistrarDireccion f) {
        while (f.getBoxLocalidad().getItemCount() > 0) {
            f.getBoxLocalidad().removeAllItems();
        }
        setConsultaList("from Provincia");
        obtenerListaConsulta();
        setBox(f.getBoxLocalidad());
        rellenarBoxLocalidad(f);
    }

    public void ejecutarRellenarBoxLocalidad(FormularioEditarDireccion f) {
        while (f.getBoxLocalidad().getItemCount() > 0) {
            f.getBoxLocalidad().removeAllItems();
        }
        setConsultaList("from Provincia");
        obtenerListaConsulta();
        setBox(f.getBoxLocalidad());
        rellenarBoxLocalidad(f);
    }

    public void rellenarBoxLocalidad(FormularioRegistrarCliente f) {

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

    public void rellenarBoxLocalidad(FormularioRegistrarDireccion f) {

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

    public void rellenarBoxLocalidad(FormularioEditarDireccion f) {

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
