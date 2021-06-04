package Arrays;

import java.util.*;




public class ThreeSum {

    //-------------two sum
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!= i){
                return new int[]{nums[i], map.get(target-nums[i])};
            }
        }
        return new int[]{};
    }

    //Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    //
    //Notice that the solution set must not contain duplicate triplets.

    //Input: nums = [-1,0,1,2,-1,-4]
    //Output: [[-1,-1,2],[-1,0,1]]
    //------------------
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length;i++){
            int right = nums.length-1;
            int left = i+1;
            while(left < right){
                int sum = nums[i] +nums[left] + nums[right];
                if(sum ==0){
                    set.add(new ArrayList<>(List.of(nums[i],nums[left],nums[right])));
                    right--;
                    left++;
                }
                else if(sum >0){
                    right--;
                }
                else if(sum <0){
                    left++;
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }


    //--------------------------
    // K sum:
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }
    private List<List<Integer>> kSum (int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k == 2) { //two pointers from left and right
            int left = start, right = len - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target) {
                    List<Integer> path = new ArrayList<Integer>();
                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(path);
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) { //move left
                    left++;
                } else { //move right
                    right--;
                }
            }
        } else {
            for(int i = start; i < len - (k - 1); i++) {
                if(i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
                for(List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            }
        }
        return res;
    }
;
}
