//https://leetcode.com/problems/longest-palindrome/
//problem no 409
//My solution 

class Solution {
    public int longestPalindrome(String s) {
        int sum=0;
        int freq[]=new int[59];
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'A']++;
        }
        for(int i=0;i<59;i++)
        {
            if(freq[i]%2!=0)
                sum+=freq[i]-1;
            else
                sum+=freq[i];
        }
        if(sum!=s.length())
            sum++;
        return sum;
    }
}

//Using Hashset only
/*
class Solution {
    public int longestPalindrome(String s) {
        int sum=0;
        HashSet <Character> freq=new HashSet<Character>();
        for(int i=0;i<s.length();i++)
        {
            char current=s.charAt(i);
            if(freq.contains(current))
            {
                sum+=2;
                freq.remove(current);
            }
            else
               freq.add(current);
        }
        
        if(sum!=s.length())
            sum++;
        return sum;
    }
}
*/
