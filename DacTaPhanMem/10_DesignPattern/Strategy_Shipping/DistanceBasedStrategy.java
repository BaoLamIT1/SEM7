public class DistanceBasedStrategy implements ShippingCostStrategy {
    @Override
    public double calculateCost(double weight, double distance) {
        return distance * 0.5; 
    }
}
