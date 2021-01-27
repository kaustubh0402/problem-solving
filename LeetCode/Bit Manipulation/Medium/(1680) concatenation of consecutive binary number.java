https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
//Problem no : 1680

/*
Explanation:
int bit will be total no of bits in current i numbers
i.e. if i=3 ,binary=11 hence bit=2 (total bits in i)
     if(i=6),binary=110 hence bit=3
	 
In next step we are right shifting ans by bit and 
doing or of current num with existing answer to append current number to ans.
 
*/


class Solution {
    public int concatenatedBinary(int n) {
        int mod=1000000007;
        long ans=0;
        for(int i=1;i<=n;i++)
        {
            int bit=(int)(Math.log(i)/Math.log(2)+1);
            ans=((ans<<bit)|i)%mod;
        }
        return (int)ans;
    }
}