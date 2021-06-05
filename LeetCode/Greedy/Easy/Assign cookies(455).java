https://leetcode.com/problems/assign-cookies/
//problem no : 455


class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        int ans=0;
        while(i<g.length && j<s.length)
        {
            if(s[j]>=g[i])
            {
                ans++;
                i++;
            }
            j++;
        }
        return ans;
    }
}