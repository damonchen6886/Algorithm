package day28;

public class backpack4 {

    //Description
    //Given n items with size nums[i] which an integer array and all positive numbers, no duplicates. An integer target denotes the size of a backpack. Find the number of possible fill the backpack.
    //Each item may be chosen unlimited number of times
    //Example
    //Given candidate items[2,3,6,7]and target7,
    //A solution set is:
    //[7]
    //[2, 2, 3]



    public int backPack4(int[] weight, int size){
        int[][] dp = new int[weight.length + 1][size + 1];

        for(int i = 1; i <= weight.length; i++){
            for(int j = 1; j <= size; j++){
                for(int k = 0; k < j/(weight[i-1]); k++){
                    if(j >= weight[i-1]){
                        dp[i][j] = Math.max(dp[i-1][j], k*dp[i-1][j-k *weight[i-1]]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[weight.length][size];
    }
    // another solution
    public int backpack4(int[] arr, int target){
        int[][] dp = new int[arr.length+1][target+1];
        dp[0][0] = 1;
        for(int i = 1 ; i < arr.length+1; i++){
            for(int j = 1; j < target+1; j++){
                if(j >= arr[i-1]){
                    dp[i][j] = dp[i-1][j]+ dp[i][j-arr[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][target];

    }


    //Description
    //Given n items with sizenums[i] which an integer array and all positive numbers. An integertargetdenotes the size of a backpack. Find the number of possible fill the backpack.
    //Each item may only be used once
    //Example
    //Given candidate items[1,2,3,3,7]and target7,
    //A solution set is:
    //[7]
    //[1, 3, 3]
    public int backpack5(int[] arr, int target){
        int[][] dp = new int[arr.length+1][target+1];
        dp[0][0] = 1;
        for(int i = 1 ; i < arr.length+1; i++){
            for(int j = 1; j < target+1; j++){
                if(j >= arr[i-1]){
                    dp[i][j] = dp[i-1][j]+ dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][target];

    }



}
