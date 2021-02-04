https://leetcode.com/problems/longest-harmonious-subsequence/
//Problem no : 594

/*
explanation:
we just want sequencee with max and min number difference 1
i.e. all subsequqnce should contain only elemnts whose difference is 1 and only 2 unique element
*/

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);
        }
        for(int i=0;i<n;i++)
        {
            if(h.containsKey(nums[i]-1))
                ans=Math.max(ans,h.get(nums[i])+h.get(nums[i]-1));
        }
        return ans;
    }
}