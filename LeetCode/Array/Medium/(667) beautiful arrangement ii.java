https://leetcode.com/problems/beautiful-arrangement-ii/
//Problem no : 667

class Solution {
    public int[] constructArray(int n, int k) {
        int ans[]=new int[n];
        for(int i=0;i<n-k;i++)
            ans[i]=i+1;
        int i=n-k;
        while(i<n)
        {
            ans[i]=ans[i-1]+k;
            i++;
            k--;
            if(i<n)
                ans[i]=ans[i-1]-k;
            i++;
            k--;
        }
        return ans;
    }
}