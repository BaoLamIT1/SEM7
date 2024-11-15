public class Main {
    public static void main(String[] args) {
        double weight = 10.0; // Trọng lượng 10 kg
        double distance = 100.0; // Khoảng cách 100 km
        // tính chi phí theo khoảng cách
        ShippingService shippingService = new ShippingService(new DistanceBasedStrategy());
        System.out.println("Cost using Distance-Based Strategy: " + 
            shippingService.calculateShippingCost(weight, distance));
        // tính chi phí theo trọng lượng
        shippingService.setStrategy(new WeightBasedStrategy());
        System.out.println("Cost using Weight-Based Strategy: " + 
            shippingService.calculateShippingCost(weight, distance));
        // tính chi phí theo tốc độ giao hàng
        shippingService.setStrategy(new SpeedBasedStrategy());
        System.out.println("Cost using Speed-Based Strategy: " + 
            shippingService.calculateShippingCost(weight, distance));
    }
}
