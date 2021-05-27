package OOD.ElevatorSystem;

public interface Elevator {

    void handleExternalRequest(ExternalRequest r);

    void handleInternalRequest(InternalRequest r);

    void openGate();

    void closeGate();
}
