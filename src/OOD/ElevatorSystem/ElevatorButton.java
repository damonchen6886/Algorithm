package OOD.ElevatorSystem;

public class ElevatorButton {
    int level;
    boolean isClicked;

    public InternalRequest pressButton(){
        return new InternalRequest(this.level);
    }



}

