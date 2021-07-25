package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class minWindow {

    //Minimum Window Substring
    //Given a string source and a string target, find the minimum window in source which will contain all the characters in target.
    //
    //
    //REPORT THIS AD
    //
    //If there is no such window in source that covers all characters in target, return the emtpy string “”.
    //
    //If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.
    //
    //Clarification
    //
    //Should the characters in minimum window has the same order in target?
    //
    //Not necessary.
    //
    //Example
    //
    //For source = “ADOBECODEBANC”, target = “ABC”, the minimum window is “BANC”
    //

    public String minWindow(String source, String target){
        if(source == null || target == null || target.length() < source.length()){
            return "";
        }
        // Construct a map
        Map<Character, Integer> dict = constructDict(target);
        //sliding window
        int slow = 0, fast = 0, res = Integer.MAX_VALUE, matchCount = 0, start = 0;
        for(; fast < target.length(); fast++){
            // case 1: when the composition is not completed
            char c = target.charAt(fast);
            Integer count = dict.get(c);
            if(count == null){
                continue;
            } else if(count == 1){
                matchCount++;
                dict.put(c, count-1);
            } else {
                dict.put(c, count-1);
            }

            while(matchCount == dict.size()){
                c = target.charAt(slow);
                count = dict.get(c);
                if(count == null){
                    slow++;
                } else if(count < 0){
                    dict.put(c, count+1);
                    slow++;
                } else if(count == 0){
                    dict.put(c, count+1);
                    matchCount--;
                    res = Math.max(res,fast-slow+1);
                    start = slow;
                }
                slow++;
            }
        }
        return source.substring(start, start+res);



    }

//    taraget = abba
//            source = abbbbbbbbbbbca
//    {a: 0, b: -7}
//    {a:2, b:2} matchCount = 1
//    abbc
    private Map<Character, Integer> constructDict(String target){
        Map<Character, Integer>  map = new HashMap<Character, Integer>();
        for(char c : target.toCharArray()){
            Integer count = map.get(c);
            if(count == null){
                map.put(c, 1);
            } else {
                map.put(c, count+1);
            }
        }
        return map;
    }
}
