//https://leetcode.com/problems/number-of-good-pairs/
/*Given an array of integers nums.
A pair (i,j) is called good if nums[i] == nums[j] and i < j.
Return the number of good pairs.
*/
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int freq[]=new int[101];
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            if(freq[nums[i]]!=0)
            {
                ans=ans+freq[nums[i]];
            }
            freq[nums[i]]=freq[nums[i]]+1;
        }
        return ans;
    }
}