https://leetcode.com/problems/range-sum-query-immutable/
//problem no: 303

class NumArray {
    int ans[];
    public NumArray(int[] nums) {
        int sum=0;
        ans=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            ans[i+1]=nums[i]+sum;
            sum=ans[i+1];
        }
    }
    
    public int sumRange(int i, int j) {
        return ans[j+1]-ans[i];
    }
}
