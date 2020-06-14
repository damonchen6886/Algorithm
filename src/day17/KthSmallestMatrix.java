package day17;

public class KthSmallestMatrix {
    //Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.
    //
    //Assumptions
    //
    //               resultlst (1 2,3,3)  3 2
    //
    //the matrix is not null, N > 0 and M > 0
    //K > 0 and K <= N * M
    //Examples
    //
    //count = 2
    //heap [,3,4,5]
    // {{1,  3,   5,  7},
    //
    //  {2,  4,   8,  9},
    //
    //  {3,  5, 11,  15},
    //
    //  {6,  8, 13,  18}}
    //
    //the 5th smallest number is 4
    //the 8th smallest number is 6


    // DFS, BFS1(Breath First Search), BFS2(Best First Search)

    // BFS1:
    //    marker, queue

    // BFS2:
    //    marker, priorityqueue

    // Binary Search(for its value)
    public int kthSmallest(int[][] matrix, int k){
        int m = matrix.length;
        int n = matrix[0].length;
        int left = matrix[0][0], right = matrix[m][n];
        while(left < right){
            int mid = left + (right - left)/2;
            int count = 0, j = m-1;
            for(int i = 0; i < m; i++){
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j+1);
            }
            if(count < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
