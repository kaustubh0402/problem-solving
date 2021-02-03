https://www.geeksforgeeks.org/transform-one-string-to-another-using-minimum-number-of-given-operation/

Given two strings A and B, the task is to convert A to B if possible. 
The only operation allowed is to put any character from A and insert it at front. 
Find if it’s possible to convert the string. 
If yes, then output minimum no. of operations required for transformation.


/*
Example:
GeeksForGeek
ForGeeksGeek

we will start form back 
if both letter are not equal then add 1 to ans 
decrement string A
if Both are equal decrement Both A and B
*/
class Solution
{
    int transfigure (String A, String B)
    {
    	int n=A.length()-1;
    	int m=B.length()-1;
		//Below line checks whether every character in string A is in String B or not
        if(!Arrays.equals(A.chars().sorted().toArray(),B.chars().sorted().toArray()))
          return -1;
    	int ans=0;
    	while(n>=0)
    	{
    	    if(A.charAt(n)!=B.charAt(m))
    	    {
    	        n--;
    	        ans++;
    	    }
    	    else
    	    {
    	        m--;
    	        n--;
    	    }
    	}
    	return ans;
    }
}