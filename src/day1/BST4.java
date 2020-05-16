package day1;

public class BST4 {

    int bst4(int[] array, int target){
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
                    left = mid;
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

    public static void main(String[] args) {
        BST4 test = new BST4();
        int[] A = new int[]{1, 2, 3};
        int[] B = new int[]{1, 4, 6};
        int[] C = new int[]{1, 3,3 , 4};
        int[] D = new int[]{1,2,2,2,3};
        int[] E = new int[]{1, 2, 2, 2, 3, 4,5,6,7,12,34,64,78,123,222,321,356};
        System.out.println("expect: 1 " + test.bst4(A,2));
        System.out.println("expect: -1 " + test.bst4(A,4));
        System.out.println("expect: 3 " + test.bst4(D,2));
        System.out.println("expect: 2 " + test.bst4(C,3));
        System.out.println("expect: 3 " + test.bst4(E,2));

    }
}
