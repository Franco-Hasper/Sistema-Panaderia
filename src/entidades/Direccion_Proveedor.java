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
@Table(name="direccion_proveedor")
public class Direccion_Proveedor {
    
    @Id

    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="id_direccion_proveedor")
    private Integer idDireccionProveedor;
    
   @ManyToOne
  @JoinColumn(name="codigo_proveedor")
    private Proveedor codigoProveedor;
    
    @Column(name="nombre")
    private String nombre;
    @Column(name="numero")
    private Integer numero;
    
    @ManyToOne
  @JoinColumn(name="codigo_localidad")
    private Localidad codigoLocalidad;

    public Direccion_Proveedor() {
    }

    public Direccion_Proveedor(Proveedor codigoProveedor, Integer numero, Localidad codigoLocalidad) {
        this.codigoProveedor = codigoProveedor;
        this.numero = numero;
       
        this.codigoLocalidad = codigoLocalidad;
    }

    public Integer getIdDireccionProveedor() {
        return idDireccionProveedor;
    }

    public void setIdDireccionProveedor(Integer idDireccionProveedor) {
        this.idDireccionProveedor = idDireccionProveedor;
    }

    public Proveedor getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Proveedor codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }


    public Localidad getCodigoLocalidad() {
        return codigoLocalidad;
    }

    public void setCodigoLocalidad(Localidad codigoLocalidad) {
        this.codigoLocalidad = codigoLocalidad;
    }
    
    
    
}
