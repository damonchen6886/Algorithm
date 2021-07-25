package PrefixSum;

import java.util.HashMap;

public class MaxSizeSubarrayToK {
    //Given an integer array nums and an integer k, return
    // the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
    //Input: nums = [1,-1,5,-2,3], k = 3
    //Output: 4
    //Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
    //Input: nums = [-2,-1,2,1], k = 1
    //Output: 2
    //Explanation: The subarray [-1, 2] sums to 1 and is the longest.
    // 思路： 构建前缀和 然后 问题就可以转化成two sum 和前缀和是否有数字等于target (array从0开始)
    // corner case: map.put(0,-1) 目的就是判断前缀和是否有数字等于target
    // map只更新一次目的：因为要找最长的 所以后面如果有同样结果 不更新map
    public int maxSubArrayLen(int[] nums, int k) {
        int[] arr = new int[nums.length];
        int sum = 0;
        for(int i = 0;i <nums.length;i++){
            sum+=nums[i];
            arr[i] = sum;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max =0;
        map.put(0,-1);
        for(int i =0; i < arr.length;i++){
            if(map.containsKey(arr[i] -k)){
                int distance = i-map.get(arr[i]-k);
                max = Math.max(max, distance);
            }
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }
        }
        return max;

    }
}
