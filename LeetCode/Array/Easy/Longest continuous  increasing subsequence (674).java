https://leetcode.com/problems/longest-continuous-increasing-subsequence/
//Problem no : 674

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        if(n<=1)
            return n;
        int ans=1,count=1;
        for(int i=1;i<n;i++)
        {
            if(nums[i-1]<nums[i])
                count++;
            else
            {
                ans=Math.max(ans,count);
                count=1;
            }
        }
        return Math.max(ans,count);
    }
}