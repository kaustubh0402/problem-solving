https://leetcode.com/problems/decode-ways/
//Problem no : 91

/*
Explanation:
We have to make two calls
for i+1 and i+2 (as letters have maximum mapping upto 2 digits)
We have to check various condition before calling function
1. for i+1 call (single character)
   char should not be 0 as it is given that no mapping for 0
2. for i+2 call (double character)
   character should be in range "10" and "26"
   as prefix 0 is not allowed
*/
 
//My initial solution
class Solution {
    public int numDecodings(String s) {
        String possible="";
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,possible,0,s.length(),dp);
    }
    
    int helper(String s,String p,int i,int n,int dp[])
    {
        if(p.length()==n)
            return 1;
        int one=0;
        if(dp[i]!=-1)
            return dp[i];
        if(p.length()<n && s.charAt(i)!='0')
          one=helper(s,p+s.charAt(i),i+1,n,dp);
        int two=0;
        String temp="";
        if(p.length()<n-1)
        {
            temp=temp+s.charAt(i)+s.charAt(i+1);
            if(temp.compareTo("10")>=0 && temp.compareTo("26")<=0)
                two=helper(s,p+s.charAt(i)+s.charAt(i+1),i+2,n,dp);
        }
        return dp[i]=one+two;
    }
}


//avoid using extra string
class Solution {
public:
    int dp[101];
    int helper(string s, int n){
        if(n==0) 
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        int one=0;
        if((n-1)>=0 && s[n-1]!='0')   
            one=helper(s, n-1);
        int two=0;
        if ((n-2)>=0 && (s[n-2]=='1'||(s[n-2]=='2'&&s[n-1]<'7')))   
            two=helper(s, n-2);
        return dp[n]=one+two;
    }
    
    int numDecodings(string s) {
        memset(dp,-1,sizeof(dp));
        return helper(s, s.size());
    }
};