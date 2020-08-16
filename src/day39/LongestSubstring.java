package day39;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    // Longest Substring Without Repeating Characters
// Given a string, find the length of the longest substring without repeating characters.

// For example, the longest substring without repeating letters for “abcabcbb” is “abc”, which the length is 3.

// For “bbbbb” the longest substring is “b”, with the length of 1.
    //O(n^2)
    public int longestSubString(String s){
        Set<Character> set;
        char[] arr = s.toCharArray();

        int sum = 0;
        int result = 0;
        for(int i = 0; i<arr.length; i++){
            set = new HashSet<>();
            sum = 0;
            for(int j =i;  j < arr.length; j++){
                if(!set.contains(arr[j])){
                    result = Math.max(result,sum++);
                    set.add(arr[j]);
                }
                else{
                    break;
                }
            }
        }
        return result;

    }

    //O(n)
    public int longestSubString2(String s){
        if(s == null){
            return 0;
        }
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int fast = 0;
        int sum = 0;
        int result = 1;
        for(int slow = 0; slow < arr.length; slow++){
            while(fast < arr.length && !set.contains(arr[fast])){
                sum++;
                set.add(arr[fast]);
                fast++;

            }
            if(set.contains(arr[fast])){
                result = Math.max(result, sum);
            }
            set.remove(arr[slow]);
            sum--;
        }
        return result;


    }

}
