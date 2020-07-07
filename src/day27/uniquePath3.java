package day27;

public class uniquePath3 {
    //Given a _m_x_n _grid filled with non-negative numbers, find a path from top left to bottom right which_minimizes_the sum of all numbers along its path.
    //Note:You can only move either down or right at any point in time.
    //Example:
    //Input:
    //[
    //  [1,3,1],
    //  [1,5,1],
    //  [4,2,1]
    //]
    //Output: 7
    //Explanation: Because the path 1→3→1→1→1 minimizes the sum.
    //
    //


    public int minPath(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = matrix[0][0];
        for(int i = 0 ; i < row; i++){
            for(int j = 0;  j < column; j++){
                if(i ==0 || j ==0){
                    if(i ==0 && j == 0){
                        continue;
                    }
                    dp[i][j] = i == 0 ? dp[i][j-1] +matrix[i][j] : dp[i-1][j] + matrix[i][j];
                }
                else{

                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+matrix[i][j];
                }
            }
        }
        return dp[row-1][column-1];
    }



    public int minPath2(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[] dp = new int[column];
        dp[0] = matrix[0][0];
        for(int i  = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(j == 0){
                    dp[j] += matrix[i][j];
                    continue;
                }
                dp[j] = Math.min(dp[j-1], dp[j]) + matrix[i][j];
            }
        }
        return dp[column-1];

    }
}
