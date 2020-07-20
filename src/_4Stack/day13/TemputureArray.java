package _4Stack.day13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class TemputureArray {

    //Given a list of daily temperaturesT, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
    //For example, given the list of temperaturesT = [73, 74, 75, 71, 69, 72, 76, 73], your output should be[1, 1, 4, 2, 1, 1, 0, 0].
    //Note:The length oftemperatureswill be in the range[1, 30000]. Each temperature will be an integer in the range[30, 100].
    //
    //

    //
    public int[] warmer(int[] tem){
        if(tem == null || tem.length == 0){
            return new int[0];
        }
        int[] res = new int[tem.length];
        // if you are using monntonous stack, record the index
        Deque<Integer> stack = new LinkedList<>();
        for(int i = tem.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && tem[i] >= tem[stack.peek()]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    // method 2: from left to right:
    public int[] warmerfromstart(int[] temp){
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] result  = new int[temp.length];
        for(int i =0; i < temp.length;i++){
            while(!stack.isEmpty() && temp[i] > temp[stack.peek()]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }




}
