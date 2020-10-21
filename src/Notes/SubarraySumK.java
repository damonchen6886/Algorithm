package Notes;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k
//Input:nums = [1,1,1], k = 2
//Output: 2 index0+index1 =2; index1+index2 =2; count  =2;

public class SubarraySumK {
    // O(n) 前缀和
    //
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i = 0; i< n;i++){
            sum +=nums[i];
            count+= map.getOrDefault(sum-k,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;

    }


    //O(n^2) 普通解法+优化
    public int subarraySum2(int[] nums, int k) {
        int n = nums.length;

        int count = 0;

        for(int i = 0; i< n; i++){
            int sum = 0;
            for(int j= i; j < n; j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;

    }


}
