package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class IslandMaxArea {
// bfs solution:
    int[][] directions = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> q = new ArrayDeque<>();
        int result = 0;
        for(int i = 0; i < m;i++){
            for(int j = 0 ; j < n;j++){
                if(grid[i][j] ==1){
                    grid[i][j] =0;
                    q.offer(new Point(i,j));
                    int count = 1;
                    while(!q.isEmpty()){
                        Point p = q.poll();
                        for(int[] dir: directions){
                            int x  = p.x +dir[0];
                            int y = p.y + dir[1];
                            while(x >=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                                grid[x][y] =0;
                                q.offer(new Point(x,y));
                                count++;
                            }
                        }
                    }
                    result= Math.max(result, count);
                }
            }
        }
        return result;
    }


    // dfs
    public int maxAreaOfIsland2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> q = new ArrayDeque<>();
        int result = 0;
        for(int i = 0; i < m;i++){
            for(int j = 0 ; j < n;j++){
                if(grid[i][j] ==1){
                    int[] count  =  new int[]{1};
                    grid[i][j] =0;
                    dfs(grid, count,i,j);
                    result = Math.max(result, count[0]);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int[] count, int i, int j){
        Point p = new Point(i,j);
        for(int[] dir: directions){
            int x = p.x + dir[0];
            int y = p.y +dir[1];
            if(x >=0 && x< grid.length && y >=0 && y< grid[0].length && grid[x][y] ==1){
                count[0]++;
                grid[x][y] =0;
                dfs(grid, count, x,y);
            }
        }
    }



    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
