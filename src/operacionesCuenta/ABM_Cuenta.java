package operacionesCuenta;

import calsesPadre.Consultas;
import conexion.ConexionHibernate;
import ds.desktop.notify.DesktopNotify;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.MovimientoCuenta;
import escritorios.PrincipalCuenta;
import formularios.FormularioEditarMovimeinto;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;
import clasesUtilidadGeneral.OperacionesUtiles;
import org.hibernate.Session;
import principal.Main;

/**
 *
 * @author Hasper Franco
 */
public class ABM_Cuenta extends Consultas {

    TablaCuenta tabla = new TablaCuenta();
    InterfacesGraficasCuenta i = new InterfacesGraficasCuenta();
    OperacionesUtiles opu = new OperacionesUtiles();

    /**
     * Verifica que los campos de texto contengan caracteres y ejecuta
     * transaccionRegistrarmovimientocuenta.
     *
     * @param p
     */
    public void ejecutarRegistrarMovimientoCuenta(PrincipalCuenta p) {
        if (p.getTxtMonto().getText().length() == 0 || p.getEditPaneMotivo().getText().length() == 0) {
            showMessageDialog(null, "Debe ingresar un monto y un motivo");
        } else {
            transaccionRegistrarMovimientoCuenta(p);
        }
    }

    /**
     * Ejeuta los metodos necesarios para eliminar un movineto de cueta
     * especificado de la base de datos.
     *
     * @return
     */
    public boolean ejecutarEliminarMovimiento() {
        String idCuenta = Main.getPrincipalAdmin().getCuenta().getBoxCuenta().getSelectedItem().toString();
        setConsultaList("from MovimientoCuenta where codigo_cuenta=" + idCuenta);
        obtenerListaConsulta();
        transaccionEliminarMovimiento();
        return true;
    }

    /**
     * Realiza una consulta de MovimientoCuenta en la bd dependiendo de el box
     * seleccionado en la interfaz grafica, el box contiene una id que indica a
     * que mc hace referncia, luego ejecuta el metodo
     * actualizarBalanceMovimientoCuentaPortDelOrEdit.
     *
     * @param p
     */
    public void ejecutarActualizarMovCuenta(PrincipalCuenta p) {
        String idCuenta = Main.getPrincipalAdmin().getCuenta().getBoxCuenta().getSelectedItem().toString();
        setConsultaList("from MovimientoCuenta where codigo_cuenta=" + idCuenta);
        obtenerListaConsulta();
        actualizarBalanceMovimientoCuentaPortDelOrEdit(p);
    }

    /**
     * Ejeuta los metodos necesarios para poder editar un movimiento de cuenta
     * especificado en la base de datos.
     *
     * @param f
     * @return
     */
    public boolean ejecutarEditarMovCuenta(FormularioEditarMovimeinto f) {
        if (opu.verificarCamposTextoVacios(f.getListaCampos())) {
            String idCuenta = Main.getPrincipalAdmin().getCuenta().getBoxCuenta().getSelectedItem().toString();
            setConsultaList("from MovimientoCuenta where codigo_cuenta=" + idCuenta);
            obtenerListaConsulta();
            transaccionEditarMovimiento(f);
            f.dispose();
            return true;
        }
        return false;
    }

