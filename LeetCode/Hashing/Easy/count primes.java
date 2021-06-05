//https://leetcode.com/problems/count-primes/
//problem no. 204
//Count primes- seive of erostesis  (n*log(log(n)))
class Solution {
    public int countPrimes(int n) {
        int pr[]=new int[n];
        int cnt=0;
        for(int i=2;i<n-1;i++)
        {
            if(pr[i]==0)
            {
                for(long j=i*i;j<n;j+=i)
                {
                    pr[(int)j]=1;
                }
            }
        }
        for(int i=2;i<n;i++)
            if(pr[i]==0)
                cnt++;
        return cnt;
    }
}