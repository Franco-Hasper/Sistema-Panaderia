package principal;

import clasesUtilidadGeneral.ApiDolar;
import operacionesConfiguracion.ConfiguracionTxt;

/**
 *
 * @author TELCOM MPC
 */
public class Main {

    private static PrincipalAdministrador principal = new PrincipalAdministrador();

    public static PrincipalAdministrador getPrincipalAdmin() {
        return principal;
    }

    public static void setPrincipalAdmin(PrincipalAdministrador principal) {
        Main.principal = principal;
    }

    public static void main(String[] args) {
        exceptionNativa();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //PrincipalAdministrador principal = new PrincipalAdministrador();
                //setPrincipalAdmin(principal);
                principal.setVisible(true);
                ConfiguracionTxt configuracion = new ConfiguracionTxt();
                configuracion.leerArchivoConfig();
                configuracion.setTema();
                try {
                    ApiDolar.call_me();
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private static void exceptionNativa() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
