public class CompletedState implements State {
    private Dishwasher machine;

    public CompletedState(Dishwasher machine) {
        this.machine = machine;
    }

    @Override
    public void loadDishes() {
        System.out.println("Cannot load dishes. Please unload first.");
    }

    @Override
    public void startWashing() {
        System.out.println("Cannot start washing. Please unload dishes first.");
    }

    @Override
    public void completeCycle() {
        System.out.println("Cycle is already completed.");
    }

    @Override
    public void unloadDishes() {
        System.out.println("Unloading dishes.");
        machine.setState(machine.getIdleState());
    }
}
