package reportesIreport;

import calsesPadre.Consultas;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import ds.desktop.notify.DesktopNotify;
import entidades.IngresoMateriaPrima;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import clasesUtilidadGeneral.OperacionesUtiles;

/**
 * @author FRANCO
 */
public class ReporteIngresoMateriaPrima extends Consultas {

    private static final Font titulofuente = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
    private static final Font datosfuente = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);

    /*----------*/
    public void ejecutarGenerarReporte(Date fechaRsDateChooser) throws FileNotFoundException, DocumentException {
        setConsultaList("from IngresoMateriaPrima");
        obtenerListaConsulta();
        int valorParaPruebas = (int) Math.floor(Math.random() * 600 + 1);
        generarReportePDF5(new File("reportes//ReporteIngresoMateriaPrima" + valorParaPruebas + ".pdf"), fechaRsDateChooser);
    }

    public void generarReportePDF5(File pdfNewFile, Date fechaRsDateChooser) {

        try {
            //al añadir un new Chapter se cambia a otra pagina
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
            document.open();
            //capitulo
            // Chapter chapterOne = new Chapter(0);
            Paragraph texto = new Paragraph();
            texto.setFont(titulofuente);
            texto.add("Reporte de Ingresos Sistema Panaderia");

            DottedLineSeparator dottedline = new DottedLineSeparator();
            dottedline.setOffset(-2);
            dottedline.setGap(2f);
            texto.add(dottedline);
            texto.setFont(datosfuente);
            texto.add("\n");
            texto.add("Detalles del reporte");
            texto.add("\n");

            Double importeTotal = 0.0;
            java.util.List lista = this.getListaResultados();

            PdfPTable table = new PdfPTable(4);
            PdfPCell columnHeader;

            columnHeader = new PdfPCell(new Phrase("Materia Prima"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Total Envases"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Unidades por Envase"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Total"));
            table.addCell(columnHeader);
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.setHeaderRows(1);

            OperacionesUtiles op = new OperacionesUtiles();

            for (Object o : lista) {
                IngresoMateriaPrima in = (IngresoMateriaPrima) o;
                String fecha = (String.valueOf(op.formatoFechaSinHora(in.getFecha())));
                String fechaRs = (String.valueOf(op.formatoFechaSinHora(fechaRsDateChooser)));
                Integer resutadoComparacion = (fecha.indexOf(fechaRs));

                if (in.getCodigoEstado().getIdEstado().equals(1) && (resutadoComparacion.equals(0))) {
                    table.addCell(in.getCodigoMateriaPrima().getNombre());
                    table.addCell(String.valueOf(in.getTotalEnvases()));
                    table.addCell(String.valueOf(in.getUdPorEnvase()));
                    table.addCell(String.valueOf(in.getPrecioTotal()));
                    importeTotal += in.getPrecioTotal();
                }

            }
            texto.add(table);
            texto.add(new Paragraph("\n"));
            texto.add("Importe Total: " + importeTotal);

            document.add(texto);

            document.close();
            DesktopNotify.showDesktopMessage("exito ", "   REPORTE GENERADO\n   CON EXITO", DesktopNotify.SUCCESS, 7000);
        } catch (FileNotFoundException | DocumentException e) {
            DesktopNotify.showDesktopMessage("error ", "    NO SE PUDO GENERAR\n    EL REPORTE", DesktopNotify.ERROR, 7000);
        }

    }

}
