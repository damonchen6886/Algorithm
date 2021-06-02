package SortingAlgo;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickSort {
    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }


    // version 2
    public void quickSort2(int[] arr){
        quickSort2(arr, 0, arr.length-1);
    }
    public void quickSort2(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int left = start;
        int right = end;
        int pivot = arr[(start+end)/2];
        while(left <= right){
            while(left <= right && arr[left] < pivot){
                left++;
            }
            while (left <= right && arr[right] > pivot){
                right--;
            }
            if(left <= right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        quickSort2(arr,start, right);
        quickSort2(arr, left, end);
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
//        int[] arr = {3,4,5,1,7,4,8,9};
//        q.quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
        int[] arr2 = {3,4,5,1,7,4,8,9};
        q.quickSort2(arr2);
        System.out.println(Arrays.toString(arr2));

    }
}
