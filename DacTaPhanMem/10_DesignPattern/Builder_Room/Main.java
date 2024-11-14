public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("CUST001", "Alice", "alice@example.com", "123456789");
        Customer customer2 = new Customer("CUST002", "Bob", "bob@example.com", "987654321");

        Order order1 = new OrderBuilder("ORD001", customer1)
                .setPaymentMethod("Credit Card")
                .setDeliveryOption("Express Delivery")
                .setProductList("Laptop, Mouse")
                .build();

        Order order2 = new OrderBuilder("ORD002", customer2)
                .setProductList("Smartphone, Headphones")
                .build();

        System.out.println("Order 1:");
        order1.displayOrder();
        System.out.println();

        System.out.println("Order 2:");
        order2.displayOrder();
    }
}
