package entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author TELCOM MPC
 */
@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "codigo_estado")
    private Estado codigoEstado;

    @OneToMany(mappedBy = "codigoProveedor")
    private List<MateriaPrima_Proveedor> materiasPrimas;

    @OneToMany(mappedBy = "codigoProveedor")
    private List<MateriaPrima_Marca_Proveedor> materiasPrimasMarcas;

    @OneToMany(mappedBy = "codigoProveedor")
    private List<Direccion_Proveedor> direccionesProveedores;

    @OneToMany(mappedBy = "codigoProveedor")
    private List<TelefonoProveedor> telefonos;

    public Proveedor() {
    }

    public Proveedor(String nombre, Estado codigoEstado) {
        this.nombre = nombre;
        this.codigoEstado = codigoEstado;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public List<MateriaPrima_Proveedor> getMateriasPrimas() {
        return materiasPrimas;
    }

    public void setMateriasPrimas(List<MateriaPrima_Proveedor> materiasPrimas) {
        this.materiasPrimas = materiasPrimas;
    }

    public List<MateriaPrima_Marca_Proveedor> getMateriasPrimasMarcas() {
        return materiasPrimasMarcas;
    }

    public void setMateriasPrimasMarcas(List<MateriaPrima_Marca_Proveedor> materiasPrimasMarcas) {
        this.materiasPrimasMarcas = materiasPrimasMarcas;
    }

    public List<Direccion_Proveedor> getDireccionesProveedores() {
        return direccionesProveedores;
    }

    public void setDireccionesProveedores(List<Direccion_Proveedor> direccionesProveedores) {
        this.direccionesProveedores = direccionesProveedores;
    }

    public List<TelefonoProveedor> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TelefonoProveedor> telefonos) {
        this.telefonos = telefonos;
    }

}
