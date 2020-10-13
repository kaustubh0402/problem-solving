https://leetcode.com/problems/hamming-distance/
//problem no:461 

/*
Explanation:
consider :  0^0=0; 1^1=0
i.e. only we will get set bit in XOR if either bit in numbers is 1 and other is 0
i.e if we XOR given two numbers let say 'ans' then set bit in ans will be our answer as we required different bits in two numbers
Then calculate set bit in 'ans' using brain keriningam's algorithm to find set bit
*/


class Solution {
    public int hammingDistance(int x, int y) {
        int num=x^y;
        int ans=0;
		//brian kernigham algo start
        while(num!=0)
        {
            ans++;
            num=num & (num-1);
        }
        return ans;
    }
}