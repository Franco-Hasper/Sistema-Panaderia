package entidades;

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

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "codigo_razon_social")
    private RazonSocial codigoRazonSocial;

    @ManyToOne
    @JoinColumn(name = "codigo_tipo_cliente")
    private TipoCliente codigoTipoCliente;

    @ManyToOne
    @JoinColumn(name = "codigo_estado")
    private Estado codigoEstado;

    @OneToMany(mappedBy = "codigoCliente")
    private List<Direccion_Cliente> direccionesclientes;

    @OneToMany(mappedBy = "codigoCliente")
    private List<TelefonoCliente> telefonos;

    @OneToMany(mappedBy = "codigoCliente")
    private List<Venta> ventas;

    @OneToMany(mappedBy = "codigoCliente")
    private List<Cuenta> cuenta;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, RazonSocial codigoRazonSocial, TipoCliente codigoTipoCliente, Estado codigoEstado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoRazonSocial = codigoRazonSocial;
        this.codigoTipoCliente = codigoTipoCliente;
        this.codigoEstado = codigoEstado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public RazonSocial getCodigoRazonSocial() {
        return codigoRazonSocial;
    }

    public void setCodigoRazonSocial(RazonSocial codigoRazonSocial) {
        this.codigoRazonSocial = codigoRazonSocial;
    }

    public TipoCliente getCodigoTipoCliente() {
        return codigoTipoCliente;
    }

    public void setCodigoTipoCliente(TipoCliente codigoTipoCliente) {
        this.codigoTipoCliente = codigoTipoCliente;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public List<Direccion_Cliente> getDireccionesclientes() {
        return direccionesclientes;
    }

    public void setDireccionesclientes(List<Direccion_Cliente> direccionesclientes) {
        this.direccionesclientes = direccionesclientes;
    }

    public List<TelefonoCliente> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TelefonoCliente> telefonos) {
        this.telefonos = telefonos;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(List<Cuenta> cuenta) {
        this.cuenta = cuenta;
    }

}
