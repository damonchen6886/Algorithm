package BFS;

import java.util.*;

public class NumofIslands {

    public int numIsland(int[][] island){
        int[][] direction = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        if(island == null || island.length == 0 || island[0].length == 0){
            return 0;
        }
        int islands = 0;

        int line = island.length;
        int column = island[0].length;
        Deque<Point> queue = new LinkedList<>();
        for(int i = 0; i < line; i++){
            for(int j = 0; j < column; j++){
                if(island[i][j] == '1'){
                    islands++;
                    queue.offer(new Point(i,j));
                    while(!queue.isEmpty()){
                        Point p = queue.poll();
                        for(int z = 0; z < direction.length; z++){
                            int x= p.x +direction[z][0];
                            int y = p.y + direction[z][1];
                            if(x >=0 && x < line && y>=0 && y< column && island[x][y] == '1' ){
                                island[x][y] = '0';
                                queue.offer(new Point(x,y));
                            }
                        }
                    }

                }

            }
        }

        return islands;

    }

    // numbers of island, bfs
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,1}};
    public int numsOfIsland(int[][] island){
        if(island == null || island.length == 0 || island[0].length == 0){
            return 0;
        }
        int m = island.length;
        int n = island[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(island[i][j] == 1){
                    result++;
                    island[i][j] = 0;
                    Queue<Point> queue = new LinkedList<Point>();
                    queue.offer(new Point(i,j));
                    while(!queue.isEmpty()){
                        Point p = queue.poll();
                        for(int k = 0; k < dir.length; k++){
                            int nextX = p.x + dir[k][0];
                            int nextY = p.y + dir[k][1];
                            if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && island[nextX][nextY] == 1){
                                island[nextX][nextY] = 0;
                                queue.offer(new Point(nextX, nextY));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }


    // numbers of islands dfs
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,1}};
    public int numsIslanddfs(int[][] island){
        if(island == null || island.length == 0 || island[0].length == 0){
            return 0;
        }
        int m = island.length;
        int n = island[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(island[i][j] == 1){
                    dfs(island, i, j, m, n);
                    result++;
                }
            }
        }
        return result;
    }
    private void dfs(int[][] island, int curX, int curY, int m, int n){
        if(curX < 0 || curX > m-1 || curY < 0 || curY >= n-1 || island[curX][curY] != 1){
            return;
        }
        island[curX][curY] = 0;
        for(int[] dir : dirs){
            dfs(island, curX + dir[0], curY + dir[1], m, n);
        }

//        island[curX][curY] = '0';
//        for(int[] d : dirs){
//            int x = curX+ d[0];
//            int y = curY +d[1];
//            if(x >= 0 && x < row && y >= 0 && y < column && grid[x][y] == '1'){
//                dfs(grid, x,y, m, n);
//            }
//        }
//        return;
    }




    class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

//-------------------------------------------
class UnionFind {

    // Union Find
    private int[] father = null; // guarantee to exist
    // custom
    private int count;

    // constructor
    public UnionFind(int n){
        father = new int[n+1];
        for(int i = 0; i < n; i++){
            father[i] = i;
        }
    }

    // find, compressed
    private int find(int x){
        // recursively find you dad
        if(father[x] == x){
            return x;
        }
        // recursive rule
        return father[x] = find(father[x]);
    }
    // connect
    private void connect(int a, int b){
        // step 1: find the father
        int father_a = find(a);
        int father_b = find(b);
        if(father_a != father_b){
            father[father_a] = father_b;
            count--;
        }
    }
    // query
    public int query(){
        return count;
    }

    public void set_count(int total){
        count = total;
    }
}
    // UnionFind
    // O(m*n + 4k);
    // O(k*m*n);
    public int numberOfIslands(int[][] grid){
        int result = 0;
        int n = grid.length;
        int m = grid[0].length;
        int total = 0;
        UnionFind uf = new UnionFind(n*m);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    total++;
                }
            }
        }

        uf.set_count(total);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    // case 1: up
                    if(i > 0 && grid[i-1][j] == 1){
                        uf.connect(i*m + j, (i-1)*m + j);
                    }
                    // case 2: down
                    if(i < m && grid[i+1][j] == 1){
                        uf.connect(i*m + j, (i+1)*m + j);
                    }
                    // case 3: left
                    if(j > 0 && grid[i][j-1]  == 1){
                        uf.connect(i*m + j, i*m + j-1);
                    }
                    if(j < n && grid[i][j+1] == 1){
                        uf.connect(i*m + j, i*m + j+1);
                    }
                }
            }
        }
        return uf.query();
    }


///////////////////////////

    // uf2 solution:
    class Solution {
        public int numIslands(char[][] grid) {
            int[][] directions = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
            int result = 0;
            int m = grid.length;
            int n = grid[0].length;
            int total = 0;
            UnionFind uf = new UnionFind(m*n);
            for(int i = 0; i < m;i++){
                for(int j = 0; j < n;j++){
                    if(grid[i][j] == '1'){
                        total++;
                    }
                }
            }
            uf.setCount(total);
            for(int i = 0; i < m;i++){
                for(int j =0; j < n;j++){
                    if(grid[i][j] == '1'){
                        for(int[] dir: directions){
                            int x = i+dir[0];
                            int y = j +dir[1];
                            if(x >=0 && x<m && y>= 0 && y<n && grid[x][y] =='1'){
                                uf.connect(i*n+j, x*n+y);
                            }
                        }
                    }
                }
            }
            return uf.query();
        }

        public class UnionFind{
            private int[] father = null;
            int count;
            public UnionFind(int n){
                father  = new int[n+1];
                for(int i = 0; i<=n;i++){
                    father[i]  =i;
                }
            }
            public int find(int x){
                if(father[x] == x){
                    return x;
                }
                return father[x] = find(father[x]);

            }
            public void connect(int a, int b){
                int father_a  =find(a);
                int father_b = find(b);
                if(father_a != father_b){
                    father[father_a] = father_b;
                    count--;
                }
            }
            public int query(){
                return count;
            }
            public void setCount(int x){
                this.count =x;
            }
        }
    }


}


//Question
//        Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//        A region is captured by flipping all 'O''s into 'X''s in that surrounded region.
//        Example
//        X X X X
//        X O O X
//        X X O X
//        X O X X
//        After capture all regions surrounded by 'X', the board should be:
//        X X X X
//        X X X X
//        X X X X
//        X O X X
//

