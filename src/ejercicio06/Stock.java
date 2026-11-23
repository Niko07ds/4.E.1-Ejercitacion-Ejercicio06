package ejercicio06;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Activo financiero (sujeto observable).
 * La lista de suscriptores es segura ante modificaciones concurrentes:
 * un panel puede suscribirse o desvincularse mientras se envía una cotización.
 */
public class Stock {

    private final String symbol;
    private double price;
    private final CopyOnWriteArrayList<QuoteObserver> observers = new CopyOnWriteArrayList<>();

    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
    }

    public void addObserver(QuoteObserver observer) {
        if (observer != null) {
            observers.addIfAbsent(observer);
        }
    }

    public void removeObserver(QuoteObserver observer) {
        observers.remove(observer);
    }

    /**
     * Actualiza el precio, calcula la variación porcentual respecto al valor anterior
     * y envía la nueva cotización a todos los paneles suscritos.
     */
    public synchronized void updatePrice(double newPrice) {
        if (newPrice <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero");
        }
        double previousPrice = price;
        double changePercent = previousPrice == 0 ? 0 : (newPrice - previousPrice) / previousPrice * 100;
        price = newPrice;

        Quote quote = new Quote(symbol, newPrice, previousPrice, changePercent);
        for (QuoteObserver observer : observers) {
            observer.onQuoteUpdated(quote);
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}
