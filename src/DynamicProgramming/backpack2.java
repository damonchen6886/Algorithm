package DynamicProgramming;

public class backpack2 {
    //Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value
    // can you put into the backpack?
    //Notice
    //You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
    //Example
    //Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
    public int backPackII(int[] weight, int[] value, int size){
        int[][] dp = new int[weight.length + 1][size + 1];
        for(int i = 1; i <= weight.length; i++){
            for(int j = 1; j <= size; j++){
                if(j >= weight[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[weight.length][size];
    }

}
