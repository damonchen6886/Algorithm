package Graph;

import java.util.*;

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

    // bfs 和 heap方法遇到环小数值 和一个大数值的des会很费时间 导致TLE
 /*
                                      0
                                   /    /\
                               10 /      \
                                 /        \  10
                                \/.        \
                                 1 -------> 2----------->3
                                      10.         1000
*/
    // 比如1->2->3 ->1 循环 weight都为10  3-> 4 weight为1000  如果k很大 就非常花时间 导致TLE

    //DFS
    int result = Integer.MAX_VALUE;
    Map<Integer, ArrayList<int[]>> map = new HashMap<>();
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
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


    // Dijkstra no visited TLE
    public int findCheapestPrice4(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int i = 0; i < flights.length;i++){
            map.putIfAbsent(flights[i][0], new ArrayList<>());
            map.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
//        int count = 0;

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
//                    int[] add = new int[]{price+next[1],next[0],stop-1};
//                    System.out.println("count  = "+ count++ +" " + Arrays.toString(add));
//                    pq.add(add);
                    pq.add(new int[]{price+next[1],next[0],stop-1});
                }
            }
        }
        return -1;
    }

    // Dijkstra + visited  TLE
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int i = 0; i < flights.length;i++){
            map.putIfAbsent(flights[i][0], new ArrayList<>());
            map.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
//        int count = 0;
        Set<String> visited = new HashSet<>();
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
            visited.add(city +"_"+ stop);
            if(stop >0 && map.containsKey(city)){
                ArrayList<int[]> curList = map.get(city);
                for(int[] next : curList){
                    if(visited.contains(next[0] +"_"+ (stop-1))){
                        continue;
                    }
//                    int[] add = new int[]{price+next[1],next[0],stop-1};
//                    System.out.println("count  = "+ count++ +" " + Arrays.toString(add));
//                    pq.add(add);
                    pq.add(new int[]{price+next[1],next[0],stop-1});
                }
            }
        }
        return -1;
    }


    // bfs
    public int findCheapestPrice3(int n, int[][] flights, int src, int dst, int k) {
        int result = Integer.MAX_VALUE;
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int i = 0; i < flights.length;i++){
            map.putIfAbsent(flights[i][0], new ArrayList<>());
            map.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{src,0});
        int step = 0;
//        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0 ; i < size;i++){
                int[] cur = q.poll();
                if(cur[0] == dst){
                    result =Math.min(result, cur[1]);
                }
                if(!map.containsKey(cur[0])){
                    continue;
                }
                for(int[] next: map.get(cur[0])){
//                    int[] add = new int[]{next[0],cur[1]+next[1]};
//                    System.out.println("count  = "+ count++ +" " + Arrays.toString(add));
                    if(cur[1]+ next[1] > result){
                        continue;
                    }

//                    q.offer(add);
                    q.offer(new int[]{next[0],cur[1]+next[1]});
                }
            }
            if(step++ > k){
                break;
            }
        }
        return result == Integer.MAX_VALUE ? -1: result;
    }

    public static void main(String[] args) {
        CheapestFlightWithKStops c = new CheapestFlightWithKStops();
        int[][] arr2 = new int[][]{{1,2,10},{2,3,10},{3,1,10},{3,4,400}};
        System.out.println(c.findCheapestPrice2(4, arr2,1,4,50));
        int[][] arr = new int[][]{{11,12,74},{1,8,91},{4,6,13},{7,6,39},{5,12,8},{0,12,54},{8,4,32},{0,11,4},{4,0,91},
        {11,7,64},{6,3,88},{8,5,80},{11,10,91},{10,0,60},{8,7,92},{12,6,78},{6,2,8},{4,3,54},{3,11,76},{3,12,23},
        {11,6,79},{6,12,36},{2,11,100},{2,5,49},{7,0,17},{5,8,95},{3,9,98},{8,10,61},{2,12,38},{5,7,58},{9,4,37},{8,6,79},
        {9,0,1},{2,3,12},{7,10,7},{12,10,52},{7,2,68},{12,2,100},{6,9,53},{7,4,90},{0,5,43},{11,2,52},
        {11,8,50},{12,4,38},{7,9,94},{2,7,38},{3,7,88},{9,12,20},{12,0,26},{10,5,38},{12,8,50},{0,2,77},{11,0,13},
        {9,10,76},{2,6,67},{5,6,34},{9,7,62},{5,3,67}};
//        System.out.println(c.findCheapestPrice3(13, arr,10,1,10));
    }

}
