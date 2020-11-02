//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
//Problem no:1614

class Solution {
    public int maxDepth(String s) {
        int count=0;
        int mx=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                count++;
				mx=Math.max(mx,count);
            }
            else if(s.charAt(i)==')')
            {
                count--;
            }
            
        }
        return mx;
    }
}