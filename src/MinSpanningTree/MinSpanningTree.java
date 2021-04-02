package MinSpanningTree;

import java.util.*;
//Sep/10/2020  leetcode 1135
//Given a list of Connections, which is the Connection class (the city name at both ends of the edge and a cost between them), find edges that can connect all the cities and spend the least amount.
//        Return the connects if can connect all the cities, otherwise return empty list.
//         Input:
//        ["Acity","Bcity",1]
//        ["Acity","Ccity",2]
//        ["Bcity","Ccity",3]
//        Output:
//        ["Acity","Bcity",1]
//        ["Acity","Ccity",2]
//        Example 2:
//
//        Input:
//        ["Acity","Bcity",2]
//        ["Bcity","Dcity",5]
//        ["Acity","Dcity",4]
//        ["Ccity","Ecity",1]
//        Output:
//        []
//        Explanation:
//        No way

public class MinSpanningTree {

 class Connection{
    String city1;
    String city2;
    int cost;
    Connection(String city1, String city2, int cost){
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
    }
}



    public  List<Connection> lowestCost(List<Connection> connections){
        if(connections == null || connections.size() == 0){
            return new ArrayList<>();
        }
        // mehtod 1: use priority queue,
        // mehtod 2: sort the connections
        Collections.sort(connections, (a, b) -> a.cost != b.cost ? a.cost - b.cost : a.city1.equals(b.city1) ? a.city2.compareTo(b.city2) : a.city1.compareTo(b.city1));
        Map<String, Integer> graph = new HashMap<>(); // key: city , value: encoded
        int count = 0;
        for(Connection connection : connections){
            if(!graph.containsKey(connection.city1)){
                graph.put(connection.city1, ++count);
            }
            if(!graph.containsKey(connection.city2)){
                graph.put(connection.city2, ++count);
            }
        }
        // Union Find
        int[] parent = new int[count + 1];
        List<Connection> res = new ArrayList<>();
        for(Connection connection : connections){
            int from = graph.get(connection.city1);
            int to = graph.get(connection.city2);
            int father_from = find(from, parent);
            int father_to = find(to, parent);
            if(father_from != father_to){
                parent[father_from] = father_to;
                res.add(connection);
            }
        }
        if(res.size() != count -1){
            return new ArrayList<>();
        }
        return res;

    }
    private int find(int x, int[] parent){
        if(parent[x] == 0){
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }



}

