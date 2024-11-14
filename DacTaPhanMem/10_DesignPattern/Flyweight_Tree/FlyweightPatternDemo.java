public class FlyweightPatternDemo {
    public static void main(String[] args) {
        Forest forest = new Forest();

    
        forest.plantTree(10, 20, "Oak", "Green", "Oak texture");
        forest.plantTree(50, 60, "Pine", "Dark Green", "Pine texture");
        forest.plantTree(20, 30, "Oak", "Green", "Oak texture");
        forest.plantTree(60, 80, "Pine", "Dark Green", "Pine texture");
        forest.plantTree(90, 100, "Cherry", "Pink", "Cherry texture");

        forest.draw();
    }
}
