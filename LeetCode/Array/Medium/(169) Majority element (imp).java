https://leetcode.com/problems/majority-element/
//Problem no : 169


//Sorting =solution 1
//HashMap =solution 2
//moore voting algorithm 
class Solution {
    public int majorityElement(int[] nums) {
        int ans=nums[0];
        int n=nums.length;
        int cnt=1;
        for(int i=1;i<n;i++)
        {
            if(cnt==0)
            {
                ans=nums[i];
            }
            if(nums[i]==ans)
                cnt++;
            else
                cnt--;
        }
        return ans;
    }
}