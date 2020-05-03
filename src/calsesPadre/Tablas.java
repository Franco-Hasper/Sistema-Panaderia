package calsesPadre;

import javax.swing.JTable;
import javax.swing.JTextField;
import clasesUtilidadGeneral.OperacionesUtiles;

/**
 *
 * @author FRANCO
 */
public class Tablas extends Consultas {

    protected OperacionesUtiles opu = new OperacionesUtiles();

    protected JTable tabla;
    protected Integer idTabla;
    protected Integer estadoConsulta;
    protected String stringConsulta;
    protected JTextField campoTexto;

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

    public Integer getEstadoConsulta() {
        return estadoConsulta;
    }

    public void setEstadoConsulta(Integer estadoConsulta) {
        this.estadoConsulta = estadoConsulta;
    }

    public String getStringConsulta() {
        return stringConsulta;
    }

    public void setStringConsulta(String stringConsulta) {
        this.stringConsulta = stringConsulta;
    }

    public JTextField getCampoTexto() {
        return campoTexto;
    }

    public void setCampoTexto(JTextField campoTexto) {
        this.campoTexto = campoTexto;
    }

    public void evaluarEstadoConsulta() {
        switch (getEstadoConsulta()) {
            case 0:
                obtenerDatosConsulta();
                break;
            case 1:
                break;
        }
    }

    public void obtenerDatosConsulta() {
        setConsultaList(this.stringConsulta);
        obtenerListaConsulta();
        setEstadoConsulta(1);
    }

    public void rellenarTabla(String valorBusqueda) {
    }
    
    
    public void rellenarTabla() {
    }
}
