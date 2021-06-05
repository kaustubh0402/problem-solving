//https://leetcode.com/problems/contains-duplicate/
//problem no 217
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet< Integer> h=new HashSet<Integer>();
        for(int i:nums)
        {
            if(h.contains(i))
                return true;
            h.add(i);
        }
        return false;
    }
}