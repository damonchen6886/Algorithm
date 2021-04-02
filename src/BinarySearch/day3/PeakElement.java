package _1BinarySearch.day3;

//2.2 A peak element is an element that is greater than its neighbors.
//        Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
//        The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//        You may imagine that num[-1] = num[n] = -∞.
//        For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2
//
//     *      *           *
//   *         *        *   *        *   *
// *            *                      *
// case1     case2       case3       case4

public class PeakElement {


    public int findElement(int[] array){
        int left = 0;
        int right = array.length-1;

        while(left <= right){
            int mid = left +(right -left)/2;


            //case 1
         if(array[mid-1] < array[mid] && array[mid]  < array[mid+1] ){
                left = mid+1;
            }
            //case 2
            else if(array[mid-1] > array[mid] && array[mid]  > array[mid+1]){
                right  = mid-1;
            }
            //case 3
            else if( array[mid] > array[mid-1] &&array[mid] > array[mid + 1]){
                return mid;
            }
            //case 4
            else{
                left = mid+1;
            }

        }

        return -1; // if the peak does not exist

    }


    // Method 2


    //  num[i] ≠ num[i+1]
    public int findPeak(int[] array){
        if(array == null || array.length == 0) return -1;
        int left = 0, right = array.length -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(mid == 0 || mid == array.length - 1){
                // todo ...
            }
            if(mid < array.length - 1 && array[mid] < array[mid+1]){
                left = mid + 1;
            } else if(mid > 0 && array[mid] < array[mid-1]){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}


// conclusion: Avoid infinity loop while using binary search: when to use
//    Situation 1: while(left<=right)  left =mid +1 or right =mid -1
//    Situation 2: while(left < right -1)  left = mid or right = mid
// when the current search value is needed in next search or current search value might be the final answer, Go situation 1;
// Sure that the current search value is not needed and wont be the final answer. Go situation 2
// Example:
// situation 1: find target value in array
// situation 2: find first occurrence, find the closest (max, min)number for target.

