package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author TELCOM MPC
 */
@Entity
@Table(name = "producto_venta")
public class Producto_Venta {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_producto_venta")
    private Integer idProductoVenta;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto codigoProducto;

    @Column(name = "total_unidades")
    private Double totalUnidades;

    @ManyToOne
    @JoinColumn(name = "codigo_venta")
    private Venta codigoVenta;

    public Producto_Venta() {
    }

    public Producto_Venta(Producto codigoProducto, Double totalUnidades, Venta codigoVenta) {
        this.codigoProducto = codigoProducto;
        this.totalUnidades = totalUnidades;
        this.codigoVenta = codigoVenta;
    }

    public Integer getIdProductoVenta() {
        return idProductoVenta;
    }

    public void setIdProductoVenta(Integer idProductoVenta) {
        this.idProductoVenta = idProductoVenta;
    }

    public Producto getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Producto codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Venta getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Venta codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Double getTotalUnidades() {
        return totalUnidades;
    }

    public void setTotalUnidades(Double totalUnidades) {
        this.totalUnidades = totalUnidades;
    }

}
