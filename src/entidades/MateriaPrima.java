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

@Entity
@Table(name = "matprima")
public class MateriaPrima {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_materia_prima")
    private Integer idMateriaPrima;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "codigo_ud_medida")
    private UnidaddeMedida codigoUnidaddeMedida;

    @ManyToOne
    @JoinColumn(name = "codigo_estado")
    private Estado codigoEstado;

    //una Materia prima puede generar muchos ingresos de materia prima
    @OneToMany(mappedBy = "codigoMateriaPrima")
    private List<IngresoMateriaPrima> gastos;

    @OneToMany(mappedBy = "codigoMateriaPrima")
    private List<MateriaPrima_Marca> marcas;

    @OneToMany(mappedBy = "codigoMateriaPrima")
    private List<MateriaPrima_Proveedor> materiasPrimasProveedores;

    @OneToMany(mappedBy = "codigoMateriaPrima")
    private List<MateriaPrima_Marca_Proveedor> marcasProveedores;

    @OneToMany(mappedBy = "codigoMateriaPrima")
    private List<PrecioMateriaPrima> precios;

    public MateriaPrima() {
    }

    public MateriaPrima(String nombre, UnidaddeMedida codigoUnidaddeMedida, Estado codigoEstado) {
        this.nombre = nombre;
        this.codigoUnidaddeMedida = codigoUnidaddeMedida;
        this.codigoEstado = codigoEstado;
    }

    public Integer getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidaddeMedida getCodigoUnidaddeMedida() {
        return codigoUnidaddeMedida;
    }

    public void setCodigoUnidaddeMedida(UnidaddeMedida codigoUnidaddeMedida) {
        this.codigoUnidaddeMedida = codigoUnidaddeMedida;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public List<IngresoMateriaPrima> getGastos() {
        return gastos;
    }

    public void setGastos(List<IngresoMateriaPrima> gastos) {
        this.gastos = gastos;
    }

    public List<MateriaPrima_Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<MateriaPrima_Marca> marcas) {
        this.marcas = marcas;
    }

    public List<MateriaPrima_Proveedor> getMateriasPrimasProveedores() {
        return materiasPrimasProveedores;
    }

    public void setMateriasPrimasProveedores(List<MateriaPrima_Proveedor> materiasPrimasProveedores) {
        this.materiasPrimasProveedores = materiasPrimasProveedores;
    }

    public List<MateriaPrima_Marca_Proveedor> getMarcasProveedores() {
        return marcasProveedores;
    }

    public void setMarcasProveedores(List<MateriaPrima_Marca_Proveedor> marcasProveedores) {
        this.marcasProveedores = marcasProveedores;
    }

    public List<PrecioMateriaPrima> getPrecios() {
        return precios;
    }

    public void setPrecios(List<PrecioMateriaPrima> precios) {
        this.precios = precios;
    }

}

/*@JoinTable(
        name = "matprima_marca",
        joinColumns = @JoinColumn(name = "codigo_materia_prima", nullable = false),
        inverseJoinColumns = @JoinColumn(name="codigo_marca", nullable = false)
    )
    
    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    private List<Marca> mtmr;
    
 */
    //-----------------------------
