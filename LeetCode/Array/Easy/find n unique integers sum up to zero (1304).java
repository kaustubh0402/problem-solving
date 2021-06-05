https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
//problem no : 1304

class Solution {
    public int[] sumZero(int n) {
        int ans[]=new int[n];
        int len=n;
        if((n&1)==1)
            len=n-1;
        int ind=0;
        for(int i=1;i<=len/2;i++)
        {
            ans[ind++]=i;
            ans[ind++]=-i;
        }
        if((n&1)==1)
            ans[ind]=0;
        return ans;
    }
}