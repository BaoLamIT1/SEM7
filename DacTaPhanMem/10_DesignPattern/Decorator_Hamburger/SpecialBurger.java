public class SpecialBurger implements Burger {
    @Override
    public String getDescription() {
        return "Special Burger (7.00)";
    }

    @Override
    public double getCost() {
        return 7.00;  // Giá của Special Burger
    }
}
