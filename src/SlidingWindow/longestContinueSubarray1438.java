package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class longestContinueSubarray1438 {
    // Sliding window 效率最高的是用双边队列deque 时间O(n); 其次用TreeMap或者priorityQueue 时间O(nlog(n)); 暴力解O(n^2);

    // Deque O(n);
    public int longestSubarray0(int[] nums, int limit) {
        if(nums.length ==1){
            return 1;
        }
        Deque<Integer> mindq = new LinkedList<>();
        Deque<Integer> maxdq = new LinkedList<>();
        int left = 0; int right;
        for( right =0; right < nums.length; right++){
            while(!maxdq.isEmpty() && nums[right] > maxdq.peekLast()){
                maxdq.pollLast();
            }
            while(!mindq.isEmpty() && nums[right]< mindq.peekLast()){
                mindq.pollLast();
            }
            mindq.addLast(nums[right]);
            maxdq.addLast(nums[right]);
            if(maxdq.peekFirst() - mindq.peekFirst() > limit){
                if(maxdq.peekFirst() == nums[left]){
                    maxdq.pollFirst();
                }
                if(mindq.peekFirst() == nums[left]){
                    mindq.pollFirst();
                }
                left++;
            }
        }
        return right-left;
    }
    // TreeMap O(nlog(n));
    public int longestSubarray(int[] nums, int limit) {
        if(nums.length ==1){
            return 1;
        }
        int left = 0;
        int right;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(right = 0;right < nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            if(map.lastEntry().getKey() - map.firstEntry().getKey() > limit){
                int i = nums[left];
                map.put(i, map.get(i)-1);
                if(map.get(i) == 0){
                    map.remove(i);
                }
                left++;
            }
        }
        return right-left;

    }

    // PriorityQueue O(nlog(n));
}
