package day3;

// 2.5 Rotated Sorted Array
// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
// Find the minimum element.
// You may assume no duplicate exists in the array.

public class RotateSortedArray {


    public int roateSortArray(int[] array){
        if(array == null || array.length == 0){
            return  -1;
        }
        int left = 0;
        int right = array.length-1;
        int mid=0;
        while(left < right-1){
            mid = left +(right-left)/2;
            if(array[mid] > array[left] || array[mid] > array[right]){
                left = mid;

            }
            else if(array[mid] < array[mid+1] && array[mid] < array[mid-1]){
                break;
            }
            else{
                right = mid;
            }


        }
        return array[mid];
    }



    public static void main(String[] args) {
        RotateSortedArray test = new RotateSortedArray();
        int[] A = new int[]{4,5,6,7,0,1,2};
        int[] B = new int[]{4,5,6,7,0,1,2,3};
        System.out.println("expected 0 "+ test.roateSortArray(A));

    }
}

//   (mid > left): answer is on the right
//   (mid < right): answer is on the left
//   (mid > right): answer is on the right
//   (mid < left) : answer is on the left
