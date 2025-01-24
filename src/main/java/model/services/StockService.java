package model.services;

import model.dao.StockDAO;
import model.entities.Stock;
import model.api.AlphaVantageAPI;

import java.util.Date;
import java.util.List;

public class StockService {

    private StockDAO stockDAO;
    private AlphaVantageAPI alphaVantageAPI;

    public StockService() {
        this.stockDAO = new StockDAO();
        this.alphaVantageAPI = new AlphaVantageAPI();
    }

    public StockService(StockDAO stockDAO, String apiKey) {
        this.stockDAO = stockDAO;
        this.alphaVantageAPI = new AlphaVantageAPI(apiKey);
    }


    public boolean save(String symbol, int quantity, Date purchaseDate, double purchasePrice) {
        double currentPrice = alphaVantageAPI.getCurrentPrice(symbol);

        if (currentPrice != -1) {

            double unitGain = currentPrice - purchasePrice;
            double unitPercentage = (unitGain / purchasePrice) * 100;
            double totalBalance = currentPrice * quantity;
            double totalGain = unitGain * quantity;


            Stock stock = new Stock(symbol, currentPrice, quantity, purchaseDate, purchasePrice,
                    unitGain, unitPercentage, totalBalance, totalGain);
            stock.setCurrentDate(new Date());

            if(stockDAO.create(stock)){
                return true;
            } else {
                return false;
            }

        } else {
           return false;
        }
    }

    public Stock findStock(String symbol) {
        return stockDAO.findBySymbol(symbol);
    }

    public List<Stock> listAllStocks() {
        return stockDAO.findAll();
    }
    
    public void deleteStock(String symbol) {
        stockDAO.deleteBySymbol(symbol);
    }
}
