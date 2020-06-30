package day23;

public class LargetSum {

    //Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.
    //
    //Assumptions
    //
    //The given array is not null and has length of at least 1.
    //Examples
    //
    //{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
    //
    //{-1, -1, -3}, the largest subarray sum is -1
    public int largestSum(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }
        int cur =  array[0];
        int result =  array[0];
        for(int i = 1; i < array.length; i++){
            cur = Math.max(cur + array[i], array[i]);
            result = Math.max(result, cur);
        }
        return result;

    }
    public int GreatestSum(int[] arr){
        int[] dp = new int[arr.length+1];

        if(arr == null || arr.length == 0){
            return 0;
        }
        dp[0] = 0;
        dp[1] = arr[0];
        int curmax = dp[1];
        for(int i = 2; i < arr.length; i++){

            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            curmax = Math.max(dp[i], curmax);
        }
        return curmax;
    }



}
