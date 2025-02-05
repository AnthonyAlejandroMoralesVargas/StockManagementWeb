package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entities.Stock;
import model.services.StockService;


import java.io.IOException;
import java.io.Serial;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/StockConsolidationController")
public class StockConsolidationController extends HttpServlet {

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
        String route = (req.getParameter("route") == null) ? "enter" : req.getParameter("route");

        switch (route) {
            case "enter":
                this.enter(req, resp);
                break;
            case "view":
                this.viewConsolidation(req, resp);
                break;
        }
    }

    private void enter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StockService stockService = new StockService();
        List<String> symbols = stockService.getAllUniqueSymbols();
        req.setAttribute("symbols", symbols);
        req.getRequestDispatcher("jsp/stockConsolidation.jsp").forward(req, resp);
    }

    private void viewConsolidation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String symbol = req.getParameter("symbol");
        if (symbol == null) {
            resp.sendRedirect("StockConsolidationController?route=enter");
            return;
        }
        StockService stockService = new StockService();
        List<Stock> stocks = stockService.findStocksBySymbol(symbol);
        int totalQuantity = 0;
        double totalValue = 0;
        double totalGain = 0;
        double totalUnitCost = 0;
        for (Stock stock : stocks) {
            totalQuantity += stock.getQuantity();  // Sumar la cantidad de acciones
            totalValue += stock.getPurchasePrice() * stock.getQuantity();  // Sumar el valor total de las acciones
            totalGain += stock.getUnitGain() * stock.getQuantity();  // Sumar las ganancias totales

            // Sumar el precio costo
        }
        totalUnitCost = totalValue / totalQuantity;  // Precio costo promedio
        double unitPercentage = (totalGain / totalValue) * 100;  // Ganancia/pérdida en porcentaje

        // Pasar los valores calculados a la JSP
        req.setAttribute("stocks", stocks);
        req.setAttribute("symbol", symbol);
        req.setAttribute("totalQuantity", totalQuantity);
        req.setAttribute("totalValue", totalValue);
        req.setAttribute("totalUnitCost", totalUnitCost);
        req.setAttribute("unitPercentage", unitPercentage);
        req.setAttribute("totalGain", totalGain);
        req.getRequestDispatcher("StockConsolidationController?route=enter").forward(req, resp);
    }
}
