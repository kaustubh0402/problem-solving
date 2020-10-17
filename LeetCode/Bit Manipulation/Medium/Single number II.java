https://leetcode.com/problems/single-number-iii
problem no: 260

/*
Refer gfg notes or single number I for more details

Once again, we need to use XOR to solve this problem. But this time, we need to do it in two passes:

In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result. Find
out an arbitrary set bit (for example, the rightmost set bit).

In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with the aforementinoed bit unset. Two different numbers we need to find must fall into thte two distrinct groups. XOR numbers in each group, we can find a number in either group.
*/


class Solution {
    public int[] singleNumber(int[] nums) {
        int ans[]=new int[2];
        int n=nums.length;
        int xor=0;
        for(int i=0;i<n;i++)
        {
            xor=xor^nums[i];
        }
        int rightMostSetBit= (xor & (~(xor-1)));
        for(int i=0;i<n;i++)
        {
            int curr=nums[i];
            if((curr&rightMostSetBit)==0)
                ans[0]=ans[0]^curr;
            else
                ans[1]=ans[1]^curr;
        }
        return ans;
    }
}
