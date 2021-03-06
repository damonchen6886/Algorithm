package day30;

import java.util.Arrays;

public class mergeSort {

    public int[] mergeSort(int[] array){
        if(array == null || array.length <= 1){
            return array;
        }
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }
    private void mergeSort(int[] array, int[] helper, int left, int right){
        if(left >= right){
            return;

        }
        int mid = left + (right - left)/2;
        // divide -> pure recursion
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid+1, right);
        // after division, conquer -> new method
        merge(array, helper, left, mid, right);
    }
    private void merge(int[] array, int[] helper, int left, int mid, int right){
        for(int i = left; i <= right; i++){
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while(leftIndex <= mid && rightIndex <= right){
            if(helper[leftIndex] < helper[rightIndex]){
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }
        while(leftIndex <= mid){
            array[left++] = helper[leftIndex++];
        }

    }

// merge sort 2:
    public  int[] mergeSort2(int[] array){
        if(array == null || array.length == 0){
            return array;
        }
        int n = array.length;
        int mid = n/2;
        int[] left = mergeSort2(Arrays.copyOfRange(array, 0, mid));
        int[] right = mergeSort2(Arrays.copyOfRange(array, mid+1, n));
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return merge(left, right);
    }

    public  int[] merge(int[] left, int[] right){
        int leftBound = left.length, rightBound = right.length;
        int l = 0, r = 0;
        int n = leftBound + rightBound;
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            if(l == leftBound){
                array[i] = right[r++];
            } else if(r == rightBound){
                array[i] = left[l++];
            } else {
                array[i] = left[l] <= right[r] ? left[l++] : right[r++];
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,2,1,4,8,6,7};
        mergeSort m = new mergeSort();
//        System.out.println(Arrays.toString(m.mergeSort(a)));
        System.out.println(Arrays.toString(m.mergeSort2(a)));
    }
}
