package SortingAlgo;

import java.util.Arrays;

public class BubbleSort {

    //------------------
    //BubbleSort
    public void  bubbleSort(int[] lst){
        int n = lst.length;
        boolean hasChanged =false;
        for(int i = 0; i < n-1; i++){

            for(int j = 0; j < n-i-1; j++){
                if(lst[j] > lst[j+1]){
                    int temp = lst[j];
                    lst[j] = lst[j+1];
                    lst[j+1] = temp;
                    hasChanged = true;
                }
            }
            if(!hasChanged){
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] lst = new int[]{29, 31, 39, 18, 6, 5, 34, 24, 13, 37};
        System.out.println("after********");
        System.out.println(Arrays.toString(lst));
        System.out.println("after********");
        b.bubbleSort(lst);
        System.out.println(Arrays.toString(lst));

    }
}
