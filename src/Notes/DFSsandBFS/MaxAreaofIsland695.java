package Notes.DFSsandBFS;

import java.util.LinkedList;
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
}
