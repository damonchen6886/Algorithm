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

        int[][] dp = new int[coins.length+1][amt+1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0]= 0;
        for(int i = 1; i <coins.length+1; i++){
            for(int j = 0; j < amt+1 ; j++){
                if(j - coins[i-1] >=0){
                    int prev = dp[i][j-coins[i-1]];
                    if(prev < Integer.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i-1][j], prev + 1);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }

                }
                else{
                    dp[i][j] = dp[i-1][j];
                }


            }
        }

        return dp[coins.length][amt] != Integer.MAX_VALUE ? dp[coins.length][amt] :-1;


    }

    // better version:
    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for(int i = 0; i < length; i++){
            for(int j = coins[i]; j < amount+1; j++){
                if(dp[j - coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }


            }
        }
        return dp[amount] > amount ? -1: dp[amount];

    }




}
