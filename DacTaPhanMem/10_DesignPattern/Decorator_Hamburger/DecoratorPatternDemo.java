public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Basic Burger        
        Burger burger = new BasicBurger();
        burger = new CheeseDecorator(burger);
        burger = new LettuceDecorator(burger);
        burger = new BaconDecorator(burger);

        System.out.println("Description: " + burger.getDescription());
        System.out.println("Total Cost: $" + burger.getCost());
        
        // Vegetarian Burger 
        Burger vegBurger = new VegetarianBurger();
        vegBurger = new CheeseDecorator(vegBurger);
        vegBurger = new LettuceDecorator(vegBurger);

        System.out.println("Description: " + vegBurger.getDescription());
        System.out.println("Total Cost: $" + vegBurger.getCost());

        // Special Burger 
        Burger specialBurger = new SpecialBurger();
        specialBurger = new SpecialBaconDecorator(specialBurger);
        specialBurger = new CheeseDecorator(specialBurger);
        specialBurger = new LettuceDecorator(specialBurger);

        System.out.println("Description: " + specialBurger.getDescription());
        System.out.println("Total Cost: $" + specialBurger.getCost());
    }
}
