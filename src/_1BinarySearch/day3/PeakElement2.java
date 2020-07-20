package _1BinarySearch.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 2.3 Find Peak Element II
// There is an integer matrix which has the following features:
// The numbers in adjacent positions are different.
// The matrix has n rows and m columns.
// For all i < m, A[0][i] < A[1][i] && A[n – 2][i] > A[n – 1][i].
// For all j < n, A[j][0] < A[j][1] && A[j][m – 2] > A[j][m – 1].
// We define a position P is a peak if:
//   A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
//   Find a peak element in this matrix. Return the index of the peak.
// Notice
//   The matrix may contains multiple peeks, find any of them.
// Example
// Given a matrix:
// [
// [1 ,2 ,3 ,6 ,5],
// [16,41,23,22,6],
// [15,17,24,21,7],
// [14,18,19,20,10],
// [13,14,11,10,9]
// ]
// return index of 41 (which is [1,1]) or index of 24 (which is [2,2])
public class PeakElement2 {

    public List<Integer> findPeakII(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }
        int m = matrix.length, n = matrix[0].length;
        // find(x_left, x_right, y_left, y_right, matrix)
        return find(1, m-2, 1, n-2, matrix, true);
    }



    private List<Integer> find(int x1, int x2, int y1, int y2, int[][] matrix, boolean flag){

        if(flag){
            int mid = y1 + (y2 - y1)/2;
            int index = x1; // record the max value in current row
            for(int i = x1; i < x2; i++){
                if(matrix[i][mid] > matrix[i][index]){
                    index = i;
                }
            }
            if(matrix[index][mid-1] > matrix[index][mid]){
                return find(x1, x2, y1, mid - 1, matrix, !flag);
            } else if(matrix[index][mid+1] > matrix[index][mid]){
                return find(x1, x2, mid+1, y2, matrix, !flag);
            } else {
                return new ArrayList<Integer>(Arrays.asList(index, mid));
            }
        } else {
            int mid = x1 + (x2 - x1)/2;
            int index = y1;
            for(int i = y1; i < y2; i++){
                if(matrix[mid][i] > matrix[mid][index]){
                    index = i;
                }
            }
            if(matrix[mid-1][index] > matrix[mid][index]){
                return find(x1, mid - 1, y1, y2, matrix, !flag);
            } else if(matrix[mid+1][index] > matrix[mid][index]){
                return find(mid + 1, x2, y1, y2, matrix, !flag);
            } else {
                return new ArrayList<Integer>(Arrays.asList(index, mid));
            }
        }

    }
}

// Flag: indicates whether cut vertically or horizontally.

//
//[
//        [1 ,2 ,3 ,6 ,5],
//        [16,41,29,22,6],
//        [15,17,24,21,7],
//        [14,18,19,20,10],
//        [13,14,11,10,9]
//        ]

// next:
//[
//        [1 ,2 ,3 ,6 ,5],
//        [16,41,29,22,6],
//        [15,17,24,21,7],
//        ]


// next:
//[
//        [1 ,2 ,3],
//        [16,41,29],
//        [15,17,24],
//        ]

// time: m: rows. n: columns;
//   O(nlogm)