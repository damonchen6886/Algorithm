package CornerCaseQuestions;

import java.util.HashMap;

public class RomantoNum {
    // leetcode 13
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result= 0;
        char[] arr = s.toCharArray();
        char prev = ' ';
        for(int i = 0;  i<arr.length;i++){
            char cur = arr[i];
            if((prev == 'I' && (cur == 'V' || cur=='X')) ||(prev == 'X' && (cur == 'L' || cur=='C')) ||(prev == 'C' && (cur == 'D' || cur=='M'))){
                result+=map.get(cur);
                result-= map.get(prev)*2;
                prev = cur;
                continue;
            }

            result+= map.get(cur);
            prev = cur;
        }
        return result;
    }

}
