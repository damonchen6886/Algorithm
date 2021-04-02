package BFSwithHeap;

public class TrapWater {
    public int maxTrapped(int[] array){
        if(array.length == 0){
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int result = 0;
        int leftMax = array[leftIndex];
        int rightMax = array[rightIndex];
        while(leftIndex < rightIndex){
            if(array[leftIndex] <= array[rightIndex]){
                result += Math.max(0, leftMax - array[leftIndex]);
                leftMax = Math.max(leftMax, array[leftIndex]);
                leftIndex++;
            } else {
                result += Math.max(0, rightMax - array[rightIndex]);
                rightMax = Math.max(rightMax, array[rightIndex]);
                rightIndex--;
            }
        }
        return result;
    }

    public int trapwater(int[] arr){
        int[] leftheight  = new int[arr.length];
        int[] rightheight = new int[arr.length];
        leftheight[0] = arr[0];
        rightheight[arr.length-1] = arr[arr.length-1];
        for(int i = 1; i < arr.length; i++){
            leftheight[i] = Math.max(arr[i-1],leftheight[i]);
        }
        for(int i = arr.length-2; i > 0; i--){
            rightheight[i] = Math.max(rightheight[i+1],arr[i]);

        }


        int result = 0;
        int cur = 0;

        for(int i = 1; i < arr.length-1; i++){
            cur = Math.max(0,Math.min(leftheight[i-1], rightheight[i+1])-arr[i]);
            result+= cur;


        }
        return result;

    }

}
