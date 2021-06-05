https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
//Problem no :1770

/*
Explanation:
we either go by left side of arry or right side of array.
but here m=10^5 so dp[][] will take 10^10 which will give MLE
we have to use n=10^3
as maximum from left will max go from l=0 to l=10^3(n or mul.size()) as only n operation i.e 10^3 need to performing-multiplication-operations/
similarly from right will go from r=a.length-1(max 10^5 or m) to r-10^3
similarly from right will go from r=a.length-1(max 10^5 or m) to r-10^3

*/

class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int dp[][]=new int[1001][1001];
        for(int i=0;i<1001;i++)
            Arrays.fill(dp[i],-1);
        return max(nums,multipliers,0,nums.length-1,0,dp);
    }
    
    public int max(int a[],int mul[],int l,int r,int i,int dp[][])
    {
        if(i==mul.length)
            return 0;
        int rmin=a.length-r-1; //This line is used to avoid Memory limit exceed 
        if(dp[l][rmin]!=-1)
            return dp[l][rmin];
        int left=max(a,mul,l+1,r,i+1,dp)+a[l]*mul[i];
        int right=max(a,mul,l,r-1,i+1,dp)+a[r]*mul[i];
        return dp[l][rmin]=Math.max(left,right);
    }
}