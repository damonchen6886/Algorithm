package day21;

import java.util.*;

public class CalculateEquation {


//    Weighted Directed Graph -> Find Path Weight
//            Medium
//    Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
//    Example:
//    Given
//    a / b = 2.0, b / c = 3.0.
//    queries are:
//    a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
//            return
//            [6.0, 0.5, -1.0, 1.0, -1.0 ].



    public double[] cal(String[][] equations, double[] values, String[][] queries){
        if(equations == null || equations.length == 0 || equations[0].length == 0 || values == null || equations.length != values.length || queries == null){
            return new double[0];
        }
        // Construct the graph
        // a/b =2.0 -> a, b, 2
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.length; i++){
            // one formula has two edges
            add(graph, equations[i][0], equations[i][1], values[i]); // add one edge
            add(graph, equations[i][1], equations[i][0], 1.0/values[i]);
        }
        double[] result = new double[queries.length];
        for(int i =0; i < queries.length; i++){
            result[i] = getValue(graph, queries[i][0], queries[i][1]);
        }
        return result;
    }

    private void add(Map<String, Map<String, Double>> graph, String from, String to, double value){
        graph.putIfAbsent(from, new HashMap<String, Double>());
        graph.get(from).put(to, value);
    }
    // pure BFS
    private double getValue(Map<String, Map<String, Double>> graph, String from, String to){
        if(graph.get(from) == null || graph.get(to) == null) return -1;
        // BFS
        Queue<String> queue = new LinkedList<String>();
        // visted
        Set<String> visited = new HashSet<String>();
        Map<String, Double> value = new HashMap<String, Double>();
        // init
        queue.offer(from);
        visited.add(from);
        value.put(from, 1.0);
        String curNode, nextNode;
        while(!queue.isEmpty()){
            curNode = queue.poll();
            //  a/b = 2,   b/c = 3   a/c = 6    a -> b -> c
            // itertor
            for(Map.Entry<String, Double> entry:graph.get(curNode).entrySet()){
                nextNode = entry.getKey();
                value.put(nextNode, entry.getValue() * value.get(curNode));
                if(nextNode.equals(to)){
                    return value.get(to);
                } else if(visited.add(nextNode)){
                    queue.offer(nextNode);
                }
            }
        }
        return -1.0;
    }







    /////-------------------------------

}
