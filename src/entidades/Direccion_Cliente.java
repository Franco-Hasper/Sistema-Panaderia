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
 * @author TELCOM MPC
 */

@Entity
@Table(name="direccion_cliente")
public class Direccion_Cliente {
    
    @Id

    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="id_direccion_cliente")
    private Integer idDireccionCliente;
    
   
    
    @Column(name="nombre")
    private String nombre;
    @Column(name="numero")
    private Integer numero;
    
    @ManyToOne
  @JoinColumn(name="codigo_cliente")
    private Cliente codigoCliente;
    
    
    @ManyToOne
  @JoinColumn(name="codigo_tipo_domicilio")
    private TipoDomicilio codigoTipoDomicilio;
    
    
    @ManyToOne
  @JoinColumn(name="codigo_localidad")
    private Localidad codigoLocalidad;

    public Direccion_Cliente() {
    }

    public Direccion_Cliente(Cliente codigoCliente, String nombre, Integer numero, TipoDomicilio codigoTipoDomicilio, Localidad codigoLocalidad) {
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.numero = numero;
        this.codigoTipoDomicilio = codigoTipoDomicilio;
        this.codigoLocalidad = codigoLocalidad;
    }

    public Integer getIdDireccionCliente() {
        return idDireccionCliente;
    }

    public void setIdDireccionCliente(Integer idDireccionCliente) {
        this.idDireccionCliente = idDireccionCliente;
    }

    public Cliente getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Cliente codigoCliente) {
        this.codigoCliente = codigoCliente;
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

    public TipoDomicilio getCodigoTipoDomicilio() {
        return codigoTipoDomicilio;
    }

    public void setCodigoTipoDomicilio(TipoDomicilio codigoTipoDomicilio) {
        this.codigoTipoDomicilio = codigoTipoDomicilio;
    }

    public Localidad getCodigoLocalidad() {
        return codigoLocalidad;
    }

    public void setCodigoLocalidad(Localidad codigoLocalidad) {
        this.codigoLocalidad = codigoLocalidad;
    }
    
    
    
}
