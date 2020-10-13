https://leetcode.com/problems/counting-bits/
//problem no : 338

/*
 This technique is look up table (dp)
 refer gfg notes 
*/

class Solution {
    public int[] countBits(int num) {
        int ans[]=new int[num+1];
        for(int i=1;i<=num;i++)
        {
            ans[i]=ans[i>>1]+(i&1);//use bracket to follow bodmass rule
						// alternative : ans[i]=ans[i/2] + i&1
						// i/2 will check for all bits excludeing LSB (last)
						// i&1 check for even or odd ( 1 in LSB)
        }
        return ans;
    }
}
