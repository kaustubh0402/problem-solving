//https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
//problem no 1374
//if n is odd then all n "aaaaa...a'  here length of a is odd
//if n is even then all n "aaaaa...b" here length of a is odd ,length of b is odd
class Solution {
    public String generateTheString(int n) {
        StringBuffer s=new StringBuffer();
        for(int i=0;i<n-1;i++)
        {
            s.append('a');
        }
        if((n & 1)==0)
            s.append('b');
        else
            s.append('a');
        return s.toString();
    }
}
