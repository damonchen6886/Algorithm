package _4Stack.day13;

import java.util.Deque;
import java.util.LinkedList;

public class ParenthesisMatch {

    //Given a string containing just the characters'(',')','{','}','['and']', determine if the input string is valid.
    //An input string is valid if:
    //Open brackets must be closed by the same type of brackets.
    //Open brackets must be closed in the correct order.
    //Note that an empty string is also considered valid.
    //Example 1:
    //Input:
    // "()"
    //
    //Output:
    // true
    //Example 2:
    //Input:
    // "()[]{}"
    //
    //     ""
    //Output:
    // true

    public boolean isValid(String s){
        Deque<Character> stack = new LinkedList<>();
        // stack.push(s.charAt(0));
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' ||s.charAt(i) == '{'||s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }

            if(!stack.isEmpty() && match(stack.peek(), s.charAt(i))){
                stack.pop();

            }
            else{
                return false;
            }

        }

        return !stack.isEmpty();

    }
    private boolean match(char a, char b){

        return ( a == '(' && b == ')' || a == '{' && b == '}'|| a == '[' && b == ']');

    }


}
