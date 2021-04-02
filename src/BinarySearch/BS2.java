
package BinarySearch.day1;

//1.1 Given a target integer T and an integer array A sorted in ascending order,
// find the index i in A such that A[i] is closest to T.(follow up of Q1)
//        Assumptions
//        There can be duplicate elements in the array, and we can return any of the indices with same value.
//        Examples
//        A = {1, 2, 3}, T = 2, return 1
//        A = {1, 4, 6}, T = 3, return 1
//        A = {1, 4, 6}, T = 5, return 1 or 2
//        A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
//        Corner Cases
//        What if A is null or A is of zero length? We should return -1 in this case.

public class BST2 {

    // step 1: sorted?
    //

    int BST2(int[] lst, int num){
        // corner case
        if(lst == null || lst.length == 0){
            return -1;
        }
        int left = 0;
        int right = lst.length-1;
        while(right >= left){
            int mid = (right +left) /2;

            // int mid = left + (right - left)/2
            if(lst[mid] == num){
                return mid;
            }

            if((right - left)< 2 && lst[mid] != num){
                return (Math.abs((num -lst[left] )) < Math.abs((lst[right]- num)))  ?  left: right;
            }


            if(lst[mid] > num){
                right = mid;
            }

            else{
                left = mid;
            }
        }
        return -1;
    }

    int bst2(int[] array, int target){
        // handle corner case
        if(array == null || array.length == 0) return -1;
        int left = 0, right = array.length - 1;
        // {x,x}
        while(left < right - 1){
            int mid = left + (right - left)/2;
            if(array[mid] == target) return mid;
            else if(array[mid] < target){
                left = mid;
            } else {
                right = mid;
            }
        }
        if(Math.abs(array[left] - target) < Math.abs(array[right] - target)){
            return left;
        }
        return right;
    }


    public static void main(String[] args) {
        BST2 test = new BST2();
        int[] A = new int[]{1, 2, 3};
        int[] B = new int[]{1, 4, 6};
        int[] C = new int[]{1, 3,3 , 4};
        int[] D = new int[]{};
        int[] E = new int[]{1, 2, 2, 2, 3, 4,5,6,7,12,34,64,78,123,222,321,356};
        System.out.println("expect: 1 " + test.BST2(A,2));
        System.out.println("expect: 1 " + test.BST2(B,3));
        System.out.println("expect: 1 " + test.BST2(B,5));
        System.out.println("expect: 1 " + test.BST2(C,2));
        System.out.println("expect: 8 " + test.BST2(E,8));

    }

}