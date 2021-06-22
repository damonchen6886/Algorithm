package OA.AZ;

import java.util.*;

public class Coin {
    // coins[]:25, 10, 5, 1，return the least number coins
    public List<Integer> getCoins(int target, int[] coins){
        List<Integer> res = new ArrayList<>();
        if(target <= 0 || coins == null || coins.length == 0) return res;
        Set<int[]> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curTar = sum(cur);

            if(curTar == target){
                res.add(cur[0]);
                res.add(cur[1]);
                res.add(cur[2]);
                res.add(cur[3]);
                return res;
            }
            for(int i = 0; i < 4; i ++){
                cur[i] ++;
                if(!visited.contains(cur) && sum(cur) <= target && cur[i]<= coins[i]){
                    visited.add(cur);
                    queue.offer(new int[]{cur[0],cur[1],cur[2],cur[3]});
                }
                cur[i] --;
            }
        }
        return res;
    }
    private int sum(int[] cur){
        return 25 * cur[0] + 10 * cur[1] + cur[2] * 5 + cur[3];
    }

    public static void main(String[] args) {
        int[] coin = new int[]{0,10,10,10};
        int[] inventory = new int[]{0};
        Coin test = new Coin();

        System.out.println(test.getCoins(30,coin));
    }
}
