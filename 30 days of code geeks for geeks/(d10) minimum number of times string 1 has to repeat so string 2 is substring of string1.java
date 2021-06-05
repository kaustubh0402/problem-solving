https://www.geeksforgeeks.org/minimum-number-of-times-a-has-to-be-repeated-such-that-b-is-a-substring-of-it/

/*
Trick:
optimal solution for check whether given string is rotation of other string or not
Given a string s1 and a string s2
(eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)

we will add string s1 two times and check whther other is substring of addition
Return (S1 + S1 ).contains (S2)

Similar concept is used in following question.
*/


static int repeatedStringMatch(String A, String B) 
	{ 
	    int ans=1;
	    String add=A;
	    while(A.length()<B.length())
	    {
	        A+=add;
	        ans++;
	    }
	    if(A.contains(B))
	      return ans;
	    if((A+add).contains(B))
	      return ans+1;
	    return -1;
	} 