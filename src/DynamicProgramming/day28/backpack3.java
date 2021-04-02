package day28;

public class backpack3 {

    //
    //Given n kind of items with size Ai and value Vi(each item has an infinite number available) and a backpack with size_m. What's the maximum value can you put into the backpack?
    //You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
    //Example
    //Given 4 items with size[2, 3, 5, 7]and value[1, 5, 2, 4], and a backpack with size10. The maximum value is 15.Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?
    //Notice
    //You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
    //Example
    //Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.

    // items can be used multiple times
    public int backPackIII1(int[] weight, int[] value, int size){
        int[][] dp = new int[weight.length + 1][size + 1];
        for(int i = 1; i <= weight.length; i++){
            for(int j = 1; j <= size; j++){
                if(j >= weight[i-1]){
                    // changed the dp[i-1][j-weight[i-1]] to dp[i][j-weight[i-1]]
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weight[i-1]] + value[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[weight.length][size];
    }


    public int backPackIII2(int[] weight, int[] value, int size){
        int[][] dp = new int[weight.length + 1][size + 1];
        for(int i = 1; i <= weight.length; i++){
            for(int j = 1; j <= size; j++){
                for(int k = 0; k < j/(weight[i-1]); k++){
                    if(j >= weight[i-1]){
                        dp[i][j] = Math.max(dp[i-1][j], k*dp[i-1][j-weight[i-1]] + k* value[i-1]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[weight.length][size];
    }


}
