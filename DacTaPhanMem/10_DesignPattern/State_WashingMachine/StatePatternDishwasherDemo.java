public class StatePatternDishwasherDemo {
    public static void main(String[] args) {
        Dishwasher dishwasher = new Dishwasher();

        dishwasher.startWashing();   
        dishwasher.loadDishes();     
        dishwasher.startWashing();   
        dishwasher.completeCycle();  
        dishwasher.unloadDishes();  
    }
}
