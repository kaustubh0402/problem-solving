https://practice.geeksforgeeks.org/problems/ncr1019/1#

/*
Calculate nCr 
nCr=n!/((n-r)!*r!)

Basic:
nC0=1 :nCn=rCr=1; r>n=0;
nCn=(n-1)Cr + (n-1)C(r-1)
*/

class Solution{
    int mod=1000000007;
    int nCr(int n, int r)
    {
        int dp[][]=new int[n+1][r+1];
        for(int a[]:dp)
           Arrays.fill(a,-1);
        return helper(dp,n,r);
    }
    
    int helper(int dp[][],int n,int r)
    {
        if(r>n)
          return 0;
        if(n<=1 || r==n || r==0)
          return 1;
        if(dp[n][r]!=-1)
          return dp[n][r];
        return dp[n][r]=(((helper(dp,n-1,r)%mod)+(helper(dp,n-1,r-1)%mod))%mod);
    }
}