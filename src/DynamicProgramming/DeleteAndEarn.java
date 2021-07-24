package DynamicProgramming;

public class DeleteAndEarn {
    // Leetcode 740
    // 偷家问题变种
    // You are given an integer array nums. You want to maximize the number of points you get by
    // performing the following operation any number of times:
    //
    //Pick any nums[i] and delete it to earn nums[i] points. Afterwards,
    // you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
    //Return the maximum number of points you can earn by applying the above operation some number of times.
    //Input: nums = [3,4,2]
    //Output: 6
    //Explanation: You can perform the following operations:
    //- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
    //- Delete 2 to earn 2 points. nums = [].
    //You earn a total of 6 points.

    //Input: nums = [2,2,3,3,3,4]
    //Output: 9
    //Explanation: You can perform the following operations:
    //- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
    //- Delete a 3 again to earn 3 points. nums = [3].
    //- Delete a 3 once more to earn 3 points. nums = [].
    //You earn a total of 9 points.
    // constraints:
    // 1 <= nums.length <= 2 * 10^4
    //1 <= nums[i] <= 10^4
;

    // 思路 用bucket sort 复杂度O(n)
    // 用一个max 来存最大的num 这样不用循环10001次
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        int[] bucket = new int[10001];
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            bucket[num]+= num;
            max = Math.max(max, num);
        }
        int[] dp = new int[max+1];
        dp[0] = bucket[0];
        dp[1] = bucket[1];
        for(int i =2 ; i< max+1;i++){
            dp[i] = Math.max(dp[i-2]+bucket[i], dp[i-1]);
        }
        return dp[max];
    }
}
