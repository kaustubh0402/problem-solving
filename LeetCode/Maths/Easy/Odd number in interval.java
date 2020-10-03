//https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
//problem no 1523

class Solution {
    public int countOdds(int low, int high) {
        int diff=high-low;
        if((diff & 1)!=0)
            return diff/2+1;
        else
            if((low & 1)!=0)
                return diff/2+1;
        return diff/2;
    }
}