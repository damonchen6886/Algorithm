package BinarySearch.day1;

// 1. Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.
// Assumptions
// There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
// Examples
// A = {1, 2, 3, 4, 5}, T = 3, return 2
// A = {1, 2, 3, 4, 5}, T = 6, return -1
// A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3
// Corner Cases
// What if A is null or A is of zero length? We should return -1 in this case.


public class BST1 {



    int BST1(int[] lst, int num){
        if(lst.length == 0 ||lst.length == 0){
            return -1;
        }
        int left = 0;
        int right = lst.length-1;
        while(right >= left){
            int mid = (right +left) /2;
            if(lst[mid] == num){
                return mid;
            }
            if(lst[mid] >= num){
                right = mid-1;
            }

            else{
                left = mid+1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        BST1 test = new BST1();
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[] B = new int[]{1, 2, 3, 4, 5};
        int[] C = new int[]{1, 2, 2, 2, 3, 4};
        int[] D = new int[]{};
        int[] E = new int[]{1, 2, 2, 2, 3, 4,5,6,7,12,34,64,78,123,222,321,356};
        System.out.println("expect: 2 " + test.BST1(A,3));
        System.out.println("expect: -1 " + test.BST1(B,6));
        System.out.println("expect: 2 " + test.BST1(C,2));
        System.out.println("expect: -1 " + test.BST1(C,7));
        System.out.println("expect: -1 " + test.BST1(D,2));
        System.out.println("expect: 2 " + test.BST1(C,2));
        System.out.println("expect: 11 " + test.BST1(E,64));
    }

}

