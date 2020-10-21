https://leetcode.com/problems/peak-index-in-a-mountain-array/
//Problem no:852


//Binary Search Method
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = (lo+hi)/2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }
}



//Linear Search 
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<arr[i-1])
                return i-1;
        }
        return -1;
    }
}
