https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
//Problem no : 1437

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        int check=0;
        for(int i=0;i<n;i++)
        {
            int curr=nums[i];
            if(curr==1)
            {
                if(check>0)
                    return false;
                else
                    check=k;
            }
            else
            {
                check--;
            }
        }
        return true;
    }
}