package SlidingWindow;

import java.util.HashMap;

public class LonestSubstringwith2char159and340 {
    //  用sliding window 的做法
    // 用 HashMap 来记录加进去的char 如果是新的char count++
    // 如果新的char超过了两个 吧头部那个移除掉
    // 每次循环更新最大的长度result
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() == 0){
            return 0;
        }
        int left = 0;
        int result = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right< s.length();right++){
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r,0)+1);
            if(map.get(r) == 1){
                count++;
            }
            //2 可以替换成K  参考lc：340
            while(count >2){
                char l = s.charAt(left);
                map.put(l, map.get(l)-1);
                if(map.get(l) == 0){
                    count--;
                }
                left++;
            }
            result = Math.max(result,right-left+1);
        }
        return result;

    }
}
