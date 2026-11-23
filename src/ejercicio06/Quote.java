package ejercicio06;

/**
 * Cotización inmutable que se envía a los paneles.
 * Contiene solo los datos primitivos necesarios para redibujar los componentes.
 */
public record Quote(String symbol, double price, double previousPrice, double changePercent) {
}
