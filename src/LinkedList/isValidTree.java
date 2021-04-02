package day32;

import java.util.*;

// leetcode 261: Graph Valid Tree
public class isValidTree {

    //Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
    //Notice
    //You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
    //Example
    //Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
    //Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
    //
    //“a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
    class UnionFind{
        int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            return compress_find(x);
        }
        // iterative compress the parent
        public int compress_find(int x){
            int x_parent = parent[x];
            // step 1: find real parent
            while(x_parent != parent[x_parent]){
                x_parent = parent[x_parent];
            } // x_parent is the thing you need to return
            // step 2：compress
            int temp = -1;
            int t_parent = parent[x];
            while(t_parent != parent[t_parent]){
                temp = parent[t_parent];
                parent[t_parent] = x_parent;
                t_parent = temp;
            }
            return x_parent;
        }
        public void union(int a, int b){
            int a_parent = find(a);
            int b_parent = find(b);
            if(a_parent != b_parent){
                parent[a_parent] = b_parent;
            }
        }
    }

    public boolean validTree(int n, int[][] edges){
        // corner case
        if(n - 1 != edges.length || n == 0){
            return false;
        }
        UnionFind uf = new UnionFind(n);
        // linear search the edge
        for(int i = 0; i < edges.length; i++){
            if(uf.find(edges[i][0]) == uf.find(edges[i][1])){
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////
    ///dfs  version:

    public boolean dfsValidTree(int n, int[][] edges){
        // corner case
        if(n - 1 != edges.length || n == 0){
            return false;
        }
        // convert to adjacent list from matrix
        List<List<Integer>> adjList = new ArrayList<>(n);
        // init the graph
        for(int i = 0; i < n; i++){
            adjList.add(i, new ArrayList<Integer>());
        }
        // connect the edge
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        if(hasCycle(adjList, 0, visited, -1)){
            return false;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent){
        // base case:
        if(visited[u]){
            return true;
        }
        visited[u] = true;
        // recursion rule
        for(int v : adjList.get(u)){
            // skip putting v into recursion again if v == parent
            if(v != parent && hasCycle(adjList, v, visited, u)){
                return true;
            }
        }
        return false;
    }


    ////////////////////////////////////////////////////////////
    // bfs  version
    public boolean BFSValid(int n, int[][] edges){
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++){
            graph.add(new HashSet<Integer>());
        }
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // start bfs
        boolean[] visited = new boolean[n]; // step 1: marker
        Queue<Integer> queue = new ArrayDeque<Integer>(); // step 2: queue
        queue.add(0); // step 3: init
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(visited[node]){
                return false;
            }
            visited[node] = true;
            for(int neighbor : graph.get(node)){
                queue.offer(neighbor);
                graph.get(neighbor).remove((Integer)node);
            }
        }
        for(boolean result:visited){
            if(!result){
                return false;
            }
        }
        return true;
    }




}
