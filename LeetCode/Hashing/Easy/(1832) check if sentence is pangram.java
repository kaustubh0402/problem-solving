https://leetcode.com/problems/check-if-the-sentence-is-pangram/
//Problem no : 1832

class Solution {
    public boolean checkIfPangram(String sentence) {
        int n=sentence.length();
        if(n<26)
            return false;
        int count=0;
        boolean freq[]=new boolean[26];
        for(int i=0;i<n;i++)
        {
            char curr=sentence.charAt(i);
            if(!freq[curr-97])
            {
                count++;
                freq[curr-97]=true;
            }
        }
        return count==26;
    }
}