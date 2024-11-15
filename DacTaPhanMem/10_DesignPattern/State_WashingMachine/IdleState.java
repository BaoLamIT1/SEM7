public class IdleState implements State {
    private Dishwasher machine;

    public IdleState(Dishwasher machine) {
        this.machine = machine;
    }

    @Override
    public void loadDishes() {
        System.out.println("Dishes loaded.");
        machine.setState(machine.getLoadedState());
    }

    @Override
    public void startWashing() {
        System.out.println("Cannot start washing. Load dishes first.");
    }

    @Override
    public void completeCycle() {
        System.out.println("No cycle to complete.");
    }

    @Override
    public void unloadDishes() {
        System.out.println("No dishes to unload.");
    }
}
