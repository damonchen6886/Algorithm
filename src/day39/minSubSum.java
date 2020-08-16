package day39;

public class minSubSum {

    // Minimum Size Subarray Sum
// Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn’t one, return -1 instead.

// Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
    //O(2n)
    // result should be array
    public int minSub(int[] array, int s){
        // sliding window template
        int fast = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        // template start
        for(int slow = 0; slow < array.length; slow++){
            while(fast < array.length && sum < s){
                sum += array[fast];
                fast++;
            }
            if(sum >= s){
                res = Math.min(res, fast - slow);
            }
            sum -= array[slow];
        }
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }


    // O(n^2)
    public int[] minSubSum(int[] arr, int s){
        int sum = 0;
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        for(int i = 0; i< arr.length; i++){
            sum = 0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                if(sum >= s && end-start <= length){
                    start = i;
                    end = j;
                    length = end -start + 1;
                    break;
                }
            }
        }
        int[] result = new int[length];
        int ite =0;
        for(int i =start; i <= end; i++){
            result[ite] = arr[i];
            ite++;
        }
        return result;
    }

}
