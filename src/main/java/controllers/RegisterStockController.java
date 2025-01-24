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
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StockService stockService = new StockService();

        List<Stock> stocks = stockService.listAllStocks();
        req.setAttribute("stocks", stocks);
        req.getRequestDispatcher("jsp/home.jsp").forward(req, resp);
    }

    private void addStock(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StockService stockService = new StockService();
            try{
                String symbol = req.getParameter("symbol");
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                double purchasePrice = Double.parseDouble(req.getParameter("purchasePrice"));
                Date purchaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("purchaseDate"));

                boolean stockSaved = stockService.save(symbol, quantity, purchaseDate, purchasePrice);

                if (stockSaved) {
                    req.setAttribute("messageControl", "La acción se registró correctamente.");
                } else {
                    req.setAttribute("messageControl", "Error al registrar la acción.");
                }
                req.getRequestDispatcher("/RegisterStockController?route=list").forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

    }
}
