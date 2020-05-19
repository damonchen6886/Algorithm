package day1;
//1.2 Given a target integer T and an integer array A sorted in ascending order,
// find the index of the first occurrence of T in A or return -1 if there is no such index. （follow up of Q1）
//        Assumptions
//        There can be duplicate elements in the array.
//        Examples
//        A = {1, 2, 3}, T = 2, return 1
//        A = {1, 2, 3}, T = 4, return -1
//        A = {1, 2, 2, 2, 3}, T = 2, return 1
//        Corner Cases
//        What if A is null or A of zero length? We should return -1 in this case.

public class BST3 {

    int bst3(int[] array, int target){
        if(array == null || array.length ==0){
            return -1;
        }
        int left =0 ;
        int right  = array.length-1;

        while( left <= right){
            int mid = left + (right -left) /2;
            if(array[mid] ==target){
                if((right - left) < 2){
                    return mid;
                }
                else{
                    right = mid;
                }

            }
            if(array[mid] > target){
                right = mid-1;
            }
            else if (array[mid] < target){
                left = mid + 1;
            }

        }
        return -1;

    }

    // O(logn)
    int BST3(int[] array, int target){
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0, right = array.length - 1;
        while(left < right - 1){
            int mid = left + (right - left)/2;
            if(array[mid] >= target){
                right = mid;
            } else {
                left = mid;
            }
        }
        if(array[left] == target){
            return left;
        } else if (array[right] == target){
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        BST3 test = new BST3();
        int[] A = new int[]{1, 2, 3};
        int[] B = new int[]{2, 2};
        int[] C = new int[]{1, 3,3 , 4};
        int[] D = new int[]{1,2,2,2,3};
        int[] E = new int[]{1, 2, 2, 2, 3, 4,5,6,7,12,34,64,78,123,222,321,356};
        System.out.println("expect: 1 " + test.bst3(A,2));
        System.out.println("expect: -1 " + test.bst3(A,4));
        System.out.println("expect: 1 " + test.bst3(D,2));
        System.out.println("expect: 1 " + test.bst3(C,3));
        System.out.println("expect: 1 " + test.bst3(E,2));
        System.out.println("expect: -1 " + test.bst3(E,8));
        System.out.println("expect: 0 " + test.bst3(B,2));


    }

}
