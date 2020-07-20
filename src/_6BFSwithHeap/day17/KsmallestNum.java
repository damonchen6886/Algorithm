package _6BFSwithHeap.day17;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KsmallestNum {
    //Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.
    //
    //Assumptions
    //
    //A is not null
    //K is >= 0 and smaller than or equal to size of A
    //Return
    //
    //an array with size K containing the K smallest numbers in ascending order
    //Examples
    //
    //A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
    //
    //result = {1,3,4}  2 ->   5 k*(n-k) = nk - k^2
    //
    //    {1,3,2,4,5}
    //    cur =max.min
    //    int[] result  = new int[k];
    //
    //
    public int[] kSmallestInt(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            pq.offer(arr[i]);

        }
        int[] result = new int[k];
        for(int j = 0; j<k; j++){

            result[j] = pq.poll();
        }
        return result;
    }

    public int[] kSmallest(int[] array, int k){
        // corner case
        if(array.length == 0 || k == 0){
            return new int[0];
        }
        // nlogk
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(o1.equals(o2)){
                    return 0;
                }
                return o1 > o2 ? -1:1;
            }
        });
        for(int i = 0; i < array.length; i++){
            if(i < k){
                maxHeap.offer(array[i]);
            } else if(array[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--){
            result[i] = maxHeap.poll();
        }
        return result;
    }


}
