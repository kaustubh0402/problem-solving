https://leetcode.com/problems/power-of-two/
//Problem no : 231

/*
Explanation:
Here n&(n-1) will unset rightmost bit of n to 0
for power of 2 we will required only 1 set bit in n
so after performing n&(n-1) we should get 0 as answer if n is power of 2 
as only 1 bit will n and that will unset because above operation
*/


class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        return ((n&(n-1))==0);
    }
}



class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0 || n==Integer.MIN_VALUE)
            return false;
        return ((n&(n-1))==0);
    }
}


return n > 0 && Integer.bitCount(n) == 1;



//Recursive
return n > 0 && (n == 1 || (n%2 == 0 && isPowerOfTwo(n/2)));
