public class MediatorDemo {
    public static void main(String[] args) {
        Mediator airportMediator = new AirportMediator();
        Aircraft aircraft1 = new Aircraft("Flight 101", airportMediator);
        Aircraft aircraft2 = new Aircraft("Flight 202", airportMediator);
        // Máy bay đầu tiên yêu cầu hạ cánh
        aircraft1.requestToLand();
        aircraft1.land();
        // Máy bay thứ hai yêu cầu hạ cánh khi đường băng đã trống
        aircraft2.requestToLand();
        aircraft2.land();
    }
}