    /**
     * Permite actualizar los datos de un movimiento cuenta especificado en la
     * base de datos.
     *
     * @param f
     */
    public void transaccionEditarMovimiento(FormularioEditarMovimeinto f) {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            String idMovCuenta = null;
            int fila = Main.getPrincipalAdmin().getCuenta().getTabla().getSelectedRow();
            String monto = Main.getPrincipalAdmin().getCuenta().getTabla().getValueAt(fila, 1).toString();
            String motivo = Main.getPrincipalAdmin().getCuenta().getTabla().getValueAt(fila, 0).toString();
            String balance = Main.getPrincipalAdmin().getCuenta().getTabla().getValueAt(fila, 2).toString();
            String fecha = Main.getPrincipalAdmin().getCuenta().getTabla().getValueAt(fila, 3).toString();
            miSesion.beginTransaction();

            List lista = this.getListaResultados();
            for (Object o : lista) {
                MovimientoCuenta movimiento = (MovimientoCuenta) o;

                if (movimiento.getMonto().toString().equals(monto) && movimiento.getMotivo().toString().equals(motivo)
                        && movimiento.getBalance().toString().equals(balance) && (opu.formatoFecha(movimiento.getFecha())).equals(fecha)) {

                    idMovCuenta = movimiento.getIdMovimientoCuenta().toString();
                }
            }

            MovimientoCuenta mc = (MovimientoCuenta) miSesion.get(MovimientoCuenta.class, Integer.parseInt(idMovCuenta));

            if (mc.getMotivo().equals("Monto Inicial")) {
                mc.setMonto(Double.valueOf(f.getTxtMonto().getText()));
                mc.setBalance(Double.valueOf(f.getTxtMonto().getText()));
            } else {
                mc.setMotivo(f.getTxtMotivo().getText());
                mc.setMonto(Double.valueOf(f.getTxtMonto().getText()));
            }

            miSesion.saveOrUpdate(mc);

            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro editado con exito");

        } catch (Exception ex) {
            showMessageDialog(null, "Error al Intentar eliminar registro");
        }

    }

    /**
     * Prmite actualizar los datos de todos los movimientos de una cuenta luego
     * de que se realize la edicion de un movimiento.
     *
     * @param p
     */
    private void actualizarBalanceMovimientoCuentaPortDelOrEdit(PrincipalCuenta p) {

        String idMovCuenta;
        Double monto;
        Double balance;
        try {
            List lista = this.getListaResultados();
            for (Object o : lista) {
                MovimientoCuenta resultsMC = (MovimientoCuenta) o;

                idMovCuenta = resultsMC.getIdMovimientoCuenta().toString();
                monto = resultsMC.getMonto();
                balance = resultsMC.getBalance();
                Session miSesion = ConexionHibernate.tomarConexion();

                miSesion.beginTransaction();
                MovimientoCuenta actualizarMC = (MovimientoCuenta) miSesion.get(MovimientoCuenta.class, Integer.parseInt(idMovCuenta));

                Cuenta cnt = (Cuenta) miSesion.get(Cuenta.class, resultsMC.getCodigoCuenta().getIdCuenta());

                if (resultsMC.getMotivo().equals("Monto Inicial")) {
                    actualizarMC.setMonto(monto);
                    actualizarMC.setBalance(balance);
                    cnt.setBalance(balance);
                } else {
                    Double nuevoBalance = (cnt.getBalance() + (monto));
                    actualizarMC.setMonto(monto);
                    actualizarMC.setBalance(nuevoBalance);
                    cnt.setBalance(nuevoBalance);
                }

                miSesion.saveOrUpdate(actualizarMC);
                miSesion.saveOrUpdate(cnt);
                miSesion.getTransaction().commit();
            }
            DesktopNotify.showDesktopMessage("   informacion", "TODOS LOS REGISTROS\nFURON ACTUAZADOS", DesktopNotify.INFORMATION, 7000);

        } catch (Exception e) {
            e.printStackTrace();
            DesktopNotify.showDesktopMessage("   error", "ERROR AL INTENTAR\nACTUALIZAR REGISTRO", DesktopNotify.ERROR, 7000);

        }

    }

    /**
     * Verifica que todos los campos obligatorios hayan sido completados y
     * ejecuta el metodo transaccionRegistrarCuenta, a continuacio ejecuta
     * transaccionRegistrarMovimientoCuenta.
     *
     * @param p
     */
    public void ejecutarRegistrarCuenta(PrincipalCuenta p) {
        if (p.getTxtMontoInicial().getText().length() == 0) {
            showMessageDialog(null, "Debe ingresar un monto inicial");
        } else {
            transaccionRegistrarCuenta(p);
            Main.getPrincipalAdmin().getCuenta().getBoxCuenta().removeAllItems();
            String idCliente = Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla().toString();
            i.rellenarBoxCuenta(idCliente);
            p.getBoxCuenta().setSelectedIndex(p.getBoxCuenta().getItemCount() - 1);
            transaccionRegistrarMovimientoCuenta(p);
        }
    }

    /**
     * Permite registrar una nueva cuenta en la base de datos.
     *
     * @param p
     */
    public void transaccionRegistrarCuenta(PrincipalCuenta p) {
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Cliente cl = (Cliente) miSesion.get(Cliente.class, Main.getPrincipalAdmin().getCliente().ObjetoTablaConDatos().getIdTabla());
            Cuenta c = new Cuenta();
            c.setBalance(Double.valueOf(p.getTxtMontoInicial().getText()));
            c.setCodigoCliente(cl);
            miSesion.save(c);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Cuenta creada con exito");
        } catch (Exception e) {
            e.printStackTrace();
            showMessageDialog(null, "Error al intentar crear cuenta");
        }
    }

    /**
     * Permite registrar un nuevo movimiento de cuenta en la base de datos.
     *
     * @param p
     */
    public void transaccionRegistrarMovimientoCuenta(PrincipalCuenta p) {
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();

            MovimientoCuenta mc = new MovimientoCuenta();

            switch (p.getOcacion()) {
                case "depositoInicial":
                    mc.setMotivo("Monto Inicial");
                    mc.setMonto(Double.valueOf(p.getTxtMontoInicial().getText()));
                    break;
                case "movimiento":
                    mc.setMotivo(p.getEditPaneMotivo().getText());
                    mc.setMonto(Double.valueOf(p.getTxtMonto().getText()));
                    break;
            }

            Cuenta cnt = (Cuenta) miSesion.get(Cuenta.class, Integer.valueOf(p.getBoxCuenta().getSelectedItem().toString()));

            switch (p.getOcacion()) {
                case "depositoInicial":
                    mc.setMotivo("Monto Inicial");
                    mc.setMonto(Double.valueOf(p.getTxtMontoInicial().getText()));
                    mc.setBalance(Double.valueOf(p.getTxtMontoInicial().getText()));
                    mc.setCodigoCuenta(cnt);
                    break;
                case "movimiento":
                    Double nuevoBalance = (cnt.getBalance() + (Double.valueOf(p.getTxtMonto().getText())));
                    mc.setBalance(nuevoBalance);
                    mc.setCodigoCuenta(cnt);
                    cnt.setBalance(nuevoBalance);
                    break;
            }

            miSesion.save(mc);
            miSesion.saveOrUpdate(cnt);

            miSesion.getTransaction().commit();
            showMessageDialog(null, "Movimiento registrado con exito");
            tabla.ejecutarRellenarTablaCuenta(p);
        } catch (Exception e) {
            showMessageDialog(null, "Error al intentar registrar movimiento");
        }
    }

    /**
     * Elimina de forma definitiva un movimiento en la base de datos.
     */
    public void transaccionEliminarMovimiento() {

        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            String idMovCuenta = null;
            int fila = Main.getPrincipalAdmin().getCuenta().getTabla().getSelectedRow();
            String monto = Main.getPrincipalAdmin().getCuenta().getTabla().getValueAt(fila, 1).toString();
            String motivo = Main.getPrincipalAdmin().getCuenta().getTabla().getValueAt(fila, 0).toString();
            String balance = Main.getPrincipalAdmin().getCuenta().getTabla().getValueAt(fila, 2).toString();
            String fecha = Main.getPrincipalAdmin().getCuenta().getTabla().getValueAt(fila, 3).toString();
            miSesion.beginTransaction();

            List lista = this.getListaResultados();
            for (Object o : lista) {
                MovimientoCuenta movimiento = (MovimientoCuenta) o;

                if (movimiento.getMonto().toString().equals(monto) && movimiento.getMotivo().toString().equals(motivo)
                        && movimiento.getBalance().toString().equals(balance) && (opu.formatoFecha(movimiento.getFecha())).equals(fecha)) {

                    idMovCuenta = movimiento.getIdMovimientoCuenta().toString();
                }
            }

            MovimientoCuenta mc = (MovimientoCuenta) miSesion.get(MovimientoCuenta.class, Integer.parseInt(idMovCuenta));
            miSesion.delete(mc);
            miSesion.getTransaction().commit();
            showMessageDialog(null, "Registro eliminado con exito");

        } catch (Exception ex) {
            showMessageDialog(null, "Error al Intentar eliminar registro");
        }

    }

}
