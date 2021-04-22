package DynamicProgramming;

public class backpack4 {

    //Description
    //Given n items with size nums[i] which an integer array and all positive numbers, no duplicates. An integer
    // target denotes the size of a backpack. Find the number of possible fill the backpack.
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
//    // another solution, better than 1st one
//    public int backpack4(int[] arr, int target){
//        int[][] dp = new int[arr.length+1][target+1];
//        dp[0][0] = 1;
//
//        for(int i = 1 ; i < arr.length+1; i++){
//            for(int j = 1; j < target+1; j++){
//                if(j >= arr[i-1]){
//                    dp[i][j] = dp[i][j]+ dp[i][j-arr[i-1]];
//                }
//                else{
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        return dp[arr.length][target];

//    }
    public int backPackIV(int[] nums, int target) {
        // Write your code here
        int m = target;
        int []A = nums;
        int f[][] = new int[A.length + 1][m + 1];

        f[0][0] = 1;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k * A[i-1] <= j; k++) {
                    f[i][j] += f[i-1][j-A[i-1]*k];
                }
            } // for j
        } // for i
        return f[A.length][target];
    }

    // using 1d array approach (rollingArray):
    public int backpack4RollingArr(int[] arr, int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 0 ; i < arr.length; i++){
            for(int j = arr[i]; j < target+1; j++){
                dp[j] = dp[j]+ dp[j-arr[i]];
            }
        }
        return dp[target];
    }
    // another version of rollingArr
    public int backPackIVVersion2(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = nums[i - 1]; j <= target; j++) {
                dp[j] += dp[j - nums[i - 1]];
            }
        }

        return dp[target];
    }



    public static void main(String[] args) {
        backpack4 b  = new backpack4();
        System.out.println(b.backpack4RollingArr(new int[]{1,2,3}, 4));
    }



}
