https://leetcode.com/problems/water-bottles/submissions/
//Problem no : 1518


class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=numBottles,rem=0;
        while((numBottles+rem)>=numExchange)
        {
            numBottles=numBottles+rem;
            rem=numBottles%numExchange;
            numBottles=numBottles/numExchange;
            ans=ans+numBottles;
        }
        return ans;
    }
}