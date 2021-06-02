package lineSweep;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MeetingRoom {
// leetcode 253
//    Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
//    return the minimum number of conference rooms required.
    //Input: intervals = [[0,30],[5,10],[15,20]]
    //Output: 2
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> map =new TreeMap<>();
        for(int i = 0; i< intervals.length;i++){
            map.put(intervals[i][0], map.getOrDefault(intervals[i][0],0)+1);
            map.put(intervals[i][1], map.getOrDefault(intervals[i][1],0)-1);
        }
        int cur = 0;
        int max =0;
        for(int val: map.values()){
            cur+= val;
            max = Math.max(max, cur);
        }
        return max;
    }

    // priorityQueue version: 记录pq的最大数量
    public int minMeetingRooms2(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0] == b[0] ? a[1]- b[1]: a[0]-b[0]);
        int max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1]-b[1]);
        for(int i =0; i < intervals.length;i++){
            while(!pq.isEmpty() && intervals[i][0] >= pq.peek()[1]){
                pq.poll();
            }
            pq.offer(intervals[i]);
            max = Math.max(max, pq.size());
        }
        return max;
    }
;
}
