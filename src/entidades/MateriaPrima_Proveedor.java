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
@Table(name = "matprima_proveedor")
public class MateriaPrima_Proveedor {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_materiaprima_proveedor")
    private Integer idMateriaPrimaProveedor;

    @ManyToOne
    @JoinColumn(name = "codigo_materia_prima")
    private MateriaPrima codigoMateriaPrima;

    @ManyToOne
    @JoinColumn(name = "codigo_proveedor")
    private Proveedor codigoProveedor;

    public MateriaPrima_Proveedor() {
    }

    public MateriaPrima_Proveedor(MateriaPrima codigoMateriaPrima, Proveedor codigoProveedor) {
        this.codigoMateriaPrima = codigoMateriaPrima;
        this.codigoProveedor = codigoProveedor;
    }

    public Integer getIdMateriaPrimaProveedor() {
        return idMateriaPrimaProveedor;
    }

    public void setIdMateriaPrimaProveedor(Integer idMateriaPrimaProveedor) {
        this.idMateriaPrimaProveedor = idMateriaPrimaProveedor;
    }

    public MateriaPrima getCodigoMateriaPrima() {
        return codigoMateriaPrima;
    }

    public void setCodigoMateriaPrima(MateriaPrima codigoMateriaPrima) {
        this.codigoMateriaPrima = codigoMateriaPrima;
    }

    public Proveedor getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Proveedor codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

}
