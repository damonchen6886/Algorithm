package Notes;

import java.util.Arrays;
import java.util.HashMap;

// 思路： 先sort array 根据 item[i][0] 大小 再根据item[i][1]大小；
// 建hashmap存每个student 有几个成绩 key： student value：grade
// 因为sort过 所以从左往右区 每一个学生的 前五个成绩 计算average就行

// 恶心的地方： 创建haskmap的时候  取前五个成绩的时候的index细节有问题

public class HighFive1086 {
    class Solution {
        public int[][] highFive(int[][] items) {
            Arrays.sort(items,(a, b)-> a[0] !=b[0] ? a[0] - b[0] : a[1] == b[1] ? a[1]: b[1]- a[1]);
            Arrays.toString(items);
            HashMap<Integer,Integer> map = new HashMap<>();
            int ct= 1;
            map.put(items[0][0],ct);
            for(int i = 1; i < items.length;i++){
                if(items[i][0] == items[i-1][0]){
                    map.put(items[i][0], ++ct);
                }else
                {
                    ct = 0;
                    map.put(items[i][0], ++ct);
                }
            }


            int count = 1;
            int sum = items[0][1];
            int index = 0;
            int[][] result = new int[map.size()][2];
            for(int i = 1; i < items.length;i++){
                if(items[i][0] != items[i-1][0]){
                    sum = items[i][1];
                    count = 1;

                }
                if(count == -1){
                    continue;
                }
                if(items[i][0] == items[i-1][0] && count != 5){
                    sum+=items[i][1];
                    count++;
                }
                if(count ==5 ){
                    int average = sum/count;
                    result[index] = new int[]{items[i][0], average};

                    index++;
                    count = -1;


                }
            }
            return result;

        }
    }
}
