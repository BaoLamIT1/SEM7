public class WeightBasedStrategy implements ShippingCostStrategy {
    @Override
    public double calculateCost(double weight, double distance) {
        return weight * 2.0; 
    }
}
