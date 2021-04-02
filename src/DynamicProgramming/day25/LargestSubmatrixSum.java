package day25;

public class LargestSubmatrixSum {

    //Given a matrix that contains integers, find the submatrix with the largest sum.
    //
    //Return the sum of the submatrix.
    //
    //Assumptions
    //
    //The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
    //Examples
    //
    //{ {1, -2, -1, 4},
    //
    //  {1, -1,  1, 1},
    //
    //  {0, -1, -1, 1},
    //
    //  {0,  0,  1, 1} }
    //
    //the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.

    public int subArraySum(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        int cur = array[0];
        int result = array[0];
        for(int i = 1; i < array.length; i++){
            cur = Math.max(cur + array[i], array[i]);
            result = Math.max(cur, result);
        }
        return result;
    }

    public int subMatrixSum(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int column  = matrix.length;
        int row = matrix[0].length;
        int result = 0;
        int cur = 0;
        for(int i = 0; i < column; i++){
            int[] dp = new int[column];
            for(int j = i; j < column; j++){
                flat(dp, matrix[j]);
                cur = subArraySum(dp);
                result = Math.max(result, cur);
            }
        }
        return result;
    }
    private void flat(int[]dp, int[] matrix){
        for(int i = 0 ; i < matrix.length; i++){
            dp[i] += matrix[i];
        }
    }


}
