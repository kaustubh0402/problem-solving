https://leetcode.com/problems/number-of-substrings-with-only-1s/
//Problem no : 1513


/*
Explanation:
Total number of substring without empty string in string of length n
==((n)*(n+1)/2)
So in this problem we just find out susbtring of given string which have consecutive ones and 
for each substring count total substring.

*/
class Solution {
    public int numSub(String s) {
        int ans=0;
        long count=0;
        int mod=1000000007;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='1')
            {
                count++;
            }
            else
            {
                ans=(ans % mod+(int)((count*(count+1)/2) % mod)) % mod;
                count=0;
            }
        }
        ans=(ans % mod+(int)((count*(count+1)/2) % mod)) % mod;
        return ans;
    }
}