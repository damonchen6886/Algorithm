package OOD.ElevatorSystem;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PassengerElevator {
    List<ElevatorButton> buttons;
    PriorityQueue<Integer> upStops;
    PriorityQueue<Integer> downStops;
    int currentLevel;
    Status status;
    boolean gateOpen;
    float weightLimit;
    public PassengerElevator(){
        downStops = new PriorityQueue<>((a,b)-> b-a);
    }

    public void handleExternalRequest(ExternalRequest r){
        if(r.d == Direcion.up){
            upStops.offer(r.level);
        }
        else{
            downStops.offer(r.level);
        }
        updateStatues();
    }

    public void handleInternalRequest(InternalRequest r){
        if(isRequestValid(r)){
            if(status == Status.up){
                upStops.offer(r.level);
            }
            if(status == Status.down){
                downStops.offer(r.level);
            }
        }

    }

    public void openGate(){
        if(status == Status.up){
            currentLevel++;
        }
        if(status == Status.down){
            currentLevel--;
        }
        else{
            currentLevel =1;
        }



    }
    public void closeGate() throws OverWeightException {
        if(getCurrentWeight() > weightLimit){
            throw new OverWeightException("overWeight");
        }
        if(status == Status.up){
            upStops.remove(currentLevel);
        }
        if(status == Status.down){
            downStops.remove(currentLevel);
        }
        for(ElevatorButton b: buttons){
            if(b.isClicked){
                this.handleInternalRequest(b.pressButton());
            }
        }
        updateStatues();
    }

    private float getCurrentWeight(){
        return 0;
    }

    private boolean isRequestValid(InternalRequest r){
        return (status == Status.up && r.level > currentLevel) || (status == Status.down && r.level < currentLevel);
    }


    private void updateStatues(){
        if(upStops.size() ==0 && downStops.size() != 0){
            this.status = Status.down;
        }
        if(downStops.size() ==0 && upStops.size() !=0){
                this.status = Status.up;
        }
        else{
            this.status = Status.idle;
        }
        if(status == Status.idle){
            downStops.add(1);
        }
    }
}


