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
@Table(name = "tipo_domicilio")
public class TipoDomicilio {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_tipo_domicilio")
    private Integer idTipoDomicilio;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "codigoTipoDomicilio")
    private List<Direccion_Cliente> direccionesclientes;

    public TipoDomicilio() {
    }

    public TipoDomicilio(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdTipoDomicilio() {
        return idTipoDomicilio;
    }

    public void setIdTipoDomicilio(Integer idTipoDomicilio) {
        this.idTipoDomicilio = idTipoDomicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Direccion_Cliente> getDireccionesclientes() {
        return direccionesclientes;
    }

    public void setDireccionesclientes(List<Direccion_Cliente> direccionesclientes) {
        this.direccionesclientes = direccionesclientes;
    }

}
