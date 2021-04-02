package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    // Implement graph by adjcentlist, undirected and unweighted
    class UnweightedGraphNode{
        //adjenctlist
        int val;
        List<UnweightedGraphNode> neighbors;
        UnweightedGraphNode(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    // Implement graph by adjacentlist, directed and weighted
    class WeightGraphNode{
        //adjenctlist
        int val;
        Map<WeightGraphNode, Integer> neighbors;
        WeightGraphNode(int val){
            this.val = val;
            neighbors = new HashMap<>();
        }
    }


}
