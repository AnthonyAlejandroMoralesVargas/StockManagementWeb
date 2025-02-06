package model.utils;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import model.entities.Stock;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StockPDFGenerator {

    public static void generatePDF(OutputStream outputStream, String symbol, List<Stock> stocks) {
        try (PdfWriter writer = new PdfWriter(outputStream);
             PdfDocument pdf = new PdfDocument(writer);
             Document document = new Document(pdf)) {

            int totalQuantity = stocks.stream().mapToInt(Stock::getQuantity).sum();
            double totalValue = stocks.stream().mapToDouble(stock -> stock.getPurchasePrice() * stock.getQuantity()).sum();
            double totalUnitCost = totalValue / totalQuantity;
            double totalGain = stocks.stream().mapToDouble(Stock::getTotalGain).sum();
            double unitPercentage = (totalGain / totalValue) * 100;

            // Título
            document.add(new Paragraph("Stock Consolidation Report")
                    .setBold()
                    .setFontSize(20)
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER));

            // Subtítulo
            document.add(new Paragraph("Symbol: " + symbol)
                    .setBold()
                    .setFontSize(14)
                    .setMarginBottom(10));

            // Tabla de consolidación
            Table summaryTable = new Table(2).useAllAvailableWidth();
            summaryTable.addHeaderCell(new Cell().add(new Paragraph("Metric")).setBold().setBackgroundColor(ColorConstants.LIGHT_GRAY));
            summaryTable.addHeaderCell(new Cell().add(new Paragraph("Value")).setBold().setBackgroundColor(ColorConstants.LIGHT_GRAY));

            summaryTable.addCell(new Cell().add(new Paragraph("Total Quantity of Stocks Purchased")));
            summaryTable.addCell(new Cell().add(new Paragraph(String.valueOf(totalQuantity))).setTextAlignment(TextAlignment.RIGHT));

            summaryTable.addCell(new Cell().add(new Paragraph("Total Value of Stocks Purchased (USD)")));
            summaryTable.addCell(new Cell().add(new Paragraph(String.format("$%.2f", totalValue))).setTextAlignment(TextAlignment.RIGHT));

            summaryTable.addCell(new Cell().add(new Paragraph("Cost Price (USD)")));
            summaryTable.addCell(new Cell().add(new Paragraph(String.format("$%.2f", totalUnitCost))).setTextAlignment(TextAlignment.RIGHT));

            summaryTable.addCell(new Cell().add(new Paragraph("% Gain/Loss")));
            summaryTable.addCell(new Cell().add(new Paragraph(String.format("%.2f%%", unitPercentage))).setTextAlignment(TextAlignment.RIGHT));

            summaryTable.addCell(new Cell().add(new Paragraph("$ Gain/Loss")));
            summaryTable.addCell(new Cell().add(new Paragraph(String.format("$%.2f", totalGain))).setTextAlignment(TextAlignment.RIGHT));

            document.add(summaryTable.setMarginBottom(20));

            // Detalle de compras
            document.add(new Paragraph("Summary Purchases:")
                    .setBold()
                    .setFontSize(16)
                    .setMarginBottom(10));

            Table purchasesTable = new Table(5).useAllAvailableWidth();
            purchasesTable.addHeaderCell(new Cell().add(new Paragraph("Purchase Date")).setBold().setBackgroundColor(ColorConstants.LIGHT_GRAY));
            purchasesTable.addHeaderCell(new Cell().add(new Paragraph("Stock")).setBold().setBackgroundColor(ColorConstants.LIGHT_GRAY));
            purchasesTable.addHeaderCell(new Cell().add(new Paragraph("Purchase Price (USD)")).setBold().setBackgroundColor(ColorConstants.LIGHT_GRAY));
            purchasesTable.addHeaderCell(new Cell().add(new Paragraph("Quantity")).setBold().setBackgroundColor(ColorConstants.LIGHT_GRAY));
            purchasesTable.addHeaderCell(new Cell().add(new Paragraph("USD Purchase")).setBold().setBackgroundColor(ColorConstants.LIGHT_GRAY));

            for (Stock stock : stocks) {
                purchasesTable.addCell(new Cell().add(new Paragraph(new SimpleDateFormat("dd-MM-yyyy").format(stock.getPurchaseDate()))));
                purchasesTable.addCell(new Cell().add(new Paragraph(stock.getSymbol())));
                purchasesTable.addCell(new Cell().add(new Paragraph(String.format("$%.2f", stock.getPurchasePrice()))).setTextAlignment(TextAlignment.RIGHT));
                purchasesTable.addCell(new Cell().add(new Paragraph(String.valueOf(stock.getQuantity()))).setTextAlignment(TextAlignment.RIGHT));
                purchasesTable.addCell(new Cell().add(new Paragraph(String.format("$%.2f", stock.getPurchasePrice() * stock.getQuantity()))).setTextAlignment(TextAlignment.RIGHT));
            }

            document.add(purchasesTable);

            // Pie de página
            document.add(new Paragraph("\nGenerated on: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                    .setFontSize(10)
                    .setMarginTop(20)
                    .setTextAlignment(TextAlignment.CENTER));

        } catch (Exception e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }
}
