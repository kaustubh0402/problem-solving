https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
//Problem no : 1414

class Solution {
    public int findMinFibonacciNumbers(int k) {
        if(k<2)
            return k;
        TreeSet<Integer> fib=new TreeSet<Integer>();
        int a=1,b=1;
        fib.add(1);
        while(b<=k)
        {
            b=b+a;
            a=(b-a);
            fib.add(b);
        }
        int ans=0;
        while(k>0)
        {
            int val=fib.floor(k);
            ans++;
            k=k-val;
        }
        return ans;
    }
}


class Solution {
    public int findMinFibonacciNumbers(int k) {
        if(k<2)
            return k;
        int a=1,b=1;
        while(b<=k)
        {
            b=b+a;
            a=(b-a);
        }
        int ans=0;
        while(k!=0)
        {
            if(b<=k)
            {
                k=k-b;
                ans++;
            }
            int temp=a;
            a=b-a;
            b=temp;
        }
        return ans;
    }
}