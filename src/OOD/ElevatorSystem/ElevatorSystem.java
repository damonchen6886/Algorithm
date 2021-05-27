package OOD.ElevatorSystem;

import java.util.List;
import java.util.PriorityQueue;

public class ElevatorSystem {
    List<PassengerElevator> elevators;
    List<FloorButton> floors;

    public void monitorEvents(){
        for(FloorButton f: floors){
            if(f.isClicked){
                ExternalRequest request = f.pressButton(f.level);
                handleSingleRequest(request);
            }
        }
    }

    public void handleSingleRequest(ExternalRequest r){
        if(r.d == Direcion.up){
            PriorityQueue<PassengerElevator> pq = new PriorityQueue<>( (a, b)-> b.currentLevel-a.currentLevel);
            for(PassengerElevator e: elevators){
                if(r.level > e.currentLevel){
                    pq.offer(e);
                }
            }
            if(!pq.isEmpty()){
                PassengerElevator cur = pq.poll();
                cur.handleExternalRequest(r);
                return;
            }

        }
        else if(r.d == Direcion.down){
            PriorityQueue<PassengerElevator> pq = new PriorityQueue<>( );
            for(PassengerElevator e: elevators) {
                if (r.level < e.currentLevel) {
                    pq.offer(e);
                }
            }
            if(!pq.isEmpty()){
                PassengerElevator cur = pq.poll();
                cur.handleExternalRequest(r);
                return;
            }
        }
        for(PassengerElevator e : elevators){
            if(e.status ==Status.idle){
                e.handleExternalRequest(r);
                return;
            }
        }

    }

}
