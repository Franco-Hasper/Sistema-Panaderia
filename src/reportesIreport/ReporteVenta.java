/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import entidades.PrecioProducto;
import entidades.Producto_Venta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import clasesUtilidadGeneral.OperacionesUtiles;
import principal.Main;

/**
 *
 * @author FRANCO
 */
public class ReporteVenta extends Consultas {

    OperacionesUtiles opu = new OperacionesUtiles();

    /*EJEMPLO VERSION 5*/
//    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
//    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
//    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
//    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
//    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static final Font titulofuente = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
    private static final Font datosfuente = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);

    /*----------*/
    public void ejecutarGenerarReporte() throws FileNotFoundException, DocumentException {
        setConsultaObject("from Producto_Venta where codigo_venta=" + Main.getPrincipalAdmin().getVentas().ObjetoTablaConDatos().getIdTabla().toString());
        obtenerObjetoConsulta();
        setConsultaList("from Producto_Venta where codigo_venta=" + Main.getPrincipalAdmin().getVentas().ObjetoTablaConDatos().getIdTabla().toString());
        obtenerListaConsulta();
        int valorParaPruebas = (int) Math.floor(Math.random() * 600 + 1);
        //V5        
        generarReportePDF5(new File("reportes//ReporteVenta" + valorParaPruebas + ".pdf"));
    }

    public void generarReportePDF5(File pdfNewFile) {

        try {

            //al añadir un new Chapter se cambia a otra pagina
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
            document.open();
            //capitulo
            // Chapter chapterOne = new Chapter(0);
            Paragraph texto = new Paragraph();
            texto.setFont(titulofuente);
            texto.add("Recibo Sistema Panaderia");

            DottedLineSeparator dottedline = new DottedLineSeparator();
            dottedline.setOffset(-2);
            dottedline.setGap(2f);
            texto.add(dottedline);
            texto.setFont(datosfuente);
            texto.add("\n");
            texto.add("Datos de Cliente");
            texto.add("\n");

            Object objeto = this.getObjetoResultado();
            Producto_Venta pro = (Producto_Venta) objeto;
            texto.add(new Paragraph("Cliente: " + pro.getCodigoVenta().getCodigoCliente().getNombre() + "  " + pro.getCodigoVenta().getCodigoCliente().getApellido()));
            texto.add(new Paragraph("Fecha: " + (opu.formatoFecha(pro.getCodigoVenta().getFechaHoraVenta()).toString())));

            texto.add(new Paragraph("\n"));

            Double resultado;
            java.util.List lista = this.getListaResultados();

            PdfPTable table = new PdfPTable(3);
            PdfPCell columnHeader;

            columnHeader = new PdfPCell(new Phrase("Nombre"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Total Unidades"));
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("Total"));
            table.addCell(columnHeader);
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.setHeaderRows(1);

            for (Object o : lista) {
                Producto_Venta pr = (Producto_Venta) o;
                table.addCell(pr.getCodigoProducto().getNombre().toString());
                table.addCell(pr.getTotalUnidades().toString());
                java.util.List<PrecioProducto> precios = pr.getCodigoProducto().getPrecios();
                for (PrecioProducto pre : precios) {
                    if (pre.getCodigoEstado().getIdEstado().equals(1)) {
                        resultado = (pr.getTotalUnidades() * pre.getPrecioTotal());
                        table.addCell("$ " + (Double.toString(resultado)));

                    }
                }

            }
            texto.add(table);
            texto.add(new Paragraph("\n"));
            texto.add("Importe Total: " + pro.getCodigoVenta().getPrecioTotal().toString());
            document.add(texto);
            document.close();
            DesktopNotify.showDesktopMessage("exito ", "   RECIBO GENERADO\n   CON EXITO", DesktopNotify.SUCCESS, 7000);
        } catch (FileNotFoundException | DocumentException e) {
            DesktopNotify.showDesktopMessage("error ", "    NO SE PUDO GENERAR\n    EL RECIBO", DesktopNotify.ERROR, 7000);
        }

    }

}
