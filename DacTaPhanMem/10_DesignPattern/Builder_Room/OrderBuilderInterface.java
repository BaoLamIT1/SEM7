public interface OrderBuilderInterface {
    OrderBuilderInterface setPaymentMethod(String paymentMethod);
    OrderBuilderInterface setDeliveryOption(String deliveryOption);
    OrderBuilderInterface setProductList(String productList);
    Order build();
}
