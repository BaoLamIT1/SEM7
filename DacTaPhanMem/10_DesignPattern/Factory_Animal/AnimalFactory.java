public class AnimalFactory {
    public static Animal getAnimal(String type) {
        switch (type.toLowerCase()) {
            case "lion":
                return new Lion();
            case "tiger":
                return new Tiger();
            case "wolf":
                return new Wolf();
            default:
                throw new IllegalArgumentException("Animal type not found: " + type);
        }
    }
}
