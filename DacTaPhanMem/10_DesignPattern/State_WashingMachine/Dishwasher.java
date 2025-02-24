public class Dishwasher {
    private State idleState; //nạp chén đĩa (loadDishes()),sau đó chuyển sang trạng thái LoadedState
    private State loadedState;//bắt đầu rửa (startWashing()),sau đó chuyển sang trạng thái WashingState
    private State washingState;
    private State completedState;//cho phép lấy chén đĩa ra (unloadDishes()), sau đó quay lại trạng thái IdleState
    //Không cho phép bắt đầu chu trình mới trước khi lấy chén đĩa ra 
    private State currentState;

    public Dishwasher() {
        idleState = new IdleState(this);
        loadedState = new LoadedState(this);
        washingState = new WashingState(this);
        completedState = new CompletedState(this);

        currentState = idleState; // Máy bắt đầu ở trạng thái chờ
    }

    public void loadDishes() {
        currentState.loadDishes();
    }

    public void startWashing() {
        currentState.startWashing();
    }

    public void completeCycle() {
        currentState.completeCycle();
    }

    public void unloadDishes() {
        currentState.unloadDishes();
    }

    public void setState(State state) {
        currentState = state;
    }

    public State getIdleState() { return idleState; }
    public State getLoadedState() { return loadedState; }
    public State getWashingState() { return washingState; }
    public State getCompletedState() { return completedState; }
}
