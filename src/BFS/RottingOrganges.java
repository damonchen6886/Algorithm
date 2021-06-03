package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOrganges {
//You are given an m x n grid where each cell can have one of three values:
//
//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

// 2  1  1     2  2  1      2  2  2      2  2  2
// 1  1  0  -> 2  1  0  ->  2  2  0  ->  2  2  0   -> return 4
// 0  1  1     0  1  1      0  1  1      0  2  2
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        int fresh = 0;
        for(int i = 0; i<m;i++){
            for(int j = 0; j <n;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
                if(grid[i][j] ==1){
                    fresh++;
                }
            }
        }
        if(q.size() == 0){
            return fresh== 0 ? 0: -1;
        }
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size;i++){
                int[] cur = q.poll();
                for(int[] dir: directions){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x >=0 && x< m && y >=0 && y <n && !visited[x][y] && grid[x][y] ==1){
                        grid[x][y] = 2;
                        q.offer(new int[]{x,y});
                        visited[x][y] = true;
                        fresh--;
                    }
                }
            }
            count++;
        }
        return fresh == 0 ? count-1: -1 ;
    }
}
