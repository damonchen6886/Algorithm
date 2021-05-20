package SortingAlgo;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SelectionSort {
    public void selectionSort(int[] arr){
        for(int i = 0; i< arr.length-1;i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i]  =arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,7,4,8,9};
        SelectionSort s = new SelectionSort();
        s.selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
