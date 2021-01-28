https://practice.geeksforgeeks.org/problems/nth-natural-number/1

Basically If we remove 9 then our number system will not have any 9
which further can be concluded that number system with base 9
Now calculating given decimal number to base 9 number

class Solution {
    long findNth(long N)
    {
        long ans=0;
        long mul=1;
        while(N!=0)
        {
            long dig=N%9;
            N=N/9;
            ans+=(mul*dig);
            mul=mul*10;
        }
        return ans;
    }
}