https://leetcode.com/problems/longest-common-subsequence/
//problem no : 1143


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<=text1.length();i++)
            Arrays.fill(dp[i],-1);
        return helper(text1,text2,text1.length(),text2.length(),dp);
    }
    
    int helper(String s1,String s2,int n,int m,int dp[][])
    {
        if(n==0 || m==0)
            return 0;
        if(dp[n][m]!=-1)
            return dp[n][m];
        
        if(s1.charAt(n-1)==s2.charAt(m-1))
            return dp[n][m]=1+helper(s1,s2,n-1,m-1,dp);
        
        return dp[n][m]=Math.max(helper(s1,s2,n-1,m,dp),helper(s1,s2,n,m-1,dp)); 
    }
}


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}