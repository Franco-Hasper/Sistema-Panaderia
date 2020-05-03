package operacionesProducto;

import conexion.ConexionHibernate;
import entidades.Estado;
import entidades.Iva;
import entidades.PrecioProducto;
import entidades.Producto;
import escritorios.PrincipalProducto;
import formularios.FormularioPrecioProducto;
import formularios.FormularioRegistrarProducto;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import clasesUtilidadGeneral.OperacionesUtiles;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author TELCOM MPC
 */
public class Otros {

    OperacionesUtiles o = new OperacionesUtiles();

    public void aplicarIvaPrecioProducto(FormularioPrecioProducto f) {

        Double precioBruto;
        Double iva;
        Double porcentage;
        Double precioFinal;

        Session miSesion = ConexionHibernate.tomarConexion();

        try {
            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 1);
            Iva i = (Iva) miSesion.createQuery("from Iva where codigoEstado= " + e.getIdEstado()).uniqueResult();

            if (f.getTxtPrecio().getText().length() == 0) {
                showMessageDialog(null, "Debe insertar un valor en el campo 'PRECIO BRUTO'");
                f.getRadioIva().setSelected(false);
            } else {
                precioBruto = Double.valueOf(f.getTxtPrecio().getText());
                iva = i.getPorcentaje();
                porcentage = precioBruto * iva;
                precioFinal = precioBruto + porcentage;
                f.getTxtPrecioFinal().setText(precioFinal.toString());
            }

            miSesion.getTransaction().commit();

        } catch (Exception e) {

        }

    }

    public void aplicarIvaProducto(FormularioRegistrarProducto f) {

        Double precioBruto;
        Double iva;
        Double porcentage;
        Double precioFinal;
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Estado e = (Estado) miSesion.get(Estado.class, 1);
            Iva i = (Iva) miSesion.createQuery("from Iva where codigoEstado= " + e.getIdEstado()).uniqueResult();
            if (f.getTxtPrecio().getText().length() == 0) {
                showMessageDialog(null, "Debe insertar un valor en el campo preciobBruto");
                f.getRadioIva().setSelected(false);
            } else {
                precioBruto = Double.valueOf(f.getTxtPrecio().getText());
                iva = i.getPorcentaje();
                porcentage = precioBruto * iva;
                precioFinal = precioBruto + porcentage;
                f.getTxtPrecioFinal().setText(precioFinal.toString());
            }
            miSesion.getTransaction().commit();

        } catch (Exception e) {

        }

    }

    public void graficarHistorialPrecios(PrincipalProducto pp) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            Integer idProducto = (Integer) pp.ObjetoTablaConDatos().getIdTabla();

            miSesion.beginTransaction();

            Producto prd = (Producto) miSesion.get(Producto.class, idProducto);

            List<PrecioProducto> precios = prd.getPrecios();

            for (PrecioProducto p : precios) {
                dataset.setValue(p.getPrecioTotal(), "", o.formatoFecha(p.getFecha()).toString());
            }
            miSesion.getTransaction().commit();
            JFreeChart chart = ChartFactory.createBarChart3D("Historial de Precios", "Fecha", "Precios", dataset, PlotOrientation.VERTICAL, true, true, false);
            ChartFrame frame = new ChartFrame("JFreeChart", chart);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
