https://leetcode.com/problems/binary-number-with-alternating-bits/
//Problem no: 693

/*
Explanation:
start from 1 ansd 2 
we want to check either number is within  ....01010101 or ....10101010
so we will right shift two bits and OR with 1 or 2 so 
in iteration
check1                  check2
00000001              00000010
00000101              00001010
00010101              00101010
01010101              10101010

for every iteration we will check whether given number is equal to check1 or check2
*/


class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n==1)
            return true;
        if(n==2)
            return true;
        int check1=1;
        int check2=2;
        for(int i=0;i<15;i++)
        {
            check1=check1<<2|1;
            check2=check2<<2|2;
            if(n==check1 ||  n==check2)
                return true;
        }
        return false;
    }
}



//Second Solution
/*
n & n>>1 will ensure that all bits are alternative
*/
class Solution {
    public boolean hasAlternatingBits(int n) {
        return ((n & (n>>1))==0 && (n & (n>>2))==(n>>2));
    }
}
