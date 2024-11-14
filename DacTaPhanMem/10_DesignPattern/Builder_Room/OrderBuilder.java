public class OrderBuilder implements OrderBuilderInterface {
    private String orderId;
    private Customer customer; // Thêm thuộc tính khách hàng
    private String paymentMethod = "Pay Later";
    private String deliveryOption = "Standard Delivery";
    private String productList;

    public OrderBuilder(String orderId, Customer customer) { // Nhận đối tượng Customer
        this.orderId = orderId;
        this.customer = customer;
    }
    
    @Override
    public OrderBuilderInterface setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    @Override
    public OrderBuilderInterface setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
        return this;
    }

    @Override
    public OrderBuilderInterface setProductList(String productList) {
        this.productList = productList;
        return this;
    }

    @Override
    public Order build() {
        return new Order(this);
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getDeliveryOption() {
        return deliveryOption;
    }

    public String getProductList() {
        return productList;
    }
}
