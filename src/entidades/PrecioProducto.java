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

/**
 * @author TELCOM MPC
 */
@Entity
@Table(name = "precio_producto")
public class PrecioProducto {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_precio")
    private Integer idPrecio;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto codigoProducto;

    @Column(name = "precio_bruto")
    private Double precioBruto;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "precio_total")
    private Double precioTotal;

    @ManyToOne
    @JoinColumn(name = "codigo_iva")
    private Iva codigoIva;

    @ManyToOne
    @JoinColumn(name = "codigo_estado")
    private Estado codigoEstado;

    public PrecioProducto() {
    }

    public PrecioProducto(Producto codigoProducto, Double precioBruto, Date fecha, Double precioTotal, Iva codigoIva, Estado codigoEstado) {
        this.codigoProducto = codigoProducto;
        this.precioBruto = precioBruto;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.codigoIva = codigoIva;
        this.codigoEstado = codigoEstado;
    }

    public Integer getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public Producto getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Producto codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Double getPrecioBruto() {
        return precioBruto;
    }

    public void setPrecioBruto(Double precioBruto) {
        this.precioBruto = precioBruto;
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
