https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/


public class Solution {
    public String solve(String A) {
        int freq[]=new int[26];
        StringBuilder ans=new StringBuilder();
        int n=A.length();
        int index=0;
        for(int i=0;i<n;i++)
        {
            freq[A.charAt(i)-'a']++;
            while(index<i && freq[A.charAt(index)-'a']>1)
            {
                index++;
            }
            if(freq[A.charAt(index)-'a']==1)
              ans.append(A.charAt(index));
            else
              ans.append('#');
        }
        return ans.toString();
    }
}
