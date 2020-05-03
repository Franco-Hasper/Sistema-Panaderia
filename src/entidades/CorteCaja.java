package entidades;

import java.util.Date;
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
@Table(name = "corte_caja")
public class CorteCaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corte_caja")
    private Integer idCorteCaja;
    
    @Column(name = "total_ingresos")
    private Double totalIngresos;
    @Column(name = "total_egresos")
    private Double totalEgresos;
    @Column(name = "balance")
    private Double balance;
      @Column(name = "fecha")
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name="codigo_estado")
    private Estado codigoEstado;
    


    public CorteCaja() {
    }

    public CorteCaja(Double totalIngresos, Double totalEgresos, Double balance, Estado codigoEstado) {
        this.totalIngresos = totalIngresos;
        this.totalEgresos = totalEgresos;
        this.balance = balance;
        this.codigoEstado = codigoEstado;
    }



    public Integer getIdCorteCaja() {
        return idCorteCaja;
    }

    public void setIdCorteCaja(Integer idCorteCaja) {
        this.idCorteCaja = idCorteCaja;
    }

    public Double getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(Double totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public Double getTotalEgresos() {
        return totalEgresos;
    }

    public void setTotalEgresos(Double totalEgresos) {
        this.totalEgresos = totalEgresos;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
     
}
