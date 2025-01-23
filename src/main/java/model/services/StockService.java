package model.services;

import model.dao.StockDAO;
import model.entities.Stock;
import model.entities.AlphaVantageAPI;

import java.util.Date;
import java.util.List;

public class StockService {

    private StockDAO stockDAO;
    private AlphaVantageAPI alphaVantageAPI;

    // Constructor vacío
    public StockService() {
        this.stockDAO = new StockDAO();
        this.alphaVantageAPI = new AlphaVantageAPI();
    }
    // Constructor con DAO y clave de API
    public StockService(StockDAO stockDAO, String apiKey) {
        this.stockDAO = stockDAO;
        this.alphaVantageAPI = new AlphaVantageAPI(apiKey);
    }

    // Registrar o actualizar una acción
    public void registerOrUpdateStock(String symbol, int quantity, Date purchaseDate, double purchasePrice) {
        double currentPrice = alphaVantageAPI.getCurrentPrice(symbol);

        if (currentPrice != -1) {
            // Calcular valores derivados
            double unitGain = currentPrice - purchasePrice;
            double unitPercentage = (unitGain / purchasePrice) * 100;
            double totalBalance = currentPrice * quantity;
            double totalGain = unitGain * quantity;

            // Crear o actualizar la entidad Stock
            Stock stock = new Stock(symbol, currentPrice, quantity, purchaseDate, purchasePrice,
                    unitGain, unitPercentage, totalBalance, totalGain);
            stock.setCurrentDate(new Date());
            // Guardar en la base de datos
            stockDAO.saveOrUpdate(stock);
        } else {
            throw new RuntimeException("Error al obtener el precio actual desde la API.");
        }
    }

    // Buscar una acción por su símbolo
    public Stock findStock(String symbol) {
        return stockDAO.findBySymbol(symbol);
    }

    // Listar todas las acciones
    public List<Stock> listAllStocks() {
        return stockDAO.findAll();
    }

    // Eliminar una acción por su símbolo
    public void deleteStock(String symbol) {
        stockDAO.deleteBySymbol(symbol);
    }
}
