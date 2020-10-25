https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
//problem no : 1525

class Solution {
    public int numSplits(String s) {
        int freq[]=new int[26];
        int temp[]=new int[26];
        int n=s.length();
        int ans=0;
        int len1=0,len2=0;
        for(int i=0;i<n;i++)
        {
            if(freq[s.charAt(i)-'a']==0)
                len2++;
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++)
        {
            char curr=(s.charAt(i));
            if(temp[curr-'a']<1)
            {
                len1++;
            }
            temp[curr-'a']++;
            if(freq[curr-'a']>0)
            {
                freq[curr-'a']--;
            }
            if(freq[curr-'a']==0)
                len2--;
            if(len1==len2)
                ans++;
        }
        return ans;
    }
}
