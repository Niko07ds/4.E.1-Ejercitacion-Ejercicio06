package ejercicio06;

public class Main {

    public static void main(String[] args) {
        Stock stock = new Stock("ACME", 100.00);

        QuoteObserver chart = new LineChartPanel();
        QuoteObserver table = new SummaryTablePanel();
        QuoteObserver alerts = new VolatilityAlertPanel(5.0);
        QuoteObserver temporary = new TemporaryPanel(stock);

        System.out.println("Suscribiendo los paneles al activo " + stock.getSymbol() + " (precio inicial 100.00)");
        stock.addObserver(chart);
        stock.addObserver(table);
        stock.addObserver(alerts);
        stock.addObserver(temporary);

        System.out.println();
        System.out.println("Nueva cotización: 102.50");
        stock.updatePrice(102.50);

        System.out.println();
        System.out.println("Nueva cotización: 110.00");
        stock.updatePrice(110.00);

        System.out.println();
        System.out.println("Se desvincula el gráfico de líneas");
        stock.removeObserver(chart);

        System.out.println();
        System.out.println("Nueva cotización: 99.00");
        stock.updatePrice(99.00);
    }
}
