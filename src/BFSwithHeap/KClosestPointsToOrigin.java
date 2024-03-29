package BFSwithHeap;
//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
//
//The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
//
//You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

//Input: points = [[1,3],[-2,2]], k = 1
//Output: [[-2,2]]
//Explanation:
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

//        ^
//        |
//        |      x2
//        |   x1
//        |
//--------0------------>
//        |
//        |
//        |
//        |

import java.util.Arrays;
import java.util.PriorityQueue;

// 973
public class KClosestPointsToOrigin {
    // N(logK);
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((b, a)-> a[0]*a[0]+a[1]*a[1] - b[0]*b[0]-b[1]*b[1]);
        for(int[] p : points){
            pq.offer(p);
            if(pq.size()> k){
                pq.poll();
            }
        }
        int[][] result = new int[k][2];
        while(!pq.isEmpty()){
            result[--k] = pq.poll();
        }
        return result;
    }

    // N(logN);
    public int[][] kClosest2(int[][] points, int k) {
        Arrays.sort(points, (a, b)-> a[0]*a[0]+a[1]*a[1]- b[0]*b[0]-b[1]*b[1]);
        return Arrays.copyOfRange(points, 0,k);

    }
}
