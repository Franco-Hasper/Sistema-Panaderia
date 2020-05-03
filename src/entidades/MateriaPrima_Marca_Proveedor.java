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
@Table(name = "materiaprima_marca_proveedor")

public class MateriaPrima_Marca_Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materiaprima_marca_proveedor")
    private Integer idMateriaPrimaMarcaProveedor;

    @ManyToOne
    @JoinColumn(name = "codigo_materia_prima")
    private MateriaPrima codigoMateriaPrima;

    @ManyToOne
    @JoinColumn(name = "codigo_marca")
    private Marca codigoMarca;

    @ManyToOne
    @JoinColumn(name = "codigo_proveedor")
    private Proveedor codigoProveedor;

    public MateriaPrima_Marca_Proveedor() {
    }

    public MateriaPrima_Marca_Proveedor(MateriaPrima codigoMateriaPrima, Marca codigoMarca, Proveedor codigoProveedor) {
        this.codigoMateriaPrima = codigoMateriaPrima;
        this.codigoMarca = codigoMarca;
        this.codigoProveedor = codigoProveedor;
    }

    public Integer getIdMateriaPrimaMarcaProveedor() {
        return idMateriaPrimaMarcaProveedor;
    }

    public void setIdMateriaPrimaMarcaProveedor(Integer idMateriaPrimaMarcaProveedor) {
        this.idMateriaPrimaMarcaProveedor = idMateriaPrimaMarcaProveedor;
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

    public Proveedor getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Proveedor codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

}
