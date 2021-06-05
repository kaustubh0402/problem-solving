//https://leetcode.com/problems/subarray-sum-equals-k/
//Problem no : 560

class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        int prefix[]=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
        }
        HashMap<Integer,Integer> target=new HashMap<Integer,Integer>();
        target.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            if(target.containsKey(prefix[i]-k))
                ans+= target.get(prefix[i]-k);
            target.put(prefix[i],target.getOrDefault(prefix[i],0)+1);
        }
        return ans;
    }
}