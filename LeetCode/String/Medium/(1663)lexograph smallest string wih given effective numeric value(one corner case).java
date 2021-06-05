https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
//problem no : 1663

/*
Approach:
I have consider first all n elemnts as 'a'
Now effective value remaining is k=k-n;
if we want to make any element now to z then we have add 25 to each
z from end willl be k/25;
and one element between a and z will be k%25;
Note : corner case consideration for value 'z' 
*/
/*
Just Handle corner case for n*26 !=k
as it will generate negative index

To avoid above corner case just fill all elemnts with 'a' first
then set k=k-n;
then while k>0
fill min(25,k) from back and set k=k-25;
 
*/
Fill from back
class Solution {
    public String getSmallestString(int n, int k) {
        char s[]=new char[n];
        int last=k-n;
        int lastcount=last/25;
        int beforelast=last%25;
        for(int i=n-1;i>n-1-lastcount;i--)
            s[i]='z';
        if(((n*26))!=k)
            s[n-1-lastcount]=(char)(97+beforelast);
        for(int i=0;i<n-1-lastcount;i++)
            s[i]='a';
        return new String(s);
    }
}

Fill from front
class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder s=new StringBuilder();
        int last=k-n;
        int lastcount=last/25;
        int beforelast=last%25;
        for(int i=0;i<n-1-lastcount;i++)
            s.append('a');
        if(((n*26))!=k)
            s.append((char)(97+beforelast));
        for(int i=n-1;i>n-1-lastcount;i--)
            s.append('z');
        return s.toString();
    }
}
