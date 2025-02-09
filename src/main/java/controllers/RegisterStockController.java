package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entities.Stock;
import model.services.StockService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


import java.io.IOException;
import java.io.Serial;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/RegisterStockController")
public class RegisterStockController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.ruteador(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.ruteador(req, resp);
    }

    private void ruteador (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Control logic
        String route = (req.getParameter("route") == null) ? "list" : req.getParameter("route");

        switch (route) {
            case "list":
                this.list(req, resp);
                break;
            case "add":
                this.addStock(req, resp);
                break;
            case "chart":
                this.generateChart(req, resp);
                break;
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StockService stockService = new StockService();

        String sort = req.getParameter("sort");

        List<Stock> stocks;
        if ("name".equals(sort)) {
            stocks = stockService.getOrderedStocksByName(); // Ordenar por nombre
        } else if("unitGainAsc".equals(sort)){
            stocks = stockService.getOrderedStocksByUnitGainAsc();
            // Ordenar por ganancia unitaria ascendente
        } else if("unitGainDesc".equals(sort)){
            stocks = stockService.getOrderedStocksByUnitGainDesc(); // Ordenar por ganancia unitaria descendente
        } else {
            stocks = stockService.listAllStocks(); // Ordenar por defecto
        }

        req.setAttribute("stocks", stocks);
        req.setAttribute("sort", sort); // Pasar el valor seleccionado al JSP
        req.getRequestDispatcher("jsp/home.jsp").forward(req, resp);
    }


    private void addStock(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StockService stockService = new StockService();
            try{
                String symbol = req.getParameter("symbol");
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                double purchasePrice = Double.parseDouble(req.getParameter("purchasePrice"));
                Date purchaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("purchaseDate"));

                StringBuilder errorMessage = new StringBuilder();

                if (quantity <= 0) {
                    errorMessage.append("ℹ️ Quantity must be positive. <br>");
                }
                if (purchasePrice <= 0) {
                    errorMessage.append("ℹ️ Purchase price must be positive. <br>");
                }
                if (purchaseDate.after(new Date())) {
                    errorMessage.append("ℹ️ The purchase date must not exceed the current date. <br>");
                }

                if (errorMessage.length() > 0) { // Si hay algún error acumulado, se envía al usuario
                    req.setAttribute("messageControl", errorMessage.toString().trim());
                    req.getRequestDispatcher("/RegisterStockController?route=list").forward(req, resp);
                    return;
                }

                boolean stockSaved = stockService.save(symbol, quantity, purchaseDate, purchasePrice);

                if (stockSaved) {
                    req.setAttribute("messageControl", "✅ Stock added successfully!");
                    req.setAttribute("messageType", "success"); // Se establece el tipo de mensaje como "success"
                } else {
                    req.setAttribute("messageControl", "❌ An error occurred while registering the stock.");
                    req.setAttribute("messageType", "error"); // Se establece el tipo de mensaje como "error"
                }
                req.getRequestDispatcher("/RegisterStockController?route=list").forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

    }

    private void generateChart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StockService stockService = new StockService();
        List<Stock> stocks = stockService.listAllStocks();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Stock stock : stocks) {
            dataset.addValue(stock.getTotalGain(), "Total Gain (USD)", stock.getSymbol());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Stock Total Gain",
                "Stock Name",
                "Total Gain (USD)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        resp.setContentType("image/png");
        ChartUtils.writeChartAsPNG(resp.getOutputStream(), chart, 800, 600);
    }
}
