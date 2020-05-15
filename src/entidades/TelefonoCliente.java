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
@Table(name = "telefono_cliente")
public class TelefonoCliente {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_telefono")
    private Integer idTelefonoCliente;

    @Column(name = "numero")
    private String nuemero;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Cliente codigoCliente;

    @ManyToOne
    @JoinColumn(name = "codigo_tipo_telefono")
    private TipoTelefono codigoTipoTelefono;

    public TelefonoCliente() {
    }

    public TelefonoCliente(String nuemero, Cliente codigoCliente, TipoTelefono codigoTipoTelefono) {
        this.nuemero = nuemero;
        this.codigoCliente = codigoCliente;
        this.codigoTipoTelefono = codigoTipoTelefono;
    }

    public Integer getIdTelefonoCliente() {
        return idTelefonoCliente;
    }

    public void setIdTelefonoCliente(Integer idTelefonoCliente) {
        this.idTelefonoCliente = idTelefonoCliente;
    }

    public String getNuemero() {
        return nuemero;
    }

    public void setNuemero(String nuemero) {
        this.nuemero = nuemero;
    }

    public Cliente getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Cliente codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public TipoTelefono getCodigoTipoTelefono() {
        return codigoTipoTelefono;
    }

    public void setCodigoTipoTelefono(TipoTelefono codigoTipoTelefono) {
        this.codigoTipoTelefono = codigoTipoTelefono;
    }

}
