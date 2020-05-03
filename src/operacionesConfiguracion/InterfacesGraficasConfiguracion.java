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

    public static void ejecutarNuevaVentanaGasto() {
        InterfacesGraficasConfiguracion i = new InterfacesGraficasConfiguracion();
        i.nuevaVentanaConfiguracion(Main.getPrincipalAdmin());
    }

    public void colorInterfazEscritorio(PrincipalAdministrador p) {
        p.getConfiguracion().getPanel_1_primario().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        // p.getConfiguracion().getBtnColorAzul().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        //p.getConfiguracion().getBtnColorMarron().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        //  p.getConfiguracion().getBtnColorRojo().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getConfiguracion().getBtnGuardar().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
        p.getConfiguracion().getBtnPaleta().setBackground(Main.getPrincipalAdmin().getPanel_1_primario().getBackground());
    }

}
