import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String productName;
    public Product(String productName) {this.productName = productName;}
    @Override
    public void addObserver(Observer observer) {observers.add(observer);}
    @Override
    public void removeObserver(Observer observer) {observers.remove(observer);}
    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);}
    }
    public void newProductArrived() {
        System.out.println("Product: " + productName + " is now available!");
        notifyObservers("New product available: " + productName);
    }
}
