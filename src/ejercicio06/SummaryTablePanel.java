package ejercicio06;

/**
 * Panel de tabla de resumen con precio anterior, precio actual y variación.
 */
public class SummaryTablePanel implements QuoteObserver {

    @Override
    public void onQuoteUpdated(Quote quote) {
        System.out.println("Tabla de resumen: " + quote.symbol() + " | anterior " + String.format("%.2f", quote.previousPrice())
                + " | actual " + String.format("%.2f", quote.price())
                + " | variación " + String.format("%+.2f%%", quote.changePercent()));
    }
}
