package Notes.DFSsandBFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxAreaofIsland695 {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int[][] direction = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        int row = grid.length;
        int column = grid[0].length;
        int max = 0;
        int curMax = 0;
        for(int i =0; i< row; i++){
            for(int j =0; j < column; j++){
                if(grid[i][j] == 1){
                    Queue<Point> queue = new LinkedList<>();
                    curMax =1;
                    queue.offer(new Point(i,j));
                    grid[i][j] = 0;
                    while(!queue.isEmpty()){
                        Point p = queue.poll();
                        for(int[] dir : direction){
                            int x = p.x+ dir[0];
                            int y=  p.y + dir[1];
                            if(x >= 0 && x< row && y >= 0 && y < column && grid[x][y] == 1){
                                queue.offer(new Point(x,y));
                                grid[x][y] = 0;
                                curMax++;
                            }
                        }

                    }
                    max = Math.max(max, curMax);
                    curMax = 0;
                }
            }
        }
        return max;
    }

    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // dfs:
    int[][] direction = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public int maxAreaOfIsland2(int[][] grid) {
        int result = 0;
        int column = grid.length;
        int row = grid[0].length;
        for(int  i = 0; i < column; i++){
            for(int j  =0; j < row; j++){
                if(grid[i][j] == 1){
                    int curMax[] = new int[]{0};
                    dfs(grid, i, j, column, row, curMax);
                    result = Math.max(result, curMax[0]);
                }
            }
        }
        return result;
    }

    public void dfs(int[][] grid, int x, int y, int column, int row, int[] curMax){
        if(x< 0 || x >= column || y < 0 || y >= row|| grid[x][y] != 1){
            return;
        }
        grid[x][y] = 0;
        curMax[0]++;
        for(int[] dir: direction){
            dfs(grid,x+dir[0],y+dir[1],column,row,curMax);
        }
    }

    // Union Find:
    public int maxAreaOfIsland3(int[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length ==0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    if(i > 0 && grid[i-1][j] == 1){
                        uf.connect(i * cols + j, (i-1)*cols + j);
                    }
                    if(j > 0 && grid[i][j-1] == 1){
                        uf.connect(i * cols + j, (i)*cols + j - 1);
                    }
                    if(i < rows - 1 && grid[i + 1][j] == 1){
                        uf.connect(i * cols + j, (i + 1) * cols + j);
                    }
                    if(j < cols - 1 && grid[i][j + 1] == 1){
                        uf.connect(i * cols + j, (i) * cols + j + 1);
                    }
                }
            }
        }
        return uf.query();
    }

    class UnionFind{
        private int[] father = null;
        private int max;
        int cols;
        int rows;
        int[][] grid;
        // constructor
        public UnionFind(int[][] g){
            this.grid = g;
            rows =  g.length  ;
            cols = g[0].length ;
            int n = rows * cols;
            father = new int[n];
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
            int father_a = find(a);
            int father_b = find(b);
            if(father_a != father_b){
                if(father_a >= father_b){
                    father[father_a] = father_b;
                }
                else{
                    father[father_b] = father_a;
                }
            }
        }

        private void rebalance(){
            for(int i = 0; i < rows * cols; i++){
                find(i);
            }
        }
        private int query(){
            rebalance();
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for(int i = 0; i< father.length; i++){
                map.put(father[i], map.getOrDefault(father[i],0)+1);

            }

            int max =0;
            for(Map.Entry<Integer, Integer> m: map.entrySet()){
                max = Math.max(max, m.getValue());

            }
            if(max ==1){
                for(int i =0; i < rows; i++){
                    for(int j = 0; j < cols; j++){
                        if(grid[i][j] == 1){
                            return 1;
                        }
                    }
                }
                return 0;
            }
            return max;
        }
    }
}
