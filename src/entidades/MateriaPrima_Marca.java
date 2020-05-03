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
//en la bd tiene este nombre (distinto al de mi clase)
@Table(name = "matprima_marca")

public class MateriaPrima_Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia_prima_marca")
    private Integer idMateriaPrimaMarca;

    @ManyToOne
    @JoinColumn(name = "codigo_materia_prima")
    private MateriaPrima codigoMateriaPrima;

    @ManyToOne
    @JoinColumn(name = "codigo_marca")
    private Marca codigoMarca;

    public MateriaPrima_Marca() {
    }

    public MateriaPrima_Marca(MateriaPrima codigoMateriaPrima, Marca codigoMarca) {
        this.codigoMateriaPrima = codigoMateriaPrima;
        this.codigoMarca = codigoMarca;
    }

    public Integer getIdMateriaPrimaMarca() {
        return idMateriaPrimaMarca;
    }

    public void setIdMateriaPrimaMarca(Integer idMateriaPrimaMarca) {
        this.idMateriaPrimaMarca = idMateriaPrimaMarca;
    }

    public MateriaPrima getCodigoMateriaPrima() {
        return codigoMateriaPrima;
    }

    public void setCodigoMateriaPrima(MateriaPrima codigoMateriaPrima) {
        this.codigoMateriaPrima = codigoMateriaPrima;
    }

    public Marca getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(Marca codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

}
