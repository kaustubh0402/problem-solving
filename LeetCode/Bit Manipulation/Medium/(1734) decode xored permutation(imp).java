https://leetcode.com/problems/decode-xored-permutation/
//Problem no : 1743

/*
Explanation:
First See solution of Decoded Xor Array (Problem no : 1720)
if we found first element of ans then whole array will be found (from 1720)

consider case:
Encoded array : E[] :     [6,5,4,6] 
suppose decoded array:    [x0,x1,x2,x3,x4] 
from given:               x0^x1=6 and x1^x2=5 and x2^x3=4 and x3^x4=6  ...equation(1)

now consider only odd terms in Encoded array i.e. E[1] and E[3]
we can observe that E[1]=5=x1^x2 and E[3]=6=x3^x4   ...see equation 1 if not understood

Now we already know that decoded array consist of numbers from 1 to n (here n=5)
Lets take XOR of all number from 1 to n i.e. all = 1^2^3^4^5          ...equation(2)
Thus we can calculate all by xoring 1 to n number
as XOR is Associative hence all=x0^x1^x2^x3^x4=1^2^3^4^5
[Note that x0,x1,x2,x3,x4 are not in order i.e x0 not necessary to be 1]

Now XORing all value (from equation 1) with odd indexed encoded arrayto get first number
i.e.
all^E[1]^E[3]
(x0^x1^x2^x3^x4) ^(x1^x2) ^(x3^x4) 
Now we will remain with x0 which is starting index


Now Finally we get first number now we can calculate whole array (See solution of problem 1720)

IN SHORT EXPLANATION:
1) calculate XOR from 1 to n
2) calculate XOR from odd indexed from Encoded Array
3) Xor value from step 1 and step 2 to get first element
4) Now same solution as question 1720 i.e. ans[i]=ans[i-1]^encoded[i-1];
*/


class Solution {
    public int[] decode(int[] encoded) {
        int n=encoded.length+1;
        int ans[]=new int[n];
        int all=0;
        int encod=0;
        for(int i=1;i<=n;i++)
            all=all^(i);
        for(int i=1;i<n;i+=2)
            encod=encod^encoded[i];
        int first=all^encod;
        ans[0]=first;
        for(int i=1;i<n;i++)
        {
            ans[i]=ans[i-1]^encoded[i-1];
        }
        return ans;
    }
}

