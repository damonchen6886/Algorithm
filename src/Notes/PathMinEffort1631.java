package Notes;

import java.util.LinkedList;
import java.util.Queue;

public class PathMinEffort1631 {


    // accepted:
    class Solution {
        public int minimumEffortPath(int[][] matrix) {
            if(matrix == null || matrix.length ==0){
                return 0;
            }
            int left =0;
            int right = 1000000;
            int result=right;
            while(left <=right){
                int mid = left+ (right-left)/2;
                if(bfs(matrix, mid)){
                    result = Math.min(result, mid);
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }

            }
            return result;
        }
        int[][] direction = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};

        private boolean bfs(int[][] matrix, int target){
            int row  = matrix.length;
            int column = matrix[0].length;

            boolean[][] visited = new boolean[row][column];
            Queue<int[]> queue =new LinkedList<>();
            queue.offer(new int[]{0,0});
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                visited[cur[0]][cur[1]] = true;
                if(cur[0] == row-1 && cur[1] == column-1){
                    return true;
                }
                for(int[] dir: direction){
                    int x = cur[0]+ dir[0];
                    int y =cur[1] + dir[1];
                    if(x >= 0 && x < row && y >= 0  && y < column && !visited[x][y]){
                        int dif = Math.abs(matrix[x][y]- matrix[cur[0]][cur[1]]);
                        if(dif <= target){
                            visited[x][y] = true;
                            queue.offer(new int[]{x,y});
                        }
                    }

                }
            }

            return false;
        }


    }

    //  not accepted:

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int minimumEffortPath(int[][] heights) {
        if(heights == null || heights.length == 0 || heights[0].length == 0){
            return 0;
        }
        int m = heights.length, n = heights[0].length;
        int[] min = new int[]{Integer.MAX_VALUE};
        int[] max = new int[]{Integer.MIN_VALUE};
        boolean[][] visited = new boolean[m][n];
        dfs(heights, visited, 0, 0, min, max);
        return min[0] < 0 ? 0 : min[0];
    }
    private void dfs(int[][] heights, boolean[][] visited, int m, int n, int[] min, int[] max){
        if(m == heights.length - 1 && n == heights[0].length - 1){
            min[0] = Math.min(max[0], min[0]);
            return;
        }

        visited[m][n] = true;
        for(int[] dir : dirs){
            int x = m + dir[0];
            int y = n + dir[1];
            if(x >= 0 && y >= 0 && x < heights.length && y < heights[0].length && !visited[x][y]){
                int temp = max[0];
                max[0] = Math.max(max[0], Math.abs(heights[m][n] - heights[x][y]));
                dfs(heights, visited, x, y, min, max);
                max[0] = temp; // return to origin when backtracking
            }
        }
        visited[m][n] = false;
    }
}
