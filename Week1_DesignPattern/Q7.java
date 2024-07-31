import java.util.ArrayList;
import java.util.List;

public interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}


public class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}
public interface Observer {
    void update(String stockName, double stockPrice);
}
public class MobileApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Mobile App: The price of " + stockName + " is now $" + stockPrice);
    }
}

public class WebApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Web App: The price of " + stockName + " is now $" + stockPrice);
    }
}
public class ObserverPatternTest {
    public static void main(String[] args) {
        // Create a StockMarket object
        StockMarket stockMarket = new StockMarket("AAPL", 150.00);

        // Create observers
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers with the StockMarket
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Update stock price and notify observers
        stockMarket.setStockPrice(155.00);
        stockMarket.setStockPrice(160.00);

        // Deregister one observer and update stock price again
        stockMarket.deregisterObserver(webApp);
        stockMarket.setStockPrice(165.00);
    }
}
