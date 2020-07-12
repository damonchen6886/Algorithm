package day29;

public class CoinsGame {
    //* 	There are n coins in a line. Two players take turns to take one or two coins from right side until there are no
    //* 	more coins left. The player who take the last coin wins.
    //* 	Could you please decide the first play will win or lose?
    //* 	Example
    //		n = 1, return true.
    //		n = 2, return true.
    //		n = 3, return false.
    //		n = 4, return true.
    //		n = 5, return true
    public boolean coins(int n){
        boolean[] dp = new boolean[n+1];
        for(int i = 0; i < n+1; i++){
            //  dp[i] = !dp[i-1] && !dp[i-2];
            if(!dp[n - 1] || !dp[n - 2]){
                dp[i] = true;
            }

        }
        return dp[n];


    }
}
