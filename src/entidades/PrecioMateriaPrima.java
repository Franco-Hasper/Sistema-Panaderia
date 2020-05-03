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

@Entity
@Table(name="precio_materia_prima")
public class PrecioMateriaPrima {
    
    @Id

    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="id_precio_materia_prima")
    private Integer idPrecioMateriaPrima;
    
    @ManyToOne
    @JoinColumn(name="codigo_materia_prima")
    private Producto codigoMateriaPrima;
    
    @Column(name="precio_bruto_unidad")
    private Double precioBrutoUnidad;
    
    @Column(name="fecha")
    private Date fecha;
    
    @Column(name="precio_total_unidad")
    private Double precioTotalUnidad;
    
    @ManyToOne
    @JoinColumn(name="codigo_iva")
    private Iva codigoIva;
    
    
    @ManyToOne
    @JoinColumn(name = "codigo_estado")
    private Estado codigoEstado;

    public PrecioMateriaPrima() {
    }

    public PrecioMateriaPrima(Producto codigoMateriaPrima, Double precioBrutoUnidad, Date fecha, Double precioTotalUnidad, Iva codigoIva, Estado codigoEstado) {
        this.codigoMateriaPrima = codigoMateriaPrima;
        this.precioBrutoUnidad = precioBrutoUnidad;
        this.fecha = fecha;
        this.precioTotalUnidad = precioTotalUnidad;
        this.codigoIva = codigoIva;
        this.codigoEstado = codigoEstado;
    }

    public Integer getIdPrecioMateriaPrima() {
        return idPrecioMateriaPrima;
    }

    public void setIdPrecioMateriaPrima(Integer idPrecioMateriaPrima) {
        this.idPrecioMateriaPrima = idPrecioMateriaPrima;
    }

    public Producto getCodigoMateriaPrima() {
        return codigoMateriaPrima;
    }

    public void setCodigoMateriaPrima(Producto codigoMateriaPrima) {
        this.codigoMateriaPrima = codigoMateriaPrima;
    }

    public Double getPrecioBrutoUnidad() {
        return precioBrutoUnidad;
    }

    public void setPrecioBrutoUnidad(Double precioBrutoUnidad) {
        this.precioBrutoUnidad = precioBrutoUnidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioTotalUnidad() {
        return precioTotalUnidad;
    }

    public void setPrecioTotalUnidad(Double precioTotalUnidad) {
        this.precioTotalUnidad = precioTotalUnidad;
    }

    public Iva getCodigoIva() {
        return codigoIva;
    }

    public void setCodigoIva(Iva codigoIva) {
        this.codigoIva = codigoIva;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }
    
    
    
}
