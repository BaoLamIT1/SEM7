public class LettuceDecorator extends BurgerDecorator {
    public LettuceDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Lettuce (0.50)";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 0.50;  // Thêm 0.50 cho xà lách
    }
}
