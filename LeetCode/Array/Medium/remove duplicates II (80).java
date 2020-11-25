https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
//problem no : 80

class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if(n<=2)
            return n;
        int j=2;
        for(int i=2;i<n;i++)
        {
            if(nums[i]!=nums[j-2])
            {
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}