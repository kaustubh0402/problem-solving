//https://leetcode.com/problems/valid-palindrome/
/*problem no 125
Explanation :
2 user defined function 
1) isnumalpha - check whether alphabet or numerical
2) casesense- it will return small alphabet chacater to Capital alphabet character i.e. a ->A , b->B ....
   will not affect Capital letters and number
*/
class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        int i=0,j=n-1;
        while(i<=j)
        {
            char ichar=s.charAt(i);
            char jchar=s.charAt(j);
            if(!isnumalpha(ichar))  // check whether char at i is alphanumeric or not 
            {
                i++;
                continue;
            }
            if(!isnumalpha(jchar))   // check whether char at j is alphanumeric or not 
            {
                j--;
                continue;
            }
            if(casesense(ichar)==casesense(jchar)) // if both char at respective pointer equal then increment both pointer
            {
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }
    public boolean isnumalpha(char c)
    {
        if((c>=65 && c<=90) || (c>=97 && c<=122))
            return true;
        else if(c>='0' && c<='9')
            return true;
        return false;
    }
    public char casesense(char c)
    {
        if(c>=97 && c<=123)   // if alphabet is small letter -32 is done to convert it into Capital letter (See ASCII Value)
            return (char)(c-32);
        return c;
    }
}
