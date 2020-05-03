package entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author TELCOM MPC
 */
@Entity
@Table(name = "venta")
public class Venta {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_venta")
    private Integer idVenta;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Cliente codigoCliente;

    @Column(name = "fecha_hora_venta")
    private Date fechaHoraVenta;

    @Column(name = "preciototal")
    private Double precioTotal;

    @ManyToOne
    @JoinColumn(name = "codigo_estado")
    private Estado codigoEstado;

    @ManyToOne
    @JoinColumn(name = "codigo_tipo_venta")
    private TipoVenta codigoTipoVenta;

    @OneToMany(mappedBy = "codigoVenta")
    private List<Producto_Venta> productos;

    public Venta() {
    }

    public Venta(Cliente codigoCliente, Date fechaHoraVenta, Double precioTotal, Estado codigoEstado, TipoVenta codigoTipoVenta) {
        this.codigoCliente = codigoCliente;
        this.fechaHoraVenta = fechaHoraVenta;
        this.precioTotal = precioTotal;
        this.codigoEstado = codigoEstado;
        this.codigoTipoVenta = codigoTipoVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Cliente codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Date getFechaHoraVenta() {
        return fechaHoraVenta;
    }

    public void setFechaHoraVenta(Date fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
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

    public TipoVenta getCodigoTipoVenta() {
        return codigoTipoVenta;
    }

    public void setCodigoTipoVenta(TipoVenta codigoTipoVenta) {
        this.codigoTipoVenta = codigoTipoVenta;
    }

    public List<Producto_Venta> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto_Venta> productos) {
        this.productos = productos;
    }

}
