package OA.eBay;

import java.util.HashSet;
import java.util.Set;

public class isSubmatrixFull {
//一个3*n数组，以3*3的窗口去扫，判断每个小窗口是不是1-9的数字齐全
    public boolean isFull(int[][] matrix){
        Set<Integer> set = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        for(int i =0 ;i < row; i++){
            if(i%3 ==0 ){
                set = new HashSet<>();
                count = 0;
            }
            for(int j = 0; j < 3;j++){
                set.add(matrix[i][j]);
                count++;
            }
            // check set size ==9
            if(count == 9){
                if(set.size() !=9){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9},{9,8,7},{6,5,4},{3,2,1},{1,4,7},{2,5,8},{3,6,9}};
        int[][] arr2 = new int[][]{{1,2,3},{7,8,9},{9,8,7},{4,5,6},{6,5,4},{3,2,1},{1,4,7},{2,5,8},{3,6,9}};
        isSubmatrixFull is = new isSubmatrixFull();
        System.out.println(is.isFull(arr));
        System.out.println(is.isFull(arr2));
    }
}
