/*https://leetcode.com/problems/buddy-strings/
problem no. 859
Explanation:
Mainly to handle 3 following coditions :
*  If lengths are not equal then return false
*  if first character mismatch found then store char of both string in separate variable lets       
   say tempA for string A and tempB for string B 
   then when next mismatch found we have to check whether
			i) char of A string is equal to tempB ( of string B)
			ii)char of B  string is equal to tempA ( of string A)
   if Both conditions are true and no other mismatch occurs(flag ==2) then return true
*  if both strings are equal( in length as well as value)
   then we have to check whether any repeating char in string A 
   as we swapping of same char in same string will not change string.
*/

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())
            return false;
        int flag=0;
        boolean ans=false;
        char tempA='A',tempB='A';
        char[] freq=new char[26]; 
        for(int i=0;i<A.length();i++)
        {
            freq[A.charAt(i)-97]++;
            if(A.charAt(i)!=B.charAt(i))
            {
                if(A.charAt(i)==tempB && B.charAt(i)==tempA && flag==1)
                {
                   ans=true; 
                }
                flag++;
                tempB=B.charAt(i);
                tempA=A.charAt(i);
            }
        }
        if(ans==true && flag==2)
            return true;
        else if(flag==0)
        {
            for(int i=0;i<26;i++)
            {
                if(freq[i]>=2)
                    return true;
            }
        }
        return false;
    }
}