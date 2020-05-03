package operacionesConfiguracion;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;
import principal.Main;

public class ConfiguracionTxt {

    ColorTema color = new ColorTema();

    public void setColor(Integer pr, Integer pg, Integer pb, Integer sr, Integer sg, Integer sb) {
        color.setPrincipalBlue(pb);
        color.setPrincipalGreen(pg);
        color.setPrincipalRed(pr);
        color.setSecundarioBlue(sb);
        color.setSecundarioGreen(sg);
        color.setSecundarioRed(sr);
        color.setColorPrimario(new Color(color.getPrincipalRed(), color.getPrincipalGreen(), color.getPrincipalBlue()));
        color.setColorSecundario(new Color(color.getSecundarioRed(), color.getSecundarioGreen(), color.getSecundarioBlue()));
    }

    public void setTema() {
        Main.getPrincipalAdmin().getPanel_1_primario().setBackground(color.getColorPrimario());
        Main.getPrincipalAdmin().getPanel_1_secundario().setBackground(color.getColorSecundario());
        Main.getPrincipalAdmin().getPanel_2_secundario().setBackground(color.getColorSecundario());
        Main.getPrincipalAdmin().getBtnConfiguracion().setBackground(color.getColorPrimario());
        Main.getPrincipalAdmin().getBtnGestionCliente().setBackground(color.getColorPrimario());
        Main.getPrincipalAdmin().getBtnGestionFinanzas().setBackground(color.getColorPrimario());
        Main.getPrincipalAdmin().getBtnGestionMateriPrima().setBackground(color.getColorPrimario());
        Main.getPrincipalAdmin().getBtnGestionPedidos().setBackground(color.getColorPrimario());
        Main.getPrincipalAdmin().getBtnGestionProducto().setBackground(color.getColorPrimario());
        Main.getPrincipalAdmin().getBtnGestionProveedor().setBackground(color.getColorPrimario());
        Main.getPrincipalAdmin().getBtnGestionGastos().setBackground(color.getColorPrimario());

    }

    public void leerArchivoConfig() {
        try {
            LinkedList valores = new LinkedList();
            Scanner input = new Scanner(new File("ConfiguracionColor.txt"));

            while (input.hasNextLine()) {
                valores.add(input.nextLine());
            }
            color.setPrincipalRed(Integer.valueOf(valores.get(0).toString()));
            color.setPrincipalGreen(Integer.valueOf(valores.get(1).toString()));
            color.setPrincipalBlue(Integer.valueOf(valores.get(2).toString()));
            color.setSecundarioRed(Integer.valueOf(valores.get(3).toString()));
            color.setSecundarioGreen(Integer.valueOf(valores.get(4).toString()));
            color.setSecundarioBlue(Integer.valueOf(valores.get(5).toString()));
            color.setColorPrimario(new Color(color.getPrincipalRed(), color.getPrincipalGreen(), color.getPrincipalBlue()));
            color.setColorSecundario(new Color(color.getSecundarioRed(), color.getSecundarioGreen(), color.getSecundarioBlue()));
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void guardarColor() {
        try {
            String ruta = "ConfiguracionColor.txt";
            String contenido = contenidoConfig();
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String contenidoConfig() {
        return color.getPrincipalRed() + "\n"
                + color.getPrincipalGreen() + "\n"
                + color.getPrincipalBlue() + "\n"
                + color.getSecundarioRed() + "\n"
                + color.getSecundarioGreen() + "\n"
                + color.getSecundarioBlue();
    }

}
