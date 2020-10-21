package Notes;

import java.util.*;

public class MinimumRemoveValidParentheses1249 {
    //标准stack + HashSet做法
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() ==0){
            return null;
        }
        Set<Integer> set = new HashSet<>();
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< s.length();i++){
            //char cur = s.charAt(i);
            if(s.charAt(i) == ('(')){
                stack.push(i);
            }
            if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    set.add(i);
                }
            }
        }
        if(set.size() == 0 && stack.isEmpty()){
            return s;
        }
        // 加上stack里面的index
        while(!stack.isEmpty()){
            set.add(stack.pop());
        }

        for(int i =0; i<s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }

    // 用arr 代替hashset 存出界的 index
    // 运行速度比第一个快 时间复杂度比第一个高（因为有sort）
    public String minRemoveToMakeValid2(String s) {
        if(s == null || s.length() ==0){
            return null;
        }
        List<Integer> arr = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< s.length();i++){
            //char cur = s.charAt(i);
            if(s.charAt(i) == ('(')){
                stack.push(i);
            }
            if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    arr.add(i);
                }
            }
        }
        if(arr.size() == 0 && stack.isEmpty()){
            return s;
        }
        while(!stack.isEmpty()){
            arr.add(stack.pop());
        }
        int idx = 0;
        Collections.sort(arr);
        for(int i =0; i<s.length();i++){
            if(idx< arr.size() &&i == arr.get(idx)){
                idx++;
                continue;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    // 不用stack O(1) space
    public String minRemoveToMakeValid3(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                open++;
            else if (c == ')') {
                if (open == 0) continue;
                open--;
            }
            sb.append(c);
        }

        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && open-- > 0) continue;
            result.append(sb.charAt(i));
        }

        return result.reverse().toString();
    }
}
