package Notes;

import java.util.ArrayList;
import java.util.List;
//思路： 先开一个26字母表大小的array 来记录 每个字母 最后出现的位置；
// 再遍历一遍给的string 来查找 每一个index 最后出现的位置 如果当前的位置就是最后出现的位置  加入到结果集中

// 难点： 如果理解 最后出现的位置 就是 array[0,i]这段里面每个字母的最后出现的位置
//
public class PartitionLabels763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] table = new int[26];
        for(int  i =0 ; i < s.length();i++){
            // record the last occurance of each letter
            table[s.charAt(i)- 'a'] = i;
        }
        int start = 0;
        int last = 0;
        for(int i = 0; i < s.length();i++){
            last = Math.max(table[s.charAt(i) - 'a'],last);
            if(last == i){
                result.add(last-start+1);
                start = last+1;
            }
        }
        return result;
    }
}
