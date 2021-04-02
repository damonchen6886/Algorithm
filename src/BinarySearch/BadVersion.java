package BinarySearch;


//3.3  First Bad Version
//        You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//        Suppose you havenversions[1, 2, ..., n]and you want to find out the first bad one, which causes all the following ones to be bad.
//        You are given an APIbool isBadVersion(version)which will return whetherversionis bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
//        Given n = 5, and version = 4 is the first bad version.
//        call isBadVersion(3) -
//        > false
//        call isBadVersion(5) -
//        > true
//        call isBadVersion(4) -
//        >true


public class BadVersion {

    public int checkVersion(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }
        int left =0; int right  = array.length-1;
        while(left< right -1){
            int mid = left + (right - left)/2;

            if(isBadVersion(array[mid])){
                right = mid;
            }
            else{
                left = mid;
            }

        }

        if(isBadVersion(array[left])){
            return left;
        }
        else if(isBadVersion(array[right])){
            return right;
        }
        return -1;
    }

    private  boolean isBadVersion(int version)
    {
        return true;

    }

}



