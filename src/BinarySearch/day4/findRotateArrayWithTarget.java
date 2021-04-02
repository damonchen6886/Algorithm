package _1BinarySearch.day4;

public class findRotateArrayWithTarget {

//    3.1  Rotated Sorted Array
//    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//            (i.e.,[0,1,2,4,5,6,7]might become[4,5,6,7,0,1,2]).
//    You are given a target value to search. If found in the array return its index, otherwise return-1.
//    You may assume no duplicate exists in the array.
//    Your algorithm's runtime complexity must be in the order of O(log n).


    public static int searchI(int[] array, int target){
        if( array==null || array.length == 0) return -1;
        int left = 0, right = array.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid] == target){
                return mid;
            }
            // step 1: 找单调区间
            // step 2: 判断答案是否再单调区间内，在的话，->去，否则，去相反区间
            if(array[mid] > array[right]){
                // rotated index is on the right, so the left half should be monotone increasing
                if(target < array[mid] && target >= array[left]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // array[mid] <= array[right], rotated index is on the left
                if(target > array[mid] && target <= array[right]){
                    left = mid + 1;
                } else {
                    right = mid -1;
                }

            }
        }
        return -1;
    }


//3.2  Rotated Sorted Array II
//    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//            (i.e.,[0,0,1,2,2,5,6]might become[2,5,6,0,0,1,2]).
//    You are given a target value to search. If found in the array returntrue, otherwise return false.

    public static int searchII(int[] array, int target){
        if( array==null || array.length == 0) return -1;
        int left = 0, right = array.length - 1;
        while(left <= right){
            //重点，这个去重的办法

            int mid = left + (right - left)/2;
            if(array[mid] == target){
                return mid;
            }

            if(array[mid] > array[right]){
                // rotated index is on the right, so the left half should be monotone increasing
                if(target < array[mid] && target >= array[left]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // array[mid] <= array[right], rotated index is on the left
                if(target > array[mid] && target <= array[right]){
                    left = mid + 1;
                } else {
                    right = mid -1;
                }

            }
            while(left < right && array[left] == array[left+1]) left++;
            while(left < right && array[right] == array[right-1]) right--;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = new int[]{4,5,6,7,0,1,2};
        int index = searchI(array, 0);
        System.out.println(index);
    }
}
