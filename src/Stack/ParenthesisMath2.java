package Stack;

import java.util.Deque;
import java.util.LinkedList;

public class ParenthesisMath2 {
    //Fellow 1:
    //Given a string containing just the characters'('and')', find the length of the longest valid (well-formed) parentheses substring.
    //Input:
    // "(())"
    // "()[]{}["
    //Output:
    // 2
    //
    //Explanation:
    // The longest valid parentheses substring is
    //"()"
    //    "()(())"
    //
    // '()((()))()'
    //     '()((()()()()())'

    public int longest(String s){
        Deque<Integer> stack = new LinkedList<>();
        int len = s.length();
        int result = 0;
        stack.push(-1);
        for(int i = 0; i < len; i++){
            // case 1: "("
            if(s.charAt(i) == '('){
                stack.push(i);
            } else {
                // case 2: ")"
                stack.pop();
                // handle the empty stack problem
                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }



}
