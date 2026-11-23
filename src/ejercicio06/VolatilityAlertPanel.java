package ejercicio06;

/**
 * Panel de alertas de volatilidad: solo reacciona cuando la variación supera un porcentaje límite.
 */
public class VolatilityAlertPanel implements QuoteObserver {

    private final double thresholdPercent;

    public VolatilityAlertPanel(double thresholdPercent) {
        this.thresholdPercent = thresholdPercent;
    }

    @Override
    public void onQuoteUpdated(Quote quote) {
        if (Math.abs(quote.changePercent()) >= thresholdPercent) {
            System.out.println("Alerta de volatilidad: " + quote.symbol() + " varió " + String.format("%+.2f%%", quote.changePercent())
                    + ", supera el límite de " + String.format("%.1f%%", thresholdPercent));
        }
    }
}
