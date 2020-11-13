https://leetcode.com/problems/palindrome-number/
//Problem no : 9

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int ans=0;
        int dummy=x;
        while(x!=0)
        {
            int digit=x%10;
            ans=10*ans+(digit);
            x=x/10;
        }
        if(ans==dummy)
            return true;
        return false;
    }
}
