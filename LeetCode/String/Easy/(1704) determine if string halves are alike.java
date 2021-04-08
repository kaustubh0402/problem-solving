https://leetcode.com/problems/determine-if-string-halves-are-alike/
//Problem no : 1704

class Solution {
    public boolean halvesAreAlike(String s) {
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(i<n/2)
                ans+=isVowel(c);
            else
                ans-=isVowel(c);
        }
        return ans==0;
    }
    
    int isVowel(char c)
    {
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
            return 1;
        if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
            return 1;
        return 0;
    }
}