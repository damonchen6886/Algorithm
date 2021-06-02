package lineSweep;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
}
