https://leetcode.com/problems/fibonacci-number/
//Problem no : 509


//recursive Approach
class Solution {
    public int fib(int n) {
        if(n<=1)
            return n;
        return fib(n-1)+fib(n-2);
    }
}


/*
In iterative approach we are indirctly using dynamic programming
what we have to find i-1 and i-2 previous steps
we will store i-1 value in b and i-2 in a
after each iteration we will update a and b value
i.e value of b will be now stored in a
and new b value=previosu a+previos b
*/

class Solution {
    public int fib(int n) {
        if(n<=1)
            return n;
        int a=0;
        int b=1;
        for(int i=2;i<=n;i++)
        {
            b=a+b;
            a=b-a;
        }
        return b;
    }
}
