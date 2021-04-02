package DynamicProgramming;

public class CutRope {

    public int  maxProduct(int length){
        if(length == 2){
            return 1;
        }
        int[] dp = new int[length+1];
        dp[1] = 0;
        dp[2] = 1;
        for(int i = 3; i <= dp.length; i++){
            for(int j = 1; j <= i/2; j++){
                dp[i] = Math.max(dp[i], j * Math.max(i-j, dp[i-j]));
            }
        }
        return dp[length+1];
    }
    public int cuttingRope(int n){
        if(n == 0){
            return 0;
        }
        int[] dp =  new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] =1;
        dp[3] = 2;

        int max = 0;
        for(int i =4; i <= n+1; i++){
            for(int j = 1; j < i; j++){
                max = Math.max(Math.max(dp[i-j], i-j)*j,max);

                dp[i] = max;


            }
        }
        return dp[n+1];
    }



}
