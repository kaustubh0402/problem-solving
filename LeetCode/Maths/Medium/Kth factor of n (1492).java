https://leetcode.com/problems/the-kth-factor-of-n/submissions/
//Problem no : 1492

//Brute force:
O(n)
class Solution {
    public int kthFactor(int n, int k) {
        int count=0;
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)
                count++;
            if(count==k)
                return i;
        }
        return -1;
    }
}


//O(sqrt(n)
/*
Brief explanation:
1. Every factor should multiply with another factor to produce n
   i.e. factor always in pair to produce n 
   let a is factor of n then another factor will be n/a
2. We will loop through only up to sqrt(n) i.e i*i<n 
   (Not take less than equal to above to avoid repetition if n is perfect square)
3. if k occurs then simply return i
4. else  if our 2*count<k that is our answer is in other factor i.e i/n
5. now we will start from sqrt(n) till count==k and increse our count if n is divisible by i
6. Else return -1;  
*/
class Solution {
    public int kthFactor(int n, int k) {
        int count=0;
        for(int i=1;i*i<n;i++)
        {
            if(n%i==0)
                count++;
            if(count==k)
                return i;
        }
        if(2*count+1>=k)
        {
            for(int i=(int)Math.sqrt(n);i>=1;i--)
            {
                if(n%i==0)
                    count++;
                if(count==k)
                    return n/i;
            }
        }
        return -1;
    }
}