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

/**
 *
 * @author TELCOM MPC
 */
@Entity
@Table(name = "localidad")
public class Localidad {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_localidad")
    private Integer idLocalidad;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cod_postal")
    private Integer codigoPostal;

    @ManyToOne
    @JoinColumn(name = "codigo_provincia")
    private Provincia codigoProvincia;

    @OneToMany(mappedBy = "codigoLocalidad")
    private List<Direccion_Cliente> direccionesclientes;

    @OneToMany(mappedBy = "codigoLocalidad")
    private List<Direccion_Proveedor> direccionesProveedores;

    public Localidad() {
    }

    public Localidad(String nombre, Integer codigoPostal, Provincia codigoProvincia) {
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.codigoProvincia = codigoProvincia;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Provincia getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(Provincia codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public List<Direccion_Cliente> getDireccionesclientes() {
        return direccionesclientes;
    }

    public void setDireccionesclientes(List<Direccion_Cliente> direccionesclientes) {
        this.direccionesclientes = direccionesclientes;
    }

    public List<Direccion_Proveedor> getDireccionesProveedores() {
        return direccionesProveedores;
    }

    public void setDireccionesProveedores(List<Direccion_Proveedor> direccionesProveedores) {
        this.direccionesProveedores = direccionesProveedores;
    }

}
