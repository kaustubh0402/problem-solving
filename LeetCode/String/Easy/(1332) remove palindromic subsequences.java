https://leetcode.com/problems/remove-palindromic-subsequences/
//Problem no : 1332


/*
If empty sting, return 0;
If palindrome, return 1;
Otherwise, we need at least 2 operation.

We can delete all characters 'a' in the 1st operation,
and then all characters 'b' in the 2nd operation.
So return 2 in this case

*/

class Solution {
    public int removePalindromeSub(String s) {
        int n=s.length();
        if(n==0)
            return 0;
        int i=0;
        int flag=0;
        for(i=0;i<(n-1)/2;i++)
            if(s.charAt(i)!=s.charAt(n-1-i))
                flag=1;
        if(flag==0)
            return 1;
        return 2;
    }
}