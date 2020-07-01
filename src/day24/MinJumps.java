package day24;

public class MinJumps {

    //Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.
    //
    //Assumptions
    //
    //The given array is not null and has length of at least 1.
    //Examples
    //
    //{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
    //
    //{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
    //
    // dp[i] = min(dp[i-1]+ [i]



    public int minJumps2(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }
        int length = array.length;
        int[] dp = new int[length];
        dp[0] = 0;
        for(int i = 1; i < length; i++){
            dp[i] = -1;
            for(int j = i-1; i >= 0; j--){
                if(array[j] + j >= i && dp[j] != -1){
                    if(dp[i] == -1 || dp[i] > dp[j] + 1){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        return dp[length-1];
    }
    public int minJumps(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int[] dp = new int[arr.length+1];
        dp[0] = arr[0] >= 0? 1:-1;
        int min = 0;
        int sum = 0;
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j ++){
                if(arr[j] >= i-j && dp[i-j] != -1){
                    dp[i] = Math.min(dp[i-1]+1,Math.min(min, dp[j]+1));
                }

            }
            if(dp[i] == 0){
                dp[i] = -1;
            }
        }
        return dp[arr.length];
    }

}
