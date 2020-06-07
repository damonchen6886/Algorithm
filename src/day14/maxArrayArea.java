package day14;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class maxArrayArea {
    //Given n non-negative integers representing the histogram's bar height
    // where the width of each bar is 1, find the area of largest rectangle in the histogram.
    //
    //[2,1,5,6,2,3]
    //histogram
    //Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
    public int maxAreaYimin(int[] array){
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        // key 1: 我们需要多压一轮0，对所有stack内元素进行清算，所以 i <= array.length
        for(int i = 0; i <= array.length; i++){
            int cur = i == array.length ? 0 : array[i];
            // key 2: 开始构造递增栈
            while(!stack.isEmpty() && array[stack.peek()] >= cur){

                int height = array[stack.pop()];
                // handle exceptions if stack is empty
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;  // 记得+1
                result = Math.max(result, height * ( i - left)); // 结算过程

            }
            stack.push(i);
        }
        return result;
    }

    public int maxArea(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int result = 0;

        //Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for(int i =0; i <= arr.length; i++){
            int cur = i == arr.length?  0 : arr[i];
            while(!stack.isEmpty() && cur <= arr[stack.peek()]){

                result = Math.max(result, ( i -stack.peek()+1 ) * arr[stack.peek()]);
                stack.pop();

            }
            stack.push(i);
        }
        return result;


    }


}
