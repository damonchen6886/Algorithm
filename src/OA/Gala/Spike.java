package OA;

import java.util.Arrays;
import java.util.HashSet;

public class Spike {
    public int longestSpike(int[] arr){
        int[] visited = new int[arr.length];
        HashSet<Integer> increase=  new HashSet<>();
        HashSet<Integer> decrease=  new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length;i++){
            if(increase.add(arr[i])){
                visited[i] =1;
            }
            max = Math.max(arr[i], max);
        }
        for(int i = 0 ; i< arr.length;i++){
            if(visited[i]!= 1 && arr[i] != max){
                decrease.add(arr[i]);
            }
        }
        System.out.println(increase+" "+decrease);
        return increase.size()+decrease.size();

    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2};
        int[] arr2 = new int[]{2,5,3,2,4,1};
        int[] arr3 = new int[]{2,3,3,2,2,1};
        int[] arr4 = new int[]{1,2,3,4,1,2,3};
        Spike s = new Spike();
        System.out.println(s.longestSpike(arr1));
        System.out.println(s.longestSpike(arr2));
        System.out.println(s.longestSpike(arr3));
        System.out.println(s.longestSpike(arr4));
    }
}
