https://leetcode.com/problems/minimum-sideway-jumps/
//Problem no: 1824

class Solution {
    public int minSideJumps(int[] obstacles) {
        int n=obstacles.length;
        int dp[][]=new int[n][4];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return helper(obstacles,n,0,2,dp);
    }
    
    public int helper(int a[],int n,int i,int lane,int dp[][])
    {
        if(i==n-1)
            return dp[i][lane]= 0;
        if(dp[i][lane]!=-1)
            return dp[i][lane];
        if(a[i+1]==lane)
        {
            int x=-1;
            int y=-1;
            if(lane==3)
            {
                x=lane-1;
                y=lane-2;
            }
            if(lane==2)
            {
                x=lane-1;
                y=lane+1;
            }
            else if(lane==1)
            {
                x=lane+2;
                y=lane+1;
            }
            int one=Integer.MAX_VALUE;
            int two=Integer.MAX_VALUE;
            if(a[i]!=x)
                one=helper(a,n,i+1,x,dp)+1;
            if(a[i]!=y)
                two=helper(a,n,i+1,y,dp)+1;
            return dp[i][lane]=Math.min(one,two);
        }
        return dp[i][lane]=helper(a,n,i+1,lane,dp);
    }
}