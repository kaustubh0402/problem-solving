https://leetcode.com/problems/unique-paths-ii/
//Problem no : 63


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);
        return helper(m,n,0,0,dp,obstacleGrid);
    }
    
    int helper(int m,int n,int i,int j,int dp[][],int ob[][])
    {
        if(i>=m || j>=n)
            return 0;
        if(ob[i][j]==1)
            return 0;
        if(i==m-1 && j==n-1)
            return 1;
        if(dp[i][j]!=-1)
            return dp[i][j];
        return dp[i][j]=helper(m,n,i+1,j,dp,ob)+helper(m,n,i,j+1,dp,ob);
    }
}