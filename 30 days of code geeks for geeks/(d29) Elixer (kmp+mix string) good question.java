/*
Flamel is making the Elixir of Life but he is missing a secret ingredient, 
a set of contiguous plants (substring) from the Garden of Eden. 
The garden consists of various plants represented by string S where each letter represents a different plant. 
 But the prophecy has predicted that the correct set of plants required to make the 
 potion will appear in the same contiguous pattern (substring) at the beginning of the forest (prefix), 
 the end of the forest (suffix), and will also be the most frequent sequence present in the entire forest.

Identify the substring of plants required to make the elixir and find out the number of times it appears in the forest. 

Example 1:

Input: S = "ababaaaab"
Output: 3
Explanation: substring "ab" is a prefix, 
a suffix and appears 3 times.

Example 2:

Input: S = "aaaa"
Output: 4
Explanation: substring "aaaa" occurs 1 time, 
substring "aaa" occurs 2 times, substring 
"aa" occurs 3 times, substring "a" occurs 
4 times. All of them are proper prefixes 
and suffixes. But, "a" has the maximum 
frequency.
*/

/*
If use of inbuilt function then passing solution
class Sol
{
    int maxFrequency(String s)
    {
        int n=s.length();
    	StringBuilder patt =new StringBuilder();
    	int i=0;
    	while(i<n)
    	{
    	    patt.append(s.charAt(i));
    	    if(s.endsWith(patt.toString()))
    	       break;
    	    i++;
    	}
    	if(patt.length()==n) 
    	  return 1;
    	return kmp(s,patt.toString());
    }
    
    int kmp(String s,String patt)
    {
        int ans=0;
        int n=s.length();
        int m=patt.length();
        int lps[]=lps(patt);
        int i=0;
        int j=0;
        while(i<n)
        {
            if(s.charAt(i)==patt.charAt(j))
            {
                j++;
                i++;
            }
            if(j==m)
            {
                ans++;
                j=lps[j-1];
            }
            else if(i<n && s.charAt(i)!=patt.charAt(j))
            {
                if(j!=0)
                  j=lps[j-1];
                else
                  i++;
            }
        }
        return ans;
    }
    
    int[] lps(String s) {
        int n=s.length();
        int lps[]=new int[n];
        int len=0;
        lps[0]=0;
        int i=1;
        while(i<n)
        {
            if(s.charAt(i)==s.charAt(len))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else
            {
                if(len!=0)
                {
                    len=lps[len-1];
                }
                else
                {
                    lps[i]=len;
                    i++;
                }
            }
        }
        return lps;
    }
}
*/
class Sol
{
    int maxFrequency(String s)
    {
        int n=s.length();
    	int lps[]=new int[n];
    	lps(s,lps);
    	int index=lps[n-1];
    	StringBuilder patt =new StringBuilder();
    	int i=0;
    	while(i<=index)
    	{
    	    if(s.charAt(i)!=s.charAt(n-1-i))
    	      patt.append(s.charAt(i));
    	    else
    	    {
    	      patt.append(s.charAt(i));
    	      break;
    	    }
    	    i++;
    	}
    	return kmp(s,patt.toString())
    }
    
    int kmp(String s,String patt)
    {
        int ans=0;
        int n=s.length();
        int m=patt.length();
        int lps[]=new int[m];
        lps(patt,lps);
        int i=0;
        int j=0;
        while(i<n)
        {
            if(s.charAt(i)==patt.charAt(j))
            {
                j++;
                i++;
            }
            if(j==m)
            {
                ans++;
                j=lps[j-1];
            }
            else if(i<n && s.charAt(i)!=patt.charAt(j))
            {
                if(j!=0)
                  j=lps[j-1];
                else
                  i++;
            }
        }
        return ans;
    }
    
    void lps(String s,int lps[]) {
        int n=s.length();
        int len=0;
        lps[0]=0;
        int i=1;
        while(i<n)
        {
            if(s.charAt(i)==s.charAt(len))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else
            {
                if(len!=0)
                {
                    len=lps[len-1];
                }
                else
                {
                    i++;
                }
            }
        }
    }
}