public class Main {
    public static void main(String[] args) {
        Product product = new Product("Laptop XYZ");

        // Tạo các Observer
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        Customer customer3 = new Customer("Charlie");

        // Đăng ký Observer vào Subject
        product.addObserver(customer1);
        product.addObserver(customer2);

        // Sản phẩm mới đến
        product.newProductArrived();

        System.out.println("\nCharlie cũng muốn nhận thông báo.");
        product.addObserver(customer3);

        // Lần thông báo thứ 2
        product.newProductArrived();

        System.out.println("\nBob không muốn nhận thông báo nữa.");
        product.removeObserver(customer2);

        // Lần thông báo thứ 3
        product.newProductArrived();
    }
}
