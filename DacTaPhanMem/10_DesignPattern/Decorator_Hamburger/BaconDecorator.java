public class BaconDecorator extends BurgerDecorator {
    public BaconDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Bacon (1.50)";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 1.50;  // Thêm 1.50 cho thịt xông khói
    }
}
