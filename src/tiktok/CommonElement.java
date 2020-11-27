package tiktok;

import java.util.*;

public class CommonElement {
    //[1,2], [1]  = > [1]
    // [2,1],[]  => []
    // [3,1,3],[3,3] = > [3,3]

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums1.length;i++){
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }
        for(int i = 0; i < nums2.length;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) >0){
                result.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        int[] r= new int[result.size()];
        for(int i =0; i< result.size();i++){
            r[i] = result.get(i);
        }
        return r;
    }



    public List<Integer> commonElement(int[] arr1, int[] arr2){
        List<Integer>  result = new ArrayList<>();
        if(arr1.length == 0 || arr2.length == 0){
            return result;
        }
        int l1 = arr1.length;
        int l2 = arr2.length;
        int[][] dp = new int[l1+1][l2+1];
        for(int i =0; i < l1; i++){
            for(int j= 0; j < l2;j++){
                if(i == 0 || j ==0){
                    dp[i][j] = 0;
                }
                else if (arr1[i-1] == arr2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i = l1;
        int j = l2;
        while(i > 0 && j>0){
            if(arr1[i-1] == arr2[j-1]){
                result.add(0,arr1[i-1]);
                i--;
                j--;
            }
            else{
                if(dp[i][j-1] > dp[i-1][j]){
                    j--;
                }
                else{
                    i--;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2};
        int[] arr2 = new int[]{1};
        int[] arr3 = new int[]{2};
        int[] arr4 = new int[]{};
        int[] arr5 = new int[]{3,1,3};
        int[] arr6 = new int[]{3,3};
        CommonElement c = new CommonElement();
        System.out.println(c.commonElement(arr1,arr2));
        System.out.println(c.commonElement(arr3,arr4));
        System.out.println(c.commonElement(arr5,arr6));


    }

    //        while(i > 0 && j > 0) {
    //
    //            if(a[i-1] == b[j-1]) {
    //                res[index-1] = a[i-1];
    //                index--;
    //                i--;
    //                j--;
    //            } else if(dp[j-1][i] > dp[j][i-1]) {
    //                j--;
    //            } else {
    //                i--;
    //            }
    //        }
    //        return res;

}
