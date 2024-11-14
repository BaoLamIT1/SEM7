public class VegetarianBurger implements Burger {
    @Override
    public String getDescription() {
        return "Vegetarian Burger (5.00)";
    }

    @Override
    public double getCost() {
        return 5.00;  // Giá của Vegetarian Burger
    }
}
