package entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//decir que a clase es una entidad
@Entity
//en la bd tiene este nombre (distinto al de mi clase)
@Table(name = "ingreso_mat_prima")

/**
 *
 * @author TELCOM MPC
 */
public class IngresoMateriaPrima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_ingreso_mat_prima")
    private Integer idIngresoMateriaPrima;

    @ManyToOne
    @JoinColumn(name = "codigo_materia_prima")
    private MateriaPrima codigoMateriaPrima;

    @Column(name = "total_envases")
    private Double totalEnvases;

    @Column(name = "ud_por_envase")
    private Double udPorEnvase;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "precio_total")
    private Double precioTotal;

    @ManyToOne
    @JoinColumn(name = "codigo_estado")
    private Estado codigoEstado;

    public IngresoMateriaPrima() {
    }

    public IngresoMateriaPrima(MateriaPrima codigoMateriaPrima, Double totalEnvases, Double udPorEnvase, Date fecha, Double precioTotal, Estado codigoEstado) {
        this.codigoMateriaPrima = codigoMateriaPrima;
        this.totalEnvases = totalEnvases;
        this.udPorEnvase = udPorEnvase;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.codigoEstado = codigoEstado;
    }

    public Integer getIdIngresoMateriaPrima() {
        return idIngresoMateriaPrima;
    }

    public void setIdIngresoMateriaPrima(Integer idIngresoMateriaPrima) {
        this.idIngresoMateriaPrima = idIngresoMateriaPrima;
    }

    public MateriaPrima getCodigoMateriaPrima() {
        return codigoMateriaPrima;
    }

    public void setCodigoMateriaPrima(MateriaPrima codigoMateriaPrima) {
        this.codigoMateriaPrima = codigoMateriaPrima;
    }

    public Double getTotalEnvases() {
        return totalEnvases;
    }

    public void setTotalEnvases(Double totalEnvases) {
        this.totalEnvases = totalEnvases;
    }

    public Double getUdPorEnvase() {
        return udPorEnvase;
    }

    public void setUdPorEnvase(Double udPorEnvase) {
        this.udPorEnvase = udPorEnvase;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

}
