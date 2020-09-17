//https://leetcode.com/problems/contains-duplicate-ii/
//problem no 219
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap <Integer,Integer> m=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(m.containsKey(nums[i]))
            {
                if(i-m.get(nums[i])<=k)
                    return true;
            }
            m.put(nums[i],i);
        }
          return false;
    }
}