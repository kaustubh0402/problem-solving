//https://leetcode.com/problems/valid-palindrome-ii/
//problem no 680
/*
Explanation:
1)Bruteforce - at every deletion check whether string is palindrome or not
2)Greedy Approach
   if we found mismatch char at i in given string the two possibilities of string is palindrome
	 1. string with char i  to n-1-i-1 should be palindrome
	 2. string with char i+1 to n-1-i should be paindrome
test case :"ebcbbececabbacecbbcbe"
*/

class Solution {
    public boolean validPalindrome(String s) {
        int n=s.length();
        for(int i=0;i<n/2;i++)
        {
            if(s.charAt(i)!=s.charAt(n-1-i))
                return ((ispalindrome(s,i+1,n-1-i)) || (ispalindrome(s,i,n-i-2)));
        }
        return true;
    }
    public boolean ispalindrome(String s,int start,int end)
    {
        for(int i=start;i<=(start+end)/2;i++)
            if(s.charAt(i)!=s.charAt(end+start-i))
                return false;
        return true;
    }
}
