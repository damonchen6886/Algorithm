package day2;

// 1.5 Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A. If there is a tie, the smaller elements are always preferred.
// Assumptions
// A is not null
// K is guranteed to be >= 0 and K is guranteed to be <= A.length
// Return
// A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.
// Examples
// A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
// A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}


// (1,4, 100, 101)
//     (x,x,x,y, x)

import day1.BST4;

import java.util.Arrays;

public class BS6 {

    int[] bs6(int[] arr, int target, int k){


        int[] result = new int[k];
        int left = 0;
        int right  = arr.length-1;
        int mid = 0;
        while(left < right -1){
            mid  = left + (right -left)/2;
            if(arr[mid] == target){
                break;
            }

            if (arr[mid] < target){

                    left = mid;
                }

            else{
                right = mid;
            }

        }

        int leftIdx = mid - 1;
        int rightIdx = mid + 1;
        result[0] = arr[mid];
        for(int i  = 1;  i < k; i++){
            if(leftIdx < 0){
                result[i] = arr[rightIdx++];
            }
            else if(rightIdx > arr.length-1){
                result[i] = arr[leftIdx--];
            }
            else if(Math.abs(arr[leftIdx] - target) > Math.abs(target - arr[rightIdx])){
                result[i] = arr[rightIdx++];
            }
            else{
                result[i] = arr[leftIdx--];
            }

        }

        return result;

    }



// Mthod2

    ///{-3,-1,0,1,3,9}
    public int[] KClosest(int[] array, int target, int k){
        // Sanity check
        if(array == null || array.length == 0) return array;
        if(k == 0) return new int[0]; // {}
        // step 1: find the largest Smaller Equal to target
        int left = largestSmallerEqual(array, target);
        int right = left + 1;
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            // case 1.0, left--
            // 1. right pointer is already out of bound
            // 2. right pointer is not out of bound, left pointer is not out of bound, you need to compare
            if(right >= array.length || left >= 0 && target - array[left] <= array[right] - target){
                result[i] = array[left--];
            } else {
                result[i] = array[right++];
            }
        }
        return result;
    }
    private int largestSmallerEqual(int[] array, int target){
        int left = 0, right = array.length - 1;
        while(left < right - 1){
            int mid = left + (right - left)/2;
            if(array[mid] <= target){
                left = mid;
            } else {
                right = mid;
            }
        }
        // two elements left, compare it from right to left
        if(array[right] <= target){
            return right;
        }
        if(array[left] <= target){
            return left;
        }
        // no element is smaller than target
        return -1;
    }


    public static void main(String[] args) {
        BS6 test = new BS6();
        int[] A = new int[]{1, 2, 3};
        int[] B = new int[]{1, 4, 6,8};
        int[] C = new int[]{1, 3,3 , 4};
        int[] D = new int[]{1,2,2,2,3};
        int[] E = new int[]{1, 2, 2, 2, 3, 4,5,6,7,12,34,64,78,123,222,321,356};
        System.out.println("expect: {2,1,3} " +  Arrays.toString(test.bs6(A,2,3)));
        System.out.println("expect: {4,1,6} " +  Arrays.toString(test.bs6(B,3,3)));
        System.out.println("expect: {5,6,7} " +  Arrays.toString(test.bs6(E,7,3)));
        System.out.println("expect: {2,1,3} " + Arrays.toString(test.KClosest(A,2,3)));
        System.out.println("expect: {4,1,6} " + Arrays.toString(test.KClosest(B,3,3)));
        System.out.println("expect: {5,6,7} " +  Arrays.toString(test.KClosest(E,7,3)));
//        System.out.println("expect: 3 " + test.bs6(D,2));
//        System.out.println("expect: 2 " + test.bs6(C,3));
//        System.out.println("expect: 3 " + test.bs6(E,2));

    }


}
