//https://leetcode.com/problems/single-number/
// problem no 136
class Solution {
    public int singleNumber(int[] nums) {
        int ans=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            ans^=nums[i];
        }
        return ans;
    }
}