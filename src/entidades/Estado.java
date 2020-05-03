package entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author TELCOM MPC
 */
@Entity

@Table(name = "estado")

public class Estado {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer idEstado;

    @Column(name = "valor")
    private String valor;

    @OneToMany(mappedBy = "codigoEstado")
    private List<MateriaPrima> materiasPrimas;

    @OneToMany(mappedBy = "codigoEstado")
    private List<IngresoMateriaPrima> ingesosMateriaPrimas;

    @OneToMany(mappedBy = "codigoEstado")
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "codigoEstado")
    private List<Producto> productos;

    @OneToMany(mappedBy = "codigoEstado")
    private List<Proveedor> proveedores;

    @OneToMany(mappedBy = "codigoEstado")
    private List<PrecioProducto> precios;

    @OneToMany(mappedBy = "codigoEstado")
    private List<Venta> ventas;
    
    @OneToMany(mappedBy = "codigoEstado")
    private List<Gasto> gastos;
    
    
    @OneToMany(mappedBy = "codigoEstado")
    private List<CorteCaja> cortes;

    @OneToMany(mappedBy = "codigoEstado")
    private List<Iva> ivas;

    public Estado() {
    }

    public Estado(String valor) {
        this.valor = valor;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public List<MateriaPrima> getMateriasPrimas() {
        return materiasPrimas;
    }

    public void setMateriasPrimas(List<MateriaPrima> materiasPrimas) {
        this.materiasPrimas = materiasPrimas;
    }

  

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<PrecioProducto> getPrecios() {
        return precios;
    }

    public void setPrecios(List<PrecioProducto> precios) {
        this.precios = precios;
    }

    public List<IngresoMateriaPrima> getIngesosMateriaPrimas() {
        return ingesosMateriaPrimas;
    }

    public void setIngesosMateriaPrimas(List<IngresoMateriaPrima> ingesosMateriaPrimas) {
        this.ingesosMateriaPrimas = ingesosMateriaPrimas;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<CorteCaja> getCortes() {
        return cortes;
    }

    public void setCortes(List<CorteCaja> cortes) {
        this.cortes = cortes;
    }

    public List<Iva> getIvas() {
        return ivas;
    }

    public void setIvas(List<Iva> ivas) {
        this.ivas = ivas;
    }
    
    
    

}
