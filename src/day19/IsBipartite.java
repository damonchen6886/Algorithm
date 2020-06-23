package day19;

import java.util.ArrayList;
import java.util.List;


//Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two groups such that no nodes have direct edges to other nodes in the same group.
//
//Examples
//
//1  --   2
//
//    /
//
//3  --   4
//
//is bipartite (1, 3 in group 1 and 2, 4 in group 2).
//
//1  --   2
//
//    /   |
//
//3  --   4
//
//is not bipartite.
//
//Assumptions
//
//The graph is represented by a list of nodes, and the list of nodes is not null.
public class IsBipartite {
    public boolean isBipartite(List<GraphNode> graph){
        return false;

    }
    class GraphNode{
        //adjenctlist
        int val;
        List<GraphNode> neighbors;
        GraphNode(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }


}
