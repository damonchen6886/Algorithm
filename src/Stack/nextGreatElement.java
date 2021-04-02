package Stack;

import java.util.*;

public class nextGreatElement {


// You are given two arrays (without duplicates)nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers fornums1's elements in the corresponding places ofnums2.
// The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
//     //  temperaturesT = [73, 74, 75, 71, 69, 72, 76, 73], your output should be[1, 1, 4, 2, 1, 1, 0, 0].
//     Example 1:          result =[3,2,-1,-1]2;
// Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
// Output: [-1,3,-1]
// Explanation:
//     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
//     For number 1 in the first array, the next greater number for it in the second array is 3.
//     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
// Input: nums1 = [2,4], nums2 = [1,2,3,4].
// Output: [3,-1]
// Explanation:
//     For number 2 in the first array, the next greater number for it in the second array is 3.
//     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.


    public int[] nextGreaterElement(int[] arr1, int[] arr2){

        if(arr1 == null || arr1.length ==0){
            return new int[0];
        }
        // key: array's value, value: next greater value
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[arr2.length];
        int[] finalResult = new int[arr1.length];
        Deque<Integer> stack = new LinkedList<>();

        for(int i = 0; i < arr2.length; i++){
            while(!stack.isEmpty() && arr2[i] > arr2[stack.peek()]){

                int index = stack.pop();
//                 result[i]  = i -index;
//                  map.put(i, result[i]);
                map.put(arr2[index],arr2[i]);
            }

            stack.push(i);
        }
        for(int j = 0; j < arr1.length; j++){
            finalResult[j] = map.get(j);
        }
        return finalResult;

    }



        // Follow2:
    // Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
    // Example 1:
    // Input:
    // [1,2,1]
    // [1,2,1,1,2,1]
    // Output:
    //  [2,-1,2]

    // Explanation:
    //  The first 1's next greater number is 2;


    // The number 2 can't find next greater number;


    // The second 1's next greater number needs to search circularly, which is also 2.

    public int[] nextGreaterElement2(int[] arr1){

        if(arr1 == null || arr1.length ==0){
            return  new int[0];
        }
        // key: array's value, value: next greater value
        Map<Integer, Integer> map = new HashMap<>();
        int[] array2 = new int[2* arr1.length];
        for(int x= 0 ; x < arr1.length; x++){
            array2[x] = arr1[x];
            array2[arr1.length+x] = arr1[x];

        }


        int[] finalResult = new int[arr1.length];
        Deque<Integer> stack = new LinkedList<>();

        for(int i = 0; i < array2.length; i++){
            while(!stack.isEmpty() && array2[i] > array2[stack.peek()]){

                int index = stack.pop();
//                 result[i]  = i -index;
//                  map.put(i, result[i]);
                map.put(array2[index],array2[i]);
            }

            stack.push(i);
        }
        for(int j = 0; j < arr1.length; j++){
            finalResult[j] = map.get(j);
        }
        return finalResult;

    }

    public int[] nextGreaterII(int[] nums){
        int len = nums.length;
        int[] result = new int[len];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = 0; i < 2 * len; i++){
            while(!stack.isEmpty() && nums[i%len] > nums[stack.peek()]){
                int index = stack.pop();
                result[index] = nums[i%len];
            }
            stack.push(i%len);
        }
        return result;
    }


}
