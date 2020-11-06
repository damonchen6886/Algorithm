package Contests;

import java.util.PriorityQueue;

public class FurthestBuilding {
    public static int furthestBuilding(int[] h, int bricks, int ladders) {

        // int[][] dp = new int[h.length+1][bricks+1];
        // for(int i =1;i h.length;i++){
        //     for(int j =1; j < bricks){
        //         if(dp[i])
        //     }
        // }
        int sum = 0;
        int count= 0;
        int num = 0;
        int i;
        PriorityQueue<Integer> pq =new PriorityQueue<>((a,b) ->  b-a);
        for(i =1; i< h.length; i++){
            if(h[i]-h[i-1] > 0){
                sum+= h[i]-h[i-1];
                pq.offer( h[i]-h[i-1]);
            }

            if(sum>= bricks){
                if(ladders == 0){
                    return i-1;
                }
                if(!pq.isEmpty()){
                    num = pq.poll();
                }
                System.out.println(num);
                sum-= num;
                ladders--;
            }
        }
        return i-1;

    }

    public static void main(String[] args) {
        int[] h1 = new int[]{4,2,7,6,9,14,12};
        int[] h2 = new int[]{4,12,2,7,3,18,20,3,19};
        int[] h3 = new int[]{14,3,19,3};
        System.out.println("result  is "+furthestBuilding(h1, 5,1));
        System.out.println("result  is "+ furthestBuilding(h2, 10,2));
        System.out.println("result  is "+furthestBuilding(h3, 17,0));

    }
}
