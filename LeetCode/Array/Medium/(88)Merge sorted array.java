https://leetcode.com/problems/merge-sorted-array/
//Problem no : 88

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=m+n-1;
        m--;
        n--;
        while(index>=0 && m>=0 && n>=0)
        {
            if(nums1[m]>nums2[n])
            {
                nums1[index]=nums1[m];
                m--;
            }
            else
            {
                nums1[index]=nums2[n];
                n--;
            }
            index--;
        }
        if(n>=0)
        {
            for(int i=0;i<=n;i++)
                nums1[i]=nums2[i];
        }
    }
}