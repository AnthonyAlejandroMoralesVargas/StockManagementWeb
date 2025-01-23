package model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;

import java.util.Date;

@Entity
public class Stock {

    @Id
    private String symbol;  // Símbolo de la acción (e.g., AAPL)

    @Column(name = "current_price")
    private double currentPrice;  // Precio actual de la acción

    @Column(name = "quantity")
    private int quantity;  // Cantidad de acciones compradas

    @Column(name = "purchase_date")
    private Date purchaseDate;  // Fecha de compra

    @Column(name = "purchase_price")
    private double purchasePrice;  // Precio de compra de la acción

    @Column(name = "unit_gain")
    private double unitGain;  // Ganancia por acción (USD)

    @Column(name = "unit_percentage")
    private double unitPercentage;  // Porcentaje de ganancia/pérdida

    @Column(name = "total_balance")
    private double totalBalance;  // Balance total (USD)

    @Column(name = "total_gain")
    private double totalGain;  // Ganancia total (USD)

    @Column(name = "current_date_stock")
    private Date currentDate;

    public Stock() {}

    // Constructor con parámetros
    public Stock(String symbol, double currentPrice, int quantity, Date purchaseDate, double purchasePrice,
                 double unitGain, double unitPercentage, double totalBalance, double totalGain) {
        this.symbol = symbol;
        this.currentPrice = currentPrice;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.unitGain = unitGain;
        this.unitPercentage = unitPercentage;
        this.totalBalance = totalBalance;
        this.totalGain = totalGain;
        this.currentDate = new Date();
    }

    // Getters y Setters
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getUnitGain() {
        return unitGain;
    }

    public void setUnitGain(double unitGain) {
        this.unitGain = unitGain;
    }

    public double getUnitPercentage() {
        return unitPercentage;
    }

    public void setUnitPercentage(double unitPercentage) {
        this.unitPercentage = unitPercentage;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public double getTotalGain() {
        return totalGain;
    }

    public void setTotalGain(double totalGain) {
        this.totalGain = totalGain;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}