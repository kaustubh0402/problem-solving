https://leetcode.com/problems/determine-if-two-strings-are-close/
//Problem no : 1657

/*
Explanation:
From operation 1 We can conclude that if we have same frequency of each character then we will return true;
  As swap opeartion will transform any word to other word of same frequency of each letter
To achieve operation 1 we will use operation 2:
  Two condition for operation 2
  1) if character is present in word1 then it must be in word2 and vice versa
  2) operation 2 allows to swap frequency in general
     so we need equal amount of frequencies irrespective of letters
	 i.e if word1 has frequencies a=3 and b=2
	 and word2 has frequencies a=2 and b=3 then we can swap both
	 In general we have to ensure that frequencies of letter in both words should be same 
*/

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        if(len1!=len2)
            return false;
        int w1[]=new int[26];
        int w2[]=new int[26];
        for(int i=0;i<len1;i++)
        {
            char one=word1.charAt(i);
            char two=word2.charAt(i);
            w1[one-97]++;
            w2[two-97]++;
        }
        for(int i=0;i<26;i++) //Operation 2 condition 1 
        {
            if((w1[i]==0 && w2[i]!=0) || (w1[i]!=0 && w2[i]==0))
                return false;
        }
        Arrays.sort(w1);
        Arrays.sort(w2);
        return Arrays.equals(w1,w2); //Opeartion 2 condition 2
    }
}