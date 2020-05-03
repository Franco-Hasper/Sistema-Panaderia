package calsesPadre;

import conexion.ConexionHibernate;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * <h1>Clase Consultas</h1>
 * Contiene atributos y metodos que se encargan de obtener resultados de la base
 * de datos.
 *
 * @author Hasper Franco
 * @version 0.1
 * @since 2019-11-14
 */
public abstract class Consultas {

    /**
     * Atributo encargado de alojar una consulta sql para una lista de
     * resultados.
     */
    protected String consultaList;
    /**
     * Atributo encargado de alojar una consulta sql para un resultado unico.
     */
    protected String consultaObject;
    /**
     * Atributo que aloja una lista obtenida en una consulta.
     */
    protected List listaResultados;
    /**
     * Atributo que aloja un resutado unico corrspondiente a una clase
     * especifica obtenida en una consulta.
     */
    protected Object objetoResultado;

    public Object getObjetoResultado() {
        return objetoResultado;
    }

    public void setObjetoResultado(Object objetoResultado) {
        this.objetoResultado = objetoResultado;
    }

    public String getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(String consultaList) {
        this.consultaList = consultaList;
    }

    public String getConsultaObject() {
        return consultaObject;
    }

    public void setConsultaObject(String consultaObject) {
        this.consultaObject = consultaObject;
    }

    public List getListaResultados() {
        return listaResultados;
    }

    public void setListaResultados(List listaResultados) {
        this.listaResultados = listaResultados;
    }

    public void obtenerListaConsulta() {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Query q = miSesion.createQuery(getConsultaList());
            setListaResultados(q.list());
        } catch (HibernateException ex) {

        }

    }

    public void obtenerObjetoConsulta() {
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Query query = miSesion.createQuery(getConsultaObject());
            query.setMaxResults(1);
            Object o = (query.uniqueResult());
            setObjetoResultado(o);
        } catch (NonUniqueResultException ex) {
        }
    }

}
