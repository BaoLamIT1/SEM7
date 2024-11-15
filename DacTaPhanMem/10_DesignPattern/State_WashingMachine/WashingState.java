public class WashingState implements State {
    private Dishwasher machine;

    public WashingState(Dishwasher machine) {
        this.machine = machine;
    }

    @Override
    public void loadDishes() {
        System.out.println("Cannot load dishes. Washing in progress.");
    }

    @Override
    public void startWashing() {
        System.out.println("Washing is already in progress.");
    }

    @Override
    public void completeCycle() {
        System.out.println("Washing completed.");
        machine.setState(machine.getCompletedState());
    }

    @Override
    public void unloadDishes() {
        System.out.println("Cannot unload. Cycle is still in progress.");
    }
}
