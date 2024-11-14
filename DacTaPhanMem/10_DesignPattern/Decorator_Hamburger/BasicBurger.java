public class BasicBurger implements Burger {
    @Override
    public String getDescription() {
        return "Basic Burger (5.00)";
    }

    @Override
    public double getCost() {
        return 5.00;  // Giá của burger cơ bản
    }
}
