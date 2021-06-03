package DynamicProgramming;

import java.util.Arrays;

public class uniquePath2 {


    //Medium
    //A robot is located at the top-left corner of a_m_x_n_grid (marked 'Start' in the diagram below).
    //The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    //Now consider if some obstacles are added to the grids. How many unique paths would there be?
    //
    //Input:
    //[
    //  [0,0,0],
    //  [0,1,0],
    //  [0,0,0]
    //]
    //Output: 2
    //Explanation:
    //There is one obstacle in the middle of the 3x3 grid above.
    //There are two ways to reach the bottom-right corner:
    //1. Right -> Right -> Down -> Down
    //2. Down -> Down -> Right -> Right

    // time: O(nm), space: O(n)

    // space O(n) 做法
    public int uniquePath(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];
        // base case;
        dp[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // if we meet obstacle
                if(matrix[i][j] == 1){
                    dp[j] = 0;
                } else {
                    // j == 0
                    dp[j] += (j>0) ? dp[j-1] : 0;
                }
            }
        }
        return dp[n-1];
    }

    // 2d dp 简洁版做法
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        for(int i = 1; i<= m;i++){
            for(int j = 1; j <= n; j++){
                if(obstacleGrid[i-1][j-1] != 1){
                    dp[i][j] = dp[i-1][j]+ dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    // standard 做法
    public int uniquePathII(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length  == 0 || grid[0][0] == 1){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // base case
        dp[0][0] = 1;
        for(int i = 1; i < m; i++){
            if(grid[i][0] == 0 && dp[i-1][0] > 0){
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for(int j = 1; j < n; j++){
            if(grid[0][j] == 0 && dp[0][j-1] > 0){
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        // induction rule
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];

    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][1] = 0;
        for(int i =1 ;i < m;i++){
            if(grid[i][0] == 0 && dp[i-1][0] >0){
                dp[i][0] = 1;
            }
        }
        for(int j =1 ;j < m;j++){
            if(grid[0][j] == 0 && dp[0][j-1] >0){
                dp[0][j] = 1;
            }
        }
        for(int i = 0; i< m;i++){
            System.out.println(Arrays.toString(grid[i]));
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

}
