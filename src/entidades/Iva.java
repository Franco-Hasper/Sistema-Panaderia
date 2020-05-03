package entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author TELCOM MPC
 */
@Entity
@Table(name = "iva")
public class Iva {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_iva")
    private Integer idIva;

    @Column(name = "porcentaje")
    private Double porcentaje;

    @ManyToOne
    @JoinColumn(name = "codigo_estado")
    private Estado codigoEstado;

    @OneToMany(mappedBy = "codigoIva")
    private List<PrecioProducto> precios;

    public Iva() {
    }

    public Iva(Double porcentaje, Estado codigoEstado) {
        this.porcentaje = porcentaje;
        this.codigoEstado = codigoEstado;
    }

    public Integer getIdIva() {
        return idIva;
    }

    public void setIdIva(Integer idIva) {
        this.idIva = idIva;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public List<PrecioProducto> getPrecios() {
        return precios;
    }

    public void setPrecios(List<PrecioProducto> precios) {
        this.precios = precios;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

}
