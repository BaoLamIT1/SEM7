import java.util.ArrayList;
import java.util.List;

public class AirportMediator implements Mediator {
    private List<Aircraft> aircrafts;
    private boolean runwayFree;
    public AirportMediator() {
        this.aircrafts = new ArrayList<>();
        this.runwayFree = true;  // Khởi đầu đường băng trống
    }
    @Override
    public void registerAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }
    @Override
    public void notifyAircraftToLand(Aircraft aircraft) {
        if (canLand(aircraft)) {
            System.out.println("Aircraft " + aircraft.getName() + " is landing.");
            runwayFree = false;  // Đường băng đang được sử dụng
        } else {
            System.out.println("Aircraft " + aircraft.getName() + " is waiting to land.");
        }
    }
    @Override
    public boolean canLand(Aircraft aircraft) {
        return runwayFree;
    }
    @Override
    public void aircraftLanded() {
        runwayFree = true;  // Đường băng lại trống
        System.out.println("Runway is now free.");
    }  
}
