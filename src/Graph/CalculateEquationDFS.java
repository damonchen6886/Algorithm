package Graph;

import java.util.*;

public class CalculateEquationDFS {
    public double[] cal(String[][] equations, double[] values, String[][] queries){
        if(equations == null || equations.length == 0 || equations[0].length == 0 || values == null || equations.length != values.length || queries == null){
            return new double[0];
        }
        HashMap<String, Map<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.length; i++){
            // one formula has two edges
            add(graph, equations[i][0], equations[i][1], values[i]); // add one edge
            add(graph, equations[i][1], equations[i][0], 1.0/values[i]);
        }
        double[] result =new double[queries.length];
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < result.length; i++){
            dfs(  result[i], graph, queries[i][0],"", queries[i][1], 0.0,visited);

        }
        return result;


    }
//    a   <b, 3><c,2><d,1>
//    b

    private void dfs( double result, HashMap<String, Map<String, Double>> graph, String from, String curString, String to,
                      double cur, Set<String> visited){
        if(curString ==to){
            result = cur;
            return;
        }
        if(visited.add(curString)){
            return;
        }
        for(String s : graph.get(from).keySet()){
            String next =s;
            double value = graph.get(from).get(next);
            cur = cur * graph.get(from).get(next);
            visited.add(next);
            dfs(result, graph, from, s, to, cur, visited);
            cur = cur/value;
        }
        result = -1;
    }




    private void add(Map<String, Map<String, Double>> graph, String from, String to, double value){
        graph.putIfAbsent(from, new HashMap<String, Double>());
        graph.get(from).put(to, value);
    }





//---------------------


    public double[] calcEquationsDFS(String[][] equations, double[] values, String[][] queries){
        if(equations == null || values == null || queries == null || equations.length != values.length){
            return new double[0];
        }
        // step 1: build graph
        HashMap<String, List<Edge>> map = buildGraph(equations, values);
        double[] res = new double[values.length];
        int index = 0;
        for(String[] query : queries){
            if(!map.containsKey(query[0])){
                res[index] = Integer.MIN_VALUE; // if the element is not defined, return Integer.MIN_VALUE
            } else {
                String numerator = query[0];
                String denominator = query[1];
                HashSet<String> visited = new HashSet<String>();
                double val = dfs(map, visited, 1.0, numerator, denominator);
                res[index] = val;
            }
            index++;
        }
        return res;
    }
    private HashMap<String,List<Edge>> buildGraph(String[][] equations, double[] values){
        // Directed and Weighted Graph
        HashMap<String, List<Edge>> map = new HashMap<>();
        for(int i = 0; i < equations.length; i++){
            map.putIfAbsent(equations[i][0], new ArrayList<Edge>());
            map.get(equations[i][0]).add(new Edge(equations[i][0], equations[i][1], values[i]));
            map.putIfAbsent(equations[i][1], new ArrayList<Edge>());
            map.get(equations[i][1]).add(new Edge(equations[i][1], equations[i][0], 1.0/values[i]));
        }
        return map;
    }
    private double dfs(Map<String, List<Edge>> map, HashSet<String> visited, double pathVal, String from, String to){
        if(from.equals(to)){
            return pathVal;
        }
        visited.add(from);
        List<Edge> edges = map.get(from);
        if(edges != null){
            for(Edge e : edges){
                if(visited.contains(e.to)){
                    continue;
                }
                visited.add(e.to);
                double value = dfs(map,visited, pathVal * e.value, e.to, to);
                if(value != Integer.MIN_VALUE){
                    return value;
                }
            }
        }
        // nothing found
        return Integer.MIN_VALUE;
    }
    class Edge{
        String from, to;
        double value;
        public Edge(String from, String to, double value){
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

}