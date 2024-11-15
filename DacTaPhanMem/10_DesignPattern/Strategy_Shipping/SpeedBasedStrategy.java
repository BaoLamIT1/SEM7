public class SpeedBasedStrategy implements ShippingCostStrategy {
    @Override
    public double calculateCost(double weight, double distance) {
        return 50 + distance * 0.7; // Phí cố định + 0.7 đơn vị tiền mỗi km
    }
}
