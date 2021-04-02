package DynamicProgramming;

public class LongestIncreasingSubsequence {
//        [10,9,2,5,3,7,101,18]
//                [2,3,7,101]
//                [2,3,7,18]
    // O(nlogn);
    // Assumption: all given element are positive
    public int longestSubsequence(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        // record an monotonous increasing array
        int[] tbl = new int[array.length + 1];
        //int[] result = new int[array.length];
        int result = 1;
        tbl[1] = array[0];
        for(int i = 1; i < array.length; i++){
            // find the largest value smaller than array[i]
            int index = find(tbl, 1, result, array[i]);
            if(index == result){
                tbl[++result] = array[i];
            } else {
                tbl[index+1] = array[i];
            }
        }
        return result;
    }
    private int find(int[] tbl, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left)/2;
            if(tbl[mid] >= target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}
