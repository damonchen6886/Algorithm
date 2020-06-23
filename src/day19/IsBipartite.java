package day19;

import java.util.*;


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
        // Assumption
        if(graph == null || graph.size() == 0){
            return true;
        }
        // key: node  value: which group
        HashMap<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
        // do not use index
        for(GraphNode node: graph){ // itertor
            if(!BFS(node, visited)){
                return false;
            }
        }
        return true;
    }
    private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited){
        // if this node has been traversed before, do not traverse it again
        if(visited.containsKey(node)){
            return true;
        }
        // start bfs here
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.offer(node);
        visited.put(node, 0);
        while(!queue.isEmpty()){
            GraphNode cur = queue.poll();
            int curGroup = visited.get(cur); // 0 : 1
            int neiGroup = curGroup == 0 ? 1 : 0;
            for(GraphNode nei : cur.neighbors){
                // case 1: if the neighbor has not been visited
                if(!visited.containsKey(nei)){
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                } else if(visited.get(nei) != neiGroup){
                    // case 2: it the neighbor has been visited before
                    return false;
                }
            }
        }
        // case 3: has been visited before and visited.get(nei) == neiGroup
        return true;
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
