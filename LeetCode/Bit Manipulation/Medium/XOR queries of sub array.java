https://leetcode.com/problems/xor-queries-of-a-subarray
//Problem no: 1310 


/*
Explanation:
we know following properties of XOR:
1. A ^ A =0
2. A ^ 0 =A
3. A^B^C=C^A^B (Associative)
We we use prefix array Tecnique to solve above problem
Here we need some pre computation
We will store Xor of all contiguous subarray starting from index 0 (prefix array)
i.e prefix[2] contain XOR of all elements form arr[0] ...arr[2]
prefix[5] =arr[0] ^arr[1] ^arr[1] ^ arr[2] ^ arr[3] ^arr[4] ^arr[5]
now we have to perform queries considering above array
Let say query is from 2 to 5
now in answer we required arr[2]^arr[3]^arr[4] ^arr[5]           ......eqn(1)
consider following operation:
prefix[5] ^ prefix[2]=(arr[0]^arr[1]^arr[2]^arr[3]^arr[4]^arr[5]) ^ (arr[0]^arr[1]^arr[2])
According to mention above XOR property same elements will be 0
prefix[5] ^ prefix[2]=arr[3] ^arr[4] ^ arr[5]                    .....eqn(2)
Now look our needed answer in eqn 1 and what we got in eqn 2
So we need to just XOR leftpoaition of query in above eqn 2
prefix[5] ^prefix[2] ^arr[2]=eqn(1)   = answre
so form above we can conclude that 
answer= prefix[R] ^prefix[L] ^arr[L]

Note :
We can also do this using O(1) space
But that will change Given array
i.e. we can use given arr[] as prefix array by modifying it

*/


class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int arrayLength=arr.length;
        int queryLength=queries.length;
        int prefix[]=new int[arrayLength];
        int ans[]=new int[queryLength];
        prefix[0]=arr[0];
        for(int index=1;index<arrayLength;index++)
        {
            prefix[index]=prefix[index-1]^arr[index];
        }
        
        for(int index=0;index<queryLength;index++)
        {
            int leftPosition=queries[index][0];
            int rightPosition=queries[index][1];
            ans[index]= prefix[leftPosition] ^ prefix[rightPosition] ^ arr[leftPosition];
        }
        return ans;
    }
}
