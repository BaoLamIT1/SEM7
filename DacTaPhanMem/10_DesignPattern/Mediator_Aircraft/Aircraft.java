public class Aircraft {
    private String name;
    private Mediator mediator;

    public Aircraft(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.registerAircraft(this);
    }

    public String getName() {
        return name;
    }

    public void requestToLand() {
        System.out.println("Aircraft " + name + " is requesting to land.");
        mediator.notifyAircraftToLand(this);
    }

    public void land() {
        System.out.println("Aircraft " + name + " has landed.");
        mediator.aircraftLanded();  // Gọi phương thức này để thông báo đã hạ cánh
    }
}
