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
@Table(name = "movimiento_cuenta")
public class MovimientoCuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento_cuenta")
    private Integer idMovimientoCuenta;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "codigo_cuenta")
    private Cuenta codigoCuenta;

    public MovimientoCuenta() {
    }

    public MovimientoCuenta(String motivo, Double monto, Double balance, Date fecha, Cuenta codigoCuenta) {
        this.motivo = motivo;
        this.monto = monto;
        this.balance = balance;
        this.fecha = fecha;
        this.codigoCuenta = codigoCuenta;
    }

    public Integer getIdMovimientoCuenta() {
        return idMovimientoCuenta;
    }

    public void setIdMovimientoCuenta(Integer idMovimientoCuenta) {
        this.idMovimientoCuenta = idMovimientoCuenta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Cuenta getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(Cuenta codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
