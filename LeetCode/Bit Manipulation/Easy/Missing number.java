https://leetcode.com/problems/missing-number/
//problem no : 268

// Use following property
(1^2^3^4^5...upto n) ^( nums[i] every) =0 if no number is missing
refer notes of gfg

class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            sum=sum+nums[i];
        }
        return (n*(n+1)/2)-sum;
    }
}



class Solution {
    public int missingNumber(int[] nums) {
        int ans=0;
        int n=nums.length;
        int i;
        for(i=0;i<n;i++)
        {
            ans=ans^nums[i]^i;
        }
        return ans^i;
    }
}
```