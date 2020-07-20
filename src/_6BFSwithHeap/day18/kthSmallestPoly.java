package _6BFSwithHeap.day18;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class kthSmallestPoly {
//// Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.
//
//// Assumptions
//
//// K >= 1
//// Examples
//
//// the smallest is 3 * 5 * 7 = 105
//// the 2nd smallest is 3 ^ 2 * 5 * 7 = 315
//// the 3rd smallest is 3 * 5 ^ 2 * 7 = 525
//// the 5th smallest is 3 ^ 3 * 5 * 7 = 945
public int kth(int k){
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
    Set<Integer> visited = new HashSet<>();
    minHeap.offer(3*5*7);
    visited.add(3*5*7);
    while(k > 1){
        int cur = minHeap.poll();
        if(visited.add(3*cur)){
            minHeap.offer(3*cur);
        }
        if(visited.add(5*cur)){
            minHeap.offer(5*cur);
        }
        if(visited.add(7*cur)){
            minHeap.offer(7*cur);
        }
        k--;
    }
    return minHeap.peek();
}

    // PriorityQueue, Collection.sort implements Comparable or Comparator
    // Time : k^3
    public int kthSmllestPoly(int k){
        PriorityQueue<Integer> polynomial = new PriorityQueue<>();
        int cur = 3*5*7;
        polynomial.offer(cur);
        Set<Integer> dup = new HashSet<>();
        for(int i = 1;  i < k-1; i++){
            cur = polynomial.poll();
            dup.add(cur);
            if(!dup.contains(cur*3)){
                polynomial.offer(cur*3);
                dup.add(cur*3);
            }
            if(!dup.contains(cur*5)){
                polynomial.offer(cur*5);
                dup.add(cur*5);
            }
            if(!dup.contains(cur*5)){
                polynomial.offer(cur*7);
                dup.add(cur*7);
            }

        }
        return polynomial.peek();

    }


}
