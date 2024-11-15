public class ShippingService {
    private ShippingCostStrategy strategy;

    public ShippingService(ShippingCostStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ShippingCostStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateShippingCost(double weight, double distance) {
        return strategy.calculateCost(weight, distance);
    }
}
