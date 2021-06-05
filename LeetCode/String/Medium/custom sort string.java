//https://leetcode.com/problems/custom-sort-string/
//problem no: 791

class Solution {
    public String customSortString(String S, String T) {
        int freq[]=new int[26];
        int freq2[]=new int[26];
        for(int i=0;i<S.length();i++)
        {
            freq[S.charAt(i)-'a']++;
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<T.length();i++)
        {
            if(freq[T.charAt(i)-'a']==0)
                ans.append(T.charAt(i));
            else
            {
                freq2[T.charAt(i)-'a']++;
            }
        }
        for(int i=0;i<S.length();i++)
        {
            if(freq2[S.charAt(i)-'a']>=1)
            {
                for(int j=0;j<freq2[S.charAt(i)-'a'];j++)
                    ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }
}