package BFS;

import java.util.HashSet;
import java.util.Set;

public class numDistinctIslands {
    //----------
    // 思路： dfs 找岛 用方向来记录岛的样子 用hashset来装方向  return hashset的长度即可
    //  注意： 记录方向时因为无法区别dfs是否回弹 所以要加上特殊符号来记录回弹
    int[][] directions = new int[][]{{1,0,2},{-1,0,1},{0,-1,4},{0,1,3}};
    public int numDistinctIslands(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        ;
        // ArrayList<Integer> result = new ArrayList<>();
        Set<String> set = new HashSet<>();;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    StringBuilder sb = new StringBuilder();
                    sb.append('a');
                    dfs(grid,i,j,sb);
                    System.out.println(sb.toString());
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    private  void dfs(int[][] grid, int i, int j ,StringBuilder sb){
        for(int[] dir: directions){
            int x = i + dir[0];
            int y = j +dir[1];
            char curDir =(char) (dir[2]+'0');

            if( x  >= 0 && x <grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
//                System.out.println(curDir);
                grid[x][y] = 0;
                sb.append(curDir);
                dfs(grid, x,y, sb);
            }
        }
        //要加上特殊符号来记录回弹
        sb.append('-');
    }
//    ---------------
    //323----
    //32-3---

    public static void main(String[] args) {
        numDistinctIslands t = new numDistinctIslands();
        int[][] grid = {{1,1,0},{0,1,1},{0,0,0},{1,1,1},{0,1,0}};
        System.out.println(t.numDistinctIslands(grid));
    }

}
