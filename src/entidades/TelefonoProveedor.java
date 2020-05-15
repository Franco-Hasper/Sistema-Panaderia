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
@Table(name = "telefono_proveedor")
public class TelefonoProveedor {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_telefono_proveedor")
    private Integer idTelefonoProveedor;

    @Column(name = "numero")
    private String nuemero;

    @ManyToOne
    @JoinColumn(name = "codigo_proveedor")
    private Proveedor codigoProveedor;

    @ManyToOne
    @JoinColumn(name = "codigo_tipo_telefono")
    private TipoTelefono codigoTipoTelefono;

    public TelefonoProveedor() {
    }

    public TelefonoProveedor(String nuemero, Proveedor codigoProveedor, TipoTelefono codigoTipoTelefono) {
        this.nuemero = nuemero;
        this.codigoProveedor = codigoProveedor;
        this.codigoTipoTelefono = codigoTipoTelefono;
    }

    public Integer getIdTelefonoProveedor() {
        return idTelefonoProveedor;
    }

    public void setIdTelefonoProveedor(Integer idTelefonoProveedor) {
        this.idTelefonoProveedor = idTelefonoProveedor;
    }

    public String getNuemero() {
        return nuemero;
    }

    public void setNuemero(String nuemero) {
        this.nuemero = nuemero;
    }

    public Proveedor getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Proveedor codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public TipoTelefono getCodigoTipoTelefono() {
        return codigoTipoTelefono;
    }

    public void setCodigoTipoTelefono(TipoTelefono codigoTipoTelefono) {
        this.codigoTipoTelefono = codigoTipoTelefono;
    }

}
