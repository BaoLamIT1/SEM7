public class CheeseDecorator extends BurgerDecorator {
    public CheeseDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Cheese (1.00)";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 1.00;  // Thêm 1.00 cho phô mai
    }
}
