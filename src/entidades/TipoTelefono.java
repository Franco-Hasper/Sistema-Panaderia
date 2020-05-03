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
@Table(name = "tipo_telefono")
public class TipoTelefono {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_tipo_telefono")
    private Integer idTipoTelefono;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "codigoTipoTelefono")
    private List<TelefonoCliente> telefonosC;

    @OneToMany(mappedBy = "codigoTipoTelefono")
    private List<TelefonoProveedor> telefonosP;

    public TipoTelefono() {
    }

    public TipoTelefono(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdTipoTelefono() {
        return idTipoTelefono;
    }

    public void setIdTipoTelefono(Integer idTipoTelefono) {
        this.idTipoTelefono = idTipoTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<TelefonoCliente> getTelefonosC() {
        return telefonosC;
    }

    public void setTelefonosC(List<TelefonoCliente> telefonosC) {
        this.telefonosC = telefonosC;
    }

    public List<TelefonoProveedor> getTelefonosP() {
        return telefonosP;
    }

    public void setTelefonosP(List<TelefonoProveedor> telefonosP) {
        this.telefonosP = telefonosP;
    }

}
