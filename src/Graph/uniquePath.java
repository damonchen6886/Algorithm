package Graph;


//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
////
////The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?
public class uniquePath {
    public int uniquePath(int m, int n){
        // corner case:
        if(m < 0 || n <0){
            return -1;
        }
        return dfs(m-1, n-1);
    }
    private int dfs(int m, int n){
        // base case
        if(m < 0 || n < 0) return 0;
        else if(m == 0 && n == 0) return 1;
            // recursion rule (2 branch)

        else {
            int down = dfs(m - 1, n);
            int right = dfs(m, n - 1);
            return down + right;
        }
    }

    // dp : 1 : 物理意义(i, j)  2: base case:   3: induction rule
    public int uniquePathDP(int m, int n){
        if(m <= 0 || n <= 0){
            return 0;
        }
        // dp
        int[][] dp = new int[m][n];
        // base case: dp[3][4] = 代表着到坐标为(2,3)一共有多少种UniquePath
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    // base case;
                    dp[i][j] = 1;
                } else{
                    // induction rule
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    // 大杀器, memory search
    public int uniquePathMem(int m, int n){
        if(m <= 0 || n <= 0){
            return 0;
        }
        return memorySearch(m-1, n-1, new int[m][n]);
    }
    private int memorySearch(int m, int n, int[][] info){
        // base case
        if(m < 0 || n < 0) {
            return 0;
        }
        else if(m == 0 && n == 0) {
            return 1;
        }
        else if(info[m][n] > 0){
            return info[m][n];
        } else {
            info[m][n] = memorySearch(m-1, n, info) + memorySearch(m, n-1, info);
            return info[m][n];
        }
    }


}
