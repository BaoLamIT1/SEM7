public interface Mediator {
    void registerAircraft(Aircraft aircraft);
    
    void notifyAircraftToLand(Aircraft aircraft);
    
    boolean canLand(Aircraft aircraft);
    
    void aircraftLanded(); 
    
}
