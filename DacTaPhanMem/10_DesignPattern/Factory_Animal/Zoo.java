public class Zoo {
    public static void main(String[] args) {

        Animal lion = AnimalFactory.getAnimal("lion");
        lion.makeSound();

        Animal tiger = AnimalFactory.getAnimal("tiger");
        tiger.makeSound();

        Animal wolf = AnimalFactory.getAnimal("wolf");
        wolf.makeSound();
        
       // Animal cat = AnimalFactory.getAnimal("meoww");
       // cat.makeSound();

        try {
            Animal unknown = AnimalFactory.getAnimal("dog");
            unknown.makeSound();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
