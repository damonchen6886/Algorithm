package Notes.SlidingWindow;

import java.util.HashMap;

public class LongestRepeatingChar424 {
    // 计算char最多出现的次数 然后如果array的长度（左右两边index的差）减去最多出现的次数 比题目给的K大 就把左边的pointer 往右移
    // map 里面同时减少当前char的次数 更新result
    // ref: https://leetcode.com/problems/longest-repeating-character-replacement/discuss/591288/Java-O(n)-solution-using-Sliding-Window-with-Explanation
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left =0;
        int count =0;
        int result =0;
        int maxRepeat = 0;
        for(int right =0; right < s.length(); right++){
            char r = s.charAt(right);

            map.put(r, map.getOrDefault(r,0)+1);
            maxRepeat = Math.max(maxRepeat, map.get(r));

            while(right-left+1 - maxRepeat >k){
                char l = s.charAt(left);
                map.put(l, map.getOrDefault(l,0)-1);
                left++;
            }
            result = Math.max(result, right-left+1);

        }
        return result;
    }

}
