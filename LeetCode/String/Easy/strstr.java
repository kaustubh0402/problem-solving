//https://leetcode.com/problems/implement-strstr/
//problem no :28

//brute force
class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        if(m>n)
            return -1;
        if(m==0)
            return 0;
        for(int i=0;i<n;i++)
        {
            if(haystack.charAt(i)==needle.charAt(0) && i<=n-m)
            {
                int j;
                for(j=1;j<m;j++)
                {
                    if(haystack.charAt(i+j)!=needle.charAt(j))
                        break;
                }
                if(j==m)
                    return i;
            }
        }
        return -1;
    }
}