//https://leetcode.com/problems/split-a-string-in-balanced-strings/
//problem no. 1221
class Solution {
    public int balancedStringSplit(String s) {
        int cnt=0,ans=0;
        char [] split=s.toCharArray();
        for(int i=0;i<s.length();i++)
        {
            if(split[i]=='L')
                cnt--;
            else
                cnt++;
            if(cnt==0)
                ans++;
        }
        return ans;
    }
}