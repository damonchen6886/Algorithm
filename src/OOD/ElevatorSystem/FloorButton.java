package OOD.ElevatorSystem;

public class FloorButton {
    int level;
    boolean isClicked;

    public ExternalRequest pressButton(int level){
        return new ExternalRequest(level);
    }
}
