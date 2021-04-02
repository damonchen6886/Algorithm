package BinarySearch;

public class woodCut {

    // 2.4 Wood Cut
// Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
// Notice
//   You couldn’t cut wood into float length.
//   If you couldn’t get >= k pieces, return 0.
// Example
//   For L=[232, 124, 456], k=7, return 114.

    public int woodCut(int[] array, int k){
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }

        int optimal = sum/k;
        int count = 0;
        int j;
        for(j = optimal; j > 0; j--){
            count = 0;
            for(int i = 0; i< array.length; i++){
                count += array[i]/j;
                }
            if(count == k){
                break;
            }
        }

        return j;
    }


    // Time: （Array.length)* logn
// O(n*log(max(array)) n is the length of array
    public int woodCut2(int[] array, int k){
        int left = 1, right = 0, res = 0;
        for(int item : array){
            right = Math.max(right, item);
        }
        while(left <= right){
            int mid = left + (right - left)/2;
            if(count(array, mid) >= k){
                // 代表木料绰绰有余，我还想要更多
                res = mid;
                left = mid + 1; // 尝试更多
            } else {
                // 东西不够，自己节约
                right = mid - 1;
            }
        }
        return res;
    }
    private int count(int[] array, int length){
        int sum = 0;
        for(int item:array){
            sum += item/length;
        }
        return sum;
    }


    public static void main(String[] args) {
        woodCut test = new woodCut();
        int[] A = new int[]{232,124,456};
        System.out.println("expected 114 "+ test.woodCut(A,7));
        System.out.println("expected 114 "+ test.woodCut2(A,7));
    }
}
