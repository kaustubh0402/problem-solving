//https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
//problem no 1347
/*
Explanation:
Using Hashmap Or Frequency Array
Increment if char found in s
Decrement if char found in t
consider either values less than 0
or values greater than 0 
or add all absolute value in frequency array and add divide by 2;
*/
class Solution {
    public int minSteps(String s, String t) {
        int freq[]=new int[26];
        int cnt=0;
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++)
        {
            if(freq[i]>0)
            cnt+=freq[i];
        }
        return cnt;
    }
}