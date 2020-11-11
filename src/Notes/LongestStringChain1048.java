package Notes;

import java.util.Arrays;
import java.util.HashMap;

public class LongestStringChain1048 {


    // 思路： 先把array根据长度来sort
    // 然后建立hashmap来动态存储每加一个char的 结果最优值
    // 从小到大 在string的每一个位置上尝试去掉当前char 来检查 比他长度短1的stirng 有没有在hashmap里面 如果有就是最佳值
    // hashmap解决了 有分支的情况（多个位置都满足）
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < words.length; i++){
            int best = 0;
            for(int j = 0; j < words[i].length();j++){
                String word = words[i].substring(0,j) + words[i].substring(j+1);
                best = Math.max(best, map.getOrDefault(word,0)+1);
            }
            map.put(words[i],best);
            result =Math.max(result,best);
        }
        return result;


    }
}
