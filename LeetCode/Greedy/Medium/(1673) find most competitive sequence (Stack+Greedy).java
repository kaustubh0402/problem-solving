https://leetcode.com/problems/find-the-most-competitive-subsequence/
//Problem no : 1673



/*
My Idea: O(n*k) TLE
find smallest element in range for every k
  range should be starting from previous smallest element index and n-i

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[k];
        int index=-1;
        int temp=-1;
        if(k==n)
            return nums;
        for(int i=k;i>=1;i--)
        {
            int min=Integer.MAX_VALUE;
            for(int j=n-i;j>=index+1;j--)
            {
                if(min>=nums[j])
                {
                    min=nums[j];
                    temp=j;
                }
            }
            index=temp; //Set smallest element index for next range
            ans[k-i]=min;
        }
        return ans;
    }
}
*/  

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[k];
        Stack<Integer> s=new Stack<Integer>();
        for(int i=0;i<n;i++)
        {
            while(!s.isEmpty() && nums[i]<s.peek() && n-i+s.size()>k)
                s.pop();
            if(s.size()<k)
                s.push(nums[i]);
        }
        for(int i=k-1;i>=0;i--)
            ans[i]=s.pop();
        return ans;
    }
}
            