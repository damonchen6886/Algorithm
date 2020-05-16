package day1;

import java.util.Arrays;

public class BST5 {


    int[] bst5(int[][] array, int target){
        int left = 0;
        int rows = array.length;
        int cols = array[0].length;
        int right = rows * cols - 1;

        while(left <= right){
            int mid = left +(right- left)/2;
            // x,y
            int row = mid / cols;
            int col = mid % cols;
            if(array[row][col] ==  target){
                return new int[]{row, col};
            }
            if (array[row][col] < target){
                left = mid + 1;
            }
            else{
                    right = mid -1;

                }

            }
        return new int[]{-1,-1};
        }

    public static void main(String[] args) {
        BST5 test = new BST5();
        int[][] matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} };
        System.out.println("expect: {1,2} " + Arrays.toString(test.bst5(matrix,7)));
        System.out.println("expect: {-1,-1} " + Arrays.toString(test.bst5(matrix,6)));
        System.out.println("expect: {1,1} " + Arrays.toString(test.bst5(matrix,5)));


    }
}
