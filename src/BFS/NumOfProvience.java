package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumOfProvience {
    // Leetcode 547
    //There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
    // and city b is connected directly with city c, then city a is connected indirectly with city c.
    //
    //A province is a group of directly or indirectly connected cities and no other cities outside of the group.
    //
    //You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are
    // directly connected, and isConnected[i][j] = 0 otherwise.

    //  1  -----   2
    //        3
//    Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//    Output: 2




    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf =new UnionFind(n);
        for(int i = 0; i < n;i++){
            for(int j = 0; j < isConnected[0].length;j++){
                if(i!= j && isConnected[i][j] ==1){
                    uf.connect(i, j);
                }
            }
        }
        return uf.query();
    }

    class UnionFind{
        public int[] father = null;
        private int size;
        public UnionFind(int n){
            father =  new int[n];
            this.size  = n;
            for(int i = 0; i < n;i++){
                father[i] = i;
            }
        }
        public int find(int x){
            if(father[x] == x){
                return x;
            }
            return father[x] = find(father[x]);
        }

        public void connect(int a, int b){
            int fathera = find(a);
            int fatherb = find(b);
            if(fathera != fatherb){
                father[fathera] = fatherb;
                size--;
            }
        }
        public int query(){
            return size;
        }
    }


    //dfs
    public int findCircleNum2(int[][] isConnected) {
        int m = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[m];
        for(int i = 0;i < m;i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i){
        for(int j = 0; j< isConnected.length;j++){
            if(!visited[j] && isConnected[i][j] == 1){
                visited[j] = true;
                dfs(isConnected, visited,j);
            }
        }
    }


    // bfs
    public int findCircleNum3(int[][] isConnected) {
        int n  =isConnected.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        int count = 0;
        for(int i =0 ; i < n;i++){
            if(!visited[i]){
                q.add(i);
                while(!q.isEmpty()){
                    int cur = q.poll();
                    visited[cur] = true;
                    for(int j = 0 ; j< n;j++){
                        if(isConnected[cur][j] ==1 && !visited[j]){
                            q.offer(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
