package day29;

import java.util.Arrays;

public class coinChange {
    public int coins(int[] coins, int amt){
        //	You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest
        // *		number of coins that you need to make up that amount. If that amount of money can not be made up by
        // *		combination of the coins, return -1;
        // *	Example:
        // *		coins = [1,2,5], amount = 11; 	return 3 (11 = 5+5+1)
        // *		coins = [2], amount = 3; return -1'

        int[][] dp = new int[coins.length][amt];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0][0]= 0;
        for(int i = 1; i <coins.length+1; i++){
            for(int j = 0; j < amt+1 ; j++){
                if(j - coins[i] >=0){
                    int prev = dp[i][j-coins[i]];
                    if(prev < Integer.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i-1][j], prev + 1);
                    }
                    // dp[i][j] = Math.min(1+ dp[i][j-coins[i]],dp[i-1][j]);

                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[coins.length][amt] != Integer.MAX_VALUE ? dp[coins.length][amt] :-1;
    }



}
