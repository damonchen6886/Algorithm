package Notes;

//Sort 的几种写法：

import java.util.*;

public class notes {

    public void examples(){
    // sort Hashmap by value:
        int[] nums = new int[]{2,3,4,5,2,4,5,7};

        Map<Integer, Integer> map = new HashMap<>();
            for(int  i =0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, (a, b) ->{
            return !a.getValue().equals(b.getValue()) ? a.getValue().compareTo(b.getValue()) : b.getKey().compareTo(a.getKey());
        });
    }

    public static void main(String[] args) {
    //    List<int[]> 和 int[][] 转换：
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{1, 2});
        result.add(new int[]{3, 4});
        int[][] expected = result.toArray(new int[0][]);
        // 打印 二维数组 用deepToString
        System.out.println(Arrays.deepToString(expected));
    }
}
