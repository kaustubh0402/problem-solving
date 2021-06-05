https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
//Problem no: 1217

/*
hint:
The first move keeps the parity of the element as it is.
The second move changes the parity of the element.
Since the first move is free, if all the numbers have the same parity, the answer would be zero.
Find the minimum cost to make all the numbers have the same parity.
*/

class Solution {
    public int minCostToMoveChips(int[] position) {
        int even=0,odd=0;
        for(int i=0;i<position.length;i++)
        {
            if((position[i] & 1)==0)
                even++;
            else
                odd++;
        }
        return Math.min(even,odd);
    }
}