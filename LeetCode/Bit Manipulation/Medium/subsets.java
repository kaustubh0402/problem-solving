https://leetcode.com/problems/subsets/
//problem no :78

/*
Explanation:
refer gfg notes(Bit manipulation)

*/
//Bitwise solutiion (2^n * n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans =new ArrayList();
        int len=nums.length;
        int powlen=(int)Math.pow(2,len);
        List<Integer> temp;
        for(int i=0;i<powlen;i++)
        {
            temp=new ArrayList<Integer>();
            for(int j=0;j<len;j++)
            {
                if(((i>>j)&1)==1)
                    temp.add(nums[j]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
