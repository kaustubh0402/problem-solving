https://leetcode.com/problems/minimum-path-sum/
//problem no : 64

class Solution {
    public int minPathSum(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int dp[][]=new int[r][c];
        dp[0][0]=grid[0][0];
		
		//first two for loops for 1st row and 1st column to avoid array out of bound
        for(int i=1;i<c;i++)
        {
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for(int i=1;i<r;i++)
        {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
		
		//Here we start filling values in dp matrix
        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[r-1][c-1];
    }
}


//Without using dp[][] matrix .... use only grid matrix for storing values

class Solution {
    public int minPathSum(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        for(int i=1;i<c;i++)
        {
            grid[0][i]=grid[0][i-1]+grid[0][i];
        }
        for(int i=1;i<r;i++)
        {
            grid[i][0]=grid[i-1][0]+grid[i][0];
        }
        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        return grid[r-1][c-1];
    }
}