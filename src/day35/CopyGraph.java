package day35;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CopyGraph {
    //Given the head of a graph, return a deep copy (clone) of the graph. Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors. There is an edge between the given node and each of the nodes in its neighbors.
    //Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
    //How we serialize an undirected graph:
    //Nodes are labeled uniquely.
    //We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
    //As an example, consider the serialized graph {0,1,2#1,2#2,2}.
    //The graph has a total of three nodes, and therefore contains three parts as separated by #.
    //First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    //Second node is labeled as 1. Connect node 1 to node 2.
    //Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
    //Visually, the graph looks like the following:
    //  1
    // / \
    ///   \
    //0 --- 2-----3
    //    / \
    //    \_/

    class Node{
        int value;
        ArrayList<Node> neighbors;
        Node(int x){
            this.value = x;
            neighbors = new ArrayList<Node>();
        }

    }

    public Node cloneGraph(Node entry){
        if(entry == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<Node>();
        Node head = entry;
        // key : itself, value: copied
        map.put(entry, head);
        q.offer(entry);
        while(!q.isEmpty()){
            Node current = q.poll();
            for(Node nei: current.neighbors){
                if(!map.containsKey(nei)){
                    q.offer(nei);
                    Node newNeighbor = new Node(nei.value);
                    map.put(nei, newNeighbor);
                }
                map.get(current).neighbors.add(map.get(nei));
            }
        }
        return head;
    }



    /// not working
    public Node cloneGraph2(Node node){
        HashMap<Node, Integer> visited = new HashMap<>();

        ArrayList<Node> neighbors = node.neighbors;
        Node result = new Node(-1);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);


        while(!queue.isEmpty()){

            Node cur = queue.poll();
            if(visited.get(cur) == 1){
                continue;
            }
            visited.put(node,1);
            result.value = cur.value;
            ArrayList<Node> resultneighbor = new ArrayList<>();
            Node neighbor = new Node(-1);
            for(Node n :neighbors){
                queue.offer(n);
                neighbor = new Node(n.value);
                resultneighbor.add(neighbor);
            }
            result.neighbors = resultneighbor;
        }

        return result;
    }

}
