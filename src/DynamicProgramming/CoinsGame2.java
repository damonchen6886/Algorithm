package DynamicProgramming;

public class CoinsGame2 {
    // Description:
    //* 	There are n coins with different value in a line. Two players take turns to take one or two coins from left side
    //* 	until there are no more coins left. The player who take the coins with the most value wins.
    //* Could you please decide the first player will win or lose?
    //* Example:
    //* 	Given values array A = [1,2,2], return true.
    //* 	Given A = [1,2,4], return false.
    // 倒着想： 给对手留最差的
    //
    public boolean coins2(int[] coins){
        int n = coins.length;
        int[] dp = new int[n+1] ;
        int[] sum = new int[n+1];
        // 从右往左 第i个sum
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + coins[n-i];
        }
        dp[0] = 0;
        dp[1] = coins[n-1];
        // dp[i-1] 从右往左剩几个
        // min(dp[i-1],dp[i-2]) 在i如何给对手最小
        for(int i =2; i < n+1; i++){
            dp[i] = sum[i]- Math.min(dp[i-1],dp[i-2]);
        }
        return dp[n] > sum[n]/2;

    }



}
