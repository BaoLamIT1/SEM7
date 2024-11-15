public class LoadedState implements State {
    private Dishwasher machine;

    public LoadedState(Dishwasher machine) {
        this.machine = machine;
    }

    @Override
    public void loadDishes() {
        System.out.println("Dishes are already loaded.");
    }

    @Override
    public void startWashing() {
        System.out.println("Starting the washing cycle.");
        machine.setState(machine.getWashingState());
    }

    @Override
    public void completeCycle() {
        System.out.println("Cannot complete cycle. Start washing first.");
    }

    @Override
    public void unloadDishes() {
        System.out.println("Cannot unload. The cycle is not completed.");
    }
}
