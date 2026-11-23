package ejercicio06;

/**
 * Panel que se desvincula a sí mismo mientras se está enviando la cotización.
 * Sirve para demostrar que la lista de suscriptores es segura ante modificaciones concurrentes.
 */
public class TemporaryPanel implements QuoteObserver {

    private final Stock stock;

    public TemporaryPanel(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void onQuoteUpdated(Quote quote) {
        System.out.println("Panel temporal: recibió la cotización de " + quote.symbol() + " y se desvincula durante el envío");
        stock.removeObserver(this);
    }
}
