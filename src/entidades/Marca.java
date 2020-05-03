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
//en la bd tiene este nombre (distinto al de mi clase)
@Table(name = "marca")

public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Integer idMarca;
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "codigoMarca")
    private List<MateriaPrima_Marca> materiasPrimas;

    @OneToMany(mappedBy = "codigoMarca")
    private List<MateriaPrima_Marca_Proveedor> materiasPrimasProveedores;

    public Marca() {
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
