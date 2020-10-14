https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
//problem no : 762


class Solution {
    boolean prime[];
    int arr[];
    Solution()
    {
        arr=new int[256];
        for(int i=1;i<256;i++)
        {
            arr[i]=arr[i>>1] + (i&1);
        }
        prime=new boolean[33];
        prime[0]=true;
        prime[1]=true;
        for(int i=2;i<=5;i++)
        {
            if(prime[i]==false)
            {
                for(int j=i*i;j<=32;j+=i)
                {
                    prime[j]=true;
                }
            }
        }
    }
    
    int isprime(int n)
    {
        if(prime[n]==false)
            return 1;
        return 0;
    }
    
    public int countPrimeSetBits(int L, int R) {
        int ans=0;
        for(int i=L;i<=R;i++)
        {
            int res=0;
            res+=arr[i & 0xFF];
            res+=arr[(i>>8) & 0xFF];
            res+=arr[(i>>16) & 0xFF];
            res+=arr[(i>>24) & 0xFF];
            ans+=isprime(res);
        }
        return ans;
    }
}



/*
0b10100010100010101100 is the bit wise representation of 665772.
Here 2nd,3rd,5th,7th,11th,13th,17th,19th,23rd and 29th bits are 1 and rest are 0s.
What do all these positions have in common? they are prime numbers
Integer.bitCount() is method to calculate set bits of number;
*/

Java stream:
public int countPrimeSetBits(int L, int R) {
    return IntStream.range(L, R+1).map(i -> 665772 >> Integer.bitCount(i) & 1).sum();
}


Java:
public int countPrimeSetBits(int L, int R) {
    int count = 0;
    while (L <= R)
        count += 665772 >> Integer.bitCount(L++) & 1;
    return count;
}
