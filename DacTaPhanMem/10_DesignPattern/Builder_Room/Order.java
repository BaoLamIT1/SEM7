public class Order {
    private final String orderId;
    private final Customer customer; // Thông tin khách hàng
    private final String paymentMethod;
    private final String deliveryOption;
    private final String productList;

    public Order(OrderBuilder builder) {
        this.orderId = builder.getOrderId();
        this.customer = builder.getCustomer();
        this.paymentMethod = builder.getPaymentMethod();
        this.deliveryOption = builder.getDeliveryOption();
        this.productList = builder.getProductList();
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Info:");
        customer.displayCustomerInfo();
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Delivery Option: " + deliveryOption);
        System.out.println("Product List: " + productList);
    }
}
