package clasesUtilidadGeneral;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class GraficaBarrasIngrMtPr {

    public static void main(String[] args) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.setValue(10, "", "A");
        dataset.setValue(11, "", "B");
        dataset.setValue(11, "", "h");
        dataset.setValue(11, "", "g");
        dataset.setValue(11, "", "h");
        dataset.setValue(101, "", "j");

        JFreeChart chart = ChartFactory.createBarChart("Calificaciones Java", "Estudiantes", "Promedios", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);
    }

    public void mostrarGrafica() {
        // Fuente de Datos
        int filaharina = 1;
        int totalharina = 1;
        int filaaceite = 1;
        int totalaceite = 1;
        String harina = "Harina";
        String aceite = "Aceite";

        //----------------------------aqui comienza la seccion con metodos de la grafica----------------------------------
        //setListarIndex es el vector que traje de la base de daos con los nombres de materia prima, se puede mejorar
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue(harina + "\n" + "Total a : " + totalharina, totalharina);
        data.setValue(aceite + "\n" + "Total envases : " + totalaceite, totalaceite);
        // System.out.println(tabla.getValueAt(0, 2).toString());
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart("Ejemplo Rapido de Grafico en un ChartFrame", data, true, false, false);
        // Mostrar Grafico
        ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);
    }

}
