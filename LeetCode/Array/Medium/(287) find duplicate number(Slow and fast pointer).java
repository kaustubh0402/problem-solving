https://leetcode.com/problems/find-the-duplicate-number/
//Problem no : 287

/*
Slow and fast pointer
Read solution of problem no 142
*/

class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length<=2)
            return nums[0];
        int slow=nums[nums[0]];
        int fast=nums[nums[nums[0]]];
        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=nums[0];
        while(fast!=slow)
        {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}