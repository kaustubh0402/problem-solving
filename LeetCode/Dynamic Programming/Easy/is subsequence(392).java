https://leetcode.com/problems/is-subsequence/
//problem no : 392

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        int i,j;
        for(i=0,j=0;i<t.length()&& j<s.length();i++)
        {
            if(s.charAt(j)==t.charAt(i))
                j++;
        }
        if(j==s.length())
            return true;
        return false;
    }
}