package tiktok;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncrementalMemoryLeak {

    public ArrayList<int[]> incrementalMemoryLeak(int n, ArrayList<int[]> tests){
        ArrayList<int[]> result =  new ArrayList<>();
        for(int  i= 0; i< tests.size();i++){
            int[] cur = new int[3];
            int time = 1;
            int m1 = tests.get(i)[0];
            int m2 = tests.get(i)[1];
            while(m1 >=0 && m2 >=0){
                if(m1 >= m2 && m1 -time >=0){
                    m1-=time;
                    time++;
                }
                else if(m2 > m1 && m2 - time >=0){
                    m2-=time;
                    time++;
                }
                else{
                    cur[0] = time;
                    cur[1] = m1;
                    cur[2] = m2;
                    break;
                }
            }
            result.add(cur);
        }
        for(int  i =0 ; i < result.size(); i++){
            System.out.println(Arrays.toString(result.get(i)));
        }
        return result;


    }

    public static void main(String[] args) {
        int[] t1 = new int[] {2,2};
        int[] t2 = new int[] {8,11};
        int n = 2;
        ArrayList<int[]> test1 = new ArrayList<>();
        test1.add(t1);
        test1.add(t2);
        IncrementalMemoryLeak i = new IncrementalMemoryLeak();
        i.incrementalMemoryLeak(n,test1);

    }


}
