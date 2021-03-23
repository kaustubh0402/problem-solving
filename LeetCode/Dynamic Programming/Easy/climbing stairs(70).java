https://leetcode.com/problems/climbing-stairs/
//problem no: 70

class Solution {
    int dp[]=new int[46];
    Solution()
    {
        Arrays.fill(dp,-1);
    }
    public int climbStairs(int n) {
       if(n==0 || n==1)
           return 1;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=(climbStairs(n-1)+climbStairs(n-2));
    }
}


class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        return helper(0,n,dp);
    }
    
    int helper(int j,int n,int dp[])
    {
        if(j==n)
        {
            return 1;
        }
        if(j>n)
            return 0;
        if(dp[j]!=0)
            return dp[j];
        dp[j]+=helper(j+1,n,dp)+helper(j+2,n,dp);
        return dp[j];
    }
}