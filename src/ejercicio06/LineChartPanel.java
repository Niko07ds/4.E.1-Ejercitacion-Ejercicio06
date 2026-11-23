package ejercicio06;

/**
 * Panel de gráfico de líneas: agrega un nuevo punto con cada cotización.
 */
public class LineChartPanel implements QuoteObserver {

    @Override
    public void onQuoteUpdated(Quote quote) {
        System.out.println("Gráfico de líneas: nuevo punto para " + quote.symbol() + " en " + String.format("%.2f", quote.price()));
    }
}
