package operacionesConfiguracion;

import escritorios.PrincipalConfiguracion;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import principal.Main;
import principal.PrincipalAdministrador;

/**
 *
 * @author FRANCO
 */
public class InterfacesGraficasConfiguracion {

    /**
     * Crea una nuea instancia para la clase PrincipalConfiguracion (intefaz
     * grafica).
     *
     * @param p
     */
    public void nuevaVentanaConfiguracion(PrincipalAdministrador p) {
        if (p.estacerrado(p.getConfiguracion())) {
            PrincipalConfiguracion c = new PrincipalConfiguracion();
            p.setConfiguracion(c);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) c.getUI()).getNorthPane();
            int width = p.getEscritorio().getWidth();
            int Height = p.getEscritorio().getHeight();
            p.getConfiguracion().remove(menupanel);
            p.getConfiguracion().setSize(width, Height);
            p.getEscritorio().add(p.getConfiguracion());
            p.getConfiguracion().show();
        }
        colorInterfazEscritorio(p);
        p.getConfiguracion().toFront();
    }

    /**
     * Crea una instancia de la clase InterfacesGraficasConfiguracion para
     * ejecutar el metodo nuevaVentanaConfiguracion necesario para generar una
     * nueva ventana de la clase Configuracion.
     */
    public static void ejecutarNuevaVentanaConfiguracion() {
        InterfacesGraficasConfiguracion i = new InterfacesGraficasConfiguracion();
        i.nuevaVentanaConfiguracion(Main.getPrincipalAdmin());
    }

    /**
     * Modifica el color de los elementos en la ventana PrincipalConfiguracion
     * segun el color de PrincipalAdministador panel.
     *
     * @param p
     */
    public void colorInterfazEscritorio(PrincipalAdministrador p) {
        p.getConfiguracion().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        // p.getConfiguracion().getBtnColorAzul().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        //p.getConfiguracion().getBtnColorMarron().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        //  p.getConfiguracion().getBtnColorRojo().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getConfiguracion().getBtnGuardar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getConfiguracion().getBtnPaleta().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

}
