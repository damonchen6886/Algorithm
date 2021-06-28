package lineSweep;

import java.util.*;

public class MergeIntervals {

//    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
//    and return an array of the non-overlapping intervals that cover all the intervals in the input.
    //Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    //Output: [[1,6],[8,10],[15,18]]
    //Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i< intervals.length;i++){
            map.put(intervals[i][0], map.getOrDefault(intervals[i][0],0)+1);
            map.put(intervals[i][1], map.getOrDefault(intervals[i][1],0)-1);
        }
        List<int[]> result = new ArrayList<>();
        int start = 0;
        int cur = 0;
        for(int key: map.keySet()){
            if(cur ==0){
                start  = key;
            }
            cur+= map.get(key);
            if(cur ==0){
                result.add(new int[]{start, key});
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    // stack approach
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]);
        Deque<int[]> stack=  new ArrayDeque<>();
        for(int[] interval: intervals){
            if(stack.isEmpty() || interval[0] > stack.peek()[1]){
                stack.push(interval);
            }
            else{
                stack.peek()[1]= Math.max(interval[1], stack.peek()[1]);
            }
        }
        ArrayList<int[]> result = new ArrayList<>(stack);
        return result.toArray(new int[0][]);
    }

    // Sort approach
    public int[][] merge3(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, (a,b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for( int[] interval: intervals){
            if(interval[0] <= end){
                end = Math.max(end, interval[1]);
            }
            else{
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);
    }
}
