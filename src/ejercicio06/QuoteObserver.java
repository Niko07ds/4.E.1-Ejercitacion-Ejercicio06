package ejercicio06;

/**
 * Interfaz común de los paneles de visualización de los inversores.
 */
public interface QuoteObserver {

    void onQuoteUpdated(Quote quote);
}
