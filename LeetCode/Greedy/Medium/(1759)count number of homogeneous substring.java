https://leetcode.com/problems/count-number-of-homogenous-substrings/
//Problem no : 1759

class Solution {
    public int countHomogenous(String s) {
        int ans=0;
        long count=1;
        int n=s.length();
        int mod=1000000007;
        for(int i=0;i<n-1;i++)
        {
            int curr=s.charAt(i);
            int prev=s.charAt(i+1);
            if(curr==prev)
            {
                count++;
            }
            else
            {
                ans=(ans%mod+(int)(((count*(count+1))/2)%mod))%mod;
                count=1;
            }
        }
        ans=(ans%mod+(int)(((count*(count+1))/2)%mod))%mod;
        return (int)ans;
    }
}


//Without using long
class Solution {
    public int countHomogenous(String s) {
        int ans=0;
        int count=0;
        int n=s.length();
        int mod=1000000007;
        for(int i=0;i<n;i++)
        {
            if(i>0 && s.charAt(i)==s.charAt(i-1))
            {
                count++;
            }
            else
            {
                count=1;
            }
            ans=(ans%mod+count%mod)%mod;
        }
        return ans;
    }
}