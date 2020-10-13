https://leetcode.com/problems/number-of-1-bits/
//problem no : 191

/*
Explanation (Total 3 methoda)
1.  Simple just check whether each bit is set or not using  loop (num>>1)&1
2.   Below method by checking only set bits using n&(n-1) it will unset all bits from LSB
3.   Using look up table (Important for many queries or numbers in one go)
Refer gfg notes
*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0)
        {
            n=n & (n-1);
            res++;
        }
        return res;
    }
}
