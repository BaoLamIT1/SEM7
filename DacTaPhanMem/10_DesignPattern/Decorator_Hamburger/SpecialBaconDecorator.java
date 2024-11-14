public class SpecialBaconDecorator extends BurgerDecorator {
    public SpecialBaconDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", SpecialBacon (2.50)";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 2.50; 
    }
}
