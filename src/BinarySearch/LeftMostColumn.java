package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class LeftMostColumn {
    //A row-sorted binary matrix means that all elements are 0 or 1 and each row of the matrix is sorted in non-decreasing order.
    //
    //Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) of the leftmost column with a 1 in it.
    // If such an index does not exist, return -1.
    //
    //You can't access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:
    //
    //BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
    //BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of 2 elements [rows, cols],
    // which means the matrix is rows x cols.
    //Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. Also,
    // any solutions that attempt to circumvent the judge will result in disqualification.
    //
    //For custom testing purposes, the input will be the entire binary matrix mat.
    // You will not have access to the binary matrix directly.

    //Input: mat = [[0,0],[1,1]]
    //Output: 0
    // Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
    //Output: 1

    class BinaryMatrix {
        int[][] matrix;
        public BinaryMatrix(int[][] content){
            this.matrix = content;
        }
        public int get(int row, int col) {
            return this.matrix[row][col];
        }
        public List<Integer> dimensions() {
            return new ArrayList<>(List.of(matrix.length,matrix[0].length));
        }
 }

    public int leftMostColumnWithOne1(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int row = dimension.get(0);
        int col = dimension.get(1);
        int x = 0;
        int y = col-1;
        int result = -1;
        while(y >=0 && x < row){
            if(binaryMatrix.get(x,y) ==1){
                result = y;
                y--;
            }
            else{
                x++;
            }
        }
        return result;
    }

    // approach 2 with optimization
    public int leftMostColumnWithOne2(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int row = dim.get(0);
        int col = dim.get(1);
        int leftMost = col;
        for (int i = 0; i < row; i++) {
            int left = 0;
            int right = leftMost;
            while (left < right) {
                int mid = left + (right - left)/2;
                if (binaryMatrix.get(i, mid) == 1) {
                    right = mid;
                }
                else {
                    left = mid+1;
                }
            }
            leftMost = left;
        }
        return leftMost == col ? -1 : leftMost;
    }




    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int rows = dimension.get(0);
        int cols = dimension.get(1);
        int min = Integer.MAX_VALUE;
        int count =0;
        for(int i =0 ;i < rows;i++){
            int curLeft = bst(binaryMatrix, i, cols);
            if(curLeft == -1){
                count++;
                continue;
            }
            min = Math.min(min, curLeft);
        }
        return count== rows? -1:min;
    }
    private int bst(BinaryMatrix binaryMatrix,int rows, int cols){
        int left = 0;
        int right = cols-1;
        if(binaryMatrix.get(rows,cols-1) ==0){
            return -1;
        }
        while(left< right){
            int mid = left+ (right-left)/2;
            if(binaryMatrix.get(rows, mid) == 1){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return right;
    }
}
