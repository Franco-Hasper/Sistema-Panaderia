package conexion;

import entidades.Cliente;
import entidades.CorteCaja;
import entidades.Cuenta;
import entidades.Direccion_Cliente;
import entidades.Direccion_Proveedor;
import entidades.Estado;
import entidades.Gasto;
import entidades.MateriaPrima;
import entidades.IngresoMateriaPrima;
import entidades.Iva;
import entidades.Localidad;
import entidades.Marca;
import entidades.MateriaPrima_Marca;
import entidades.MateriaPrima_Marca_Proveedor;
import entidades.MateriaPrima_Proveedor;
import entidades.MovimientoCuenta;
import entidades.PrecioProducto;
import entidades.PrecioMateriaPrima;
import entidades.Producto;
import entidades.Producto_Venta;
import entidades.Proveedor;
import entidades.Provincia;
import entidades.RazonSocial;
import entidades.TelefonoCliente;
import entidades.TelefonoProveedor;
import entidades.TipoCliente;
import entidades.TipoDomicilio;
import entidades.TipoTelefono;
import entidades.TipoVenta;
import entidades.UnidaddeMedida;
import entidades.Venta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.JDBCConnectionException;

public class ConexionHibernate {

    /**
     * Añade todas las clases mapeadas a la sesion.
     * @return
     */
    public static Session tomarConexion() {
        try {

        } catch (JDBCConnectionException e) {
        }
        SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(Direccion_Cliente.class)
                .addAnnotatedClass(Direccion_Proveedor.class)
                .addAnnotatedClass(Iva.class)
                .addAnnotatedClass(Localidad.class)
                .addAnnotatedClass(PrecioProducto.class)
                .addAnnotatedClass(Producto.class)
                .addAnnotatedClass(Producto_Venta.class)
                .addAnnotatedClass(Provincia.class)
                .addAnnotatedClass(RazonSocial.class)
                .addAnnotatedClass(TelefonoCliente.class)
                .addAnnotatedClass(TelefonoProveedor.class)
                .addAnnotatedClass(TipoCliente.class)
                .addAnnotatedClass(TipoDomicilio.class)
                .addAnnotatedClass(TipoTelefono.class)
                .addAnnotatedClass(TipoVenta.class)
                .addAnnotatedClass(Venta.class)
                .addAnnotatedClass(MateriaPrima.class)
                .addAnnotatedClass(IngresoMateriaPrima.class)
                .addAnnotatedClass(Estado.class)
                .addAnnotatedClass(UnidaddeMedida.class)
                .addAnnotatedClass(Marca.class)
                .addAnnotatedClass(MateriaPrima_Marca.class)
                .addAnnotatedClass(MateriaPrima_Proveedor.class)
                .addAnnotatedClass(Proveedor.class)
                .addAnnotatedClass(MateriaPrima_Marca_Proveedor.class)
                .addAnnotatedClass(PrecioMateriaPrima.class)
                .addAnnotatedClass(MovimientoCuenta.class)
                .addAnnotatedClass(Cuenta.class)
                .addAnnotatedClass(Gasto.class)
                .addAnnotatedClass(CorteCaja.class)
                .buildSessionFactory();
        return sf.getCurrentSession();
    }

}
