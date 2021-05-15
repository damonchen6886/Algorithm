package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// leetcode 787
//There are n cities connected by some number of flights. You are given an array flights where
// flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
//
//You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
// If there is no such route, return -1.
//Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
//Output: 200
//Explanation: The graph is shown.
//The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

//            0
//   100  /       \  500
//       /         \
//    1<-           -> 2
//    ^      100       ^
//    |----------------|


public class CheapestFlightWithKStops {


    // BFS with pruning
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int i = 0; i < flights.length;i++){
            map.putIfAbsent(flights[i][0], new ArrayList<>());
            map.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]- b[0]);
        pq.offer(new int[]{0,src,k+1});
        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int price = cur[0];
            int city = cur[1];
            int stop = cur[2];
            if(city == dst){
                return price;
            }
            if(stop >0 && map.containsKey(city)){
                ArrayList<int[]> curList = map.get(city);
                for(int[] next : curList){
                    pq.add(new int[]{price+next[1],next[0],stop-1});
                }
            }
        }
        return -1;
    }

    //DFS
    int result = Integer.MAX_VALUE;
    Map<Integer, ArrayList<int[]>> map = new HashMap<>();
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        for(int i = 0; i < flights.length;i++){
            map.putIfAbsent(flights[i][0], new ArrayList<>());
            map.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
        dfs( src,dst,k+1,0);
        return result == Integer.MAX_VALUE ? -1: result;
    }
    private void dfs( int src, int dst, int k, int cost){
        if(k <0){
            return;
        }
        if(src == dst){
            result = cost;
            return;
        }
        if(!map.containsKey(src)){
            return;
        }
        for(int[] cur: map.get(src)){
            if(cost + cur[1] > result){
                continue;
            }
            dfs(cur[0],dst,k-1,cost+cur[1]);
        }
    }


}
