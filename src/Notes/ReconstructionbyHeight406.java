package Notes;

import java.util.*;

public class ReconstructionbyHeight406 {
    //Input:
    //[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    //
    //Output:
    //[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    // reorder the 2d array
    // 思路： 先排序 根据arr[i][1]的大小来排序
    // 再把数组里面的数字 插入到 result的arr[i]上
    public int[][] reconstructQueue(int[][] people) {
        if(people.length ==0){
            return new int[][]{};
        }
        Arrays.sort(people, (a, b) -> a[0] == b[0] ?  a[1]-b[1] : b[0]-a[0]);

        List<int[]> result =new ArrayList<>();
        for(int i =0; i< people.length;i++){
            result.add(people[i][1], people[i]);
        }
        return result.toArray(new int[people.length][]);

    }

    // 2nd
    public int[][] reconstructQueue2(int[][] people) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2)-> {
            if(i1[0]!=i2[0])
                return i2[0]-i1[0];
            return i1[1]-i2[1];
        });
        for(int[]i:people)
            pq.add(i);
        List<int[]>l = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] peops = pq.poll();
            l.add(peops[1],peops);
        }
        return l.toArray(people);
    }
}
