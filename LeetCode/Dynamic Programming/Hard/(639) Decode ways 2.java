https://leetcode.com/problems/decode-ways-ii/
//Problem no : 639

/*
Decode array | Explanation:
We have to make two calls
for i-1 and i-2 (as letters have maximum mapping upto 2 digits)
We have to check various condition before calling function
1. for i-1 call (single character)
   char should not be 0 as it is given that no mapping for 0
2. for i-2 call (double character)
   character should be in range "10" and "26"
   as prefix 0 is not allowed
   
One extra condition added :
'*' symbol is added and it can be any number from 1 to 9
Now again we have to check conditions

for i-1 call (single character)
 1. Normal call as above mentioned in decode-ways-i
 2. if char i-1 is '*' then we have nine posibilities so we will multiply curr call by 9
 
for i-2 call (doubel character)
 1. Normal call as above mentioned in decode-ways-i
 2. if char at i-2 is '*'
      1) if (i-1) is less than 7 (then multiply by 2) why?? as i-2 can be '1' or '2' 
	  2) if(i-1) is greater than 7 then (multiply by 1) as i-2 only have '1' as possibility 
	     we cannot put i-2 as '2' in place of * as it will generate 27,28,29 which are not following condition
	  3) if (i-1) is also *
	     in above cases both are * so there are total 15 posibilities 11,12,13,14,15,16,17,18,19,21,22,23,24,25,26
		 basically we are including all from 1 to 26 except whose digit contains 0 (as mentioned * cannot be 0)
 3. if char at i-1 is *
      1) if (i-1) is 1 then * can be 9 (1 to 9) any digits
	  2) if (i-1) is 2 then * can be less than 7 (1-6) as we can choose from (21-26) total 6
*/

class Solution {
    public int numDecodings(String s) {
        long dp[]=new long[s.length()+1];
        Arrays.fill(dp,-1);
        return (int)((helper(s,s.length(),dp)%1000000007));
    }
    
    long helper(String s,int i,long dp[])
    {
        if(i==0)
            return 1;
        long one=0;
        if(dp[i]!=-1)
            return dp[i];
        if(i-1>=0 && s.charAt(i-1)!='0')
        {
            one=helper(s,i-1,dp);
            if(s.charAt(i-1)=='*')
                one=one*9;
        }
        long two=0;
        if(i-2>=0)
        {
            if((s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1)<'7')) && s.charAt(i-1)!='*')
                two=helper(s,i-2,dp);
            else if(s.charAt(i-2)=='*')
            {
                if(s.charAt(i-1)<'7' && s.charAt(i-1)!='*')
                    two=2*helper(s,i-2,dp);
                else if(s.charAt(i-1)!='*')
                    two=helper(s,i-2,dp);
                else
                    two=15*helper(s,i-2,dp);
            }
            else if(s.charAt(i-1)=='*')
            {
                if(s.charAt(i-2)=='1')
                    two=9*helper(s,i-2,dp);
                else if(s.charAt(i-2)=='2')
                    two=6*helper(s,i-2,dp);
            }
        }
        return dp[i]=(one+two)%1000000007;
    }
}