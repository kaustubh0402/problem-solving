//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//problem no. 3
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int dp[]=new int[s.length()];
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        if(s.length()==0)
            return 0;
        dp[0]=1;
        h.put(s.charAt(0),0);
        int index=0;
        for(int i=1;i<s.length();i++)
        {
            if(h.containsKey(s.charAt(i)))
            {
                 dp[i]=Math.min(i-h.get(s.charAt(i)),dp[i-1]+1);
            }
            else
            {
                dp[i]=dp[i-1]+1;
            }
            h.put(s.charAt(i),i);
        }
        int m=dp[0];
        for(int i=1;i<s.length();i++)
        {
            m=Math.max(m,dp[i]);
        }
        return m;
    }
}